package Sample_Day25_ParallelExecutionProgram;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Testing_ParallelExecution {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public WebDriver getDriver() {
        return driver.get();
    }


	
	@Parameters({"browserName","url"})
	@BeforeMethod(alwaysRun = true)
	public void launchBrowser(String browserName,String url) {

		switch(browserName) {
			case "Chrome":
				driver.set(new ChromeDriver());
				break;
			
			case "Edge":
				driver.set(new EdgeDriver());
				break;
				
			case "FireFox":
				driver.set(new FirefoxDriver());
				break;
				
			default:
				System.out.println("Browser Invalid");
				break;
		}
		System.out.println("Launching "+browserName+" browser...");
		getDriver().manage().window().maximize();
		getDriver().get(url);
	}
	
	@Test(priority=1 , groups = {"smoke"}, dataProvider = "credentials")
	public void loginUser(String email, String password) {
		
		System.out.println("Thread ID: " + Thread.currentThread().threadId() + " | Login for Email: " + email);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/login']"))).click();
        getDriver().findElement(By.id("Email")).sendKeys(email);
        getDriver().findElement(By.id("Password")).sendKeys(password);
        getDriver().findElement(By.xpath("//input[@value='Log in']")).click();
        System.out.println("Thread ID: " + Thread.currentThread().threadId() + " | Login successfull for Email: " + email);

//		driver.get("https://demoweb.com");
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/login']"))).click();
//		System.out.println("Thread ID: " + Thread.currentThread().threadId() + " | Email: "+email);
//		driver.findElement(By.id("Email")).sendKeys(email);
//		driver.findElement(By.id("Password")).sendKeys(password);
//		driver.findElement(By.xpath("//input[@value='Log in']")).click();
//		driver.quit();
	}
	
	@Test(priority=2, groups = {"smoke"})
	public void goToElectronics() {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='/electronics'])[1]"))).click();
//		driver.quit();
		
	}
	
//	
//	@Test(priority=3, groups = {"smoke"})
//	public void goToCellPhones() {
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='/cell-phones'])[4]"))).click();
//		
//	}
//	
//	
//	@Test(priority=4, groups = {"smoke"})
//	public void selectingItem() {
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Smartphone"))).click();
////		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Smartphone']"))).click();
////		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='/smartphone'])[2]"))).click();
//		
//	}
//	@Test(priority=5, groups = {"sanity"})
//	public void addToCart() {
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button-43"))).click();
//		
//	}
	
	@DataProvider(name = "credentials", parallel=true)
	public String[][] getData(){
			String[][] data = {
					{"marvel01@gmail.com","IronMan"},
					{"marvel02@gmail.com","IronMan2"},
					{"marvel03@gmail.com","IronMa3"},
					{"marvel04@gmail.com","IronMa3"},
					{"marvel05@gmail.com","IronMa3"},
					{"marvel06@gmail.com","IronMa3"},
					{"marvel07@gmail.com","IronMa3"},
					{"marvel08@gmail.com","IronMa3"},
					{"marvel09@gmail.com","IronMa3"},
					{"marvel10@gmail.com","IronMa3"},
					
			};
			return data;
		}
		
	@AfterMethod
		public void afterTest() throws InterruptedException {
			System.out.println("After test is running successfully");
			if(driver != null) {
				Thread.sleep(5000);
				getDriver().quit();
				System.out.println("Browser closed successfully");
			}
		}
		

}
