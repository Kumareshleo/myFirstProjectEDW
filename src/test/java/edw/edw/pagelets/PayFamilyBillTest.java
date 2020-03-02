package edw.edw.pagelets;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import edw.edw.frameLib.Driver;
import edw.edw.frameLib.Log;
import edw.edw.frameLib.ReadExcel;
import edw.edw.pages.HomePage;
import edw.edw.pages.LoginPage;
import edw.edw.pages.PayFamilyBillPage;

public class PayFamilyBillTest extends Driver {
	LoginPage loginPage;
	HomePage homePage;
	PayFamilyBillPage payFamilyBillPage;

	@Override
	public void PageSetup() {
		driver.get(appURL);
		Log.info("Navigating to url : " + appURL);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		payFamilyBillPage = new PayFamilyBillPage(driver);
		ReadExcel.setExcelFile("loginApplication");
	}

	@DataProvider
    public Object[][] Authentication() throws Exception{

         Object[][] testObjArray = ReadExcel.getMultipleData();

         return (testObjArray);

		}
	
	@Test(dataProvider="Authentication")
	public void payFamilyBillTest(String userName,String password,String userType) throws Exception {
		
		if(userType.equalsIgnoreCase("patient")||userType.equalsIgnoreCase("patientmember")||userType.equalsIgnoreCase("memberpatient"))
		{

		Log.startTestCase("Test_Case_ID : 006 : ");

		loginPage.loginToApplication(userName, password);

		// Verify Home Label displayed
		Assert.assertTrue(homePage.isHomeLabelDisplayed());
		Log.info("User is successfully Logged In");

		// switch to iframe of billing
		homePage.switchToBillingPageletFrame();

		// Verify Pay Bill Pagelet
		Assert.assertTrue(homePage.isBillingPayPageletAvailable());
		Log.info("Pay Bill Pagelet is available");
		Log.info("Pay My Bill Link is available");
		
		//Verify Family's Link
		Assert.assertTrue(homePage.isViewMoreDetailsLinkAvailable());
		Log.info("View More Details Link is available");


		//click on pay bill link
		homePage.clickOnPayFamilyBillLink();
		Log.info("Clicked On Pay Family's Member Bill Link");

		homePage.switchToNewOpenedWindow();

		ReadExcel.setExcelFile("payBill");
		
		Log.info("Family Bill Page Headline is : " + payFamilyBillPage.getPageHeader());
		
		payFamilyBillPage.accountNumberFieldIsAvailable();
		Log.info("Account Number Field is Available.");
		
		payFamilyBillPage.patientDOBFieldIsAvailable();
		Log.info("Patient Date Of Birth Field is Available.");
		
		
		payFamilyBillPage.viewMyBillIsAvailable();
		Log.info("View My Bill Button is Available.");
		
		


		Log.endTestCase("Test Case ID : 005 is QA verified.");
		}
		
		else
		{
			Log.endTestCase("This functionality is not for user Type : " + userType);
		}

	}

}
