package hobbyKing.testCase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.OutputType;

import hobbyKing.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();

	public String baseUrl = readconfig.getApplicationUrl();
	
	//setLogin_Login
	public String hkusername = readconfig.getHKUserName();
	public String hkpassword = readconfig.getHKPassword();
	
	//setGmailLogin_Login
	public String gmailid = readconfig.getGmailId();
	public String gmailpassword = readconfig.getGmailPassword();
	
	//setGmailSubject_Login
	public String newordergmailsubject = readconfig.getGmailSubject();
	
	//addItemToCart_HomePage
	public String productid = readconfig.getProductID();
	
	//setPersonalInfoAustraliaUser
	public String hkfname = readconfig.getHKFirstname();
	public String hklname = readconfig.getHKLastname();
	public String telephone = readconfig.getTelephone();
	public String addr = readconfig.getAddress();
	public String country = readconfig.getCountryName();
	public String state = readconfig.getState();
	public String suburb=readconfig.getSuburb();
	
	//setPaypalPayment_Payment
	public String paypalemail=readconfig.getPaypalLogIn();
	public String paypalpassword=readconfig.getPaypalPassword();
	
	//setWorldpayPayment_Payment
	public String worldpaycardnumber=readconfig.getWorldpayCardNumber();
	public String worldpayexpirymonth=readconfig.getWorldpaylExpiryMonth();
	public String worldpayexpiryyear=readconfig.getWorldpayExpiryYear();
	public String worldpaysecuritycode=readconfig.getWorldpaylSecurityCode();
	
	public static String WindowHandle;

	public static WebDriver driver;

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws InterruptedException {
		logger = Logger.getLogger("eventExtraa");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equals("chrome")) {
			ChromeOptions notifications = new ChromeOptions();
			notifications.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver(notifications);
			driver.manage().window().maximize();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}

		driver.get(baseUrl);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	public static String randomString()
	{
		String generatedString1=RandomStringUtils.randomAlphabetic(8);
		return generatedString1;
	}
	
	public String getWindowHandles()
	{
		WindowHandle = driver.getWindowHandle();
		return WindowHandle;
	}

}
