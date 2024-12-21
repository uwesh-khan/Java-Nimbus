package in.dauniv.model;
import java.sql.Connection;

import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.dauniv.DTO.LoginDTO;
import in.dauniv.connectivity.GetConnection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;


public class UniversityImpl implements University {

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement st = null;
	private static double mark = 0;
	private static String value=null;
	private static int rowsAffected = 0; 
	private static String rollNo = null;
	
	
	@Override 
	public boolean  update(java.lang.String rollNo ){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 to update name : ");
		System.out.println("Enter 2 to update physics marks : ");
		System.out.println("Enter 3 to update chemistry marks : ");
		System.out.println("Enter 4 to update maths marks : ");
		System.out.println("Enter 5 to update gender : ");
		System.out.println("Enter 6 to update Email : ");
		int i = sc.nextInt();
		
		try {
		con = GetConnection.connectivity();		// S1,S2 : static method of GetConnection class , returns the object of connection interface
		
		
		switch(i) {
		case 1 :  System.out.println("Enter new name : "); 
				  LoginDTO.setName(sc.next());	//	S3
				  ps = con.prepareStatement("update marksheet set name=? where  rollNo=?");
				  ps.setString(1, LoginDTO.getName());
				  ps.setString(2,rollNo);
				  rowsAffected = ps.executeUpdate();
		case 2 : System.out.println("Enter new physics marks : ");
				mark = sc.nextDouble();
				ps = con.prepareStatement("update marksheet set physics=? where rollNo=? ");
				ps.setDouble(1, mark);
				ps.setString(2,rollNo);
				rowsAffected = ps.executeUpdate();
		case 3 : System.out.println("Enter new chemistry marks : ");
				mark = sc.nextDouble();
				ps = con.prepareStatement("update marksheet set chemistry=? where rollNo=?");
				ps.setDouble(1,mark);
				ps.setString(2, rollNo);
				rowsAffected = ps.executeUpdate();
		case 4 : System.out.println("Enter new Maths marks  : ");
				mark = sc.nextDouble();
				ps = con.prepareStatement("update marksheet set maths=? where rollNo=?");
				ps.setDouble(1,mark);
				ps.setString(2, rollNo);
				rowsAffected = ps.executeUpdate();
		case 5 : System.out.println("Enter new gender : ");
				 value = sc.next();
				ps = con.prepareStatement("update marksheet set gender=? where rollNo=?");
				ps.setString(1,value);
				ps.setString(2,rollNo);
				rowsAffected = ps.executeUpdate();
		case 6 : System.out.println("Enter new mail id  : ");
				value = sc.next();
				ps = con.prepareStatement("update marksheet set email=? where rollNo=?");
				ps.setString(1,value);
				ps.setString(2,rollNo);
				rowsAffected = ps.executeUpdate();
		}
		//String qry = String.format("insert into marksheet values('%s','%s',%d,%d,%d,'%s','%s')",m.getName() , m.getRollNo() , m.getPhysics() , m.getChemistry() , m.getMaths() ,m.getGender() ,m.getEmail());	// (String , object...)
		// '%s' for string value and %d for byte short int long values

		con.close();
		ps.close();
		}
		catch(SQLException sqle){
		sqle.printStackTrace();
		}
			
		return (rowsAffected<1)?false:true;
		}
	
