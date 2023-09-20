package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

	WebDriver driver;
	
	public SearchResultsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validHPProduct;
	
    @FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
	private WebElement messageText;
	
	
	
	
	
	
	public boolean displayStatusOfProduct() {
	return	validHPProduct.isDisplayed();
	}
	public String getMessageText() {
	return	messageText.getText();
	}
	
	
	
	
	
	
}
