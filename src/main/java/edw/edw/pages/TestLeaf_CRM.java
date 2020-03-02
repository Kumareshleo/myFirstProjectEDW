package edw.edw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import edw.edw.commonLib.Controls;
import edw.edw.frameLib.Driver;

public class TestLeaf_CRM extends Driver {

	public WebDriver driver;
	public WebDriverWait wait ;
	Controls controls;

	public TestLeaf_CRM(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new WebDriverWait(driver, time);
		controls = new Controls(driver);
	}
	
	public void enterUserName(String data) {
		controls.type("Leaf1", "CSS_username",data);
	}

	public void enterPassword(String data) {
		controls.type("Leaf1", "CSS_pwd", data);
	}
	
	public void ClickonLogin()
	{
		controls.actionsClick("Leaf1", "CSS_login_button");
	}	

	public void ClickonCRMBtn()
	{
		controls.actionsClick("Leaf1", "XPATH_crm_button");
	}
	
	public void ClickonLeads()	
	{
		controls.actionsClick("Leaf1", "XPATH_leads");
	}

	public void ClickonCreateLeadBtn1()	
	{
		controls.actionsClick("Leaf1", "XPATH_createlead_button");
	}

	public void enterCompanyName(String data) {
		controls.type("Leaf1", "CSS_companyname", data);
	}

	public void enterForeName(String data) {
		controls.type("Leaf1", "CSS_forename", data);
	}

	public void enterSurName(String data) {
		controls.type("Leaf1", "CSS_surname", data);
	}

	public void enterFirstName(String data) {
		controls.type("Leaf1", "CSS_firstname", data);
	}

	public void enterLastName(String data) {
		controls.type("Leaf1", "CSS_lastname", data);
	}

	public void enterSalutation(String data) {
		controls.type("Leaf1", "CSS_salutation", data);
	}
	public void enterTitle(String data) {
		controls.type("Leaf1", "CSS_title", data);
	}

	public void enterDepartment(String data) {
		controls.type("Leaf1", "CSS_department", data);
	}

	public void enterAnnualRevenue(String data) {
		controls.type("Leaf1", "CSS_annualrevenue", data);
	}

	public void enterNumberofEmployees(String data) {
		controls.type("Leaf1", "CSS_numberofemployees", data);
	}

	public void enterSICcode(String data) {
		controls.type("Leaf1", "CSS_siccode", data);
	}

	public void enterTickerSymbol(String data) {
		controls.type("Leaf1", "CSS_tickersymbol", data);
	}

	public void enterDescription(String data) {
		controls.type("Leaf1", "CSS_description", data);
	}

	public void enterImportantNote(String data) {
		controls.type("Leaf1", "CSS_importantnote", data);
	}

	public void enterAreaCode(String data) {
		controls.type("Leaf1", "ID_areacode", data);
	}

	public void enterPhoneNumber(String data) {
		controls.type("Leaf1", "CSS_phonenumber", data);
	}

	public void enterExtension(String data) {
		controls.type("Leaf1", "CSS_extension", data);
	}

	public void enterPersonToAskFor(String data) {
		controls.type("Leaf1", "CSS_persontoaskfor", data);
	}

	public void enterEmailAddress(String data) {
		controls.type("Leaf1", "CSS_emailaddress", data);
	}

	public void enterWebURL(String data) {
		controls.type("Leaf1", "CSS_weburl", data);
	}

	public void enterToName(String data) {
		controls.type("Leaf1", "CSS_toname", data);
	}

	public void enterAttentionName(String data) {
		controls.type("Leaf1", "CSS_attentionname", data);
	}

	public void enterAddressLine1(String data) {
		controls.type("Leaf1", "CSS_addressline1", data);
	}

	public void enterAddressLine2(String data) {
		controls.type("Leaf1", "CSS_addressline2", data);
	}

	public void enterCity(String data) {
		controls.type("Leaf1", "CSS_city", data);
	}
	
	public void SelectCountry(int index)
	{
		controls.selectDropDownByIndex("Leaf1", "CSS_dropdown1", index);
	}
	
	public void SelectState(int index)
	{
		controls.selectDropDownByIndex("Leaf1", "CSS_dropdown2", index);
	}

	public void enterPostalCode(String data) {
		controls.type("Leaf1", "CSS_postalcode", data);
	}

	public void ClickonCreateLeadBTN()
	{
		controls.actionsClick("Leaf1", "XPATH_createlead_button1");
	}
	
//	public void ClickonFindLeadBTN()
//	{
//		controls.click(By.xpath(controls.readProperty("Leaf1", "findleads")));
//	}
//	
//	public void ClickonEmailBTN()
//	{
//		controls.click(By.id(controls.readProperty("Leaf1", "ext-gen854")));
//	}
//	
//	public void enterEmailID(String data) {
//		controls.type(By.xpath(controls.readProperty("Leaf1", "emailbtn")), data);
//	}
//	
//	public void ClickonFindLeadsBTN()
//	{
//		controls.click(By.id(controls.readProperty("Leaf1", "findleadsbtn")));
//	}

}