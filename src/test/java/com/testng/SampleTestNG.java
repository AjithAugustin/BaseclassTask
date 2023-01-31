package com.testng;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.page.BookHotelPage;
import com.page.BookingConfirmationPage;
import com.page.CancelBookingPage;
import com.page.LoginPage;
import com.page.SearchHotelPage;
import com.page.SelectHotelPage;

public class SampleTestNG extends BaseClass {
	
	private static final String dataProvider = null;
	@BeforeSuite
	private void m1() {
		getDriver();
		getUrl("https://adactinhotelapp.com/");
		maximizeWindow();
	}
	@AfterSuite
	private void m2() {
		closeAllWindow();
	}
	@BeforeTest
	private void m3() {
		System.out.println("@BeforeTest");
	}
	@AfterTest
	private void m4() {
		System.out.println("@AfterTest");
	}
	@BeforeClass
	private void m5() {
		System.out.println("@BeforeClass");
	}
	@AfterClass
	private void m6() {
		System.out.println("@AfterClass");
	}
	@BeforeMethod
	private void m7() {
		System.out.println("@BeforeMethod");
	}
	@AfterMethod
	private void m8() {
		System.out.println("@AfterMethod");
	}
	@Test(dataProvider="test")
	private void login(String username, String password) throws IOException {
		
		//1. Login	
		
//		LoginPage loginPage = new LoginPage();
//		loginPage.login(getcellData("Adactin", 1, 0), getcellData("Adactin", 1, 1));
//		
//		SearchHotelPage searchHotelPage = new SearchHotelPage();
//		String actualLoginsucessMessage = getValueTextbox(searchHotelPage.getAdMessage());
//		System.out.println(actualLoginsucessMessage);
//		Assert.assertEquals("Verify after login sucess message", "Hello Anifadsp!",actualLoginsucessMessage);
		
		findElementById("username").sendKeys(username);
		findElementById("password").sendKeys(password);
		findElementById("login").click();
	}
	@DataProvider(name="test")
	private Object[][] dataPro() {
		Object data [][]=new Object[3][2];
		data[0][0]="Cristiano17";
		data[0][1]="ajith@17";
		
		data[1][0]="Cristiano17";
		data[1][1]="godson@17";
		
		data[2][0]="ajithaugustin";
		data[2][1]="godson@17";
		
		return data;
		}
	@Test(priority=1)
	private void search() throws IOException {
		//2. Select Hotel
		SearchHotelPage searchHotelPage = new SearchHotelPage();
		searchHotelPage.searchHotel(5, 3,3, 2, getcellData("Adactin", 1, 6), getcellData("Adactin", 1, 7), 2, 2);
		
		SelectHotelPage selectHotelPage = new SelectHotelPage();
	    String actualSearchHotelTxt = getTextElement(selectHotelPage.getAdSelectHotel());
	    System.out.println(actualSearchHotelTxt);
	    Assert.assertEquals("verify search hotel text","Select Hotel",actualSearchHotelTxt);		
		
	}
	@Test(priority=2)
	private void select() throws IOException {
       // 3. select Hotel
		SelectHotelPage selectHotelPage = new SelectHotelPage();
	    selectHotelPage.selectHotel();
	    
	    BookHotelPage bookHotelPage = new BookHotelPage();
	    
	    String actualTxtSelectHotel = getTextElement(bookHotelPage.getAdMsgBookAHotel());
	    System.out.println(actualTxtSelectHotel);
	    Assert.assertEquals("verify select hotel text","Book A Hotel",actualTxtSelectHotel);
		
	}
	@Test(priority=3)
	private void BookHotel() throws IOException {
		
		//4. Book A Hotel
		BookHotelPage bookHotelPage = new BookHotelPage();
	    bookHotelPage.BookHotel(getcellData("Adactin", 1, 2), getcellData("Adactin", 1, 3), getcellData("Adactin", 1, 4), getcellData("Adactin", 1, 5), "VISA", "May", "2022",getcellData ("Adactin", 1, 8));
	    
	    
	    BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
	    implicitWait(30);
	    String actualTxtBookingConfirmation = getTextElement(bookingConfirmationPage.getAdMsgBookingConfirmation());
	    System.out.println(actualTxtBookingConfirmation);
	    Assert.assertEquals("Verify booking confirmation", "Booking Confirmation",actualTxtBookingConfirmation);
	    
	}
	
	@Test(priority=4)
	private void bookingConfirm() throws IOException {
    // 5. Booking confirmation
	    
	    implicitWait(30);
	    BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
	    bookingConfirmationPage.bookingConfirmation();
	}
	@Test(priority=5)
	private void cancel() throws IOException {
		
        // 6.Cancel Booking
	    
	    CancelBookingPage cancelBookingPage = new CancelBookingPage();
	    cancelBookingPage.cancelBooking(getcellData("Adactin", 1, 9));
	}

}
