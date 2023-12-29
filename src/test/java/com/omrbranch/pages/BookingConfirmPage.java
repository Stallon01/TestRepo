package com.omrbranch.pages;
import com.omrbranch.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmPage extends BaseClass {
	public BookingConfirmPage() {
		PageFactory.initElements(driver, this);
	}
	public static String AfterModifyDateOrderId;
	public static String AfterModifyDateHotelName;
	public static String AfterModifyDateHotelPrice;
	
	@FindBy(xpath="//a[.='Cancel']")
	private WebElement btnCancel;
	public WebElement getBtnCancel() {
		return btnCancel;
	}
	public void cancelOrderId() throws InterruptedException {
		Thread.sleep(2000);
		click(getBtnCancel());
	}
	public void cancelAcceptAlert() {
		acceptAlert();
	}
	
	@FindBy(xpath="//li[@class='alertMsg']")
	private WebElement txtCancelBookingSuccessMsg;
	public WebElement getTxtCancelBookingSuccessMsg() {
		return txtCancelBookingSuccessMsg;
	}
	public String getCancelOrderIdSuccessTextMsg() {
		String text = getText(getTxtCancelBookingSuccessMsg());
		System.out.println(text);
		return text;

	}
	
	@FindBy(xpath="//div[@class='room-code']//span")
	private WebElement aftermodifydateOrderId;
	public WebElement getAftermodifydateOrderId() {
		return aftermodifydateOrderId;
	}
	
	public String txtAfterModifyDateOrderId() {
		String text = getText(getAftermodifydateOrderId());
		System.out.println(text);
		AfterModifyDateOrderId = text;
		return AfterModifyDateOrderId;

	}
	
	@FindBy(xpath="//div[@id='bookinglist']//h5")
	private WebElement aftermodifydateHotelName;
	public WebElement getAftermodifydateHotelName() {
		return aftermodifydateHotelName;
	}
	
	public String txtAfterModifyDateHotelName() {
		String text = getText(getAftermodifydateHotelName());
		System.out.println(text);
		AfterModifyDateHotelName = text;
		return AfterModifyDateHotelName;
		
	}
	
	@FindBy(xpath="//strong[@class='total-prize']")
	private WebElement aftermodifydateHotelPrice;
	public WebElement getAftermodifydateHotelPrice() {
		return aftermodifydateHotelPrice;
	}
	
	public String txtAfterModifyDateHotelPrice() {
		String text = getText(getAftermodifydateHotelPrice());
		System.out.println(text);
		AfterModifyDateHotelPrice = text;
		return AfterModifyDateHotelPrice;

	}
	public void cancelFirstOrderId() {
		click(getBtnCancel());
	}
	
}
