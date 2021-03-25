package listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.rmi.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;

import Base.Page;
import utilities.MonitoringMail;
import utilities.TestConfig;
import utilities.TestUtil;

public class CustumListeners extends Page implements ITestListener,ISuiteListener{
	public String messageBody;
	public void onFinish(ITestContext arg0) {
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		System.setProperty("org.uncommons.reportng.escape-output","false");
		//this is to see the link and if you click we cn see the image with reportng
		//if we want to see this screenshot in the different tab then in the <a target = blank we need to give
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.FAIL, arg0.getName().toUpperCase()+"Failed with Exceptions: "+arg0.getThrowable());
		test.log(LogStatus.FAIL,test.addScreenCapture(TestUtil.screenshotName) ); 
		Report.endTest(test);
		Report.flush();
		Reporter.log("Click to see the screenshot");
		//Reporter.log("<a target =\"blank\" href = \"C:\\Selenium Softwares\\screenshot\\error.jpg\" >scrrenshot</a>");
	    Reporter.log("<a target = \"blank\" href = "+TestUtil.screenshotName+" >screenshot </a>"); 
		
		Reporter.log("<br>");
		Reporter.log("<br>");
		
		//Reporter.log("<a target =\"blank\" href = \"C:\\Selenium Softwares\\screenshot\\error.jpg\" ><img src = \"C:\\Selenium Softwares\\screenshot\\error.jpg\" height=350 width=400</img></a>");
		Reporter.log("<a target = \"blank\" href = "+TestUtil.screenshotName+"><img src = "+TestUtil.screenshotName+"height=200 width=200></a>"); 
		
		
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		test = Report.startTest(arg0.getName().toUpperCase());
		//runmode
		//if( ! TestUtil.isRunnable(arg0.getName(), excel)){
			
			//throw new SkipException("Skipping the test" +arg0.getName().toUpperCase()+"as  the Runmode is No");
			
  	//}
		
		
	}

	public void onTestSuccess(ITestResult arg0) {
		test.log(LogStatus.PASS,arg0.getName().toUpperCase()+"PASS");
	    Report.endTest(test);
	    Report.flush();
	}

	
	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub
		//System.out.println(InetAddress.getLocalHost().getHostAddress());
				//this will give the Address of your local machine
					MonitoringMail mail = new MonitoringMail();
					
					try {
						messageBody = "http://"+InetAddress.getLocalHost().getHostAddress()+":8080/job/PageObjectModelProject/Extent_20Report/";
					} catch (java.net.UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				try {
					mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody,TestConfig.attachmentPath,
							TestConfig.attachmentName);
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	
	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
