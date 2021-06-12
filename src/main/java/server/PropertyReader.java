package server;

import java.io.*;
import java.util.Properties;

public class PropertyReader {

    public String getPropertyValue(String propertyName) {

        String propertyValue = "";
        Properties properties = new Properties();
        try(FileInputStream input = new FileInputStream("D:/Temp4/src/main/resources/application.properties")){
            properties.load(input);
            propertyValue = properties.getProperty(propertyName);
        } catch(IOException e){
            System.out.println(e);
        }
        return propertyValue;
    }
}
