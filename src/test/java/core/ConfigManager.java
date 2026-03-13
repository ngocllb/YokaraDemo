package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static final String CONFIG_PATH = "config/config.properties";
    private static final Properties PROPERTIES = loadProperties();

    private ConfigManager() {
        // utility class
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream(CONFIG_PATH)) {
            properties.load(fis);
            return properties;
        } catch (IOException e) {
            throw new IllegalStateException(
                    "Cannot load configuration from " + CONFIG_PATH,
                    e
            );
        }
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }

    public static String getRequired(String key) {
        String value = get(key);

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Missing required config key: " + key);
        }

        return value.trim();
    }
}