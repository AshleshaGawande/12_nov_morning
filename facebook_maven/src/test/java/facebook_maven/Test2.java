package facebook_maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.forgotPaswordPage;
import pom.loginpage;

public class Test2 {
	  public static void main(String[] args) throws InterruptedException 
      {
	   System.setProperty("webdriver.chrome.driver","C:\\\\\\\\Users\\\\\\\\User\\\\\\\\Documents\\\\\\\\automation\\\\\\\\selenium\\\\\\\\chromedriver_win32\\\\\\\\chromedriver.exe");	
	   WebDriver driver = new ChromeDriver();
	   driver.get("https://www.facebook.com/");
	   Thread.sleep(3000);
	   
	   loginpage loginPage= new loginpage(driver);
	   loginPage.clickOnForgotPasswoed();

	   forgotPaswordPage forgotPassPage= new forgotPaswordPage(driver);
	   Thread.sleep(15000);
	   forgotPassPage.sendMail();
	   forgotPassPage.clickOnSarchButton();
	   

}
}
