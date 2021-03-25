package rough;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import utilities.MonitoringMail;
import utilities.TestConfig;

public class TestHostAddress {
	public static void main(String[] args) throws UnknownHostException, AddressException, MessagingException {
		//System.out.println(InetAddress.getLocalHost().getHostAddress());
	//this will give the Address of your local machine
		MonitoringMail mail = new MonitoringMail();
		String messageBody = "http://"+InetAddress.getLocalHost().getHostAddress()+":8080/job/PageObjectModelProject/Extent_20Report/";
	System.out.println(messageBody);
	mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody,TestConfig.attachmentPath,TestConfig.attachmentName);
	}

}
