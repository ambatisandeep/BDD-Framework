package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfiqReader {

    private Properties prop;

    public Properties init_prop() {
        prop = new Properties();
        try {
            FileInputStream file = new FileInputStream("./src/main/java/Config/confiq.properties");
            try {
                prop.load(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return prop;
    }
 }

