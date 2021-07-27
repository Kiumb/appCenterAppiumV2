package tests;

import com.microsoft.appcenter.appium.Factory;
import com.microsoft.appcenter.appium.EnhancedIOSDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.rules.TestWatcher;
import org.junit.runners.MethodSorters;
import org.junit.Rule;
import global.*;
import org.junit.Test;
import pages.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_1_LogIn extends BaseTestFixture{
	
	static Date date = new Date();      
    static String LogDate= new SimpleDateFormat("yyyyMMdd").format(date);
	
	private static final Logger logger = LogManager.getLogger(Test_1_LogIn.class);

    @Rule
    public TestWatcher watcher = Factory.createWatcher();

    @Override
    public void beforeEachTest()
    {
//    	System.setProperty("logFilename", LogDate);
//    	logger.info("");
//    	logger.info("******************************************************");
//		logger.info("System property : " +System.getProperty("logFilename"));
        start();
    }

    @After
    public void TearDown(){
        driver.quit();
    }
    
    //test Login funzionanti

    @Test
    public void test_1_LoginWithCredentials() throws InterruptedException {
    	logger.info("***start test == testLoginWithCredentials ****");
        new LoginPage()
        //enterCredentials(String phoneNumber, String passCode, String smsCode, String securityToken) 
                .enterCredentials("1111110611", "00000", "123456", "00000")
                .tapHomeButton();
    }

    @Test
    public void test_2_LoginFailed()
    {
    	logger.info("***start test == tapSignInButton ****");
        new LoginPage().wrongPasscode("1111110604", "54321", "Passcode errato. Forse qualche errore di battitura?" , "00000");
    }
   
    
    
}