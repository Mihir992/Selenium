package seleniumPractice;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Day3_ActionsClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chromer.driver","C:\\Users\\admin\\eclipseworkspace\\SeleniumJava\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
				
		//For Double Click and Right Click Event
		// Launch the URL 
		driver.get("https://demoqa.com/buttons"); 
		System.out.println("Demoqa Web Page Displayed"); 
		
		//Maximise browser window 
		driver.manage().window().maximize(); 
		
		//Instantiate Action Class 
		Actions actions = new Actions(driver); 
		
		//Retrieve WebElement to perform double click WebElement
		WebElement btnElement = driver.findElement(By.id("doubleClickBtn")); 
		
		//Double Click the button 
		actions.doubleClick(btnElement).perform(); 
		
		System.out.println("Button is double clicked"); 
		
		//Following code just click on OK button on alert , this differs 
		//depending upon application(under test) specific test case  
		// Accept the Alert  
		driver.switchTo().alert().accept(); 
		System.out.println("Double click Alert Accepted"); 
		
		
		// Launch the URL 
		driver.get("https://demoqa.com/buttons");
		System.out.println("demoqa webpage displayed");
			
			 
		 //Retrieve WebElement to perform right click
		 WebElement btnElement1 = driver.findElement(By.id("rightClickBtn"));
			 
		 //Right Click the button to display Context Menu&nbsp;
		 actions.contextClick(btnElement1).perform();
		 System.out.println("Right click Context Menu displayed");
		  
		// Launch the URL 
		driver.get("https://demoqa.com/droppable/");
		WebElement from = driver.findElement(By.id("draggable"));
		 
		WebElement to = driver.findElement(By.id("droppable"));	 
		//Perform drag and drop
		actions.dragAndDrop(from, to).perform();
			
		//verify text changed in to 'Drop here' box 
		String textTo = to.getText();
		if(textTo.equals("Dropped!")) {
					System.out.println("PASS: Source is dropped to target as expected");
				}else {
					System.out.println("FAIL: Source couldn't be dropped to target as expected");
				}

		
		//Mouse Hover Test Case
		// Launch the URL 
        driver.get("https://demoqa.com/menu/");
        System.out.println("demoqa webpage Displayed");
        driver.manage().window().maximize(); 
		
        WebElement menuOption = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
    	//Mouse hover menuOption 'Main Item 2'
    	actions.moveToElement(menuOption).perform();
    	Thread.sleep(3000);
    	System.out.println("Done Mouse hover on 'Main Item 2' from Menu");
        
    	WebElement submenuOption = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
    	//Mouse hover menuOption 'SUB SUB LIST »'
    	actions.moveToElement(submenuOption).perform();
    	Thread.sleep(3000);
    	System.out.println("Done Mouse hover on 'SUB SUB LIST »' from Menu");
    	
    	WebElement submenuOption1 = driver.findElement(By.xpath("//a[text()='Sub Sub Item 1']"));
    	//Mouse hover menuOption 'Sub Sub Item 1'
    	submenuOption1.click();
    	Thread.sleep(3000);
    	System.out.println("Clicked on 'Sub Sub Item 1' from Menu");
        
    	//For KeyBoardEvents
    	//Navigate to the demo site
        driver.get("https://demoqa.com/text-box");
        
        // Enter the Current Address
        WebElement currentAddress=driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("43 School Lane London EC71 9GO");
        
        // Copy the Current Address
        currentAddress.sendKeys(Keys.CONTROL);
        currentAddress.sendKeys("A");
        currentAddress.sendKeys(Keys.CONTROL);
        currentAddress.sendKeys("C");
        
        //Press the TAB Key to Switch Focus to Permanent Address
        currentAddress.sendKeys(Keys.TAB);
        
        //Paste the Address in the Permanent Address field
        WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys(Keys.CONTROL);
        permanentAddress.sendKeys("V");
        
        //Compare Text of current Address and Permanent Address
        assertEquals(currentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));
        
		 //Close the main window 
		driver.close();
			
		} 
	}
