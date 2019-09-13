package hobbyKing.pageObjects;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hobbyKing.utilities.XLUtils;

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
	
	//Select Country
	@FindBy(xpath="//div[@class='store-language-container']//div[@class='js-change-location-header']")
	WebElement drpCountry;
	
	@FindBys(@FindBy(xpath="//*[@id=\"header-custom\"]/div/ul/li"))
	@CacheLookup
	List<WebElement> lstCountries;
	//css="span.title"
	
//	@Test(dataProvider = "LoginData")
	public void selectCountry(String countrytobeselected) throws InterruptedException
	{
		Actions action = new Actions(ldriver);
		drpCountry.click();
		action.moveToElement(drpCountry);
		
		for (WebElement element : lstCountries)
		{
			if(element.getText().equals(countrytobeselected))
			{
				element.click();
				break;
			}
		}
		Thread.sleep(5000);
		
	}
	
	
//	@Test(dataProvider = "LoginData")
//	public void selectCountry(String username)
//	{
//		
//	}
//	
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
//
//	}

	
	public void addItemToCart(String productid) throws InterruptedException
	{
		WebDriverWait wdw=new WebDriverWait(ldriver, 10);
		wdw.until(ExpectedConditions.visibilityOf(txtMainSearch));
		txtMainSearch.click();
		txtMainSearch.sendKeys(productid);
		Actions action=new Actions(ldriver);
		action.sendKeys(Keys.ENTER).build().perform();
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
