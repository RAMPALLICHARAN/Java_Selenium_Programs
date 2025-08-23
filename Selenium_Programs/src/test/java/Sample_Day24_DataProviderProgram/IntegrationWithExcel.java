package Sample_Day24_DataProviderProgram;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;





public class IntegrationWithExcel{
	WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)
	@Parameters({"browserName","url"})
	public void launchBrowser(String browserName,String url) {

		switch(browserName) {
			case "Chrome":
				driver = new ChromeDriver();
				break;
			
			case "Edge":
				driver = new EdgeDriver();
				break;
				
			case "FireFox":
				driver = new FirefoxDriver();
				break;
				
			default:
				System.out.println("Browser Invalid");
				break;
		}
		System.out.println("Launching "+browserName+" browser...");
		driver.manage().window().maximize();
	}
	@Test(dataProvider = "credentials" , dataProviderClass = DataProviderExcel.class )
	public void loginUser(String Email, String Password){
		driver.get("https://demowebshop.tricentis.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/login']"))).click();
		driver.findElement(By.id("Email")).sendKeys(Email);
		driver.findElement(By.id("Password")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click(); 
}
	public void tearDown() {
		driver.quit();
	}
}
