package helpers;

import java.io.File;

import org.codehaus.plexus.util.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshoter extends TestWatcher {

		private WebDriver driver;
		
		@Override
			protected void failed(Throwable throwable, Description description) {
			
			    if(driver instanceof TakesScreenshot) {
			    	
					File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					try {
						FileUtils.copyFile(screenshotFile, new File("error_"+description.getMethodName()+".png"));
						
					}catch(Exception e){
						e.printStackTrace();
					}
			    	
			    }

				
			}
		@Override
			protected void finished(Description description) {
	        if (driver != null) {
	            driver.quit();
	        }

			}
		
		 public void setDriver(WebDriver driver) {
		        this.driver = driver;
		    }
					
		

		

	
}
