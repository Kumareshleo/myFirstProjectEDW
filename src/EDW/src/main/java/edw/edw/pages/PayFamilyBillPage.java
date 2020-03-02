package edw.edw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import edw.edw.commonLib.Controls;
import edw.edw.frameLib.Driver;

public class PayFamilyBillPage extends Driver {
	public WebDriver driver;
	public WebDriverWait wait;
	Controls controls;

	public PayFamilyBillPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, time);
		controls = new Controls(driver);

	}

	
public String getPageHeader()
{
	return controls.getText("payFamilyBill", "CSS_pageHeader");
}

public boolean accountNumberFieldIsAvailable()
{
	return controls.isDisplayed("payFamilyBill", "CSS_accountNumber");
}

public boolean patientDOBFieldIsAvailable()
{
	return controls.isDisplayed("payFamilyBill", "CSS_patientDOB");
}

public boolean viewMyBillIsAvailable()
{
	return controls.isDisplayed("payFamilyBill", "ID_viewMyBill");
}



public void typeAccountNumber(String accountNumber)
{
	controls.type("payFamilyBill", "CSS_accountNumber", accountNumber);
}

public void typePatientDOB(String dateOfBirth)
{
	controls.type("payFamilyBill", "CSS_patientDOB", dateOfBirth);
}


public void clickOnViewMyBill()
{
	controls.actionsClick("payFamilyBill", "ID_viewMyBill");
}


}
