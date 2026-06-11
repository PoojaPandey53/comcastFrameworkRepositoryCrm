package organisationTest;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.CreateOrganisationpage;
import elementRepository.HomePage;
import elementRepository.OrganisationInfoPage;
import elementRepository.OrganisationPage;
import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.WebDriverUtility;

public class ToCreateOrganisationWithIndustryTest extends BaseClass {
	@Test(groups="regression")
	public void ToCreateOrganisationWithIndustryTest_02() throws EncryptedDocumentException, IOException {

		ExcelFileUtility eutil = new ExcelFileUtility();
		WebDriverUtility wutil = new WebDriverUtility();

		// step3: navigation to organisation link

		HomePage hp = new HomePage(driver);
		hp.getOrganisationsLink().click();

		// step4: click on create organisation look up image

		OrganisationPage op = new OrganisationPage(driver);
		op.getOrganisationLookupclick().click();

		// step5: create organisation with mandotory fields
		String ORGNAME = eutil.toReadDataFromExcelFile("organisations", 1, 2);

		Random r = new Random();
		int randomNumber = r.nextInt(1000);

		CreateOrganisationpage cop = new CreateOrganisationpage(driver);
		cop.getOrganisationTextField().sendKeys(ORGNAME + randomNumber);

		WebElement DROPDOWNTEXTFIELD = cop.getIndustryDropdownTextField();

//select chemicals in the industry dropdown 
		wutil.toHandledropdown(DROPDOWNTEXTFIELD, "Chemicals");

//step6: save and verify 

		cop.getOrganisationSaveButton().click();

		OrganisationInfoPage oip = new OrganisationInfoPage(driver);
		String orgName = oip.getOrganisationSaveHeader().getText();

		Assert.assertTrue(orgName.contains(ORGNAME));

	}

}
