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

public class CashStreamPage extends EvolveBasePage {

	static Date date = new Date();
	static String logDate = new SimpleDateFormat("yyyyMMddHHmmss").format(date);

	private static final Logger logger = LogManager.getLogger(CashStreamPage.class);

	@Rule
	public TestWatcher watcher = Factory.createWatcher();

	public CashStreamPage() {
	}

	@Override
	public PlatformQuery trait() {
		return new PlatformQuery().setAndroid(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView"))
				.setiOS(By.id("Login"));
	}

	public CashStreamPage testFiltriCashStream(String toSearch, String tipologia, String categoria, String tag,
			boolean isOutTransaction) throws InterruptedException {
		logger.info("START REAL TEST : < testFiltriCashStream >");

		logger.info("Scenario ) Test Filtri Cash Stream ");
		label("< TEST FILTRI CASH STREAM STARTED >");

		// step 1 click money
		logger.info("Filtri Cash Stream - Step 1 - Tap Btn Home ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/homeFragment")));
		MobileElement homeButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/homeFragment"));
		homeButton.click();
		label("1) Tapped: 'Btn Home'");

		// step 2 scroll fino a Cash Stream
		logger.info("Filtri Cash Stream - Step 2 - Scroll Cash Stream ");
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().className(\"android.widget.Button\").textContains(\"Vedi tutto\").instance(0))");
		label("2) Scroll: 'Btn Cash Stream'");

