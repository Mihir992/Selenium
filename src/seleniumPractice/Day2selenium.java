package seleniumPractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;


public class Day2selenium {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chromer.driver","C:\\Users\\admin\\eclipseworkspace\\SeleniumJava\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//For Frame
		driver.navigate().to("https://demoqa.com/frames");
		Thread.sleep(5000);
		System.out.println(driver.switchTo().frame("frame1").findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
		driver.switchTo().defaultContent();
		System.out.println(driver.switchTo().frame("frame2").findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
		
		//For Nested IFrame
		driver.navigate().to("https://demoqa.com/nestedframes");
		driver.switchTo().frame("frame1").switchTo().frame(0).findElement(By.xpath("/html/body/p")).getText();
		
		
		
		//For Radiobutton
		/*driver.navigate().to("https://demoqa.com/radio-button");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[@for='impressiveRadio']")).click();
		if(driver.findElement(By.xpath("//label[@for='impressiveRadio']")).isSelected()) {
			System.out.println("Selected");
		}else {
			System.out.println("Not Selected");
		}*/
		
		
		
		//For Alert
		/*driver.navigate().to("https://demoqa.com/alerts");
		//Thread.sleep(5000);
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(1000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(3000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		
		driver.findElement(By.id("promptButton")).click();
		Thread.sleep(1000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys("Message");
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();*/
		
		
		
		//For Webtable
		driver.navigate().to("https://demoqa.com/webtables");
		Thread.sleep(5000);
		WebElement objTable = driver.findElement(By.className("rt-table"));
		List<WebElement> objRows=objTable.findElements(By.className("rt-tr-group"));
		for(int i=0;i<objRows.size();i++) {
			List<WebElement> objCols = objRows.get(i).findElements(By.className("rt-td"));
			for(int j=0;j<objCols.size();j++) {
				System.out.println("Cell value in row " + i + " and column " + j + " is:" + objCols.get(j).getText());
				//objCols.get(j).findElements(By.id("edit-record-1")).click();
			
			}
		}
		
		driver.findElement(By.id("edit-record-1")).click();
		//driver.findElement(By.id("registration-form-modal"));
		
		//driver.navigate().to("https://demoqa.com/select-menu");
		//Thread.sleep(5000);
		//For Select One Drodpdown Style
		//driver.findElement(By.xpath("div[text()='Select Title']")).click();
		//Thread.sleep(1000);
		//driver.findElement(By.xpath("div[text()='Mr.')")).click();
		
		
		//Select drpdwnColor = new Select(driver.findElement(By.id("oldSelectMenu")));
		//drpdwnColor.selectByIndex(2);
		//Thread.sleep(1000);
		//drpdwnColor.selectByValue("6");
		//Thread.sleep(1000);
		//drpdwnColor.selectByVisibleText("Aqua");
		
		//List<WebElement> lstcolor = drpdwnColor.getOptions();
		//for(int i=0;i<lstcolor.size();i++) {
			//drpdwnColor.selectByIndex(i);
			//Thread.sleep(1000);
			
		//}
		
		//For Standard Multi-Select
		//Select drpdwnCars = new Select(driver.findElement(By.id("cars")));
		
		//if(drpdwnCars.isMultiple()) {
			//drpdwnCars.selectByIndex(0);
			//Thread.sleep(1000);
			//drpdwnCars.selectByValue("saab");
			//Thread.sleep(1000);
			//drpdwnCars.selectByVisibleText("Audi");
			//List<WebElement> allSelectOptions=drpdwnCars.getAllSelectedOptions();
			//for(WebElement w:allSelectOptions) {
				//System.out.println(w.getText());
			//}
		//}
		driver.close();
	}
}