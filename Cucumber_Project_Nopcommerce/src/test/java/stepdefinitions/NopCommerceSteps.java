package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import java.time.Duration;

public class NopCommerceSteps {

    WebDriver driver;
    WebDriverWait wait;

    // ----------------- Launch Browser & Homepage -----------------
    @Given("the user launches the browser")
    public void the_user_launches_the_browser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @When("the user opens the nopCommerce homepage")
    public void the_user_opens_the_nopcommerce_homepage() {
        driver.get("https://demo.nopcommerce.com/");
    }

    @Then("the page title should contain {string}")
    public void the_page_title_should_contain(String title) {
        wait.until(ExpectedConditions.titleContains(title));
    }

    // ----------------- Register -----------------
    @Given("the user navigates to the register page")
    public void the_user_navigates_to_the_register_page() {
        driver.findElement(By.className("ico-register")).click();
    }

    @When("the user enters valid registration details")
    public void the_user_enters_valid_registration_details() {
        driver.findElement(By.id("FirstName")).sendKeys("Test");
        driver.findElement(By.id("LastName")).sendKeys("User");
        driver.findElement(By.id("Email")).sendKeys("testuser" + System.currentTimeMillis() + "@mail.com");
        driver.findElement(By.id("Password")).sendKeys("Test@1234");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Test@1234");
        driver.findElement(By.id("register-button")).click();
    }

    @Then("the user should be registered successfully")
    public void the_user_should_be_registered_successfully() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("result")));
    }

    // ----------------- Login -----------------
    @Given("the user navigates to the login page")
    public void the_user_navigates_to_the_login_page() {
        driver.findElement(By.className("ico-login")).click();
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        driver.findElement(By.id("Email")).sendKeys("testuser@mail.com"); // use registered email
        driver.findElement(By.id("Password")).sendKeys("Test@1234");
        driver.findElement(By.cssSelector("button.login-button")).click();
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ico-logout")));
    }

    // ----------------- Add product -----------------
    @Given("the user navigates to the Computers -> Desktops section")
    public void the_user_navigates_to_the_computers_desktops_section() {
        driver.findElement(By.linkText("Computers")).click();
        driver.findElement(By.linkText("Desktops")).click();
    }

    @When("the user adds the first product to the cart")
    public void the_user_adds_the_first_product_to_the_cart() {
        driver.findElement(By.cssSelector(".product-box-add-to-cart-button")).click();
    }

    @Then("the product should be added successfully")
    public void the_product_should_be_added_successfully() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bar-notification")));
    }

    // ----------------- Product attributes -----------------
    @When("the user selects RAM from the dropdown")
    public void the_user_selects_ram_from_the_dropdown() {
        WebElement ramDropdown = driver.findElement(By.id("product_attribute_2")); // Example ID
        Select select = new Select(ramDropdown);
        select.selectByIndex(1); // Select 2 GB
    }

    @When("the user selects HDD using radio button")
    public void the_user_selects_hdd_using_radio_button() {
        WebElement hddRadio = driver.findElement(By.id("product_attribute_3_6")); // Example ID for 320 GB
        hddRadio.click();
    }

    @Then("the user adds the configured product to the cart")
    public void the_user_adds_the_configured_product_to_the_cart() {
        driver.findElement(By.id("add-to-cart-button-1")).click();
    }

    // ----------------- Shopping cart -----------------
    @When("the user opens the shopping cart")
    public void the_user_opens_the_shopping_cart() {
        driver.findElement(By.className("cart-label")).click();
    }

    @Then("the cart page should be displayed")
    public void the_cart_page_should_be_displayed() {
        wait.until(ExpectedConditions.titleContains("Shopping Cart"));
    }

    @Given("the user is on the cart page")
    public void the_user_is_on_the_cart_page() {
        driver.findElement(By.className("cart-label")).click();
    }

    @When("the user increases quantity to {int}")
    public void the_user_increases_quantity_to(Integer qty) {
        WebElement quantity = driver.findElement(By.className("qty-input"));
        quantity.clear();
        quantity.sendKeys(qty.toString());
        driver.findElement(By.name("updatecart")).click();
    }

    @Then("the cart should reflect quantity {int}")
    public void the_cart_should_reflect_quantity(Integer qty) {
        WebElement quantity = driver.findElement(By.className("qty-input"));
        assert quantity.getAttribute("value").equals(qty.toString());
    }

    // ----------------- Shipping -----------------
    @When("the user clicks on Estimate Shipping")
    public void the_user_clicks_on_estimate_shipping() {
        driver.findElement(By.id("open-estimate-shipping-popup")).click();
    }

    @Then("the shipping popup should be displayed")
    public void the_shipping_popup_should_be_displayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estimate-shipping-popup")));
    }

    @When("the user selects country {string} and enters postal code")
    public void the_user_selects_country_and_enters_postal_code(String country) {
        Select select = new Select(driver.findElement(By.id("CountryId")));
        select.selectByVisibleText(country);
        driver.findElement(By.id("ZipPostalCode")).sendKeys("500001");
    }

    @When("chooses shipping method {string}")
    public void chooses_shipping_method(String method) {
        if (method.equals("Next Day Air")) {
            driver.findElement(By.id("shippingoption_1")).click();
        }
    }

    @Then("the shipping details should be applied")
    public void the_shipping_details_should_be_applied() {
        driver.findElement(By.cssSelector("button[name='applyshipping']")).click();
    }

    // ----------------- Checkout -----------------
    @Given("the user accepts the terms of service")
    public void the_user_accepts_the_terms_of_service() {
        driver.findElement(By.id("termsofservice")).click();
    }

    @When("the user clicks on checkout")
    public void the_user_clicks_on_checkout() {
        driver.findElement(By.id("checkout")).click();
    }

    @Then("the checkout page should be displayed")
    public void the_checkout_page_should_be_displayed() {
        wait.until(ExpectedConditions.titleContains("Checkout"));
    }

    // ----------------- Navigation -----------------
    @When("the user clicks on Digital Downloads")
    public void the_user_clicks_on_digital_downloads() {
        driver.findElement(By.linkText("Digital downloads")).click();
    }

    @Then("the Digital Downloads page should open")
    public void the_digital_downloads_page_should_open() {
        wait.until(ExpectedConditions.titleContains("Digital downloads"));
    }

    @When("the user clicks on Books")
    public void the_user_clicks_on_books() {
        driver.findElement(By.linkText("Books")).click();
    }

    @Then("the Books page should open")
    public void the_books_page_should_open() {
        wait.until(ExpectedConditions.titleContains("Books"));
    }
}
