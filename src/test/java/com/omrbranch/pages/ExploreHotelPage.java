package com.omrbranch.pages;
import com.omrbranch.base.BaseClass;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExploreHotelPage extends BaseClass {
	public ExploreHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@data-testid='username']")
	private WebElement txtLoginSuccessMsg;

	public WebElement getTxtLoginSuccessMsg() {
		return txtLoginSuccessMsg;
	}

	public String getLoginSuccessMsgText() {
		String text = getText(getTxtLoginSuccessMsg());
		return text;
	}
	
	

	@FindBy(xpath="//select[@id='state']")
	private WebElement selectState;
	@FindBy(xpath="//select[@id='city']")
	private WebElement selectCity;
	@FindBy(xpath="//select[@id='room_type']")
	private WebElement selectRoomType;
	@FindBy(xpath="//input[@name='check_in']")
	private WebElement dateCheckIn;
	@FindBy(xpath="//input[@name='check_out']")
	private WebElement dateCheckOut;
	@FindBy(xpath="//select[@id='no_rooms']")
	private WebElement selectNoRooms;
	@FindBy(xpath="//select[@id='no_adults']")
	private WebElement selectNoOfAdults;
	@FindBy(xpath="//input[@id='no_child']")
	private WebElement noOfChild;
	@FindBy(xpath="//iframe[@id='hotelsearch_iframe']")
	private WebElement frame;
	@FindBy(xpath="//button[.='Search']")
	private WebElement btnSearch;

	public WebElement getSelectState() {
		return selectState;
	}

	public WebElement getSelectCity() {
		return selectCity;
	}

	public WebElement getSelectRoomType() {
		return selectRoomType;
	}

	public WebElement getDateCheckIn() {
		return dateCheckIn;
	}

	public WebElement getDateCheckOut() {
		return dateCheckOut;
	}

	public WebElement getSelectNoRooms() {
		return selectNoRooms;
	}

	public WebElement getSelectNoOfAdults() {
		return selectNoOfAdults;
	}

	public WebElement getNoOfChild() {
		return noOfChild;
	}

	public WebElement getFrame() {
		return frame;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public void searchHotels(String state, String city, String roomType, String checkInDate, String checkOutDate, String noOfRoom, String noOfAdults, String noOfChildren) {

		selectDpdownText(getSelectState(), state);
		selectDpdownText(getSelectCity(), city);
		selectDpdownText(getSelectRoomType(), roomType);
		elementSendKeysjs(getDateCheckIn(),checkInDate);
		elementSendKeysjs(getDateCheckOut(), checkOutDate);
		selectDpdownText(getSelectNoRooms(), noOfRoom);
		selectDpdownText(getSelectNoOfAdults(),noOfAdults);
		sendKey(getNoOfChild(),noOfChildren);
		switchFramebyWebElement(getFrame());
		click(getBtnSearch());

	}
	public void searchHotelAllRoomType(String state, String city,String roomType, String checkInDate, String checkOutDate, String noOfRoom, String noOfAdults, String noOfChildren) {
		selectDpdownText(getSelectState(), state);
		selectDpdownText(getSelectCity(), city);
		String[] split = roomType.split("/");
		for(String eachRoomType:split) {
			System.out.println(eachRoomType);
			selectDpdownText(getSelectRoomType(), eachRoomType);
		}
		elementSendKeysjs(getDateCheckIn(),checkInDate);
		elementSendKeysjs(getDateCheckOut(), checkOutDate);
		selectDpdownText(getSelectNoRooms(), noOfRoom);
		selectDpdownText(getSelectNoOfAdults(),noOfAdults);
		sendKey(getNoOfChild(),noOfChildren);
		switchFramebyWebElement(getFrame());
		click(getBtnSearch());

	}
	
	public void btnSearchWithoutData() {
		switchFramebyWebElement(getFrame());
		click(getBtnSearch());

 	}
	
	public void selectRoomType(String roomType) {
		String[] split = roomType.split("/");
		for(String eachRoomType:split) {
			System.out.println(eachRoomType);
		}

	}

	public boolean verifyHotelNameEndsWithRoomType(String roomType) {

		List<WebElement> listStandard = driver.findElements(By.xpath("//*[@id=\"hotellist\"]//h5"));
		ArrayList<String> List = new ArrayList<String>();
		for(WebElement a:listStandard) {
			List.add(a.getText());
		}
		ArrayList<Boolean> ListEnds = new ArrayList<Boolean>();
		for(String a:List) {
			boolean endsWith = a.endsWith(roomType);
			ListEnds.add(endsWith);
		}
		boolean contains = ListEnds.contains(true);
		return contains;
	}
	
//	public void clickHotelSearch() {
//		
//	}
	
	@FindBy(xpath="//div[.='Please select state']")
	private WebElement txtStateErrorMsg;
	@FindBy(xpath="//div[@id='invalid-city']")
	private WebElement txtCityErrorMsg;
	@FindBy(xpath="//div[@id='invalid-check_in']")
	private WebElement txtCheckInDateErrorMsg;
	@FindBy(xpath="//div[@id='invalid-check_out']")
	private WebElement txtCheckOutDateErrorMsg;
	@FindBy(xpath="//div[@id='invalid-no_rooms']")
	private WebElement txtNoOfRoomsErrorMsg;
	@FindBy(xpath="//div[@id='invalid-no_adults']")
	private WebElement txtNoOfAdultsErrorMsg;
	
	public WebElement getTxtStateErrorMsg() {
		return txtStateErrorMsg;
	}

	public WebElement getTxtCityErrorMsg() {
		return txtCityErrorMsg;
	}

	public WebElement getTxtCheckInDateErrorMsg() {
		return txtCheckInDateErrorMsg;
	}

	public WebElement getTxtCheckOutDateErrorMsg() {
		return txtCheckOutDateErrorMsg;
	}

	public WebElement getTxtNoOfRoomsErrorMsg() {
		return txtNoOfRoomsErrorMsg;
	}

	public WebElement getTxtNoOfAdultsErrorMsg() {
		return txtNoOfAdultsErrorMsg;
	}

	public String getStateErrorTextMsg()  {
		defaultContent();
		String text = getText(getTxtStateErrorMsg());
		
        return text;
	}
	public String getCityErrorTextMsg()  {
		defaultContent();
		String text = getText(getTxtCityErrorMsg());
		return text;
	}
	public String getCheckInDateErrorMsg()  {
		defaultContent();
		String text = getText(getTxtCheckInDateErrorMsg());
		return text;
	}
	public String getCheckOutDateErrorMsg()  {
		defaultContent();
		String text = getText(getTxtCheckOutDateErrorMsg());
		return text;
	}
	public String getNoOfRoomsErrorMsg()  {
		defaultContent();
		String text = getText(getTxtNoOfRoomsErrorMsg());
		return text;
	}
	public String getNoofAdultsErrorMsg(){
		defaultContent();
		String text = getText(getTxtNoOfAdultsErrorMsg());
		return text;
	}
	
}
