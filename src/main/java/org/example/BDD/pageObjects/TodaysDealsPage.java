package org.example.BDD.pageObjects;

import org.example.BDD.driverSetup.BrowserSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class TodaysDealsPage {

    private WebDriver driver = BrowserSetup.getDriver();
    private By serchBar = By.id("twotabsearchtextbox");
    private By serchButton = By.id("nav-search-submit-button");
    private By thirdDeal = By.cssSelector(".s-main-slot.s-result-list.s-search-results.sg-row div[data-index='5'] h2 a span");
    private By addToCart = By.xpath("//*[@id='twotabsearchtextbox']//following::input[@id='add-to-cart-button']");
    private By cartButton = By.cssSelector(".a-box-inner span a#hlb-view-cart-announce");

    public TodaysDealsPage(WebDriver driver){
        this.driver=driver;
    }


    public void searchTodaysDeal(String searchItem){
        driver.findElement(serchBar).sendKeys(searchItem);
    }

    public void selectTodaysDeal(){
        driver.findElement(serchButton).click();
    }



    public String actualDealSelected() {
        String actualItemText = driver.findElement(thirdDeal).getText();
        return actualItemText;
    }



    public void selectThirdDeal(){
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        System.out.println(driver.findElement(thirdDeal).getText());
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(thirdDeal));
        driver.findElement(thirdDeal).click();
     }

    public void addToCart(){
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.findElement(addToCart).click();
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.findElement(cartButton).click();
        System.out.println(driver.getTitle());
    }

}
