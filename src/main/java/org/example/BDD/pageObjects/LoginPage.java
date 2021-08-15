package org.example.BDD.pageObjects;

import org.example.BDD.driverSetup.BrowserSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private WebDriver driver;

    private By accountsHome = By.cssSelector(".nav-right #nav-tools a#nav-link-accountList span.nav-icon.nav-arrow");
    private By homePageSigin = By.cssSelector("#nav-al-signin span.nav-action-inner");
    private By emailId = By.xpath("//*[@id='ap_email']");
    private By continueButton = By.id("continue");
    private By passwordId = By.xpath("//*[@type='password']");
    private By signInSubmitId= By.cssSelector("#auth-signin-button");


    public LoginPage(WebDriver driver){
        this.driver= driver;
    }

    public String getLoginPageTitle(){

        driver.findElement(accountsHome).click();
        return driver.getTitle();
    }

    public void enterUserEmailId(String emailAddress){
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.findElement(emailId).sendKeys(emailAddress);
        driver.findElement(continueButton).click();
    }

    public void enterUserPassword(String password){
        driver.findElement(passwordId).clear();
        driver.findElement(passwordId).sendKeys(password);

    }

    public void clickOnSignIn(){
        driver.findElement(signInSubmitId).click();
    }

    public TodaysDealsPage doLogin(String email, String pass){
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.findElement(accountsHome).click();
        driver.findElement(emailId).sendKeys(email);
        driver.findElement(continueButton).click();
        driver.findElement(passwordId).clear();
        driver.findElement(passwordId).sendKeys(pass);
        driver.findElement(signInSubmitId).click();
        return new TodaysDealsPage(driver);


    }

}
