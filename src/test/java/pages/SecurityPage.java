package pages;

import java.text.SimpleDateFormat;
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
import io.appium.java_client.MobileElement;

public class SecurityPage extends EvolveBasePage {

	static Date date = new Date();
	static String logDate = new SimpleDateFormat("yyyyMMddHHmmss").format(date);

	private static final Logger logger = LogManager.getLogger(SecurityPage.class);

	@Rule
	public TestWatcher watcher = Factory.createWatcher();

	public SecurityPage() {
	}

	@Override
	public PlatformQuery trait() {
		return new PlatformQuery().setAndroid(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView"))
				.setiOS(By.id("Login"));
	}

	public SecurityPage changeSecurityToken(String passCode, String securityToken) throws InterruptedException {
		logger.info("START REAL TEST : < changeSecurityToken >");

		logger.info("Scenario ) Cambio Security Token ");
		label("< CAMBIO SECURITY TOKEN STARTED >");

		// step 1 click profilo
		logger.info("Security Token - Step 1 - Tap Btn Profilo ");
		label("1) Tapped: 'Btn Profilo'");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/profileBox")));
		MobileElement profileButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/profileBox"));
		profileButton.click();

		// step 2 click ingranaggio impostazioni
		logger.info("Security Token - Step 2 - Tap Btn Impostazioni ");
		label("2) Tapped: 'Btn Impostazioni'");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/profileRightToolbarIcon")));
		MobileElement settingButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/profileRightToolbarIcon"));
		settingButton.click();

		// step 3 click passcode & security token
		logger.info("Security Token - Step 3 - Tap Passcode & Security Token ");
		label("3) Tapped: 'Btn SecuritySection'");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/android.view.ViewGroup")));
		MobileElement securitySectionButton = (MobileElement) driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/android.view.ViewGroup"));
		securitySectionButton.click();

		// step 4 click cambia security token
		logger.info("Security Token - Step 4 - Tap Cambia security token ");
		label("4) Tapped: 'Btn SecurityTokenSection'");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup")));
		MobileElement securityTokenButton = (MobileElement) driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup"));
		securityTokenButton.click();

		// step 5 inserimento passcode
		logger.info("Security Token - Step 5 - Inserimento Passcode " + passCode);
		label("5) Inserted: 'Inserimento passcode' " + passCode);
		MobileElement passCodeEl = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/insert_pin_entry"));
		passCodeEl.sendKeys(passCode);

		// step 6 click continua
		logger.info("Security Token - Step 6 - Tap Btn Continua ");
		label("6) Tapped: 'Btn Continua'");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/insert_pin_continue")));
		MobileElement passcodeContinueButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/insert_pin_continue"));
		passcodeContinueButton.click();

		// step 7 inserimento securityToken
		logger.info("Security Token - Step 7 - Inserimento Security Token " + securityToken);
		label("7) Inserted: 'Inserimento Security Token' " + securityToken);
		MobileElement securityTokenEl = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/security_token_login_text_entry"));
		securityTokenEl.sendKeys(securityToken);

		// step 8 click continua securityToken
		logger.info("Security Token - Step 8 - Tap Btn Continua Security Token ");
		label("8) Tapped: 'Btn SecurityToken'");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/security_token_continue_btn")));
		MobileElement securityTokenContinueButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/security_token_continue_btn"));
		securityTokenContinueButton.click();

		// step 9 click continua securityToken troppo facile
		logger.info("Security Token - Step 9 - Tap Btn Continua Security Token Troppo Facile");
		label("9) Tapped: 'Btn SecurityToken Troppo Facile'");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/btn_dialog_ko")));
		MobileElement securityTokenContinueEasyButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/btn_dialog_ko"));
		securityTokenContinueEasyButton.click();

		// step 10 inserimento securityToken
		logger.info("Security Token - Step 10 - Inserimento Security Token Conferma" + securityToken);
		label("10) Inserted: 'Inserimento Security Token Conferma' " + securityToken);
		MobileElement confirmedSecurityTokenEl = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/security_token_login_text_entry"));
		confirmedSecurityTokenEl.sendKeys(securityToken);

		// step 11 click continua securityToken conferma
		logger.info("Security Token - Step 11 - Tap Btn Continua Security Token Conferma ");
		label("11) Tapped: 'Btn SecurityToken Conferma'");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/security_token_continue_btn")));
		MobileElement confirmedSecurityTokenContinueButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/security_token_continue_btn"));
		confirmedSecurityTokenContinueButton.click();

		// step 12 click skip impronta
		logger.info("Security Token - Step 12 - Tap Btn Skip Impronta ");
		label("12) Tapped: 'Btn Skip Impronta'");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/sca_use_biometric_not_now_btn")));
		MobileElement skipFingerButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/sca_use_biometric_not_now_btn"));
		skipFingerButton.click();

		// step 13 click conferma security token creato
		logger.info("Security Token - Step 13 - Tap Btn Conferma Security Token Creato ");
		label("13) Tapped: 'Btn Conferma Security Token Creato'");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/security_token_created_btn")));
		MobileElement tokenCreatedButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/security_token_created_btn"));
		tokenCreatedButton.click();

		// step 14 click torna Home step 1
		logger.info("Security Token - Step 14 - Tap Btn tornaHomeStep1 ");
		label("14) Tapped: 'Btn tornaHomeStep1'");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.View[1]")));
		MobileElement tornaHomeStep1Button = (MobileElement) driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.View[1]"));
		tornaHomeStep1Button.click();

		// step 15 click torna Home step 2
		logger.info("Security Token - Step 15 - Tap Btn tornaHomeStep2 ");
		label("15) Tapped: 'Btn tornaHomeStep2'");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/easyToolbarBack")));
		MobileElement tornaHomeStep2Button = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/easyToolbarBack"));
		tornaHomeStep2Button.click();

		// step 16 click torna Home step 3
		logger.info("Security Token - Step 16 - Tap Btn tornaHomeStep3 ");
		label("16) Tapped: 'Btn tornaHomeStep3'");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/profileBackIcon")));
		MobileElement tornaHomeStep3Button = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/profileBackIcon"));
		tornaHomeStep3Button.click();
		
		logger.info("END REAL TEST : < changeSecurityToken >");

		return this;
	}
}
