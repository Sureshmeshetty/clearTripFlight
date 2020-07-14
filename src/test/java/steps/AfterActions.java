package steps;


import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.clearTrip.utils.BaseClasss;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class AfterActions {
	static Logger logger = Logger.getLogger(AfterActions.class);

    @After
    public static void tearDown(Scenario scenario) {
    	
    	WebDriver driver=BaseClasss.getDriver();
    	logger.info("Is Scenarios Failed: "+scenario.isFailed());
    	 if (scenario.isFailed()) {
             byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
             scenario.embed(screenshotBytes, "image/png");
         }
    	 BaseClasss.tearDown();
    }
}
