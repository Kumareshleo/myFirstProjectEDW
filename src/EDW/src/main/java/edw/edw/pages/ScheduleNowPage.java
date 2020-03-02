package edw.edw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import edw.edw.commonLib.Controls;
import edw.edw.frameLib.Driver;

public class ScheduleNowPage extends Driver {
	public WebDriver driver;
	public WebDriverWait wait;
	Controls controls;

	public ScheduleNowPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, time);
		controls = new Controls(driver);

	}

	// Verify Schedule Now Form Displayed
	public boolean isScheduleNowFormDisplayed() {
		return controls.isDisplayed("scheduleNow", "CSS_scheduleNowForm");
	}


   public void switchToScheduleNowWindow()
   {
	   controls.connectToLatestWindow();
   }

	// verify page Header
	public String getPageHeader() {
		return controls.getText("scheduleNow", "CSS_header");
	}

	
	

}
