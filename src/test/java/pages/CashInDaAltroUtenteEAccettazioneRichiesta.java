package pages;

import com.microsoft.appcenter.appium.Factory;

import global.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import modals.SecurityTokenModal;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.appium.java_client.android.AndroidDriver;


public class CashInDaAltroUtenteEAccettazioneRichiesta extends EvolveBasePage {
	
	private static final Logger logger = LogManager.getLogger(CashInDaAltroUtenteEAccettazioneRichiesta.class);

    @Rule
    public TestWatcher watcher = Factory.createWatcher();

    public CashInDaAltroUtenteEAccettazioneRichiesta() {
    }

    @Override
    public PlatformQuery trait() {
        return new PlatformQuery()
        		.setAndroid(By.id("bm0.zero.tier2:id/homeFragment"))
                //.setAndroid(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView"))
                //.setAndroid(By.id("Login"))
                .setiOS(By.id("Login"));
    }

    public CashInDaAltroUtenteEAccettazioneRichiesta rechargeAccountFromFloweUser(String phoneNumberForReq, String NameAccForReq, String SurnameAccForReq, String amountRecharge) throws InterruptedException {

    	logger.info("START REAL TEST : < rechargeAccountFromFloweUser >");

    	//step 1 attendi che il saldo sia visibile
		logger.info("Richiedi Ricarica: Wait - HomeUserBalance ");
		label("1) wait: 'HomeUserBalance'");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/homeUserBalance")));
		
		//step 2 click money button
		logger.info("Richiedi Ricarica: Tap - Money ");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/moneyFragment")));
		MobileElement moneyButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/moneyFragment"));
		moneyButton.click();
		label("2) Tapped: 'Tap - Money'");
//		utilDriver.takeScreenShotStep(methodName,"GoTo Money" ,"Jump to Money", driver);
		
		//step 3 click cash in button
		logger.info("Richiedi Ricarica: Tap - Cash In ");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/homeWidgetBalanceCashIn")));
		MobileElement homeButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/homeWidgetBalanceCashIn"));
		homeButton.click();	
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		label("3) Tapped: 'Tap - Cash In'");
//		utilDriver.takeScreenShotStep(methodName,"GoTo Home" ,"Jump to Home", driver);
			
//		//step 4 Tap Cash In 
//		logger.info("Richiedi Ricarica- Step: - Action: Tap < CashIn > ");
//		//wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/adapterProfileBannerDescription")));
//		MobileElement cashIn = (MobileElement) ((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Cash In\").instance(0))");
//				//driver.findElement(By.id("bm0.zero.tier2:id/adapterProfileBannerDescription"));
//		cashIn.click();
//		label("4) Tapped: 'CashIn'");
//		utilDriver.takeScreenShotStep(methodName,"GoTo CashIn" ,"CashIn", driver);
		
		//WORKFLOW WITHOUT SYNC BOOK
		//step 5 Tap Richiedi
		logger.info("Richiedi Ricarica - Step: - Action: Tap < Richiedi > ");
//		wait.until(ExpectedConditions.elementToBeClickable(By
//		        .xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.view.View[2]")));
//		MobileElement richiediButton = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.view.View[2]"));
//		richiediButton.click();	
		List <MobileElement> listEl = driver.findElements(By.className("android.view.View"));
		logger.info("listEl.size()=="+listEl.size());
		label("5.1) Send: 'List Size' <"+listEl.size()+">");
		//MobileElement btnRichiedi = (MobileElement) driver.findElements(By.className("android.view.View")).get(1);
		MobileElement btnRichiedi = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/cashInRequestButton"));
		btnRichiedi.click();
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		label("5.2) Tapped: 'Richiedi'");
//		utilDriver.takeScreenShotStep(methodName,"Page CashIn" ,"Tap Richiedi", driver);
		
		
		//step 6 Tap Nuovo Contatto
		logger.info("Richiedi Ricarica - Step: - Action: Tap < Nuovo Contatto > ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/cashInAddContactLayout")));
		MobileElement nuovoContatto = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/cashInAddContactLayout"));
		nuovoContatto.click();	
		label("6) Tapped: 'Nuovo Contatto'");
		WaitOptions.waitOptions(Duration.ofSeconds(1));
	
		
		
		//step 7 send Numero a cui chiedere la ricarica 
		logger.info("Richiedi Ricarica - Step: - Action: Send < telephonenumber > - value : "+phoneNumberForReq);
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/view_phone_number")));
		MobileElement numTelPerRichiesta = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/view_phone_number"));
		numTelPerRichiesta.sendKeys(phoneNumberForReq);	
		label("7) Send < telephonenumber > - value : "+phoneNumberForReq);
