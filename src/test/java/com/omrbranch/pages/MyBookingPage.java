package com.omrbranch.pages;

import com.omrbranch.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyBookingPage extends BaseClass {
	public MyBookingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public static String OrderId;
	
	public static String MybookingOrderId;
	public static String MyBookingHotelName;
	public static String MyBookingPrice;
	
	public static String BookHotelOrderName;
	
	@FindBy(xpath="//a[@data-testid='username']")
	private WebElement ddnWelcome;
	@FindBy(xpath="//a[.='My Account']")
	private WebElement clkAccount;
	
	public WebElement getDdnWelcome() {
		return ddnWelcome;
	}
	public WebElement getClkAccount() {
		return clkAccount;
	}

	
	@FindBy(xpath="//button[.='My Booking']")
	private WebElement btnBookings;
public WebElement getBtnBookings() {
		return btnBookings;
	}

public void navigateMyBookingPage() {
	String text = getOrderId().getText();
	System.out.println(text);
	BookHotelOrderName = text;
	String replaceAll = text.replaceAll("[//#]", "");
	OrderId = replaceAll;
	System.out.println(OrderId);
	click(getBtnBookings());
//	click(getDdnWelcome());
//	click(getClkAccount());

}

public void navigatebyMyAccount() {
	click(getDdnWelcome());
	click(getClkAccount());

}

public String txtBookHotelOrderId() {
	
	return BookHotelOrderName;
}

@FindBy(xpath="//div[@id='bookings']//h4")
private WebElement booking;
public WebElement getBooking() {
	return booking;
}

public String getHotelNameTextMsg() {
	String text = getText(getBooking()).replaceAll("[\\d\\s\\(\\)]", "");
//	String substring = text.substring(0, text.length() - 5);
//	System.out.println(substring);
//	return substring ;
	System.out.println(text);
	return text;
	

}

@FindBy(xpath="//h2[@name='booking-code']//strong")
private WebElement orderId;

public WebElement getOrderId() {
	return orderId;
}

@FindBy(xpath="//input[@name='search']")
private WebElement txtSearch;
public WebElement getTxtSearch() {
	return txtSearch;
	
}
public void getOrderIdTextMsg() {
	
sendKey(getTxtSearch(),OrderId);
	
}
//MyBooking Order Id
@FindBy(xpath="//div[@class='room-code']//span")
private WebElement mybookingOrderId;

public WebElement getMybookingOrderId() {
	return mybookingOrderId;
}

public String txtMyBookingOrderId() throws InterruptedException {
	Thread.sleep(2000);
	String text = getText(getMybookingOrderId());
	MybookingOrderId = text;
	System.out.println(MybookingOrderId);
	return MybookingOrderId;
}

//MyBooking Hotel Name
@FindBy(xpath="//div[@id='bookinglist']//h5")
private WebElement mybookingHotelName;

public WebElement getMybookingHotelName() {
	return mybookingHotelName;
}

public String txtMyBookingHotelName() throws InterruptedException {
	Thread.sleep(2000);
	String text = getText(getMybookingHotelName()); 
	MyBookingHotelName = text;
	System.out.println(MyBookingHotelName);
	return MyBookingHotelName;
}

//MyBooking Hotel Price
@FindBy(xpath="//div[@id='bookinglist']//strong")
private WebElement mybookingPrice;

public WebElement getMybookingPrice() {
	return mybookingPrice;
}
public String txtMyBookingPrice() throws InterruptedException {
	Thread.sleep(3000);
	String text = getText(getMybookingPrice());
	MyBookingPrice = text;
	System.out.println(MyBookingPrice);
	return MyBookingPrice;
}

//Modify Date
@FindBy(xpath="//button[.='Edit']")
private WebElement btnEdit;
public WebElement getBtnEdit() {
	return btnEdit;
}
@FindBy(xpath="//input[@name='check_in']")
private WebElement txtModifyDate;
public WebElement getTxtModifyDate() {
	return txtModifyDate;
}

@FindBy(xpath="//button[.='Confirm']")
private WebElement clkConfirm;

public WebElement getClkConfirm() {
	return clkConfirm;
}
public void changeCheckInDate(String modifyDate) throws InterruptedException {
	Thread.sleep(2000);
	click(getBtnEdit());
	elementSendKeysjs(getTxtModifyDate(),modifyDate);
	click(getClkConfirm());
}

@FindBy(xpath="//li[@class='alertMsg']")
private WebElement changeBookingSuccess;
public WebElement getChangeBookingSuccess() {
	return changeBookingSuccess;
}
public String getChangeBookingSuccessTextMsg() {
	String text = getText(getChangeBookingSuccess());
	System.out.println(text);
	return text;
}

public void modifyCheckInDateWithExistingOrderId(String orderId) {
	sendKey(getTxtSearch(),orderId);

}
@FindBy(xpath="//span[.='#DYTFD33375']")
private WebElement existingOrderId;

public WebElement getExistingOrderId() {
	return existingOrderId;
}

public String existingOrderId() {
	String text = getText(getExistingOrderId()).replaceAll("[//#]", "");
	System.out.println(text);
	return text;

}

}
