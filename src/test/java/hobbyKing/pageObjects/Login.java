package hobbyKing.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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


public class Login {
	
public WebDriver ldriver;
	
	public Login(WebDriver rdriver)
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
	WebElement logHomePage;
	
	//loginGmail
	@FindBy(id="identifierId")
	@CacheLookup
	WebElement txtGmailID;
	
	@FindBy(xpath="//span[@class='RveJvd snByac']")
	@CacheLookup
	WebElement btnGmailNext;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtGmailPassword;
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	@CacheLookup
	WebElement btnGmailNext2;
	
	@FindBy(xpath="//span[@class='bog']")
	@CacheLookup
	List<WebElement> lstClickEmail;
	
	@FindBy(xpath="//span[@class='gb_Ba gbii']")
	@CacheLookup
	WebElement imgGmailProfileLogo;


	
	public void setLogin(String hkusername, String hkpassword) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(ldriver, 10);
		
		if(existsElement("bblcIconClose")==true)
		{
			wait.until(ExpectedConditions.visibilityOf(icnClose));
			icnClose.click();
			Thread.sleep(2000);
			btnAcceptAndClose.click();
//			wait.until(ExpectedConditions.visibilityOf(lblSignIn));
//			lblSignIn.click();
//			wait.until(ExpectedConditions.visibilityOf(txtUserName));
//			txtUserName.sendKeys(hkusername);
//			wait.until(ExpectedConditions.visibilityOf(btnNext));
//			btnNext.click();
//			wait.until(ExpectedConditions.visibilityOf(txtPassword));
//			txtPassword.sendKeys(hkpassword);
//			wait.until(ExpectedConditions.visibilityOf(btnSignIn));
//			btnSignIn.click();
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
	
	public void setSignOut()
	{
		WebDriverWait wait=new WebDriverWait(ldriver, 10);
		drpSignOut=wait.until(ExpectedConditions.visibilityOf(drpSignOut));
		drpSignOut.click();
		optSignOut=wait.until(ExpectedConditions.visibilityOf(optSignOut));
		optSignOut.click();
	}
	
	public boolean existsElement(String bblcIconClose)
	{
		try {
			icnClose.isDisplayed();
        } catch (Exception e) {
            System.out.println("Close icon is not present.");
            return false;
        }

        return true;
	}
	
	public void gmailLogin(String gmailid, String gmailpassword, String emailsubject) throws InterruptedException
	{

		Actions actions = new Actions(ldriver);
		((JavascriptExecutor) ldriver).executeScript("window.open('http://gmail.com/','_blank');");
		
		ArrayList<String> newTab = new ArrayList<String>(ldriver.getWindowHandles());
		ldriver.switchTo().window(newTab.get(1));
		
		explicitWait(ldriver, txtGmailID);
		txtGmailID.sendKeys(gmailid);
		
		explicitWait(ldriver, btnGmailNext);
		btnGmailNext.click();
		
		explicitWait(ldriver, txtGmailPassword);
		actions.moveToElement(txtGmailPassword);
		actions.click();
		actions.sendKeys(gmailpassword, Keys.ENTER);
		actions.build().perform();
		
		explicitWait(ldriver, imgGmailProfileLogo);
		
		for(int i=0; i < lstClickEmail.size(); i++)
		{
			if (lstClickEmail.get(i).getText().contains(emailsubject))
			{
				lstClickEmail.get(i).click();
				break;
			}
		}
		
		
		Thread.sleep(5000);

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

}
