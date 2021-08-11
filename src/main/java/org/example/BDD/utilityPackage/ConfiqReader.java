package org.example.BDD.utilityPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfiqReader {

    final String filePath = System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+File.separator+"java"
            +File.separator+"org"+File.separator+"example"+File.separator+"BDD"+
            File.separator+"confiq"+File.separator+"confiq.properties";
    private Properties prop;

    public Properties init_prop() {
        prop = new Properties();
        try {
            FileInputStream file = new FileInputStream(filePath);
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

