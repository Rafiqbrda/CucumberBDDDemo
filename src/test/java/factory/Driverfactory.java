package factory;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.configReader;

public class Driverfactory {
	
	             //WebDriver driver = null;    //....  4
	       static  WebDriver driver =null;    //...... 5
	          // public static WebDriver initializeBrowser(String browserName) {  ....7
	    	   // public static void initializeBrowser(String browserName) {
	       public static WebDriver initializeBrowser(String browserName) {
	    		
		  //  WebDriver driver = null;   //  ..... 2
		//WebDriver driver = null;
	
	   if(browserName.equals("chrome")) {
		//WebDriver driver = new ChromeDriver();    //   1
		 driver = new ChromeDriver();
	}
		if(browserName.equals("firefox")) {
	
			 driver = new FirefoxDriver();
		}
		if(browserName.equals("edge")) {
			 driver = new EdgeDriver();
		}
		 
		  driver.manage().deleteAllCookies();
		  driver.manage().window().maximize();                                   // 3 lines come from myhook
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));      // pora
		 return driver;
		
	//return driver;  //.... 6
	}
	
	//public void getDriver() {     //    ..... 3
	 // public static void getDriver() { // .... 8
	  public static WebDriver getDriver() {  
	  return driver;
	
	
	}	
}	
	
	
	
	


