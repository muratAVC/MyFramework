package avci.murat;


import avci.murat.utilities.DataBaseUtilities;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.Collections;
import java.util.List;

public class DataBaseQuery {


@Test
public static void dataBase() throws SQLException {
    String column="length";
    String table="film";
    String query="SELECT " + column+ " from " + table;
    DataBaseUtilities.createDBConnection();
    DataBaseUtilities.executeQuery(query);
    System.out.println("DataBaseUtilities.getRowCount() = " + DataBaseUtilities.getRowCount());
    List<Object> columnList= DataBaseUtilities.getColumnData(query,column);
    for (Object asd:columnList) {
        System.out.println(asd.toString());
    }

}

@Test
public void  maxOrMinOrAVR() throws SQLException {
    String column="length";
    String table="film";
    String query="SELECT " + column+ " from " + table;
    DataBaseUtilities.createDBConnection();
    DataBaseUtilities.executeQuery(query);
    ResultSet resultSet=DataBaseUtilities.getResultSet();
     //while (resultSet.next()){
       //  System.out.println("resultSet.toString() = " + resultSet.getString(1));
     //}
    System.out.println("DataBaseUtilities.getCellValue(query) = " + DataBaseUtilities.getCellValue(query));
}


}


