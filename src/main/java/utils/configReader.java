package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configReader {
	
	   //public static Properties intializeProperties() {
		public   Properties intializeProperties() {	// move Static
	    Properties prop = new Properties();
	    File proFile = new File(System.getProperty("user.dir")+"\\sre\\test\\resources\\config\\config.properties");
	
	
	try {
	FileInputStream fis = new FileInputStream(proFile);
	prop.load(fis);		
	}catch(Throwable e) {		
	e.printStackTrace();		
}
	
return prop;	
			
	}	
	
}	
	
	
	
	
	
	
	

	/*
	 * public static Properties intializeProperties() {
	 * 
	 * Properties prop = new Properties(); File proFile = new
	 * File(System.getProperty("user.dir")+
	 * "\\sre\\test\\resources\\config\\config.properties");
	 * 
	 * try { FileInputStream fis = new FileInputStream(proFile); prop.load(fis); }
	 * catch (Throwable e) { e.printStackTrace(); } return prop; }
	 */

