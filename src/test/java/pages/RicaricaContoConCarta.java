package pages;

import com.microsoft.appcenter.appium.Factory;

import global.*;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import modals.FingerPrintModal;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;


public class RicaricaContoConCarta extends EvolveBasePage {
	
	private static final Logger logger = LogManager.getLogger(RicaricaContoConCarta.class);

    @Rule
    public TestWatcher watcher = Factory.createWatcher();

    public RicaricaContoConCarta() {
    }

    @Override
    public PlatformQuery trait() {
        return new PlatformQuery()
        		.setAndroid(By.id("bm0.zero.tier2:id/homeFragment"))
                //.setAndroid(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView"))
                //.setAndroid(By.id("Login"))
                .setiOS(By.id("Login"));
    }

    public RicaricaContoConCarta rechargeAccount(String amountRechargeStr, String cardHolderStr, String cardNumberStr, String emailStr, String cvv2Str) throws InterruptedException {

    	logger.info("START REAL TEST : < enterCredentials >");
    	
    	//step 1 click ho gia un account (login)
//    	logger.info("Scenario) Login nuovo numero - Step 1) click ho gia un account");
//    	MobileElement loginIn = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/btn_welcome_login"));			
//		loginIn.click();
		//driver.findElementByAccessibilityId("LoginEntry").sendKeys(username);
//		label("1) Tapped: 'Sign in'");
		
		
		//-----------------------------------------------------------------------
		
		logger.info("Scenario ) Ricarica Conto ");
		label("< RICARICA CONTO STARTED >");

		//step 2 Security token  
		//click money button
		logger.info("Ricarica Conto - Step 1 - Tap Btn Money ");
		label("1) Tapped: 'Btn Money'");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/moneyFragment")));
		MobileElement moneyButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/moneyFragment"));
		moneyButton.click();
		
		//click home button
		logger.info("Ricarica Conto - Step 2 - Tap Btn Home ");
		label("2) Tapped: 'Btn Home'");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/homeFragment")));
		MobileElement homeButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/homeFragment"));
		homeButton.click();	
		WaitOptions.waitOptions(Duration.ofSeconds(1));
			
		//inizio ricarica
		//wait.until(ExpectedConditions.elementToBeClickable(By
			//	.id("bm0.zero.tier2:id/adapterProfileBannerDescription")));
		logger.info("Ricarica Conto - Step 3 - Tap Btn CashIn ");
		label("1) Tapped: 'Btn CashIn'");
		MobileElement cashIn = (MobileElement) ((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Cash In\").instance(0))");
				//driver.findElement(By.id("bm0.zero.tier2:id/adapterProfileBannerDescription"));
		cashIn.click();
		

		//clicca carta per ricaricare
		logger.info("Ricarica Conto - Step 4 - Tap Btn Credit Card ");
		label("4) Tapped: 'Btn Credit Card'");
		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("bm0.zero.tier2:id/img_card_with_circle")));
		MobileElement cartaPerRicarica = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/img_card_with_circle"));
		cartaPerRicarica.click();
		
		//inserire importo da ricaricare
		logger.info("Ricarica Conto - Step 5 - Insert Amount: "+amountRechargeStr);
		label("5) Tapped: Insert Amount: "+amountRechargeStr);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("bm0.zero.tier2:id/inserted_value")));
		MobileElement importoDaRicaricare = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/inserted_value"));
		importoDaRicaricare.sendKeys(amountRechargeStr);
		MobileElement importoDaRicaricareNext = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/flowContinueBtn"));
		importoDaRicaricareNext.click();
		//popUp dati carte per ricarica
		
		//Modale Ricarica in un Lampo : salva metodo di pagamento
		Thread.sleep(1000);
		List<MobileElement> elementList = driver.findElements(By.id("bm0.zero.tier2:id/btn_dialog_ok"));
		
		if(elementList.size()>0){
			logger.info("Ricarica Conto - Step 6 - Tap Salta Salva metodo di pagamento ");
			label("6) Tap: 'Btn Ok Salva metodo di pagamento'");
			wait.until(ExpectedConditions.elementToBeClickable(By
					.id("bm0.zero.tier2:id/btn_dialog_ko")));
			MobileElement saveMethodOk = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/btn_dialog_ko"));
			saveMethodOk.click();
		}
		else{
			System.out.println("Salva metodo di pagamento Modal NOT Show");
			logger.info("Ricarica Conto - Step6.0) Salva metodo di pagamento Modal NOT Show");
			label("6.0) Tapped: 'Salva metodo di pagamento Modal NOT Show'");
		}
		
		
		

		
		
		//Swipe bottom
			Dimension size;
		  //Get the size of screen.
		  size = driver.manage().window().getSize();
		  System.out.println(size);

		  //Swipe from Bottom to Top.
