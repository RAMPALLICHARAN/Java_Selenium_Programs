package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class NopCommerceSteps {

    WebDriver driver;
    WebDriverWait wait;

    public NopCommerceSteps() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ----------------- Launch Browser & Homepage -----------------
    @Given("the user launches the browser")
    public void the_user_launches_the_browser() {
        System.out.println("Browser launched via Hooks.");
    }

    @When("the user opens the NopCommerce homepage")
    public void the_user_opens_the_nop_commerce_homepage() {
        driver.get("https://demo.nopcommerce.com/");
    }

    @Then("the homepage should be displayed")
    public void the_homepage_should_be_displayed() {
        String title = driver.getTitle();
        assertEquals(title, "nopCommerce demo store", "Homepage title mismatch!");
    }

    // ----------------- Login -----------------
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get("https://demo.nopcommerce.com/login");
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        driver.findElement(By.id("Email")).sendKeys("testuser@example.com");
        driver.findElement(By.id("Password")).sendKeys("Test@123");
    }

    @And("clicks the login button")
    public void clicks_the_login_button() {
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("account")));
        String accountText = driver.findElement(By.className("account")).getText();
        assertEquals(accountText, "testuser@example.com", "Login failed!");
    }

    // ----------------- Search Product -----------------
    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        driver.get("https://demo.nopcommerce.com/login");
        driver.findElement(By.id("Email")).sendKeys("testuser@example.com");
        driver.findElement(By.id("Password")).sendKeys("Test@123");
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("account")));
    }

    @When("the user searches for a product")
    public void the_user_searches_for_a_product() {
        driver.findElement(By.id("small-searchterms")).sendKeys("Laptop");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("search results should be displayed")
    public void search_results_should_be_displayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product-item")));
        boolean isProductVisible = driver.findElement(By.className("product-item")).isDisplayed();
        assertEquals(isProductVisible, true, "Search results not displayed!");
    }
}
