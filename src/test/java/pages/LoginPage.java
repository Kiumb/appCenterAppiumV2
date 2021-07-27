package pages;

import com.microsoft.appcenter.appium.Factory;

import global.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.touch.WaitOptions;
import modals.FingerPrintModal;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends EvolveBasePage {
	
	private static final Logger logger = LogManager.getLogger(LoginPage.class);

    @Rule
    public TestWatcher watcher = Factory.createWatcher();

    public LoginPage() {
    }

    @Override
    public PlatformQuery trait() {
        return new PlatformQuery()
                .setAndroid(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView"))
                //.setAndroid(By.id("Login"))
                .setiOS(By.id("Login"));
    }

    public LoginPage enterCredentials(String phoneNumber, String passCode, String smsCode, String securityToken) throws InterruptedException {

    	logger.info("START REAL TEST : < enterCredentials >");
    	
    	//step 1 click ho gia un account (login)
    	logger.info("Scenario) Login nuovo numero - Step 1) click ho gia un account");
    	MobileElement loginIn = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/btn_welcome_login"));			
		loginIn.click();
		//driver.findElementByAccessibilityId("LoginEntry").sendKeys(username);
		label("1) Tapped: 'Sign in'");
		
		//step 2 click ok sulla modale OTP
		logger.info("Scenario) Login nuovo numero - Step 2) click ok sulla modale OTP");
		MobileElement otpPermission = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/btn_dialog_ok"));
		label("2) Tapped: 'OTP Permission'");
		otpPermission.click();
		//Italiano : consenti
		

		//step 3 click ok sulla modale permesso android SMS
		logger.info("Scenario) Login nuovo numero - Step 3) click ok sulla modale permesso android SMS");
		
		String textIta = "consenti";
		String textEng = "allow";

		By.xpath("//android.widget.Button[@text='"+textEng+"']");
		
//		List <MobileElement> permissionItaList = driver.findElements(By.xpath("//android.widget.Button[@text='"+textIta+"']"));
//		List<MobileElement> permissionItaList = driver.findElements(By.xpath("//android.widget.Button[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"+textIta+"')]"));
		List<MobileElement> permissionItaList = driver.findElements(By.xpath("//android.widget.Button[contains(lower-case(@text),'"+textIta+"')]")); 
		
		
		//		List <MobileElement> permissionEngList = driver.findElements(By.xpath("//android.widget.Button[@text='"+textEng+"']"));
		List<MobileElement> permissionEngList = driver.findElements(By.xpath("//android.widget.Button[contains(lower-case(@text),'"+textEng+"')]")); 
		
		logger.info("listITA.size()=="+permissionItaList.size()+ "listENG.size()=="+permissionEngList.size());
		label("3.1) Send: 'List Ita Size' <"+permissionItaList.size()+">  --- Send: 'List Eng Size' <"+permissionEngList.size()+">");
		if(permissionItaList.size()>0) {
			logger.info("listITA.size>0");
//					MobileElement consentiBtn = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@text='"+textIta+"']"));
			MobileElement consentiBtn = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[contains(lower-case(@text),'"+textIta+"')]"));
			consentiBtn.click();
			label("3.2) Tapped: 'SMS Permission ITA'");
		}else if(permissionEngList.size()>0) {
			logger.info("listITA.size>0");
//					MobileElement allowBtn = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@text='"+textEng+"']"));
			MobileElement allowBtn = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[contains(lower-case(@text),'"+textEng+"')]"));
			allowBtn.click();
			label("3.2) Tapped: 'SMS Permission ENG'");
		}
		
		
//		//step 3 click ok sulla modale permesso android SMS
//		logger.info("Scenario) Login nuovo numero - Step 3) click ok sulla modale permesso android SMS");
//		wait.until(ExpectedConditions.elementToBeClickable(By
//				.id("com.android.packageinstaller:id/permission_allow_button")));
//		//logger.info("Scenario) Login nuovo numero - Step 3) click ok sulla modale permesso android SMS");
//		MobileElement smsPermission = (MobileElement) driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
//		label("3) Tapped: 'SMS Permission'");
//		smsPermission.click();

		
		
		//step 4 inserisci il numero di telefono 	
		wait.until(ExpectedConditions.elementToBeClickable(By
						.id("bm0.zero.tier2:id/view_phone_number")));
		logger.info("Scenario) Login nuovo numero - Step 4) inserisci il numero di telefono: "+phoneNumber);
		MobileElement phoneNumberEl = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/view_phone_number"));
		label("4) Write: 'Telphonenumber'");
		phoneNumberEl.sendKeys(phoneNumber);
		//step 4.1 send il numero di telefono 	
		logger.info("Scenario) Login nuovo numero - Step 4.1) invia il numero di telefono");
		MobileElement sendPhoneNumber = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/btn_phone_number_continue"));
		label("4.1) Tapped: 'Confirm Telephonenumber'");
		sendPhoneNumber.click();
		
		//step 5 inserisci il passcode
		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("bm0.zero.tier2:id/login_text_entry")));
		logger.info("Scenario) Login nuovo numero - Step 5) inserisci il passcode"+passCode);
		MobileElement passCodeEl = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/login_text_entry"));
		label("5) Write: 'Passcode'"+" Value : "+passCode);
		passCodeEl.sendKeys(passCode);
		//utilDriver.takeScreenShotStep(methodName,"Insert Passcode" ,"inserisco il passcode: "+dataFromCSV.get("9").getValore(), driver);
		
		//step 6 il codice OTP ricevuto via SMS
		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("bm0.zero.tier2:id/otpPinEntry")));
		logger.info("Scenario) Login nuovo numero - Step 6) il codice OTP ricevuto via SMS");
		MobileElement smsCodeEl = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/otpPinEntry"));
		label("6) Write: 'SMS Code'"+" Value : "+smsCode);
		smsCodeEl.sendKeys(smsCode);
		//step 6.1 send il codice OTP ricevuto via SMS
		logger.info("Scenario) Login nuovo numero - Step6.1) send OTP ricevuto via SMS");
		MobileElement sendSmsCode = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/btn_next"));
		label("6.1) Tap: 'SMS ok'");
		Thread.sleep(1000);
		sendSmsCode.click();
		label("6.2) Tapped: 'SMS ok'");
		
		//utilDriver.takeScreenShotStep(methodName,"Insert SMS code" ,"inserisco il codice ricevuto via SMS: "+dataFromCSV.get("10").getValore(), driver);
		

		//NOTA BENE STEP 7 DA SCOMMENTARE PER I TEST LOCALI
		//COMMENTARE QUESTO STEP PRIMA DEL DEPLOY SU APPCENTER
		
		Thread.sleep(5000);
		List<MobileElement> elementList = driver.findElements(By.id("bm0.zero.tier2:id/btn_biometric_notnow"));
		List<MobileElement> elementListText = driver.findElements(By.id("bm0.zero.tier2:id/imageView10"));
		//titolo fingerprint window --  bm0.zero.tier2:id/sca_use_biometric_title
		if(elementList.size()>0||elementListText.size()>0){
			logger.info("Scenario) Login nuovo numero - Step7.0) Fingerprint Modal Show");
			label("7.0) Tapped: 'FingerPrint Banner'");
			FingerPrintModal.skip1Finger(driver);
		}
		else{
			System.out.println("Fingerprint Modal NOT Show");
			logger.info("Scenario) Login nuovo numero - Step7.0) Fingerprint Modal NOT Show");
			label("7.0) Tapped: 'Fingerprint Modal NOT Show'");
		}
		
		WaitOptions.waitOptions(Duration.ofSeconds(3));
