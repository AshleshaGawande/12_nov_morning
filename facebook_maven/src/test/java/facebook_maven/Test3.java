package facebook_maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.loginpage;
import pom.signUpPage;
import pom.signUpPopup;

public class Test3 {
	  public static void main(String[] args) throws InterruptedException 
	     {
	    	 System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Documents\\Automation\\Selenium\\chromedriver_win32\\chromedriver.exe");	
			   WebDriver driver = new ChromeDriver();
			   driver.get("https://www.facebook.com/");
			   Thread.sleep(3000);
			   
			   loginpage loginPage= new loginpage(driver);
			   loginPage.clickOnCreateNewAcc();
			   Thread.sleep(3000);

			   signUpPopup signUpPopUP= new signUpPopup(driver);
			   signUpPopUP.sendFirstName();
			   signUpPopUP.sendLastName();
			   signUpPopUP.sendMailId();
			   signUpPopUP.sendReMailId();
			   signUpPopUP.sendPassword();
			   signUpPopUP.seletDayDOB();
			   signUpPopUP.seletMonthDOB();
		       signUpPopUP.seletYearDOB();
		       signUpPopUP.seletFemale();
		       signUpPopUP.clickSubmit();
		       
		 }

}
