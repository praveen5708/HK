package hobbyKing.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOut {
	
public WebDriver ldriver;
	
	public CheckOut(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Continue')]")
	@CacheLookup
	WebElement btnContinue;
	
	@FindBy(xpath="//span[contains(text(),'Paypal')]")
	@CacheLookup
	WebElement rdoPaypal;
	
	@FindBy(xpath="//label[@class='label css_radio worldpay_cc']")
	@CacheLookup
	WebElement rdoWorldpay;
	
	@FindBy(xpath="//*[@id='advice-required-entry-agree-term-checkout']")
	@CacheLookup
	WebElement chkIAgree;
	
	@FindBy(xpath="//button[@class='button_orange button btn-checkout -js-payment-review']")
	@CacheLookup
	WebElement btnProceedToPayment;
	
	@FindBy(xpath="//button[@class='button_orange button btn-checkout -js-payment-worldpay_cc']")
	@CacheLookup
	WebElement btnProceedToPayment1;

	
	public void setCheckOutAsPaypal() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(ldriver,10);
		btnContinue=wait.until(ExpectedConditions.visibilityOf(btnContinue));
		btnContinue.click();
		
		rdoPaypal.click();
		
		Actions ac=new Actions(ldriver);
		ac.contextClick(ldriver.findElement(By.xpath("//span[contains(text(),'Paypal')]"))).sendKeys(Keys.TAB, Keys.TAB, Keys.SPACE).build().perform();
		
		btnProceedToPayment.click();
		Thread.sleep(5000);
	}
	
	public void setCheckOutAsWorldpay() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(ldriver,10);
		btnContinue=wait.until(ExpectedConditions.visibilityOf(btnContinue));
		btnContinue.click();
		
		rdoWorldpay.click();
		
		Actions ac=new Actions(ldriver);
		ac.contextClick(ldriver.findElement(By.xpath("//label[@class='label css_radio worldpay_cc']"))).sendKeys(Keys.TAB, Keys.TAB, Keys.SPACE).build().perform();
		
		btnProceedToPayment1.click();
	}

}
