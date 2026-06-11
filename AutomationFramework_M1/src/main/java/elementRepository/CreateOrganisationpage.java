package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganisationpage {

	//constructor
	
			public CreateOrganisationpage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
	
		@FindBy(name="accountname")	
		private WebElement organisationTextField;
			
		@FindBy(xpath="//input[@title='Save [Alt+S]']")	
		private WebElement organisationSaveButton;

		public WebElement getOrganisationTextField() {
			return organisationTextField;
		}

		public WebElement getOrganisationSaveButton() {
			return organisationSaveButton;
		}
			
		@FindBy(name="industry")
		private WebElement industryDropdownTextField;

		public WebElement getIndustryDropdownTextField() {
			return industryDropdownTextField;
		}
			@FindBy (name="accounttype")
			private WebElement typeDropDowntextField;
			
			
			public WebElement getTypeDropDowntextField() {
				return typeDropDowntextField;
			}
		
			@FindBy (id="dtlview_Phone")
			private WebElement OrgPhoNumbAfterSavetext;
			
			
			public WebElement getOrgPhoNumbAfterSavetext() {
				return OrgPhoNumbAfterSavetext;
			}
		
		
			
			
	
}
