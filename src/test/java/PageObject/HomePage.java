package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public  WebDriver driver ;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(id="twotabsearchtextbox")
    @CacheLookup
    WebElement searchBar;

    @FindBy(xpath = "(//*[@type='submit'])[1]")
    @CacheLookup
    WebElement searchButtuon;



}
