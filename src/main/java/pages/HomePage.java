package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Base.Page;

public class HomePage extends Page{

	
	
		public void goToFreeSignUp(){
			click("FreeSignUp_CSS");
			
			
		}

		public void goToSupport(){
			
			click("Support_CSS");
			
		}
		public void goToEnterprise(){
			click("Enterprise_CSS");
			
		}
		public void goToCustomers(){
			
		}
		public void goToSales(){
			
		}
		public LoginPage goToLogin(){
			click("SignIn_XPATH");
			return new LoginPage();
		}
		
		public void goToEnglish(){
			
		}
	}




