package com.TryCloud.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    // 1 - Create the object of Properties class
    // We need properties class to use methods coming from class like load(), getProperty("key)
    private static Properties properties = new Properties();

    static {
        try {
             // 2 - Create the object of FileInputStream
            // We need this object to open file as a stream in Java memory
            FileInputStream file = new FileInputStream("configuration.properties");

            // 3 - Load the properties object using FileInputStream object
            // Load
            properties.load(file);

            // close the file after loading
            // if we do not close the file, it will take space from computer memory like Scanner
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyword) {

        return properties.getProperty(keyword);
    }


}
