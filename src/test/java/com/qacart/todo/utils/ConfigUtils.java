package com.qacart.todo.utils;

import java.util.Properties;

//load the properties ONCE and give specific values
public class ConfigUtils {
    //hold everything from the file
    private static Properties properties;
    //Store one instance
    private static ConfigUtils configUtils;

    //private constructor : load properties file and store it
    //Connects the two classes
    private ConfigUtils() {
        //env variable to run tests from command line without hard coded filepaths
        //in this project , we only have production url ,in other cases we may have test instance, local instance..etc
        String env = System.getProperty("env","production");
        switch (env){
            case "production":
                properties = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/production.properties");
                break;
            default:
                throw new RuntimeException("Environment not found");
        }
    }
    //if object doesnt exist ,create it . if not, resue it
    //So that file load once not everytime
    public static ConfigUtils getInstance(){
        if(configUtils==null){
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }

    //Getting the value of the Url
    public static String getBaseUrl(){
        String prop= properties.getProperty("BaseUrl");
        if(prop!=null) return prop;
        throw new RuntimeException("Could not find BaseUrl property");
    }

    public String getEmail(){
        String prop= properties.getProperty("email");
        if(prop!=null) return prop;
        throw new RuntimeException("Could not find email property");
    }

    public String getPassword(){
        String prop= properties.getProperty("password");
        if(prop!=null) return prop;
        throw new RuntimeException("Could not find password property");
    }
}
