package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this class consists of methods such as maximize
 * ,minimize,implicitwait,explicitwait, handle dropdown,handleframes,handle
 * mouse actions,to handle popups, to take screenshot,to switch between window
 * 
 * author pooja pandey
 */

public class WebDriverUtility {

	/**
	 * this method is used to maximize the browser provide the driver
	 * 
	 * @param driver
	 */

	public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * this method to minimize the browser provided the driver
	 * @param driver
	 */
	public void toMinimize(WebDriver driver) {
		driver.manage().window().minimize();

	}
//...................................................................................
	/**
	 * this method is will wait untill the element gets loaded
	 *  in webpage(implicitly wait)
	 * 
	 * @param driver
	 */
	public void waitForElement(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	/**
	 * this methods will wait until the element becomes clickable provided driver
	 * and element
	 * 
	 * @param driver
	 * @param element
	 */

	public void elementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

//.............................................................	
	/**
	 * this method is used to handle the dropdown using index
	 * 
	 * @param element
	 * @param index
	 */
	public void toHandledropdown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * this method is used to handle the dropdown using index by value
	 * 
	 * @param element
	 * @param value
	 */
	public void toHandledropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * this method is used to handle the dropdown using visible text
	 * 
	 * @param text
	 * @param element
	 */
	public void toHandledropdown(String text, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

//...........................................................

	/**
	 * this method is used to handle frame by using index
	 * 
	 * @param driver
	 * @param index
	 */
	public void ToHandleframe(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * this method is used to handle frame by using name or id
	 * 
	 * @param driver
	 * @param name_id
	 */
	public void ToHandleframe(WebDriver driver, String name_id) {
		driver.switchTo().frame(name_id);
	}

	/**
	 * this method is used to handle frame by using webelement
	 * 
	 * @param driver
	 * @param element
	 */
	public void ToHandleframe(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * this method is used to switch comtorl to back from frame to parent window
	 * 
	 * @param driver
	 */
	public void toSwitchBackFromFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	// ...........................................................

	/**
	 * this method provide double click to driver and element
	 * 
	 * @param driver
	 * @param element
	 */
	public void ToDoubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	/**
	 * this method is used to right click to driver and element
	 * 
	 * @param driver
	 * @param element
	 */
	public void ToRightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * this method is used to mouse hover the element and driver
	 * @param driver
	 * @param element
	 */
	public void ToMouseHoverClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * this method is used to perform drag and dropn provided driver and 2 element
	 * 
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void toDropAndDrag(WebDriver driver, WebElement src, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(src, target).perform();
	}
	//..........................................................................................

	/**
	 * this method is used to handle the popup by accept 
	 * @param driver
	 */
	public void toHandleAlertPopupByAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * this method is used to handle alert popup by dismiss
	 * @param driver
	 */
	public void toHandleAlertPopupByDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * this method is used to capture the message in alert popup and then accept it 
	 * @param driver
	 * @return
	 */
	public String toCaptureMessageInAlertPopupAndAccept(WebDriver driver) {
	Alert alertPopup	= driver.switchTo().alert();
	String alertMessage = alertPopup.getText();
	alertPopup.accept();//ok button
	return alertMessage;
	}
	//.....................................................................................
	/**
	 * this method is used perform scroll action provided by driver 
	 * @param driver
	 */
	public void toScroll(WebDriver driver ) {
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("window.scrollBy(0,500)");
	}
	//............................................................................................
	
	/**
	 * this method is used to take screenshotof  provided driver and screehotname 
	 * @param driver
	 * @param scrrenshotname
	 * @throws IOException 
	 */
	public void toTakeScreeshot(WebDriver driver ,String scrrenshotname ) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File src = new File("./errorshots/"+scrrenshotname+".png");
		FileHandler.copy(temp, src);
	}
	
	
	//...............................................................................
	
	/**
	 * 
	 * @param driver
	 * @param partialTitle
	 */
	public void ToSwitchwindow(WebDriver driver, String partialTitle) {
		//step1:capture all_ids
	Set<String> all_ids = driver.getWindowHandles();
	//step2: traverse to every window and capture title 
	for (String id :all_ids) {
	@Nullable
	String title = driver.switchTo().window(id).getTitle();
	//step3: compare title to capture with partialTitle given 
	if(title.contains(partialTitle)) {
		break;
	}
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
