package edw.edw.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import edw.edw.frameLib.Log;
import edw.edw.commonLib.Controls;
import edw.edw.frameLib.Driver;

public class InsurancePage extends Driver {
	public WebDriver driver;
	public WebDriverWait wait;
	Controls controls;

	public InsurancePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, time);
		controls = new Controls(driver);

	}
	
	public String getPageHeader()
	
	{
		return controls.getText("insurance", "CSS_pageHeader");
	}
	
	public int countOfPageletsAvailable()
	{
return controls.numberOfElementsSimiliarIdentifier("insurance", "CSS_view_idcard_link");
		
	}
	
	
	public void textOfLinksAvailable()
	{
		List<String> links =controls.textOfElements("insurance", "CSS_main_pagelet_partition_tag", "CSS_view_idcard_link");
	for(String link : links)
	{
		Log.info("Link  :  " +  link + " is available.");
	}
	}
	
	public void textOfAvailablePageletsHeader()
	{
		List<String> headers =controls.textOfElements("insurance", "CSS_main_pagelet_partition_tag", "CSS_pagelet_header");
	for(String head : headers)
	{
		Log.info("Pagelet with Header  :  " +  head + " is available.");
	}
	}
	
	public void clickOnViewIDCards()
	{
		controls.actionsClick("insurance", "CSS_view_idcard_link");
	}
	
	public boolean isDetailsViewIDCardsDisplayed(){
		return controls.isDisplayed("insurance", "CSS_view_idcard_link");
	}
	
	public void clickOnViewBenefits()
	{
		controls.actionsClick("insurance", "CSS_view_benefits_link");
	}
	
	public boolean isViewBenefitsDisplayed() throws InterruptedException{
		Thread.sleep(5000);
		return controls.isDisplayedExceptedTrue("insurance", "CSS_view_benefits_link");
	}
	
	public void clickOnViewClaims()
	{
		controls.actionsClick("insurance", "CSS_view_claims_link");
	}
	
	public boolean isViewClaimsDisplayed(){
		return controls.isDisplayedExceptedTrue("insurance", "CSS_view_claims_link");
	}
	
	
	public void switchToInsuranceFrame() {
		controls.switchToFrame("insurance", "CSS_iframe_insurance");
		
	}

	public void visibilityOfPageElementsLoad()
	{
		controls.waitUntilVisibilityForAllElements("insurance", "CSS_view_idcard_link");
	}
	
	public boolean isViewBackSideOfCard()
	{
		return controls.isDisplayed("insurance", "CSS_view_back_side_of_card ");
	}
	
	public void clickOnViewOtherSideOfCard()
	{
		controls.actionsClick("insurance", "CSS_view_back_side_of_card ");
	}
	
	public String getTextForOtherSide()
	{
		return controls.getText("insurance", "CSS_view_back_side_of_card ");
	}
	public void visibilityOfIdcardMenu()
	{
		controls.waitUntilVisibilityForAllElements("insurance", "CSS_header_links");
		
	}
	
	public void textOfAllMenuItems()
	{
		List<String> headers =controls.textOfElements("insurance", "CSS_menu_card_idcard", "CSS_header_links");
		for(String head : headers)
		{
			Log.info("Pagelet with Header  :  " +  head + " is available.");
		}
	}
	
	public void returnBackToInsurance()
	{
		controls.actionsClick("insurance", "CSS_go_back_insurance_main_link");
	}
	
	public String IdCardHeader()
	{
		return controls.getText("insurance", "CSS_idcard_page_title");
	}
	


}
