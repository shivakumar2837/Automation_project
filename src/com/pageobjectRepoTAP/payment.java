package com.pageobjectRepoTAP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.genericLib.webdrivercommlib;

public class payment {
	//finding webelements for payment

	@FindBy(xpath="//*[@id=\"center_column\"]/p[2]/a[1]/span")
	private WebElement summarypaycheckout;
	@FindBy(xpath="//*[@id=\"center_column\"]/form/p/button/span")
	private WebElement addresspaycheckout;
	@FindBy(xpath="//*[@id=\"cgv\"]")
	private WebElement shippingcheckbox;
	@FindBy(xpath="//*[@id=\"form\"]/p/button/span")
	private WebElement shippingpaycheckout;
	@FindBy(xpath="//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")
	private WebElement paymentpaycheck;
	@FindBy(xpath="//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
	private WebElement paymentpaybank;
	@FindBy(xpath="//*[@id=\"cart_navigation\"]/button/span")
	private WebElement confirmorder;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
	private WebElement signout;
	
	
	
	
	public void pay()  {
		webdrivercommlib l=new webdrivercommlib();
		l.Implicitwait();
		summarypaycheckout.click();
		l.Implicitwait();
		addresspaycheckout.click();
		l.Implicitwait();
		boolean isSelected=shippingcheckbox.isSelected();
		if(isSelected==false) {shippingcheckbox.click();}
		l.Implicitwait();
		shippingpaycheckout.click();
		l.Implicitwait();
		paymentpaycheck.click();
		l.Implicitwait();
		confirmorder.click();
		signout.click();
		
	}
	
}
