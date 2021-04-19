package utils;

import java.util.Properties;

public class TestProperties {
    private static final String filePath = "/environment/maven.properties";
    private static TestProperties instance;
    private Properties props;

    TestProperties() {
        readProperties();
    }

    public static TestProperties getMavenProperties() {
        if (instance == null) {
            instance = new TestProperties();
        }
        return instance;
    }

    private void readProperties() {
        if (props == null) {
            props = FilesUtil.readFilePropertiesFromResources(filePath);
        }
    }

    public String getBaseUrl() {
        return props.getProperty("BASE_URL");
    }


}