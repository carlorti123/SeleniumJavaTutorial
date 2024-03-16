package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.plexus.util.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;

import helpers.Helpers;
import helpers.Screenshoter;
import pages.PageLogin;
import pages.PageLogon;
import pages.PageReservation;

public class tests {
	ArrayList<String> tabs;
	private WebDriver driver;
	  @Rule
	    public Screenshoter customTestWatcher = new Screenshoter();
	
	@Before
	
	public void setUp() {
		//DesiredCapabilities caps = new DesiredCapabilities();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
		JavascriptExecutor javaScriptexecutor = (JavascriptExecutor)driver;
		String googleWindow = "window.open('https://www.google.com/')";
		javaScriptexecutor.executeScript(googleWindow);
		tabs = new ArrayList<String>(driver.getWindowHandles());
		Helpers helper = new Helpers();
		helper.sleepSeconds(4);	
		
	}
	
	@Test
	public void pruebaUno() {
		driver.switchTo().window(tabs.get(1)).navigate().to("https://www.youtube.com/watch?v=pM5jcKwgWes");
		driver.switchTo().window(tabs.get(0));
		PageLogin pagelogin = new PageLogin(driver);
		pagelogin.login("user", "user");
		PageLogon pagelogon = new PageLogon(driver);
		pagelogon.assertLogonPage();
		customTestWatcher.setDriver(driver);
		Helpers helper = new Helpers();
		helper.sleepSeconds(4);	
		
		
			
		
	}
	

	
	@Test
	
	public void reservacion() {
		PageLogin pagelogin = new PageLogin(driver);
		pagelogin.login("user", "user");
		PageReservation pagereservation = new PageReservation(driver);
		pagereservation.assertLogonPage();
		customTestWatcher.setDriver(driver);
		Helpers helper = new Helpers();
		helper.sleepSeconds(4);	
		
	}
	
	@Test
	public void dropdowns() {
		PageLogin pagelogin = new PageLogin(driver);
		pagelogin.login("user", "user");
		PageReservation pagereservation = new PageReservation(driver);
		pagereservation.assertLogonPage();
		pagereservation.selectPassengers(2);
		pagereservation.selectFrom(3);
		pagereservation.selectTo("London");
		customTestWatcher.setDriver(driver);
		
		Helpers helper = new Helpers();
		helper.sleepSeconds(4);	
		
	}
	
	@Test
	public void pruebaCantidadDeCampos() {
		PageLogin pagelogin = new PageLogin(driver);
		pagelogin.verifyFields();
		customTestWatcher.setDriver(driver);
		
	}
	
	/*@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		protected void failed(Throwable throwable, Description description) {
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenshotFile, new File("error_"+description.getMethodName()+".png"));
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		@Override
		protected void finished(Description description) {
			driver.quit();
		}
				
	};*/
	
	

	

	
	

}
