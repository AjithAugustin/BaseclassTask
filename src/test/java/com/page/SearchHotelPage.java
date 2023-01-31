package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SearchHotelPage extends BaseClass {
	
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(id="username_show")
	private WebElement adMessage;
	
	@FindBy(id="location")
	private WebElement adLocation;
	
	@FindBy(id="hotels")
	private WebElement adHotel;
	
	@FindBy(id="room_type")
	private WebElement adRoomType;
	
	@FindBy(id="room_nos")
	private WebElement adRoomNos;
	
	@FindBy(id="datepick_in")
	private WebElement adCheckInDate;
	
	@FindBy(id="datepick_out")
	private WebElement adCheckOutDate;
	
	@FindBy(id="adult_room")
	private WebElement adAdultRoom;
	
	@FindBy(id="child_room")
	private WebElement adChildRoom;
	
	@FindBy(id="Submit")
	private WebElement adSubmit;

	public WebElement getAdMessage() {
		
		return adMessage;
	}

	public WebElement getAdLocation() {
		return adLocation;
	}

	public WebElement getAdHotel() {
		return adHotel;
	}

	public WebElement getAdRoomType() {
		return adRoomType;
	}

	public WebElement getAdRoomNos() {
		return adRoomNos;
	}

	public WebElement getAdCheckInDate() {
		
		return adCheckInDate;
	}

	public WebElement getAdCheckOutDate() {
		return adCheckOutDate;
	}

	public WebElement getAdAdultRoom() {
		return adAdultRoom;
	}

	public WebElement getAdChildRoom() {
		return adChildRoom;
	}

	public WebElement getAdSubmit() {
		return adSubmit;
	}

public void searchHotel(int location,int hotel,int roomType,int roomNos,String checkInDate,String checkOutDate,int adultRoom,int childRoom) {
	//getValueTextbox(getAdMessage(), Message);
	selectoptionByIndex(getAdLocation(), location);
	selectoptionByIndex(getAdHotel(), hotel);
	selectoptionByIndex(getAdRoomType(), roomType);
	selectoptionByIndex(getAdRoomNos(), roomNos);
	sendKeys(getAdCheckInDate(), checkInDate);
	sendKeys(getAdCheckOutDate(), checkOutDate);
	selectoptionByIndex(getAdAdultRoom(), adultRoom);
	selectoptionByIndex(getAdChildRoom(), childRoom);
	click(getAdSubmit());
	

}
}
