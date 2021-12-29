package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws Throwable {
		Connection con=null;
		try{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Sailor@2020");
		Statement state = con.createStatement();
		int result = state.executeUpdate("insert into employee values(4,'raja','Chennai');");
		if(result==1)
		{
			System.out.println("Data added");
		}
		else
		{
			System.out.println("data not added");
		}}
		catch(Exception e){
			
		}
		finally {      
		con.close();
		System.out.println("done");
		}
	}

}
