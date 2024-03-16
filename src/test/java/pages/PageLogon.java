package pages;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PageLogon {
	private WebDriver driver;
	private By titleText;
	
	public PageLogon(WebDriver driver) {
		this.driver = driver;
		titleText = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3");
		
	}
	
	public void assertLogonPage() {

		Assert.assertTrue(driver.findElement(titleText).getText().contains("REcibido"));
	}

}
