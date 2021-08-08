package StepDefinitions;
import DriverSetup.BrowserSetup;
import PageObjects.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    private static String pageTitle;

    private LoginPage loginPage = new LoginPage(BrowserSetup.getBrowser());

    @Given("user is on Homepage page")
    public void user_is_on_homepage_page() {

        BrowserSetup.getBrowser().get("https://www.amazon.in/");
        BrowserSetup.getBrowser().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        BrowserSetup.getBrowser().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {

        pageTitle = loginPage.getLoginPageTitle();
        System.out.println("Login page title : " + pageTitle);
    }
    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(pageTitle.contains(expectedTitleName));

    }

    @Given("user is on login page")
    public void user_is_on_login_page() {
        BrowserSetup.getBrowser().get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
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
        BrowserSetup.getBrowser().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        loginPage.enterUserPassword(password);
    }
    @When("user clicks on sign-In button")
    public void user_clicks_on_sign_in_button() {
        System.out.println("Here");
        //loginPage.clickOnSignIn();
    }

}
