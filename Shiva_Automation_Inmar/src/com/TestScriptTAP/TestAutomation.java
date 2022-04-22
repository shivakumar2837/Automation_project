package com.TestScriptTAP;

import java.io.File;
//import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import com.relevantcodes.extentreports.ExtentTest;

import com.relevantcodes.extentreports.LogStatus;

import com.genericLib.Browser;
import com.genericLib.ExcelLib;
import com.genericLib.Screenshot;
import com.genericLib.log1;
import com.genericLib.webdrivercommlib;
import com.pageobjectRepoTAP.Main_Page;
import com.pageobjectRepoTAP.SignIn_Page;
import com.pageobjectRepoTAP.payment;
import com.pageobjectRepoTAP.register;
import com.pageobjectRepoTAP.shopping;

import junit.framework.Assert;
@Listeners(Screenshot.class)
public class TestAutomation {
	ExcelLib elib=new ExcelLib();
	webdrivercommlib wblib=new webdrivercommlib();
	WebDriver driver;
	SignIn_Page loginpage;
	Main_Page mainpage;
	register registrationpage;
	shopping shop;
	 payment pay;
	//Search_Result_Page search;
	static String value =null;
	//public String Firstname;
	//public String Lastname;
	
@BeforeTest
public void extendreport()
{
	//Browser.report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	//File dst=new File("C:\\Screen\\"+filename+"____"+timeStamp+".png");
	String dst1="report"+timeStamp;
	Browser.report = new ExtentReports(System.getProperty("user.dir")+"\\ExtendReports\\"+dst1+"\\ExtentReportResults.html");
	

}
	
@BeforeClass
	public void bfrcls(){
		driver=Browser.getbrowser();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	    loginpage=	PageFactory.initElements(driver,SignIn_Page.class);
	    mainpage=	PageFactory.initElements(driver,Main_Page.class);
	    registrationpage=	PageFactory.initElements(driver,register.class);
	
	 shop=PageFactory.initElements(driver,shopping.class);
	 pay= PageFactory.initElements(driver,payment.class);
	 log1.configure();
	 log1.info("Test Case execution for automation project.");

}

	
	@Test
	public void MD_Indexing_TC01() throws InvalidFormatException, IOException, Exception
	{
//		   this method is for testing valid flow.
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	    StackTraceElement e = stacktrace[1];
	    value = e.getMethodName();
	    Browser.test = Browser.report.startTest(value);
	    mainpage.check_main_page();
	    mainpage.Click_sign();
	    loginpage.check_signin_page();
	    loginpage.create_account("testshivanelllutl@gmail.com");
	    Thread.sleep(3000);
	    String Firstname= elib.getExceldata("DataSheet.xlsx","sheet1",1,0);
		String Lastname=elib.getExceldata("DataSheet.xlsx","sheet1",1,1);
	    registrationpage.enter_firstname(Firstname);
		registrationpage.enter_lastname(Lastname);
	    registrationpage.enter_password("Svvsa@98480");
	    registrationpage.enter_address("hyd");
	    registrationpage.enter_city("telangana");
	    registrationpage.select_country();
	    registrationpage.select_state();
	    registrationpage.enter_mobilenumber("9573596918");
	    registrationpage.enter_zipcode("12345");
	    registrationpage.enter_address("karmanghat");
	    registrationpage.enter_alias_address("HYD");
	    registrationpage.registerclick();
	 Thread.sleep(2000);
	 //loginpage.login("akhilesh123@gmail.com", "Svvsa@98480");
	shop.shoppingcart();
	pay.pay();
	log1.info(value+" test case passed successfully");
	Browser.test.log(LogStatus.PASS, "valid flow");

}

	@Test
	public void MD_Indexing_TC02() throws InvalidFormatException, IOException, Exception
	{
		  // this method is for testing invalid  createaccount.
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	    StackTraceElement e = stacktrace[1];
	    value = e.getMethodName();
	    Browser.test = Browser.report.startTest(value);
	    mainpage.check_main_page();
	    mainpage.Click_sign();
	    loginpage.check_signin_page();
	    loginpage.create_account("invalid");
	    Thread.sleep(3000);
	    loginpage.invalid_email_notification();
	    log1.info(value+" test case passed successfully");
		Browser.test.log(LogStatus.PASS, "invalid Account Create");

}
	
	@Test
	public void MD_Indexing_TC03() throws InvalidFormatException, IOException, Exception
	{
		  // this method is for testing login flow.
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	    StackTraceElement e = stacktrace[1];
	    value = e.getMethodName();
	    Browser.test = Browser.report.startTest(value);
	    mainpage.check_main_page();
	    mainpage.Click_sign();
	    loginpage.check_signin_page();
	    // Empty user name and password
	    loginpage.login("", "");
	    loginpage.error_notification();
	    // no password 
	    loginpage.login("s@gmail.com", "");
	    loginpage.error_notification();
	    // no email id
	    loginpage.login("", "password@123");
	    loginpage.error_notification();
	    // invalid password
	    loginpage.login("shiva97.nlt@gmail.com", "invalid_password");
	    loginpage.error_notification();
	    
	    // valid password
	    loginpage.login("s@gmail.com", "Password@123");
	    loginpage.error_notification();
	    log1.info(value+" test case passed successfully");
		Browser.test.log(LogStatus.PASS, "invalid login scenarios");

	    
	    
	   
}
	
	@Test
	public void MD_Indexing_TC04() throws InvalidFormatException, IOException, Exception
	{
//		  this method is for testing registration invalid  flow.
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	    StackTraceElement e = stacktrace[1];
	    value = e.getMethodName();
	    Browser.test = Browser.report.startTest(value);
	    mainpage.check_main_page();
	    mainpage.Click_sign();
	    loginpage.check_signin_page();
	    loginpage.create_account("srikhhu22uio@gmail.com");
	    Thread.sleep(3000);
	    registrationpage.enter_firstname("");
		registrationpage.enter_lastname("");
	    registrationpage.enter_password("");
	    registrationpage.enter_address("");
	    registrationpage.enter_city("");
	    registrationpage.select_country();
	    registrationpage.select_state();
	    registrationpage.enter_mobilenumber("");
	    registrationpage.enter_zipcode("");
	    registrationpage.enter_address("");
	    registrationpage.enter_alias_address("");
	    registrationpage.registerclick();
	    Thread.sleep(1000);
	    registrationpage.register_error_notification();
	    log1.info(value+" test case passed successfully");
		Browser.test.log(LogStatus.PASS, "invalid registraition flow");

}



	
	@AfterMethod
    public void TearDown(ITestResult result) throws IOException
    {
         if(ITestResult.FAILURE == result.getStatus())
           {
           log1.warn(value+" test case failed.**");
          Browser.test.log(LogStatus.FAIL,Browser.test.addScreenCapture(capture(driver))+ "Test Failed");

           }
    }
	
	public static String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("src/../ErrImages/" + System.currentTimeMillis()+ ".png");
	String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
	}

	
	@AfterClass
	public void last()
	{
		Browser.report.endTest(Browser.test);
		
		Browser.report.flush();

		log1.info("Test Case execution for automation_project completed.");
		driver.close();
		
		
	}
	@AfterTest
	public void last_quit()
	{
		
		driver.close();
		
	}
	
}
