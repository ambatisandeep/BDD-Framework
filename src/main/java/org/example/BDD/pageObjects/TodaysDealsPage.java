package org.example.BDD.pageObjects;

import org.example.BDD.driverSetup.BrowserSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TodaysDealsPage {

    private WebDriver driver;

    private By serchBar = By.id("twotabsearchtextbox");

    private By serchButton = By.id("nav-search-submit-button");

    private By thirdDeal = By.xpath("//*[@class='s-main-slot s-result-list s-search-results sg-row']/div[@data-index='5']");

    public TodaysDealsPage(WebDriver driver){
        this.driver=driver;
    }


    public void searchTodaysDeal(String searchItem){
        BrowserSetup.getDriver().findElement(serchBar).sendKeys(searchItem);
    }




}