//		utilDriver.takeScreenShotStep(methodName,"Seleziono il numero" ,"Seleziono il secondo numero in rubrica", driver);
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		//step 8 Tap num tel Continue 
		logger.info("Richiedi Ricarica - Step: - Action: Tap < Continue > ");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/addressBookNewContactBtn")));
		MobileElement btnTelContinue = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/addressBookNewContactBtn"));
		btnTelContinue.click();	
		label("8) Tapped: 'Continue'");
//				utilDriver.takeScreenShotStep(methodName,"Seleziono il numero" ,"Seleziono il secondo numero in rubrica", driver);
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		//step 9 send nome acc 
		logger.info("Richiedi Ricarica - Step: - Action: Send < Name > - value : "+NameAccForReq);
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/addressBookNewContactName")));
		MobileElement sendNameAcc = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/addressBookNewContactName"));
		sendNameAcc.sendKeys(NameAccForReq);	
		label("9) Send < Name > - value : "+NameAccForReq);
//				utilDriver.takeScreenShotStep(methodName,"Seleziono il numero" ,"Seleziono il secondo numero in rubrica", driver);
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		//step 10 send Cognome acc 
		logger.info("Richiedi Ricarica - Step: - Action: Send < Surname > - value : "+ SurnameAccForReq);
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/addressBookNewContactSurname")));
		MobileElement sendSurNameAcc = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/addressBookNewContactSurname"));
		sendSurNameAcc.sendKeys(SurnameAccForReq);	
		label("10) Send < Surname > - value : "+SurnameAccForReq);
//				utilDriver.takeScreenShotStep(methodName,"Seleziono il numero" ,"Seleziono il secondo numero in rubrica", driver);
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		//step 11 num tel Tap Continue 
		logger.info("Richiedi Ricarica - Step: numTel btnContinue - Action: Tap < Continue > ");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/addressBookNewContactBtn")));
		MobileElement btnContactContinue = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/addressBookNewContactBtn"));
		btnContactContinue.click();	
		label("11) Tapped: 'Continue'");
//						utilDriver.takeScreenShotStep(methodName,"Seleziono il numero" ,"Seleziono il secondo numero in rubrica", driver);
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		//step 12 Permessi Scrittura Contatti 
		logger.info("Richiedi Ricarica - Step: Permessi Scrittura Contatti - Action: Tap < OK > ");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/btn_dialog_ok")));
		MobileElement btnPermissionContactOk = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/btn_dialog_ok"));
		btnPermissionContactOk.click();	
		label("12) Permessi Contatti - Tapped: 'OK'");
//						utilDriver.takeScreenShotStep(methodName,"Seleziono il numero" ,"Seleziono il secondo numero in rubrica", driver);
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		//step 13 Permessi Scrittura Contatti Android
		logger.info("13) Richiedi Ricarica - Step: Permessi Scrittura Contatti Android - Action: Tap < OK > ");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("com.android.packageinstaller:id/permission_allow_button")));
		MobileElement btnPermissionContactAndroidOk = (MobileElement) driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
		btnPermissionContactAndroidOk.click();
		label("13) Permessi android - Tapped: 'OK'");
//								utilDriver.takeScreenShotStep(methodName,"Seleziono il numero" ,"Seleziono il secondo numero in rubrica", driver);
		WaitOptions.waitOptions(Duration.ofSeconds(1));
				
		
		//step 13 Send Importo da ricaricare
		logger.info("Richiedi Ricarica - Step 13: - Action: sendKeys - Value : " + amountRecharge);
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/inserted_value")));
		MobileElement importoDaRicaricare = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/inserted_value"));
		importoDaRicaricare.sendKeys(amountRecharge);	
		label("13) Send: Amount - Value : "+amountRecharge);
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		
		//step 14 action swipe
		logger.info("Richiedi Ricarica - Step 14: - Action: Swipe ");
		Point elementStart = driver.findElement(By.id("bm0.zero.tier2:id/floweSwipeButton")).getLocation();
		Point elementEnd = driver.findElement(By.id("bm0.zero.tier2:id/animationView")).getLocation();
		label("14.1) Tapped: 'Swipe Start'");
		TouchAction touchAction = new TouchAction(driver);

	    touchAction.longPress(PointOption.point(elementStart))
	               .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
	               .moveTo(PointOption.point(elementEnd))
	               .release()
	               .perform();
	    
	    label("14.2) Tapped: 'Swipe End'");
	    
	    
