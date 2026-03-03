package com.qacart.todo.utils;

import java.io.*;
import java.util.Properties;


//This class' job: Go to a file, read it, return key/value pairs
public class PropertiesUtils {
    //receives file path
    public static Properties loadProperties(String filePath) {

        File file = new File(filePath);

        try {
            //open file in java
            InputStream input = new FileInputStream(file);
            //converts file data to key/value pairs
            Properties prop = new Properties();
            prop.load(input);
            //
            input.close();
            return prop;

        }
        catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + filePath);
        }
        catch (IOException e) {
            throw new RuntimeException("Error loading file properties : " + filePath);
        }


    }
}
