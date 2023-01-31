package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class CancelBookingPage extends BaseClass {
	
	public CancelBookingPage() {
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement adBookedItinerary;
	
	@FindBy(id="order_id_text")
	private WebElement adOrderId;
	
	@FindBy(id="search_hotel_id")
	private WebElement adSearch;
	
	@FindBy(name="ids[]")
	private WebElement btnRadio;
	
	@FindBy(name = "cancelall")
	private WebElement BtnCancelSelect;
	
	@FindBy(id="search_result_error")
	private WebElement txtCancelMsg;
	
	
	public WebElement getBtnCancelSelect() {
		return BtnCancelSelect;
	}

	public WebElement getTxtCancelMsg() {
		return txtCancelMsg;
	}

	public WebElement getBtnRadio() {
		return btnRadio;
	}

	public WebElement getAdBookedItinerary() {
		return adBookedItinerary;
	}

	public WebElement getAdOrderId() {
		return adOrderId;
	}

	public WebElement getAdSearch() {
		return adSearch;
	}
    public void cancelBooking(String orderId ) {
	click(getAdBookedItinerary());
	sendKeys(getAdOrderId(), orderId);
	click(getAdSearch());
	click(getBtnRadio());
	click(getBtnCancelSelect());
	acceptAlert();

    }
}
