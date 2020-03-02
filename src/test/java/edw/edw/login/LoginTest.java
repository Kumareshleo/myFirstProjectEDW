package edw.edw.login;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import edw.edw.frameLib.Driver;
import edw.edw.frameLib.Log;
import edw.edw.frameLib.ReadExcel;
import edw.edw.pages.HomePage;
import edw.edw.pages.LoginPage;
import edw.edw.pages.TestLeaf_CRM;

public class LoginTest extends Driver {

	TestLeaf_CRM crm;
	//	LoginPage loginPage;
	//	HomePage homePage;

	@Override
	public void PageSetup() {
		driver.get(appURL);
		Log.info("Navigating to url : " + appURL);
		crm = new TestLeaf_CRM(driver);
		//		loginPage = new LoginPage(driver);
		//		homePage = new HomePage(driver);
		ReadExcel.setExcelFile("TestLeafExcel");
	}

	@Test
	public void logintest() throws Exception {

		crm.enterUserName(ReadExcel.getCellData(1, 1));
		Log.info("Entered the valid username id : " + ReadExcel.getCellData(1, 1));

		crm.enterPassword(ReadExcel.getCellData(2, 1));
		Log.info("Entered the valid password : " + ReadExcel.getCellData(2, 1));

		crm.ClickonLogin();
		Log.info("LoggedIn Successful");

		crm.ClickonCRMBtn();
		Log.info("ClickedButton Successful");

		crm.ClickonLeads();
		Log.info("Clicked Leads Button Successful");

		crm.ClickonCreateLeadBtn1();
		Log.info("Clicked Lead Button Successful");

		crm.enterCompanyName(ReadExcel.getCellData(3, 1));
		Log.info("Entered the valid Company Name : " + ReadExcel.getCellData(3, 1));

		crm.enterForeName(ReadExcel.getCellData(4, 1));
		Log.info("Entered the valid ForeName : " + ReadExcel.getCellData(4, 1));

		crm.enterSurName(ReadExcel.getCellData(5, 1));
		Log.info("Entered the valid SurName : " + ReadExcel.getCellData(5, 1));

		crm.enterFirstName(ReadExcel.getCellData(6, 1));
		Log.info("Entered the valid FirstName : " + ReadExcel.getCellData(6, 1));

		crm.enterLastName(ReadExcel.getCellData(7, 1));
		Log.info("Entered the valid LastName : " + ReadExcel.getCellData(7, 1));

		crm.enterSalutation(ReadExcel.getCellData(8, 1));
		Log.info("Entered the valid Salutation : " + ReadExcel.getCellData(8, 1));

		crm.enterTitle(ReadExcel.getCellData(9, 1));
		Log.info("Entered the valid Title : " + ReadExcel.getCellData(9, 1));

		crm.enterDepartment(ReadExcel.getCellData(10, 1));
		Log.info("Entered the valid Department : " + ReadExcel.getCellData(10, 1));

		crm.enterAnnualRevenue(String.valueOf(ReadExcel.getNumericCellValue(11, 1)));
		Log.info("Entered the valid Annual Revenue : " + String.valueOf(ReadExcel.getNumericCellValue(11, 1)));

		crm.enterNumberofEmployees(String.valueOf(ReadExcel.getNumericCellValue(12, 1)));
		Log.info("Entered the valid Number of Employees : " + String.valueOf(ReadExcel.getNumericCellValue(12, 1)));

		crm.enterSICcode(String.valueOf(ReadExcel.getNumericCellValue(13, 1)));
		Log.info("Entered the valid SIC Code : " + String.valueOf(ReadExcel.getNumericCellValue(13, 1)));

		crm.enterTickerSymbol(ReadExcel.getCellData(14, 1));
		Log.info("Entered the valid Ticker Symbol : " + ReadExcel.getCellData(14, 1));

		crm.enterDescription(ReadExcel.getCellData(15, 1));
		Log.info("Entered the valid Description : " + ReadExcel.getCellData(15, 1));

		crm.enterImportantNote(ReadExcel.getCellData(16, 1));
		Log.info("Entered the valid Importnant Note : " + ReadExcel.getCellData(16, 1));

		crm.enterAreaCode(String.valueOf(ReadExcel.getNumericCellValue(17, 1)));
		Log.info("Entered the valid Area Code : " + String.valueOf(ReadExcel.getNumericCellValue(17, 1)));

		crm.enterPhoneNumber(String.valueOf(ReadExcel.getNumericCellValue(18, 1)));
		Log.info("Entered the valid Phone Number : " + String.valueOf(ReadExcel.getNumericCellValue(18, 1)));

		crm.enterExtension(String.valueOf(ReadExcel.getNumericCellValue(19, 1)));
		Log.info("Entered the valid Extension : " + String.valueOf(ReadExcel.getNumericCellValue(19, 1)));

		crm.enterPersonToAskFor(ReadExcel.getCellData(20, 1));
		Log.info("Entered the valid Person to Ask For : " + ReadExcel.getCellData(20, 1));

		crm.enterEmailAddress(ReadExcel.getCellData(21, 1));
		Log.info("Entered the valid email address : " + ReadExcel.getCellData(21, 1));

		crm.enterWebURL(ReadExcel.getCellData(22, 1));
		Log.info("Entered the valid Web URL : " + ReadExcel.getCellData(22, 1));

		crm.enterToName(ReadExcel.getCellData(23, 1));
		Log.info("Entered the valid To Name : " + ReadExcel.getCellData(23, 1));

		crm.enterAttentionName(ReadExcel.getCellData(24, 1));
		Log.info("Entered the valid Attention Name : " + ReadExcel.getCellData(24, 1));

		crm.enterAddressLine1(ReadExcel.getCellData(25, 1));
		Log.info("Entered the valid Address Line 1 : " + ReadExcel.getCellData(25, 1));

		crm.enterAddressLine2(ReadExcel.getCellData(26, 1));
		Log.info("Entered the valid Address Line 2 : " + ReadExcel.getCellData(26, 1));

		crm.enterCity(ReadExcel.getCellData(27, 1));
		Log.info("Entered the valid City : " + ReadExcel.getCellData(27, 1));

		crm.SelectCountry(102);
		Thread.sleep(1000);
		crm.SelectState(31);
		Thread.sleep(1000);
		crm.enterPostalCode(String.valueOf(ReadExcel.getNumericCellValue(28, 1)));
		Log.info("Entered the valid Postal Code : " + String.valueOf(ReadExcel.getNumericCellValue(28, 1)));
		Thread.sleep(2000);
		crm.ClickonCreateLeadBTN();
		Log.info("Create Lead Successful");
		Thread.sleep(3000);
		
//		crm.ClickonFindLeadBTN();
//		Log.info("Clicked on Find Lead Button Successful");
//
//		crm.ClickonEmailBTN();
//		Log.info("Clicked on Email Button Successful");
//
//		crm.enterEmailID(ReadExcel.getCellData(28, 1));
//		Log.info("Entered the valid Email ID : " + ReadExcel.getCellData(28, 1));

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//	@DataProvider
	//	public Object[][] Authentication() throws Exception {
	//		Object[][] testObjArray = ReadExcel.getMultipleData();
	//		return (testObjArray);
	//
	//	}
	//
	//	@Test(dataProvider = "Authentication")
	//	public void loginTest(String userName, String password, String userType, String applicationType,
	//			String employeeType, String executionType) throws Exception {
	//		if (executionType.equalsIgnoreCase("yes")) {
	//			Log.startTestCase("Test_Case_ID : 001 : Login into EDW and Verify the dashboard");
	//			// Enter Email Address
	//			loginPage.enterEmailAddress(userName);
	//			Log.info("Entered Email Address : " + userName);
	//
	//			// Enter Password
	//			loginPage.enterPassword(password);
	//			Log.info("Entered Password : " + password);
	//
	//			// Click Sign In button
	//			loginPage.clickOnSignInButton();
	//			Log.info("Clicked on Sign In Button");
	//
	//			// Verify Home Label displayed
	//			Assert.assertTrue(homePage.isHomeLabelDisplayed());
	//			Log.info("User is successfully Logged In");
	//			Log.info("HOME in left panel is available.");
	//
	//			if (applicationType.equalsIgnoreCase("mobile")) {
	//				homePage.clickOnMobileTabForLeftMenu();
	//			}
	//
	//			// Verify Find Doctor Left Panel
	//			Assert.assertTrue(homePage.isFindDoctorLeftDisplayed());
	//			Log.info("Find A doctor or facility  is available in left panel.");
	//
	//			// Verify Pay Bill in left Panel
	//			Assert.assertTrue(homePage.isPayBillLeftDisplayed());
	//			Log.info("Pay Bill is available in left Panel.");
	//
	//			// Verify Find a Doctor in left panel
	//			Assert.assertTrue(homePage.isFindADoctorLeftPanelLink());
	//			Log.info("Find A Doctor or Service Link Avaialble in left panel.");
	//
	//			if (applicationType.equalsIgnoreCase("mobile")) {
	//				homePage.clickOnHomeLabel();
	//			}
	//
	//			// switch to iframe of evisit pagelets
	//			homePage.switchToEvisitPageletFrame();
	//
	//			Assert.assertTrue(homePage.isEvisitButtonAvailable());
	//			Log.info("Evisit Pagelet is Available");
	//			
	//			Log.info("DashBoard is loaded successfully");
	//			
	//			homePage.switchToParentFrame();
	//
	//			homePage.clickOnUserProfileTab();
	//			Log.info("Clicked On user profile.");
	//
	//			homePage.clickOnSignOutButton();
	//			Log.info("Clicked On Sign Out Button.");
	//
	//			Thread.sleep(5000);
	//
	//			Assert.assertTrue(loginPage.isSignInButtonDisplayed());
	//			Log.info("User is logged out successfully.");
	//
	//			Log.endTestCase("Test Case ID : 001 is QA verified that user is able to login in the application.");
	//
	//		} else {
	//			Log.info("Script will not be executed for this user as suggested in settings.");
	//		}
	//	}
}
