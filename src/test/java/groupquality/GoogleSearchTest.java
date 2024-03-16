package groupquality;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
	
	private WebDriver driver;
	
	
	@Before
	public void setUp() {
		
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void testGooglePage() {
		WebElement searchbox = driver.findElement(By.name("q"));
		
		searchbox.clear();
		
		searchbox.sendKeys("quality-stream Introduccion a la Automatización de Pruebas de Software");
		
		searchbox.submit();
		
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		assertEquals("quality-stream Introduccion a la Automatización de Pruebas de Software- Google Search" , driver.getTitle());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
