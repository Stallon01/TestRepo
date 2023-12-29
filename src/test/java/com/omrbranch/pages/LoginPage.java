 package com.omrbranch.pages;
import com.omrbranch.base.BaseClass;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='email']")
	private WebElement txtUserName;
	@FindBy(xpath="//input[@id='pass']")
	private WebElement txtPassword;
	@FindBy(xpath="//button[.='Login']")
	private WebElement btnLogin;
	@FindBy(xpath="//b[contains(text(),'Invalid')]")
	private WebElement txtloginErrorMsg;

	public WebElement getTxtUserName() {
		return txtUserName;
	}
	public WebElement getTxtPassword() {
		return txtPassword;
	}
	public WebElement getBtnLogin() {
		return btnLogin;
	}
	public WebElement getTxtloginErrorMsg() {
		return txtloginErrorMsg;
	}

	public void login(String userName, String password) {
		sendKey(getTxtUserName(), userName);
		sendKey(getTxtPassword(), password);
		click(getBtnLogin());
	}


	public void loginWithEnterKey(String userName, String password) throws AWTException {
		sendKey(getTxtUserName(), userName);
		sendKey(getTxtPassword(), password);
		robotEnter();
	}

	public String getLoginErrorMsgText() {
		String text = getText(getTxtloginErrorMsg());
		return text;
	}

}
