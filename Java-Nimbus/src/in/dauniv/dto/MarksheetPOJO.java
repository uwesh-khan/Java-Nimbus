package in.dauniv.DTO;
public class LoginDTO {

private static String name = null;		//	public > protected > default > private or privacy
private static String rollNo = null;
private static double physics = 0.0;
private static double chemistry = 0.0;
private static double maths = 0.0;
private static String gender = null;
private static String email = null;



//	Corresponding Plain old java beans , data transfer object , accessor mutator

public static void setName(String name){

LoginDTO.name=name;
}

public static void setRollNo(String roll){
rollNo=roll;
}

public static void setPhysics(double physics){
LoginDTO.physics=physics;
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

email=mail;
}

public static String getName(){

return name;
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




}