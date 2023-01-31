package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SelectHotelPage extends BaseClass{
	
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(id="radiobutton_0")
	private WebElement btnRadio;
	
	@FindBy(id="continue")
	private WebElement btnContinue;
	
	@FindBy(xpath="//td[text()='Select Hotel ']")
	private WebElement adSelectHotel;

	public WebElement getBtnRadio() {
		return btnRadio;
	}

	public WebElement getAdSelectHotel() {
		return adSelectHotel;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}
	 
	public void selectHotel() {
		
		click(getBtnRadio());
		click(getBtnContinue());

	}

}