//		//step 7 skip finger print
//		Thread.sleep(5000);
//		label("7.0) wait 5sec: 'Skip finger print'");		
//		wait.until(ExpectedConditions.elementToBeClickable(By
//						.id("bm0.zero.tier2:id/btn_biometric_notnow")));	
//		//xpath --- /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Button[2]
//		logger.info("Scenario) Login nuovo numero - Step 7) skip finger print");
//		label("7.1) found: 'Skip finger print'");
//		MobileElement skipFingerPrint = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/btn_biometric_notnow"));
//		label("7.2) Tapped: 'Skip finger print'");
//		skipFingerPrint.click();
		
		//step 8 popup sicurezza vai a security token
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By
						.id("bm0.zero.tier2:id/btn_dialog_ok")));
		logger.info("Scenario) Login nuovo numero - Step 8) popup sicurezza vai a security token");
		MobileElement vaiSecToken = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/btn_dialog_ok"));
		label("8) Tapped: 'Vai a security token'");
		vaiSecToken.click();
		
		//step 9 pubblicita  security token
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By
						.id("bm0.zero.tier2:id/tutorialNextBtn")));
		logger.info("Scenario) Login nuovo numero - Step 9) pubblicita security token");
		MobileElement pubSecTok = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/tutorialNextBtn"));
		label("9) Tapped: 'tutorial security token - page 1'");
		Thread.sleep(1000);
		pubSecTok.click();
		
		//step 10 pubblicita  crea security token
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By
						.id("bm0.zero.tier2:id/tutorialPrimaryBtn")));
		logger.info("Scenario) Login nuovo numero - Step 10) pubblicita  crea security token");
		MobileElement btnCreaSecTok = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/tutorialPrimaryBtn"));
		label("10) Tapped: 'tutorial security token - page 2'");
		btnCreaSecTok.click();
		
		//step 11 pubblicita  crea security token
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/insert_pin_entry")));
		MobileElement insertPassCode = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/insert_pin_entry"));
		label("11) Tapped: 'insert passcode' Value: "+passCode);
		insertPassCode.sendKeys(passCode);
		logger.info("Scenario) Login nuovo numero - Step 11) passcode per securitytoken");
	//	utilDriver.takeScreenShotStep(methodName,"Security Token" ,"Insert PassCode: "+dataFromCSV.get("11").getValore(), driver);
		MobileElement sendPassCode = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/insert_pin_continue"));
		label("11.1) Tapped: 'Send PassCode'");
		sendPassCode.click();
	
		//step 12 insert security token
		logger.info("Scenario) Login nuovo numero - Step 12) insert securitytoken");
		wait.until(ExpectedConditions.elementToBeClickable(By
			        .id("bm0.zero.tier2:id/security_token_login_text_entry")));		
		MobileElement insertSecurityToken = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/security_token_login_text_entry"));
		label("12) Write: 'Security Token' - Value : "+securityToken);
		insertSecurityToken.sendKeys(securityToken);
		MobileElement sendSecurityToken = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/security_token_continue_btn"));