//		  TouchAction swipe = new TouchAction(driver);
//		  swipe.press(PointOption.point(624,1227));
//		  swipe.moveTo(PointOption.point(632,491));
//		  swipe.release();
//		  swipe.perform();
//		  driver.performTouchAction(swipe);
		 // wait.until(ExpectedConditions.elementToBeClickable(By.id("cardButton")));
		  logger.info("Ricarica Conto - Step 7 - Scroll UiAutomator <email>");
		  label("7) Scroll: 'UiAutomator <Email>'");
		  WaitOptions.waitOptions(Duration.ofSeconds(1));
		  ((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"EMAIL\").instance(0))");
 
	
		  WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		logger.info("Ricarica Conto - Step 8 - Choose: 'Credit card' <materCard> ");
		label("8) Choose: 'Credit card' <materCard>");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]")));
		MobileElement dropDownTipoCarta = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]"));
		dropDownTipoCarta.click();
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")));
		MobileElement selectMatercard = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]"));
		selectMatercard.click();
		//nome Intestatario
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[4]/android.widget.EditText")));
		
		logger.info("Ricarica Conto - Step 9 - Send: 'Nome Intes' - value : "+cardHolderStr);
		label("9) Send: 'Nome Intes - value : "+cardHolderStr);
		MobileElement nomeIntestatario = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[4]/android.widget.EditText"));
		nomeIntestatario.sendKeys(cardHolderStr);
		
		//numero carta
		logger.info("Ricarica Conto - Step 10 - Send: Card Number - Value : " + cardNumberStr);
		label("10) Send: < Card Number > - Value : " + cardNumberStr);
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[6]/android.widget.EditText")));
		MobileElement numeroCarta = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[6]/android.widget.EditText"));
		numeroCarta.sendKeys(cardNumberStr);
		
		//scadenzamese
		logger.info("Ricarica Conto - Step 11 - Send: 'Scadenza' <mese><anno> ");
		label("11) Send: 'Scadenza' <mese><anno>");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[8]/android.view.View[1]")));
		MobileElement monthList = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[8]/android.view.View[1]"));
		monthList.click();
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[7]")));
		MobileElement monthListDropDown = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[7]"));
		monthListDropDown.click();
		//scadenza anno
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[8]/android.view.View[2]")));
		MobileElement yearList = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[8]/android.view.View[2]"));
		yearList.click();
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[5]")));
		MobileElement yearListDropDown = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[5]"));
		yearListDropDown.click();
		logger.info("Ricarica Conto - Step 12 - Send: 'Scadenza' <mese><anno> ");
		label("12) Send: 'Scadenza' <mese><anno>");
		
		//move to down
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		  ((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Conferma\").instance(0))");

		
		
		//email
		Thread.sleep(1000);
		logger.info("Ricarica Conto - Step 13 - Send: 'Email' <test.1.1@test1.com> ");
		label("13.1) Send: 'Email' <test.1.1@test1.com>");
		
//		TouchAction touchAction = new TouchAction(driver);
//		touchAction.tap(new PointOption().withCoordinates(459, 817)).perform();
//		touchAction.tap(new PointOption().withCoordinates(540, 1528)).perform();
//		touchAction.tap(new PointOption().withCoordinates(749, 1805)).perform();
//		touchAction.tap(new PointOption().withCoordinates(624, 1558)).perform();
//		touchAction.tap(new PointOption().withCoordinates(328, 1807)).perform();
//		touchAction.tap(new PointOption().withCoordinates(632, 1525)).perform();
//		touchAction.tap(new PointOption().withCoordinates(752, 1805)).perform();
//		touchAction.tap(new PointOption().withCoordinates(456, 1669)).perform();
//		touchAction.tap(new PointOption().withCoordinates(838, 1653)).perform();
//		driver.getKeyboard();
//		TouchAction touchAction = new TouchAction(driver);
//		touchAction.tap(new PointOption().withCoordinates(459, 817)).perform();
//		((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.D));
//		((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.AT));
//		((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.G));
//		((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.NUMPAD_DOT));
//		((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.C));
//		((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.O));
//		((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.M));
//		driver.hideKeyboard();
		
		//email
		//funziona solo in locale
//		wait.until(ExpectedConditions.elementToBeClickable(By
//		        .xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.EditText")));
//		MobileElement email = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.EditText"));
//		email.sendKeys("test11@test1.com");
//		
		
//		wait.until(ExpectedConditions.elementToBeClickable(By
//		        .className("android.widget.EditText")));
		
		List <MobileElement> listEl = driver.findElements(By.className("android.widget.EditText"));
		logger.info("listEl.size()=="+listEl.size());
		label("13.2) Send: 'List Size' <"+listEl.size()+">");
		MobileElement email = (MobileElement) driver.findElements(By.className("android.widget.EditText")).get(0);
		
		email.sendKeys(emailStr);
		
		label("13.3) Send: 'Email' <"+emailStr+">");
		

		
		//cvc
		logger.info("Ricarica Conto - Step 14 - Send: 'CVV2' <"+cvv2Str+"> ");
		label("14) Send: 'CVV2' <"+cvv2Str+">");
//		wait.until(ExpectedConditions.elementToBeClickable(By
//		        .xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[4]/android.widget.EditText")));
		MobileElement cvv2 = (MobileElement) driver.findElements(By.className("android.widget.EditText")).get(1);
		cvv2.sendKeys(cvv2Str);
		
		//acceptPrivacyInput
		logger.info("Ricarica Conto - Step 15 - Send: 'acceptPrivacyInput' <Y> ");
		label("15) Send: 'acceptPrivacyInput' <Y>");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.CheckBox")));
		MobileElement acceptPrivacyInput = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.CheckBox"));
		acceptPrivacyInput.click();
		//confirm recharge
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.Button[2]")));
		MobileElement confirmRecharge = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.Button[2]"));
		confirmRecharge.click();
		
		//schermata di successo della ricarica 
		//confirm recharge
		logger.info("Ricarica Conto - Step 16 - Tap: 'okBackToHome' <Y> ");
		label("16) Tap: 'okBackToHome' <Y>");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button")));
		MobileElement okBackToHome = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button"));
		okBackToHome.click();
		
		
		
		System.out.println("Fine RicaricaConto");
		
		
		//clicca X vote Flowe
		logger.info("Ricarica Conto - Step 17 - Tap X vote Flowe ");
		label("17) Tapped: 'Btn X vote Flowe'");
		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("bm0.zero.tier2:id/floweFeedbackDialogCloseBtn")));
		MobileElement skipVoteFlowe = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/floweFeedbackDialogCloseBtn"));
		skipVoteFlowe.click();
		
		
		
	
		//-----------------------------------------------------------------------
		return this;
    }

    public void tapHomeButton() {
    	logger.info("START REAL TEST : < tapHomeButton >");
		//click home button
		wait.until(ExpectedConditions.elementToBeClickable(By
			        .id("bm0.zero.tier2:id/homeFragment")));
		MobileElement homeButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/homeFragment"));
		homeButton.click();
    }

    public void creditCard2(String telephonenumb, String wrongPasscode , String errorMex , String correctPasscode) {

    	logger.info("START REAL TEST : < wrong Passcode >");
    	
    	//step 1 click ho gia un account (login)
    	logger.info("Scenario) Login nuovo numero - Step 1) click ho gia un account");
    	MobileElement loginIn = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/btn_welcome_login"));			
		loginIn.click();
		//driver.findElementByAccessibilityId("LoginEntry").sendKeys(username);
		label("1) Tapped: 'Sign in'");
		

    }
}