//		//Tap Continue
//		logger.info("Richiedi Ricarica - Step: - Action: Tap < NumeroDaLista[2] > ");
//		wait.until(ExpectedConditions.elementToBeClickable(By
//		        .id("bm0.zero.tier2:id/flowContinueBtn")));
//		MobileElement continueBtn = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/flowContinueBtn"));
//		continueBtn.click();	
////		utilDriver.takeScreenShotStep(methodName,"Importo da ricaricare" ,"inserisco 26 come importo", driver);
//		WaitOptions.waitOptions(Duration.ofSeconds(1));
//		
//		
//		//Send messaggio richiesta
//		logger.info("Richiedi Ricarica - Step: - Action: sendKeys < messaggio > ");
//		wait.until(ExpectedConditions.elementToBeClickable(By
//		        .id("bm0.zero.tier2:id/view_message_edt")));
//		MobileElement messaggioRichiesta = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/view_message_edt"));
//		messaggioRichiesta.sendKeys("Ciao test automatizzato riuscito");	
//		WaitOptions.waitOptions(Duration.ofSeconds(1));
//		
//		//Tap emoticon
//		logger.info("Richiedi Ricarica - Step: - Action: Tap < emoticon > ");
//		wait.until(ExpectedConditions.elementToBeClickable(By
//		        .xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.ImageView")));
//		MobileElement emoticonBtn = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.ImageView"));
//		emoticonBtn.click();	
//		WaitOptions.waitOptions(Duration.ofSeconds(1));
//		
//		//Tap invia
//		logger.info("Richiedi Ricarica - Step: - Action: Tap < Invia > ");
//		wait.until(ExpectedConditions.elementToBeClickable(By
//		        .id("bm0.zero.tier2:id/cashInRequestBtn")));
//		MobileElement inviaBtn = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/cashInRequestBtn"));
////		utilDriver.takeScreenShotStep(methodName,"Schermata di ricarica" ,"inserisco il messaggio e l'icona , tap continua", driver);
//		inviaBtn.click();	
//		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		
//		//Tap Torna Alla Home
//		logger.info("Richiedi Ricarica - Step: - Action: Tap < tornaAllaHomeBtn > ");
//		wait.until(ExpectedConditions.elementToBeClickable(By
//		        .id("bm0.zero.tier2:id/cashInConfirmHomeBtn")));
//		MobileElement tornaAllaHomeBtn = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/cashInConfirmHomeBtn"));
////		utilDriver.takeScreenShotStep(methodName,"Messaggio di conferma" ,"Tap Torna Alla Home", driver);
//		tornaAllaHomeBtn.click();	
//		logger.info("Richiedi Ricarica: test terminato correttamente ***** ");
//		label("15) Tapped: 'Sign in'");
//		WaitOptions.waitOptions(Duration.ofSeconds(1));
//		
//		//attendi che il saldo sia visibile
//		wait.until(ExpectedConditions.elementToBeClickable(By
//		        .id("bm0.zero.tier2:id/homeUserBalance")));
//		label("16) Tapped: 'End Test -> home'");
	
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

    public void acceptRequestCharging(String responseMexStr) throws InterruptedException {

    	logger.info("START REAL TEST : < acceptRequestCharging >");
    	
    	//step 1 click ho gia un account (login)
//    	logger.info("Scenario) Login nuovo numero - Step 1) click ho gia un account");
//    	MobileElement loginIn = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/btn_welcome_login"));			
//		loginIn.click();
//		//driver.findElementByAccessibilityId("LoginEntry").sendKeys(username);
//		label("1) Tapped: 'Sign in'");
//		
    	//step 1 attendi che il saldo sia visibile
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/homeUserBalance")));
		//utilDriver.takeScreenShotStep(methodName, "Notifica Di Ricarica","Mi aspetto di trovare la notifica di richiesta ricarica", driver);
		
		
		//step 2 Read Notifica
		logger.info("Verifica Richiesta Ricarica - Step: 2 - Action: Read < Notifica > ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/itemtitle")));
		label("2) Tapped: 'Sign in'");
		MobileElement titoloNotificaRichiestaDiRicarica = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/itemtitle"));
		String titoloNotifica = titoloNotificaRichiestaDiRicarica.getAttribute("text");
		logger.info("Verifica Richiesta Ricarica - Result: Titolo = " + titoloNotifica);
		MobileElement messaggioNotificaRichiestaDiRicarica = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/itemdescription"));
		String testoNotifica = messaggioNotificaRichiestaDiRicarica.getAttribute("text");
		logger.info("Verifica Richiesta Ricarica - Result: Testo = " + testoNotifica);
		label("2.1) Tapped: 'Sign in'");
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		//utilDriver.takeScreenShotStep(methodName, "Notifica Trovata","Titolo Notifica: " +
//													titoloNotifica + " Contenuto: " +
//													testoNotifica, driver);

		//step 3 Tap Notifica
		logger.info("Verifica Richiesta Ricarica - Step: 3 - Action: Tap < Notifica > ");
		titoloNotificaRichiestaDiRicarica.click();
		label("3) Tapped: 'Sign in'");

		//step 4 Tap Notifica From list
		logger.info("Accetta Ricarica - Step: 4 - Action: Tap < notifica from list > ");
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
//				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[3]")));
//		MobileElement notiFromListBtn = (MobileElement) driver.findElement(By.xpath(
//				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[3]"));
//		notiFromListBtn.click();
		List <MobileElement> listEl = driver.findElements(By.className("android.view.ViewGroup"));
		logger.info("listEl.size()=="+listEl.size());
		label("4.1) Send: 'List Size' <"+listEl.size()+">");
		MobileElement notiFromListBtn = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/itemTitle"));
		notiFromListBtn.click();
		label("4.2) Tapped: 'Sign in'");
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		//utilDriver.takeScreenShotStep(methodName, "Pagina ricarica","Visualizzo la notifica", driver);
		
		//step 5 Tap read mex
		logger.info("Accetta Ricarica - Step: 5 - Wait: < schermata > ");
		// wait data operazione
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/cashout_payment_request_date")));
		logger.info("Accetta Ricarica - read Message ");
		MobileElement messaggioNotificaRicevuta = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/messageBox_fromMessage"));
		String mexNot = messaggioNotificaRicevuta.getAttribute("text");
		logger.info("Accetta Ricarica - contenuto messaggio: " + mexNot);
		label("5) Tapped: 'Sign in'");
		WaitOptions.waitOptions(Duration.ofSeconds(1));

		//step 6 Tap Accetta
		logger.info("Accetta Ricarica - Step: 6 - Action: Tap < Accetta > ");
		wait.until(
				ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/cashout_payment_request_accept_btn")));
		MobileElement inviaBtn = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/cashout_payment_request_accept_btn"));
		//utilDriver.takeScreenShotStep(methodName, "Click Accetta","accetto la richiesta", driver);
		inviaBtn.click();
		label("6) Tapped: 'Sign in'");
		WaitOptions.waitOptions(Duration.ofSeconds(1));

		//step 7 Tap ( + ) Aggiungi messaggio
		logger.info("Accetta Ricarica - Step: 7 - Aggiungi Messaggio - Action: Tap < + > ");
		wait.until(
				ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/cashInAmountEditMessageImg")));
		MobileElement btnAddMex = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/cashInAmountEditMessageImg"));
		//utilDriver.takeScreenShotStep(methodName, "Click Accetta","accetto la richiesta", driver);
		btnAddMex.click();
		label("7) Tapped: 'Sign in'");
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		
		//step 8 Send messaggio risposta
		logger.info("Accetta Ricarica - Step: 8 - Action: sendKeys < messaggio > - Value : "+responseMexStr);
		wait.until(ExpectedConditions           
				.elementToBeClickable(By.id("bm0.zero.tier2:id/cashOutMessageText")));
		MobileElement messaggioRichiesta = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/cashOutMessageText"));
		messaggioRichiesta.sendKeys(responseMexStr);
		label("8) Accetta Ricarica - Action: sendKeys < messaggio > - Value : "+responseMexStr);
		WaitOptions.waitOptions(Duration.ofSeconds(1));

		
		//step 9 Tap emoticon
		logger.info("Accetta Ricarica - Step: 9 - Action: Tap < emoticon > ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.ImageView")));
		MobileElement emoticonBtn = (MobileElement) driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.ImageView"));
		emoticonBtn.click();
		label("9) Tapped: 'Sign in'");
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		
		//step 10 Tap save message
		List <MobileElement> listElTopBar = driver.findElements(By.className("android.view.View"));
		logger.info("listElTopBar.size()=="+listElTopBar.size());
		label("10.1) Send: 'List Size' <"+listElTopBar.size()+">");
		MobileElement saveMexBtn = (MobileElement) driver.findElements(By.className("android.view.View")).get(1);
		//xpath :  /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.View[2]
		saveMexBtn.click();
		label("10.2) Tapped: 'Sign in'");
		WaitOptions.waitOptions(Duration.ofSeconds(1));

		//-------------------------------------------------------------------------------------------
		// Tap invia
