package stepdefinitions;

import java.time.Duration;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;


    public class login {
    	
	WebDriver driver;     //.... add + 5
	private LoginPage loginpage;
	 private AccountPage accountPage;
    private	 CommonUtils commonUtils;
	//WebDriver driver;    //..... 3
   // @Before
	//public void setup() {
	
	// driver = new ChromeDriver() ; 
	// driver.manage().deleteAllCookies();
	// driver.manage().window().maximize();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //.... 1
	// driver.get("https://tutorialsninja.com/demo/");
 //  }
	//@After
	//public void teardown()	{
	//	driver.quit();                   //..... 2
   
	//}
   

    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
    	//Driverfactory.getDriver();     // add + 4
         driver = Driverfactory.getDriver();   //... 6
         HomePage homepage = new HomePage(driver);
         homepage.clickonMyAccount();
       // homepage.selectLoginOption();
  loginpage =  homepage.selectLoginOption();
        
    //driver.findElement(By.xpath("//span[text()='My Account']")).click();
    //driver.findElement(By.xpath("//a[text()='Login']")).click();
}

    @When("User enters valid email address {string} into email field")
    
    public void user_enters_valid_email_address_into_email_field(String emailText) {
	
	//loginpage = new LoginPage(driver);
	loginpage.enterEmailAddress(emailText);
 //driver.findElement(By.xpath("//input[@name='email']")).sendKeys(emailText);
	
}

     @And("User enters valid password {string} into password field")
     
      public void user_enters_valid_password_into_password_field(String passwordText) {
	  loginpage.enterPassword(passwordText); 
  // driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passwordText);
}

    @And("User clicks on login button")
    public void user_clicks_on_login_button() {
	//loginpage.clickOnLoginButton();
 accountPage	= loginpage.clickOnLoginButton();
  //driver.findElement(By.xpath("//input[@value='Login']")).click();
}

       @Then("User should get successfully logged in")
        public void user_should_get_successfully_logged_in() {
	   // AccountPage accountPage = new AccountPage(driver);
	    // accountPage = new AccountPage(driver);//  pora delete
   // Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed()); 
         Assert.assertTrue(accountPage.displayStatusOfAccountInformation()); 
}

         @When("User enters invalid email address into email field")
         public void user_enters_invalid_email_address_into_email_field() {
	    // loginpage = new LoginPage(driver);//  pora delete
        	 
        	//CommonUtils commonUtils = new CommonUtils();    // make object  , pora add Static remove korta 
        	 commonUtils = new CommonUtils();    // make object  , pora add Static remove korta 
             loginpage.enterEmailAddress(commonUtils.getEmailTimestamp());
   // driver.findElement(By.xpath("//input[@name='email']")).sendKeys(getEmailTimestamp());  
}

         @When("User enters invalid password {string} into password field")
         public void user_enters_invalid_password_into_password_field(String invalidpasswordText) {
	     loginpage.enterPassword(invalidpasswordText);
   // driver.findElement(By.xpath("//input[@name='password']")).sendKeys(invalidpasswordText);   
}

         @Then("User should get a proper warning message about credentials mismatch")
          public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
   // Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
        //  Assert.assertTrue(loginpage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
    
    Assert.assertTrue(loginpage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
}   

           @When("User does not enter  email address into email field")
           public void user_does_not_enter_email_address_into_email_field() {
	      // loginpage = new LoginPage(driver);//   pora delete
	       loginpage.enterEmailAddress("");
   //driver.findElement(By.xpath("//input[@name='email']")).sendKeys(""); 
	
}

             @When("User does not enter  password into password field")
              public void user_does_not_enter_password_into_password_field() {
	          loginpage.enterPassword("");
  //driver.findElement(By.xpath("//input[@name='password']")) .sendKeys(""); 
}

   
             
    //  private String getEmailTimestamp() {
	//Date date = new Date();
	//return "rafiqueltaj"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	

//}
}













