 package com.omrbranch.base;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;



public class BaseClass {
	public static WebDriver driver;
	Alert alert;
	Select select;
	Actions actions;
	
	//1.To Launch the Browser
    public static void browserLaunch() {
	      driver = new ChromeDriver();
         }
    
    public static void quitBrowser() {
		driver.quit();
	}
    
  //2.To enter the URL
    public static void enterUrl(String url) {
	     driver.get(url);
          }
    
  //3. To maximize the window
    public static void maxiWindow() {
	     driver.manage().window().maximize();
          }
    
  //4. To Click the selected WebElement
    public void click(WebElement element) {
		element.click();
	}
   //5.Sendkeys
    
    public static void sendKey(WebElement element, String data) {
		element.sendKeys(data);
	}

  //6.To Switch to Alert
    public void switchToAlert() {
		driver.switchTo().alert();
	}
    
  //7.To Accept the OK by alert
    public void acceptAlert() {
    	driver.switchTo().alert().accept();
	}
    
  //8. To Dismiss the alert
    public void cancelAlert() {
    	driver.switchTo().alert().dismiss();
	}
    
   
    
  //9. To get the Webelement text
    public static String getText(WebElement element) {
    	String text = element.getText();
		return text;
	}
    
  //10. To get the attribute value of the WebElement
    public String getAttribute(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		return attribute;
	}
    
  //11.To close all the windows in the webpage
    public static void closeallwindows() {
		driver.quit();
	}
    
  //12.To close the current window in the webpage
    public void closeCurrentWindow() {
		driver.close();
	}
    
