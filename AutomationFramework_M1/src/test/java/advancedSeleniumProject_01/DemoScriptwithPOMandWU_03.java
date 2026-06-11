package advancedSeleniumProject_01;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import elementRepository.CreateOrganisationpage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.OrganisationInfoPage;
import elementRepository.OrganisationPage;
import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;

public class DemoScriptwithPOMandWU_03 {

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
		String ORGNAME = eutil.toReadDataFromExcelFile("organisations", 1, 2);
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
		Thread.sleep(3000);
		
		// Step2: login to application with valid credentials 
					driver.get(URL);
					LoginPage lp = new LoginPage(driver);
					lp.getUserTextfield().sendKeys(USERNAME);
					lp.getPasswordTextField().sendKeys(PASSWORD);
					lp.getLoginButton().click();
		Thread.sleep(3000);
		
		//step3: navigation to organisation link 
					
					HomePage hp = new HomePage(driver);
					hp.getOrganisationsLink().click();
					Thread.sleep(3000);
		
		//step4: click on create organisation look up image
					
					OrganisationPage op = new OrganisationPage(driver);
					op.getOrganisationLookupclick().click();
					Thread.sleep(3000);
		
		//step5: create organisation with mandotory fields
					
					Random r = new Random() ;
					 int randomNumber = r.nextInt(1000);
					
					CreateOrganisationpage cop = new CreateOrganisationpage(driver);
					cop.getOrganisationTextField().sendKeys(ORGNAME+randomNumber);
					
			WebElement DROPDOWNTEXTFIELD = cop.getIndustryDropdownTextField();
			
		
		//select chemicals in the industry dropdown 
			wutil.toHandledropdown(DROPDOWNTEXTFIELD, "Chemicals");
			Thread.sleep(3000);
			
			
		//step6: save and verify 
			
		cop.getOrganisationSaveButton().click();
		Thread.sleep(3000);
			
			OrganisationInfoPage oip = new OrganisationInfoPage(driver);
		String orgName = oip.getOrganisationSaveHeader().getText();
			
	if (orgName.contains(ORGNAME+ randomNumber)){
			
			System.out.println( orgName+"----passed");
		}
		else {
			
			System.out.println(orgName+"------failed");
		}
	Thread.sleep(3000);
		
		//step7: logout of application 
			WebElement logoutelement = hp.getAdministratorlink();
			Thread.sleep(3000);
			
			wutil.ToMouseHoverClick(driver, logoutelement);
			hp.getSignOutLink().click();
			Thread.sleep(3000);
			
			//close the browser 
			driver.quit();	
				
		
		
		
		
		
		
		
		
		
	}
}
