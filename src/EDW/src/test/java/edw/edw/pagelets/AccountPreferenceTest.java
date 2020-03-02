package edw.edw.pagelets;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import edw.edw.frameLib.Driver;
import edw.edw.frameLib.Log;
import edw.edw.frameLib.ReadExcel;
import edw.edw.pages.AccountPrefencePage;
import edw.edw.pages.HomePage;
import edw.edw.pages.LoginPage;
import edw.edw.pages.ProfilePage;

public class AccountPreferenceTest extends Driver {
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	AccountPrefencePage accountPreferencePage;

	@Override
	public void PageSetup() {
		driver.get(appURL);
		Log.info("Navigating to url : " + appURL);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		profilePage = new ProfilePage(driver);
		accountPreferencePage = new AccountPrefencePage(driver);
		ReadExcel.setExcelFile("loginApplication");
	}

	@DataProvider
	public Object[][] Authentication() throws Exception {

		Object[][] testObjArray = ReadExcel.getMultipleData();

		return (testObjArray);

	}

	@Test(dataProvider = "Authentication")
	public void accountPreferenceTest(String userName, String password, String userType, String applicationType,
			String employeeType, String executionType) throws Exception {
		if (executionType.equalsIgnoreCase("yes")) {
			Log.startTestCase("Test_Case_ID : 003 : Verify Account Preference page.");

			loginPage.loginToApplication(userName, password);

			// Verify Home Label displayed
			Assert.assertTrue(homePage.isHomeLabelDisplayed());
			Log.info("User is successfully Logged In");
			
			homePage.clickOnUserProfileTab();
			Log.info("Clicked On user profile.");

			profilePage.clickOnProfileOverviewTab();
			Log.info("Clicked On Profile Overview");
			
			Thread.sleep(7000);

			profilePage.switchToProfileFrame();

		    Assert.assertEquals(profilePage.getHeaderText(), "PROFILE OVERVIEW");
			Log.info("Verified page header is : " + profilePage.getHeaderText());

			Assert.assertTrue(profilePage.isAccountPreferenceCardAvailable());
			Log.info("Verified Account Preferences Card is Available.");
			
			profilePage.clickOnAccountPrefenceLink();
			Log.info("Clicked On Account Preference Link.");

			homePage.switchToParentFrame();
			
			Thread.sleep(15000);
			
			accountPreferencePage.switchToAccountFrame();
			
			Assert.assertEquals(accountPreferencePage.getHeaderText(), "ACCOUNT PREFERENCES");
			Log.info("Verified page header is : " + accountPreferencePage.getHeaderText());
			
			Assert.assertEquals(accountPreferencePage.getSubHeaderText(), "SET AND CONTROL YOUR ACCOUNT PREFERENCES");
			Log.info("Verified page sub header is : " + accountPreferencePage.getSubHeaderText());
			
			homePage.switchToParentFrame();

			homePage.clickOnUserProfileTab();
			Log.info("Clicked On user profile.");

			homePage.clickOnSignOutButton();
			Log.info("Clicked On Sign Out Button.");

			Thread.sleep(5000);

			Assert.assertTrue(loginPage.isSignInButtonDisplayed());
			Log.info("User is logged out successfully.");

			Log.endTestCase("Test Case ID : 003 is QA verified Account Preference Page.");

		} else {
			Log.info("Script will not be executed for this user as suggested in settings.");
		}
	}
}
