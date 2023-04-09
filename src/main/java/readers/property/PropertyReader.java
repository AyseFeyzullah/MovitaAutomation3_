package readers.property;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    Properties prop = new Properties();
    FileReader fileReader;
    FileWriter fileWriter;
    String file;

    public static PropertyReader propertyReader() {
        return propertyReader("config");
    }

    public static PropertyReader propertyReader(String fileName) {
        return new PropertyReader(fileName);
    }

    private PropertyReader(String fileName) {
        try {
            this.file = "src/test/resources/" + fileName + ".properties";
            FileReader fileReader = new FileReader(file);
            prop.load(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static PropertyReader read() {
        return null;
    }

    public String get(String key) {
        return prop.getProperty(key);
    }


    public void set(String key, String value) {
        prop.setProperty(key, value);
    }


    public void del(String key) {
        prop.remove(key);
    }

    public void store(String comment) {
        try {
            fileWriter = new FileWriter(file);
            prop.store(fileWriter, comment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
