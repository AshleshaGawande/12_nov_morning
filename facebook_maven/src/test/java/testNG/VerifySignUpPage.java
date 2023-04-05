package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browsersSetup.Base;
import pom.loginpage;
import pom.signUpPage;
import pom.signUpPopup;

public class VerifySignUpPage extends Base{
	  WebDriver driver;
	   loginpage loginPage;
	   signUpPopup signUpPopUP;
	   signUpPage signUPPage;
	   
	   @Parameters ("browser")
	   @BeforeTest
	   public void openBrowser(String BrowserName) {
	   System.out.println("Before Test");
	   if(BrowserName.equals("chrome"));
	   {
		   //System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\automation\\selenium\\chromedriver_win32\\chromedriver.exe");
		   driver = new ChromeDriver();
		   driver = openChromeBrowser();
	   }
	   if(BrowserName.equals("Edge"))
		  {

			   //System.setProperty("webdriver.edge.driver","C:\\\\Users\\\\User\\\\Documents\\\\automation\\\\selenium\\\\edgedriver_win64\\\\msedgedriver.exe");
		   driver = openEdgeBrowser();
		  }
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		   
	   }
	 @BeforeClass
	   public void beforeClass() {
		  
		   System.out.println("Before Class");
		   loginpage loginPae=new loginpage(driver);
		   signUpPopUP = new signUpPopup(driver);
		   signUPPage = new signUpPage(driver);
	   }
	 
	   @BeforeMethod
	   public void beforeMethod() {
		   System.out.println("Before Method");
		   driver.get("https://www.facebook.com/");
		   
		   loginPage.clickOnCreateNewAcc();
		   
	   }
	   @Test
	   public void signpage1() {
		   System.out.println("Test1");
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
	       String xpectedResult="https://www.facebook.com/";
          String actualResult=driver.getCurrentUrl();
	     Assert.assertEquals(actualResult, xpectedResult);
	 	   
	   }
	   
	   @Test
	   public void signpage2() {
		   System.out.println("Test2");
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
	       String xpectedResult="https://www.facebook.com/";
          String actualResult=driver.getCurrentUrl();
	     Assert.assertEquals(actualResult, xpectedResult);
	 	   
	   }
	   
	   
	   
	   @Test
	   public void signUpPage() {
		   System.out.println("Test3");
		   signUPPage.sendFirstName();
		   signUPPage.sendLastName();
		   signUPPage.sendMailId();
		   signUPPage.sendReMailId();
		   signUPPage.sendPassword();
		   signUPPage.seletDayDOB();
		   signUPPage.seletMonthDOB();
		   signUPPage.seletYearDOB();
		   signUPPage.clickSubmit();

	       String xpectedResult="Please choose a gender. You can change who can see this later.";
	       String actualResult=signUPPage.errorMsgGender();
	     Assert.assertEquals(actualResult, xpectedResult);
	     
	    
	   }
	   @Test
	   public void signupPage2() {
		   System.out.println("Test4");
		   signUPPage.sendFirstName();
		   signUPPage.sendLastName();
		   signUPPage.sendMailId();
		   signUPPage.sendReMailId();
		   signUPPage.sendPassword();
		   signUPPage.seletDayDOB();
		   signUPPage.seletMonthDOB();
		   signUPPage.seletYearDOB();
		   signUPPage.clickSubmit();

	       String xpectedResult="Please choose a gender. You can change who can see this later.";
	       String actualResult=signUPPage.errorMsgGender();
	     Assert.assertEquals(actualResult, xpectedResult);
	   }  
	   @AfterMethod
	   public void afterMethod() {
		   System.out.println("After Method");
	   }
	   @AfterClass()
	   public void clearObjects() {
		   
		   loginPage =null;
		   signUpPopUP =null;
		   signUPPage =null;
		   
		   
	   }
	   
	   
	   @AfterTest
	   public void closedBrowser() {
		   System.out.println("after test");
		   driver.quit();
		   driver=null;
		   System.gc();//garbage collection
		   
	   }
	   
}


