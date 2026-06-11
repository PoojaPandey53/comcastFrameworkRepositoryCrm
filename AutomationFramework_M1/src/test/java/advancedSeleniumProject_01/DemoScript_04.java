package advancedSeleniumProject_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DemoScript_04 {

	public static void main(String[] args) {
		
		//step1:launch a browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		// Step2: login to application with valid credentials 
		driver.get("http://localhost:8888/");
		
		WebElement userName = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		
		userName.clear();
		userName.sendKeys("admin");
		
		password.clear();
		password.sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		
		//step3: navigation to organisation link 
		driver.findElement(By.linkText("Organizations")).click();
		
		//step4: click on create organisation look up image
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//step5: create organisation with mandotory fields
		
		driver.findElement(By.name("accountname")).sendKeys("flipkart");
		
		//select energy in the industry dropdown 
		
		WebElement industryDropdown = driver.findElement(By.name("industry"));
			
			Select industrySelect = new Select (industryDropdown);
			
			industrySelect.selectByValue("Energy");
	// select customer in the type dropdown 
			
		WebElement typeDropdown = driver.findElement(By.name("accounttype"));
			
			Select typeSelect = new Select (typeDropdown);
			typeSelect.selectByValue("Customer");
		
			
			//step6: save and verify 
			
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
	  String orgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			
			if (orgName.contains("flipkart")){
				
				System.out.println( orgName+"----passed");
			}
			else {
				
				System.out.println(orgName+"------failed");
			}	
			
			//step7: logout of application 
			
			 WebElement logoutEle = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
					
					
					Actions action = new Actions(driver);
					
					action.moveToElement(logoutEle).perform();
					
					driver.findElement(By.linkText("Sign Out")).click();
					
					// step8:  close the browser 
					
					driver.quit();
			
			
			
		
	}
}
