package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	
	//constructor
		public OrganisationPage (WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	
@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement organisationLookupclick;

public WebElement getOrganisationLookupclick() {
	return organisationLookupclick;
}	
		
}
