package edw.edw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import edw.edw.commonLib.Controls;
import edw.edw.frameLib.Driver;
import edw.edw.frameLib.StringEncrypt;

public class LoginPage extends Driver {
	public WebDriver driver;
	public WebDriverWait wait;
	Controls controls;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, time);
		controls = new Controls(driver);

	}

	// Click on Sign In Button
	public void clickOnSignInButton() {
		controls.actionsClick("login", "ID_signIn_Button");
	}
	
	public boolean isSignInButtonDisplayed()
	{
		return controls.isDisplayed("login", "ID_signIn_Button");
	}

	// Enter Email Address
	public void enterEmailAddress(String data) {
		controls.type("login", "ID_email_Address_TextBox", data);
	}

	// Enter Password
	public void enterPassword(String data) {
		controls.type("login", "ID_password_TextBox", StringEncrypt.decrypt(data));
	}

	public void loginToApplication(String userName, String password) {
		enterEmailAddress(userName);
		enterPassword(password);
		clickOnSignInButton();
	}

}
