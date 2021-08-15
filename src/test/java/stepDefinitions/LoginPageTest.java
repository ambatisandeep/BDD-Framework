package stepDefinitions;
import org.example.BDD.driverSetup.BrowserSetup;
import org.example.BDD.pageObjects.LoginPage;
import io.cucumber.java.en.*;
import org.example.BDD.utilityPackage.utilities;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    private static String pageTitle;
    private LoginPage loginPage = new LoginPage(BrowserSetup.getDriver());
    private WebDriver driver = BrowserSetup.getDriver();


    @Given("user is on Homepage page")
    public void user_is_on_Homepage_page() {

        driver.get("https://www.amazon.in/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        pageTitle = driver.getTitle();
        System.out.println("Login page title : " + pageTitle);
    }
    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(pageTitle.contains(expectedTitleName));
        utilities.TakeScreenShot("LoginPageTest.png");
    }

    @Given("user is on login page")
    public void user_is_on_login_page() {
       String loginPageTitle = loginPage.getLoginPageTitle();
    }
    @When("user enters emailAddress {string}")
    public void user_enters_email_address(String emailAddress) {
        loginPage.enterUserEmailId(emailAddress);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @When("user enters password {string}")
    public void user_enters_password(String password) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        loginPage.enterUserPassword(password);
        utilities.TakeScreenShot("LoginPagePassword.png");
    }
    @When("user clicks on sign-In button")
    public void user_clicks_on_sign_in_button() {
        try{
            loginPage.clickOnSignIn();
            System.out.println(driver.getTitle());
        }catch (NoSuchElementException e ){
            e.printStackTrace();
            driver.navigate().back();
            loginPage.clickOnSignIn();
        }
    }

}
