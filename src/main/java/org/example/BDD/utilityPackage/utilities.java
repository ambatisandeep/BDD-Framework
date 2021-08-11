package org.example.BDD.utilityPackage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class utilities {

    static final String screenShotsPath= System.getProperty("user.dir")+ File.separator+"src"+File.separator+"test"+File.separator+"java"
            +File.separator+"screenShots";

    public static void TakeScreenShot(WebDriver driver,String srcFileName){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File(screenShotsPath+File.separator+srcFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
