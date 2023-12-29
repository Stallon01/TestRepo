package com.stepdefinition;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.omrbranch.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
public class HooksClass extends BaseClass{
	@Before
	public void beforeExecution() throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("Browser"));
		enterUrl(getPropertyFileValue("url"));
		maxiWindow();
		implicitWait();
	}
	@After
	public void afterExecution() {
		quitBrowser();

	}

}
