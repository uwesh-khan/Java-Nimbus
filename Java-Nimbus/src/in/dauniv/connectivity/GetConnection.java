package in.dauniv.connectivity;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ResourceBundle;
public class GetConnection {

private static final ResourceBundle rb =ResourceBundle.getBundle("in.dauniv.resources.App");//	MySQL 8 driver will be loading
//private static final String uRL = "jdbc:mysql://localhost:3306/uwesh";
//private static final String id = "root";
//private static final String psw  = "root";
private static java.sql.Connection con = null;
//private static java.sql.Statement st  = null;


public static  java.sql.Connection connectivity(){
	try{
	Class c = Class.forName(rb.getString("driver"));	//STEP 1 : 	LOAD THE DRIVER

	con = java.sql.DriverManager.getConnection(rb.getString("url"),rb.getString("uid"),rb.getString("pwd"));		//STEP 2 : 	CONNECTION ESTABLISHMENT

		
	}
	catch(java.lang.ClassNotFoundException  cnfe){
	cnfe.printStackTrace();
	}
	catch(java.sql.SQLException  sqle){
	sqle.printStackTrace();
	}

return con;
}























}