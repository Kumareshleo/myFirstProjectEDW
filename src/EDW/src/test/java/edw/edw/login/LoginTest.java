package edw.edw.login;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import edw.edw.frameLib.Driver;
import edw.edw.frameLib.Log;
import edw.edw.frameLib.ReadExcel;
import edw.edw.pages.HomePage;
import edw.edw.pages.LoginPage;

public class LoginTest extends Driver {
	LoginPage loginPage;
	HomePage homePage;

	@Override
	public void PageSetup() {
		driver.get(appURL);
		Log.info("Navigating to url : " + appURL);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		ReadExcel.setExcelFile("loginApplication");
	}

	@DataProvider
	public Object[][] Authentication() throws Exception {
		Object[][] testObjArray = ReadExcel.getMultipleData();
		return (testObjArray);

	}

	@Test(dataProvider = "Authentication")
	public void loginTest(String userName, String password, String userType, String applicationType,
			String employeeType, String executionType) throws Exception {
		if (executionType.equalsIgnoreCase("yes")) {
			Log.startTestCase("Test_Case_ID : 001 : Login into EDW and Verify the dashboard");
			// Enter Email Address
			loginPage.enterEmailAddress(userName);
			Log.info("Entered Email Address : " + userName);

			// Enter Password
			loginPage.enterPassword(password);
			Log.info("Entered Password : " + password);

			// Click Sign In button
			loginPage.clickOnSignInButton();
			Log.info("Clicked on Sign In Button");

			// Verify Home Label displayed
			Assert.assertTrue(homePage.isHomeLabelDisplayed());
			Log.info("User is successfully Logged In");
			Log.info("HOME in left panel is available.");

			if (applicationType.equalsIgnoreCase("mobile")) {
				homePage.clickOnMobileTabForLeftMenu();
			}

			// Verify Find Doctor Left Panel
			Assert.assertTrue(homePage.isFindDoctorLeftDisplayed());
			Log.info("Find A doctor or facility  is available in left panel.");

			// Verify Pay Bill in left Panel
			Assert.assertTrue(homePage.isPayBillLeftDisplayed());
			Log.info("Pay Bill is available in left Panel.");

			// Verify Find a Doctor in left panel
			Assert.assertTrue(homePage.isFindADoctorLeftPanelLink());
			Log.info("Find A Doctor or Service Link Avaialble in left panel.");

			if (applicationType.equalsIgnoreCase("mobile")) {
				homePage.clickOnHomeLabel();
			}

			// switch to iframe of evisit pagelets
			homePage.switchToEvisitPageletFrame();

			Assert.assertTrue(homePage.isEvisitButtonAvailable());
			Log.info("Evisit Pagelet is Available");
			
			Log.info("DashBoard is loaded successfully");
			
			homePage.switchToParentFrame();

			homePage.clickOnUserProfileTab();
			Log.info("Clicked On user profile.");

			homePage.clickOnSignOutButton();
			Log.info("Clicked On Sign Out Button.");

			Thread.sleep(5000);

			Assert.assertTrue(loginPage.isSignInButtonDisplayed());
			Log.info("User is logged out successfully.");

			Log.endTestCase("Test Case ID : 001 is QA verified that user is able to login in the application.");

		} else {
			Log.info("Script will not be executed for this user as suggested in settings.");
		}

	}
}
