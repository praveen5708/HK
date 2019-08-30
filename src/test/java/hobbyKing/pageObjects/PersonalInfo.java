package hobbyKing.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfo {
	
public WebDriver ldriver;
	
	public PersonalInfo(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//div[@class='fieldset']//div[@class='add-address -js-add-address']")
	@CacheLookup
	WebElement btnAddAddress;
	
	@FindBy(id="billing:firstname")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(id="billing:lastname")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(name="billing[telephone]")
	@CacheLookup
	WebElement txtTelephone;
	
	@FindBy(id="billing:street1")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(xpath="//span[@id='select2-billingcountry_id-container']")
	@CacheLookup
	WebElement drpCountry;
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	@CacheLookup
	WebElement drpSearchCountry;
	
	@FindBy(xpath="//li[contains(@id, 'select2-billingcountry_id-result')]")
	@CacheLookup
	WebElement drpSelectCountry;
	
	@FindBy(xpath="//span[@id='select2-billingregion_id-container']")
	@CacheLookup
	WebElement drpState;
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	@CacheLookup
	WebElement drpSearchState;
	
	@FindBy(xpath="//li[contains(@id, 'select2-billingregion_id-result')]")
	@CacheLookup
	WebElement drpSelectState;
	
	@FindBy(xpath="//span[@id='select2-billingsuburb_sel-container']")
	@CacheLookup
	WebElement drpSuburb;
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	@CacheLookup
	WebElement drpSearchSuburb;
	
	@FindBy(xpath="//li[contains(@id, 'select2-billingsuburb_sel-result')]")
	@CacheLookup
	WebElement drpSelectSuburb;
	
	@FindBy(xpath="//span[@id='select2-billingpostcode_sel-container']")
	@CacheLookup
	WebElement drpZip;
	
	@FindBy(xpath="//li[contains(@id, 'select2-billingpostcode_sel-result')]")
	@CacheLookup
	WebElement drpSelectZip;
	
	@FindBy(xpath="//label[contains(@class, 'label')][contains(text(),'Save in address book')]")
	@CacheLookup
	WebElement chkSaveInAddressBook;
	
	@FindBy(xpath="//button[@class='button']")
	@CacheLookup
	WebElement btnContinue;
	
	@FindBy(xpath="//div[@id='billing-buttons-container']//button[@id='continue_button']")
	@CacheLookup
	WebElement btnExpressPaypalContinue;
	
	public void setPersonalInfoAustraliaUser(String fname, String lname, String telephone, String addr, String country, String state, String suburb) throws InterruptedException
	{
		
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
		
		txtLastName.clear();
		txtLastName.sendKeys(lname);
		
		txtTelephone.clear();
		txtTelephone.sendKeys(telephone);
		
		txtAddress.clear();
		txtAddress.sendKeys(addr);
		
		drpCountry.click();
		drpSearchCountry.sendKeys(country);
		drpSelectCountry.click();
		
		drpState.click();
		drpSearchState.sendKeys(state);
		drpSelectState.click();
		
		drpSuburb.click();
		drpSearchSuburb.sendKeys(suburb);
		drpSelectSuburb.click();
		
		drpZip.click();
		drpSelectZip.click();
		
		if(checkContinueButton("bvalueContinueButton")==true)
		{
			btnContinue.click();
		}
		else
		{
			btnExpressPaypalContinue.click();
		}
		
		Thread.sleep(10000);
	}
	
	public boolean checkContinueButton(String bvalueContinueButton)
	{
		try
		{
			btnContinue.isDisplayed();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
