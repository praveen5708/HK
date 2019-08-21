package hobbyKing.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Payment {
	
	public WebDriver ldriver;
	
	public Payment(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Paypal
		@FindBy(xpath="//input[@id='email']")
		@CacheLookup
		WebElement txtPaypalEmail;
		
		@FindBy(xpath="//input[@id='password']")
		@CacheLookup
		WebElement txtPaypalPassword;
		
		@FindBy(xpath="//button[@id='btnLogin']")
		@CacheLookup
		WebElement btnPaypalLogIn;
		
		@FindBy(xpath="//input[@id='confirmButtonTop']")
		@CacheLookup
		WebElement btnPayNow;
		
		//Worldpay
		@FindBy(id="wp-cl-checkout-payment-worldpay-container-iframe")
		@CacheLookup
		WebElement frameId;
		
		@FindBy(id="cardNumber")
		@CacheLookup
		WebElement txtCardNumber;
		
		@FindBy(id="expiryMonth")
		@CacheLookup
		WebElement txtExpiryMonth;
		
		@FindBy(id="expiryYear")
		@CacheLookup
		WebElement txtExpiryYear;
		
		@FindBy(id="securityCode")
		@CacheLookup
		WebElement txtSecurityCode;
		
		@FindBy(id="submitButton")
		@CacheLookup
		WebElement btnSubmitPayment;
		
		//Completed Order Number
		@FindBy(xpath="//a[contains(text(),'220000')]")
		@CacheLookup
		WebElement lblOrderNumber;
		
		//Paypal
		public void setPaypalPayment(String paypalemail, String paypalpassword) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(ldriver, 10);
			txtPaypalEmail=wait.until(ExpectedConditions.visibilityOf(txtPaypalEmail));
			txtPaypalEmail.clear();
			txtPaypalEmail.sendKeys(paypalemail);
			
			txtPaypalPassword.click();
			txtPaypalPassword.sendKeys(paypalpassword);
			
			btnPaypalLogIn.click();
			
			Thread.sleep(15000);
			btnPayNow.click();
		}
		
		//Worldpay
		public void setWordlpayPayment(String worldpaycardnumber, String worldpayexpirymonth, String worldpayexpiryyear, String worldpaysecuritycode) throws InterruptedException
		{
			ldriver.switchTo().frame(frameId);
			
			WebDriverWait wait = new WebDriverWait(ldriver, 10);
			txtCardNumber=wait.until(ExpectedConditions.visibilityOf(txtCardNumber));
			
			ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			txtCardNumber.clear();
			txtCardNumber.sendKeys(worldpaycardnumber);
			
			ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			txtExpiryMonth.clear();
			txtExpiryMonth.sendKeys(worldpayexpirymonth);
			
			ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			txtExpiryYear.clear();
			txtExpiryYear.sendKeys(worldpayexpiryyear);
			
			ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			txtSecurityCode.clear();
			txtSecurityCode.sendKeys(worldpaysecuritycode);
			
			ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			btnSubmitPayment.click();
			
			ldriver.switchTo().defaultContent();
			
			Thread.sleep(5000);
		}
		
		//Completed Order Number
		public void getOrderNumber()
		{
			String OrderNumber = lblOrderNumber.getText();
			System.out.println("YOUR ORDER NUMBER IS "+OrderNumber);
		}

}
