package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	//constructor
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement ToCreateLookUpImageClick;
	
	
	public WebElement getToCreateLookUpImageClick() {
		return ToCreateLookUpImageClick;
	}
	
	
	



	
	
	
}