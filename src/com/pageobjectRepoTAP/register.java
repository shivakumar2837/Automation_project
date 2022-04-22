package com.pageobjectRepoTAP;


import java.io.IOException;

//import org.apache.bcel.generic.Select;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.genericLib.Browser;
import com.genericLib.ExcelLib;
import com.genericLib.constnts;
import com.genericLib.webdrivercommlib;

public class register {

	//Locating webelements of registerpage
	
	
	@FindBy(xpath="//*[@id=\"customer_firstname\"]")
	private WebElement FirstName;
	@FindBy(xpath="//*[@id=\"customer_lastname\"]")
	private WebElement LastName;
	@FindBy(xpath="//*[@id=\"passwd\"]")
	private WebElement Password;
	@FindBy(xpath="//*[@id=\"address1\"]")
	private WebElement Address;
	
	
	@FindBy(xpath="//*[@id=\"phone_mobile\"]")
	private WebElement Mobile;
	@FindBy(xpath="//*[@id=\"alias\"]")
	private WebElement Futureaddress;
	@FindBy(xpath="//*[@id=\"city\"]")
	private WebElement City;
	
	
	@FindBy(xpath="//*[@id=\"id_country\"]")
	private WebElement Country;
	@FindBy(xpath="//*[@id=\"id_state\"]")
	private WebElement state;
	@FindBy(xpath="//*[@id=\"submitAccount\"]/span")
	private WebElement registerdetails;
	@FindBy(xpath="//*[@id=\"postcode\"]")
	private WebElement Zipcode;
	@FindBy(xpath="//*[@id=\"id_gender1\"]")
	private WebElement radio;
	
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div")
	private WebElement error_notification;
	
	//providing respective values
	    public void check_radio() {radio.click();}
		public void enter_firstname(String firstname) {
			
			FirstName.sendKeys(firstname);
			
		}
		public void enter_lastname(String lastname) {
			LastName.sendKeys(lastname);
			
		}
		public void enter_password(String password) {
			Password.sendKeys(password);
			
		}

		public void enter_address(String address) {
			Address.sendKeys(address);
			
		}
		public void enter_city(String city) {
			City.sendKeys(city);
			
		}
		public void select_state() {
			Select h=new Select(state);
			h.selectByIndex(1);			
		}
		public void enter_zipcode(String zipcode) {
			Zipcode.sendKeys(zipcode);
			
		}
		public void select_country() {
		Select	h=new Select(Country);
			h.selectByIndex(1);			
		}
		public void enter_mobilenumber(String mobileno) {
			Mobile.sendKeys(mobileno);
			
		}
		public void enter_alias_address(String address) {
			Futureaddress.sendKeys(address);
			
		}
	//clicking register button
		
	public void registerclick() {
		registerdetails.click();
	}
	
	public void register_error_notification() {
//		webdrivercommlib l=new webdrivercommlib();
//		l.explicitwait("//*[@id=\\\"customer_firstname\\\"]");
		error_notification.isDisplayed();
	}
	
	

}