//			utilDriver.takeScreenShotStep(methodName,"Security Token" ,"Confirm Security token"+dataFromCSV.get("11").getValore(), driver);
		label("12.1) Tapped: 'Send SecurityToken'");
		sendSecurityToken.click();
		
		//step 13 codice troppo facile continuare
		logger.info("Scenario) Login nuovo numero - Step 13) securitytoken pop up codice troppo facile");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/btn_dialog_ko")));
		MobileElement tokenFacile = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/btn_dialog_ko"));
//			utilDriver.takeScreenShotStep(methodName,"Security Token" ,"Dialog Token Facile - OK", driver);
		label("13) Tapped: 'Confirm Codice troppo facile'");
		tokenFacile.click();
		
		//step 14 sett security token
		logger.info("Scenario) Login nuovo numero - Step 14) insert securitytoken confirm");
		wait.until(ExpectedConditions.elementToBeClickable(By
			        .id("bm0.zero.tier2:id/security_token_login_text_entry")));
		insertSecurityToken = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/security_token_login_text_entry"));
		label("14) Write: 'Confirm Security Token' - Value : "+securityToken);
		insertSecurityToken.sendKeys(securityToken);
		sendSecurityToken = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/security_token_continue_btn"));
//			utilDriver.takeScreenShotStep(methodName,"Security Token" ,"Confirm Security token"+dataFromCSV.get("11").getValore(), driver);
		label("14.1) Tapped: 'Confirm Security Token'");
		sendSecurityToken.click();
		
		
		Thread.sleep(3000);
		
