package class2go;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentBody implements Serializable{
	
	private static final long serialVersionUID = 3L;
	private ArrayList<Student> students = new ArrayList<Student>();
	
	public StudentBody(){
		
	}
	
	public void addStudent(Student s){
		students.add(s);
	}
	
	public void removeStudent(Student s){
		students.remove(s);
	}
	
	public void removeStudent(String first, String last){
		for (Student s: students)
			if (s.getFirstName().equals(first) && s.getLastName().equals(last)) students.remove(s);
	}
	
	public Student getStudent(String first, String last){
		for (Student s: students)
			if (s.getFirstName().equals(first) && s.getLastName().equals(last)) return s;
		return null;
	}

}