		// step 3 click vedi tutto
		logger.info("Filtri Cash Stream - Step 3 - Tap Btn Vedi tutto ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/lifeStreamSeeAll")));
		MobileElement seeAllButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/lifeStreamSeeAll"));
		seeAllButton.click();
		label("3) Tapped: 'Btn Vedi tutto'");

		if (isOutTransaction) {
			// step 3.5 click Uscite
			logger.info("Filtri Cash Stream - Step 3.5 - Tap Btn Uscite ");
			wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/outBtn")));
			MobileElement outButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/outBtn"));
			outButton.click();
			label("3.5) Tapped: 'Btn Uscite'");
		}

		// step 4 send testo da cercare
		logger.info("Filtri Cash Stream - Step 4 - Send testo da cercare " + toSearch);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/addressBook_search_text_cash_in")));
		MobileElement toSearchEl = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/addressBook_search_text_cash_in"));
		toSearchEl.sendKeys(toSearch);
		label("4) Sent: 'Testo da cercare '" + toSearch);

		Thread.sleep(2000);

		// step 5 check risultato aspettato
		logger.info("Filtri Cash Stream - Step 5 - Check risultato aspettato " + toSearch);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/transactionItemDescription")));
		MobileElement checkEl = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/transactionItemDescription"));
		String toCheck = checkEl.getText();
		label("5) Check: 'Risultato aspettato '" + toSearch + "'Risultato ottenuto '" + toCheck);

		// step 6 click svuota testo
		logger.info("Filtri Cash Stream - Step 6 - Tap Btn ClearText ");
		wait.until(ExpectedConditions
				.elementToBeClickable(By.id("bm0.zero.tier2:id/addressBook_search_delete_icon_cash_in")));
		MobileElement clearTextButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/addressBook_search_delete_icon_cash_in"));
		clearTextButton.click();
		label("6) Tapped: 'Btn ClearText'");

		// step 7 click ingranaggi
		logger.info("Filtri Cash Stream - Step 7 - Tap Btn Ingranaggi ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/cashStreamSearchFilter")));
		MobileElement settingsButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/cashStreamSearchFilter"));
		settingsButton.click();
		label("7) Tapped: 'Btn Ingranaggi'");

		// step 8 click Tipologia
		logger.info("Filtri Cash Stream - Step 8 - Tap Btn Tipologia ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[2]/android.view.ViewGroup")));
		MobileElement typeButton = (MobileElement) driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[2]/android.view.ViewGroup"));
		typeButton.click();
		label("8) Tapped: 'Btn Tipologia'");

		// step 9 scroll fino a tipologia
		logger.info("Filtri Cash Stream - Step 9 - Scroll Tipologia " + tipologia);
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ tipologia + "\").instance(0))");
		label("9) Scroll: 'Search Type' " + tipologia);

		// step 10 click tipologia selezionata
		logger.info("Filtri Cash Stream - Step 10 - Tap Tipologia " + tipologia);
		MobileElement typeSelectedButton = (MobileElement) driver.findElement(
				By.xpath("//android.widget.TextView[contains(lower-case(@text),'" + tipologia.toLowerCase() + "')]"));
		typeSelectedButton.click();
		label("10) Tapped: 'Btn Tipologia' " + tipologia);

		// step 11 click imposta
		logger.info("Filtri Cash Stream - Step 11 - Tap Btn Imposta ");
		TouchAction tapElement = new TouchAction(driver);

		tapElement.tap(new PointOption().point(500, 2060)).perform();
		label("11) Tapped: Btn Imposta ");

		Thread.sleep(2000);

		// step 12 check risultato aspettato
		logger.info("Filtri Cash Stream - Step 12 - Check risultato aspettato " + tipologia);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.TextView[1]")));
		MobileElement checkTypeEl = (MobileElement) driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.TextView[1]"));
		String toCheckType = checkTypeEl.getText();
		label("12) Check: 'Risultato aspettato '" + tipologia + "'Risultato ottenuto '" + toCheckType);

		// step 13 click ingranaggi
		logger.info("Filtri Cash Stream - Step 13 - Tap Btn Ingranaggi ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/cashStreamSearchFilter")));
		MobileElement settingsTypeButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/cashStreamSearchFilter"));
		settingsTypeButton.click();
		label("13) Tapped: 'Btn Ingranaggi'");

		// step 14 click Annulla
		logger.info("Filtri Cash Stream - Step 14 - Tap Btn Annulla ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/cashStreamFiltersCancel")));
		MobileElement clearFilterButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/cashStreamFiltersCancel"));
		clearFilterButton.click();
		label("14) Tapped: 'Btn Annulla'");

		// step 15 click Tipologia
		logger.info("Filtri Cash Stream - Step 15 - Tap Btn Tipologia ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[2]/android.view.ViewGroup")));
		MobileElement typeCloseButton = (MobileElement) driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[2]/android.view.ViewGroup"));
		typeCloseButton.click();
		label("15) Tapped: 'Btn Tipologia'");

		// step 16 click Categoria
		logger.info("Filtri Cash Stream - Step 16 - Tap Btn Categoria ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[3]/android.view.ViewGroup")));
		MobileElement categoryButton = (MobileElement) driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[3]/android.view.ViewGroup"));
		categoryButton.click();
		label("16) Tapped: 'Btn Categoria'");

		// step 17 click Categoria selezionata
		logger.info("Filtri Cash Stream - Step 17 - Tap Btn Categoria " + categoria);
		MobileElement categorySelectedButton = (MobileElement) driver.findElement(
				By.xpath("//android.widget.TextView[contains(lower-case(@text),'" + categoria.toLowerCase() + "')]"));
		categorySelectedButton.click();
		label("17) Tapped: 'Btn Categoria'" + categoria);

		// step 18 click imposta
		logger.info("Filtri Cash Stream - Step 18 - Tap Btn Imposta ");

		tapElement.tap(new PointOption().point(500, 2060)).perform();
		label("18) Tapped: Btn Imposta ");

		Thread.sleep(2000);

		// step 19 click Categoria elemento
		logger.info("Filtri Cash Stream - Step 19 - Tap Btn Categoria elemento");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.view.ViewGroup")));
		MobileElement categoryElementButton = (MobileElement) driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.view.ViewGroup"));
		categoryElementButton.click();
		label("19) Tapped: 'Btn Categoria elemento'");

		// step 20 check risultato aspettato
		logger.info("Filtri Cash Stream - Step 20 - Check risultato aspettato " + categoria);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/category_type")));
		MobileElement checkCategoryEl = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/category_type"));
		String toCheckCategory = checkCategoryEl.getText();
		label("20) Check: 'Risultato aspettato '" + categoria + "'Risultato ottenuto '" + toCheckCategory);

		// step 21 click tasto indietro
		logger.info("Filtri Cash Stream - Step 21 - Tap Btn Back From Type ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/cashStreamBackBtn")));
		MobileElement backFromTypeButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/cashStreamBackBtn"));
		backFromTypeButton.click();
		label("21) Tapped: 'Btn Back From Type'");

		// step 22 click ingranaggi
		logger.info("Filtri Cash Stream - Step 22 - Tap Btn Ingranaggi ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/cashStreamSearchFilter")));
		MobileElement settingsCategoryButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/cashStreamSearchFilter"));
		settingsCategoryButton.click();
		label("22) Tapped: 'Btn Ingranaggi'");

		// step 23 click Annulla
		logger.info("Filtri Cash Stream - Step 23 - Tap Btn Annulla ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/cashStreamFiltersCancel")));
		MobileElement clearFilterCategoryButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/cashStreamFiltersCancel"));
		clearFilterCategoryButton.click();
		label("23) Tapped: 'Btn Annulla'");

		// step 24 click Categoria
		logger.info("Filtri Cash Stream - Step 24 - Tap Btn Categoria ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[3]/android.view.ViewGroup")));
		MobileElement categoryCloseButton = (MobileElement) driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[3]/android.view.ViewGroup"));
		categoryCloseButton.click();
		label("24) Tapped: 'Btn Categoria'");

		// step 25 click Tag
		logger.info("Filtri Cash Stream - Step 25 - Tap Btn Tag ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[4]/android.view.ViewGroup")));
		MobileElement tagButton = (MobileElement) driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[4]/android.view.ViewGroup"));
		tagButton.click();
		label("25) Tapped: 'Btn Tag'");

		// step 26 click Tag selezionata
		logger.info("Filtri Cash Stream - Step 26 - Tap Btn Tag " + tag);
		MobileElement tagSelectedButton = (MobileElement) driver.findElement(
				By.xpath("//android.widget.CompoundButton[contains(lower-case(@text),'" + tag.toLowerCase() + "')]"));
		tagSelectedButton.click();
		label("26) Tapped: 'Btn tag'" + tag);

		// step 27 click imposta
		logger.info("Filtri Cash Stream - Step 27 - Tap Btn Imposta ");

		tapElement.tap(new PointOption().point(500, 2060)).perform();
		label("27) Tapped: Btn Imposta ");

		Thread.sleep(2000);

		// step 28 click Tag elemento
		logger.info("Filtri Cash Stream - Step 28 - Tap Btn Tag elemento");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.view.ViewGroup")));
		MobileElement tagElementButton = (MobileElement) driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.view.ViewGroup"));
		tagElementButton.click();
		label("28) Tapped: 'Btn Tag elemento'");

		// step 28.1 scroll Tag edit
		logger.info("Filtri Cash Stream - Step 28.1 - Scroll fino a Tag Edit ");
		WaitOptions.waitOptions(Duration.ofSeconds(1));
		((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Tag\").instance(0))");
		label("28.1) Scroll: 'Ricerca Tag Edit'");

		// step 29 click Tag edit
		logger.info("Filtri Cash Stream - Step 29 - Tap Btn Tag edit");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/cashStreamDetailTagImg")));
		MobileElement tagEditButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/cashStreamDetailTagImg"));
		tagEditButton.click();
		label("29) Tapped: 'Btn Tag edit'");

		// step 30 check risultato aspettato
		logger.info("Filtri Cash Stream - Step 30 - Check risultato aspettato " + tag);
		MobileElement checkTagEl = (MobileElement) driver.findElement(
				By.xpath("//android.widget.TextView[contains(lower-case(@text),'" + tag.toLowerCase() + "')]"));
		String toCheckTag = checkTagEl.getText();
		label("30) Check: 'Risultato aspettato '" + tag + "'Risultato ottenuto '" + toCheckTag);

		// step 31 click Tag save
		logger.info("Filtri Cash Stream - Step 31 - Tap Btn Tag save");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/tagBottomSheetSave")));
		MobileElement tagSaveButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/tagBottomSheetSave"));
		tagSaveButton.click();
		label("31) Tapped: 'Btn Tag save'");

		// step 32 click tasto indietro
		logger.info("Filtri Cash Stream - Step 32 - Tap Btn Back From Tag ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/cashStreamBackBtn")));
		MobileElement backFromTagButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/cashStreamBackBtn"));
		backFromTagButton.click();
		label("32) Tapped: 'Btn Back From Tag'");

		// step 33 click ingranaggi
		logger.info("Filtri Cash Stream - Step 33 - Tap Btn Ingranaggi ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/cashStreamSearchFilter")));
		MobileElement settingsTagButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/cashStreamSearchFilter"));
		settingsTagButton.click();
		label("33) Tapped: 'Btn Ingranaggi'");

		// step 34 click Annulla
		logger.info("Filtri Cash Stream - Step 34 - Tap Btn Annulla ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/cashStreamFiltersCancel")));
		MobileElement clearFilterTagButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/cashStreamFiltersCancel"));
		clearFilterTagButton.click();
		label("34) Tapped: 'Btn Annulla'");

		// step 35 click Tag
		logger.info("Filtri Cash Stream - Step 35 - Tap Btn Tag ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[4]/android.view.ViewGroup")));
		MobileElement tagCloseButton = (MobileElement) driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[4]/android.view.ViewGroup"));
		tagCloseButton.click();
		label("35) Tapped: 'Btn Tag'");

		// step 36 click Periodo
		logger.info("Filtri Cash Stream - Step 36 - Tap Btn Periodo ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[1]/android.view.ViewGroup")));
		MobileElement periodButton = (MobileElement) driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[1]/android.view.ViewGroup"));
		periodButton.click();
		label("36) Tapped: 'Btn Periodo'");

		// step 37 click Periodo specifico
		logger.info("Filtri Cash Stream - Step 37 - Tap Btn Periodo Specifico ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout")));
		MobileElement periodPersonalizedButton = (MobileElement) driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout"));
		periodPersonalizedButton.click();
		label("37) Tapped: 'Btn Periodo specifico'");

		// step 38 click Periodo A
		logger.info("Filtri Cash Stream - Step 38 - Tap Btn Periodo A ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.EditText")));
		MobileElement periodToButton = (MobileElement) driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.EditText"));
		periodToButton.click();
		label("38) Tapped: 'Btn Periodo A'");

		// step 39 click Prev Month
		logger.info("Filtri Cash Stream - Step 39 - Tap Btn Prev Month ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/mdtp_previous_month_arrow")));
		MobileElement prevMonthButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/mdtp_previous_month_arrow"));
		prevMonthButton.click();
		label("39) Tapped: 'Btn Prev Month'");

		// step 40 click Last day
		logger.info("Filtri Cash Stream - Step 40 - Tap Btn Last Day ");
		MobileElement lastDayButton = (MobileElement) driver
				.findElement(By.xpath("//android.view.View[contains(lower-case(@content-desc),'" + "28" + "')]"));
		lastDayButton.click();
		label("40) Tapped: 'Btn Last Day'");

		// step 41 click CalendarOK
		logger.info("Filtri Cash Stream - Step 41 - Tap Btn CalendarOK ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/mdtp_ok")));
		MobileElement calendarOKButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/mdtp_ok"));
		calendarOKButton.click();
		label("41) Tapped: 'Btn CalendarOK'");

		// step 42 click Periodo DA
		logger.info("Filtri Cash Stream - Step 42 - Tap Btn Periodo DA ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.EditText")));
		MobileElement periodFromButton = (MobileElement) driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.EditText"));
		periodFromButton.click();
		label("42) Tapped: 'Btn Periodo DA'");

		// step 42 click Prev Month
		logger.info("Filtri Cash Stream - Step 42 - Tap Btn Prev Month ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/mdtp_previous_month_arrow")));
		MobileElement prevMonthFromButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/mdtp_previous_month_arrow"));
		prevMonthFromButton.click();
		label("42) Tapped: 'Btn Prev Month'");

		// step 43 click Last day
		logger.info("Filtri Cash Stream - Step 43 - Tap Btn Last Day ");
		MobileElement lastDayFromButton = (MobileElement) driver
				.findElement(By.xpath("//android.view.View[contains(lower-case(@content-desc),'" + "28" + "')]"));
		lastDayFromButton.click();
		label("43) Tapped: 'Btn Last Day'");

		// step 44 click CalendarOK
		logger.info("Filtri Cash Stream - Step 44 - Tap Btn CalendarOK ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/mdtp_ok")));
		MobileElement calendarOKFromButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/mdtp_ok"));
		calendarOKFromButton.click();
		label("44) Tapped: 'Btn CalendarOK'");

		// step 45 click imposta
		logger.info("Filtri Cash Stream - Step 45 - Tap Btn Imposta ");

		tapElement.tap(new PointOption().point(500, 2060)).perform();
		label("45) Tapped: Btn Imposta ");

		Thread.sleep(2000);

		// step 46 check risultato aspettato
		logger.info("Filtri Cash Stream - Step 46 - Check risultato aspettato ");
		MobileElement checkDateEl = (MobileElement) driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		String toCheckDate = checkTagEl.getText();
		label("46) Check: 'Risultato aspettato '" + "28" + "'Risultato ottenuto '" + toCheckDate);

		// step 47 click rimuovi filtri
		logger.info("Filtri Cash Stream - Step 47 - Tap Btn Rimuovi filtri ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/cashStreamDisableFilters")));
		MobileElement removeFilterButton = (MobileElement) driver
				.findElement(By.id("bm0.zero.tier2:id/cashStreamDisableFilters"));
		removeFilterButton.click();
		label("47) Tapped: 'Btn Rimuovi filtri'");

		// step 48 click back
		logger.info("Filtri Cash Stream - Step 48 - Tap Btn Back ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/cashStreamBackBtn")));
		MobileElement backButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/cashStreamBackBtn"));
		backButton.click();
		label("48) Tapped: 'Btn Back'");

		// step 49 click money
		logger.info("Filtri Cash Stream - Step 49 - Tap Btn Money ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/moneyFragment")));
		MobileElement moneyButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/moneyFragment"));
		moneyButton.click();
		label("49) Tapped: 'Btn Money'");

		// step 50 click home reset
		logger.info("Filtri Cash Stream - Step 50 - Tap Btn Home Reset ");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bm0.zero.tier2:id/homeFragment")));
		MobileElement homeResetButton = (MobileElement) driver.findElement(By.id("bm0.zero.tier2:id/homeFragment"));
		homeResetButton.click();
		label("50) Tapped: 'Btn Home Reset'");

		logger.info("END REAL TEST : < testFiltriCashStream >");

		return this;
	}
}
