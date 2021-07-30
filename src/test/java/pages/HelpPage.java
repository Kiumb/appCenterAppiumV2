package pages;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.microsoft.appcenter.appium.Factory;

import global.EvolveBasePage;
import global.PlatformQuery;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class HelpPage extends EvolveBasePage {

	static Date date = new Date();
	static String logDate = new SimpleDateFormat("yyyyMMddHHmmss").format(date);

	private static final Logger logger = LogManager.getLogger(HelpPage.class);

	@Rule
	public TestWatcher watcher = Factory.createWatcher();

	public HelpPage() {
	}

	@Override
	public PlatformQuery trait() {
		return new PlatformQuery().setAndroid(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView"))
				.setiOS(By.id("Login"));
	}

	public HelpPage chatWithOperator() throws InterruptedException {
		logger.info("START REAL TEST : < chatWithOperator >");

		logger.info("Scenario ) Chat Con Operatore ");
		label("< CHAT CON OPERATORE STARTED >");

		// step 1 click profilo
		logger.info("Chat con operatore - Step 1 - Tap Btn Profilo ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/profileBox")));
		MobileElement profileButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/profileBox"));
		profileButton.click();
		label("1) Tapped: 'Btn Profilo'");

		// step 2 scroll fino ad HELP
		logger.info("Chat con operatore - Step 2 - Scroll Btn Help ");
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Help\").instance(0))");
		label("2) Scroll: 'Btn Help'");

		// step 3 click help button
		logger.info("Chat con operatore - Step 3 - Tap Btn Help ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/profilehelpbtn")));
		MobileElement helpButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/profilehelpbtn"));
		helpButton.click();
		label("3) Tapped: 'Btn Help'");
		
		Thread.sleep(5000);

		// step 4 send Operatore
		logger.info("Chat con operatore - Step 4 - Inserimento 'Operatore\n' ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.widget.EditText")));
		MobileElement chatEl = (MobileElement) driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.widget.EditText"));
		chatEl.click();
		chatEl.sendKeys("Operatore");
		WaitOptions.waitOptions(Duration.ofSeconds(3));
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));

		label("4) Inserted: Inserimento 'Operatore\n' ");
		WaitOptions.waitOptions(Duration.ofSeconds(3));
		driver.hideKeyboard();
		Thread.sleep(5000);

		// step 5 tap coordinate
		logger.info("Chat con operatore - Step 5 - Tap Coordinate ");
		TouchAction tapElement = new TouchAction(driver);

		tapElement.press(new PointOption().point(725, 1875))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
				.moveTo(new PointOption().point(420, 1875))
				.release()
				.perform();
		
		label("5) Tapped: Scroll 1 ");
		
		tapElement.press(new PointOption().point(725, 1875))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
		.moveTo(new PointOption().point(420, 1875))
		.release()
		.perform();

		label("5) Tapped: Scroll 2 ");
		
		tapElement.press(new PointOption().point(725, 1875))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
		.moveTo(new PointOption().point(420, 1875))
		.release()
		.perform();

		label("5) Tapped: Scroll 3 ");
		
		tapElement.press(new PointOption().point(725, 1875))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
		.moveTo(new PointOption().point(420, 1875))
		.release()
		.perform();

		label("5) Tapped: Scroll 4 ");
		
		tapElement.press(new PointOption().point(725, 1875))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
		.moveTo(new PointOption().point(420, 1875))
		.release()
		.perform();

		label("5) Tapped: Scroll 5 ");
		
		tapElement.press(new PointOption().point(725, 1875))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
		.moveTo(new PointOption().point(420, 1875))
		.release()
		.perform();

		label("5) Tapped: Scroll 6 ");
		
		logger.info("Chat con operatore - Step 5 end - Fine Scroll ");
		label("5) Tapped: Scroll end ");

		// step 6 click help Voglio parlare con l'operatore
		logger.info("Chat con operatore - Step 6 - Tap Btn Voglio parlare con l'operatore ");
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
//				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.ListView/android.view.View[4]/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.MenuItem")));
//		MobileElement operatorButton = (MobileElement) driver.findElement(By.xpath(
//				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.ListView/android.view.View[4]/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.MenuItem"));
//		operatorButton.click();
		tapElement.tap(new PointOption().point(550, 1900)).perform();
		label("6) Tapped: 'Btn Voglio parlare con l'operatore'");

		// step 7 click help Voglio parlare con l'operatore conferma
		logger.info("Chat con operatore - Step 7 - Tap Btn Voglio parlare con l'operatore conferma ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.ListView/android.view.View[2]/android.widget.Button")));
		MobileElement confirmOperatorButton = (MobileElement) driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.ListView/android.view.View[2]/android.widget.Button"));
		confirmOperatorButton.click();
		label("7) Tapped: 'Btn Voglio parlare con l'operatore'");
		
		Thread.sleep(5000);

		// step 8 click close button
		logger.info("Chat con operatore - Step 8 - Tap Btn Close Chat ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/toolbarRightCloseBtn")));
		MobileElement closeChatButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/toolbarRightCloseBtn"));
		closeChatButton.click();
		label("8) Tapped: 'Btn Close Chat'");

		// step 9 click torna Home
		logger.info("Chat con operatore - Step 9 - Tap Btn Torna Home ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/profileBackIcon")));
		MobileElement tornaHomeButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/profileBackIcon"));
		tornaHomeButton.click();
		label("9) Tapped: 'Btn Torna Home'");

		logger.info("END REAL TEST : < chatWithOperator >");

		return this;
	}

	/*
	 * 
	 * // step 5.1 scroll destra 1
	 * logger.info("Chat con operatore - Step 5.1 - Scroll destra 1 ");
	 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.ListView/android.view.View[3]/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View"
	 * ))); MobileElement scroll1 = (MobileElement) driver.findElement(By.xpath(
	 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.ListView/android.view.View[3]/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View"
	 * )); scroll1.click(); label("5.1) Tapped: Scroll destra 1 ");
	 * 
	 * // step 5.2 scroll destra 2
	 * logger.info("Chat con operatore - Step 5.2 - Scroll destra 2 ");
	 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.ListView/android.view.View[3]/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView/android.view.View[3]/android.view.View[2]/android.view.View/android.view.View/android.view.View"
	 * ))); MobileElement scroll2 = (MobileElement) driver.findElement(By.xpath(
	 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.ListView/android.view.View[3]/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView/android.view.View[3]/android.view.View[2]/android.view.View/android.view.View/android.view.View"
	 * )); scroll2.click(); label("5.2) Tapped: Scroll destra 2 ");
	 * 
	 * // step 5.3 scroll destra 3
	 * logger.info("Chat con operatore - Step 5.3 - Scroll destra 3 ");
	 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.ListView/android.view.View[4]/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView/android.view.View[3]/android.view.View[2]/android.view.View/android.view.View/android.view.View"
	 * ))); MobileElement scroll3 = (MobileElement) driver.findElement(By.xpath(
	 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.ListView/android.view.View[4]/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView/android.view.View[3]/android.view.View[2]/android.view.View/android.view.View/android.view.View"
	 * )); scroll3.click(); label("5.3) Tapped: Scroll destra 3 ");
	 * 
	 * // step 5.4 scroll destra 4
	 * logger.info("Chat con operatore - Step 5.4 - Scroll destra 4 ");
	 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.ListView/android.view.View[7]/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView/android.view.View[3]/android.view.View[2]/android.view.View/android.view.View/android.view.View"
	 * ))); MobileElement scroll4 = (MobileElement) driver.findElement(By.xpath(
	 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.ListView/android.view.View[7]/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView/android.view.View[3]/android.view.View[2]/android.view.View/android.view.View/android.view.View"
	 * )); scroll4.click(); label("5.4) Tapped: Scroll destra 4 ");
	 * 
	 * // step 5.5 scroll destra 5
	 * logger.info("Chat con operatore - Step 5.5 - Scroll destra 5 ");
	 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.ListView/android.view.View[7]/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView/android.view.View[3]/android.view.View[2]/android.view.View/android.view.View/android.view.View"
	 * ))); MobileElement scroll5 = (MobileElement) driver.findElement(By.xpath(
	 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.ListView/android.view.View[7]/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView/android.view.View[3]/android.view.View[2]/android.view.View/android.view.View/android.view.View"
	 * )); scroll5.click(); label("5.5) Tapped: Scroll destra 5 ");
	 */
}
