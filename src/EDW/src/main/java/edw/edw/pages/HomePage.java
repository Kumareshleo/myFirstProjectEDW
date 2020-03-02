package edw.edw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import edw.edw.commonLib.Controls;
import edw.edw.frameLib.Driver;

public class HomePage extends Driver {
	public WebDriver driver;
	public WebDriverWait wait;
	Controls controls;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, time);
		controls = new Controls(driver);

	}

	// Verify Home In Left Panel
	public boolean isHomeLabelDisplayed() {
		return controls.isDisplayed("home", "CSS_home_Label");
	}

	public void clickOnHomeLabel() {
		controls.actionsClick("home", "CSS_home_Label");
	}

	// Verify Find A doctor In Left Panel
	public boolean isFindDoctorLeftDisplayed() {

		return controls.isDisplayed("home", "CSS_find_Doctor_Left_Panel");
	}

	// Verify Pay Bill In Left Panel
	public boolean isPayBillLeftDisplayed() {
		return controls.isDisplayed("home", "CSS_pay_Bill_Left_Panel");
	}

	// Verify Customer Support In Left Panel
	public boolean isCustomerSupportDisplayed() {
		return controls.isDisplayed("home", "CSS_customer_Support_Left_Panel");
	}

	// switch to the pagelets Frame
	public void switchToFindPageletFrame() {
		controls.switchToFrame("home", "CSS_find_Pagelet_Iframe");
	}

	public void switchToParentFrame() {
		controls.switchToDefaultContent();
	}

	public void switchToProfilePageletFrame() {
		controls.switchToFrame("home", "CSS_profile_Pagelet_Iframe");

	}

	public void switchToBillingPageletFrame() {
		controls.switchToFrame("home", "CSS_billing_Pagelet_Iframe");

	}

	public void switchToEvisitPageletFrame() {
		controls.switchToFrame("home", "CSS_evisit_Pagelet_Iframe");

	}

	public void switchToDeductibleTrackerPageletFrame() {
		controls.switchToFrame("home", "CSS_tracker_Pagelet_Iframe");

	}

	public void switchToKeyLabsPageletFrame() {
		controls.switchToFrame("home", "CSS_keyLabs_Pagelet_Iframe");

	}

	public void switchToMessagesPageletFrame() {
		controls.switchToFrame("home", "CSS_messages_Pagelet_Iframe");

	}

	// verify find a doctor pagelet is available or not
	public boolean isFindADoctorLeftPanelLink() {
		return controls.isDisplayed("home", "CSS_find_Doctor_Link");
	}

	public boolean isVirtualCareLeftPanelLink() {
		return controls.isDisplayed("home", "XPATH_virtual_care_tab");
	}

	public boolean isEvisitLeftPanelLink() {
		return controls.isDisplayed("home", "XPATH_evisit_link");
	}

	// verify find facility pagelet is available or not
	public boolean isFindAFaciliytPageletAvailable() {
		return controls.isDisplayed("home", "CSS_find_Facility_Link");
	}

	// verify find a billing statement pagelet is available or not
	public boolean isBillingPayPageletAvailable() {
		return controls.isDisplayed("home", "CSS_paybill_button");
	}

	// verify Profile pagelet is available or not
	public boolean isProfilePageletAvailable() {
		return controls.isDisplayed("home", "CSS_editpreference_Link");
	}

	public void clickOnPayBillButton() {
		controls.actionsClick("home", "CSS_paybill_button ");
	}

	public void switchToNewOpenedWindow() {
		controls.connectToLatestWindow();
	}

	public boolean isViewInsuranceClaimsLinkAvailable() {
		return controls.isDisplayed("home", "CSS_view_Insurance_Claim_Link");
	}

	public boolean isBillDetailsLinkAvailable() {
		return controls.isDisplayed("home", "CSS_Bill_Details_Link");
	}

	public void clickOnPayFamilyBillLink() {
		controls.actionsClick("home", "CSS_pay_SomeOneElse_Bill_Link");
	}

	public boolean isEvisitButtonAvailable() {
		return controls.isDisplayed("home", "CSS_evisit_Button");
	}

	public boolean isSendMessageButtonAvailable() {
		return controls.isDisplayed("home", "CSS_send_Message_Button");
	}

	public boolean isInboxLinkAvailable() {
		return controls.isDisplayed("home", "CSS_inbox_link");
	}

	public boolean isViewLabResultsLinkAvailable() {
		return controls.isDisplayed("home", "CSS_viewLab_Results_Link");

	}

	public void clickOnEditPreferenceLink() {
		controls.actionsClick("home", "CSS_editpreference_Link");
	}

	public boolean isEditPreferenceLinkAvailable() {
		return controls.isDisplayed("home", "CSS_editpreference_Link");
	}

	public void clickOnFindADoctorLink() {
		controls.actionsClick("home", "CSS_find_Doctor_Link");
	}

	public void clickOnVirtualCareLink() {
		controls.actionsClick("home", "XPATH_virtual_care_tab");
	}

	public void clickOnEvisitLink() {
		controls.actionsClick("home", "XPATH_evisit_link");
	}

	public void clickOnFindAFacilityLink() {
		controls.actionsClick("home", "CSS_find_Facility_Link");
	}

	public void clickOnScheduleNowButton() {
		controls.actionsClick("home", "CSS_scheduleNow_Button");
	}

	public boolean isViewMoreDetailsLinkAvailable() {
		return controls.isDisplayed("home", "CSS_view_more_details_link");
	}

	public void clickOnViewMoreDetailsLink() {
		controls.actionsClick("home", "CSS_view_more_details_link");
	}

	public String getTextOfDeductiblePagelet() {
		return controls.getText("home", "CSS_deductible_tracker_header");
	}

	public boolean deductibleTrackerGraphIsAvailable() {
		return controls.isDisplayed("home", "ID_deductible_tracker_graph");
	}

	public int countOfDeductibleBars() {
		return controls.numberOfElementsSimiliarIdentifier("home", "CSS_deductible_first_bar");
	}

	public String getTotalBalance() {
		return controls.getText("home", "CSS_total_balance");
	}

	public String getRemainingBalance() {
		return controls.getText("home", "CSS_remaining_balance");
	}

	public void clickOnSelfBar() {
		controls.actionsClick("home", "CSS_deductible_first_bar");
	}

	public void clickOnDependentBar() {
		controls.actionsClick("home", "CSS_deductible_second_bar");
	}

	public boolean isInsuranceLinkLeftPanel() {
		return controls.isDisplayed("home", "CSS_insurance_left_panel");
	}

	public void clickOnInsuranceLeftPanel() {
		controls.actionsClick("home", "CSS_insurance_left_panel");
	}

	public void clickOnMobileTabForLeftMenu() {
		controls.actionsClick("home", "CSS_mobile_tab_left_panel");
	}
	
	public void clickOnUserProfileTab() {
		controls.actionsClick("home", "CSS_userprofile_tab");
	}
	
	public void clickOnSignOutButton()
	{
		controls.javaScriptClick("home", "CSS_signout_tab");
	}

}
