package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

//constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Organizations")
	private WebElement organisationsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorlink; 
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getOrganisationsLink() {
		return organisationsLink;
	}

	public WebElement getAdministratorlink() {
		return administratorlink;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
