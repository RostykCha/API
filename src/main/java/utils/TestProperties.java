package utils;

import java.io.InputStream;
import java.util.Properties;

public class TestProperties {

    static private Properties props;

    private static void readProperties() {
        if (props != null) {
            return;
        }

        props = new Properties();

        try (InputStream myIs = TestProperties.class.getResourceAsStream("/environment/maven.properties")) {
            props.load(myIs);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBaseUrl() {
        readProperties();
        return props.getProperty("BASE_URL");
    }





}