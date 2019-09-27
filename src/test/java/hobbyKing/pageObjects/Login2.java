package hobbyKing.pageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EmptyFileException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hobbyKing.utilities.XLUtils;


public class Login2 {
	
public WebDriver ldriver;
	
	public Login2(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//setLogin
	@FindBy(xpath="//a[@class='sign-in-link item']")
	@CacheLookup
	WebElement lblSignIn;
	
	@FindBy(xpath="//input[@id='email']")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(xpath="//button[@class='submitBtn next']")
	@CacheLookup
	WebElement btnNext;
	
	@FindBy(xpath="//input[@id='pass']")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@id='send2']")
	@CacheLookup
	WebElement btnSignIn;
	
	@FindBy(xpath="//a[@class='fancybox-item fancybox-close']")
	@CacheLookup
	WebElement icnClose;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[6]/div[1]/div[1]/div[2]/p[1]/a[1]")
	@CacheLookup
	WebElement btnAcceptAndClose;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/div[6]/div[1]/div[1]/div[2]/p[1]/a[1]")
	@CacheLookup
	WebElement btnAcceptAndCloserd;
	
	//setSignOut
	@FindBy(xpath="//span[@class='title -name -dropdown']")
	@CacheLookup
	WebElement drpSignOut;
	
	@FindBy(xpath="//a[@class='account-link out']")
	@CacheLookup
	WebElement optSignOut;
	
	@FindBy(xpath="//a[@class='logo']")
	@CacheLookup
	public
	WebElement logHomePage;
	
	@FindBys(@FindBy(tagName="a"))
	@CacheLookup
	List<WebElement> getAllLinks;
	
//	@Test(dataProvider = "LoginData")
	public void setLogin(String hkusername, String hkpassword) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(ldriver, 10);
		
		if(existsElement("bblcIconClose")==true)
		{
			wait.until(ExpectedConditions.visibilityOf(icnClose));
			icnClose.click();
			Thread.sleep(2000);
			btnAcceptAndClose.click();
			wait.until(ExpectedConditions.visibilityOf(lblSignIn));
			lblSignIn.click();
			wait.until(ExpectedConditions.visibilityOf(txtUserName));
			txtUserName.sendKeys(hkusername);
			wait.until(ExpectedConditions.visibilityOf(btnNext));
			btnNext.click();
			wait.until(ExpectedConditions.visibilityOf(txtPassword));
			txtPassword.sendKeys(hkpassword);
			wait.until(ExpectedConditions.visibilityOf(btnSignIn));
			btnSignIn.click();
		}
			else
			{
				lblSignIn.click();
				wait.until(ExpectedConditions.visibilityOf(txtUserName));
				txtUserName.sendKeys(hkusername);
				wait.until(ExpectedConditions.visibilityOf(btnNext));
				btnNext.click();
				wait.until(ExpectedConditions.visibilityOf(txtPassword));
				txtPassword.sendKeys(hkpassword);
				wait.until(ExpectedConditions.visibilityOf(btnSignIn));
				btnSignIn.click();
				wait.until(ExpectedConditions.visibilityOf(logHomePage));
				logHomePage.click();
			  }
	}
	
//	@DataProvider(name = "LoginData")
//	public String[][] getData() throws IOException {
//		String path = System.getProperty("user.dir") + "/src/test/java/hobbyKing/testData/LoginData.xlsx";
//
//		int rowcount = XLUtils.getRowCount(path, "Sheet1");
//		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
//
//		String logindata[][] = new String[rowcount][colcount];
//
//		for (int i = 1; i <= rowcount; i++) {
//			for (int j = 0; j < colcount; j++) {
//				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
//			}
//		}
//		return logindata;
//	}
	
	
	public void setSignOut()
	{
		try
		{
		WebDriverWait wait=new WebDriverWait(ldriver, 10);
//		drpSignOut=wait.until(ExpectedConditions.visibilityOf(drpSignOut));
//		drpSignOut.click();
//		optSignOut=wait.until(ExpectedConditions.visibilityOf(optSignOut));
//		optSignOut.click();
		} catch (Exception e){
			System.out.println("  13 alert. no alert-window");
		}
		
	}
	
	public boolean existsElement(String bblcIconClose)
	{
		try {
			icnClose.isDisplayed();
        } catch (Exception e) {
            
            return false;
        }

        return true;
	}
	
	public void explicitWait(WebDriver ldriver, WebElement element)
	{
		try
		{
			WebDriverWait webdriverwait = new WebDriverWait(ldriver, 10);
			webdriverwait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void verifyLinks() throws IOException
	{
		int s = getAllLinks.size();
		
		System.out.println(s);
		
		for(int i=0; i<=s; i++)
		{
			WebElement element = getAllLinks.get(i);
			String url = element.getAttribute("href");
			
			URL link = new URL(url);
			
			HttpURLConnection conn = (HttpURLConnection) link.openConnection();
			
			conn.connect();
			
			int respcode = conn.getResponseCode();
			
			if(respcode>=400)
			{
				System.out.println(url +" - " + " Valid");
			}
			else
			{
				System.out.println(url +" - " + " Not Valid");
			}
			
		}
	}
	
	//Flipkart
	
	//login
	@FindBy(xpath="(//input[@type='text'])[2]")
	@CacheLookup
	WebElement ui;
	
	@FindBy(xpath="//input[@type='password']")
	@CacheLookup
	WebElement pw;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	@CacheLookup
	WebElement li;
	
	//logout
	@FindBy(xpath="(//*[contains(@class,'_2aUbKa')])[1]")
	@CacheLookup
	WebElement pr;
	
	@FindBys(@FindBy(xpath="//*[contains(@class,'_1-qoxT')]"))
	@CacheLookup
	List<WebElement> lo;
	
	//click product
	
	@FindBy(xpath="(//*[contains(@class,'_1QZ6fC')])[1]")
	WebElement prd;
	
	@FindBys(@FindBy(xpath="//*[contains(@class,'_1KCOnI')]"))
	@CacheLookup
	List<WebElement> prd1;
	

	public void flipkart(String uii, String pww) throws InterruptedException
	{
//		ldriver.switchTo().frame(fr);
		ui.sendKeys(uii);
		pw.sendKeys(pww);
		li.click();
		Thread.sleep(5000);
//		ldriver.switchTo().defaultContent();
	}
	
	public void flipkartLogout() throws InterruptedException
	{
		Actions action = new Actions(ldriver);
		action.moveToElement(pr).perform();
		
		int s =lo.size();
		System.out.print(s);
		
		for(int i=0; i<=s; i++)
		{
			WebElement element = lo.get(i);
			String ss = element.getText();
			
			if(ss.equals("Logout"))
			{
				element.click();
				Thread.sleep(5000);
				break;
			}
		}
	}
	
	public void clickCategory() throws InterruptedException
	{
		Actions actions = new Actions(ldriver);
		actions.moveToElement(prd).perform();
		
		int s2 = prd1.size();
		
		for(int i=0; i<=s2; i++)
		{
			WebElement element = prd1.get(i);
			String category = element.getText();
			
			if(category.equals("Mobiles"))
			{
				element.click();
				Thread.sleep(2000);
				break;
			}
		}
	}

}