//		logger.info("Accetta Ricarica - Step: - Action: Tap < Invia > ");
//		wait.until(ExpectedConditions
//				.elementToBeClickable(By.id("bm0.zero.tier2:id/cashout_payment_request_send_response_btn")));
//		MobileElement inviaRicaricaBtn = (MobileElement) driver
//				.findElement(By.id("bm0.zero.tier2:id/cashout_payment_request_send_response_btn"));
//		//utilDriver.takeScreenShotStep(methodName, "Compilo La risposta","Compilo la risposta e confermo", driver);
//		inviaRicaricaBtn.click();
//		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		//step 11 action swipe
		logger.info("Accetta Ricarica - Step: - Action: Swipe ");
		
		Point elementStart = driver.findElement(By.id("bm0.zero.tier2:id/floweSwipeButton")).getLocation();
		Point elementEnd = driver.findElement(By.id("bm0.zero.tier2:id/animationView")).getLocation();
		 
		label("11) Tapped: 'Sign in'");
		
		TouchAction touchAction = new TouchAction(driver);

	    touchAction.longPress(PointOption.point(elementStart))
	               .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
	               .moveTo(PointOption.point(elementEnd))
	               .release()
	               .perform();
	    
	    label("11.2) Tapped: 'Sign in'");

		Thread.sleep(3000);
		List<MobileElement> elementList = driver.findElements(By.id("bm0.zero.tier2:id/security_token_title"));
		if (elementList.size() > 0) {
			//utilDriver.takeScreenShotStep(methodName, "Token Richiesto","Schermata token intercettata", driver);
			System.out.println("**token richiesto");
			SecurityTokenModal.insertSecurityToken(driver);
		} else {
			System.out.println("token non richiesto");
		}

		//step 12 Tap read mex Title
		logger.info("Accetta Ricarica - Step: 12 - Wait: < schermata > ");
		// wait data operazione
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/cashInConfirmTitle")));
		logger.info("Accetta Ricarica - read Message result operation ");
		MobileElement titoloMexDiRIsposta = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/cashInConfirmTitle"));
		String mexConfirmNot = titoloMexDiRIsposta.getAttribute("text");
		//utilDriver.takeScreenShotStep(methodName, "Ricarica Accettata","Ricarica accettata correttamente ResponseMex: " +mexConfirmNot, driver);
		logger.info("Accetta Ricarica - contenuto messaggio di conferma: " + mexConfirmNot);
		label("12) Tapped: 'Sign in'");
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		//step 13 Tap read mex Description
		logger.info("Accetta Ricarica - Step: 13 - Wait: < Description > ");
		// wait data operazione
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/cashInConfirmTitle")));
		logger.info("Accetta Ricarica - read Message result operation ");
		MobileElement descMexDiRIsposta = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/cashInConfirmTitle"));
		String titleMexConfirmNot = descMexDiRIsposta.getAttribute("text");
		//utilDriver.takeScreenShotStep(methodName, "Ricarica Accettata","Ricarica accettata correttamente ResponseMex: " +mexConfirmNot, driver);
		logger.info("Accetta Ricarica - contenuto messaggio di conferma: " + mexConfirmNot);
		label("13) Tapped: 'Sign in'");
		WaitOptions.waitOptions(Duration.ofSeconds(1));

		//step 14 Tap Torna Alla Home
		logger.info("Accetta Ricarica - Step: - Action: Tap < tornaAllaHomeBtn > ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/cashInConfirmHomeBtn")));
		MobileElement tornaAllaHomeBtn = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/cashInConfirmHomeBtn"));
		//utilDriver.takeScreenShotStep(methodName, "Schermata Conferma ","Tap Confirm per tornare alla home", driver);
		logger.info("Accetta Ricarica: test terminato correttamente ***** ");
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		tornaAllaHomeBtn.click();
		label("14) Tapped: 'Sign in'");
		WaitOptions.waitOptions(Duration.ofSeconds(1));

		//step 15 attendi che il saldo sia visibile
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/homeUserBalance")));
		logger.info("End test ***** ");
		label("15) Tapped: 'end test'");
    }
}
