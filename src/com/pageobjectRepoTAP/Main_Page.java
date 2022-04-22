package com.pageobjectRepoTAP;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.genericLib.Browser;
import com.genericLib.constnts;
import com.genericLib.webdrivercommlib;
import com.sun.glass.events.KeyEvent;

public class Main_Page {

	//Locating Header and Footer elements
	
	@FindBy(xpath="//*[@id=\"page\"]/div[3]")
	private WebElement Footer;
	@FindBy(xpath="//*[@id=\"page\"]/div[1]")
	private WebElement Header;
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	private WebElement sign;
	
	
	
	
	public void check_main_page() {
		//checking home page whether it is loading
		
		Browser.driver.get(constnts.url_b);
		//setting implicit wait.
		webdrivercommlib l=new webdrivercommlib();
		l.explicitwait("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a");;
        Header.isDisplayed();
		Footer.isDisplayed();
	}
   public void Click_sign()
   
   {//Navigating to signin page
	  
	   sign.click();
   }
	}

	

