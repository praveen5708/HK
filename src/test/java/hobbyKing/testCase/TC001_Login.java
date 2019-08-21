package hobbyKing.testCase;

import org.testng.annotations.Test;

import hobbyKing.pageObjects.Login;


public class TC001_Login extends BaseClass {
	
	@Test
	public void login() throws InterruptedException
	{
		Login login = new Login(driver);
		
		login.setLogin(hkusername, hkpassword);		
	}

}
