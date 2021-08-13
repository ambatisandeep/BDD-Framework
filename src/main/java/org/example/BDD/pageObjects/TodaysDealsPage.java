package org.example.BDD.pageObjects;

import org.example.BDD.driverSetup.BrowserSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class TodaysDealsPage {

    private WebDriver driver = BrowserSetup.getDriver();
    private By serchBar = By.id("twotabsearchtextbox");
    private By serchButton = By.id("nav-search-submit-button");
    private By thirdDeal = By.cssSelector(".s-main-slot.s-result-list.s-search-results.sg-row div[data-index='5'] h2 a");
    private By addToCart = By.xpath("//*[@id='twotabsearchtextbox']//following::input[@id='add-to-cart-button']");


    public TodaysDealsPage(WebDriver driver){
        this.driver=driver;
    }


    public void searchTodaysDeal(String searchItem){
        driver.findElement(serchBar).sendKeys(searchItem);
    }

    public void selectTodaysDeal(){
        driver.findElement(serchButton).click();
    }


    public void selectThirdDeal(){
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.findElement(thirdDeal).click();

    }

    public String actualDealSelected(){
        String actualItemText = driver.findElement(thirdDeal).getText();
        return actualItemText;
    }

    public void addToCart(){
        driver.findElement(addToCart).click();
    }



}
