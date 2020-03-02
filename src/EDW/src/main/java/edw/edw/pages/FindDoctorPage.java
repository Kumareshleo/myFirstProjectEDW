package edw.edw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import edw.edw.commonLib.Controls;
import edw.edw.frameLib.Driver;

public class FindDoctorPage extends Driver {
	public WebDriver driver;
	public WebDriverWait wait;
	Controls controls;

	public FindDoctorPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, time);
		controls = new Controls(driver);

	}

	// Verify Location Filter Displayed
	public boolean isLocationFilterDisplayed() {
		return controls.isDisplayed("findDoctor", "CSS_locationFilterLink");
	}

	// switch to the physician search Frame
	public void switchToPhysicianSearchFrame() {
		controls.switchToFrame("findDoctor", "CSS_physician_search_Iframe");
	}

	public void switchToParentFrame() {
		controls.switchToDefaultContent();
	}

	
	// verify searchBoxAvailable or not
	public boolean isSearchPhysicianAvailable() {
		return controls.isDisplayed("findDoctor", "CSS_searchPhysicianBox");
	}

	// verify page Header
	public String getPageHeader() {
		return controls.getText("findDoctor", "CSS_header");
	}

	// verify  Physician Directory Link
	//public boolean isPhysicianDirectoryLinkAvailable() {
		//return controls.isDisplayed("findDoctor", "CSS_physician_Directory_Link");
	//}
	
	
}
