package seleniumPractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumCode {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chromer.driver","C:\\Users\\admin\\eclipseworkspace\\SeleniumJava\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//launch URL
		driver.get("https://www.google.com");
		driver.navigate().to("https://demoqa.com/login");
		
		String actTitle = driver.getTitle();
		String expTitle ="DEMOQA";
		
		if(actTitle.equalsIgnoreCase(expTitle)) {
			System.out.println("Title matched");
		}else {
			System.out.println("Title not matched");
		}
		
		//get curretn url
		System.out.println("Current url is "+ driver.getCurrentUrl());
				
		
		WebElement objUserID = driver.findElement(By.xpath("//input[@id='userName']"));
		objUserID.sendKeys("test123");
		Thread.sleep(5000);
		driver.findElement(By.id("password")).sendKeys("pass@123");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		if(driver.findElement(By.xpath("//p[contains(text(),'Invalid')]")).isDisplayed()){
			System.out.println("Wrong credential");
		}
		
	}
}
