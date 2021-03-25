package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;
import utilities.ExtentReportTest;
import utilities.TestUtil;



public class Page {
	public static TopMenu menu;
  public static  WebDriver driver; 
  
	public static Properties config = new Properties();
	public static Properties ObjectR = new Properties();
	public static FileInputStream fis;
	public static Logger log =Logger.getLogger("devpinoyLogger");//this is a standard name for Logger
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\PageObjectTest.xlsx");
	public static WebDriverWait wait; 
	public ExtentReports Report = ExtentReportTest.getInstance();
	public static ExtentTest test;
	public static String browser;
  public Page(){
	 if(driver==null){
		 if (driver == null){
				
				try {
					fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					config.load(fis);
					log.debug("Config file loaded !!!");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\ObjectRepository.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			    try {
					ObjectR.load(fis);
					log.debug("Object Repository  file loaded !!!");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    //jenkins Browser filter configuration
			    if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty()){
			    	browser = System.getenv("browser");
			    	
			    }else {
			    	browser = config.getProperty("browser");
			    }
			    config.setProperty("browser" , browser);
			    if(config.getProperty("browser").equals("firefox")){
					WebDriverManager.firefoxdriver().setup();
					System.getProperty("webdriver.firefox.driver",System.getProperty("user.dir"+"\\src\\test\\resources\\executables\\geckodriver.exe")); 
					driver = new FirefoxDriver();
					log.debug("Firefox Browser Launched!!!");
				}
			    else if(config.getProperty("browser").equals("edge")){
			    	
					WebDriverManager.edgedriver().setup();
		  System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\Excecutables\\msedgedriver.exe");
		 
		  Map<String,Object> prefix = new HashMap<String,Object>();
		  prefix.put("profile.default_content_setting_values.notification",2);
		  prefix.put("credentials_enable_service",false);
		  prefix.put("profile.password_manager_enable", false);
		  EdgeOptions options = new EdgeOptions();
		//  options.setExperimentalOption("prefix", prefix);
		//  options.addArguments("--disable-entensions");
		////  options.addArguments("--disable-infobars");
		 // driver = new ChromeDriver(options);
		  driver = new EdgeDriver(options);
		  log.debug("Edge  Browser Launched!!!");
		 }else if(config.getProperty("browser").equals("chrome")){
					WebDriverManager.chromedriver().setup();
				System.getProperty("webdriver.chrome.driver",System.getProperty("user.dir"+"\\src\\test\\resources\\executables\\chromedriver.exe")); 
				 Map<String,Object> prefix = new HashMap<String,Object>();
				  prefix.put("profile.default_content_setting_values.notification",2);
				  prefix.put("credentials_enable_service",false);
				  prefix.put("profile.password_manager_enable", false);
				  ChromeOptions options = new ChromeOptions();
				  options.setExperimentalOption("prefix", prefix);
				  options.addArguments("--disable-entensions");
				  options.addArguments("--disable-infobars");
				  driver = new ChromeDriver(options);
					log.debug("Chrome Browser Launched!!!");
				}
		    }else if(config.getProperty("browser").equals("ie")){
		    	
				WebDriverManager.iedriver().setup();
			System.getProperty("webdriver.ie.driver",System.getProperty("user.dir"+"\\src\\test\\resources\\executables\\IEDriverServer.exe")); 
				driver = new InternetExplorerDriver();
			}
                
	  
	  
	  driver.get("https://zoho.com");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(config.getProperty("testsiteurl"));
		log.debug("Navigated to :  "+config.getProperty("testsiteurl"));
		//DbManager.setMysqLDbConnection();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
      //wait = new WebDriverWait(driver,Integer.parseInt(p.getProperty("explicit.wait")));
	 
		wait = new WebDriverWait(driver,5);
		menu = new TopMenu(driver);
	 }
	 
  }
  
  public static  void quit(){
	  driver.quit();
  }
  
  
  //common Keywords
  public void click(String locator){
		if(locator.endsWith("_CSS")){
			driver.findElement(By.cssSelector(ObjectR.getProperty(locator))).click();
		}else if(locator.endsWith("_XPATH")){
			driver.findElement(By.xpath(ObjectR.getProperty(locator))).click();
		}else if(locator.endsWith("_ID")){
			driver.findElement(By.id(ObjectR.getProperty(locator))).click();
		}
		log.debug("Clicking on the element :"+locator);
		test.log(LogStatus.INFO, "Clicking on :"  +locator);
		
		
		}
		public void type(String locator,String value){
			if(locator.endsWith("_CSS")){
			driver.findElement(By.cssSelector(ObjectR.getProperty(locator))).sendKeys(value);
			}else if(locator.endsWith("_XPATH")){
				driver.findElement(By.xpath(ObjectR.getProperty(locator))).sendKeys(value);
			}else if(locator.endsWith("_ID")){
				driver.findElement(By.id(ObjectR.getProperty(locator))).sendKeys(value);
			}
			log.debug("Typing in :"+locator+"entering the value :"+value);
			test.log(LogStatus.INFO, "Typing in the locator" +locator +"entered the value :"+value);
		}
		
		
		static WebElement dropdown;
		public void select(String locator,String value){
			if(locator.endsWith("_CSS")){
				dropdown = driver.findElement(By.cssSelector(ObjectR.getProperty(locator)));
				
			}else if(locator.endsWith("_XPATH")){
				dropdown = driver.findElement(By.xpath(ObjectR.getProperty(locator)));
				
			}else if(locator.endsWith("_ID")){
				dropdown = driver.findElement(By.id(ObjectR.getProperty(locator)));
			}	
		
		 Select select = new Select(dropdown);
		 select.selectByVisibleText(value);
		 log.debug("Selecting from an element :"+locator+"value as :"+value);
		 test.log(LogStatus.INFO, "Selecting from dropdown" +locator +"value as :"+value);
		}
		public boolean isElementPresent(By by){

			try{
				driver.findElement(by);
				return true;
				
			}catch(NoSuchElementException e ) {
				 	
				return false;
			}
		}
		
		public static void verifyEquals(String expected,String actual) throws IOException{
			try{
				Assert.assertEquals(actual, expected);
			}catch(Throwable t){
				 TestUtil.captureScreenshot();
				 //ReportNG Report
				 Reporter.log("<br>"+ "Verification failed :"+t.getMessage()+"<br>");
				//Reporter.log("<a target =\"blank\" href = \"C:\\Selenium Softwares\\screenshot\\error.jpg\" ><img src = \"C:\\Selenium Softwares\\screenshot\\error.jpg\" height=350 width=400</img></a>");
				Reporter.log("<a target = \"blank\" href = "+TestUtil.screenshotName+"><img src = "+TestUtil.screenshotName+"height=200 width=200></a>"); 
				Reporter.log("<br>");
				Reporter.log("<br>");
				//TestNG Report
				test.log(LogStatus.FAIL,"Verification Failed with Exceptions: "+t.getMessage());
				test.log(LogStatus.FAIL,test.addScreenCapture(TestUtil.screenshotName) ); 
				
				 
				 
			}
		}
	  
  
}

