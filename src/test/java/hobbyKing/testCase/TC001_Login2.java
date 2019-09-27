package hobbyKing.testCase;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hobbyKing.pageObjects.Gmail;
import hobbyKing.pageObjects.Login;
import hobbyKing.pageObjects.Login2;
import hobbyKing.utilities.XLUtils;


public class TC001_Login2 extends BaseClass {
	
//	@BeforeMethod
//	public void login() throws InterruptedException
//	{
//		Login2 login = new Login2(driver);
//		login.setLogin(hkusername, hkpassword);
//		Thread.sleep(5000);
//	}
	
	@AfterMethod
	public void signOut() throws InterruptedException
	{
		Login2 login = new Login2(driver);
//		login.setSignOut();
		login.flipkartLogout();
	}
	
	@Test(dataProvider = "LoginData")
	public void homePage(String uii, String pww) throws IOException, InterruptedException
	{
		Login2 login = new Login2(driver);
		//login.logHomePage.click();
//		login.verifyLinks();
		
		login.flipkart(uii, pww);
	}
	
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
		return logindata;
	}
	
	@Test(dependsOnMethods="homePage")
	public void Act() throws InterruptedException
	{
		Login2 login =new Login2(driver);
		
		login.clickCategory();
	}
	
	
}
