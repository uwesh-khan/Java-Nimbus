package in.dauniv.model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import in.dauniv.connectivity.GetConnection;
import in.dauniv.dto.MarksheetPOJO;

public class StudentLoginModel {
//	Authenticate the email id and password with the database of student
	
private ResourceBundle rb = ResourceBundle.getBundle("in.dauniv.resources.App");
	
	public boolean verify() {
		Connection con = GetConnection.connectivity();
		try {
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select name , password from AdminDB");
		
		while(rs.next()) {	//	returns boolean value if it contains the first row
			String name = rs.getString(1);
			String password = rs.getString(2);
			//	== checks reference in case of String
			if(MarksheetPOJO.getAdminName().equals(name) && MarksheetPOJO.getAdminPassword().equals(password)) {
				return true;
			}
		}
		
		}
		catch(SQLException sqle) {
			System.out.println("Database Error!");
		}	
			
		
		return false;
	}
	
}
