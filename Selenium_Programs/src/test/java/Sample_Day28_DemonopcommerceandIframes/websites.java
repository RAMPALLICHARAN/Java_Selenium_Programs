package Sample_Day28_DemonopcommerceandIframes;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.Scanner;

public class websites {

    @Test
    public void loginWithOtp() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        WebElement emailInput = driver.findElement(By.id("ap_email"));

       
        emailInput.sendKeys("usedfortestingteam04@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("IronMan@123");
        driver.findElement(By.id("signInSubmit")).click();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobiles");
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.findElement(By.xpath("//h2/span[contains(text(),'Infinix')]")).click();
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600)"); 
        driver.findElement(By.id("buy-now-button")).click();
        
        
        
        
//        driver.findElement(By.id("ap_email")).sendKeys("usedfortestingteam04@gmail.com");
//        driver.findElement(By.id("sendOtpBtn")).click();
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter OTP from SMS/Email: ");
//        String otp = scanner.nextLine();
//
//        driver.findElement(By.id("otpInput")).sendKeys(otp);
//        driver.findElement(By.id("verifyOtp")).click();
//
//        System.out.println("Logged in successfully");
//        driver.quit();
    }
}