		@Override
		public boolean updateAll(LoginDTO m) {
			Scanner sc = new Scanner(System.in);
			
			try {
			con = GetConnection.connectivity();
			
			ps =con.prepareStatement("update marksheet set name=? , physics=? , chemistry=?, maths=? , gender=? , Email=? where rollNo=?");
			ps.setString(1,m.getName());
			ps.setDouble(2,m.getPhysics());
			ps.setDouble(3,m.getChemistry());
			ps.setDouble(4,m.getMaths());
			ps.setString(5,m.getGender());
			ps.setString(6,m.getEmail());
			ps.setString(7,m.getRollNo());
			
			
			// JDBC S1 , S2 , S3 DONE
			/** INSTEAD OF USING createStatement() of Connection interface , we have used prepareStatement() of Connection interface returns the 
			 object of PreparedStatement implemented class 			**/
			//	S4
			
			rowsAffected = ps.executeUpdate();
			ps.close();
			con.close();
			 }
			catch(SQLException sqle) {
				sqle.printStackTrace();
			}
			
			return (rowsAffected<1)?false:true;	//	returns false if condition is true
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		@Override
		public boolean add(LoginDTO m){	//	m has the whole Marksheet class!

		try{
		con = GetConnection.connectivity();
		st=con.createStatement();
		
		
		java.lang.String qry = String.format("insert into Marksheet values('%s','%s',%f,%f,%f,'%s','%s')" , m.getName(),m.getRollNo(),m.getPhysics(),m.getChemistry(),m.getMaths(),m.getGender(),m.getEmail());
		/**	%f format specifier is used for double values and floating point value!		**/
		rowsAffected = st.executeUpdate(qry);	
		st.close();
		}
		catch(SQLException sqle){
		sqle.printStackTrace();
		}
	
		return (rowsAffected<0)?false:true;
		}

		@Override
		public java.util.ArrayList get(java.lang.String  rollNo){
			ArrayList al = new ArrayList();
		try {
		con = GetConnection.connectivity();
		st = con.createStatement();	//	We can also use prepareStatement instead of it

		ResultSet rs = st.executeQuery("Select * from Marksheet where rollNo="+rollNo);
		//	returns the object of ResulSet I implemented class
		
		while(rs.next()){
		al.add(rs.getString(1));
		al.add(rs.getString(2));
		al.add(rs.getDouble(3));
		al.add(rs.getDouble(4));
		al.add(rs.getDouble(5));
		al.add(rs.getString(6));
		al.add(rs.getString(7));
//				System.out.println()+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7));
		}
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		

		return al;
		}
		
		@Override
		public boolean delete(String rollNo) {
			try {
			con = GetConnection.connectivity();
			PreparedStatement ps = con.prepareStatement("delete from marksheet where rollNo=?");
			ps.setString(1,rollNo);
			rowsAffected = ps.executeUpdate();
			ps.close();
			con.close();
			}
			catch(SQLException sqle) {
				sqle.printStackTrace();
			}
			
		return (rowsAffected<1)?false:true;
		}
		
		@Override
		public boolean deleteAll() {
		
			try {
			con = GetConnection.connectivity();
			Statement st = con.createStatement();
			rowsAffected  = st.executeUpdate("delete from marksheet");
			st.close();
			con.close();
			}
			catch(SQLException sqle) {
				sqle.printStackTrace();
			}
			
			
			
			return (rowsAffected<1)?false:true;
			
		}

		@Override 
		public java.util.Set getAll(){
			Set s=null;
			try {
			s = new LinkedHashSet();
			con = GetConnection.connectivity();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from marksheet");
			//	rs will get the whole table and will point before first row!
			
			while(rs.next()) {
				s.add(rs.getString(1));	// Row 1 and column 1
				s.add(rs.getString(2));	//	Row 1 and column 2
				s.add(rs.getDouble(3));
				s.add(rs.getDouble(4));	/** Row will be changed when next() return boolean , it must be pointing the next one**/
				s.add(rs.getDouble(5));
				s.add(rs.getString(6));
				s.add(rs.getString(7)); //	Row 1 and column 7
			}
			}
			catch(SQLException sqle) {
				sqle.printStackTrace();
			}
			
			return s;	//	We can also return LinkedHashSet object instead of Set reference variable
		}
		
		@Override
		public java.util.LinkedHashSet getMeritList(){
			
			LinkedHashSet lhs = new LinkedHashSet();
			try{
			con = GetConnection.connectivity();
			//	instead of createStatement() we have used prepare statement
			 st = con.createStatement();	//	S3
			
			ResultSet rss = st.executeQuery("Select rollNo from marksheet");//	S4
			
			while(rss.next()) {
			rollNo = rss.getString(1);
			
		
			PreparedStatement ps = con.prepareStatement("Select name , physics , chemistry , maths from marksheet");
			ResultSet rs3 = ps.executeQuery();
			if((rs3.getDouble(2)>=50) && (rs3.getDouble(3)>=50) && (rs3.getDouble(4)>=50) ) {
			
			PreparedStatement ps2 =con.prepareStatement("select  sum(physics+chemistry+maths) from marksheet where rollNo=?");
			ps.setString(1, rollNo);
			ResultSet total = ps2.executeQuery();
				while(total.next()) {
					if(total.getDouble(1)>=150) {
						lhs.add(rs3.getString(1));
					}
				}
				}
			}
		
			}
			catch(SQLException sqle) {
					sqle.printStackTrace();
			}
			
			return lhs;
		}
		
		
		
		
		
	

}
