package avci.murat.utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBaseUtilities {
    private static Connection connection;

    private static Statement statement;

    private static ResultSet resultSet;

    public static void createDBConnection(String url,String userN,String userP) {
        try {
            connection= DriverManager.getConnection(url,userN,userP);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createDBConnection(){
        String url=ConfigurationReader.getProperties("DataBase.URL");
        String userN=ConfigurationReader.getProperties("DataBase.userName");
        String userP=ConfigurationReader.getProperties("DataBase.userPass");

        try {
            connection=DriverManager.getConnection(url,userN,userP);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void destroy(){
        try {
            if (resultSet!=null) {
                resultSet.close();
                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void executeQuery(String query){
        try {
            statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultSet=statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<List<Object>> getQueryResultsetList(String query){
        executeQuery(query);
        List<List<Object>> result=new ArrayList<>();
        try {
            ResultSetMetaData resultSetMetaData= resultSet.getMetaData();
            while (resultSet.next()){
                List<Object> rowSet= new ArrayList<>();
                int columnCount=resultSetMetaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    rowSet.add(resultSet.getObject(i));
                }
                result.add(rowSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    public static List<Object> getRowList(String query) {
        return getQueryResultsetList(query).get(0);
    }

    public static int getRowCount(){
        int result=0;
        try {
            resultSet.last();
            result=resultSet.getRow();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public static List<Object> getRowList(String query,int row) {
        List<Object> result = null;
        if (getRowCount()<=row) {
            result = getQueryResultsetList(query).get(row);
        }
        return result;
    }

    public static List<Map<String,Object>> getQueryResultsetMapList(String query){
        executeQuery(query);
        List<Map<String,Object>> result=new ArrayList<>();
        try {
            ResultSetMetaData setMetaData= resultSet.getMetaData();
            while (resultSet.next()){
                Map<String,Object> row=new HashMap<>();
                for (int i = 1; i < setMetaData.getColumnCount(); i++) {
                    row.put(setMetaData.getColumnName(i),resultSet.getObject(i));
                }
                result.add(row);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static Map<String, Object> getRowMap(String query) {
        return getQueryResultsetMapList(query).get(0);
    }

    public static List<Object> getColumnData(String query, String column){
        executeQuery(query);
        List<Object> result=new ArrayList<>();
        try {
            while (resultSet.next()){
                result.add(resultSet.getObject(column));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public static Object getCellValue(String query) {
        return getQueryResultsetList(query).get(0).get(0);
    }



}
