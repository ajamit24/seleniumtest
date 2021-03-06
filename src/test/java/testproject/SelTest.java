package testproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//File updated on 8th Jul
public class SelTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\work\\rough\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);
	}
	
	@Test
	public void validateAboutPage() throws Exception {
		System.out.println("Opening Browser");
		//Puppet agent machine IP --8th July
		String s="http://18.217.16.65:80";
		
		driver.get(s);
				
		System.out.println("Clicking About us");
		driver.findElement(By.xpath("/html/body/div/header/nav/a[2]")).click();
		Thread.sleep(5000);
		boolean textFound = false;
		if (driver.findElement(By.id("PID-ab2-pg")).getText().startsWith("This is about page")) 
		{
			
			textFound=true;
		}
		AssertJUnit.assertTrue(textFound);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
}

