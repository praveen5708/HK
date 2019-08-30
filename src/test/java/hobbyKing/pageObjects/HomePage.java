package hobbyKing.pageObjects;

import java.util.concurrent.TimeUnit;

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

public class HomePage {
	
public WebDriver ldriver;
	
	public HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//input[@id='search']")
	@CacheLookup
	WebElement txtMainSearch;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[8]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/button[1]")
	@CacheLookup
	WebElement btnAddToCart;
	
	@FindBy(xpath="//a[@id='cartadd']")
	@CacheLookup
	WebElement btnCart;
	
	@FindBy(id="button-checkout")
	@CacheLookup
	WebElement btnCheckout;
	
	public void addItemToCart(String productid) throws InterruptedException
	{
		WebDriverWait wdw=new WebDriverWait(ldriver, 10);
		txtMainSearch.sendKeys(productid);
		Actions ac=new Actions(ldriver);
		ac.sendKeys(Keys.ENTER).build().perform();
		wdw.until(ExpectedConditions.visibilityOf(btnAddToCart));
		btnAddToCart.click();
		Thread.sleep(4000);
		btnCart.click();
		Thread.sleep(3000);
	}
	
	public void clickCheckoutIcon() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(ldriver, 10);
		btnCheckout=wait.until(ExpectedConditions.visibilityOf(btnCheckout));
		btnCheckout.click();
		Thread.sleep(3000);
	}

}
