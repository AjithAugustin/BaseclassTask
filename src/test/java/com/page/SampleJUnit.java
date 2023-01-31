package com.page;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.base.BaseClass;

public class SampleJUnit extends BaseClass {
	
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
		
	LoginPage loginPage = new LoginPage();
	loginPage.login(getcellData("Adactin", 1, 0), getcellData("Adactin", 1, 1));
	
	SearchHotelPage searchHotelPage = new SearchHotelPage();
	String actualLoginsucessMessage = getValueTextbox(searchHotelPage.getAdMessage());
	System.out.println(actualLoginsucessMessage);
	Assert.assertEquals("Verify after login sucess message", "Hello Greens8767!",actualLoginsucessMessage);
	
	//2. Select Hotel
	
	searchHotelPage.searchHotel(5, 3,3, 2, getcellData("Adactin", 1, 6), getcellData("Adactin", 1, 7), 2, 2);
	
	SelectHotelPage selectHotelPage = new SelectHotelPage();
    String actualSearchHotelTxt = getTextElement(selectHotelPage.getAdSelectHotel());
    System.out.println(actualSearchHotelTxt);
    Assert.assertEquals("verify search hotel text","Select Hotel",actualSearchHotelTxt);
	
    // 3. select Hotel
    
    selectHotelPage.selectHotel();
    
    BookHotelPage bookHotelPage = new BookHotelPage();
    
    String actualTxtSelectHotel = getTextElement(bookHotelPage.getAdMsgBookAHotel());
    System.out.println(actualTxtSelectHotel);
    Assert.assertEquals("verify select hotel text","Book A Hotel",actualTxtSelectHotel);
    
    //4. Book A Hotel
    bookHotelPage.BookHotel(getcellData("Adactin", 1, 2), getcellData("Adactin", 1, 3), getcellData("Adactin", 1, 4), getcellData("Adactin", 1, 5), "VISA", "May", "2022",getcellData ("Adactin", 1, 8));
    
    
    BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
    implicitWait(30);
    String actualTxtBookingConfirmation = getTextElement(bookingConfirmationPage.getAdMsgBookingConfirmation());
    System.out.println(actualTxtBookingConfirmation);
    Assert.assertEquals("Verify booking confirmation", "Booking Confirmation",actualTxtBookingConfirmation);
    
    // 5. Booking confirmation
    
    implicitWait(30);
    bookingConfirmationPage.bookingConfirmation();
    
    
   // 6.Cancel Booking
    
    CancelBookingPage cancelBookingPage = new CancelBookingPage();
    cancelBookingPage.cancelBooking(getcellData("Adactin", 1, 9));
   
      
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
