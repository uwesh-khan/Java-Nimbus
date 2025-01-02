package in.dauniv.model;
import java.sql.Connection;




import java.util.Scanner;
import java.sql.PreparedStatement;
import in.dauniv.connectivity.GetConnection;
import java.sql.SQLException;
import in.dauniv.dto.MarksheetPOJO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.List;



public class UniversityImpl implements University {

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement st = null;
	private static double mark = 0;
	private static String value=null;
	private static int rowsAffected = 0; 
	private static String rollNo = null;
	
	static UniversityImpl ui = new UniversityImpl();
	//	java.lang.StackOverflow exception is raising coz of ui object
	
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
				  MarksheetPOJO.setStudentName(sc.next());	//	S3
				  ps = con.prepareStatement("update marksheet set name=? where  rollNo=?");
				  ps.setString(1, MarksheetPOJO.getStudentName());
				  ps.setString(2,rollNo);
				  rowsAffected = ps.executeUpdate();
		break;
		case 2 : System.out.println("Enter new physics marks : ");
				MarksheetPOJO.setPhysics(sc.nextDouble());
				ps = con.prepareStatement("update marksheet set physics=? where rollNo=? ");
				ps.setDouble(1, MarksheetPOJO.getPhysics());
				ps.setString(2,rollNo);
				rowsAffected = ps.executeUpdate();
		break;
		case 3 : System.out.println("Enter new chemistry marks : ");
				mark = sc.nextDouble();
				ps = con.prepareStatement("update marksheet set chemistry=? where rollNo=?");
				ps.setDouble(1,mark);
				ps.setString(2, rollNo);
				rowsAffected = ps.executeUpdate();
		break;
		case 4 : System.out.println("Enter new Maths marks  : ");
				mark = sc.nextDouble();
				ps = con.prepareStatement("update marksheet set maths=? where rollNo=?");
				ps.setDouble(1,mark);
				ps.setString(2, rollNo);
				rowsAffected = ps.executeUpdate();
		break;
		case 5 : System.out.println("Enter new gender : ");
				 value = sc.next();
				ps = con.prepareStatement("update marksheet set gender=? where rollNo=?");
				ps.setString(1,value);
				ps.setString(2,rollNo);
				rowsAffected = ps.executeUpdate();
		break;
		case 6 : System.out.println("Enter new mail id  : ");
				value = sc.next();
				ps = con.prepareStatement("update marksheet set email=? where rollNo=?");
				ps.setString(1,value);
				ps.setString(2,rollNo);
				rowsAffected = ps.executeUpdate();
		break;
		default : 
			System.out.println("Please enter the given number Only!");
			ui.update(rollNo);
			
		}
		
		
		//String qry = String.format("insert into marksheet values('%s','%s',%d,%d,%d,'%s','%s')",m.getName() , m.getRollNo() , m.getPhysics() , m.getChemistry() , m.getMaths() ,m.getGender() ,m.getEmail());	// (String , object...)
		// '%s' for string value and %d for byte short int long values

		con.close();
		ps.close();
		}
		catch(SQLException sqle){
		sqle.printStackTrace();
		}
			
		return (rowsAffected<0)?false:true;
		}
	
		@Override
		public boolean updateAll(MarksheetPOJO m) {
			
			Scanner sc = new Scanner(System.in);
			
			try {
			con = GetConnection.connectivity();
			
			ps =con.prepareStatement("update marksheet set name=? , physics=? , chemistry=?, maths=? , gender=? , Email=? where rollNo=?");
			ps.setString(1,m.getStudentName());
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
			
			return (rowsAffected<0)?false:true;	//	returns false if condition is true
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		@Override
		public boolean add(){	//	m has the whole Marksheet class!

		try{
		con = GetConnection.connectivity();
		st=con.createStatement();
		
		
		java.lang.String qry = String.format("insert into Marksheet values('%s','%s',%f,%f,%f,'%s','%s')" , MarksheetPOJO.getStudentName(),MarksheetPOJO.getRollNo(),MarksheetPOJO			.getPhysics(),MarksheetPOJO.getChemistry(),MarksheetPOJO.getMaths(),MarksheetPOJO.getGender(),MarksheetPOJO.getEmail());
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
			
			
			
			return (rowsAffected<0)?false:true;
			
		}

		@Override 
		public java.util.List getAll(){
			List s=null;
			try {
			s = new java.util.ArrayList();
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
			
			PreparedStatement ps = con.prepareStatement("Select name , physics , chemistry , maths , rollNo from marksheet");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if((rs.getDouble(2)>=50) && (rs.getDouble(3)>=50) && (rs.getDouble(4)>=50) ) {
			
					PreparedStatement ps2 =con.prepareStatement("select  sum(physics+chemistry+maths) from marksheet where rollNo=?");
					ps2.setString(1, rs.getString(5));
					ResultSet total = ps2.executeQuery();	
			/**Returns the object of ResultSet interface implemented class , object will point the data of DB accessed by the Query **/
			
				while(total.next()) {
					if(total.getDouble(1)>=150) {
						lhs.add(rs.getString(1)+" is in merit List roll number is : "+rs.getString(5));
					}
				}
				}
			
			}
			/** In LinkedHashSet insertion order is preserved but duplicate elemens are not allowed but , two more student 
			 can get same marks */
			}
			catch(SQLException sqle) {
					sqle.printStackTrace();
			}
			
			return lhs;
		}
		
		@Override 
		public int numberOfStudents()	{
			
			int no = 0;
			try {
			con = GetConnection.connectivity();//	S1 and S2 returns the object of connection interface
			st =con.createStatement(); // 	S3
			ResultSet rs = st.executeQuery("Select rollNo from marksheet");
			//	rs will point the whole rollNo list from DB
			
				while(rs.next()) {
					no++;
				}
			}
			catch(SQLException sqle) {
				sqle.printStackTrace();
			}
		
			return no;
		}
		
		@Override
		public java.util.LinkedHashMap getFailedStudentList(){
			
			LinkedHashMap lhm = new LinkedHashMap();
			try {
			con = GetConnection.connectivity();			
			PreparedStatement ps =con.prepareStatement("Select name ,physics , chemistry , maths , rollNo from marksheet");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if((rs.getDouble(2)<33) || (rs.getDouble(3)<33) || (rs.getDouble(4)<33)) {
				
					lhm.put(rs.getString(1),rs.getString(5)+" is failed");
				
				}
			}
			}
			catch(SQLException sqle) {
				sqle.printStackTrace();
			}
		return lhm;
		}
		
		@Override 
		public java.util.ArrayList getAbsenties(){
			ArrayList al = new ArrayList();
			 
			try {
			con = GetConnection.connectivity();
			st = con.createStatement();
			ResultSet rs = st.executeQuery("Select physics , chemistry , maths , name from marksheet");
			while(rs.next()) {
				if((rs.getDouble(1)==0) && (rs.getDouble(2)==0) && (rs.getDouble(3)==0)) {
					al.add(rs.getString(4)+" was absent!");
				}
			
			
			}
			}
			catch(SQLException sqle) {
				sqle.printStackTrace();
			}
			
			
			
			
			return al;
			
		}
		
		@Override
		public java.util.ArrayList getTopper(){
			ArrayList al = new ArrayList();
			
			/**Not using getMeritList() because it returns Name and RollNo , can't select Topper from it 	*/
			try {
			con = GetConnection.connectivity();
			PreparedStatement ps2 = con.prepareStatement("Select rollNo from Marksheet");
			ResultSet rs2 = ps2.executeQuery();
			PreparedStatement ps=null;
			while(rs2.next()) {
				System.out.println(rs2.getString(1));
				 ps =con.prepareStatement("Select sum(physics+chemistry+maths) from marksheet where rollNo=?");
				ps.setString(1,rs2.getString(1));
			}
		
			ResultSet rs = ps.executeQuery();
			
			int i=0;
			double t =0.0;
			while(rs.next()) {
				double mark = rs.getDouble(1);//	next() will point the next row from before first row!
				System.out.println(mark);
				if(i==0) {	
				t = mark;
				i++;
				}
				else {
				
					t = (mark>t)?mark:t;
				}
			}
			
			al.add(t);
			}
			catch(SQLException sqle) {
				
				sqle.printStackTrace();
			}
			
			
			
			
			
			return al;
			
				
		}
		
		@Override
		public java.lang.String[]  getLowestMarkStudents(){
			String str [] = null;
			try {
			con = GetConnection.connectivity();
			PreparedStatement ps = con.prepareStatement("Select rollNo from marksheet");
			ResultSet rs = ps.executeQuery();

			PreparedStatement ps1  =con.prepareStatement("Select  physics , chemistry , maths from marksheet where rollNo=?");
			int count=0;
			while(rs.next()) {
			count++;
			ps1.setString(1,rs.getString(1));	//	Pointing row number 1 by rs
			}
			ResultSet rs2 = ps1.executeQuery();//S4
				
			str = new String[count];
			int i=0;
			while(rs2.next()) {
				 	if((rs2.getDouble(1)>=33 && rs.getDouble(1)<=40) &&  (rs2.getDouble(2)>=33 && rs2.getDouble(2)<=40)  && (rs2.getDouble(3)>=33 && rs2.getDouble(3)>=40)) {
				 		while(rs.next()) {
				 			str[i] = "Roll number "+rs.getString(1)+"has the lowest mark";
				 			i++;
				 		}
				 		
				 	}
					
				}
			}
			catch(SQLException sqle) {
					sqle.printStackTrace();
			}
			
			
			
			
			return  str;
		}
		@Override
		public java.lang.String[] getPassedStudents(){
			int num=1;
			String str[]= null;
			
			try {
			con = GetConnection.connectivity();
//			PreparedStatement ps =con.prepareStatement("Select  count(physics>33 And chemistry>33 And maths>33 And rollNo) from marksheet ");
//			THE ABOVE QUERY WILL ONLY RETURN THE WHOLE COLUMN BUT conditionS WON'T BE APPLIED 
			PreparedStatement ps = con.prepareStatement("Select physics , chemistry , maths , rollNo from marksheet");
			PreparedStatement ps2 = con.prepareStatement("Select count(*) from marksheet");// Total Students (No of rows)
			ResultSet rs = ps.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
			str = new String[rs2.getInt(1)];
			
			int i=0;
			while(rs.next()) {
				  
				
					if(rs.getDouble(1)>=33 && rs.getDouble(2)>=33 && rs.getDouble(3)>=33) {
					str[i]= "Roll number "+rs.getString(4)+" is passed! ";
//					System.out.println(str.length);
					num++;
					
					i++;
//					System.out.println(str.getClass().getName()+"$"+hashCode());
				}
				
			}
			}
			catch(SQLException sqle) {
				sqle.printStackTrace();
			}
			
			
			return str;
		}
	
		@Override
		public double getAverageResultOfClass() {
			
			double average = 0;
			try {
			con = GetConnection.connectivity();
//			PreparedStatement ps = con.prepareStatement("Select sum(physics+chemistry+maths) from marksheet");// Returns whole sum
//			PreparedStatement ps2 = con.prepareStatement("Select count(rollNo) from marksheet");// rollNo is primary key
			//					Returns the number of Rows of tables of MySQL
			PreparedStatement ps = con.prepareStatement("Select avg(physics+chemistry+maths) from marksheet");
			// THIS QUERY WILL RETURN THE AVERAGE RESULT OF A CLASS DIRECTLY
			
			ResultSet rs = ps.executeQuery();	// returns the object of resultset interface 
//			ResultSet rs2 = ps2.executeQuery();
			
			if(rs.next()) {
					// rs and rs2 will point their first row
				average = rs.getDouble(1); // Returns the total sum of marks of all the students
				// Average of the class where 300 marks of each student was total
//				average =(average/(rs2.getInt(1))); // total marks divided by the total no of students
				//	rs2 is pointing to before first row! , if you call method it will through SQLException
			}
			}
			catch(SQLException sqle) {
				sqle.printStackTrace();
			}
			
			return average;
		}
		@Override 
		public int getNumberOfBoysPass(){
			
			int pass=0;
			try {
			con = GetConnection.connectivity();
			PreparedStatement ps = con.prepareStatement("Select count(Gender) from marksheet where gender='male' And physics>=33 And chemistry>=33 And maths>=33");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				pass = rs.getInt(1);// ResultSet will point the only single row
			}
			
			}
			catch(SQLException sqle) {
				sqle.printStackTrace();
				
			}
			
			return pass;
		}
		
		@Override
		public int getNumberOfGirlsPass() {
			int pass=0;
			try {
			con = GetConnection.connectivity();
			PreparedStatement ps =con.prepareStatement("Select count(Gender) from marksheet where gender='female' And physics>=33 And chemistry>=33 And maths>=33");
				//	Query returns int type value ie., count of gender
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				pass=rs.getInt(1);
			}
			}
			catch(SQLException sqle) {
				sqle.printStackTrace();
			}
			
			return pass;
		}
		
		@Override
		public char [] getGradeOfStudent(java.lang.String rollNumber) {
			
			char[] grade = new char[3];
			
			try {
			con = GetConnection.connectivity();
			PreparedStatement ps = con.prepareStatement("Select physics , chemistry , maths  from marksheet where rollNo=?");
			ps.setString(1, rollNumber);
			ResultSet rs = ps.executeQuery();
			
			for(int i=0; i<grade.length; i++) {
						
				if(rs.getDouble(1)>32 && rs.getDouble(2)>32 && rs.getDouble(3)>32) {
							
							double sum = rs.getDouble(i+1);
							
							if(90<= sum) {
								grade[i]='O';
							}
							else if(80<= sum && sum <=89 ) {
								grade[i]= 'A';
								/**We can also concatenate character literal using concatenation operator but it will add their
								 ASCII values!*/
							}
							else if(70<= sum && sum>=79) {
								grade[i] = 'B';
							}	
							else if(60<=sum && sum <=69) {
								grade[i]='C';
							}
							else if(50<=sum && sum<=59) {
								grade[i]='D';
							}		
							else if(40<=sum && sum<=49) {
								grade[i] ='E';
							}
							else if(33<=sum && sum<=39) {
								grade[i]='P';
							}
				
				}
				else {
					grade[i]='F';
				}
				
			}
				
			
			}
			catch(SQLException sqle) {
				sqle.printStackTrace();
			}
			
			
			
			return grade;
		}
		
			
		@Override
		public double getCutOff() {
			return 33.0;
		}
		
		@Override
		public java.lang.String exit() {
			
				return "End with exit code 0 ";
					
		}
		
		
		
		
		
}
