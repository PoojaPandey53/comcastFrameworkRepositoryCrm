package advancedSeleniumProject_01;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DataScriptDataDrivenTesting {

	public static void main(String[] args) throws IOException {

		// toReadDataFromProperries

		FileInputStream pfis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties prop = new Properties();
		prop.load(pfis);
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");

		// TOREAD DATA FROM EXCEL file
		FileInputStream efis = new FileInputStream(".\\src\\test\\resources\\Excel file.xlsx");
		Workbook wb = WorkbookFactory.create(efis);

		String LASTNAME = wb.getSheet("contacts").getRow(1).getCell(2).toString();

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

			driver.findElement(By.name("lastname")).sendKeys(LASTNAME );

			// step6: save and verify

			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

			String lastName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

			if (lastName.contains(LASTNAME )) {

				System.out.println(lastName + "----passed");
			} else {

				System.out.println(lastName + "---failed");
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
