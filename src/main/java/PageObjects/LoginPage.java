package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    private By emailId = By.xpath("//*[@id='ap_email']");
    private By continueButton = By.id("continue");
    private By passwordId = By.id("ap_password");
    private By signInSubmitId= By.cssSelector("#auth-signin-button");


    public LoginPage(WebDriver driver){
        this.driver= driver;
    }


    public String getLoginPageTitle(){

        return driver.getTitle();
    }

    public void enterUserEmailId(String emailAddress){
        driver.findElement(emailId).sendKeys(emailAddress);
        driver.findElement(continueButton).click();
    }

    public void enterUserPassword(String password){
        driver.findElement(passwordId).sendKeys(password);
        System.out.println(driver.findElement(signInSubmitId).getText());
        driver.findElement(continueButton).click();

    }

    public void clickOnSignIn(){
        driver.findElement(signInSubmitId).click();
    }


}