  //13. To the title of the webpage
    public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}
    
  //14. To get entered Url by javascript
    public String getEnteredUrljs() {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	String enteredUrl = (String)js.executeScript("return window.location.href;");
    	return enteredUrl;
	}
    
  //15. To select the dropdown by text
    public void selectDpdownText(WebElement element,String data) {
		select = new Select(element);
		select.selectByVisibleText(data);
	}
    
  //16. To select the dropdown by Attribute value
    public void selectDpdownAttribute(WebElement element, String data) {
		select = new Select(element);
		select.selectByValue(data);
	}
    
  //17.To select the dropdown by Index value
    public void selectDpdownIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}
    
  //18.To input data using javascript
    public void elementSendKeysjs(WebElement element, String data) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+data+"')",element);
	}
    
  //19.To click WebElement using javascript
    public void elementClickjs(WebElement element) {
    	JavascriptExecutor js =(JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click()", element);
	}
    
  //20.To switch to child window
    public void switchChildwindow(int index) {
		Set<String> allIds = driver.getWindowHandles();
		List<String> i = new ArrayList();
		i.addAll(allIds);
		String child = i.get(index);
		driver.switchTo().window(child);
		}
    
  //21. To switch to frame by index
    public void switchFrameIndex(int index) {
		driver.switchTo().frame(index);
	}
    
  //22. To switch to frame by Attribute value
    public void switchFramebyId(String attributeValue) {
		driver.switchTo().frame(attributeValue);
	}
    
    //23. To switch to frame by WebElement Id
    public void switchFramebyWebElement(WebElement element) { 
		driver.switchTo().frame(element);
	}
    
    //23.1 To switch back to default content
    public void defaultContent() {
		driver.switchTo().defaultContent();

	}
    
    
  //24. To locate the WebElement using id
    public WebElement findLocatorbyId(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}
    
  //25. To locate the WebElement using Name
    public WebElement findLocatorbyName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}
    
  //26. To Locate the WebElement using ClassName
    public WebElement findLocatorbyClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}
    
  //27. To Locate the WebElement using Xpath
    public WebElement findLocatorbyXpath(String xpathExpression) {
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		return element;
	}
    
  //28. To get the options in dropdown as Text
    public String getOptionsDpdownasText(WebElement element, int index) {
		select = new Select(element);
		List<WebElement> li = select.getOptions();
			String text = li.get(index).getText();
			return text;
	}
    
  //29. To get the first selected option in dropdown as Text
    public String getFirstSelectedOptionDpdownText(WebElement element) {
    	select = new Select(element);
		 WebElement element2 = select.getFirstSelectedOption();
		String text = element2.getText();
		return text;
	}
    
  //30. To verift whether the dropdown has multiple selected options
    public boolean verifyDropdownMultiselect(WebElement element) {
    	select = new Select(element);
		boolean multiple = select.isMultiple();
        return multiple;
	}
    
  //31. To verify whether the element is displayed 
    public boolean VerifyIsDisplayed(String xpathExpression ) {
		boolean displayed = driver.findElement(By.xpath(xpathExpression)).isDisplayed();
		return displayed;
	}
    
  //32. To verify whether the element is enabled
    public boolean VerifyIsEnabled(String xpathExpression ) {
		boolean displayed = driver.findElement(By.xpath(xpathExpression)).isEnabled();
		return displayed;
	}
    
  //33. To verify whether the element is selected
    public boolean VerifyIsSelected(String xpathExpression ) {
		boolean displayed = driver.findElement(By.xpath(xpathExpression)).isSelected();
		return displayed;
	}
  //34. To deselect by Index
    public void deselectByIndex(WebElement element,int index) {
    	select = new Select(element);
		select.deselectByIndex(index);
	}
    
  //35. To deselect by AttributeValue
    public void deselectByAttribute(WebElement element,String value) {
    	select = new Select(element);
		select.deselectByValue(value);
	}
    
  //36. To deselect by Text
    public void deselectByText(WebElement element,String text) {
    	select = new Select(element);
		select.deselectByVisibleText(text);
	}
    
  //37. To deselect all selected options
    public void deselectAll(WebElement element) {
    	select = new Select(element);
		select.deselectAll();
	}
    
  //38. To get the parent window ID
    public String getParentWindow() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
    
  //39. To get all the windows ID
    public void getAllWindows() {
    	String id = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String s:windowHandles) {
			if(!id.equals(s)) {
				driver.switchTo().window(s);
			}
		}

	}
    
  //40. To clear the TextBox
    public void clearTextbox(String xpathExpression) {
		driver.findElement(By.xpath(xpathExpression)).clear();
	}
    
  //41. To take screenshot and save in a Folder as file
    
    public void screenshot(String name) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		File file = new File("D:\\Java Tasks\\JS Testing\\Project1\\TargetScreenshot\\name.png");
		FileHandler.copy(screenshotAs, file);
		
	}
	
  //42. To perform mouse over action
    public void mouseOverActionSingleOption(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
    
  //43. To perform drag and drop using mouse 
    public void mouseoverdragAndDrop(WebElement element, WebElement element1) {
		actions = new Actions(driver);
		actions.dragAndDrop(element, element1).perform();
	}
    
  //44. To perform RightClick using mouse
    public void mouseoverRightClick(WebElement element) {
		actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
    
  //45. To perform DoubleClick using mouse
    public void mouseoverDoubleClick(WebElement element) {
		actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
    
  //46. To refesh the page 
    public void refreshPage() {
		driver.navigate().refresh();
	}
    
  //47. 
    public void visibilityOf(WebElement element) {
		WebDriverWait driverwait = new WebDriverWait(driver,Duration.ofSeconds(30));
		driverwait.until(ExpectedConditions.visibilityOf(element));
	}
    
  //48. To Take screenshot and save in file location
    public void screenshot(WebElement element) throws IOException {
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		File file = new File("D:\\Java Tasks\\JS Testing\\Project1\\TargetScreenshot\\name.png");
		FileHandler.copy(screenshotAs, file);
		
	}
    
    //49. Implicit waits
    public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
    
//    //50. Fluent Waits
//    public void fluentWait() {
//		Wait<WebDriver>w = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(50)).pollingEvery(Duration.ofSeconds(10)).ignoring(Exception.class);
//	}
    
    //51. Robot Enter
    
    public void robotEnter() throws AWTException {
    	Robot r = new Robot();
    	r.keyPress(KeyEvent.VK_ENTER);
    	r.keyRelease(KeyEvent.VK_ENTER);
	}
    
    //52. To get list of WebElements
    public List<WebElement> findElementsByxpath(String xpathExpression) {
		List<WebElement> findElements = driver.findElements(By.xpath(xpathExpression));
		return findElements;
	}
    
    //53. getProjectPath
    
    public String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;

	}
    
    //54. getPropertyFileValue
    
    public String getPropertyFileValue(String Key) throws FileNotFoundException, IOException {
		 Properties properties= new Properties();
		 properties.load(new FileInputStream(getProjectPath()+"\\Config\\Config.properties"));
		 Object object = properties.get(Key);
		 String value = (String) object;
		 return value;

	}
    
    //55. Launching in multiple browser
    
    public void getDriver(String browserType) {
    	switch(browserType) {
    	case "Chrome":
    		driver = new ChromeDriver();
    		break;
    	case "firefox":
    		driver = new FirefoxDriver();
    		break;
    	case "ie":
    		driver = new InternetExplorerDriver();
    		break;
    	case "edge":
    		driver = new EdgeDriver();
    		break;

    	default:
    		
    		break;
    	}
    }
    
    //56. Generate jvm report
    
//    public  void generateJvmReport(String jsonFile) throws FileNotFoundException, IOException {
//		File file = new File(getProjectPath()+getPropertyFileValue("jvmpath"));
//		Configuration configuration = new Configuration(file, "OMR Branch HOtel");
//		configuration.addClassifications("Browser", "Chrome");
//		configuration.addClassifications("Browser Version", "107");
//		configuration.addClassifications("OS", "Windows 11");
//		configuration.addClassifications("Sprint", "24");
//		ArrayList<String> jsonFiles = new ArrayList<String>();
//		jsonFiles.add(jsonFile);
//		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
//		builder.generateReports();
//	}
    
}
