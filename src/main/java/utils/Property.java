package utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Property {

    Properties property = new Properties();

    public List<String> getPropertyAsList(String key) {
        String names = "";
        String[] splitNames = {};
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/testdata/homepage.properties");
            property.load(fis);
            names = property.getProperty(key);
            splitNames = names.split(",");

        } catch (Exception e) {

        }

        return Arrays.stream(splitNames).collect(Collectors.toList());

    }
}
