package rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Base.Page;
import Base.TopMenu;
import CRM.Pages.CRM_HomePage;
import CRM_Account.Accounts_Page;
import CRM_Account.CreateAccount_Page;
import pages.HomePage;
import pages.LoginPage;
import pages.ZohoAppPage;

public class LoginTest {
	

	public static void main(String[] args) throws InterruptedException {
		//this is the runner file
		
		HomePage home = new HomePage();
		//page.goToFreeSignUp();
		//page.goToEnterprise();
		LoginPage lp = home.goToLogin();
		ZohoAppPage zoho= lp.doSignIn("buddy150515@gmail.com", "Snigdha15");
		zoho.clickOnCrm();
	     Accounts_Page act= Page.menu.gotoAccounts();
         CreateAccount_Page cat= act.gotoCreateAccounts();
         cat.createAccount("Sarayu");
		
	}

}
