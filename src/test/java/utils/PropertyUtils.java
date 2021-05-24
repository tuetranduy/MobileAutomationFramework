package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {
    public static PropertyUtils INSTANCE = null;
    private final Properties properties = new Properties();

    private PropertyUtils() {
        this.loadProperties("configuration.properties");
        this.properties.putAll(System.getProperties());
    }

    private static PropertyUtils getInstance() {
        if (PropertyUtils.INSTANCE == null) {
            PropertyUtils.INSTANCE = new PropertyUtils();
        }

        return PropertyUtils.INSTANCE;
    }

    public static String getProperty(final String key) {
        return PropertyUtils.getInstance().properties.getProperty(key);
    }

    /**
     * This method will read any integer property value
     *
     * @param key
     * @param defaultValue
     * @return intValue
     */
    public static int getIntProperty(final String key, final int defaultValue) {
        int intValue;
        final String value = PropertyUtils.getInstance().properties.getProperty(key);

        if (value == null) {
            return defaultValue;
        }

        intValue = Integer.parseInt(value);

        return intValue;
    }

    /**
     * If key couldn't be found then it will return default
     * value
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getProperty(final String key, final String defaultValue) {
        return PropertyUtils.getInstance().properties.getProperty(key, defaultValue);
    }

    public static Properties getProperties() {
        return PropertyUtils.getInstance().properties;
    }

    public void loadProperties(final String path) {
        InputStream inputStream = null;
        try {
            inputStream = ClassLoader.getSystemResourceAsStream(path);
            System.out.println("Properties file path: " + inputStream);

            if (inputStream != null) {
                this.properties.load(inputStream);
            } else {
                throw new UnableToLoadPropertiesException("property file '" + path + "' not found in the classpath");
            }
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
        return;
    }

    class UnableToLoadPropertiesException extends RuntimeException {
        UnableToLoadPropertiesException(final String s) {
            super(s);
        }
    }
}
