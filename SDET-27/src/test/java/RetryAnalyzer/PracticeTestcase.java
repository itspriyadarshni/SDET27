package RetryAnalyzer;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeTestcase {

@Test(retryAnalyzer = com.vtiger.comcast.genericutility.RetryAnalyserImpl.class)	
public void testCase() {
	System.out.println("print");
    Assert.fail();
}
}
