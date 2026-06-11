package advancedSeleniumProject_01;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;

public class DemoScriptWithWebDriverUtilityMethods {

	public static void main(String[] args) throws IOException, InterruptedException {

		// to read data from property
		PropertyFileUtility putil = new PropertyFileUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		WebDriverUtility wutil = new WebDriverUtility();

		// to read data from property file
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String URL = putil.toReadDataFromPropertyFile("url");
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");

		// to read the data from property file
		String LASTNAME = eutil.toReadDataFromExcelFile("contacts", 1, 2);

		// testScripts
		// step1: launch a browser

		WebDriver driver = null;

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("Firefox")) {
			driver = new FirefoxDriver();
		}

		wutil.toMaximize(driver);// WDU
		wutil.waitForElement(driver);

		// Step2: login to application with valid credentials
		driver.get(URL);

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		// Step3:navigate to contacts link

		driver.findElement(By.linkText("Contacts")).click();

		// step4: click on create contact look up image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// step5: create contact with mandotory fields

		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

		// step6: save and verify

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(3000);

		String lastName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		if (lastName.contains(LASTNAME)) {

			System.out.println(LASTNAME + "----passed");
		} else {

			System.out.println(LASTNAME + "---failed");
		}

		// step7: logout of application

		WebElement logoutEle = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		Actions action = new Actions(driver);

		action.moveToElement(logoutEle).perform();

		driver.findElement(By.linkText("Sign Out")).click();

		// step8: close the browser

		driver.quit();
		
		
		

	}
}
