package com.zeebu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find config.properties");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties: " + e.getMessage(), e);
        }
    }

    /**
     * Retrieves the value of the specified property key.
     *
     * @param key The property key.
     * @return The property value.
     */
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value != null) {
            return value;
        } else {
            throw new RuntimeException("Property " + key + " not found in config.properties");
        }
    }

    /**
     * Retrieves the value of the specified property key with a default value.
     *
     * @param key          The property key.
     * @param defaultValue The default value if the key is not found.
     * @return The property value or the default value.
     */
    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
