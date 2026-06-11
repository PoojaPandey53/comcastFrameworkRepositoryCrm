package advancedSeleniumProject_01;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import elementRepository.ContactInfoPage;
import elementRepository.ContactsPage;
import elementRepository.CreateContactpage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;

public class DemoScriptWithPOMandGU_01 {
	
	public static void main(String[] args) throws IOException {
		
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
		LoginPage lp = new LoginPage(driver);
		lp.getUserTextfield().sendKeys(USERNAME);
		lp.getPasswordTextField().sendKeys(PASSWORD);
		lp.getLoginButton().click();
		
		//step:3navigate to contacts link
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();
		
		//step4:click on create contact look up image 
		ContactsPage cp = new ContactsPage(driver);
		cp.getToCreateLookUpImageClick().click();
		
		// step5: create contact with mandotory fields

		CreateContactpage ccp = new CreateContactpage(driver);
		ccp.getLastnametextField().sendKeys(LASTNAME);;
		
		//save and verify 
		ccp.getSaveButton().click();
		
		 ContactInfoPage cip = new  ContactInfoPage(driver);
		String lastnamesaveHeader = cip.getContactsSaveHeader().getText();
		if (lastnamesaveHeader.contains(LASTNAME)) {
			System.out.println(LASTNAME+"...............passed");
		}
		else {
			System.out.println(LASTNAME+"...........failed");
		}
		
		// step7: logout of application
	WebElement logoutelement = hp.getAdministratorlink();
		
		wutil.ToMouseHoverClick(driver, logoutelement);
		hp.getSignOutLink().click();
		
		//close the browser 
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

	
}
