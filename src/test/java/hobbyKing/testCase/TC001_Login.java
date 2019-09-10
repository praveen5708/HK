package hobbyKing.testCase;

import org.testng.annotations.Test;

import hobbyKing.pageObjects.Gmail;
import hobbyKing.pageObjects.Login;


public class TC001_Login extends BaseClass {
	
	@Test
	public void login() throws InterruptedException
	{
		Login login = new Login(driver);
		
		login.setLogin(hkusername, hkpassword);		
	}

//	@Test(priority=1)
//	public void verifyOrderNumberInGmail() throws InterruptedException
//	{
//		Gmail gmail = new Gmail(driver);
//		
//		gmail.setGmailLogin(gmailid, gmailpassword);
//		gmail.setGmailSubject(newordergmailsubject);
//		gmail.getOrderNumberFromEmail();
//		gmail.verifyOrderNumber();
//	}
}
