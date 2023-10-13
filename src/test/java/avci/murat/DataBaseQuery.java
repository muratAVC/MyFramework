package avci.murat;


import avci.murat.utilities.DataBaseUtilities;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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

@Test
    public static void insertDatainTable() throws SQLException {
    DataBaseUtilities.createDBConnection();
    Faker faker=new Faker();
    int a=100;

    while (a-->0){
        List<Object> list=new ArrayList<>();
        list.add(a);
        list.add(faker.name().firstName());
        list.add(faker.name().lastName());
        list.add(faker.address().streetName());
        list.add(faker.address().city());
        list.add(faker.programmingLanguage().name());
       // list.add(faker.date().birthday());
        //list.add((a%2==0)? "false":"true");
        DataBaseUtilities.insertData(list);
        //System.out.print(a);

    }

    }



}


