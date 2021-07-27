package pages;

import com.microsoft.appcenter.appium.Factory;

import global.*;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.touch.WaitOptions;
import modals.FingerPrintModal;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Drop extends EvolveBasePage {
	
	static Date date = new Date();      
    static String logDate= new SimpleDateFormat("yyyyMMddHHmmss").format(date);
	
	private static final Logger logger = LogManager.getLogger(Drop.class);

    @Rule
    public TestWatcher watcher = Factory.createWatcher();

    public Drop() {
    }

    @Override
    public PlatformQuery trait() {
        return new PlatformQuery()
                .setAndroid(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView"))
                //.setAndroid(By.id("Login"))
                .setiOS(By.id("Login"));
    }

    public Drop dropCreation(String dropNameStr, String AmountDropStr, String autoCashInValueStr) throws InterruptedException {
  	
    	logger.info("START REAL TEST : < dropCreation >");    	

    	//step 1 attendi che il saldo sia visibile
		logger.info("Creazione Drop - step 1 - Wait - HomeUserBalance ");
		label("1) wait: 'HomeUserBalance'");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/homeUserBalance")));
		label("1) Tapped: 'Wait - homeUserBalance Component'");
		
		//step 2 click money button
		logger.info("Creazione Drop - Step 2 - Tap - Money ");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/moneyFragment")));
		MobileElement moneyButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/moneyFragment"));
		moneyButton.click();
		label("2) Tapped: 'Tap - Money'");
		
		//step 3 scroll to Aggiungi Drop
		logger.info("Creazione Drop - Step 3 - Scroll UiAutomator <email>");
		label("3) Scroll: 'UiAutomator <Aggiungi un Drop>'");
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Aggiungi un Drop\").instance(0))");
		//other string for search      : I tuoi gruppi
		
		
		
		//step 4 click tap aggiungi drop button
		logger.info("Creazione Drop - step 4 - Tap - Aggiungi Drop ");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/floweDropCardAddDropBtn")));
		MobileElement addDrop = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/floweDropCardAddDropBtn"));
		addDrop.click();
		label("4) Tapped: 'Tap - Aggiungi Drop (+)'");
		
		//step 5 click tap set drop Name
		logger.info("Creazione Drop - step 5 - Send - Name Drop - Value : " + dropNameStr+logDate);
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/goalWalletCreateNameText")));
		MobileElement dropName = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/goalWalletCreateNameText"));
		dropName.sendKeys(dropNameStr+logDate);
		label("5) Tapped: 'Send - Drop Drop Name' - Value : "+dropNameStr+logDate);
		
		driver.hideKeyboard();
		
		//step 6 drop name - Tap Continue
		logger.info("Creazione Drop - step 6 - Tap - Continue ");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/goalWalletCreateNameBtn")));
		MobileElement dropNameContinue = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/goalWalletCreateNameBtn"));
		dropNameContinue.click();
		label("6) Tapped: 'Tap - Continue' - Value : Drop Automatico");
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		//step 7 drop Amount - send Value
		logger.info("Creazione Drop - step 7 - Send - Amount - Value : " +AmountDropStr);
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/goal_wallet_amount")));
		MobileElement setDropAmount = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/goal_wallet_amount"));
		setDropAmount.sendKeys(AmountDropStr);
		label("7) Tapped: 'Tap - Continue' - Value : "+AmountDropStr);
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		//step 8 drop amount - Tap Continue
		logger.info("Creazione Drop - step 8 - Tap - Drop Amount Continue ");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/goal_wallet_amount_next_with_amount")));
		MobileElement dropAmountContinue = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/goal_wallet_amount_next_with_amount"));
		dropAmountContinue.click();
		label("8) Tapped: 'Tap -Drop Amount Continue'");
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		
		//step 9  Choose - Topic
		logger.info("Creazione Drop - step 9 - Choose - Topic ");
//		wait.until(ExpectedConditions.elementToBeClickable(By
//		        .id("bm0.zero.tier2:id/goal_wallet_amount_next_with_amount")));
		List <MobileElement> listEl = driver.findElements(By.className("android.widget.RelativeLayout"));
		logger.info("listEl.size()=="+listEl.size());
		label("9.1) Send: 'List Size' <"+listEl.size()+">");
		MobileElement topicBtn = (MobileElement) driver.findElements(By.className("android.widget.RelativeLayout")).get(4);
		topicBtn.click();
		label("9.2) Tapped: 'Choose - Topic'");
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		//step 10  Choose - Topic Continue
		logger.info("Creazione Drop - step 10 - Tap - Continue ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/topicBtn")));
		MobileElement dropTopicContinue = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/topicBtn"));
		dropTopicContinue.click();
		label("10) Tapped: 'Choose - Topic'");
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		
		//step 11 drop Select Date - Tap : Senza Scadenza
		logger.info("Creazione Drop - step 11 - Tap -  Senza Scadenza ");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/goal_wallet_date_next_no_amount")));
		MobileElement senzaScadenzaBtn = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/goal_wallet_date_next_no_amount"));
		senzaScadenzaBtn.click();
		label("11) Tapped: 'Tap - Senza Scadenza'");
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		//step 12 drop topic - Choose Rule : Auto CashIn
		logger.info("Richiedi Ricarica - step 12 - Choose Rule : Auto CashIn ");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/goalWalletRulesAutoCashInSwitch")));
		MobileElement btnAutoCashIn = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/goalWalletRulesAutoCashInSwitch"));
		btnAutoCashIn.click();
		label("12) Tapped: 'Choose Rule : Auto CashIn'");
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		//step 13 drop Rule - Tap Continue
		logger.info("Creazione Drop - step 13 - Tap - Drop Rule Continue ");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/goalWalletSettingAutoCashinContinueBtn")));
		MobileElement dropRuleContinue = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/goalWalletSettingAutoCashinContinueBtn"));
		dropRuleContinue.click();
		label("13) Tapped: 'Tap -Drop Rule Continue'");
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		
		//step 14 drop AutocashIn Value - Send Value 1
		logger.info("Creazione Drop - step 14 - Send - AutocashIn Value - Send Value : "+autoCashInValueStr);
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/inserted_value")));
		MobileElement sendAutoCashInValue = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/inserted_value"));
		sendAutoCashInValue.sendKeys(autoCashInValueStr);
		label("14) Tapped: 'Send: <AutocashIn> - Value : "+autoCashInValueStr);
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		
		//step 15 Amount AutoCashIn - Tap Continue
		logger.info("Creazione Drop - step 15 - Tap - Drop Rule Continue ");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/flowContinueBtn")));
		MobileElement amountAutoCashContinue = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/flowContinueBtn"));
		amountAutoCashContinue.click();
		label("15) Tapped: 'Tap -Drop Rule Continue'");
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		
		//QUESTA SCHERMATA COMPARE AUTOMATICAMENTE
		//step 16 drop Rule second Step - Tap Continue
		logger.info("Richiedi Ricarica - step 16 - drop Rule second Step Tap - Drop Rule Continue ");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/goalWalletCreateRulesBtn")));
		MobileElement dropRuleStep2Continue = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/goalWalletCreateRulesBtn"));
		dropRuleStep2Continue.click();
		label("16) Tapped: 'Tap -Drop Rule second Step Continue'");
		WaitOptions.waitOptions(Duration.ofSeconds(3));
		
		//step 17 drop Rule - Check Result Title Continue
		logger.info("Creazione Drop - step 17 - Tap - Drop Check Result ");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/goalWalletDetailToolbarTitle")));
		MobileElement titleDropCreated = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/goalWalletDetailToolbarTitle"));
		String titleDrop = titleDropCreated.getText();
		label("17) Tapped: Check - Drop Result Title : "+titleDrop);
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		
		//step 18 Click Back 
		logger.info("Creazione Drop - step 18 - Tap - Drop Rule Continue ");
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/goalWalletDetailToolbarBack")));
		MobileElement btnBackToHome1 = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/goalWalletDetailToolbarBack"));
		btnBackToHome1.click();
		label("18) Tapped: Tap - Back Btn");
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		
		
		//19 verifica popup vota per flowe
		Thread.sleep(2000);
		List<MobileElement> elementListVote = driver.findElements(By.id("bm0.zero.tier2:id/floweFeedbackDialogCloseBtn"));
		if(elementListVote.size()>0){
			logger.info("Ricarica Conto - Step 19 - Modal Vota L'app NOT Show ");
			wait.until(ExpectedConditions.elementToBeClickable(By
					.id("bm0.zero.tier2:id/floweFeedbackDialogCloseBtn")));
			MobileElement voteFlowePopUpX = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/floweFeedbackDialogCloseBtn"));
			voteFlowePopUpX.click();
			label("19.1) Tap: 'Modal Vota L'app NOT Show'");
		}
		else{
			System.out.println("Modal Vota L'app NOT Show");
			logger.info("Ricarica Conto - Step6.0) Modal Vota L'app NOT Show");
			label("19.1) Tapped: 'Modal Vota L'app NOT Show'");
		}
		
			
		
		//step 20 attendi che il saldo sia visibile
		logger.info("Creazione Drop - step 20 - Wait - HomeUserBalance - END DROP TEST ");		
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("bm0.zero.tier2:id/homeUserBalance")));
		label("20) END TEST : DROP wait: 'HomeUserBalance'");
	
		
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

    public void deleteDrop(String telephonenumb, String wrongPasscode , String errorMex , String correctPasscode) {

    	logger.info("START REAL TEST : < wrong Passcode >");
    	
    	//step 1 click ho gia un account (login)
    	logger.info("Scenario) Login nuovo numero - Step 1) click ho gia un account");
    	MobileElement loginIn = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/btn_welcome_login"));			
		loginIn.click();
		//driver.findElementByAccessibilityId("LoginEntry").sendKeys(username);
		label("1) Tapped: 'Sign in'");
		

    }
}
