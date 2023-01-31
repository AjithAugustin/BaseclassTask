package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookHotelPage extends BaseClass{
	
	public BookHotelPage() {
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//td[text()='Book A Hotel ']")
	private WebElement adMsgBookAHotel;
	
	@FindBy(id="first_name")
	private WebElement adFirstName;

	@FindBy(id="last_name")
	private WebElement adLastName;
	
	@FindBy(id="address")
	private WebElement adAddress;
	
	@FindBy(id="cc_num")
	private WebElement adCCNum;
	
	@FindBy(id="cc_type")
	private WebElement adCCType;
	
	@FindBy(id="cc_exp_month")
	private WebElement adMonth;
	
	@FindBy(id="cc_exp_year")
	private WebElement adYear;
	
	@FindBy(id="cc_cvv")
	private WebElement adCVV;
	
	@FindBy(id="book_now")
	private WebElement adBookNow;
	
	public WebElement getAdMsgBookAHotel() {
		return adMsgBookAHotel;
	}

	public WebElement getAdFirstName() {
		return adFirstName;
	}

	public WebElement getAdLastName() {
		return adLastName;
	}

	public WebElement getAdAddress() {
		return adAddress;
	}

	public WebElement getAdCCNum() {
		return adCCNum;
	}

	public WebElement getAdCCType() {
		return adCCType;
	}

	public WebElement getAdMonth() {
		return adMonth;
	}

	public WebElement getAdYear() {
		return adYear;
	}

	public WebElement getAdCVV() {
		return adCVV;
	}

	public WebElement getAdBookNow() {
		return adBookNow;
	}
	
	public void BookHotel(String firstName,String lastName,String address,String ccNum,String ccType,String month,String year,String cVV) {
	
		sendKeys(getAdFirstName(), firstName);
		sendKeys(getAdLastName(), lastName);
		sendKeys(getAdAddress(), address);
		sendKeys(getAdCCNum(), ccNum);
		selectoptionByText(getAdCCType(), ccType);
		selectoptionByText(getAdMonth(), month);
		selectoptionByText(getAdYear(), year);
		sendKeys(getAdCVV(), cVV);
		click(getAdBookNow());
		

	}

}
