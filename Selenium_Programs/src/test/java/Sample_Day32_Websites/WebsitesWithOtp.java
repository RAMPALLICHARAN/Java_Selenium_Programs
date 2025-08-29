package Sample_Day32_Websites;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class WebsitesWithOtp {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void launchBrowser() {
        System.out.println("Launching browser...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void openAmazonHomePage() {
    	//https://www.amazon.in/ap/signin

        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        
    }

    @Test(priority = 2)
    public void loginToAmazon() throws IOException, InterruptedException {
        System.out.println("Reading credentials from file...");

        
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\91830\\Downloads\\loginData.txt"));
        String email = reader.readLine();
        String password = reader.readLine();
        reader.close();

       
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email"))).sendKeys(email);
        driver.findElement(By.id("continue")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password"))).sendKeys(password);
        driver.findElement(By.id("signInSubmit")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 3)
    public void searchForMobiles() throws InterruptedException {
    	Thread.sleep(3000);
    	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobiles");
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 4)
    public void selectInProduct() throws InterruptedException {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600)");
    	driver.findElement(By.xpath("//h2[span[contains(text(), 'iPhone 16 Pro 128 GB')]]")).click();
        Thread.sleep(3000);
        Thread.sleep(3000); // Optional wait for product page
    }

    @Test(priority = 5)
    public void scrollAndClickBuyNow() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600)");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("buy-now-button"))).click();
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Closing browser...");
        if (driver != null) {
            driver.quit();
        }
    }
}
