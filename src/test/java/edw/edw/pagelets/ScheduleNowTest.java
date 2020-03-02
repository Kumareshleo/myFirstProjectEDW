package edw.edw.pagelets;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import edw.edw.frameLib.Driver;
import edw.edw.frameLib.Log;
import edw.edw.frameLib.ReadExcel;
import edw.edw.pages.HomePage;
import edw.edw.pages.LoginPage;
import edw.edw.pages.ScheduleNowPage;

public class ScheduleNowTest extends Driver {
	LoginPage loginPage;
	HomePage homePage;
	ScheduleNowPage scheduleNowPage;

	@Override
	public void PageSetup() {
		driver.get(appURL);
		Log.info("Navigating to url : " + appURL);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		scheduleNowPage = new ScheduleNowPage(driver);
		ReadExcel.setExcelFile("loginApplication");
	}
	
	@DataProvider
    public Object[][] Authentication() throws Exception{

         Object[][] testObjArray = ReadExcel.getMultipleData();

         return (testObjArray);

		}
	
	@Test(dataProvider="Authentication")
	public void scheduleNowTest(String userName,String password,String userType,String applicationType) throws Exception {

		
		Log.startTestCase("Test_Case_ID : 002 : ");

		loginPage.loginToApplication(userName, password);

		// Verify Home Label displayed
		Assert.assertTrue(homePage.isHomeLabelDisplayed());
		Log.info("User is successfully Logged In");
		
		if(!userType.equalsIgnoreCase("customer"))
		{
		

		// switch to iframe of appointment pagelets
		homePage.switchToEvisitPageletFrame();

		// Verify Schedule Now
		Assert.assertTrue(homePage.isEvisitButtonAvailable());
		Log.info("Appointment Pagelet is available");
		Log.info("Schedule Now Button is available");


		homePage.clickOnScheduleNowButton();
		Log.info("Clicked On Schedule Now Button ");

		ReadExcel.setExcelFile("scheduleNow");

		scheduleNowPage.switchToScheduleNowWindow();

		Assert.assertTrue(scheduleNowPage.getPageHeader().equalsIgnoreCase(ReadExcel.getCellData(1, 1)));
		Log.info("Navigated to Schedule Now Page Successfully.");

		Assert.assertTrue(scheduleNowPage.isScheduleNowFormDisplayed());
		Log.info("Schedule Now Form is loaded Successfully.");

		

	}
		else
		{
			Log.info("This Functionality is not available for the user type with which you logged in");
		}
		


		Log.endTestCase("Test Case ID : 002 is QA verified.");

	}
}
