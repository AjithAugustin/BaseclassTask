package com.base;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdactinHotel extends BaseClass {

	public static void main(String[] args) throws IOException {
		
		AdactinHotel ah = new AdactinHotel();
		ah.booking();
		
		}
	public void booking() throws IOException {
		BaseClass bc = new BaseClass();
		
		bc.getDriver();
		bc.getUrl("https://adactinhotelapp.com/");
		bc.maximizeWindow();
		
		WebElement txtUserName = bc.findElementById("username");
		String name = bc.getcellData("Adactin", 1	, 0);
		bc.sendKeys(txtUserName,name);
		
		WebElement txtPassword = bc.findElementById("password");
		String password = bc.getcellData("Adactin", 1, 1);
		bc.sendKeys(txtPassword, password);
		
		WebElement btnLogin = bc.findElementById("login");
		bc.click(btnLogin);
		
	    WebElement location = bc.findElementById("location");
	    bc.selectoptionByText(location, "London");
	    
	    WebElement hotel = bc.findElementById("hotels");
	    bc.selectoptionByIndex(hotel, 3);
	    
	    WebElement roomType = bc.findElementById("room_type");
	    bc.selectoptionByText(roomType, "Deluxe");
	    
	    WebElement roomnos = bc.findElementById("room_nos");
	    bc.selectoptionByIndex(roomnos, 2);
	    
	    WebElement checkInDate = bc.findElementById("datepick_in");
	    String cID = bc.getcellData("Adactin", 1, 6);
	    bc.sendKeys(checkInDate, cID);
	    
	    WebElement checkOutDate = bc.findElementById("datepick_out");
	    String cOD = bc.getcellData("Adactin", 1, 7);
	    bc.sendKeys(checkOutDate, cOD);
	    
	    WebElement adult = bc.findElementById("adult_room");
	    bc.selectoptionByIndex(adult, 2);
	    
	    WebElement child = bc.findElementById("child_room");
	    bc.selectoptionByIndex(child, 2);
	    
	    WebElement search = bc.findElementById("Submit");
	    bc.click(search);
	    
	    WebElement radioBtn = bc.findElementById("radiobutton_0");
	    bc.click(radioBtn);
	    
	    WebElement continu = bc.findElementById("continue");
	    bc.click(continu);
	    
	    WebElement txtFirstName = bc.findElementById("first_name");
	    String firstName = bc.getcellData("Adactin", 1, 2);
	    bc.sendKeys(txtFirstName, firstName);
	    
	    WebElement txtLastName = bc.findElementById("last_name");
	    String lastName = bc.getcellData("Adactin", 1, 3);
	    bc.sendKeys(txtLastName, lastName);
	    
	    WebElement txtaddress = bc.findElementById("address");
	    String address = bc.getcellData("Adactin", 1, 4);
	    bc.sendKeys(txtaddress, address); 
	    
	    WebElement txtccnum = bc.findElementById("cc_num");
	    String ccnum = bc.getcellData("Adactin", 1, 5);
	    bc.sendKeys(txtccnum, ccnum);
	    
	    WebElement txtCardType = bc.findElementById("cc_type");
	    bc.selectoptionByText(txtCardType, "VISA");
	    
	    WebElement txtMonth = bc.findElementById("cc_exp_month");
	    bc.selectoptionByText(txtMonth, "May");
	    
	    WebElement txtYear = bc.findElementById("cc_exp_year");
	    bc.selectoptionByText(txtYear, "2022");
	    
	    
	    WebElement txtccv = bc.findElementById("cc_cvv");
	    String Ccv = bc.getcellData("Adactin", 1, 8);
	    bc.sendKeys(txtccv, Ccv);
	    
	    WebElement txtBookNow = bc.findElementById("book_now");
	    bc.click(txtBookNow);
	    
	    bc.implicitWait(30);
	    
	    WebElement txtOrderNum = bc.findElementById("order_no");
	    String orderNumber = bc.getValueTextbox(txtOrderNum);
	    System.out.println(orderNumber);
	    bc.writeCellData("Adactin", 1, 9, orderNumber);
	    
	    bc.closeAllWindow();
	    
	}

}
