package in.dauniv.model;
import in.dauniv.dto.MarksheetPOJO;
public interface University{	//	interface is also known as 100% class!


public boolean add();	//	by default abstract , public whether we are declaring or not
public boolean delete(java.lang.String rollNumber);
public boolean  update(java.lang.String  rollNumber);
public boolean  updateAll(MarksheetPOJO  m);
public boolean deleteAll();
public java.util.ArrayList get(java.lang.String  rollNumber);
//public java.util.Set getAll();
public java.util.List getAll();
public java.util.LinkedHashSet  getMeritList();
public int numberOfStudents();
public java.util.LinkedHashMap  getFailedStudentList();
public java.util.ArrayList getAbsenties();
public java.util.ArrayList getTopper();
public java.lang.String[]  getLowestMarkStudents();
public java.lang.String[]  getPassedStudents();
public double getAverageResultOfClass();
//public java.util.List getAllowedToKeepTermStudents();
public double getCutOff();
public int getNumberOfBoysPass();
public int getNumberOfGirlsPass();
public char [] getGradeOfStudent(java.lang.String  rollNumber);
public java.lang.String exit();

/**We have almost 75 lakh method in java */





}