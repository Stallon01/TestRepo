package com.stepdefinition;
import org.junit.Assert;

import com.omrbranch.base.BaseClass;
import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC3_SelectHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@When("User Select the first hotel name and save the hotel name and prize")
	public void userSelectTheFirstHotelNameAndSaveTheHotelNameAndPrize() {
		pom.getSelectHotelPage().selectHotelName();
	    
	}
	@When("User accept the popup")
	public void userAcceptThePopup() {
		pom.getSelectHotelPage().OkAlert();
	    
	}
	@Then("User Should verify success message after select hotel {string}")
	public void userShouldVerifySuccessMessageAfterSelectHotel(String expBookHotelSuccessMsg) {
	   Assert.assertEquals("Verify BookHotel Success Message", expBookHotelSuccessMsg, pom.getSelectHotelPage().getBookHoteltxtSuccessMsg());
		
	}
	

	@When("User dismiss the popup")
	public void userDismissThePopup() {
	    pom.getSelectHotelPage().dismissAlert();
	}

	@When("User click the name ascending in sort by")
	public void userClickTheNameAscendingInSortBy() throws InterruptedException {
		pom.getSelectHotelPage().clickSortHotelNameByAsc();
	    
	}
	
	@Then("User Should verify whether the selected roomType are listed in Ascending")
	public void userShouldVerifyWhetherTheSelectedRoomTypeAreListedInAscending() {
		Assert.assertFalse(pom.getSelectHotelPage().sortHotelNameByAscending());
	    
	}

	@When("User unselect the roomType {string}")
	public void userUnselectTheRoomType(String roomType) {
		pom.getSelectHotelPage().unselectRoomType(roomType);
	}
	@Then("User should verify listed hotels after unselect roomType")
	public void userShouldVerifyListedHotelsAfterUnselectRoomType() throws InterruptedException {
	    Assert.assertTrue(pom.getSelectHotelPage().verifyUnselectRoomTypeHotelCount());
		
	}



	
}
