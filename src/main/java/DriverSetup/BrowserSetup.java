package DriverSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSetup {

    public WebDriver driver;

    public static ThreadLocal<WebDriver>threadDriver = new ThreadLocal<>();

    public WebDriver setBrowser(String browser){
        System.out.println("Browser value given: " + browser);
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            threadDriver.set(new ChromeDriver());
        }else{
            System.out.println("Initialise new browser type");
        }

        getBrowser().manage().deleteAllCookies();
        getBrowser().manage().window().maximize();
        return getBrowser();
    }

    public static synchronized WebDriver getBrowser(){
        return threadDriver.get();

    }

}
