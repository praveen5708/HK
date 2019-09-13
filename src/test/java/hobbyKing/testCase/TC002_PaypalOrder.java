package hobbyKing.testCase;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
	
	@Test(dataProvider = "LoginData")
	public void paypalOrder(String countrytobeselected, String sku) throws InterruptedException
	{
	HomePage homepage = new HomePage(driver);
	PersonalInfo personalinfo = new PersonalInfo(driver);
	CheckOut checkout =new CheckOut(driver);
	Payment payment = new Payment(driver);
	
	homepage.selectCountry(countrytobeselected);
	homepage.addItemToCart(productid);
	homepage.clickCheckoutIcon();
	personalinfo.setPersonalInfoAustraliaUser(hkfname, hklname, telephone, addr, country, state, suburb);
	checkout.setCheckOutAsPaypal();
	payment.setPaypalPayment(paypalemail, paypalpassword);
	payment.getOrderNumber();
	}
	
//	@Test(dependsOnMethods = { "paypalOrder" }, dataProvider = "LoginData")
//	public void verifyOrderNumberInGmail() throws InterruptedException
//	{
//		Gmail gmail = new Gmail(driver);
//		
//		gmail.setGmailLogin(gmailid, gmailpassword);
//		gmail.setGmailSubject(newordergmailsubject);
//		gmail.getOrderNumberFromEmail();
//		gmail.verifyOrderNumber();
//	}
	
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/hobbyKing/testData/LoginData.xlsx";

		int rowcount = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rowcount][colcount];

		for (int i = 1; i <= rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
//		for (int k = 1; k <= rowcount; k++) {
//			for (int l = 0; l < colcount; l++) {
//				logindata[k - 1][l] = XLUtils.getCellData(path, "Sheet2", k, l);
//			}
//		}
		return logindata;

	}
}
