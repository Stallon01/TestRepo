package com.stepdefinition;

import com.omrbranch.pagemanager.PageObjectManager;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC5_ChangeBookingStep {
	PageObjectManager pom = new PageObjectManager();

	@When("User navigate to my booking page")
	public void userNavigateToMyBookingPage() {
		pom.getMyBookingPage().navigateMyBookingPage();
	}
	@Then("User Should verify the success message after navigate to booking page {string}")
	public void userShouldVerifyTheSuccessMessageAfterNavigateToBookingPage(String expBookingSuccessMsg) {
	    Assert.assertEquals("Verify Bookings Success Msg", expBookingSuccessMsg, pom.getMyBookingPage().getHotelNameTextMsg());
	}
	@When("User search the generated order id")
	public void userSearchTheGeneratedOrderId(){
	    pom.getMyBookingPage().getOrderIdTextMsg();
	}
	@Then("User Should verify same order id is displayed")
	public void userShouldVerifySameOrderIdIsDisplayed() throws InterruptedException {
		Assert.assertEquals(pom.getMyBookingPage().txtBookHotelOrderId(), pom.getMyBookingPage().txtMyBookingOrderId());
	   
	}
	@Then("User Should verify same hotel name is displayed")
	public void userShouldVerifySameHotelNameIsDisplayed() throws InterruptedException {
	   Assert.assertEquals(pom.getSelectHotelPage().txtBookHotelName(), pom.getMyBookingPage().txtMyBookingHotelName());
	}
	@Then("User Should verify same hotel prize is displayed")
	public void userShouldVerifySameHotelPrizeIsDisplayed() throws InterruptedException {
	    Assert.assertEquals(pom.getSelectHotelPage().txtBookHotelPrice(), pom.getMyBookingPage().txtMyBookingPrice());
	}
	@When("User click the edit button and modify the checkInDate {string}")
	public void userClickTheEditButtonAndModifyTheCheckInDate(String modifyDate) throws InterruptedException {
	    pom.getMyBookingPage().changeCheckInDate(modifyDate);
	}
	@Then("User Should verify success message edit checkInDate {string}")
	public void userShouldVerifySuccessMessageEditCheckInDate(String string) {
	    pom.getMyBookingPage().getChangeBookingSuccessTextMsg();
	}
//---------------------
	@When("User navigate to the my bookings page")
	public void userNavigateToTheMyBookingsPage() {
	    pom.getMyBookingPage().navigatebyMyAccount();
	}

	@When("User enter the existing order id {string}")
	public void userEnterTheExistingOrderId(String orderId) {
	   pom.getMyBookingPage().modifyCheckInDateWithExistingOrderId(orderId);
	}
	@Then("User Should verify the same order id is displayed")
	public void userShouldVerifyTheSameOrderIdIsDisplayed() {
	    Assert.assertEquals("DYTFD33375", pom.getMyBookingPage().existingOrderId());
	}

}
