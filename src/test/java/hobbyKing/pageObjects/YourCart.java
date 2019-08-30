package hobbyKing.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YourCart {
	
	public WebDriver ldriver;
	
	public YourCart(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//span[@class='checkout_paypal']")
	@CacheLookup
	WebElement btnExpressPaypal;
	
	@FindBy(xpath="//div[@class='add-address -js-add-address']")
	@CacheLookup
	WebElement btnAddNewAddress;
	
	public void expressPaypalPayment()
	{
		WebDriverWait wdw = new WebDriverWait(ldriver, 10);
		btnExpressPaypal=wdw.until(ExpectedConditions.visibilityOf(btnExpressPaypal));
		btnExpressPaypal.click();
		btnAddNewAddress=wdw.until(ExpectedConditions.visibilityOf(btnAddNewAddress));
		btnAddNewAddress.click();
	}
	

}
