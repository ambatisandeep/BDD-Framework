package stepDefinitions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.example.BDD.driverSetup.BrowserSetup;
import org.example.BDD.pageObjects.LoginPage;
import org.example.BDD.pageObjects.TodaysDealsPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TodaysDealsPageTest {
    private WebDriver driver=BrowserSetup.getDriver();
    private LoginPage loginPage = new LoginPage(BrowserSetup.getDriver());
    private TodaysDealsPage todaysDealsPage;
    private String titleDealsPage;

    @Given("user is already on login page")
    public void user_is_already_on_login_page(DataTable dataTable) {

        List<Map<String,String>> loginCredentials= dataTable.asMaps();
        String email = loginCredentials.get(0).get("emailId");
        String password = loginCredentials.get(0).get("password");
        driver.get("https://www.amazon.in/");
        todaysDealsPage = loginPage.doLogin(email,password);
    }
    @Given("user enters in search bar {string}")
    public void user_enters_in_search_bar(String searchDeals) {
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        todaysDealsPage.searchTodaysDeal(searchDeals);

    }
    @When("user selects today's deals of the day")
    public void user_selects_today_s_deals_of_the_day() {
        todaysDealsPage.selectTodaysDeal();
    }


    @Then("user verifies page title to be {string}")
    public void user_verifies_page_title_to_be(String expectedPageTitle){
        titleDealsPage=driver.getTitle();
        System.out.println(expectedPageTitle);
        System.out.println(titleDealsPage);
        Assert.assertTrue(titleDealsPage.contains(expectedPageTitle));

    }


    @Then("user selects third item from the page")
    public void user_selects_third_item_from_the_page() {
        todaysDealsPage.selectThirdDeal();
        ArrayList<String> tabs = new ArrayList (driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window(tabs.get(1));
    }
    @Then("user add items to the cart")
    public void user_add_items_to_the_cart() {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        todaysDealsPage.addToCart();



    }

}