//		/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[2]
		//id bm0.zero.tier2:id/btn_biometric_notnow
		List<MobileElement> elementList2 = driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[2]"));
		List<MobileElement> elementListText2 = driver.findElements(By.id("bm0.zero.tier2:id/imageView10"));
		//titolo fingerprint window --  bm0.zero.tier2:id/sca_use_biometric_title
		if(elementList2.size()>0||elementListText2.size()>0){
			logger.info("Scenario) Login nuovo numero - Step 15) skip biometric");
			label("15.0) Tapped: 'FingerPrint Banner'");
			FingerPrintModal.skip2Finger(driver);
		}
		else{
			System.out.println("Fingerprint Modal NOT Show");
			logger.info("Scenario) Login nuovo numero - Step 15) Fingerprint Modal NOT Show");
			label("15.0) Tapped: 'Fingerprint Modal NOT Show'");
		}
		
//		//step 15 skip finger print
//		logger.info("Scenario) Login nuovo numero - Step 15) skip biometric");
//		wait.until(ExpectedConditions.elementToBeClickable(By
//				.id("bm0.zero.tier2:id/sca_use_biometric_not_now_btn")));
//		MobileElement skipFingerPrint = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/btn_biometric_notnow"));
//		skipFingerPrint = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/sca_use_biometric_not_now_btn"));
////		utilDriver.takeScreenShotStep(methodName,"Dialog FingerPrint" ,"Skip Dialog FingerPrint", driver);
//		label("15) Tapped: 'Skip Finger Print'");
//		skipFingerPrint.click();
		
		//step 15 security created
		label("16) WAIT: 'security token Confirm'");
		logger.info("Scenario) Login nuovo numero - Step 16) security token created");
		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("bm0.zero.tier2:id/security_token_created_btn")));
		MobileElement securityContinua = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/security_token_created_btn"));
