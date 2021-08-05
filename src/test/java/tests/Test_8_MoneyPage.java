package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runners.MethodSorters;

import com.microsoft.appcenter.appium.Factory;

import global.BaseTestFixture;
import pages.LoginPage;
import pages.MoneyPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_8_MoneyPage extends BaseTestFixture{
	
	private static final Logger logger = LogManager.getLogger(Test_8_MoneyPage.class);

    @Rule
    public TestWatcher watcher = Factory.createWatcher();

    @Override
    public void beforeEachTest()
    {
        start();
    }

    @After
    public void TearDown(){
        driver.quit();
    }
    
    @Test
    public void test_1_CreaGruppoSpesa() throws InterruptedException {
    	logger.info("***start test == testLoginWithCredentials ****");
        new LoginPage()
                .enterCredentials("1111110611", "00000", "123456", "00000")
                .tapHomeButton();
        
    	logger.info("***start test == testCreaGruppoSpesa ****");
    	new MoneyPage()
    			.creaGruppoSpesa("GRUPPOTEST");
    			
    }
}
