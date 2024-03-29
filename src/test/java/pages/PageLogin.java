package pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import helpers.Helpers;

public class PageLogin {
	private WebDriver driver;
	private By userField; 
	private By passwordField;
	private By loginButton;
	private By fields;
	
	public PageLogin(WebDriver driver) {
		this.driver = driver;
		userField= By.name("userName");
		passwordField = By.name("password");
		loginButton = By.name("submit");
		fields = By.tagName("input");
	}
	
	public void login(String user, String pass) {
		driver.findElement(userField).sendKeys(user);
		driver.findElement(passwordField).sendKeys(pass);
		driver.findElement(loginButton).click();
		File myScreenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(myScreenshot, new File("C:\\Users\\Hp\\Documents\\Errores\\Error.png"));
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Helpers helper = new Helpers();
		//helper.sleepSeconds(4);	
	}
	
	public void capturaDeFalla(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			File myScreenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(myScreenshot, new File("C:\\Users\\Hp\\Documents\\Errores\\Error.png"));
				
			}catch(IOException e) {
				
				e.printStackTrace();
				
			}
	}
	}
	
	public void verifyFields() {
		List<WebElement> loginFields = driver.findElements(fields);
		System.out.println(loginFields.size());
		Assert.assertTrue(loginFields.size()== 4);
	}

}
