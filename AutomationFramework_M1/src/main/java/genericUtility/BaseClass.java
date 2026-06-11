package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import elementRepository.HomePage;
import elementRepository.LoginPage;

public class BaseClass {

	PropertyFileUtility putil = new PropertyFileUtility();
	WebDriverUtility wutil = new WebDriverUtility();
//	public WebDriver driver = null;
	public WebDriver driver ;
	public static WebDriver sDriver;// for listeners 
	
	

	@BeforeSuite(groups="smoke")
	public void beforeSuiteConfigur() {
		System.out.println("...database connection established.........");
	}

	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups={"smoke","regression"}) // launch
	public void beforeClassconfig(/*String BROWSER*/) throws IOException {
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String URL = putil.toReadDataFromPropertyFile("url");

		// step1: launch a browser
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("Firefox")) {
			driver = new FirefoxDriver(); 
		}

		sDriver= driver;//listeners 
		
		System.out.println("browser got launched ");

		wutil.toMaximize(driver);//
		System.out.println("browser got maximized  ");

		wutil.waitForElement(driver);
		System.out.println("browser got  wait for element");
		driver.get(URL);
	}

	@BeforeMethod(groups={"smoke","regression"}) // login
	public void beforeMethodConfig() throws IOException {

		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");

		LoginPage lp = new LoginPage(driver);
		lp.getUserTextfield().sendKeys(USERNAME);
		lp.getPasswordTextField().sendKeys(PASSWORD);
		lp.getLoginButton().click();
		System.out.println("Successfully logged in to vtiger");

	}
	
	@AfterMethod(groups={"smoke","regression"}) // logout 
	public void afterMethodConfig() {
		HomePage hp = new HomePage(driver);
		wutil.ToMouseHoverClick(driver, hp.getAdministratorlink());
		hp.getSignOutLink().click();
		System.out.println("Successfully logged out from v tiger");
	}
	
	@AfterClass(groups={"smoke","regression"}) //class 
	public void  afterClassconfig() {
		System.out.println("browser got Successfully closed");
		driver.quit();
	}
	
	@AfterSuite(groups={"smoke","regression"})
	public void afterSuiteConfig() {
		System.out.println("database establish disconnected  ");
	}
 

}
