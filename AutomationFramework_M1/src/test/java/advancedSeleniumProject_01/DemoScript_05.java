package advancedSeleniumProject_01;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoScript_05 {
	
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
		
		//Step3:navigate to contacts link
		
				driver.findElement(By.linkText("Contacts")).click();
				
				//step4: click on create  contact look up image
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				
				//step5: create contact with mandotory fields
				
				driver.findElement(By.name("lastname")).sendKeys("pandeys");
				
				//find the parent window 
				String parentId = driver.getWindowHandle();
		
		//select the organisation from organisation look up image 
				
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		
		//select organisation use switch  to window to child 

		 Set<String> childIds = driver.getWindowHandles();
		 for (String ids:childIds ) {
			 
			 driver.switchTo().window(ids);
		 }
		driver.findElement(By.linkText("google")).click();
		
		// re switch to child window to parent window
		driver.switchTo().window(parentId);
		
		
		//step6: save and verify 
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
  String orgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if (orgName.contains("pandeys")){
			
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
