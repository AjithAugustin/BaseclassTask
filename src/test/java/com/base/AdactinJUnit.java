package com.base;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdactinJUnit extends BaseClass {
	
	static WebDriver driver;
	@BeforeClass
	public static void beforeClass() {
	
		getDriver();
		getUrl("https://adactinhotelapp.com/");
		maximizeWindow();
		
	}
	@Before
	public void beforeTest() {
		long time = System.currentTimeMillis();
		System.out.println(time);

	}
	@Test
	public void login() throws IOException {
	//1. Login	
	WebElement txtUserName = findElementById("username");
	String name = getcellData("Adactin", 1, 0);
	sendKeys(txtUserName, name);
	
	WebElement txtPassword = findElementById("password");
	String pass = getcellData("Adactin", 1, 1);
	sendKeys(txtPassword, pass);
	
	WebElement btnLogin = findElementById("login");
	click(btnLogin);
		
	WebElement txtLoginSucessMsg = findElementById("username_show");
	String actualLoginsucessMessage = getValueTextbox(txtLoginSucessMsg);
	System.out.println(actualLoginsucessMessage);
	Assert.assertEquals("Verify after login sucess message", "Hello Cristiano17!",actualLoginsucessMessage);
	
	//2. Select Hotel
	WebElement location = findElementById("location");
    selectoptionByText(location, "London");
    
    WebElement hotel = findElementById("hotels");
    selectoptionByText(hotel, "Hotel Hervey");
    
    WebElement roomType = findElementById("room_type");
    selectoptionByText(roomType, "Deluxe");
   
    WebElement roomnos = findElementById("room_nos");
    sendKeys(roomnos, "1-One");
	
    WebElement checkInDate = findElementById("datepick_in");
    String cID = getcellData("Adactin", 1, 6);
    sendKeys(checkInDate, cID);
    
    WebElement checkOutDate = findElementById("datepick_out");
    String cOD = getcellData("Adactin", 1, 7);
    sendKeys(checkOutDate, cOD);
    
    WebElement adult = findElementById("adult_room");
    sendKeys(adult, "2-Two");
    
    WebElement child = findElementById("child_room");
    sendKeys(child, "0-None");
    
    WebElement search = findElementById("Submit");
    click(search);
	
    WebElement txtSearchHotel = findElementByClassName("login_title");
    String actualSearchHotelTxt = getTextElement(txtSearchHotel);
    System.out.println(actualSearchHotelTxt);
    Assert.assertEquals("verify search hotel text","Select Hotel",actualSearchHotelTxt);
	
    // select Hotel
    WebElement radioBtn = findElementById("radiobutton_0");
    click(radioBtn);
    
    WebElement continu = findElementById("continue");
    click(continu);
    
    WebElement txtSelectHotel = findElementByXpath("//td[text()='Book A Hotel ']");
    String actualTxtSelectHotel = getTextElement(txtSelectHotel);
    System.out.println(actualTxtSelectHotel);
    Assert.assertEquals("verify select hotel text","Book A Hotel",actualTxtSelectHotel);
    
    //4. Book A Hotel
    WebElement txtFirstName = findElementById("first_name");
    String firstName = getcellData("Adactin", 1, 2);
    sendKeys(txtFirstName, firstName);
    
    WebElement txtLastName = findElementById("last_name");
    String lastName = getcellData("Adactin", 1, 3);
    sendKeys(txtLastName, lastName);
    
    WebElement txtaddress = findElementById("address");
    String address = getcellData("Adactin", 1, 4);
    sendKeys(txtaddress, address); 
    
    WebElement txtccnum = findElementById("cc_num");
    String ccnum = getcellData("Adactin", 1, 5);
    sendKeys(txtccnum, ccnum);
    
    WebElement txtCardType = findElementById("cc_type");
    selectoptionByText(txtCardType, "VISA");
    
    WebElement txtMonth = findElementById("cc_exp_month");
    selectoptionByText(txtMonth, "May");
    
    WebElement txtYear = findElementById("cc_exp_year");
    selectoptionByText(txtYear, "2022");
    
    
    WebElement txtccv = findElementById("cc_cvv");
    String Ccv = getcellData("Adactin", 1, 8);
    sendKeys(txtccv, Ccv);
    
    WebElement txtBookNow = findElementById("book_now");
    click(txtBookNow);
    
    implicitWait(30);
    WebElement txtBookingConfirmation = findElementByXpath("//td[contains(text(),'Booking Confirmation ')]");
    String actualTxtBookingConfirmation = getTextElement(txtBookingConfirmation);
    System.out.println(actualTxtBookingConfirmation);
    Assert.assertEquals("Verify booking confirmation", "Booking Confirmation",actualTxtBookingConfirmation);
    
    implicitWait(30);
    
    WebElement txtOrderNum = findElementById("order_no");
    String orderNumber = getValueTextbox(txtOrderNum);
    System.out.println("Oder Number: "+orderNumber);
    writeCellData("Adactin", 1, 9, orderNumber);
      
	}
	@After
	public void afterTest() {
		
		long time = System.currentTimeMillis();
		System.out.println(time);

	}
	
	@AfterClass
	public static void afterClass() {
		closeAllWindow();
	}
	
}
   
