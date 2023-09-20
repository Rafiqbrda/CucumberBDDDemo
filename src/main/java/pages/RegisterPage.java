package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
    public RegisterPage(WebDriver driver) {
    this.driver = driver;	
    PageFactory.initElements(driver, this);	
    }	
    	
    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameField;
    
    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameField;
    
   @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;
    
    @FindBy(xpath = "//input[@name='telephone']")
    private WebElement telephoneField;
    
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    
    @FindBy(xpath = "//input[@name='confirm']")
    private WebElement passwordConfirmFeild;
    
    @FindBy(xpath = "//input[@name='agree']")
    private WebElement privacyPolicyOption;
    
    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButtonFeild;
    
   @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement warningMessage;
    
   @FindBy(xpath = "//div[text()='First Name must be between 1 and 32 characters!']")
    private WebElement firstNameWarning;
   
   @FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
    private WebElement lastNameWarning;
    
   @FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
    private WebElement emailWarning;
   
   @FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
    private WebElement telephoneWarning;
    
    @FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
    private WebElement passwordWarning;
    
    
    
    
    
         public void enterFirstName(String firstNameText) {
    	 firstNameField.sendKeys(firstNameText);
         }
         public void enterlastName(String lastNameText) {
    	 lastNameField.sendKeys(lastNameText);
         }
         public void enterEmailAddress(String emailText) {
    	 emailField.sendKeys(emailText);
         }   
         public void entertelephoneNumber(String telephoneText) {
    	 telephoneField.sendKeys(telephoneText);
         }
         public void enterpassword(String passwordText) {
    	 passwordField.sendKeys(passwordText);
        }
         public void enterConfirmPassword(String passwordText) {
        	 passwordConfirmFeild.sendKeys(passwordText);
         } 
         public void selectPrivacyPolicy() {
        	 privacyPolicyOption.click();
         }
         //public void clickOnContinueButton() {
        	 public AccountSuccessPage clickOnContinueButton() { 
        	 continueButtonFeild.click();
        	 return new AccountSuccessPage(driver);    // pora add
         } 
         public String getWarnimgMessage() {
    	 return warningMessage.getText(); 
     }      
       
        
        public String getFirstNameWarning() {
        return firstNameWarning.getText();
     }
        public String getLastNameWarning() {
        return lastNameWarning.getText();
      }
        public String getEmailWarning() {
        return emailWarning.getText();
     }
        public String getTelephoneWarning() {
        return	telephoneWarning.getText();
     }   
        public String getPasswordWarning() {
        return passwordWarning.getText();
     }
     
     
     
     
     
     
     
     
     
}
