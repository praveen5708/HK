package hobbyKing.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import hobbyKing.testCase.BaseClass;

public class Gmail {

	public WebDriver ldriver;
	
	public Gmail(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

		//Login into Gmail
		@FindBy(id="identifierId")
		@CacheLookup
		WebElement txtGmailID;
		
		@FindBy(xpath="//span[@class='RveJvd snByac']")
		@CacheLookup
		WebElement btnGmailNext;
		
		@FindBy(name="password")
		@CacheLookup
		WebElement txtGmailPassword;
		
		//Select the email
		@FindBy(xpath="//span[@class='bog']")
		@CacheLookup
		List<WebElement> lstClickEmail;
		
		@FindBy(xpath="//span[@class='gb_Ba gbii']")
		@CacheLookup
		WebElement imgGmailProfileLogo;
		
		//Get the Order ID from the email
		@FindBy(xpath="//h2[contains(@id, ':')][@class='hP']")
		WebElement lblMailOrderNumber;
		
		Payment payment = new Payment(ldriver);
		BaseClass baseclass = new BaseClass();
		
		String MailOrderNumber = null;
		String OrderNumber1 = Payment.OrderNumber;
		//String WindowHandle1 = Payment.WindowHandle;
		String WindowHandle1 = baseclass.WindowHandle;
		
		//ExplicitWait Method
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
		
		//Login into Gmail
		public void setGmailLogin(String gmailid, String gmailpassword) throws InterruptedException
		{

			Actions actions = new Actions(ldriver);
			((JavascriptExecutor) ldriver).executeScript("window.open('http://gmail.com/','_blank');");
			
			Set<String> WinHandles = ldriver.getWindowHandles();
			for (String handle : WinHandles)
			{
				if(!handle.equals(WindowHandle1))
				{
					ldriver.switchTo().window(handle);
					Thread.sleep(2000);
				}
		            
			}
			
			
			explicitWait(ldriver, txtGmailID);
			txtGmailID.sendKeys(gmailid);
			
			explicitWait(ldriver, btnGmailNext);
			btnGmailNext.click();
			
			explicitWait(ldriver, txtGmailPassword);
			actions.moveToElement(txtGmailPassword);
			actions.click();
			actions.sendKeys(gmailpassword, Keys.ENTER);
			actions.build().perform();
			
			Thread.sleep(5000);
		}
		
		//Select the email
		public void setGmailSubject(String gmailsubject)
		{
			explicitWait(ldriver, imgGmailProfileLogo);
			
			for(int i=0; i < lstClickEmail.size(); i++)
			{
				if (lstClickEmail.get(i).getText().contains(gmailsubject))
				{
					lstClickEmail.get(i).click();
					break;
				}
			}
		}
		
		//Get the Order ID from the email
		public String getOrderNumberFromEmail()
		{
			MailOrderNumber = lblMailOrderNumber.getText();
			return MailOrderNumber;
		}
		
		//Verify the Hobbyking Order Number vs Email Order Number
		public boolean verifyOrderNumber() throws InterruptedException
		{
			if (MailOrderNumber.contains(OrderNumber1))
			{
				SoftAssert sf = new SoftAssert();
				sf.assertTrue(true);
				Thread.sleep(5000);
				ldriver.close();
				Thread.sleep(5000);
				ldriver.switchTo().window(WindowHandle1);
				sf.assertAll();
			}
			return false;
		}
}
