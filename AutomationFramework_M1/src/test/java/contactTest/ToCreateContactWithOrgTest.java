package contactTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.jspecify.annotations.Nullable;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.ContactInfoPage;
import elementRepository.ContactsPage;
import elementRepository.CreateContactpage;
import elementRepository.HomePage;
import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.WebDriverUtility;

public class ToCreateContactWithOrgTest extends BaseClass {

	@Test(groups="smoke")
	public void toCreateContactWithOrgTest() throws EncryptedDocumentException, IOException {

		ExcelFileUtility eutil = new ExcelFileUtility();
		String LASTNAME = eutil.toReadDataFromExcelFile("contacts", 1, 2);
		WebDriverUtility wutil = new WebDriverUtility();

		// Step3:navigate to contacts link
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		// step4: click on create contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.getToCreateLookUpImageClick().click();

		// step5: create contact with mandotory fields
		CreateContactpage ccp = new CreateContactpage(driver);
		ccp.getLastnametextField().sendKeys(LASTNAME);
		ccp.getSelectOrganisationLookUpClick().click();

		wutil.ToSwitchwindow(driver, "Accounts");
		ccp.getAmazonSelectedLink().click();
		wutil.ToSwitchwindow(driver, "Contacts");

		// step5: save and verify
		ccp.getSaveButton().click();

		ContactInfoPage cip = new ContactInfoPage(driver);
		String lastnamesaveHeader = cip.getContactsSaveHeader().getText();
		Assert.assertTrue(lastnamesaveHeader.contains(LASTNAME));

	}

}
