package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.Page;

public class LoginPage extends Page {
	
	
	public ZohoAppPage  doSignIn(String username,String password){
		type("Email_XPATH",username);
		click("Next_XPATH");
		type("Password_XPATH",password);
		click("Next1_XPATH");
		
		return new ZohoAppPage();
		
	}

}
