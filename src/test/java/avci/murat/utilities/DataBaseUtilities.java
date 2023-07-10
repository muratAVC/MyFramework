package avci.murat.utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class DataBaseUtilities {
    private static Connection connection;

    private static Statement statement;

    private static ResultSet resultSet;

    public static void createDBConnection(String url,String userN,String userP) {
        try {
            setConnection(DriverManager.getConnection(url,userN,userP));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createDBConnection(){
        String url=ConfigurationReader.getProperties("DataBase.URL");
        String userN=ConfigurationReader.getProperties("DataBase.userName");
        String userP=ConfigurationReader.getProperties("DataBase.userPass");

        try {
            setConnection(DriverManager.getConnection(url,userN,userP));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void destroy(){
        try {
            if (getResultSet() !=null) {
                getResultSet().close();
                getStatement().close();
                getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void executeQuery(String query){
        try {
            setStatement(getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY));
            setResultSet(getStatement().executeQuery(query));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertData(List<Object> user) {
        try {
            //PreparedStatement statement = connection.prepareStatement(importQuery);
            //statement.setInt(1, (int)user.get(0));
            String id= user.get(0).toString();
            //statement.setString(2, user.get(1).toString());
            String firstName=(String) user.get(1);
            //statement.setString(3, user.get(2).toString());
            String lastName=(String) user.get(2);
            //statement.setString(4,user.get(3).toString());
            String adress=(String) user.get(3);
            //statement.setString(5,user.get(4).toString());
            String city=(String) user.get(4);
            //statement.setString(6,user.get(5).toString());
            String category=(String) user.get(5);
            //statement.executeUpdate();
            String importQuery="INSERT INTO yazar (id_no, first_name, last_name, adress, city, category) VALUES ("+id+", "+firstName+", "+lastName+", "+adress+", "+city+", "+category+")";
            System.out.println(importQuery);
            connection.createStatement().executeUpdate(importQuery);

        }catch (SQLException e){
            e.printStackTrace();
        }




    }


    public static List<List<Object>> getQueryResultsetList(String query){
        executeQuery(query);
        List<List<Object>> result=new ArrayList<>();
        try {
            ResultSetMetaData resultSetMetaData= getResultSet().getMetaData();
            while (getResultSet().next()){
                List<Object> rowSet= new ArrayList<>();
                int columnCount=resultSetMetaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    rowSet.add(getResultSet().getObject(i));
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
            getResultSet().last();
            result= getResultSet().getRow();
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
            ResultSetMetaData setMetaData= getResultSet().getMetaData();
            while (getResultSet().next()){
                Map<String,Object> row=new HashMap<>();
                for (int i = 1; i < setMetaData.getColumnCount(); i++) {
                    row.put(setMetaData.getColumnName(i), getResultSet().getObject(i));
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
            while (getResultSet().next()){
                result.add(getResultSet().getObject(column));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public static Object getCellValue(String query) {
        return getQueryResultsetList(query).get(1).get(0);
    }

    public static List<Object> getColumnName(String query) throws SQLException {
        executeQuery(query);
        List<Object> result=new ArrayList<>();
        IntStream.rangeClosed(1, getResultSet().getMetaData().getColumnCount())
                .mapToObj(i -> {
                    try {
                        return getResultSet().getObject(i);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                })
                .forEach(result::add);
        /*
        ResultSetMetaData setMetaData=resultSet.getMetaData();
        for (int i = 1; i <= setMetaData.getColumnCount(); i++) {
            result.add(resultSet.getObject(i));
        }*/
        return result;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        DataBaseUtilities.connection = connection;
    }

    public static Statement getStatement() {
        return statement;
    }

    public static void setStatement(Statement statement) {
        DataBaseUtilities.statement = statement;
    }

    public static ResultSet getResultSet() {
        return resultSet;
    }

    public static void setResultSet(ResultSet resultSet) {
        DataBaseUtilities.resultSet = resultSet;
    }
}
