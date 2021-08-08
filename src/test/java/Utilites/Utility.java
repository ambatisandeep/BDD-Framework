package Utilites;

import StepDefinitions.TestSteps;
import org.openqa.selenium.WebDriver;



import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Utility {

    public static WebDriver driver;

    public static void saveDriver(WebDriver savedDriver){
        driver = savedDriver;
    }

    public static void pageLoadTimeouts(int time) {

        driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

        System.out.println("Pages Loads");

    }


    public static void explictWait(){

    }


    public static void switchTabs() {

        String parentTab = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String childTab : handles) {
            if (!childTab.equalsIgnoreCase(parentTab)) {
                //Switch to the opened tab
                driver.switchTo().window(childTab);
            }

        }
    }





}