package in.dauniv.connectivity;
import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public Validation() {
		
	}
	static Pattern p;
	static Matcher m;
	public static String validateName(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name : ");
		String name = sc.nextLine().trim();	//	name can be long
		/**nextLine() returns String , returns whole line until line changes or press enter or input of getting '\n'*/
		//	APPLYING REGEX
		String regex = "[a-zA-Z]+";	//	+ (Plus): Matches one or more occurrences 

		p = Pattern.compile(regex);	//	Compiles the given regular expression into a pattern.
		m = p.matcher(name);
		if(m.matches()) {
			return name;
		}
		else {
			System.err.println("Please enter valid input");
			validateName();
		}
		
	/*	
		for(int i=0;i<name.length(); i++) {
			char ch = name.toLowerCase().charAt(i);
			
			if((ch>=97 && ch<=122) ||(ch==32)) {
				return name;
			}
			else {
				System.err.println("Please enter the valid name!");
				validateName();

			}
			
		}
	*/
		
		return name;
	}
	
	public static String validateRollNo() {
		Scanner sc = new Scanner(System.in);
		/**  sc object has local scope coz declared inside the method*/
		String rollNo = sc.next().trim();
		/**Using next method to get the next token only!*/
		System.out.println("Enter your year of completion of course.for example 2025");
			String st = sc.next().trim();
			String regex = st.substring(2)+"IOT[0-9]{4}";
			p = Pattern.compile(regex);
			Matcher m = p.matcher(rollNo);
			if(m.matches()) {
				return rollNo;
			}
			else {
				System.err.println("wrong input! \n\tPlease enter roll no properly. Ex- 20IOT8018");
				validateRollNo();
			}
		/*
		int len = rollNo.trim().length();
		boolean flag=rollNo.regionMatches(0,"20IOT",0,5);
		if(!((flag) && (len==9))) {//		! NOT operator will make true value false and vice versa
			System.err.println("Please enter in proper format!");
			System.out.println("Please enter the roll number again!");
			validateRollNo();
		}
		*/
		return rollNo;
	}
	
	
	public static double validatePhysics() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the physics marks : ");
		double physics = 0.0;
		try {
		physics = sc.nextDouble();
		/**nextDouble() throws runtime or unchecked exception java.util.InputMismatchException */
		if(physics>=0 && physics<=100) {
				return physics;
		}
		else {
			System.err.println("Please enter the valid marks!");
			validatePhysics();
			/**calling static method directly without creating an object , static keyword has a class level resolution*/
		}
		}
		catch(java.util.InputMismatchException ime) {
			System.err.println("Please enter the valid marks!");
			validatePhysics();
		}
		
		return physics;
	}
	
	public static double validateChemistry() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the chemistry marks : ");
		double chem=0;
		try {
		chem = sc.nextDouble();
		if(chem>=0 && chem<=100) {
			return chem;
		}
		else {
			System.out.println("Please enter the valid marks!");
			validateChemistry();
		}
		}
		catch(java.util.InputMismatchException ime) {
			System.err.println("Please enter the valid marks!");
			validateChemistry();
		}
		
		return chem;
		
	}
	
	public static double validateMaths() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the maths marks : ");
		double maths=0;
		boolean flag = Pattern.matches("[0-9]{1,3}",maths+"");
		
		try {
		maths=sc.nextDouble();
		if(flag && maths>=0 && maths<=100) {
			return maths;
		}
		else {
			System.err.println("Please enter the valid marks!");
			validateMaths();
		}
		}
		catch(java.util.InputMismatchException ime) {
				System.err.println("Please enter the valid marks!");
		}
		// maths var will be overrided 
		return maths;
	}
	
	
	
	public static String validateGender() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your gender : ");
		
		String gen = sc.next();
		Pattern.matches("[a-zA-Z]{4,6}",gen);
		/**Using next() because , we only need single term or word*/
		if(gen.equalsIgnoreCase("Male") || gen.equalsIgnoreCase("Female")) {
				return gen;
		}
		else {
			System.err.println("Enter either Male or Female : ");
			validateGender();
		}
		return gen;
	}
	
	public static String validateEmail() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your mail id : ");
		String email = sc.next().trim();
		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z]+.[a-zA-Z]{2,}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(email);
		
		if(m.matches()) {
			return email;
		}
		else {
			System.err.println("Enter valid email");
			validateEmail();
		}
		
		/*
		int i=0;
		for (; i<email.length();i++) {
		char ch= email.charAt(i);
			if(ch=='@' && i!=0) {
				break;
			}
			else {
				System.err.println("Please enter valid Email!");
				validateEmail();
			}
		}
		
		if(email.regionMatches(i,"@gmail.com",0,10)) {
			return email;
		}
		else {
			System.err.println("Please enter valid Email!");
			validateEmail();
		}
		*/
		
		
		
		return email;
	}
	

	public static int validateOthers(int caseNumber) {
		Scanner sc = new Scanner(System.in);
		int num=0;
		
		try {
			System.out.print("Now enter 1 or 0 : ");
			num = sc.nextInt();
		 System.out.println(num);
		/**nextInt() throws java.util.InputMismatchException if value is other than int type*/
		if(num==1) {
			return num;		
		}
		else if(num==0) {
			return num;
		}
		}
		catch(java.util.InputMismatchException  ime) {
			System.err.println("Please Enter 1 and 0 only!");
			
			Validation.validateOthers(caseNumber);
		}
		
		return num;
	}

}
