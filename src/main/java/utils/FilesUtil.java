package utils;

import org.apache.commons.io.FileUtils;


public class FilesUtil extends FileUtils {

    public static String getFileAsString(String name) {
        return getFile(name).toString();
    }

}
