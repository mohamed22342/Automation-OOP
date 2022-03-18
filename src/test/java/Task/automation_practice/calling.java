package Task.automation_practice;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class calling {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\resources\\chromedriver.exe ");
		WebDriver driver= new ChromeDriver();
		methods.getUrl(driver, "http://automationpractice.com/");
		methods.SignIn(driver);
		methods.VALIDATE_Error(driver, "Invalid email address.");
		methods.VALIDATE_Error2(driver, "mm@gmail.com", "An account using this email address has already been registered. Please enter a valid password or request a new one.");
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);
		String emaill=("username"+ randomInt+randomInt +"@gmail.com");
		String Passw="12345678";
		methods.Sign_In(driver,emaill);
		methods.validate_filling(driver, "There are 8 errors");
        methods.fillData(driver, "Mohamed", "Maged", Passw, "6", "8", "1997", "Vodafone", "Maadi,Cairo",  "Giza", "30", "54321", "additional informaton", "9876543210", "0123456789", "address");
        methods.SignOut(driver);
        methods.Authenicattion_FAILED(driver,emaill,"1234");
        methods.LogIn(driver, emaill, Passw);
        methods.category(driver);
        methods.select(driver);
        methods.check_out01(driver);
        methods.CheckOut02(driver);
        methods.CheckOut03(driver);
        methods.terms(driver);
        methods.ProcessOfCheckOut(driver);
        methods.history(driver);
	}

}
