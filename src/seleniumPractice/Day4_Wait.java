package seleniumPractice;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day4_Wait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chromer.driver","C:\\Users\\admin\\eclipseworkspace\\SeleniumJava\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
				
		//Maximise browser window 
		driver.manage().window().maximize(); 
		
		//Implicit wait commands - implicitywait,pageLoadTimeout
		//implicit wait - implicity wait - It will wait as per duration second before throwing any error
		//Thread sleep method forcibly wait for seconds as per defined
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.navigate().to("https://www.amazon.in/");
		driver.findElement(By.cssSelector("twotabsearchtextbox")).sendKeys("wrist watch for men");
		driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
		System.out.println("implicitly waited");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
		driver.get("https://www.licindia.in/");
		driver.findElement(By.xpath("//span[contains(text(),'Buy Online']")).click();
		
		//Explicit commands - Webdriver Wait with certain conditions before throwing “ElementNotVisibleException” exception. 
		
		WebElement linkClick = new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Buy Online']"))); 
		linkClick.click();
	
		WebElement objFind = driver.findElement(By.xpath("//span[contains(text(),'Buy Online']"));
		boolean boolClick = new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOf(objFind)); 
		
		//Fluent Wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		WebElement we = wait.until(new Function<WebDriver,WebElement>(){
			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//span[contains(text(),'Buy Online']"));
			}
		});

	}

}
