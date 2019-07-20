package com.automationcalling.commonutil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

    private Utils() {
        throw new IllegalStateException("Utility class");
    }

    public static String returnProperties(String keyName) throws IOException {
        Properties prop = new Properties();
        InputStream input = ClassLoader.class.getResourceAsStream("./globalenvironment.properties");
        prop.load(input);
        return prop.getProperty(keyName);
    }

}
