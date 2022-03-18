package Task.automation_practice;

import static org.junit.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class methods {
	
	public  static void getUrl(WebDriver driver,String url)
	{
		
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}

public  static void SignIn(WebDriver driver)
		{
			
			WebElement Signin_button= driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
			Signin_button.click();
		}
	
public  static void VALIDATE_Error(WebDriver driver,String error_message) {
		
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement Signin = driver.findElement(By.id("SubmitCreate"));
	Signin.click();
	WebElement error=driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li"));
	String s1= (error.getText());
	assertTrue(s1.contains(error_message));
	
}	
public  static void VALIDATE_Error2(WebDriver driver,String email,String error_message) {
	
	WebElement emaill=driver.findElement(By.id("email_create"));
	emaill.sendKeys(email);
	WebElement Signin = driver.findElement(By.id("SubmitCreate"));
	Signin.click();
	WebElement error=driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li"));
	String s1= (error.getText());
	assertTrue(s1.contains(error_message));	
}
public  static void Sign_In(WebDriver driver, String emaill)
{
	WebElement email= driver.findElement(By.id("email_create"));
	
	email.clear();
	email.sendKeys(emaill); 
	
	WebElement btn = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]"));
	btn.click();
}
public static void validate_filling(WebDriver driver ,String error_message)
{
	WebElement register_button=driver.findElement(By.id("submitAccount"));
	register_button.click();
	WebElement error=driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p"));
    String s1= error.getText();
    assertTrue(s1.contains(error_message));
}
public  static void fillData(WebDriver driver,String firstName ,String lastName,String Password,String Day,String Month ,String Year,String Company,String Address1,String city , String State , String PostCode,String Additional,String Phone,String PhoneMobile ,String Alias)
{
			WebElement radio1=driver.findElement(By.xpath("//*[@id=\"uniform-id_gender2\"]/span"));
			radio1.click();
			WebElement first_name=driver.findElement(By.id("customer_firstname"));
			first_name.sendKeys(firstName);
			WebElement last_name=driver.findElement(By.id("customer_lastname"));
			last_name.sendKeys(lastName);
			WebElement mail=driver.findElement(By.id("email"));
			mail.click();
			WebElement password=driver.findElement(By.id("passwd"));
			password.sendKeys(Password);
			WebElement day= driver.findElement(By.xpath("//*[@id=\"days\"]"));
			Select select1 = new Select(day);
			select1.selectByValue(Day);
			WebElement month= driver.findElement(By.id("months"));
			Select select2 = new Select(month);
			select2.selectByValue(Month);
			WebElement year= driver.findElement(By.id("years"));
			Select select3 = new Select(year);
			select3.selectByValue(Year);
			WebElement check1=driver.findElement(By.xpath("//*[@id=\"uniform-newsletter\"]"));
			check1.click();
			WebElement check2=driver.findElement(By.xpath("//*[@id=\"uniform-optin\"]"));
			check2.click();
			WebElement company=driver.findElement(By.id("company"));
			company.sendKeys(Company);
			WebElement address1=driver.findElement(By.id("address1"));
			address1.sendKeys(Address1);
			WebElement City=driver.findElement(By.id("city"));
			City.sendKeys(city);
			WebElement state= driver.findElement(By.id("id_state"));
			Select select4 = new Select(state);
			select4.selectByValue(State);
			WebElement post_code=driver.findElement(By.id("postcode"));
			post_code.sendKeys(PostCode);
			WebElement additional=driver.findElement(By.id("other"));
			additional.sendKeys(Additional);
			WebElement phone=driver.findElement(By.id("phone"));
			phone.sendKeys(Phone);
			WebElement phone_mobile=driver.findElement(By.id("phone_mobile"));
			phone_mobile.sendKeys(PhoneMobile);
			WebElement alias=driver.findElement(By.id("alias"));
			alias.clear();
			alias.sendKeys(Alias);
			WebElement Submit=driver.findElement(By.id("submitAccount"));
			Submit.click();
}
public static void SignOut(WebDriver driver) {
	WebElement Sign_out=driver.findElement(By.linkText("Sign out"));
	Sign_out.click();
}
public static void Authenicattion_FAILED(WebDriver driver ,String emaill,String pass) {
	
	WebElement email=driver.findElement(By.id("email"));
	email.sendKeys("mmm");
	WebElement password =driver.findElement(By.id("passwd"));
	password.sendKeys(pass);
	WebElement button= driver.findElement(By.name("SubmitLogin"));
	button.click();
	WebElement error1=driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	String erorr_mail=error1.getText();
	assertTrue(erorr_mail.contains("Invalid email address."));
	WebElement email2=driver.findElement(By.id("email"));
	email2.sendKeys(emaill);
	WebElement password2 =driver.findElement(By.id("passwd"));
	password2.sendKeys(pass);
	WebElement button2= driver.findElement(By.name("SubmitLogin"));
	button2.click();
	WebElement error2=driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	String erorr_pass=error2.getText();
	assertTrue(erorr_pass.contains("Authentication failed."));
}
public static void LogIn(WebDriver driver ,String emaill,String passw) {
	

	WebElement email=driver.findElement(By.id("email"));
	email.clear();
	email.sendKeys(emaill);
	WebElement password =driver.findElement(By.id("passwd"));
	password.clear();
	password.sendKeys(passw);
	WebElement button= driver.findElement(By.name("SubmitLogin"));
	button.click();
	
}

public static void category(WebDriver driver )
{
	WebElement searchBtn = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]"));
	Actions action = new Actions(driver);
	action.moveToElement(searchBtn).build().perform();
	WebElement menuOption = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[2]/a"));
	action.moveToElement(searchBtn).moveToElement(menuOption).click().build().perform();
	
}
public static void select(WebDriver driver) {
	WebElement searchBtn0 = driver.findElement(By.linkText("Blouse"));
	Actions action = new Actions(driver);
	action.moveToElement(searchBtn0).build().perform();
	WebElement searchBtn = driver.findElement(By.linkText("Add to cart"));
	action.moveToElement(searchBtn0).moveToElement(searchBtn).click().build().perform();
	}
public static void check_out01(WebDriver driver) {
	WebElement checkOut=driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
	checkOut.click();
}
public  static void CheckOut02(WebDriver driver) {
	WebElement checkout= driver.findElement(By.linkText("Proceed to checkout"));
	checkout.click();
}
public  static void CheckOut03(WebDriver driver) {
	WebElement checkout= driver.findElement(By.name("processAddress"));
	checkout.click();
}
public static void terms( WebDriver driver) {
	
	WebElement CheckBox=driver.findElement(By.xpath("//*[@id=\"cgv\"]"));
	CheckBox.click();
}
public  static void ProcessOfCheckOut(WebDriver driver)
{
	WebElement ProceedToCheck_Out=driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span"));
	ProceedToCheck_Out.click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement Pay_bybank=driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a"));
	Pay_bybank.click();
	WebElement Confirm=driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span"));
	Confirm.click();
}
public static void history(WebDriver driver) {
	
	WebElement history=driver.findElement(By.xpath("//*[@id=\"center_column\"]/p/a"));
	history.click();	
	WebElement ref=driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr/td[1]/a"));
	ref.click();
	WebElement product=driver.findElement(By.xpath("//*[@id=\"order-detail-content\"]/table/tbody/tr/td[2]"));
	String productt=product.getText();
    assertTrue(productt.contains("Blouse - Color : Black, Size : S"));	
}
}

