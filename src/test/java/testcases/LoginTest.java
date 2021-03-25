package testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ZohoAppPage;
import utilities.TestUtil;

public class LoginTest extends BaseTest {
	@Test(dataProviderClass = TestUtil.class,dataProvider="dp")
	public void loginTest(Hashtable<String,String> data){

		HomePage home = new HomePage();
		//page.goToFreeSignUp();
		//page.goToEnterprise();
		LoginPage lp = home.goToLogin();
		ZohoAppPage zoho= lp.doSignIn(data.get("username"), data.get("password"));
		
	}

}
