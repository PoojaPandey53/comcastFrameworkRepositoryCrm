package contactTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import elementRepository.ContactInfoPage;
import elementRepository.ContactsPage;
import elementRepository.CreateContactpage;
import elementRepository.HomePage;
import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;

@Listeners(genericUtility.ListenersImplementation.class)
public class ToCreateContactTest extends BaseClass {

	@Test(groups="smoke")
	public void toCreateContact_01() throws EncryptedDocumentException, IOException {

		// Step3:navigate to contacts link
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		// step4: click on create contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.getToCreateLookUpImageClick().click();

		// step5: create contact with mandotory fields
		ExcelFileUtility eutil = new ExcelFileUtility();
		String LASTNAME = eutil.toReadDataFromExcelFile("contacts", 1, 2);
		CreateContactpage ccp = new CreateContactpage(driver);
		ccp.getLastnametextField().sendKeys(LASTNAME);
		// step6: save and verify
		ccp.getSaveButton().click();
		
        Assert.fail();//fail 
		ContactInfoPage cip = new ContactInfoPage(driver);
		String lastnamesaveHeader = cip.getContactsSaveHeader().getText();
		Assert.assertTrue(lastnamesaveHeader.contains(LASTNAME));

	}

}
