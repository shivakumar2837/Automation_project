package com.pageobjectRepoTAP;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.genericLib.Browser;
import com.genericLib.constnts;
import com.genericLib.webdrivercommlib;

public class SignIn_Page {
// Finding elements of sigin page
	
	@FindBy(xpath="//*[@id='email_create']")
	private WebElement usernameedt;
	
	
	@FindBy(xpath="//*[@id='SubmitCreate']/span")
	private WebElement loginbtn;
	
	
	@FindBy(xpath="//*[@id='login_form']/h3")
	private WebElement registerdalready;
	
	@FindBy(xpath="//*[@id=\"email\"]")
	private WebElement Emailsent;
	
	@FindBy(xpath="//*[@id=\"passwd\"]")
	private WebElement passwordsent;
	
	@FindBy(xpath="//*[@id=\"SubmitLogin\"]/span")
	private WebElement signinalready;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[3]")
	private WebElement header ;
	@FindBy(xpath="//*[@id=\"page\"]/div[3]")
	private WebElement footer;
	@FindBy(xpath="//*[@id=\"create-account_form\"]")
	private WebElement createaccount ;
	
	@FindBy(xpath="//*[@id=\"create_account_error\"]")
	private WebElement email_notification ;
	
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div[1]")
	private WebElement error_notification ;
	
	
	webdrivercommlib wb=new webdrivercommlib();
	
	
	public void check_signin_page() throws InterruptedException{
		//waiting for webpage elements to Load
		wb.explicitwait("/html/body/div/div[2]/div/div[3]/div");
		footer.isDisplayed();
		header.isDisplayed();
		createaccount.isDisplayed();
		registerdalready.isDisplayed();
	}
	
	
	public void create_account(String username) throws InterruptedException{
		//sending the value of the email
		
		 usernameedt.sendKeys(username);
		 loginbtn.click();
		 wb.Implicitwait();

		 
		
}
	public void invalid_email_notification() throws InterruptedException{
	
		//using explicit wait to get text on alert
		
		webdrivercommlib l=new webdrivercommlib();
		l.explicitwait("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[1]");
		String notification;
		notification=email_notification.getText();
		assertEquals(notification,"Invalid email address.");
		
		
		 
		
}
	

	//positive Scenario
	
	public void login(String username , String password) throws InterruptedException{
			
		//login with valid details for that navigate to signpage to check functionality.
			Emailsent.clear();
		    Emailsent.sendKeys(username);
			passwordsent.clear();
			passwordsent.sendKeys(password);
			signinalready.click();
			
				
	}
	
	public void error_notification() throws InterruptedException{
		
		//login with valid details for that navigate to signpage to check functionality.
		webdrivercommlib l=new webdrivercommlib();
		l.explicitwait("/html/body/div/div[2]/div/div[3]/div/div[1]");
		error_notification.isDisplayed();		
				
	}
	
}
	


