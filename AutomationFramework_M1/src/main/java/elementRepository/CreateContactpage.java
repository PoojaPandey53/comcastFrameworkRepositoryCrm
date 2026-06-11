package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactpage {
	
	//constructor
		public CreateContactpage (WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(name="lastname")
		private WebElement lastnametextField;
		
		
		public WebElement getLastnametextField() {
			return lastnametextField;
		}


		public WebElement getSaveButton() {
			return SaveButton;
		}

		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement SaveButton;


		@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
		private WebElement selectOrganisationLookUpClick;


		public WebElement getSelectOrganisationLookUpClick() {
			return selectOrganisationLookUpClick;
		}

        @FindBy(linkText="amazon")
        private WebElement amazonSelectedLink;

		public WebElement getAmazonSelectedLink() {
			return amazonSelectedLink;
		}
		
		public WebElement getSupport_end_dateTextField() {
			return support_start_dateTextField;	
		}
		@FindBy(name="support_start_date")
		private WebElement support_start_dateTextField;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
