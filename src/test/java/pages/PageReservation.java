package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageReservation {
	
	private WebDriver driver;
	private By titleText;
	private By flightsLink;
	private By passengersDrop;
	private By fromDrop;
	private By toDrop;
	
	
	public PageReservation(WebDriver driver) {
		this.driver = driver;
		flightsLink= By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a");
		titleText = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font");
		passengersDrop = By.name("passCount");
		fromDrop = By.name("fromPort");
		toDrop = By.name("toPort");
		
		
	}
	
	public void assertLogonPage() {
		driver.findElement(flightsLink).click();
		driver.get("https://demo.guru99.com/test/newtours/reservation.php");
		Assert.assertTrue(driver.findElement(titleText).getText().contains("Use our Flight Finder to search for the lowest fare on participating airlines. Once you've booked your flight, don't forget to visit the Mercury Tours Hotel Finder to reserve lodging in your destination city."));
	}
	
	public void selectPassengers(int cant) {
		Duration timeout = Duration.ofSeconds(10);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement cantidadPasajeros = wait.until(ExpectedConditions.presenceOfElementLocated(passengersDrop));
		Select selectPasajeros = new Select(cantidadPasajeros);
		selectPasajeros.selectByVisibleText(Integer.toString(cant));
		
	}
	
	public void selectFrom(int index) {
		Select selectFrom = new Select(driver.findElement(fromDrop));
		selectFrom.selectByIndex(index);
	}
	
	public void selectTo(String city) {
		Select selectTo = new Select(driver.findElement(toDrop));
		selectTo.selectByValue(city);
	}

}
