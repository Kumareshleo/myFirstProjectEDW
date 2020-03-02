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
import edw.edw.pages.PayBillPage;

public class PayBillTest extends Driver {
	LoginPage loginPage;
	HomePage homePage;
	PayBillPage payBillPage;

	@Override
	public void PageSetup() {
		driver.get(appURL);
		Log.info("Navigating to url : " + appURL);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		payBillPage = new PayBillPage(driver);
		ReadExcel.setExcelFile("loginApplication");
	}

	@DataProvider
    public Object[][] Authentication() throws Exception{

         Object[][] testObjArray = ReadExcel.getMultipleData();

         return (testObjArray);

		}

	@Test(dataProvider="Authentication")
	public void payBillTest(String userName,String password,String userType,String applicationType) throws Exception {

		Log.startTestCase("Test_Case_ID : 005 : Verify Pay Bill");

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

		//click on pay bill link
		homePage.clickOnPayBillButton();
		Log.info("Clicked On Pay Bill Button");

		homePage.switchToNewOpenedWindow();

		ReadExcel.setExcelFile("payBill");

		Log.endTestCase("Test Case ID : 005 is QA verified.");

	}

}
