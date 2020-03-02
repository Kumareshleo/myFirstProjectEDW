package edw.edw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import edw.edw.commonLib.Controls;
import edw.edw.frameLib.Driver;

public class AccountPrefencePage extends Driver {
	public WebDriver driver;
	public WebDriverWait wait;
	Controls controls;

	public AccountPrefencePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, time);
		controls = new Controls(driver);

	}
	
	
	public String getHeaderText() {
		return controls.getText("accountPreference", "CSS_header");
	}

	public void switchToAccountFrame() {
		controls.switchToFrame("accountPreference", "CSS_iframe_account_preference");
	}
	
	public String getSubHeaderText() {
		return controls.getText("accountPreference", "CSS_sub_header");
	}


	
 
}
