package in.dauniv.model;
import in.dauniv.DTO.LoginDTO;
import in.dauniv.connectivity.GetConnection;

import java.util.Scanner;


public class TestMain {

	public static void main(String[] args){

//			WITHOUT CREATING AN OBJECT

		java.util.Scanner sc = new java.util.Scanner(System.in);	//	open logical stream form console to java program , does not have no argument constructor

		System.out.println("Press 1 to add : ");
		System.out.println("Press 2 to update : ");
		System.out.println("Press 3 to delete : ");
		System.out.println("Press 4 to delete all the data : ");
		System.out.println("Press 5 to get specific data : ");
		System.out.println("Press 6 to get all the data : ");
		System.out.println("Press 7 to update all : ");
		
		int i = sc.nextInt();
		String rollNo=null;
		LoginDTO  m = new LoginDTO();
		UniversityImpl ui = new UniversityImpl();
		
		switch(i){
		case 1 :
			System.out.println("Enter name : ");
			LoginDTO.setName(sc.next().trim());

			System.out.println("Enter rollNo : ");
			LoginDTO.setRollNo(sc.next().trim());

			System.out.println("Enter physics marks : ");
			LoginDTO.setPhysics(sc.nextDouble());

			System.out.println("Enter chemistry marks  : ");
			LoginDTO.setChemistry(sc.nextDouble());

			System.out.println("Enter maths marks : ");
			LoginDTO.setMaths(sc.nextDouble());

			System.out.println("Enter gender : ");
			LoginDTO.setGender(sc.next().trim());

			System.out.println("Enter email id : ");
			LoginDTO.setEmail(sc.next().trim());
			
			if(ui.add(m)) {
				System.out.println("Successfully added!");
			}
			else {
				System.out.println("Failed addition");
			}
		break;
		case 2 : 
				System.out.println("University roll number can't be updated");
				System.out.println("Enter roll number where you want to update : ");
				rollNo = sc.next();
			
				if(ui.update(rollNo)) {
					System.out.println("Update Successfully!");
				}
				else {
					System.out.println("Failed updation!");
				}	
		break;
		case 3 : 
				System.out.println("Enter  the roll number to delete data ");
				rollNo = sc.next();
				if(ui.delete(rollNo)){
					System.out.println("Deleted successfully");
				}
				else {
					System.out.println("failed Deletion");
				}
		break;
		case 4 :
			  	 if(ui.deleteAll()) {
			  		 System.out.println("Database cleared!");
			  	 }
			  	 else {
			  		 System.out.println("Failed deletion!");
			  	 }
		break;
		case 5 : 
				System.out.println("Enter the roll no to get data : ");
				System.out.println(ui.get(sc.next()));
				
		break;
		case 6 :
				int ii=0;
				java.util.Set s = ui.getAll();
				/** Returning child class object NOT implemented class object	**/
				java.util.Iterator point = s.iterator();	
				//	method return the object of Iterator interface, can point via cursor to all the Collection
				while(point.hasNext()) {
					System.out.print(point.next()+"\t\t");
						if(ii==7) {
							ii=1;
							System.out.println();
						
						}
					i++;
				}
		break;
				
		case 7 : System.out.println("Warning : YOU  CAN'T UPDATE ROLL NUMBER!");
				 System.out.println("Enter the roll number where you want to update : ");
				 LoginDTO.setRollNo(sc.next());
				 
				System.out.println("Enter the new name");
				LoginDTO.setName(sc.next());
				System.out.println("Enter the new physics marks : ");
				LoginDTO.setPhysics(sc.nextDouble());
				System.out.println("Enter the new chemistry marks : ");
				LoginDTO.setChemistry(sc.nextDouble());
				System.out.println("Enter the new maths marks : ");
				LoginDTO.setMaths(sc.nextDouble());
				System.out.println("Enter the new gender : ");
				LoginDTO.setGender(sc.next());
				System.out.println("Enter the new Email : ");
				LoginDTO.setEmail(sc.next());

				if(ui.updateAll(m)) {
					System.out.println("Successfully updated! ");
				}
				else {
					System.out.println("Failed updation!");
				}
				
				
				
			break;

		}






		}
		}


