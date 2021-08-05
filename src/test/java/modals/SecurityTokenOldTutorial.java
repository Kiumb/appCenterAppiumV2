package modals;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import global.AppManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.touch.WaitOptions;

public class SecurityTokenOldTutorial { 
	
	private static final Logger logger = LogManager.getLogger(SecurityTokenOldTutorial.class);
	
	
	public static void skipSecurityTutorial(AppiumDriver<MobileElement> driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		logger.info("Skippa tutorial page 1 ");
		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("bm0.zero.tier2:id/dialog_gemalto_tutorial_right_btn")));	
		MobileElement skipBtnTutorial1 = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/dialog_gemalto_tutorial_right_btn"));
		label("7.1) found: 'Skip finger print'");
		skipBtnTutorial1.click();

		logger.info("Skippa tutorial page 2 ");
		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("bm0.zero.tier2:id/dialog_gemalto_tutorial_right_btn")));	
		skipBtnTutorial1 = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/dialog_gemalto_tutorial_right_btn"));
		label("7.1) found: 'Skip finger print'");
		skipBtnTutorial1.click();
		
		logger.info("Skippa tutorial page 3 ");

		//step 7 skip finger print
		Thread.sleep(1500);
		//label("7.0) wait 5sec: 'Skip finger print'");		
		wait.until(ExpectedConditions.elementToBeClickable(By
						.id("bm0.zero.tier2:id/gemalto_tutorial_page_three_enable_btn")));	
		MobileElement skipBtnTutorial3= (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/gemalto_tutorial_page_three_enable_btn"));
		label("7.2) Tapped: 'Skip finger print'");
		skipBtnTutorial3.click();
			
	}
	
	
    public static void label(String label) {
        AppManager.label(label);
    }






}
