package facebook_maven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.loginpage;

public class Test1 {
	  public static void main(String[] args) throws InterruptedException
      {
    	  System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\User\\\\Documents\\\\automation\\\\selenium\\\\chromedriver_win32\\\\chromedriver.exe");	
		   WebDriver driver = new ChromeDriver();
		   driver.manage().timeouts().implicitlyWait(20000,TimeUnit.MILLISECONDS);
		   driver.get("https://www.facebook.com/");
		   Thread.sleep(3000);
		   
		   loginpage loginPage= new loginpage(driver);
		   loginPage.sendUserName();
		   loginPage.sendPassword();
		   loginPage.clickOnLoginButton();
	  }
}


