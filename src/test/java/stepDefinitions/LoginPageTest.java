package stepDefinitions;
import org.example.BDD.driverSetup.BrowserSetup;
import org.example.BDD.pageObjects.LoginPage;
import io.cucumber.java.en.*;
import org.example.BDD.utilityPackage.utilities;
import org.junit.Assert;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    private static String pageTitle;

    private LoginPage loginPage = new LoginPage(BrowserSetup.getDriver());

    @Given("user is on Homepage page")
    public void user_is_on_Homepage_page() {

        BrowserSetup.getDriver().get("https://www.amazon.in/");
        BrowserSetup.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        BrowserSetup.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        pageTitle = BrowserSetup.getDriver().getTitle();
        System.out.println("Login page title : " + pageTitle);
    }
    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(pageTitle.contains(expectedTitleName));
        utilities.TakeScreenShot(BrowserSetup.getDriver(),"LoginPageTest.png");
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
        BrowserSetup.getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        loginPage.enterUserPassword(password);
        utilities.TakeScreenShot(BrowserSetup.getDriver(),"LoginPagePassword.png");
    }
    @When("user clicks on sign-In button")
    public void user_clicks_on_sign_in_button() {
        try{
            loginPage.clickOnSignIn();
            System.out.println(BrowserSetup.getDriver().getTitle());
        }catch (NoSuchElementException e ){
            e.printStackTrace();
            BrowserSetup.getDriver().navigate().back();
            loginPage.clickOnSignIn();
        }
    }

}
