package in.dauniv.model;	//	package declaration
import in.dauniv.dto.MarksheetPOJO;



import java.util.Scanner;
import in.dauniv.connectivity.GetConnection;
import in.dauniv.connectivity.Validation;


public class TestMain {
		
		public static int  option() {
		
			
		
			Scanner sc = new Scanner(System.in);
			System.out.println("Press 1 to add : ");
			System.out.println("Press 2 to update : ");
			System.out.println("Press 3 to delete : ");
			System.out.println("Press 4 to delete all the data : ");
			System.out.println("Press 5 to get specific data : ");
			System.out.println("Press 6 to get all the data : ");
			System.out.println("Press 7 to update all : ");
			System.out.println("Press 8 to get Merit List : ");
			System.out.println("Press 9 to get number of students in the marksheet : ");
			System.out.println("Press 10 to get failed students in the marksheet : ");
			System.out.println("Press 11 to get absenties : ");
			System.out.println("Press 12 to get the Topper of the class: ");
			System.out.println("Press 13 to get the lowest mark : ");
			System.out.println("Press 14 to get the passed students  : ");
			System.out.println("Press 15 to the average of marks : ");
			System.out.println("Press 16 to get the cut off/passing  marks : ");
			System.out.println("Press 17 to get number of boys passed : ");
			System.out.println("Press 18 to get number of girls passed : ");
			System.out.println("Press 19 to get your grade : ");
			System.out.println("Press 20 to exit from app : ");
		
		
		// it will take value from console and send it to java program via stream!
			
			return con(sc.nextInt());
			
	} 
	
		
		
