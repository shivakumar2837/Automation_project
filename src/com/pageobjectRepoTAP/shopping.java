package com.pageobjectRepoTAP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.genericLib.Browser;
import com.genericLib.webdrivercommlib;

public class shopping {
	
	//selecting tshirt and finding webelements
	
	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[3]/a")
	private WebElement Tshirt;
	@FindBy(xpath="//*[@id=\"layered_id_feature_11\"]")
	private WebElement style;
	@FindBy(xpath="//*[@id=\"layered_id_feature_5\"]")
	private WebElement compositions;
	@FindBy(xpath="//*[@id=\"layered_id_attribute_group_1\"]")
	private WebElement size;
	@FindBy(xpath="//*[@id=\"selectProductSort\"]")
	private WebElement sortby;
	@FindBy(xpath="//*[@id=\"add_to_cart\"]/button/span")
	private WebElement cart;
	@FindBy(xpath="//*[@id=\"wishlist_button\"]")
	private WebElement wishlist;
	
	@FindBy(xpath="//*[@id=\"product\"]/div[2]/div/div/a")
	private WebElement cncelwishlist;
	
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
	private WebElement proceedcheckout;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
	private WebElement image;
	
	
	
	public void shoppingcart() throws InterruptedException {
		
		Tshirt.click();
		webdrivercommlib l=new webdrivercommlib();
		l.Implicitwait();
		boolean isSelected=size.isSelected();
		if(isSelected==false) {size.click();}
		l.Implicitwait();
		boolean isSelected1= compositions.isSelected();
		if(isSelected1==false) { compositions.click();}
		l.Implicitwait();
		boolean isSelected2=style.isSelected();
		if(isSelected2==false) {style.click();}
		l.Implicitwait();
		
		Select s=new Select(sortby);
		s.selectByIndex(1);
		l.Implicitwait();
		image.click();
		Thread.sleep(2000);
		Browser.driver.navigate().to("http://automationpractice.com/index.php?id_product=1&controller=product"); 
		wishlist.click();
		l.Implicitwait();
		cncelwishlist.click();
		l.Implicitwait();
		
		cart.click();
		Thread.sleep(1000);
		proceedcheckout.click();
		l.Implicitwait();
		
		
		
		
		
	}

}
