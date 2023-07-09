package seleniumPractice;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Day3_MultipleWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chromer.driver","C:\\Users\\admin\\eclipseworkspace\\SeleniumJava\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
				
		//For New Tab Event
		// Launch the URL 
		driver.get("https://demoqa.com/browser-windows"); 
		System.out.println("Demoqa Web Page Displayed"); 
		
		//Maximise browser window 
		driver.manage().window().maximize(); 
		String parentWindow=driver.getWindowHandle();
		System.out.println("Parent Window URL:" + driver.getCurrentUrl());
		driver.findElement(By.id("tabButton")).click();
		Thread.sleep(5000);
		Set<String> childWindows = driver.getWindowHandles();
		
		/*for(String s: childWindows) {
			System.out.println(s);
			if(!parentWindow.equalsIgnoreCase(s)) {
				driver.switchTo().window(s);
				System.out.println("Child Window url:" + driver.getCurrentUrl());
				driver.close();
			}
		}*/
		
		Iterator<String> it = childWindows.iterator();
		while(it.hasNext()) {
			String chWindow = it.next();
			if(!parentWindow.equalsIgnoreCase(chWindow)) {
				driver.switchTo().window(chWindow);
				System.out.println("Child Window url:" + driver.getCurrentUrl());
				driver.close();
			}
		}
		Thread.sleep(5000);
		driver.switchTo().window(parentWindow);
		System.out.println("Back to parent Window");
		driver.close();
		
		// Open new child window within the main window
        driver.findElement(By.id("windowButton")).click();

        //Get handles of the windows
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + text.getText());
            }
        }
	}

}
