package edw.edw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import edw.edw.commonLib.Controls;
import edw.edw.frameLib.Driver;

public class ProfilePage extends Driver {
	public WebDriver driver;
	public WebDriverWait wait;
	Controls controls;

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, time);
		controls = new Controls(driver);

	}
	// Verify Profile pagelet Displayed
	// public boolean isProfileFormDisplayed() {
	// return controls.isDisplayed("Profile", "CSS_profileForm");
	// }

	// verify Profile pagelet is available or not
	public void clickOnProfileOverviewTab() {
		controls.javaScriptClick("profile", "CSS_profileOverviewTab");
	}

	public String getHeaderText() {
		return controls.getText("profile", "CSS_header");
	}

	public void switchToProfileFrame() {
		controls.switchToFrame("profile", "CSS_iframe_profile_overview");
	}

	
 public boolean isPersonalInfoCardAvailable()
 {
	return controls.isDisplayed("profile", "CSS_personal_info_card");
 }
 
 public boolean isSignSecurityCardAvailable()
 {
	return controls.isDisplayed("profile", "CSS_sign_security_card");
 }
 
 public boolean isAccountPreferenceCardAvailable()
 {
	return controls.isDisplayed("profile", "CSS_account_preferences_card");
 }
 
 public void clickOnAccountPrefenceLink()
 {
	 controls.actionsClick("profile", "CSS_account_preferences_card");
 }
}
