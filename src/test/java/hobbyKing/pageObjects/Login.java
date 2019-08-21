package hobbyKing.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	//setSignOut
	@FindBy(xpath="//span[@class='title -name -dropdown']")
	@CacheLookup
	WebElement drpSignOut;
	
	@FindBy(xpath="//a[@class='account-link out']")
	@CacheLookup
	WebElement optSignOut;
	
	@FindBy(xpath="//*[@class='svg-icon -logo']")
	@CacheLookup
	WebElement logHomePage;


	
	public void setLogin(String hkusername, String hkpassword) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(ldriver, 10);
		
		if(existsElement("bblcIconClose")==true){

			icnClose = wait.until(ExpectedConditions.visibilityOf(icnClose));
			icnClose.click();
			Thread.sleep(5000);
			btnAcceptAndClose.click();
			lblSignIn = wait.until(ExpectedConditions.visibilityOf(lblSignIn));
			lblSignIn.click();
			txtUserName = wait.until(ExpectedConditions.visibilityOf(txtUserName));
			txtUserName.sendKeys(hkusername);
			btnNext = wait.until(ExpectedConditions.visibilityOf(btnNext));
			btnNext.click();
			txtPassword = wait.until(ExpectedConditions.visibilityOf(txtPassword));
			txtPassword.sendKeys(hkpassword);
			btnSignIn = wait.until(ExpectedConditions.visibilityOf(btnSignIn));
			btnSignIn.click();
			Thread.sleep(7000);

			   }
			   else{
//					lblSignIn = wait.until(ExpectedConditions.visibilityOf(lblSignIn));
					lblSignIn.click();
					txtUserName = wait.until(ExpectedConditions.visibilityOf(txtUserName));
					txtUserName.sendKeys(hkusername);
					btnNext = wait.until(ExpectedConditions.visibilityOf(btnNext));
					btnNext.click();
					txtPassword = wait.until(ExpectedConditions.visibilityOf(txtPassword));
					txtPassword.sendKeys(hkpassword);
					btnSignIn = wait.until(ExpectedConditions.visibilityOf(btnSignIn));
					btnSignIn.click();
					logHomePage = wait.until(ExpectedConditions.visibilityOf(logHomePage));
					logHomePage.click();
					Thread.sleep(7000);
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
	
//	public boolean existsElement(String bblcIconClose)
//	{
//		try {
//            ldriver.findElement(By.xpath("//a[@class='fancybox-item fancybox-close']"));
//        } catch (Exception e) {
//            System.out.println("id is not present ");
//            return false;
//        }
//
//        return true;
//	}
	
	public boolean existsElement(String bblcIconClose)
	{
		try {
            ldriver.findElement(By.xpath("//a[@class='fancybox-item fancybox-close']"));
        } catch (Exception e) {
            System.out.println("id is not present ");
            return false;
        }

        return true;
	}

}
