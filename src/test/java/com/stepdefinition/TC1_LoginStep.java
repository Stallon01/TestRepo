package com.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.omrbranch.pagemanager.PageObjectManager;

import java.awt.AWTException;


import org.junit.Assert;

import com.omrbranch.base.BaseClass;

public class TC1_LoginStep extends BaseClass {
	
	PageObjectManager pom =new PageObjectManager();
	
	@Given("User is on the OMR Branch hotel page")
	public void userIsOnTheOMRBranchHotelPage(){
		
	    
	}
	@When("User login {string},{string}")
	public void userLogin(String userName, String password) {
	    pom.getLoginpage().login(userName, password);
	}
	@Then("User Should verify success message after login {string}")
	public void userShouldVerifySuccessMessageAfterLogin(String expLoginSuccessMsg) {
		Assert.assertEquals("verify after login ",expLoginSuccessMsg,pom.getExploreHotelPage().getLoginSuccessMsgText());
		
	}
	
	@When("User login {string},{string} with Enter Key")
	public void userLoginWithEnterKey(String userName, String password) throws AWTException {
		pom.getLoginpage().loginWithEnterKey(userName, password);
	    
	}
	
	@Then("User Should verify error message after login {string}")
	public void userShouldVerifyErrorMessageAfterLogin(String expLoginErrorMsg) {
		Assert.assertTrue("Verify Login Error Msg", pom.getLoginpage().getLoginErrorMsgText().contains("Invalid Login details"));
	    
	}

}
