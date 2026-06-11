package advancedSeleniumProject_01;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;

public class DemoScriptWithGeneriUtility_01 {

public static void main(String[] args) throws IOException {
	
	//to read data from property 
	PropertyFileUtility putil = new PropertyFileUtility();
      String BROWSER = putil.toReadDataFromPropertyFile("browser");
     String URL = putil.toReadDataFromPropertyFile("url");
    String USERNAME = putil.toReadDataFromPropertyFile("username");
    String PASSWORD = putil.toReadDataFromPropertyFile("password");
    
    //TO READ DATA FROM EXCEL FILE 
    
    ExcelFileUtility eutil = new ExcelFileUtility();
  String lastname = eutil.toReadDataFromExcelFile("contacts", 1, 2);
     
     //testScripts
 	// step1: launch a browser

		WebDriver driver = null;

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

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

			driver.findElement(By.name("lastname")).sendKeys(lastname);
			
			// step6: save and verify

						driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

						String lastName_1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

						if (lastName_1.contains(lastname )) {

							System.out.println(lastname + "----passed");
						} else {

							System.out.println(lastname + "---failed");
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
