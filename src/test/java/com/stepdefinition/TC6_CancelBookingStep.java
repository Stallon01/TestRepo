package com.stepdefinition;

import org.junit.Assert;

import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC6_CancelBookingStep {
	PageObjectManager pom = new PageObjectManager();
	
	@Then("User Should verify same order id is displayed after modifyDate")
	public void userShouldVerifySameOrderIdIsDisplayedAfterModifyDate() throws InterruptedException {
	    Assert.assertEquals(pom.getMyBookingPage().txtMyBookingOrderId(), pom.getBookingConfrimPage().txtAfterModifyDateOrderId());
	}
	@Then("User Should verify same hotel name is displayed after modifyDate")
	public void userShouldVerifySameHotelNameIsDisplayedAfterModifyDate() throws InterruptedException {
	    Assert.assertEquals(pom.getMyBookingPage().txtMyBookingHotelName(), pom.getBookingConfrimPage().txtAfterModifyDateHotelName());
	}
	@Then("User Should verify same hotel prize is displayed after modifyDate")
	public void userShouldVerifySameHotelPrizeIsDisplayedAfterModifyDate() throws InterruptedException {
	    Assert.assertEquals(pom.getMyBookingPage().txtMyBookingPrice(), pom.getBookingConfrimPage().txtAfterModifyDateHotelPrice());
	}

	@When("User click the cancel button")
	public void userClickTheCancelButton() throws InterruptedException {
	    pom.getBookingConfrimPage().cancelOrderId();
	}
	@When("User Should accept the alert")
	public void userShouldAcceptTheAlert() {
	    pom.getBookingConfrimPage().cancelAcceptAlert();
	}
	
	@Then("User Should verify after cancel success message {string}")
	public void userShouldVerifyAfterCancelSuccessMessage(String string) {
	   pom.getBookingConfrimPage().getCancelOrderIdSuccessTextMsg();
	}

	@When("User click the first booking cancel button")
	public void userClickTheFirstBookingCancelButton() {
	   pom.getBookingConfrimPage().cancelFirstOrderId();
	}
}
