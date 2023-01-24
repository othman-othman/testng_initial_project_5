package utilities;

import java.io.FileInputStream;

import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();


    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("Config.Properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}