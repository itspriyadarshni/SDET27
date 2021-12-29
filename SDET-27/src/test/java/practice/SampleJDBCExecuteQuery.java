package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	public static void main(String[] args) throws SQLException {
	
	/*Step1: Register the driver*/
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		 
    /*Step 2: get connection with database - provide db name*/
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Sailor@2020");
		 
	/* Step 3: issue create statement*/
		 Statement state = con.createStatement();
		 
	/*step 4: execute query*/
		 ResultSet result = state.executeQuery("select * from employeeinfo;");
		 
		 while(result.next())
		 {
			 System.out.println(result.getString(2)+" "+result.getString(3)); 
		 }
		 
		 /* step 5: close the db*/
		 con.close();
	}

}
