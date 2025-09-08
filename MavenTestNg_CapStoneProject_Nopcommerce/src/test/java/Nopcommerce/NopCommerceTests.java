package Nopcommerce;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({Nopcommerce.MyListener.class, Nopcommerce.MyExtentListener.class})
public class NopCommerceTests {

    WebDriver driver;
    WebDriverWait wait;
    String dynamicEmail;
    final String password = "Password123!";
    final String baseUrl = "https://demo.nopcommerce.com/";
    final String excelPath = "C:\\Users\\91830\\Downloads\\login.xlsx";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    @Test(priority = 1)
    public void launchBrowserTest() {
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        Assert.assertTrue(title.contains("nopCommerce"));
    }

    @Test(priority = 2)
    public void registerUserSuccessfully() throws IOException {
        driver.findElement(By.cssSelector("a.ico-register")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));

        ExcelUtils excel = new ExcelUtils();
        dynamicEmail = "user" + System.currentTimeMillis() + "@gmail.com";

        WebElement genderMale = driver.findElement(By.id("gender-male"));
        if (!genderMale.isSelected()) {
            genderMale.click();
        }

        driver.findElement(By.id("FirstName")).clear();
        driver.findElement(By.id("FirstName")).sendKeys("User");

        driver.findElement(By.id("LastName")).clear();
        driver.findElement(By.id("LastName")).sendKeys("Persons");

        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(dynamicEmail);

        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys(password);

        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);

        driver.findElement(By.id("register-button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.result")));
        String resultText = driver.findElement(By.cssSelector("div.result")).getText();
        Assert.assertTrue(resultText.toLowerCase().contains("your registration completed"),
                "Registration not successful. Actual message: " + resultText);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.button-1.register-continue-button"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.ico-logout"))).click();

        try {
            excel.overwriteData(excelPath, "Sheet1", dynamicEmail, password);
        } catch (Exception e) {
            System.err.println("Failed to write credentials to Excel: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Registered with new Email: " + dynamicEmail);
    }

    @Test(priority = 3, dependsOnMethods = {"registerUserSuccessfully"})
    public void loginUserSuccessfully() throws IOException {
        ExcelUtils excel = new ExcelUtils();
        String email = excel.getCellData(excelPath, "Sheet1", 1, 0);

        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

        try {
            Alert myAlert = driver.switchTo().alert();
            System.out.println("Alert found: " + myAlert.getText());
            myAlert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present, continuing...");
        }
    }

    @Test(priority = 4)
    public void addProductToCart() {
        Actions action = new Actions(driver);
        WebElement computersMenu = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        action.moveToElement(computersMenu).perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Add to cart')])[1]"))).click();
    }

    
    @Test(priority = 5)
    public void selectProductFromDropdown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");

        // Explicit wait for dropdown to be visible
        WebElement ramDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product_attribute_2")));

        Select select = new Select(ramDropdown);
        select.selectByVisibleText("8GB [+$60.00]");
    }


    @Test(priority = 6)
    public void selectProductRadioButton() {
        driver.findElement(By.id("product_attribute_3_6")).click();
        WebElement addButton = driver.findElement(By.id("add-to-cart-button-1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addButton);
        addButton.click();
    }

    @Test(priority = 7)
    public void addProductFromProductPage() {
        driver.findElement(By.xpath("//span[@class='cart-qty']")).click();
    }

    
    
//    @Test(priority = 8)
//    public void increaseCartQuantityToTwo() {
//        // Wait until the quantity input is visible
//        WebElement qtyInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.qty-input")));
//
//        // Get current quantity
//        int currentQty = Integer.parseInt(qtyInput.getAttribute("value"));
//        int desiredQty = 2; // Target quantity
//
//        // Click the "+" button enough times to reach desired quantity
//        if (currentQty < desiredQty) {
//            WebElement plusButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.quantity.up")));
//            for (int i = currentQty; i < desiredQty; i++) {
//                plusButton.click();
//                // Small wait to allow UI to update
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        // Optional: Wait until cart input reflects desired quantity
//        wait.until(ExpectedConditions.attributeToBe(By.cssSelector("input.qty-input"), "value", String.valueOf(desiredQty)));
//    }
//
//    @Test(priority = 9)
//    public void openShippingPage() {
//        driver.findElement(By.id("open-estimate-shipping-popup")).click();
//    }
//
//    @Test(priority = 10)
//    public void enterShippingAddress() throws InterruptedException {
//        Select countrySelect = new Select(driver.findElement(By.id("CountryId")));
//        countrySelect.selectByVisibleText("India");
//        driver.findElement(By.id("ZipPostalCode")).sendKeys("505305");
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//div[normalize-space()='Next Day Air']")).click();
//        driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();
//    }
//
//    @Test(priority = 11)
//    public void proceedToCheckout() throws InterruptedException {
//   	 JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,400)", "");
//       driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
//       driver.findElement(By.xpath("//button[@id='checkout']")).click();
//       Thread.sleep(2000);
//   	    JavascriptExecutor js1 = (JavascriptExecutor) driver;
//       js1.executeScript("window.scrollBy(0,-400)", "");
//   }
//
//    @Test(priority = 12)
//    public void clickonDigitalDownloads() throws Exception {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        
//        // Use desktop menu locator
//        WebElement digitalDownloads = wait.until(
//            ExpectedConditions.elementToBeClickable(
//                By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Digital downloads']")
//            )
//        );
//        
//        digitalDownloads.click();
//    }
//
//
//    @Test(priority = 13)
//    public void clickonbooks() {
//       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        
//        // Use desktop menu locator
//        WebElement books = wait.until(
//            ExpectedConditions.elementToBeClickable(
//            		By.xpath("//a[normalize-space()='Books']")
//
//            )
//        );
//        
//        books.click();
//    }
//
//    @AfterClass(alwaysRun = true)
//    public void tearDown() {
//        if(driver != null){
//            driver.quit();
//        }
//    }
}
