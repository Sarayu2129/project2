package testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import Base.Page;
import CRM_Account.Accounts_Page;
import CRM_Account.CreateAccount_Page;
import pages.ZohoAppPage;
import utilities.TestUtil;

public class CreateAccountTest {

	
	@Test(dataProviderClass=TestUtil.class,dataProvider ="dp")
	public void createAccountTest(Hashtable<String,String>data){
		ZohoAppPage zoho = new ZohoAppPage();
		zoho.clickOnCrm();
	     Accounts_Page act= Page.menu.gotoAccounts();
        CreateAccount_Page cat= act.gotoCreateAccounts();
        cat.createAccount(data.get("accountname"));
		
	}
}
