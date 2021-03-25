package CRM_Account;

import org.openqa.selenium.By;

import Base.Page;

public class CreateAccount_Page extends Page {
	
	public CreateAccount_Page createAccount(String AccountName){
		driver.findElement(By.xpath("//input[@id='Crm_Accounts_ACCOUNTNAME']")).sendKeys(AccountName);
	return new CreateAccount_Page();
	
	}

}
