package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import CRM_Account.Accounts_Page;

//
//
//
public class TopMenu {
	WebDriver driver;
	public TopMenu(WebDriver driver){
		this.driver=driver;
	}

	public void gotoHome(){
		
	}
	
	public void gotoLeads(){
		
	}
	
	public Accounts_Page gotoAccounts(){
		
		//driver.findElement(By.xpath("//*[@id='mainMenuTabDiv']/crm-menu/div[1]/crm-tab/div[2]/div[4]/a")).click();
		//driver.findElement(By.cssSelector("#tab_Accounts")).click();
	
		driver.findElement(By.xpath("//*[@id='mainMenuTabDiv']/crm-menu/div[1]/crm-tab/div[2]/div[4]")).click();
		 //driver.findElement(By.xpath("/html/body/div[2]/div/a")).click();
		//driver.switchTo().alert().accept();
		return new Accounts_Page();
	}
	
	public void gotoContacts(){
		
	}
	
	public void signOut(){
		//Page.driver.findElement(By.xpath("#topdivuserphoto_4834504000000304001")).click();
		//Actions action = new Actions(Page.driver);
		//action.moveToElement(target)
		
	}
}
