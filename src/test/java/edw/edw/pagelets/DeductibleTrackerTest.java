package edw.edw.pagelets;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import edw.edw.frameLib.Driver;
import edw.edw.frameLib.Log;
import edw.edw.frameLib.ReadExcel;
import edw.edw.pages.DeductibleTrackerPage;
import edw.edw.pages.HomePage;
import edw.edw.pages.LoginPage;

public class DeductibleTrackerTest extends Driver {
	LoginPage loginPage;
	HomePage homePage;
	DeductibleTrackerPage deductibleTrackerPage;

	@Override
	public void PageSetup() {
		driver.get(appURL);
		Log.info("Navigating to url : " + appURL);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		deductibleTrackerPage = new DeductibleTrackerPage(driver);
		ReadExcel.setExcelFile("loginApplication");
	}


	@DataProvider
    public Object[][] Authentication() throws Exception{

         Object[][] testObjArray = ReadExcel.getMultipleData();

         return (testObjArray);

		}

	@Test(dataProvider="Authentication")
	public void deductibleTrackerTest(String userName,String password,String userType) throws Exception {

		Log.startTestCase("Test_Case_ID : 008 : ");

		loginPage.loginToApplication(userName, password);

		// Verify Home Label displayed
		Assert.assertTrue(homePage.isHomeLabelDisplayed());
		Log.info("User is successfully Logged In");

		 if (userType.equalsIgnoreCase("member")) {
		homePage.switchToParentFrame();

				// switch to iframe of deductible Tracker pagelets
				homePage.switchToDeductibleTrackerPageletFrame();

				Log.info("Switched to Pagelet " + homePage.getTextOfDeductiblePagelet());
				
				Assert.assertTrue(homePage.isViewMoreDetailsLinkAvailable());
				Log.info("Deductible Tracker Pagelet is Available");
				Log.info("View More Details Link is Available");
				
				Assert.assertTrue(homePage.deductibleTrackerGraphIsAvailable());
				Log.info("Balance Progress Graph is available.");
				
				if(homePage.countOfDeductibleBars() == 2)
				{
					Assert.assertTrue(true);
					Log.info("Tracker Available for both family and self");
					
					homePage.clickOnSelfBar();
					Log.info("Clicked on Self Button");
					
					Log.info("Total Balance for self is : " +homePage.getTotalBalance());

					Log.info("Remaining Balance for self is : " +homePage.getRemainingBalance());
					
					homePage.clickOnDependentBar();
					Log.info("Clicked On dependent Button");
					
					Log.info("Total Balance for dependent is : " +homePage.getTotalBalance());

					Log.info("Remaining Balance for dependent is : " +homePage.getRemainingBalance());
					
					homePage.clickOnViewMoreDetailsLink();
					Log.info("Click On View More Details Link");
					
					// switch to iframe of deductible Tracker pagelets
					deductibleTrackerPage.switchToDeductibleDetailsTrackerFrame();

		
			Log.info(" Number of dependents Tracker  : " +	deductibleTrackerPage.countOfDependentTracker());

			Assert.assertEquals(deductibleTrackerPage.getPageHeader(),"BENEFITS");
			Log.info("Page Header is found as expected.");
			
			Log.info("Member Name is : " + deductibleTrackerPage.memberName());
			
			deductibleTrackerPage.dependentsName();
			
			deductibleTrackerPage.clickOnParticularDependentDetail();
			Log.info("Clicked on first dependent details.");
			
		
			Log.info("Successfully Navigating to : " +  deductibleTrackerPage.getPageHeader());
			Log.info("Benefits detailed table is displayed for the dependent");
			
			
			Assert.assertTrue(deductibleTrackerPage.isDetailsTableDisplayed());
			
			
			
				}
				else
				{
					Assert.assertTrue(false,"Tracker is not Available for both family and self and bars available is "+ homePage.countOfDeductibleBars());
					
				}

		
		 }
		 else{
		 
		 Log.info("This functionality is available only for User those are " + userType);
		 }

		Log.endTestCase("Test Case ID : 005 is QA verified.");

	}

}
