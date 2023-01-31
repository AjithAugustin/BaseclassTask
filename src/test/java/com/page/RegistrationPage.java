package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class RegistrationPage extends BaseClass {
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="New User Register Here")
	private WebElement txtRegister;
	
	@FindBy(id="username")
	private WebElement txtUserName;
	
	@FindBy(id="password")
	private WebElement txtPassword;
	
	@FindBy(id="re_password")
	private WebElement txtRePassword;
	
	@FindBy(id="full_name")
	private WebElement txtFullName;
	
	@FindBy(id="email_add")
	private WebElement txtemail;
	
	@FindBy(id="tnc_box")
	private WebElement btnRadio;
	
	@FindBy(id="Submit")
	private WebElement btnSubmit;
	
	public WebElement getTxtRegister() {
		return txtRegister;
	}

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getTxtRePassword() {
		return txtRePassword;
	}

	public WebElement getTxtFullName() {
		return txtFullName;
	}

	public WebElement getTxtemail() {
		return txtemail;
	}

	public WebElement getBtnRadio() {
		return btnRadio;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}
	
	public void registrationPage(String userName,String password,String rePassword,String fullName,String email) {
		click(getTxtRegister());
		sendKeys(getTxtUserName(), userName);
		sendKeys(getTxtPassword(), password);
		sendKeys(getTxtRePassword(), rePassword);
		sendKeys(getTxtFullName(), fullName);
		sendKeys(getTxtemail(), email);
		implicitWait(30);
		implicitWait(30);
		click(getBtnRadio());
		click(getBtnSubmit());
		
		
	}

}
