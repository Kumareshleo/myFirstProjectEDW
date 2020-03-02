package edw.edw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import edw.edw.commonLib.Controls;
import edw.edw.frameLib.Driver;

public class FindFacilityPage extends Driver {
	public WebDriver driver;
	public WebDriverWait wait;
	Controls controls;

	public FindFacilityPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, time);
		controls = new Controls(driver);

	}

	// Verify Location Filter Displayed
	public boolean isLocationFilterDisplayed() {
		return controls.isDisplayed("findFacility", "CSS_locationFilterLink");
	}

	// switch to the Facility search Frame
	public void switchToFacilitySearchFrame() {
		controls.switchToFrame("findFacility", "CSS_facility_search_Iframe");
	}

	public void switchToParentFrame() {
		controls.switchToDefaultContent();
	}

	// verify Facility dropdown
	public boolean isFacilityDropdownAvailable() {
		return controls.isDisplayed("findFacility", "CSS_facilities_Dropdown");
	}

	// verify page Header
	public String getPageHeader() {
		return controls.getText("findFacility", "CSS_header");
	}
}
