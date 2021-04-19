package utils;

import org.apache.commons.io.FileUtils;

import java.io.InputStream;
import java.util.Properties;


public class FilesUtil {

    public static String getFileAsString(String name) {
        return FileUtils.getFile(name).toString();
    }

    public static Properties readFilePropertiesFromResources(String filePath) {
        Properties props = new Properties();

        try (InputStream myIs = TestProperties.class.getResourceAsStream(filePath)) {
            props.load(myIs);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return props;
    }


}
