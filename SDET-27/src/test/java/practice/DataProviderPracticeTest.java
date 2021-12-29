package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPracticeTest {
	
	@Test (dataProvider="getData")
	public void readDataFromDataProviderTest(String name,String model, int Quantity) {
		
		System.out.println("Mobile name: "+name+"-------Quantity: "+Quantity);
	}
	
	
	
	
	@DataProvider
	public Object[] [] getData()
	{
		Object[] [] objarray=new Object[5] [3];
		
		objarray[0] [0]="iphone";
		objarray[0] [1]="13pro";
		objarray[0] [2]=3;
		
		
		objarray[1] [0]="samsung";
		objarray[1] [1]="Z fold";
		objarray[1] [2]=5;
		
		objarray[2] [0]="vivo";
		objarray[2] [1]="v15";
		objarray[2] [2]=4;
		
		objarray[3] [0]="google pixel";
		objarray[3] [1]="10";
		objarray[3] [2]=2;
		
		objarray[4] [0]="one plus";
		objarray[4] [1]="9";
		objarray[4] [2]=1;
		
		;
		return objarray;
	}
	

}
