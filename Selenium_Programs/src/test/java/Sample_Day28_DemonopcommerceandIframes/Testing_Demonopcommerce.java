package Sample_Day28_DemonopcommerceandIframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testing_Demonopcommerce {
	WebDriver driver;
	@BeforeTest
	public void beforeTest() {
		System.out.println("The Before is running now");
		}
	@BeforeClass
	public void beforeClass() {
		System.out.println("Launching the Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void login() {
		driver.get("https://admin-demo.nopcommerce.com");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='Email']"))).clear();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("admin@yourstore.com");
		driver.findElement(By.xpath("//input[@id='Password']")).clear();
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("admin");
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
		
		
	}
}
