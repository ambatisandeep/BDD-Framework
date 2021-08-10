package hooks;

import driverSetup.BrowserSetup;
import utilityPackage.ConfiqReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;
public class ApplicationHooks {

    private BrowserSetup browserSetup;
    private WebDriver driver;
    private ConfiqReader confiqReader;
    Properties prop;

    @Before(order = 0)
    public void getProperty(){
        confiqReader = new ConfiqReader();
        prop = confiqReader.init_prop();

    }

    @Before(order = 1)
    public void lauchBrowser(){
        String browserName = prop.getProperty("browser");
        browserSetup = new BrowserSetup();
        driver = browserSetup.setBrowser(browserName);
    }

    @After(order = 1)
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()){
           String screenShotName = scenario.getName().replaceAll(" ", "_");
           byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
           scenario.attach(sourcePath,"image/png",screenShotName);
        }


    }


    @After(order=0)
    public void quitBrowser(){
        driver.quit();
    }


}
