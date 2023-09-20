package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.configReader;

public class MyHooks {
	
	 WebDriver driver; 
    private	 configReader ConfigReader;
    @Before
	public void setup() {
    	
    	  configReader ConfigReader = new configReader();  //pora object made , for remove Static
    	  Properties prop = ConfigReader.intializeProperties();
    	
		 // Driverfactory.initializeBrowser(prop.getProperty("browser")); 
		  driver =  Driverfactory.initializeBrowser(prop.getProperty("browser"));
		 // driver =  Driverfactory.getDriver(); 
		  driver.get(prop.getProperty("url"));
		  
		 // driver.manage().deleteAllCookies();
		 // driver.manage().window().maximize();
		 // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 // driver.get(prop.getProperty("url"));
		 
	
           // WebDriver driver;    // ----- 3
          //  @Before
	       // public void setup() {
	//prop = configReader.intializeProperties()  //.....8
			//Properties prop = configReader.intializeProperties();	
	       // Driverfactory.initializeBrowser("chrome"); //................. 1
	// WebDriver driver =   Driverfactory.initializeBrowser("chrome");   //  2
	// Driverfactory.initializeBrowser("chrome");   //  5
	// Driverfactory.initializeBrowser(prop.getProperty("browser"));	//.... 9
	// Driverfactory.getDriver();  //..... 6
	
	
	/*
	 * driver = Driverfactory.getDriver(); // .... 7
	 * driver.manage().deleteAllCookies(); //------------- 4
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 * driver.get("https://tutorialsninja.com/demo/");
	 */
	  
	 
	 
    
    }
    
    
    
    
    
   //@After
	//public void teardown() {
	
	//driver.quit();
    //}	

   
       @After
	   public void teardown(Scenario scenario) {   // screenShot Er jonno
	   String scenarioName =   scenario.getName().replaceAll(" ", "_") ;
	   if(scenario.isFailed()) {
	   
         byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		   scenario.attach(srcScreenshot, "image/png", scenarioName);
	   }	   
		   
	   driver.quit();
		
} 
   
   
   
   
   
   
   
}