package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Page;
import CRM.Pages.CRM_HomePage;

public class ZohoAppPage extends Page {
	
	 public void clickOnCalender(){	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    
	    	
	    	
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/a/span")));
	    	click("clickonCalender_XPATH");
	    	
	    }
	 public CRM_HomePage clickOnCrm(){
		 WebDriverWait wait = new WebDriverWait(driver,10);
		    
		 //driver.findElement(By.xpath("/html/body/div[2]/div/a")).click();
	    	
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='zl-myapps']/div[1]/div[6]/div/a/div")));
	    	click("clickonCRM_XPATH");
	    	return new CRM_HomePage();
		 
	 }
	
   
}