//		utilDriver.takeScreenShotStep(methodName,"Security Token" ,"Security token settato pagina di Successo - ok", driver);
		label("16.1) Tapped: 'securityContinua'");
		securityContinua.click();
	
		
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

    public void wrongPasscode(String telephonenumb, String wrongPasscode , String errorMex , String correctPasscode) {

    	logger.info("START REAL TEST : < wrong Passcode >");
    	
    	//step 1 click ho gia un account (login)
    	logger.info("Scenario) Login nuovo numero - Step 1) click ho gia un account");
    	MobileElement loginIn = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/btn_welcome_login"));			
		loginIn.click();
		//driver.findElementByAccessibilityId("LoginEntry").sendKeys(username);
		label("1) Tapped: 'Sign in'");
		
		//step 2 click ok sulla modale OTP
		logger.info("Scenario) Login nuovo numero - Step 2) click ok sulla modale OTP");
		MobileElement otpPermission = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/btn_dialog_ok"));
		label("2) Tapped: 'OTP Permission'");
		otpPermission.click();
		
		//step 3 click ok sulla modale permesso android SMS
		logger.info("Scenario) Login nuovo numero - Step 3) click ok sulla modale permesso android SMS");
		
		String textIta = "consenti";
		String textEng = "allow";

		By.xpath("//android.widget.Button[@text='"+textEng+"']");
		
//		List <MobileElement> permissionItaList = driver.findElements(By.xpath("//android.widget.Button[@text='"+textIta+"']"));
//		List<MobileElement> permissionItaList = driver.findElements(By.xpath("//android.widget.Button[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"+textIta+"')]"));
		List<MobileElement> permissionItaList = driver.findElements(By.xpath("//android.widget.Button[contains(lower-case(@text),'"+textIta+"')]")); 
		
		
		//		List <MobileElement> permissionEngList = driver.findElements(By.xpath("//android.widget.Button[@text='"+textEng+"']"));
		List<MobileElement> permissionEngList = driver.findElements(By.xpath("//android.widget.Button[contains(lower-case(@text),'"+textEng+"')]")); 
		
		logger.info("listITA.size()=="+permissionItaList.size()+ "listENG.size()=="+permissionEngList.size());
		label("3.1) Send: 'List Ita Size' <"+permissionItaList.size()+">  --- Send: 'List Eng Size' <"+permissionEngList.size()+">");
		if(permissionItaList.size()>0) {
			logger.info("listITA.size>0");
//			MobileElement consentiBtn = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@text='"+textIta+"']"));
			MobileElement consentiBtn = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[contains(lower-case(@text),'"+textIta+"')]"));
			consentiBtn.click();
			label("3.2) Tapped: 'SMS Permission ITA'");
		}else if(permissionEngList.size()>0) {
			logger.info("listITA.size>0");
//			MobileElement allowBtn = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@text='"+textEng+"']"));
			MobileElement allowBtn = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[contains(lower-case(@text),'"+textEng+"')]"));
			allowBtn.click();
			label("3.2) Tapped: 'SMS Permission ENG'");
		}
		
//		//step 3 click ok sulla modale permesso android SMS
//		logger.info("Scenario) Login nuovo numero - Step 3) click ok sulla modale permesso android SMS");
//		wait.until(ExpectedConditions.elementToBeClickable(By
//				.id("com.android.packageinstaller:id/permission_allow_button")));
//		//logger.info("Scenario) Login nuovo numero - Step 3) click ok sulla modale permesso android SMS");
//		MobileElement smsPermission = (MobileElement) driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
//		label("3) Tapped: 'SMS Permission'");
//		smsPermission.click();
		
		//step 4 inserisci il numero di telefono 	
		wait.until(ExpectedConditions.elementToBeClickable(By
						.id("bm0.zero.tier2:id/view_phone_number")));
		logger.info("Scenario) Login nuovo numero - Step 4) inserisci il numero di telefono: "+telephonenumb);
		MobileElement phoneNumberEl = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/view_phone_number"));
		label("4) Write: 'Telphonenumber'");
		phoneNumberEl.sendKeys(telephonenumb);
		//step 4.1 send il numero di telefono 	
		logger.info("Scenario) Login nuovo numero - Step 4.1) invia il numero di telefono");
		MobileElement sendPhoneNumber = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/btn_phone_number_continue"));
		label("4.1) Tapped: 'Confirm Telephonenumber'");
		sendPhoneNumber.click();
		
		//step 5 inserisci il passcode errato
		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("bm0.zero.tier2:id/login_text_entry")));
		logger.info("Scenario) Login nuovo numero - Step 5) inserisci il numero di telefono"+wrongPasscode);
		MobileElement passCodeEl = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/login_text_entry"));
		label("5) Write: 'Wrong Passcode'"+" Value : "+wrongPasscode);
		passCodeEl.sendKeys(wrongPasscode);
		//utilDriver.takeScreenShotStep(methodName,"Insert Passcode" ,"inserisco il passcode: "+dataFromCSV.get("9").getValore(), driver);
		
		
		
		
		//step 6 inserisci il passcode
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/confirm_password_text_error_counter")));
		logger.info("Scenario) Login nuovo numero - Step 6) Atteso messaggio di errore : "+errorMex);
		MobileElement mexErrorPasscodeWrong = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/confirm_password_text_error_counter"));
		label("6) Write: 'Error Mex Wrong PassCode' : "+errorMex);
		String readErrorMex = mexErrorPasscodeWrong.getText();
		if (readErrorMex.compareTo(errorMex)==0)
		{
			label("6.1) Copy error Ok. error read : "+readErrorMex +" equalsto " + errorMex);
		}
		else 
		{
			label("6.1) Copy error Failed. error read : "+readErrorMex +" not Match " + errorMex);
		}
		
		//step 7 inserisci il passcode
		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("bm0.zero.tier2:id/login_text_entry")));
		logger.info("Scenario) Login nuovo numero - Step 5) inserisci il passcode corretto"+correctPasscode);
		passCodeEl = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/login_text_entry"));
		label("5) Write: 'Passcode'"+" Value : "+correctPasscode);
		passCodeEl.sendKeys(correctPasscode);
		
		//step 6 il codice OTP ricevuto via SMS
		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("bm0.zero.tier2:id/otpPinEntry")));
		logger.info("Scenario) Login nuovo numero - Step 6) il codice OTP ricevuto via SMS");
		MobileElement smsCodeEl = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/otpPinEntry"));
//		label("6) Write: 'SMS Code'"+" Value : "+smsCode);
//		smsCodeEl.sendKeys(smsCode);
    }
}
