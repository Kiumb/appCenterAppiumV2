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
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ArcadiaPage extends EvolveBasePage {

	static Date date = new Date();
	static String logDate = new SimpleDateFormat("yyyyMMddHHmmss").format(date);

	private static final Logger logger = LogManager.getLogger(ArcadiaPage.class);

	@Rule
	public TestWatcher watcher = Factory.createWatcher();

	public ArcadiaPage() {
	}

	@Override
	public PlatformQuery trait() {
		return new PlatformQuery().setAndroid(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView"))
				.setiOS(By.id("Login"));
	}

	public ArcadiaPage testBadge() throws InterruptedException {
		logger.info("START REAL TEST : < testBadge >");

		logger.info("Scenario ) Test Badge ");
		label("< TEST BADGE STARTED >");

		// step 1 click profilo
		logger.info("Test Badge - Step 1 - Tap Btn Profilo ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/profileBox")));
		MobileElement profileButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/profileBox"));
		profileButton.click();
		label("1) Tapped: 'Btn Profilo'");

		// step 2 click arcadia
		logger.info("Test Badge - Step 2 - Tap Btn Arcadia ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/profileTabArcadia")));
		MobileElement arcadiaButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/profileTabArcadia"));
		arcadiaButton.click();
		label("2) Tapped: 'Btn Arcadia'");

		// step 3 scroll fino ad Scoprili Tutti
		logger.info("Test Badge - Step 3 - Scroll Scoprili Tutti ");
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Scoprili tutti\").instance(0))");
		label("3) Scroll: 'Btn Scoprili Tutti'");

		// step 4 click scoprili tutti
		logger.info("Test Badge - Step 4 - Tap Btn Scoprili tutti ");
		wait.until(
				ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/profileArcadiaSectionSeeAllBadges")));
		MobileElement scopriliTuttiButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/profileArcadiaSectionSeeAllBadges"));
		scopriliTuttiButton.click();
		label("4) Tapped: 'Btn Scoprili tutti'");

		// step 5 click first badge
		logger.info("Test Badge - Step 5 - Tap Btn first badge ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.GridLayout/android.view.ViewGroup[1]")));
		MobileElement firstBadgeButton = (MobileElement) driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.GridLayout/android.view.ViewGroup[1]"));
		firstBadgeButton.click();
		label("5) Tapped: 'Btn first badge'");

		// step 6 swipe 1
		logger.info("Test Badge - Step 6 - Swipe 1 ");
		TouchAction tapElement = new TouchAction(driver);

		tapElement.press(new PointOption().point(825, 1025)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
				.moveTo(new PointOption().point(240, 1025)).release().perform();

		label("6) Tapped: Swipe 1 ");

		// step 7 swipe 2
		logger.info("Test Badge - Step 7 - Swipe 2 ");

		tapElement.press(new PointOption().point(825, 1025)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
				.moveTo(new PointOption().point(240, 1025)).release().perform();

		label("7) Tapped: Swipe 2 ");

		// step 8 swipe 3
		logger.info("Test Badge - Step 8 - Swipe 3 ");

		tapElement.press(new PointOption().point(825, 1025)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
				.moveTo(new PointOption().point(240, 1025)).release().perform();

		label("8) Tapped: Swipe 3 ");

		// step 9 swipe 4
		logger.info("Test Badge - Step 9 - Swipe 4 ");

		tapElement.press(new PointOption().point(825, 1025)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
				.moveTo(new PointOption().point(240, 1025)).release().perform();

		label("9) Tapped: Swipe 4 ");

		// step 10 swipe 5
		logger.info("Test Badge - Step 10 - Swipe 5 ");

		tapElement.press(new PointOption().point(825, 1025)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
				.moveTo(new PointOption().point(240, 1025)).release().perform();

		label("10) Tapped: Swipe 5 ");

		// step 11 swipe 6
		logger.info("Test Badge - Step 11 - Swipe 6 ");

		tapElement.press(new PointOption().point(825, 1025)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
				.moveTo(new PointOption().point(240, 1025)).release().perform();

		label("11) Tapped: Swipe 6 ");

		// step 12 click close badge
		logger.info("Test Badge - Step 12 - Tap Btn close badge button ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ImageView[1]")));
		MobileElement closeBadgeButton = (MobileElement) driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ImageView[1]"));
		closeBadgeButton.click();
		label("12) Tapped: 'Btn Close Badge Button'");

		// step 13 click go back from badge
		logger.info("Test Badge - Step 13 - Tap Btn go back from badge button ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.View[1]")));
		MobileElement goBackFromBadgeButton = (MobileElement) driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.View[1]"));
		goBackFromBadgeButton.click();
		label("13) Tapped: 'Btn Go Back From Badge Button'");

		// step 14 click torna Home
		logger.info("Test Badge - Step 14 - Tap Btn Torna Home ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/profileBackIcon")));
		MobileElement tornaHomeButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/profileBackIcon"));
		tornaHomeButton.click();
		label("14) Tapped: 'Btn Torna Home'");

		logger.info("END REAL TEST : < testBadge >");

		return this;
	}
}
