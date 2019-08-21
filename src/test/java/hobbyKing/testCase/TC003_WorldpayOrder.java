package hobbyKing.testCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hobbyKing.pageObjects.CheckOut;
import hobbyKing.pageObjects.HomePage;
import hobbyKing.pageObjects.Login;
import hobbyKing.pageObjects.Payment;
import hobbyKing.pageObjects.PersonalInfo;

public class TC003_WorldpayOrder extends BaseClass{
	
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
	public void worldpaylOrder() throws InterruptedException
	{
	HomePage homepage = new HomePage(driver);
	PersonalInfo personalinfo = new PersonalInfo(driver);
	CheckOut checkout =new CheckOut(driver);
	Payment payment = new Payment(driver);
	
	Thread.sleep(5000);
	homepage.addItemToCart(productid);
	homepage.clickCheckoutIcon();
	personalinfo.setPersonalInfoAustraliaUser(hkfname, hklname, cname, telephone, addr, country, state, suburb);
	checkout.setCheckOutAsWorldpay();
	payment.setWordlpayPayment(worldpaycardnumber, worldpayexpirymonth, worldpayexpiryyear, worldpaysecuritycode);
	payment.getOrderNumber();
	}

}
