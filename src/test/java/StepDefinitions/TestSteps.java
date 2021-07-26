package StepDefinitions;

import PageObject.HomePage;
import Utilites.Utility;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestSteps {

    public static WebDriver driver;

    /**tag Name: @Background
     User login with amazon account **/

    @Given("user launch the browser")
    public void user_launch_the_browser() {
        String path = System.getProperty("user.dir") + File.separator + "Drivers" + File.separator + "chromedriver";
        System.out.println(path);
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        Utility.saveDriver(driver);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @When("user enters  the URL {string}")
    public void user_enters_the_url(String url) {
        Utility.pageLoadTimeouts(10);
        driver.get(url);
    }

    @Then("user enters valid username and password")
    public void user_enters_valid_username_and_password() {

        driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']/following::span[@class='nav-line-2 ']")).click();

        Utility.pageLoadTimeouts(10);

        WebElement eleEmail = driver.findElement(By.xpath("//input[@id='ap_email']"));
        eleEmail.clear();
        eleEmail.click();
        eleEmail.sendKeys("sandeepambati.reddy@gmail.com");

        driver.findElement(By.xpath("//input[@id='continue']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement elePass = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ap_password']")));
        elePass.clear();
        elePass.click();
        elePass.sendKeys("@Zemoso8");
        driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
    }



    /**tag Name: @TodaysDeals
     Selecting Today's Deal, adding items to the cart and getting subtotal items quantity **/


    @Given("user clicks on Today's deals")
    public void user_clicks_on_today_s_deals() throws InterruptedException {

        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[normalize-space()='See all deals']")).click();


    }

    @When("user clicks on the third deal")
    public void user_clicks_on_the_third_deal() throws InterruptedException {

        Utility.pageLoadTimeouts(10);

        //Creating object of an Actions class
        //Actions action = new Actions(driver);

        Thread.sleep(2000);

        WebElement thirdDeal = driver.findElement(By.xpath("(//*[@id='twotabsearchtextbox']//following::a/div/img)[3]"));

        thirdDeal.click();



        //action.moveToElement(thirdDeal).perform();

    }

    @Then("user clicks on the item")
    public void user_clicks_on_the_item() {

        Utility.pageLoadTimeouts(10);

        WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement item = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='twotabsearchtextbox']//following::li/descendant::a/div[@class='a-section octopus-dlp-image-shield'])[2]")));

        System.out.println(item.getText());

        item.click();

    }

    @When("user adds item's to the cart")
    public void user_adds_item_s_to_the_cart() {
        Utility.pageLoadTimeouts(10);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement addCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='twotabsearchtextbox']//following::input[@id='add-to-cart-button']")));
        addCart.click();

    }


    @Then("user verify the quantity in the cart")
    public void user_verify_the_quatinty_in_the_cart() {
        Utility.pageLoadTimeouts(10);

        driver.findElement(By.xpath("//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement totalItems = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='sc-subtotal-label-activecart']")));
        System.out.println(totalItems.getText());


    }

    @And("user close the browser")
    public void user_close_the_browser() {

        driver.quit();

    }


    /**tag Name: @MobileSearxch
    Searching for mobiles **/

    @Given("user enters mobiles in the searchbar")
    public void user_enters_mobiles_in_the_searchbar() {

     WebElement searchBar = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

    searchBar.clear();

    searchBar.sendKeys("Mobiles");

    }
    @When("user click on the search button")
    public void user_click_on_the_search_button() {

        driver.findElement(By.xpath("//*[contains(@id,'nav-search-submit-button')]")).click();

    }
    @Then("user should the last displayed mobile")
    public void user_should_the_last_displayed_mobile() {
        Utility.pageLoadTimeouts(10);
        driver.findElement(By.xpath("(//img[@class='s-image'])[24]")).click();

    }
    @Then("user should get info of the mobile")
    public void user_should_get_info_of_the_mobile() {
        WebElement lastMobile = driver.findElement(By.xpath("(//img[@class='s-image'])[24]"));
        System.out.println(lastMobile.getAttribute("alt"));

    }

    /**tag Name: @PrimeDelivery
     Clicking on Prime Checkbox and getting the delivery status of first displayed Item **/

    @Given("user clicks mobiles button")
    public void user_clicks_mobiles_button() {

        driver.findElement(By.xpath("//a[normalize-space()='Mobiles']")).click();

    }
    @When("user clicks Prime check box")
    public void user_clicks_prime_check_box() {

        Utility.pageLoadTimeouts(10);
        driver.findElement(By.xpath("//*[@class='a-icon a-icon-prime a-icon-medium apb-browse-refinements-icon']/preceding-sibling::div/label/i[@class='a-icon a-icon-checkbox']")).click();

    }

    @Then("user get delivery date of the item")
    public void user_get_delivery_date_of_the_item() throws InterruptedException {

        System.out.println("Here");

        Utility.pageLoadTimeouts(10);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement eleDeliveryDate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@id='twotabsearchtextbox']//following::div/span/child::span[@class='a-text-bold'])[1]")));

        System.out.println(eleDeliveryDate.getText());

        driver.quit();
    }

    /**tag Name: @NAVMenu
     Clicking on NAV and choosing the mobiles **/

    @Given("user clicks on menu button")
    public void user_clicks_on_menu_button() {

        Utility.pageLoadTimeouts(10);
        driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']")).click();

    }
    @When("user selects items by department")
    public void user_selects_items_by_department() {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement items = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[normalize-space()='Mobiles, Computers']")));
        items.click();

    }

    @Then("user clicks all mobile phones")
    public void user_clicks_all_mobile_phones() throws InterruptedException {

        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement mobilesItem = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space()='All Mobile Phones']")));
        mobilesItem.click();
        System.out.println(mobilesItem.getText());

    }

    @And("user returns to main menu")
    public void user_returns_to_main_menu(){
        driver.navigate().back();
        System.out.println(driver.getTitle());
        driver.quit();

    }


    /**tag Name: @PreviousOrders
     Getting the info or past one year orders placed**/

    @Given("user clicks on Returns and Orders button")
    public void user_clicks_on_Returns_and_Orders_button() {

        driver.findElement(By.xpath("//*[@id='navbar']/descendant::a[@id='nav-orders']")).click();
    }

    @Then("user selects last 1 year orders")
    public void user_selects_last_1_year_orders() {

        Utility.pageLoadTimeouts(10);
        Select dropDown = new Select(driver.findElement(By.xpath("//*[@name='orderFilter']")));

        dropDown.selectByIndex(2);

        System.out.println(driver.findElement(By.xpath("//div[@class='a-section a-spacing-top-medium a-text-center']")).getText());

        driver.quit();

    }


    /**tag Name: @AddNewAddress
     Creating a new address **/

    @Given("user clicks on Accounts and Lists")
    public void user_clicks_on_accounts_and_lists() {

        driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']/following::span[@class='nav-line-2 ']")).click();

    }
    @When("user selects your account")
    public void user_selects_your_account() {

        Actions actions = new Actions(driver);

        WebElement menuOption = driver.findElement(By.xpath("//span[@class='nav-text'][normalize-space()='Your Account']"));

        actions.moveToElement(menuOption).click();


    }
    @Then("user selects your addresses")
    public void user_selects_your_addresses() {
        Utility.pageLoadTimeouts(10);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement eleAddress = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='a-container']/descendant::div[@class='ya-card-cell']/a)[4]")));

        eleAddress.click();

    }

    @Then("user clicks on Add address")
    public void user_clicks_on_add_address() {
        Utility.pageLoadTimeouts(10);
        driver.findElement(By.xpath("//div[@id='ya-myab-plus-address-icon']")).click();


    }
    @When("user enters all required fields and clicks Add address")
    public void user_enters_all_required_fields_and_clicks_add_address() {
        Utility.pageLoadTimeouts(10);

        driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressFullName']")).sendKeys("Sanju");

        driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressPhoneNumber']")).sendKeys("9876534265");

        driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressPostalCode']")).sendKeys("520007");

        driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressLine1']")).sendKeys("43-54-234");

        driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressLine2']")).sendKeys("Singinagar");

        driver.findElement(By.xpath("//input[@id='address-ui-widgets-landmark']")).sendKeys("Harani Hospital");

        driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressCity']")).sendKeys("Vijayawada");

        WebElement eleState = driver.findElement(By.xpath("//*[@name='address-ui-widgets-enterAddressStateOrRegion']"));

        Select dropDownState = new Select(eleState);
        dropDownState.selectByValue("ANDHRA PRADESH");


        WebElement eleAddType = driver.findElement(By.xpath("//*[@name='address-ui-widgets-addr-details-address-type-and-business-hours']"));

        Select dropDownAddressType = new Select(eleAddType);
        dropDownAddressType.selectByIndex(1);

        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();

    }
    @When("user verifies new address")
    public void user_verifies_new_address() {

        System.out.println("Need to verify address");

    }
}