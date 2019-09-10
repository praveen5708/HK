package hobbyKing.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is: " + e.getMessage());
		}
	}

	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getFirefoxPath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}

	public String getApplicationUrl() {
		String url = pro.getProperty("baseUrl");
		return url;
	}

	//setLogin_Login
	public String getHKUserName()
	{
		String hkusername = pro.getProperty("hkusername");
		return hkusername;
	}
	
	public String getHKPassword()
	{
		String hkpassword=pro.getProperty("hkpassword");
		return hkpassword;
	}
	
	//setGmailLogin_Login
	public String getGmailId()
	{
		String gmailid=pro.getProperty("gmailid");
		return gmailid;
	}
	
	public String getGmailPassword()
	{
		String gmailpassword=pro.getProperty("gmailpassword");
		return gmailpassword;
	}
	
	//setGmailSubject_Login
	public String getGmailSubject()
	{
		String gmailsubject=pro.getProperty("newordergmailsubject");
		return gmailsubject;
	}
	
	//setPersonalInfoAustraliaUser_PersonalInfo
	public String getHKFirstname()
	{
		String hkkfname=pro.getProperty("hkfname");
		return hkkfname;
	}
	
	public String getHKLastname()
	{
		String hkklname=pro.getProperty("hklname");
		return hkklname;
	}
	
	public String getTelephone()
	{
		String telephone=pro.getProperty("telephone");
		return telephone;
	}
	
	public String getAddress()
	{
		String addr=pro.getProperty("addr");
		return addr;
	}
	
	public String getCountryName()
	{
		String country=pro.getProperty("country");
		return country;
	}
	
	public String getState()
	{
		String state=pro.getProperty("state");
		return state;
	}
	
	public String getSuburb()
	{
		String suburb=pro.getProperty("suburb");
		return suburb;
	}
	
	
	//setPaypalPayment_Payment
	public String getPaypalLogIn()
	{
		String paypallogin=pro.getProperty("paypalemail");
		return paypallogin;
	}
	
	public String getPaypalPassword()
	{
		String paypalpassword=pro.getProperty("paypalpassword");
		return paypalpassword;
	}
	
	//setWorldpayPayment_Payment
	public String getWorldpayCardNumber()
	{
		String worldpaycardnumber=pro.getProperty("worldpaycardnumber");
		return worldpaycardnumber;
	}
	
	public String getWorldpaylExpiryMonth()
	{
		String worldpayexpirymonth=pro.getProperty("worldpayexpirymonth");
		return worldpayexpirymonth;
	}
	
	public String getWorldpayExpiryYear()
	{
		String worldpayexpiryyear=pro.getProperty("worldpayexpiryyear");
		return worldpayexpiryyear;
	}
	
	public String getWorldpaylSecurityCode()
	{
		String worldpaysecuritycode=pro.getProperty("worldpaysecuritycode");
		return worldpaysecuritycode;
	}
	
	//addItemToCart_HomePage
	public String getProductID()
	{
		String productid=pro.getProperty("productid");
		return productid;
	}

}
