package CRM_Account;

import org.openqa.selenium.By;

import Base.Page;

public class Accounts_Page extends Page{

	public CreateAccount_Page gotoCreateAccounts(){
		click("CreateAccount_CSS");
		return new CreateAccount_Page();
	}
	
	public void gotoActions(){
		
	}
	
}
