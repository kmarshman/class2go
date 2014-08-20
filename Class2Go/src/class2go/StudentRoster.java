package class2go;

import java.util.ArrayList;

public class StudentRoster{
	
	private ArrayList<User> students = new ArrayList<User>();

	public StudentRoster(){
		
	}
	
	public void addStudent(User s){
		students.add(s);
	}
	
	public void removeStudent(User s){
		students.remove(s);
	}
	
	public void removeStudent(String first, String last){
		for (User s: students)
			if (s.getFirstName().equals(first) && s.getLastName().equals(last)) students.remove(s);
	}
	
	public User getStudent(String first, String last){
		for (User s: students)
			if (s.getFirstName().equals(first) && s.getLastName().equals(last)) return s;
		return null;
	}
	
	public ArrayList<User> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<User> students) {
		this.students = students;
	}

}
