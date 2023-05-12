package avci.murat.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

private static Properties properties;

   static {
    String path="configuration.properties";
    try {
        FileInputStream fileInputStream=new FileInputStream(path);
        properties =new Properties();
        properties.load(fileInputStream);
        fileInputStream.close();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
   }

   public static String getProperties(String a){
       return properties.getProperty(a);
   }
}
