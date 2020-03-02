package edw.edw.pagelets;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import edw.edw.frameLib.Driver;
import edw.edw.frameLib.Log;
import edw.edw.frameLib.ReadExcel;
import edw.edw.pages.FindFacilityPage;
import edw.edw.pages.HomePage;
import edw.edw.pages.LoginPage;

public class FindFacilityTest extends Driver {
	LoginPage loginPage;
	HomePage homePage;
	FindFacilityPage findFacilityPage;

	@Override
	public void PageSetup() {
		driver.get(appURL);
		Log.info("Navigating to url : " + appURL);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		findFacilityPage = new FindFacilityPage(driver);
		ReadExcel.setExcelFile("loginApplication");
	}

	@DataProvider
    public Object[][] Authentication() throws Exception{

         Object[][] testObjArray = ReadExcel.getMultipleData();

         return (testObjArray);

		}

	@Test(dataProvider="Authentication")
	public void findFacilityTest(String userName,String password,String userType) throws Exception {

		Log.startTestCase("Test_Case_ID : 003 : ");

		loginPage.loginToApplication(userName, password);

		// Verify Home Label displayed
		Assert.assertTrue(homePage.isHomeLabelDisplayed());
		Log.info("User is successfully Logged In");

		// switch to iframe of find pagelets
		homePage.switchToFindPageletFrame();

		// Verify Find a Facility Pagelet
		Assert.assertTrue(homePage.isFindAFaciliytPageletAvailable());
		Log.info("Find A Facility Pagelet is available.");

		homePage.clickOnFindAFacilityLink();;
		Log.info("Clicked On Find A Facility Link");

		ReadExcel.setExcelFile("findFacility");

		findFacilityPage.switchToFacilitySearchFrame();

		Assert.assertTrue(findFacilityPage.getPageHeader().equalsIgnoreCase(ReadExcel.getCellData(1, 1)));
		Log.info("Navigated to Find A Facility Page Successfully.");

		Assert.assertTrue(findFacilityPage.isLocationFilterDisplayed());
		Log.info("Location Filter is available.");

		Assert.assertTrue(findFacilityPage.isFacilityDropdownAvailable());
		Log.info("Facility Dropdown is available.");


		Log.endTestCase("Test Case ID : 003 is QA verified.");

	}

}
