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

public class MoneyPage extends EvolveBasePage {

	static Date date = new Date();
	static String logDate = new SimpleDateFormat("yyyyMMddHHmmss").format(date);

	private static final Logger logger = LogManager.getLogger(MoneyPage.class);

	@Rule
	public TestWatcher watcher = Factory.createWatcher();

	public MoneyPage() {
	}

	@Override
	public PlatformQuery trait() {
		return new PlatformQuery().setAndroid(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView"))
				.setiOS(By.id("Login"));
	}

	public MoneyPage creaGruppoSpesa(String groupName) throws InterruptedException {
		logger.info("START REAL TEST : < testCreaGruppoSpesa >");

		logger.info("Scenario ) Test Crea Gruppo Spesa ");
		label("< TEST CREA GRUPPO SPESA STARTED >");

		// step 1 click money
		logger.info("Crea Gruppo Spesa - Step 1 - Tap Btn Money ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/moneyFragment")));
		MobileElement moneyButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/moneyFragment"));
		moneyButton.click();
		label("1) Tapped: 'Btn Money'");

		// step 2 scroll fino a Gruppi di spesa
		logger.info("Crea Gruppo Spesa - Step 2 - Scroll Gruppi di spesa ");
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Gruppi di spesa\").instance(0))");
		label("2) Scroll: 'Btn Crea Gruppo Spesa'");

		// step 3 click Crea un gruppo
		logger.info("Crea Gruppo Spesa - Step 3 - Tap Btn Crea un gruppo ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/floweSharedExpensesCardAddBtn")));
		MobileElement createGroupButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/floweSharedExpensesCardAddBtn"));
		createGroupButton.click();
		label("3) Tapped: 'Btn Crea un gruppo'");

		// step 4 send Nome gruppo
		logger.info("Crea Gruppo Spesa - Step 4 - Send Nome Gruppo " + groupName);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/sharedExpensesCreateNameText")));
		MobileElement groupNameEl = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/sharedExpensesCreateNameText"));
		groupNameEl.sendKeys(groupName);
		label("4) Send: 'Nome gruppo' " + groupName);

		// step 5 click Conferma nome
		logger.info("Crea Gruppo Spesa - Step 5 - Tap Btn Conferma nome ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/sharedExpensesCreateNameBtn")));
		MobileElement groupNameConfirmButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/sharedExpensesCreateNameBtn"));
		groupNameConfirmButton.click();
		label("5) Tapped: 'Btn Conferma nome'");

		// step 6 click icona
		logger.info("Crea Gruppo Spesa - Step 6 - Tap Btn Icona Tipologia ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]")));
		MobileElement iconButton = (MobileElement) driver.findElement(By.id(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]"));
		iconButton.click();
		label("6) Tapped: 'Btn Icona Tipologia'");

		// step 7 click Conferma icona
		logger.info("Crea Gruppo Spesa - Step 7 - Tap Btn Conferma icona ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/topicBtn")));
		MobileElement iconConfirmButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/topicBtn"));
		iconConfirmButton.click();
		label("7) Tapped: 'Btn Conferma icona'");

		// step 8 click Sincronizza Rubrica
		logger.info("Crea Gruppo Spesa - Step 8 - Tap Btn Sincronizza Rubrica ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/sharedExpensesContactsSyncBtn")));
		MobileElement syncContactsButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/sharedExpensesContactsSyncBtn"));
		syncContactsButton.click();
		label("8) Tapped: 'Btn Sincronizza Rubrica'");

		// step 9 click Conferma Sincronizza Rubrica
		logger.info("Crea Gruppo Spesa - Step 9 - Tap Btn Conferma Sincronizza Rubrica ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/btn_dialog_ok")));
		MobileElement confirmSyncContactsButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/btn_dialog_ok"));
		confirmSyncContactsButton.click();
		label("9) Tapped: 'Btn Conferma Sincronizza Rubrica'");

		// step 10 click Consenti Sincronizza Rubrica
		logger.info("Crea Gruppo Spesa - Step 10 - Tap Btn Consenti Sincronizza Rubrica ");
		wait.until(ExpectedConditions
				.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_button")));
		MobileElement allowSyncContactsButton = (MobileElement) driver
				.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
		allowSyncContactsButton.click();
		label("10) Tapped: 'Btn Consenti Sincronizza Rubrica'");

		logger.info("END REAL TEST : < testCreaGruppoSpesa >");

		return this;
	}
}
