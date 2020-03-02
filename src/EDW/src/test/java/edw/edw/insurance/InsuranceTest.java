package edw.edw.insurance;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import edw.edw.frameLib.Driver;
import edw.edw.frameLib.Log;
import edw.edw.frameLib.ReadExcel;
import edw.edw.pages.HomePage;
import edw.edw.pages.InsurancePage;
import edw.edw.pages.LoginPage;

public class InsuranceTest extends Driver {
	LoginPage loginPage;
	HomePage homePage;
	InsurancePage insurancePage;

	@Override
	public void PageSetup() {
		driver.get(appURL);
		Log.info("Navigating to url : " + appURL);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		insurancePage = new InsurancePage(driver);
		ReadExcel.setExcelFile("loginApplication");
	}

	
	@DataProvider
    public Object[][] Authentication() throws Exception{

         Object[][] testObjArray = ReadExcel.getMultipleData();

         return (testObjArray);

		}

	@Test(dataProvider="Authentication")
	public void insuranceTest(String userName,String password,String userType,String applicationType) throws Exception {

		Log.startTestCase("Test_Case_ID : 5 : Verify the Insurance for Member Persona");

		loginPage.loginToApplication(userName, password);

		// Verify Home Label displayed
		Assert.assertTrue(homePage.isHomeLabelDisplayed());
		Log.info("User is successfully Logged In");
		
		if(applicationType.equalsIgnoreCase("mobile"))
		{
			homePage.clickOnMobileTabForLeftMenu();
		}

		 if (userType.equalsIgnoreCase("member")||userType.equalsIgnoreCase("memberPatient")) {
		
			 Assert.assertTrue(homePage.isInsuranceLinkLeftPanel());
		Log.info("Insurance Link is Available On left panel");
		
		homePage.clickOnInsuranceLeftPanel();
		Log.info("Clicked On Insurance Left  Panel Link");
				
		// switch to iframe of insurance pagelets
				insurancePage.switchToInsuranceFrame();
				
				insurancePage.visibilityOfPageElementsLoad();

				Assert.assertTrue(insurancePage.isViewBenefitsDisplayed());
				Log.info("View Benefits Link is visible on page.");
				
				Assert.assertTrue(insurancePage.isViewClaimsDisplayed());
				Log.info("View Claims Link is visible on page.");
				
				Assert.assertTrue(insurancePage.isDetailsViewIDCardsDisplayed());
				Log.info("View ID CARDS Link is visible on page.");
				
				Assert.assertEquals(insurancePage.getPageHeader(),"INSURANCE");
				Log.info("Page Header verified i.e. INSURANCE");

				Assert.assertEquals(insurancePage.countOfPageletsAvailable(),3);
				Log.info("Total 3 Pagelets Available");
				
				insurancePage.textOfAvailablePageletsHeader();
				
				insurancePage.textOfLinksAvailable();
				
				insurancePage.clickOnViewIDCards();
				Log.info("Clicked On View ID Cards Link.");
				
				homePage.switchToParentFrame();
			
		 }
		 else{
			   Assert.assertFalse(homePage.isInsuranceLinkLeftPanel());
				Log.info("Insurance Link is not  Available On left panel");
		 }

		Log.endTestCase("Test Case ID : 05 is QA verified.");
	}
}