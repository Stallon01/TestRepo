package com.omrbranch.pagemanager;

import com.omrbranch.pages.BookHotelPage;
import com.omrbranch.pages.BookingConfirmPage;
import com.omrbranch.pages.ExploreHotelPage;
import com.omrbranch.pages.LoginPage;
import com.omrbranch.pages.MyBookingPage;
import com.omrbranch.pages.SelectHotelPage;

public class PageObjectManager {
	private LoginPage loginpage;
	private ExploreHotelPage exploreHotelPage;
	private SelectHotelPage selectHotelPage;
	private BookHotelPage bookHotelPage;
	private BookingConfirmPage bookingConfrimPage;
	private MyBookingPage myBookingPage;

	public LoginPage getLoginpage() {
		return(loginpage==null)?loginpage = new LoginPage():loginpage;
	}
	public ExploreHotelPage getExploreHotelPage() {
		return(exploreHotelPage==null)?exploreHotelPage = new ExploreHotelPage(): exploreHotelPage;
	}
	public SelectHotelPage getSelectHotelPage() {
		return(selectHotelPage==null)?selectHotelPage = new SelectHotelPage(): selectHotelPage;
	}
	public BookHotelPage getBookHotelPage() {
		return (bookHotelPage==null)?bookHotelPage = new BookHotelPage(): bookHotelPage;
	}
	public BookingConfirmPage getBookingConfrimPage() {
		return (bookingConfrimPage==null)? bookingConfrimPage = new BookingConfirmPage():bookingConfrimPage;
	}
	public MyBookingPage getMyBookingPage() {
		return (myBookingPage==null)? myBookingPage = new MyBookingPage():myBookingPage;
	}
	
	
}
