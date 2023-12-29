package com.stepdefinition;

import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

import com.omrbranch.base.BaseClass;

public class TC2_ExploreHotelStep extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();
	
	
	@When("User select {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userSelectAnd(String state, String city, String roomType, String checkInDate, String checkOutDate, String noOfRoom, String noOfAdults, String noOfChildren) {
	    pom.getExploreHotelPage().searchHotels(state, city, roomType, checkInDate, checkOutDate, noOfRoom, noOfAdults, noOfChildren);
	}
	
	@Then("User Should verify success message after search hotel {string}")
	public void userShouldVerifySuccessMessageAfterSearchHotel(String expSearchHotelSuccessMsg) {
		Assert.assertEquals("Verify after searchHotel", expSearchHotelSuccessMsg, pom.getSelectHotelPage().getSearchHotelSuccessMsgText());
	   
	}
	
	@When("User select with multiple room type {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userSelectWithMultipleRoomTypeAnd(String state, String city, String roomType, String checkInDate, String checkOutDate, String noOfRoom, String noOfAdults, String noOfChildren) {
	   pom.getExploreHotelPage().searchHotelAllRoomType(state, city, roomType, checkInDate, checkOutDate, noOfRoom, noOfAdults, noOfChildren);
	}
	
	@Then("User Should verify after select hotel success message multipleRoomType header {string}")
	public void userShouldVerifyAfterSelectHotelSuccessMessageMultipleRoomTypeHeader(String expMultiRoomTypeSuccessMsg) {
		Assert.assertEquals("Verify multi roomType Hotel Header", expMultiRoomTypeSuccessMsg, pom.getSelectHotelPage().getMultiRoomTypeTxtSuccessMsg());
	    
	}


	@Then("User Should verify hotel header name ends with selected room type {string}")
	public void userShouldVerifyHotelHeaderNameEndsWithSelectedRoomType(String roomType) {
		Assert.assertTrue(pom.getSelectHotelPage().verifyHotelNameEndsWithRoomType(roomType));
		
	}

	@When("User click search button without enter any fields")
	public void userClickSearchButtonWithoutEnterAnyFields() {
	      pom.getExploreHotelPage().btnSearchWithoutData();
	}
	
	@Then("User Should verify error message after clicking submit button {string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyErrorMessageAfterClickingSubmitButtonAnd(String expErrorState, String expErrorCity, String expErrorCheckInDate, String expErrorCheckOutDate, String expErrorNoofRooms, String expErrorNoofAdults ) throws InterruptedException {
	  Assert.assertEquals("Verify State Error", expErrorState, pom.getExploreHotelPage().getStateErrorTextMsg()); 
	    Assert.assertEquals("Verify City Error" , expErrorCity, pom.getExploreHotelPage().getCityErrorTextMsg());
	    Assert.assertEquals("Verify CheckInDate Error", expErrorCheckInDate, pom.getExploreHotelPage().getCheckInDateErrorMsg());
	    Assert.assertEquals("Verify CheckOutDate Error", expErrorCheckOutDate, pom.getExploreHotelPage().getCheckOutDateErrorMsg());
	    Assert.assertEquals("Verify NoofRooms Error", expErrorNoofRooms, pom.getExploreHotelPage().getNoOfRoomsErrorMsg());
	    Assert.assertEquals("Verify NoofAdults Error", expErrorNoofAdults, pom.getExploreHotelPage().getNoofAdultsErrorMsg());
	   
	    	
	}


}
