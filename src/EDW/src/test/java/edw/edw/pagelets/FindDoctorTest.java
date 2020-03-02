package edw.edw.pagelets;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import edw.edw.frameLib.Driver;
import edw.edw.frameLib.Log;
import edw.edw.frameLib.ReadExcel;
import edw.edw.pages.FindDoctorPage;
import edw.edw.pages.HomePage;
import edw.edw.pages.LoginPage;

public class FindDoctorTest extends Driver {
	LoginPage loginPage;
	HomePage homePage;
	FindDoctorPage findDoctorPage;

	@Override
	public void PageSetup() {
		driver.get(appURL);
		Log.info("Navigating to url : " + appURL);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		findDoctorPage = new FindDoctorPage(driver);
	}
	
	@DataProvider
    public Object[][] Authentication() throws Exception{

         Object[][] testObjArray = ReadExcel.getMultipleData();

         return (testObjArray);

		}

	@Test(dataProvider="Authentication")
	public void findDoctorTest(String userName,String password,String userType,String applicationType) throws Exception {

		Log.startTestCase("Test_Case_ID : 003 : Verify the find a doctor or facility page. ");

		loginPage.loginToApplication(userName, password);

		// Verify Home Label displayed
		Assert.assertTrue(homePage.isHomeLabelDisplayed());
		Log.info("User is successfully Logged In");

		if(applicationType.equalsIgnoreCase("mobile"))
		{
			homePage.clickOnMobileTabForLeftMenu();
		}

		// Verify Find a Doctor Pagelet
		Assert.assertTrue(homePage.isFindADoctorLeftPanelLink() );
		Log.info("Find A Doctor Link is present in level Panel.");

		homePage.clickOnFindADoctorLink();
		Log.info("Clicked On Find A Doctor Link");

		ReadExcel.setExcelFile("findDoctor");

		findDoctorPage.switchToPhysicianSearchFrame();
		
		Assert.assertTrue(findDoctorPage.getPageHeader().equalsIgnoreCase(ReadExcel.getCellData(1, 1)));
		Log.info("Navigated to Find A Doctor Page Successfully.");

		Assert.assertTrue(findDoctorPage.isLocationFilterDisplayed());
		Log.info("Filters are available.");

		Assert.assertTrue(findDoctorPage.isSearchPhysicianAvailable());
		Log.info("Physician Searchbox is available.");

		//Assert.assertTrue(findDoctorPage.isPhysicianDirectoryLinkAvailable());
		//Log.info("Physician Directory link is available.");

		Log.endTestCase("Test Case ID : 003 is QA verified Find a Doctor or Facility page");

	}

}
