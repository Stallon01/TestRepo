package com.stepdefinition;


import org.junit.Assert;

import com.omrbranch.base.BaseClass;
import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;


public class TC4_BookHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User add guest details {string},{string},{string},{string} and {string}")
	public void userAddGuestDetailsAndWithoutGivingAnySpecialRequest(String salutation, String firstName, String lastName, String mobNum, String email) throws InterruptedException {
	   pom.getBookHotelPage().addGuestDetails(salutation, firstName, lastName, mobNum, email);
	}

	@Then("User enter Total Payment Fill Card Details {string}")
	public void userEnterTotalPaymentFillCardDetails(String cardType, io.cucumber.datatable.DataTable dataTable) {
		pom.getBookHotelPage().addPaymentDetails(cardType, dataTable);
	}
	
		
	@Then("User Should verify success message after submit {string} and save the generated order id")
	public void userShouldVerifySuccessMessageAfterSubmitAndSaveTheGeneratedOrderId(String expBookingSuccessMsg) {
	    Assert.assertEquals("Verify Booking Success Msg", expBookingSuccessMsg, pom.getBookHotelPage().getTextBookingSuccessMsg());
	}
	
	
	@Then("User Should verify whether same selected hotel is booked or not")
	public void userShouldVerifyWhetherSameSelectedHotelIsBookedOrNot() {
	    Assert.assertEquals(pom.getSelectHotelPage().SelectedHotelName(), pom.getBookHotelPage().txtbookedHotelName());
	}

	@Then("User add guest details with gst {string},{string},{string},{string} and {string}")
	public void userAddGuestDetailsWithGstAnd(String salutation, String firstName, String lastName, String mobNum, String email) throws InterruptedException {
		pom.getBookHotelPage().addGuestDetailsWithGst(salutation, firstName, lastName, mobNum, email);
	}



	@Then("User enter GST Details {string},{string} and {string}")
	public void userEnterGSTDetailsAnd(String gstRegNo, String gstCompany, String gstComAddress)  {
	    pom.getBookHotelPage().addGstDetails(gstRegNo, gstCompany, gstComAddress);
	}


	@Then("User add special request {string}")
	public void userAddSpecialRequest(String otherRequest) {
	    pom.getBookHotelPage().addSpecialRequest(otherRequest);
	}
	
	
	@Then("User Should verify error message {string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyErrorMessageAnd(String expCardTypeError, String expCardError, String expCardNumError, String expCardNameError, String expCardExpDateError, String expCardCvvError) {
	    Assert.assertEquals("Verify CardType Error", expCardTypeError, pom.getBookHotelPage().getCardTypeTxtErrorMsg());
	    Assert.assertEquals("Verify Card Error", expCardError, pom.getBookHotelPage().getCardTxtErrorMsg());
	    Assert.assertEquals("Verify CardNum Error", expCardNumError, pom.getBookHotelPage().getCardNumTxtErrorMsg());
	    Assert.assertEquals("Verify CardName Error", expCardNameError, pom.getBookHotelPage().getCardNameTxtErrorMsg());
	    Assert.assertEquals("Verify CardExpDate Error", expCardExpDateError, pom.getBookHotelPage().getCardExpDateTxtErrorMsg());
	    Assert.assertEquals("Verify CardCvv Error", expCardCvvError, pom.getBookHotelPage().getCardCvvTxtErrorMsg());
	}
	

	



}
