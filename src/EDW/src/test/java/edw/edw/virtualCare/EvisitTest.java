package edw.edw.virtualCare;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import edw.edw.frameLib.Driver;
import edw.edw.frameLib.Log;
import edw.edw.frameLib.ReadExcel;
import edw.edw.pages.EvisitPage;
import edw.edw.pages.HomePage;
import edw.edw.pages.LoginPage;

public class EvisitTest extends Driver {
	LoginPage loginPage;
	HomePage homePage;
	EvisitPage eVisitPage;

	@Override
	public void PageSetup() {
		driver.get(appURL);
		Log.info("Navigating to url : " + appURL);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		eVisitPage = new EvisitPage(driver);
	}

	@DataProvider
	public Object[][] Authentication() throws Exception {

		Object[][] testObjArray = ReadExcel.getMultipleData();

		return (testObjArray);

	}

	@Test(dataProvider = "Authentication")
	public void eVisitTest(String userName, String password, String userType, String applicationType,
			String employeeType, String executionType) throws Exception {

		if (executionType.equalsIgnoreCase("yes")) {
			Log.startTestCase("Test_Case_ID : 009 : Verify the evisit page under virtual care. ");

			loginPage.loginToApplication(userName, password);

			// Verify Home Label displayed
			Assert.assertTrue(homePage.isHomeLabelDisplayed());
			Log.info("User is successfully Logged In");

			if (applicationType.equalsIgnoreCase("mobile")) {
				homePage.clickOnMobileTabForLeftMenu();
			}

			// Verify Virtual Care is available
			Assert.assertTrue(homePage.isVirtualCareLeftPanelLink());
			Log.info("Virtual Care Tab is present in left Panel.");

			homePage.clickOnVirtualCareLink();
			Log.info("Clicked On Virtual Care Link");

			// Verify EVisit Link is available
			Assert.assertTrue(homePage.isEvisitLeftPanelLink());
			Log.info("EVisit Link is present in left Panel.");

			homePage.clickOnEvisitLink();
			Log.info("Clicked On EVisit Link");

			ReadExcel.setExcelFile("eVisit");

			eVisitPage.switchToEvisitPageFrame();

			if (!(userType.equalsIgnoreCase("dependent"))) {

				Assert.assertEquals(eVisitPage.getPageHeader(), (ReadExcel.getCellData(1, 1)));
				Log.info("Navigated to EVisit Page Successfully.");

				Assert.assertEquals(eVisitPage.getPageHeaderParagraph(), (ReadExcel.getCellData(2, 1)));
				Log.info("Verified That Page header has following paragraph : " + ReadExcel.getCellData(2, 1));

				// Assert.assertTrue(eVisitPage.isPDFLinkAvailable());
				// Log.info("Verified that eVisit pdf details link is available.");

				Assert.assertTrue(eVisitPage.isAllVisitsLinkAvailable());
				Log.info("Verified that All EVisits link is available.");

				eVisitPage.isPhysicalAddressTextboxAvailable();
				Log.info("Verified that physical address textbox is available.");

				eVisitPage.isCityTextBoxAvailable();
				Log.info("Verified that City textbox is available.");

				eVisitPage.isStateDropdownAvailable();
				Log.info("Verified that State dropdown is available.");

				eVisitPage.isZipCodeTextBoxAvailable();
				Log.info("Verified that ZipCode textbox is available.");

				eVisitPage.isPhoneNumberTextBoxAvailable();
				Log.info("Verified that Phone Number textbox is available.");

				eVisitPage.isSavePhoneCheckBoxAvailable();
				Log.info("Verified that Save Phone Checkbox is available.");

				eVisitPage.isReceiveNotificationsCheckBoxAvailable();
				Log.info("Verified that Receive Text Notifications Checkbox is available.");

				eVisitPage.isStartEVisitButtonAvailable();
				Log.info("Verified that Start EVisit Button is available.");

				if (employeeType.equalsIgnoreCase("MHNE")) {
					Assert.assertTrue(eVisitPage.getPaymentOption().contains("25"));
					Log.info("Verified that payment option for MH Non-Employee is $25");

					Assert.assertTrue(eVisitPage.isStartEVisitButtonEnabled());
					Log.info("Verified that Start EVisit Button is not greyed out.");

					eVisitPage.clearPhysicalAddress();
					Log.info("Clear Physical Address Textbox");

					eVisitPage.clearCity();
					Log.info("Clear City Textbox");

					Assert.assertFalse(eVisitPage.isStartEVisitButtonEnabled());
					Log.info("Verified that Start EVisit Button is greyed out.");

					eVisitPage.typePhysicalAddress(ReadExcel.getCellData(3, 1));
					Log.info("Entered Physical Address : " + ReadExcel.getCellData(3, 1));

					eVisitPage.typeCity(ReadExcel.getCellData(4, 1));
					Log.info("Entered City : " + ReadExcel.getCellData(4, 1));
				}

				else if (employeeType.equalsIgnoreCase("MHE")) {

					Assert.assertFalse(eVisitPage.isStartEVisitButtonEnabled());
					Log.info("Verified that Start EVisit Button is greyed out.");

					Assert.assertTrue(eVisitPage.isHealthPlanPaymentOptionAvailable());
					Log.info("Payment Option of $15 for health plan is available ");

					Assert.assertTrue(eVisitPage.isCashPaymentOptionAvailable());
					Log.info("Payment Option of $25 pay by cash is available ");

					eVisitPage.clickOnHealthPlanPaymentOption();
					Log.info("Payment Option for HealthPlan of $15 is selected.");

					if (userType.equalsIgnoreCase("memberpatient")) {
						eVisitPage.isVisitForCheckboxAvailable();
						Log.info("Visit For Option available.");

						eVisitPage.clickOnVisitForCheckbox();
						Log.info("Visit For Checkbox is selected.");
					}

					Thread.sleep(5000);

					Assert.assertTrue(eVisitPage.isStartEVisitButtonEnabled());
					Log.info("Verified that Start EVisit Button is not greyed out.");

				}

				else {
					Assert.fail("Please Provide Employee Type as MHE or MHNE");
				}

				eVisitPage.clickOnSavePhoneCheckbox();
				Log.info("Save Phone checkbox is selected.");

				eVisitPage.clickOnReceiveNotificationsCheckbox();
				Log.info("Receive Notifications checkbox is selected.");

//				eVisitPage.clickOnStartEVisitButton();
//				Log.info("Click on start EVisit Button");

//				Thread.sleep(20000);
//
//				eVisitPage.switchToZipnosisPageFrame();
//				Log.info("Switched to Zipnosis frame.");
//
//				Assert.assertTrue(eVisitPage.isViewAllHistoryLinkAvailable());
//				Log.info("Verified that view all history link is available.");
//
//				Assert.assertEquals(eVisitPage.getZipnosisPageHeader(), ReadExcel.getCellData(5, 1));
//				Log.info("Verified that zipnosis page header : " + ReadExcel.getCellData(5, 1));
//
//				Assert.assertTrue(eVisitPage.isStartNewEvisitLinkAvailable());
//				Log.info("Verified that Start New Evisit link is available.");
//
//				Assert.assertTrue(eVisitPage.isCancelEvisitAvailable());
//				Log.info("Verified that Cancel Evisit Button is available.");
//
//				Assert.assertTrue(eVisitPage.isContinueButtonAvailable());
//				Log.info("Verified that Continue Button is available.");
//
//				Assert.assertTrue(eVisitPage.isAgreeCheckboxAvailable());
//				Log.info("Verified that Agree Terms Checkbox is available.");
//
//				Assert.assertTrue(eVisitPage.isAcknowledgeCheckboxAvailable());
//				Log.info("Verified that Acknowledge Checkbox is available.");
//
//				eVisitPage.clickOnContinueButton();
//				Log.info("Clicked on Continue Button");
//
//				Assert.assertEquals(eVisitPage.getErrorMessage(), ReadExcel.getCellData(6, 1));
//				Log.info("Verified the error message on zipnosis page for not selecting mandatory checkboxes.");
//
//				eVisitPage.clickOnAgreeCheckbox();
//				Log.info("Selected Agree Terms checkbox.");
//
//				eVisitPage.clickOnAcknowledgeCheckbox();
//				Log.info("Selected Acknowledgement checkbox.");
//
//				eVisitPage.clickOnContinueButton();
//				Log.info("Clicked on Continue Button");
//
//				Thread.sleep(5000);
//
//				Assert.assertEquals(eVisitPage.getInterviewPageHeader(), ReadExcel.getCellData(7, 1));
//				Log.info("Verified that interview steps page is loaded successfully.");

			} else {
				Assert.assertFalse(eVisitPage.getPageHeader().equalsIgnoreCase(ReadExcel.getCellData(1, 1)));
				Log.info("Evisit Page is unavailable for the dependent below 18.");
			}

			eVisitPage.switchToParentFrame();

			homePage.clickOnUserProfileTab();
			Log.info("Clicked On user profile.");

			homePage.clickOnSignOutButton();
			Log.info("Clicked On Sign Out Button.");

			Thread.sleep(5000);

			Assert.assertTrue(loginPage.isSignInButtonDisplayed());
			Log.info("User is logged out successfully.");

			Log.endTestCase("Test Case ID : 009 is QA verified Evisit page");

		} else {
			Log.info("Script will not be executed for this user as suggested in settings.");
		}

	}
}
