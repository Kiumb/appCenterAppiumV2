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
public class Test_4_Drop extends BaseTestFixture{
	
	static Date date = new Date();      
    static String LogDate= new SimpleDateFormat("yyyyMMdd").format(date);
	
	private static final Logger logger = LogManager.getLogger(Test_4_Drop.class);

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
    
 

    
    @Test
    public void test_1_DropCreationWithAutoCashIn() throws InterruptedException {
    	logger.info("***start test == testLoginWithCredentials ****");
        new LoginPage()
        //enterCredentials(String phoneNumber, String passCode, String smsCode, String securityToken) 
                .enterCredentials("1111110611", "00000", "123456", "00000")
                .tapHomeButton();
        new Drop()
		.dropCreation("Drop", "10", "1");
    }
    

    
    
    
    
    
    
    
}