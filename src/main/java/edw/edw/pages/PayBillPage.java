package edw.edw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import edw.edw.commonLib.Controls;
import edw.edw.frameLib.Driver;

public class PayBillPage extends Driver {
	public WebDriver driver;
	public WebDriverWait wait;
	Controls controls;

	public PayBillPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, time);
		controls = new Controls(driver);

	}

	


}
