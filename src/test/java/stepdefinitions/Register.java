package stepdefinitions;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {
	
          WebDriver driver;
          private RegisterPage registerPage;   //    ..... 1
          private AccountSuccessPage accountSuccessPage;
          private  CommonUtils commonUtils;
          
          @Given("User open to register account page")
          public void user_open_to_register_account_page() {
        	  
	   driver = Driverfactory.getDriver(); 
	   HomePage hompag = new HomePage(driver);
	   hompag.clickonMyAccount();
	  // hompag.selectRegisterOption();
	   registerPage =   hompag.selectRegisterOption();   //   pora add
	   
	// driver.findElement(By.xpath("//span[text()='My Account']")).click();
	// driver.findElement(By.linkText("Register")).click();   
}

          @When("User provides infomation into the below fields")
          public void user_provides_infomation_into_the_below_fields(io.cucumber.datatable.DataTable dataTable) {
	      Map<String, String> dataMap = dataTable.asMap(String.class,String.class); 
	
	     // RegisterPage registerPage = new RegisterPage(driver);   //....1
	     // registerPage = new RegisterPage(driver);  // pora delete
	      registerPage.enterFirstName(dataMap.get("firstName"));
	      registerPage.enterlastName(dataMap.get("lastName"));
	     // CommonUtils commonUtils = new CommonUtils();  // pora add
	      commonUtils = new CommonUtils();
	      registerPage.enterEmailAddress(commonUtils.getEmailTimestamp());
	      registerPage.entertelephoneNumber(dataMap.get("telephone"));
	      registerPage.enterpassword(dataMap.get("password"));
	      registerPage.enterConfirmPassword(dataMap.get("password"));
	      
	      
	//driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(dataMap.get("firstName"));
	//driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(dataMap.get("lastName"));
	//driver.findElement(By.xpath("//input[@name='email']")).sendKeys(getEmailTimestamp());
	//driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys(dataMap.get("telephone"));
	//driver.findElement(By.xpath("//input[@name='password']")).sendKeys(dataMap.get("password"));
	//driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys(dataMap.get("password"));
}

          @When("User selects privacy policy")
          public void user_selects_privacy_policy() {
	      registerPage.selectPrivacyPolicy();
	//driver.findElement(By.xpath("//input[@name='agree']")).click(); 
}

        @When("User clicks continue button")
        public void user_clicks_continue_button() {
	 accountSuccessPage =  registerPage.clickOnContinueButton();
	//driver.findElement(By.xpath("//input[@value='Continue']")).click();
}


        @When("User account should create successfully")
        public void user_account_should_create_successfully() {
        	//AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);// pora delete
        	Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getPageHeading());
        	
        }
        	
        	
         @When("User not write any details into fields")
         public void user_not_write_any_details_into_fields() {
         //registerPage = new RegisterPage(driver);
          registerPage.enterFirstName("");
   	      registerPage.enterlastName("");
   	      registerPage.enterEmailAddress("");
   	      registerPage.entertelephoneNumber("");
   	      registerPage.enterpassword("");
   	      registerPage.enterConfirmPassword("");
        	 
   }

    @When("User shoult get important message for every blank fields")
    public void user_shoult_get_important_message_for_every_blank_fields() {
    	
	//Assert.assertTrue(registerPage.getWarnimgMessage().contains("Warning: You must agree to the Privacy Policy!"));
    	
	//Assert.assertEquals("First Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//div[text()='First Name must be between 1 and 32 characters!']")).getText());
	//Assert.assertEquals("Last Name must be between 1 and 32 characters!",driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText());
	//Assert.assertEquals("E-Mail Address does not appear to be valid!",driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText());
	//Assert.assertEquals("Telephone must be between 3 and 32 characters!",driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText());
	//Assert.assertEquals("Password must be between 4 and 20 characters!",driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText());

	Assert.assertTrue(registerPage.getWarnimgMessage().contains("Warning: You must agree to the Privacy Policy!"));
	
	
	Assert.assertEquals("First Name must be between 1 and 32 characters!", registerPage.getFirstNameWarning());
	Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerPage.getLastNameWarning());
	Assert.assertEquals("E-Mail Address does not appear to be valid!",registerPage.getEmailWarning());
	Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerPage.getTelephoneWarning());
	Assert.assertEquals("Password must be between 4 and 20 characters!",registerPage.getPasswordWarning());





}











    private String getEmailTimestamp() {
	
	Date date = new Date();
	return "rafiqueltaj"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
     }	


	
}
