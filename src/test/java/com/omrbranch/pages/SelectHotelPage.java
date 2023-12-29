package com.omrbranch.pages;

import com.omrbranch.base.BaseClass;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage extends BaseClass {
	public static String HotelName;
	public static String HotelPrice;
	
	public static String BookHotelName;
	public static String BookHotelOrderId;
	
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h5[.='Select Hotel']")
	private WebElement txtSearchHotelSuccessMsg;

	public WebElement getTxtSearchHotelSuccessMsg() {
		return txtSearchHotelSuccessMsg;
	}
	
	public String getSearchHotelSuccessMsgText() {
		String text = getText(getTxtSearchHotelSuccessMsg());
		return text;

	}
	@FindBy(xpath="//a[@id='room_type']")
	private WebElement txtMutiRoomType;

	public WebElement getTxtMutiRoomType() {
		return txtMutiRoomType;
	}
	
	public String getMultiRoomTypeTxtSuccessMsg() {
		String text = getText(getTxtMutiRoomType());
		return text;
	}
	
	@FindBy(xpath="//a[.='Continue']")
	private WebElement selectHotel;
	
	
	public WebElement getSelectHotel() {
		return selectHotel;
	}
	
	@FindBy(xpath="(//div[@id='hotellist']//h5)[1]")
	private WebElement txtHotelName;
	@FindBy(xpath="//strong[@class='total-prize']")
	private WebElement txtHotelPrize;
	
	public WebElement getTxtHotelName() {
		return txtHotelName;
	}

	public WebElement getTxtHotelPrize() {
		return txtHotelPrize;
	}
	
	
	public void selectHotelName() {
		String hotelName = getText(getTxtHotelName());

		String replaceAll = hotelName.replaceAll(" Standard", "");
		 HotelName = replaceAll;
		System.out.println(HotelName);
	
		String hotelPrize = getText(getTxtHotelPrize());
		 HotelPrice = hotelPrize ;
		 System.out.println(HotelPrice);
		
	}
	
	
	
	public void OkAlert() {
		click(getSelectHotel());
		acceptAlert();
	}
	
	
	@FindBy(xpath="(//*[@id=\"page-wrapper\"]//h2)[1]")
	private WebElement txtBookHotel;
	
	public WebElement getTxtBookHotel() {
		return txtBookHotel;
	}
	public String getBookHoteltxtSuccessMsg() {
		String text = getTxtBookHotel().getText().replaceAll(" - Jayamahal Palace Hotel Standard", "");
		return text;

	}

	public void dismissAlert() {
		click(getSelectHotel());
		cancelAlert();

	}
	
	@FindBy(xpath="//label[@for='value_nasc']")
	private WebElement rdoAscending;
	public WebElement getRdoAscending() {
		return rdoAscending;
	}

	public void clickSortHotelNameByAsc() throws InterruptedException {
		Thread.sleep(3000);
		click(getRdoAscending());

	}
	@FindBy(xpath="//*[@id='hotellist']//h5")
	private List<WebElement> hotelList;
	
	public List<WebElement> getHotelList() {
		return hotelList;
	}

	public boolean sortHotelNameByAscending() {
		
		List<WebElement> liHotel = getHotelList();
		//List<WebElement> liHotel = driver.findElements(By.xpath("//*[@id=\"hotellist\"]//h5"));
		List<String> list = new ArrayList<String>();

		for(WebElement a:liHotel) {
			list.add(a.getText());
		}
		List<String> listAsc = new ArrayList<String>();

		for(WebElement a:liHotel) {
			listAsc.add(a.getText());
			Collections.sort(listAsc);
			boolean equals = list.equals(listAsc);
			return false;
		}
		
       return true;
	}

	@FindBy(xpath="//label[@for='Standard']")
	private WebElement deSelectLabel;

	public WebElement getDeSelectLabel() {
		return deSelectLabel;
	}

	public void unselectRoomType(String roomType) {
		click(getDeSelectLabel());

	}
	public boolean verifyUnselectRoomTypeHotelCount() throws InterruptedException {
		boolean res = false;
		List<WebElement> listRoomType = getHotelList();
	  //List<WebElement> listRoomType = driver.findElements(By.xpath("//*[@id=\"hotellist\"]//h5"));
	  int sizeRoomType = listRoomType.size();
	  Thread.sleep(3000);
	  WebElement deSelectLabel = getDeSelectLabel();
	  //WebElement deSelectLabel = driver.findElement(By.xpath("//label[@for='Standard']"));
	  deSelectLabel.click();
	  
	  List<WebElement> listAllRoom = driver.findElements(By.xpath("//*[@id=\"hotellist\"]//h5"));
	  int sizeAllRoom = listAllRoom.size();
	 
	  if(sizeRoomType!=sizeAllRoom) {
		  res=true;
	  }
	  return res;

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
	public String SelectedHotelName() {
		return HotelName;

	}
	
	//BookHotel Name
	@FindBy(xpath="(//div[@id='page-wrapper']//h5)[1]")
	private WebElement bookhotelName;
	public WebElement getBookhotelName() {
		return bookhotelName;
	}
	
	public String txtBookHotelName() throws InterruptedException {
		Thread.sleep(2000);
		String text = getText(getBookhotelName());
		BookHotelName = text;
		System.out.println(BookHotelName);
		return BookHotelName;
	}
	//BookHotel OrderId
	@FindBy(xpath="//strong[@class='total-prize']")
	private WebElement bookhotelPrice;

	public WebElement getBookhotelPrice() {
		return bookhotelPrice;
	}

	public String txtBookHotelPrice() throws InterruptedException {
		Thread.sleep(2000);
		String text = getText(getBookhotelPrice());
		BookHotelOrderId = text;
		System.out.println(BookHotelOrderId);
		return BookHotelOrderId;
	}
	
}

