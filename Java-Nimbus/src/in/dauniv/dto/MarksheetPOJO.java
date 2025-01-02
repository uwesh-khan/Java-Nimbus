package in.dauniv.dto;
public class MarksheetPOJO {

//	public > protected > default > private or privacy
private static String rollNo = null;
private static double physics = 0.0;
private static double chemistry = 0.0;
private static double maths = 0.0;
private static String gender = null;
private static String email = null;
private static String adminName = null;
private static String adminPassword = null;
private static String studentName = null;
private static String studentPassword = null;

//	Corresponding Plain old java beans , data transfer object , accessor mutator


public static void setRollNo(String roll){
rollNo=roll;
}

public static void setPhysics(double physics){
MarksheetPOJO.physics=physics;
}

public static void setChemistry(double chem){

chemistry=chem;
}

public static void setMaths(double math){
maths=math;
}

public static void setGender(String gen){
gender = gen;
}

public static void setEmail(String mail){
	//this is not allowed ,its an static method

email=mail;
}

public static void setAdminName(String adminName1) {
adminName=adminName1;
}

public static void setAdminPassword(String adminPassword1) {
adminPassword = adminPassword1;
}

public static void setStudentName(String studentName1) {
studentName = studentName1;
}

public static void setStudentPassword(String studentPassword1) {
studentPassword = studentPassword1;
}


public static String getRollNo(){

return rollNo;
}

public static double getPhysics(){

return physics;
}

public static double getChemistry(){
return chemistry;
}

public static double getMaths(){

return maths;
}

public static String getGender(){
return gender;
}

public static String getEmail(){
return email;
}

public static String getAdminName() {
	return adminName;
}

public static String getAdminPassword() {
	return adminPassword;
}

public static String getStudentName() {
	return studentName;
}

public static String getStudentPassword() {
	return studentPassword;
}



}