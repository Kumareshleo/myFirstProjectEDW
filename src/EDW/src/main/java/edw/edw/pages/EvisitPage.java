package edw.edw.pages;

import org.openqa.selenium.WebDriver;

import edw.edw.commonLib.Controls;
import edw.edw.frameLib.Driver;

public class EvisitPage extends Driver {
	public WebDriver driver;
	Controls controls;

	public EvisitPage(WebDriver driver) {
		this.driver = driver;
		controls = new Controls(driver);

	}

	// switch to the physician search Frame
	public void switchToEvisitPageFrame() {
		controls.switchToFrame("eVisit", "CSS_evisit_Iframe");
	}

	public void switchToParentFrame() {
		controls.switchToDefaultContent();
	}


	// verify page Header
	public String getPageHeader() {
		return controls.getText("eVisit", "CSS_header");
	}

	// verify page Header Paragraph
	public String getPageHeaderParagraph() {
		return controls.getText("eVisit", "CSS_header_paragraph");
	}
	
	public boolean isAllVisitsLinkAvailable()
	{
		return controls.isDisplayed("eVisit", "CSS_all_evisits_link");
	}

	
	public void clickOnAllEVisitsLink()
	{
		controls.actionsClick("eVisit", "CSS_all_evisits_link");
	}
	
	public String getPaymentOption()
	{
		return controls.getText("eVisit", "CSS_payment_option");
	}
		
	public boolean isPDFLinkAvailable()
	{
		return controls.isDisplayed("eVisit", "CSS_evisit_pdf_link");
	}
	
	public boolean isPhysicalAddressTextboxAvailable()
	{
		return controls.isDisplayed("eVisit", "CSS_physical_address_textbox");
	}
	public void clearPhysicalAddress()
	{
		controls.clear("eVisit", "CSS_physical_address_textbox");
	}
	
	public boolean isCityTextBoxAvailable()
	{
		return controls.isDisplayed("eVisit", "CSS_city_textbox");
	}
	
	public void clearCity()
	{
		controls.clear("eVisit", "CSS_city_textbox");
	}
	
	
	public void typePhysicalAddress(String address)
	{
		controls.type("eVisit", "CSS_physical_address_textbox", address);
	}
	
	public void typeCity(String city)
	{
		controls.type("eVisit", "CSS_city_textbox", city);
	}
	
	public boolean isStateDropdownAvailable()
	{
		return controls.isDisplayed("eVisit", "CSS_state_dropdown");
	}
	
	public boolean isZipCodeTextBoxAvailable()
	{
		return controls.isDisplayed("eVisit", "CSS_zipcode_textbox");
	}
	
	public boolean isPhoneNumberTextBoxAvailable()
	{
		return controls.isDisplayed("eVisit", "CSS_phone_textbox");
	}
	
	public boolean isSavePhoneCheckBoxAvailable()
	{
		return controls.isDisplayed("eVisit", "CSS_save_phone_checkbox");
	}
	
	
	public void clickOnSavePhoneCheckbox()
	{
		 controls.actionsClick("eVisit", "CSS_save_phone_checkbox");
	}
	
	public void clickOnReceiveNotificationsCheckbox()
	{
		 controls.actionsClick("eVisit", "CSS_receive_text_notifications_checkbox");
	}
	
	public boolean isReceiveNotificationsCheckBoxAvailable()
	{
		return controls.isDisplayed("eVisit", "CSS_receive_text_notifications_checkbox");
	}
	
	
	public boolean isStartEVisitButtonAvailable()
	{
		return controls.isDisplayed("eVisit", "CSS_start_evisit_button");
	}
	
	public boolean isStartEVisitButtonEnabled()
	{
		return controls.isEnabled("eVisit", "CSS_start_evisit_button");
	}
	
	public void clickOnStartEVisitButton()
	{
		 controls.actionsClick("eVisit", "CSS_start_evisit_button");
	}
	
	
	public boolean isHealthPlanPaymentOptionAvailable()
	{
		return controls.isDisplayed("eVisit", "CSS_MHE_payment_option_healthplan");
	}
	
	public boolean isCashPaymentOptionAvailable()
	{
		return controls.isDisplayed("eVisit", "CSS_MHE_payment_option_cash");
	}
	
	public void clickOnHealthPlanPaymentOption()
	{
		controls.actionsClick("eVisit", "CSS_MHE_payment_option_healthplan");
	}
	
	
	public void clickOnPayByCashPaymentOption()
	{
		controls.actionsClick("eVisit", "CSS_MHE_payment_option_cash");
	}
	
	
	public boolean isVisitForCheckboxAvailable()
	{
		return controls.isDisplayed("eVisit", "CSS_MHE_Visit_for");
	}

	
	public void clickOnVisitForCheckbox()
	{
		controls.actionsClick("eVisit", "CSS_MHE_Visit_for");
	}
	
	public void switchToZipnosisPageFrame() {
		controls.switchToFrame("eVisit", "CSS_Zipnosis_iframe");
	}
	
	public boolean isViewAllHistoryLinkAvailable()
	{
		return controls.isDisplayed("eVisit", "CSS_View_All_History_Link");
	}
	
	public String getZipnosisPageHeader()
	{
		return controls.getText("eVisit", "CSS_header");
	}
	
	public boolean isStartNewEvisitLinkAvailable()
	{
		return controls.isDisplayed("eVisit", "CSS_start_new_evisit_link");
	}
	
	public boolean isAgreeCheckboxAvailable()
	{
		return controls.isDisplayed("eVisit", "CSS_agree_checkbox");
	}
	
	public boolean isAcknowledgeCheckboxAvailable()
	{
		return controls.isDisplayed("eVisit", "CSS_acknowledge_checkbox");
	}
	
	public boolean isContinueButtonAvailable()
	{
		return controls.isDisplayed("eVisit", "CSS_continue_button");
	}
	
	public boolean isCancelEvisitAvailable()
	{
		return controls.isDisplayed("eVisit", "CSS_cancel_evisit_button");
	}
	
	public void clickOnContinueButton()
	{
		controls.actionsClick("eVisit", "CSS_continue_button");
	}
	
	public String getErrorMessage()
	{
		return controls.getText("eVisit", "CSS_error_message_zipnosis_page");
	}
	
	public void clickOnAcknowledgeCheckbox()
	{
		controls.actionsClick("eVisit", "CSS_acknowledge_checkbox");
	}
	
	public void clickOnAgreeCheckbox()
	{
		controls.actionsClick("eVisit", "CSS_agree_checkbox");
	}
	
	public String getInterviewPageHeader()
	{
		return controls.getText("eVisit", "CSS_zipnosis_interview");
	}
	
}
