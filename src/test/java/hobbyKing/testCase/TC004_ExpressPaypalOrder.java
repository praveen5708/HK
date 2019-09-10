package hobbyKing.testCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hobbyKing.pageObjects.Gmail;
import hobbyKing.pageObjects.HomePage;
import hobbyKing.pageObjects.Login;
import hobbyKing.pageObjects.Payment;
import hobbyKing.pageObjects.PersonalInfo;
import hobbyKing.pageObjects.YourCart;

public class TC004_ExpressPaypalOrder extends BaseClass {
	
	@BeforeMethod
	public void login() throws InterruptedException
	{
		Login login = new Login(driver);
		login.setLogin(hkusername, hkpassword);
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void signOut()
	{
		Login login = new Login(driver);
		login.setSignOut();
	}
	
	@Test(priority=0)
	public void expressPaypalOrder() throws InterruptedException
	{
		HomePage homepage = new HomePage(driver);
		Payment payment = new Payment(driver);
		YourCart yourcart = new YourCart(driver);
		PersonalInfo personalinfo = new PersonalInfo(driver);
		
		homepage.addItemToCart(productid);
		yourcart.expressPaypalPayment();
		personalinfo.setPersonalInfoAustraliaUser(hkfname, hklname, telephone, addr, country, state, suburb);
		payment.setPaypalPayment(paypalemail, paypalpassword);
		payment.getOrderNumber();
	}
	
	@Test(priority=1)
	public void verifyOrderNumberInGmail() throws InterruptedException
	{
		Gmail gmail = new Gmail(driver);
		
		gmail.setGmailLogin(gmailid, gmailpassword);
		gmail.setGmailSubject(newordergmailsubject);
		gmail.getOrderNumberFromEmail();
		gmail.verifyOrderNumber();
	}

}
