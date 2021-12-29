package com.vtiger.comcast.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImpl implements IRetryAnalyzer {

	int count =0;
	int retrycount=4;
	
	public boolean retry(ITestResult result) {
	
		
		while(count<retrycount) {
			count++;
			return true;
		}
		return false;
	}
	
	

}
