package com.vtiger.comcast.genericutility;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Priya
 *
 */
public class JavaUtility {
	
	/**
	 * used to generate random number
	 * @return
	 */
public int getRandomNumber() {
	Random r=new Random();
	int intrandom = r.nextInt(1000);
	return intrandom;
}

/**
 * used to return the system date in IST format
 * @return
 */

public String getSystemDateAndTime() {
	Date date=new Date();
	String sysdate = date.toString();
	return sysdate;
}

/**
 * used to return date in yyyy-mm-dd format
 * @return
 */

public String getSystemDate() {
	Date date=new Date();
	String sysdate = date.toString();
	String year = sysdate.split(" ")[5];
	String day = sysdate.split(" ")[2];
	int month = date.getMonth()+1;
	return(year+"-"+month+"-"+day);
	
}

}
