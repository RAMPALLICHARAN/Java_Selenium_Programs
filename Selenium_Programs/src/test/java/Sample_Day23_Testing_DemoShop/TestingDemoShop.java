package Sample_Day23_Testing_DemoShop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class TestingDemoShop {
	
	WebDriver driver;
	
	@Parameters({"browserName", "url"})
	
	@BeforeClass
	public void launchWebShop(String browserName, String url) {
		System.out.println("Launching Demo Web Shop.");
//		driver = new ChromeDriver();
		
		switch (browserName) {
			case "Chrome" :
				driver = new ChromeDriver();
				break;
			case "FireFox" :
				driver = new FirefoxDriver();
				break;
			case "Edge" :
				driver = new EdgeDriver();
				break;
			default :
				System.out.println("Browsers Invalid");
				break;
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	
	@Test(priority =1)
	public void logIn() {
		System.out.println("Testing LogIn.");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/login']"))).click();
		driver.findElement(By.id("Email")).sendKeys("marvel01@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("IronMan");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Log in']"))).click();
		
	}
	
	@Test (priority = 3)
	public void GoToComputers() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='/computers'])[1]"))).click();	
	}
	@Test (priority = 4)
	public void GoToDeskTops() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='/desktops'])[4]"))).click();
				}
	@Test (priority = 5)
	public void SelectItem() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement computer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@href='/simple-computer'])[2]")));
		((JavascriptExecutor) driver).executeScript("arguments [0].scrollIntoView(true);",computer);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", computer);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='/simple-computer'])[2]"))).click();
	}
	@Test (priority = 6)
    public void AddToCart() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(By.id("product_attribute_75_5_31_96"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button-75"))).click();
    	
    	
    }
	
	@AfterClass
	public void afterTest() {
		System.out.println("AfterTest is running now ");
		
		if(driver != null) {
			driver.quit();
			System.out.println("Browser is closed");
		}
	}

}



