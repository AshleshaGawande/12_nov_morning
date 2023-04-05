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
import org.testng.asserts.SoftAssert;

import browsersSetup.Base;
import pom.forgotPaswordPage;
import pom.loginpage;

public class VerifyForgotPasswordPage  extends Base{

	   WebDriver driver;
	   forgotPaswordPage forgotPassPage;
	   loginpage loginPage;
	   
	   
	   
	   @Parameters ("browser")
	   @BeforeTest
	   public void openBrowser(String BrowserName) {
	   System.out.println("Before Test");
	   if(BrowserName.equals("chrome"));
	   {
		   
		   driver = openChromeBrowser();
	   }
	   
	  if(BrowserName.equals("Edge"))
	  {

		   
		   driver = openEdgeBrowser();
	  }
	  
	  //extra code for understand git
	  if(BrowserName.equals("safari"))
	  {

		   
		   driver = opensafariBrowser();
	  }
	  
	  
	  
	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	   }
	   private WebDriver opensafariBrowser() {
		// TODO Auto-generated method stub
		return null;
	}
	@BeforeClass
	   public void createPomObjects() {
		    forgotPassPage =new  forgotPaswordPage(driver);
		    loginPage= new  loginpage(driver);
		   
		   
	
	   }
	   
	   @BeforeMethod
	   public void goToForgotPasswodPage() {
		   System.out.println("Before Method");
		   driver.get("https://www.facebook.com/");
		   
		   loginPage.clickOnForgotPasswoed();
		   //forgotPassPage = new forgotPaswordPage(driver);
		   
	   }
	   
	   @Test
	   public void verifyMessageOnForgotPasswordPage() {
		   System.out.println("Test1");
		   // forgotPassPage = new ForgotPassPage(driver);
        String actualMsg = forgotPassPage.getTextMessage();
        String expectedMsg = "Please enter your email address or mobile number to search for your account.";
       Assert.assertEquals(actualMsg, expectedMsg);
	   }  
	   @Test 
	   public void verifyCancleButtonForgotPasswardPage() {
		   System.out.println("Test2");
		   // forgotPassPage = new ForgotPassPage(driver);
		    forgotPassPage.clickOnSarchButton();
		    String expectedURL="https://www.facebook.com/login/identify/?ctx=recover&ars=facebook_login&from_login_screen=0";
		    String expectedTitle="Log in to Facebook";
            String actualURL =driver.getCurrentUrl();
            String actualTitle=driver.getTitle();
            
            SoftAssert soft=new SoftAssert();
            soft.assertEquals(actualTitle, expectedTitle);
            soft.assertAll();
            Assert.assertEquals(actualURL, expectedURL);
           // soft.assertEquals(actualTitle, expectedTitle);
	   }
	   
	   @Test (priority=-1)
	   public void verifyCancleButtoForgotPasswardPage() {
		   System.out.println("Test3");
		   // forgotPassPage = new ForgotPassPage(driver);
		    forgotPassPage.clickOnSarchButton();
		    String expectedURL="https://www.facebook.com/login/identify/?ctx=recover&ars=facebook_login&from_login_screen=0";
		    String expectedTitle="Log in to Facebook";
            String actualURL =driver.getCurrentUrl();
            String actualTitle=driver.getTitle();
            
            SoftAssert soft=new SoftAssert();
            soft.assertEquals(actualTitle, expectedTitle);
            Assert.assertEquals(actualURL, expectedURL);
           // soft.assertEquals(actualTitle, expectedTitle);
	   }
	   
	   
	   
	   
      
//	   }
	   @Test (priority=1)
	   public void veriffySearchFunctionOnForgotPasswordPage() {
		   System.out.println("Test4");
		  //  forgotPassPage = new ForgotPassPage(driver);
		    forgotPassPage.sendMail();
		    forgotPassPage.clickOnSarchButton();
		    String actualText =driver.getTitle();
	        String expectedText="Forgotten Password | Can't Log In | Facebook";
	        Assert.assertEquals(actualText, expectedText);
	           
		    
		    
	   }
	   
	   
	   @AfterMethod
	   public void logoutFromApplicatiion() {
		   System.out.println("After method");
	   }
	   @AfterClass()
	   public void clearObjects() {
		   forgotPassPage=null;
		   loginPage=null;
		   
	   }
	   @AfterTest
	   public void closedBrowser() {
		   System.out.println("after test");
		   driver.quit();
		   driver=null;
		   System.gc();//garbage collection
		   
	   }
	   
	   
	   
	   
	   
}

	
	

