package com.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookingConfirmationPage extends BaseClass {
	
	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//td[contains(text(),'Booking Confirmation ')]")
	private WebElement adMsgBookingConfirmation;
	
	@FindBy(id="order_no")
	private WebElement adOrderNo;

	public WebElement getAdMsgBookingConfirmation() {
		return adMsgBookingConfirmation;
	}

	public WebElement getAdOrderNo() {
		return adOrderNo;
	}
	
    public void bookingConfirmation() throws IOException {
		
    	String OrderNo = getValueTextbox(getAdOrderNo());
    	System.out.println(OrderNo);
    	writeCellData("Adactin", 1, 9, OrderNo);
    	try {
    		scrollDownJs(adOrderNo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			}
        
        takeScreenshot("");
    	
    	
	}
}
