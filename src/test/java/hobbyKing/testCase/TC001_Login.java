package hobbyKing.testCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hobbyKing.pageObjects.Gmail;
import hobbyKing.pageObjects.Login;


public class TC001_Login extends BaseClass {
	
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
	public void homePage()
	{
		Login login = new Login(driver);
		login.logHomePage.click();
	}
	
	
}
