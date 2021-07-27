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

public class FingerPrintModal { 
	
	private static final Logger logger = LogManager.getLogger(FingerPrintModal.class);
	
	
	public static void skip2Finger(AppiumDriver<MobileElement> driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		//label("7.0) Tapped: 'FingerPrint Banner'");
		logger.info("Modale 2 intercettata - skip finger ");

		//step 7 skip finger print
		Thread.sleep(1500);
		//label("7.0) wait 5sec: 'Skip finger print'");		
		wait.until(ExpectedConditions.elementToBeClickable(By
						.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[2]")));	
		//xpath --- /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Button[2]
		logger.info("Scenario) Login nuovo numero - Step 7) skip finger print");
		label("7.1) found: 'Skip finger print'");
		MobileElement skipFingerPrint = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[2]"));
		label("7.2) Tapped: 'Skip finger print'");
		skipFingerPrint.click();
			
	}
	
	public static void skip1Finger(AppiumDriver<MobileElement> driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		//label("7.0) Tapped: 'FingerPrint Banner'");
		logger.info("Modale 1 intercettata - skip finger ");

		//step 7 skip finger print
		Thread.sleep(1500);
		//label("7.0) wait 5sec: 'Skip finger print'");		
		wait.until(ExpectedConditions.elementToBeClickable(By
						.id("bm0.zero.tier2:id/btn_biometric_notnow")));	
		//xpath --- /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Button[2]
		logger.info("Scenario) Login nuovo numero - Step 7) skip finger print");
		label("7.1) found: 'Skip finger print'");
		MobileElement skipFingerPrint = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/btn_biometric_notnow"));
		label("7.2) Tapped: 'Skip finger print'");
		skipFingerPrint.click();
			
	}
	
    public static void label(String label) {
        AppManager.label(label);
    }






}
