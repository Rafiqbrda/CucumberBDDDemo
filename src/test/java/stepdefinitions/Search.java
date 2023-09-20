package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResultsPage;

public class Search {
	
	WebDriver driver;
    private	HomePage homePage;
    private SearchResultsPage searchResultsPage;// pora add
    
    
	@Given("Users open the application")
	public void users_open_the_application() {
	 driver = Driverfactory.getDriver();
	 
	}

	   @When("Users enter valid product {string} into search bos fields")
	   public void users_enter_valid_product_into_search_bos_fields(String validproductText) {
	    homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBox(validproductText);
		//driver.findElement(By.xpath("//input[@name='search']")).sendKeys(validproductText);
	}

	    @When("Users click on search button")
	    public void users_click_on_search_button() {
	    //homePage.clickOnSearchButton();	
	    searchResultsPage =	homePage.clickOnSearchButton();
		//driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	}

	     @Then("Users should get valid product on display")
	     public void users_should_get_valid_product_on_display() {
		// SearchResultsPage searchResultsPage = new SearchResultsPage(driver);  //pora delete
		 Assert.assertTrue(searchResultsPage.displayStatusOfProduct()); 
		 
		
	}

	    @When("Users enter invalid product {string} into search bos fields")
	    public void users_enter_invalid_product_into_search_bos_fields(String invalidproductText) {
		homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBox(invalidproductText);
	   // driver.findElement(By.xpath("//input[@name='search']")).sendKeys(invalidproductText); 
	}

	   @Then("Users should get warning message for product no matching")
	    public void users_should_get_warning_message_for_product_no_matching() {
		//SearchResultsPage searchResultsPage = new SearchResultsPage(driver);  //pora delete
		Assert.assertEquals("There is no product that matches the search criteria.",searchResultsPage.getMessageText() );
	    
	}

	   @When("Users do not  enter any product name into search box field")
	   public void users_do_not_enter_any_product_name_into_search_box_field() {
	   homePage = new HomePage(driver);
	}

	
	
	
	
}
