package edw.edw.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import edw.edw.frameLib.Log;
import edw.edw.commonLib.Controls;
import edw.edw.frameLib.Driver;

public class DeductibleTrackerPage extends Driver {
	public WebDriver driver;
	public WebDriverWait wait;
	Controls controls;

	public DeductibleTrackerPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, time);
		controls = new Controls(driver);

	}
	
	public String getPageHeader()
	
	{
		return controls.getText("deductibleTracker", "CSS_pageHeader");
	}
	
	public int countOfDependentTracker()
	{
		int total = controls.numberOfElementsSimiliarIdentifier("deductibleTracker", "CSS_single_tracker");
		
		return total - 2;
	}
	
	public String memberName()
	{
		return controls.getText("deductibleTracker", "CSS_member_name");
	}
	
	public void dependentsName()
	{
		List<String> dependents =controls.textOfElements("deductibleTracker", "CSS_dependents_section", "CSS_dependents_name");
	for(String dep : dependents)
	{
		Log.info("Dependent Name : " +  dep);
	}
	}
	
	public void clickOnParticularDependentDetail()
	{
		controls.actionsClick("deductibleTracker", "CSS_particular_dependent_link");
	}
	
	public boolean isDetailsTableDisplayed(){
		return controls.isDisplayed("deductibleTracker","CSS_dependents_detail_table");
	}
	
	
	public void switchToDeductibleDetailsTrackerFrame() {
		controls.switchToFrame("deductibleTracker", "CSS_details_deductible_frame");
		
	

	}

	


}
