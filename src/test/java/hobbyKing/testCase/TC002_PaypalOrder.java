package hobbyKing.testCase;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import hobbyKing.pageObjects.CheckOut;
import hobbyKing.pageObjects.Gmail;
import hobbyKing.pageObjects.HomePage;
import hobbyKing.pageObjects.Login;
import hobbyKing.pageObjects.Payment;
import hobbyKing.pageObjects.PersonalInfo;
import hobbyKing.pageObjects.YourCart;
import hobbyKing.utilities.XLUtils;

public class TC002_PaypalOrder extends BaseClass {

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
	
	@Test
	public void paypalOrder() throws InterruptedException
	{
	HomePage homepage = new HomePage(driver);
	PersonalInfo personalinfo = new PersonalInfo(driver);
	CheckOut checkout =new CheckOut(driver);
	Payment payment = new Payment(driver);
	Gmail gmail = new Gmail(driver);
	
	//homepage.selectCountry(countrytobeselected);
	homepage.addItemToCart(productid);
	homepage.clickCheckoutIcon();
	personalinfo.setPersonalInfoAustraliaUser(hkfname, hklname, telephone, addr, country, state, suburb);
	checkout.setCheckOutAsPaypal();
	payment.setPaypalPayment(paypalemail, paypalpassword);
	payment.getOrderNumber();
	}
	
//	@Test(dependsOnMethods = { "paypalOrder" })
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
