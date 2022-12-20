package ru.passworkDemo.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(PropertiesHelper.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("URL");
    }

    public static String getLogin() {
        return properties.getProperty("login");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }
}
