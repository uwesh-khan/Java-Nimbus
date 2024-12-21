package in.dauniv.model;
import in.dauniv.DTO.LoginDTO;
public interface University{	//	interface is also known as 100% class!


public boolean add(LoginDTO  m);	//	by default abstract , public whether we are declaring or not
public boolean delete(java.lang.String str);
public boolean  update(java.lang.String  str);
public boolean  updateAll(LoginDTO  m);
public boolean deleteAll();
public java.util.ArrayList get(java.lang.String  str);
public java.util.Set getAll();
public java.util.LinkedHashSet  getMeritList();
//public int numberOfStudents();
//public java.util.LinkedHashMap  getFailedStudentList();
//public java.util.ArrayList getAbsenties();
//public java.util.ArrayList getTopper();
//public java.lang.String[]  getLowestMarkStudents();
//public java.lang.String[]  getPassedStudents();
//public double getAverageResultOfClass();
//public java.util.List getAllowedToKeepTermStudents();
//public double getCutOffMethod();
//public int getNumberOfBoysPass();
//public int getNumberOfGirlsPass();
//public char getGradesOfStudent(java.lang.String  str);











}