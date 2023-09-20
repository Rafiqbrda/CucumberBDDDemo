package utils;

import java.util.Date;

public class CommonUtils {

	    // public static String getEmailTimestamp() {//remove Static
		 public  String getEmailTimestamp() {
			
			Date date = new Date();
			return "rafiqueltaj"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
			
	
	 }	
}
