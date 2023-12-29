package com.omrbranch.pages;
import com.omrbranch.base.BaseClass;

import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotelPage extends BaseClass {
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	public static String BookedHoteName;
	
	//public static String BookHotelOrderName;
	
	@FindBy(xpath="//input[@id='own']")
	private WebElement clkMyself;
	@FindBy(xpath="//select[@id='user_title']")
	private WebElement selectSalutation;
	@FindBy(xpath="//input[@placeholder='First Name *']")
	private WebElement txtFirstName;
	@FindBy(xpath="//input[@placeholder='Last Name *']")
	private WebElement txtLastName;
	@FindBy(xpath="//input[@placeholder='Mobile No. *']")
	private WebElement txtMobNum;
	@FindBy(xpath="//input[@placeholder='Email *']")
	private WebElement txtEmail;
	
	public WebElement getClkMyself() {
		return clkMyself;
	}
	public WebElement getSelectSalutation() {
		return selectSalutation;
	}
	public WebElement getTxtFirstName() {
		return txtFirstName;
	}
	public WebElement getTxtLastName() {
		return txtLastName;
	}
	public WebElement getTxtMobNum() {
		return txtMobNum;
	}
	public WebElement getTxtEmail() {
		return txtEmail;
	}

	@FindBy(xpath="//input[@id='gst']")
	private WebElement checkboxGst;
	@FindBy(xpath="//input[@id='gst_registration']")
	private WebElement gstRegNo;
	@FindBy(xpath="//input[@id='company_name']")
	private WebElement gstCompany;
	@FindBy(xpath="//input[@id='company_address']")
	private WebElement gstComAddress;
	@FindBy(xpath="//button[@id='step1next']")
	private WebElement btnNext;
	@FindBy(xpath="//button[@id='step2next']")
	private WebElement btnNext2;
	
	
	public WebElement getCheckboxGst() {
		return checkboxGst;
	}
	public WebElement getGstRegNo() {
		return gstRegNo;
	}
	public WebElement getGstCompany() {
		return gstCompany;
	}
	public WebElement getGstComAddress() {
		return gstComAddress;
	}
	public WebElement getBtnNext() {
		return btnNext;
	}
	public WebElement getBtnNext2() {
		return btnNext2;
	}

	public void addGuestDetails(String salutation, String firstName, String lastName, String mobNum, String email) throws InterruptedException {
		Thread.sleep(3000);
		click(getClkMyself());
		selectDpdownText(getSelectSalutation(), salutation);
		sendKey(getTxtFirstName(), firstName);
		sendKey(getTxtLastName(), lastName);
		sendKey(getTxtMobNum(), mobNum);
		sendKey(getTxtEmail(), email);
		click(getBtnNext());
		Thread.sleep(2000);
		click(getBtnNext2());
	}
	
	public void addGuestDetailsWithGst(String salutation, String firstName, String lastName, String mobNum, String email) throws InterruptedException {
		Thread.sleep(2000);
		click(getClkMyself());
		selectDpdownText(getSelectSalutation(), salutation);
		sendKey(getTxtFirstName(), firstName);
		sendKey(getTxtLastName(), lastName);
		sendKey(getTxtMobNum(), mobNum);
		sendKey(getTxtEmail(), email);
	
} 

	public void addGstDetails(String gstRegNo, String gstCompany, String gstComAddress)  {
		click(getCheckboxGst());
		sendKey(getGstRegNo(), gstRegNo);
		sendKey(getGstCompany(), gstCompany);
		sendKey(getGstComAddress(), gstComAddress);
		click(getBtnNext());
		
	}
	
	@FindBy(xpath="//input[@id='late']")
	private WebElement lateCheckIn;
	
	public WebElement getLateCheckIn() {
		return lateCheckIn;
	}
	
	@FindBy(xpath="//textarea[@id='other_request']")
	private WebElement otherRequest;
	
	public WebElement getOtherRequest() {
		return otherRequest;
	}
	
	
	public void addSpecialRequest(String otherRequest) {
		click(getLateCheckIn());
		sendKey(getOtherRequest(), otherRequest);
		click(getBtnNext2());
		
	}
	
	
	
	@FindBy(xpath="//div[@class='credit-card pm']")
	private WebElement btnPayment;
	
	public WebElement getBtnPayment() {
		return btnPayment;
	}
	
	
	@FindBy(xpath="//select[@id='payment_type']")
	private WebElement selectCardType;
	public WebElement getSelectCardType() {
		return selectCardType;
	}
	
	@FindBy(xpath="//select[@id='card_type']")
	private WebElement selectCard;
	
	public WebElement getSelectCard() {
		return selectCard;
	}
	
	@FindBy(xpath="//input[@id='card_no']")
	private WebElement enterCardNum;
	@FindBy(xpath="//input[@id='card_name']")
	private WebElement cardName;
	@FindBy(xpath="//select[@id='card_month']")
	private WebElement month;
	@FindBy(xpath="//select[@id='card_year']")
	private WebElement year;
	@FindBy(xpath="//input[@id='cvv']")
	private WebElement cvv;
	
	public WebElement getEnterCardNum() {
		return enterCardNum;
	}
	public WebElement getCardName() {
		return cardName;
	}
	public WebElement getMonth() {
		return month;
	}
	public WebElement getYear() {
		return year;
	}
	public WebElement getCvv() {
		return cvv;
	}
	@FindBy(xpath="//button[@id='submitBtn']")
	private WebElement btnSubmit;
	public WebElement getBtnSubmit() {
		return btnSubmit;
	}
	public void addPaymentDetails(String cardType, DataTable dataTable){
		
		click(getBtnPayment()); 
		List<Map<String, String>> emp = dataTable.asMaps();
		switch(cardType) {
		case "Credit Card":
			Map<String, String> c = emp.get(0);
			selectDpdownText(getSelectCardType(),c.get("selectCard"));
			selectDpdownText(getSelectCard(),c.get("selectCardType"));
			sendKey(getEnterCardNum(),c.get("Enter Card Number"));
			sendKey(getCardName(),c.get("Enter Your Name On Card"));
			selectDpdownText(getMonth(),c.get("Select Month"));
			selectDpdownText(getYear(),c.get("Year"));
			sendKey(getCvv(),c.get("Enter Card CVV"));
			break;
		case "Debit Card":
			Map<String, String> d = emp.get(4);
			selectDpdownText(getSelectCardType(),d.get("selectCard"));
			selectDpdownText(getSelectCard(),d.get("selectCardType"));
			sendKey(getEnterCardNum(),d.get("Enter Card Number"));
			sendKey(getCardName(),d.get("Enter Your Name On Card"));
			selectDpdownText(getMonth(),d.get("Select Month"));
			selectDpdownText(getYear(),d.get("Year"));
			sendKey(getCvv(),d.get("Enter Card CVV"));
		break;
		default:
			break;
		}
		click(getBtnSubmit());
		
	}
	
	
//	@FindBy(xpath="//button[.='My Booking']")
//	private WebElement bookingSuccessMsg;
//	public WebElement getBookingSuccessMsg() {
//		return bookingSuccessMsg;
//	}
//	
//	public String getTextBookingSuccessMsg() {
//		String text = getText(getBookingSuccessMsg());
//		return text;
//
//	}

	@FindBy(xpath="//h2[@name='booking-code']")
	private WebElement txtBookingandId;

	public WebElement getTxtBookingandId() {
		return txtBookingandId;
	}

	@FindBy(xpath="//h2[@name='booking-code']//strong")
	private WebElement txtOrderId;

	public WebElement getTxtOrderId() {
		return txtOrderId;
	}
	
	public String getTextBookingSuccessMsg() {
		String text = getText(getTxtOrderId());
		 String replaceAll = getText(getTxtBookingandId()).replaceAll(text, "").trim();
		 System.out.println(replaceAll);
		 return replaceAll;
	}
	
@FindBy(xpath="(//div[@class='invalid-feedback animated fadeInDown'])[1]")
private WebElement cardTypeErrorMsg;
@FindBy(xpath="(//div[@class='invalid-feedback animated fadeInDown'])[2]")
private WebElement cardErrorMsg;
@FindBy(xpath="(//div[@class='invalid-feedback animated fadeInDown'])[3]")
private WebElement cardNumErrorMsg;
@FindBy(xpath="(//div[@class='invalid-feedback animated fadeInDown'])[4]")
private WebElement cardNameErrorMsg;
@FindBy(xpath="(//div[@class='invalid-feedback animated fadeInDown'])[5]")
private WebElement cardExpDateErrorMsg;
@FindBy(xpath="(//div[@class='invalid-feedback animated fadeInDown'])[6]")
private WebElement cardCvvErrorMsg;

public WebElement getCardTypeErrorMsg() {
	return cardTypeErrorMsg;
}
public WebElement getCardErrorMsg() {
	return cardErrorMsg;
}
public WebElement getCardNumErrorMsg() {
	return cardNumErrorMsg;
}
public WebElement getCardNameErrorMsg() {
	return cardNameErrorMsg;
}
public WebElement getCardExpDateErrorMsg() {
	return cardExpDateErrorMsg;
}
public WebElement getCardCvvErrorMsg() {
	return cardCvvErrorMsg;
}

public String getCardTypeTxtErrorMsg() {
	click(getBtnPayment()); 
	click(getBtnSubmit());
	String text = getText(getCardTypeErrorMsg());
	return text;
}

public String getCardTxtErrorMsg() {
	//click(getBtnPayment()); 
	String text = getText(getCardErrorMsg());
	return text;
}
public String getCardNumTxtErrorMsg() {
	//click(getBtnPayment()); 
	String text = getText(getCardNumErrorMsg());
	return text;
}
public String getCardNameTxtErrorMsg() {
	//click(getBtnPayment()); 
	String text = getText(getCardNameErrorMsg());
	return text;
}
public String getCardExpDateTxtErrorMsg() {
	//click(getBtnPayment()); 
	String text = getText(getCardExpDateErrorMsg());
	return text;
}
public String getCardCvvTxtErrorMsg() {
	//click(getBtnPayment()); 
	String text = getText(getCardCvvErrorMsg());
	return text;
}
@FindBy(xpath="//*[@id=\"page-wrapper\"]//p/strong")
private WebElement bookedHotelName;
public WebElement getBookedHotelName() {
	return bookedHotelName;
}
public String txtbookedHotelName() {
	String text = getText(getBookedHotelName());
	BookedHoteName = text;
	return BookedHoteName;

}

//@FindBy(xpath="//h2[@name='booking-code']//strong")
//private WebElement bookhotelOrderId;
//
//public WebElement getBookhotelOrderId() {
//	return bookhotelOrderId;
//	
//}
//public String txtBookHotelOrderId() {
//	String text = getText(getBookhotelOrderId());
//	BookHotelOrderName = text;
//	System.out.println(BookHotelOrderName);
//	return BookHotelOrderName;
//}
}