		public static int con(int caseNumber) {
			java.util.Scanner sc = new java.util.Scanner(System.in);
			
			String rollNo=null;
			double physics = 0.0;
			double chemistry = 0.0;
			double maths = 0.0;
			String gender = null;
			String email = null;
			MarksheetPOJO m = new MarksheetPOJO();
			UniversityImpl ui = new UniversityImpl();
			// get returns the int val of option();
			String  hold=null;
			int ind=2;
			/**It is mandatory to initialize local variable*/
			
			switch(caseNumber){
			case 1 :
				String name = Validation.validateName();
				MarksheetPOJO.setStudentName(name);

				rollNo = Validation.validateRollNo();
				MarksheetPOJO.setRollNo(rollNo);

				physics = Validation.validatePhysics();
				MarksheetPOJO.setPhysics(physics);

				chemistry = Validation.validateChemistry();
				MarksheetPOJO.setChemistry(chemistry);

				maths = Validation.validateMaths();
				MarksheetPOJO.setMaths(maths);

				gender=Validation.validateGender();
				MarksheetPOJO.setGender(gender);

				email=Validation.validateEmail();
				MarksheetPOJO.setEmail(email);
				
				if(ui.add()) {
					System.out.println("Successfully added!");
					System.out.println("_______________________________________________________");
					System.out.println("Press 1 to add more! and 0 to continue : ");
					hold = sc.next();
					ind = hold.lastIndexOf(hold);
					if(ind==1) {
						con(1);
					}
					else if(ind==0) {
						option();
					}
					
					
				}
				else {
					System.out.println("Failed addition!");
					System.out.println("_______________________________________________________");
					System.out.println("Press 1 to  add more! and 0 to continue : ");
					hold = sc.next();
					ind = hold.lastIndexOf(hold);
					if(ind==1) {
						con(1);
					}
					else if(ind==0) {
						option();
					}
				}
				
				
			break;
			case 2 : 
					System.out.println("University roll number can't be updated");
					System.out.println("Enter the roll number where you want to update!");
				
					rollNo = Validation.validateRollNo();
					if(ui.update(rollNo)) {
						System.out.println("Updated Successfully!");
						System.out.println("Do you want to update again , Press 1 for yes and 0 for continue!");
						String num= sc.next();
						ind=num.lastIndexOf(num);
						if(ind==1) {
							con(2);
						}
						else if(ind==0) {
							option();
						}
					}
					else {
						System.out.println("Failed updation!");
						System.out.println("_______________________________________________________");
						System.out.println("Do you want to update again , Press 1 for yes and 0 for continue!");
						String num= sc.next();
						ind=num.lastIndexOf(num);
						if(ind==1) {
							con(2);
						}
						else if(ind==0) {
							option();
						}
					}	
			break;
			case 3 : 
					System.out.println("Enter  the roll number to delete data ");
					rollNo = Validation.validateRollNo();
					
					if(ui.delete(rollNo)){
						System.out.println("Deleted successfully");
						System.out.println("_______________________________________________________");
						System.out.println("Do you want to delete again , Press 1 for yes and 0 for continue!");
						String num= sc.next();
						ind=num.lastIndexOf(num);
						if(ind==1) {
							con(3);
						}
						else if(ind==0) {
							option();
						}
					}
					else {
						System.out.println("failed Deletion");
						System.out.println("_______________________________________________________");
						System.out.println("Do you want to delete again , Press 1 for yes and 0 for continue!");
						String num= sc.next();
						ind=num.lastIndexOf(num);
						if(ind==1) {
							con(3);
						}
						else if(ind==0) {
							option();
						}
					}
			break;
			case 4 :
				  	 if(ui.deleteAll()) {
				  		 System.out.println("Database cleared!");
				  		 option();
				  	 }
				  	 else {
				  		 System.out.println("Failed deletion!");
				  		System.out.println("_______________________________________________________");
						System.out.println("Do you want to delete again , Press 1 for yes and 0 for continue!");
						String num= sc.next();
						ind=num.lastIndexOf(num);
						if(ind==1) {
							con(4);
						}
						else if(ind==0) {
							option();
						}
				  	 }
			break;
			case 5 : 
					System.out.println("Enter the roll no to get data : ");
					rollNo = Validation.validateRollNo();
					System.out.println(ui.get(rollNo));
					System.out.println("_______________________________________________________");
					System.out.println("Do you want to get data again , Press 1 for yes and 0 for continue!");
					String num= sc.next();
					ind=num.lastIndexOf(num);
					if(ind==1) {
						con(5);
					}
					else if(ind==0) {
						option();
					}
					
			break;
			case 6 :
					int ii=1;
					java.util.List s = ui.getAll();
					/** Returning child class object NOT implemented class object	**/
					java.util.Iterator point = s.iterator();	
					//	method return the object of Iterator interface, can point via cursor to all the Collection
					while(point.hasNext()) {
						System.out.print(point.next()+"\t\t");
							if(ii==7) {
								ii=0;
								System.out.println();
								
							}
						ii++;
					}
					System.out.println("_______________________________________________________");
					System.out.println("Do you want to fetch data again , Press 1 for yes and 0 for continue!");
					
					
					ind = Validation.validateOthers(6);
					System.out.println(ind);
					if(ind==1) {
						con(6);
					}
					else if(ind==0) {
						option();
					}
			break;
					
			case 7 : System.out.println("Note : YOU  CAN'T UPDATE ROLL NUMBER!");
					 System.out.println("Enter the roll number where you want to update : ");
					 rollNo = Validation.validateRollNo();
					 MarksheetPOJO.setRollNo(rollNo);
					 
					System.out.println("Enter the new name");
					MarksheetPOJO.setStudentName(sc.next());
					System.out.println("Enter the new physics marks : ");
					MarksheetPOJO.setPhysics(sc.nextDouble());
					System.out.println("Enter the new chemistry marks : ");
					MarksheetPOJO.setChemistry(sc.nextDouble());
					System.out.println("Enter the new maths marks : ");
					MarksheetPOJO.setMaths(sc.nextDouble());
					System.out.println("Enter the new gender : ");
					MarksheetPOJO.setGender(sc.next());
					System.out.println("Enter the new Email : ");
					MarksheetPOJO.setEmail(sc.next());

					if(ui.updateAll(m)) {
						System.out.println("Successfully updated! ");
						System.out.println("_______________________________________________________");
						System.out.println("Press 1 to update more! and 0 to continue : ");
						hold = sc.next();
						ind = hold.lastIndexOf(hold);
						if(ind==1) {
							con(7);
						}
						else if(ind==0) {
							option();
						}
						
						
					}
					else {
						System.out.println("Failed updation!");
						System.out.println("_______________________________________________________");
						System.out.println("Press 1 to update more! and 0 to continue : ");
						hold = sc.next();
						ind = hold.lastIndexOf(hold);
						if(ind==1) {
							con(7);
						}
						else if(ind==0) {
							option();
						}
					}
					
			break;

			case 8 :
						java.util.HashSet hs = ui.getMeritList();	//	Returns the object of LinkedHashSet
						java.util.Iterator cur = hs.iterator();
						while(cur.hasNext()) {
							System.out.println(cur.next());
						}
						System.out.println("Press 1 to get merit list again! and 0 to continue : ");
						hold = sc.next();
						ind = hold.lastIndexOf(hold);
						if(ind==1) {
							con(8);
						}
						else if(ind==0) {
							option();
						}
						
				break;
				
			case 9 :
						System.out.println("We have "+ui.numberOfStudents()+" students");
						System.out.println("Press 1 to get data again more! and 0 to continue : ");
						hold = sc.next();
						ind = hold.lastIndexOf(hold);
						if(ind==1) {
							con(9);
						}
						else if(ind==0) {
							option();
						}
						
			break;
			case 10: 
						System.out.println(ui.getFailedStudentList());
						/** Iterator interface cannot iterate Map and its child*/
						System.out.println("Press 1 to get data again! and 0 to continue : ");
						hold = sc.next();
						ind = hold.lastIndexOf(hold);
						if(ind==1) {
							con(10);
						}
						else if(ind==0) {
							option();
						}
						
						
			break;
			case 11 : 
						java.util.List l =ui.getAbsenties();
						java.util.Iterator ar = l.iterator();
						while(ar.hasNext()) {
							System.out.println(ar.next());
						}
						System.out.println("Press 1 to get data again! and 0 to continue : ");
						hold = sc.next();
						ind = hold.lastIndexOf(hold);
						if(ind==1) {
							con(11);
						}
						else if(ind==0) {
							option();
						}
						
			break;
			
			case 12 : 
						System.out.println("The topper of the class is : "+ui.getTopper());	
						System.out.println("Press 1 to get data again! and 0 to continue : ");
						hold = sc.next();
						ind = hold.lastIndexOf(hold);
						if(ind==1) {
							con(12);
						}
						else if(ind==0) {
							option();
						}
						System.out.println("Press 1 to get data again! and 0 to continue : ");
						hold = sc.next();
						ind = hold.lastIndexOf(hold);
						if(ind==1) {
							con(12);
						}
						else if(ind==0) {
							option();
						}
						
						
			break;
			case 13 : 
						String arr [] = ui.getLowestMarkStudents();
						for(String var : arr) {
							if(var.isEmpty()) {
								System.out.println("No student found of low mark!");
							}
													System.out.println(var);
							/** toString() of Object class will be called every time when we call println() of PrintStream class to print hashCode but 
							 String class was overrided the toString and print the String instead of hashcode! */
						}
						System.out.println("Press 1 to get data! and 0 to continue : ");
						hold = sc.next();
						ind = hold.lastIndexOf(hold);
						if(ind==1) {
							con(13);
						}
						else if(ind==0) {
							option();
						}
						
			break;
			case 14 : 
						String itr [] = ui.getPassedStudents();
						//Iterating array via for each loop , fail fast
						for(String str : itr) {
							if(str!=null) {
								System.out.println(str);
							}
						}
						System.out.println("Press 1 to get data again! and 0 to continue : ");
						hold = sc.next();
						ind = hold.lastIndexOf(hold);
						if(ind==1) {
							con(14);
						}
						else if(ind==0) {
							option();
						}
						
			case 15 : System.out.println(ui.getAverageResultOfClass()+"% is the average result of class!");
						
					System.out.println("Press 1 to update more! and 0 to continue : ");
					hold = sc.next();
					ind = hold.lastIndexOf(hold);
					if(ind==1) {
						con(7);
					}
					else if(ind==0) {
						option();
					}
			
			break;		
			
			case 16 : System.out.println("Cut off is : "+ui.getCutOff());
			
						System.out.println("Press 1 to update more! and 0 to continue : ");
							hold = sc.next();
							ind = hold.lastIndexOf(hold);
							if(ind==1) {
								con(7);
							}
							else if(ind==0) {
								option();
							}
			
			break;

			case 17 :		int pass = ui.getNumberOfBoysPass();
				 		 System.out.println((pass>1)?pass+" boys have passed!":pass+" boy has passed!");
				 		System.out.println("Press 1 to get data again! and 0 to continue : ");
						hold = sc.next();
						ind = hold.lastIndexOf(hold);
						if(ind==1) {
							con(17);
						}
						else if(ind==0) {
							option();
						}
						
				 		 
			break;
			case 18 :   int pass2 = ui.getNumberOfGirlsPass();
						System.out.println((pass2>1)?pass2+" girls have passed!":pass2+" girl has passed!");
						System.out.println("Press 1 to get data again! and 0 to continue : ");
						hold = sc.next();
						ind = hold.lastIndexOf(hold);
						if(ind==1) {
							con(18);
						}
						else if(ind==0) {
							option();
						}
						
			break;
					
			case 19 : 	
							char[] grade = ui.getGradeOfStudent(MarksheetPOJO.getRollNo());
//							if(grade[]=='x') {
//								System.out.println("Not exist!");
//							}
//							else {
//								if(grade=='l') {
//									 System.out.println("You got grade : A+");
//									
//								}
//								else if(grade=='m') {
//									System.out.println("You got grade : B+");
//								}
//								else {
//								System.out.println("You got grade : "+grade);
//								}
//							}
							
							
			case 20 : 	System.out.println("Are you sure! press Y for yes / N for no : ");
						String chh= sc.next().trim();
						/**We don't have nextChar() in Scanner class that's why we are using next()*/
						if(chh.equalsIgnoreCase("Y")) {
							System.out.println(ui.exit());
						}
						else {
							System.err.println("Please enter Y/N only : ");
							con(20);
						}
						
						
			break;
			default : System.out.println("Please enter valid number!");
			
			}
		return 0;

		}
	
	
	public static void main(String[] args){

		java.util.Scanner sc = new java.util.Scanner(System.in);	
		//	open logical stream form console to java program , does not have no argument constructor
			int i=option();
				
	}
	
}