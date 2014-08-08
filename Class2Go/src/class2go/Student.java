package class2go;

import java.io.Serializable;
import java.util.ArrayList;

//Test Comment
public class Student implements Serializable{
	
	private static final long serialVersionUID = 5L;
	private String firstName;
	private String lastName;
	private int id;
	private ArrayList<Course> courses = new ArrayList<Course>();
	
	public Student(){
		firstName = "";
		lastName = "";
		id = -1;
	}
	
	public Student(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		id = -1;
	}
	
	public void addCourse(Course course){
		courses.add(course);
	}
	
	public void removeCourse(Course course){
		courses.remove(course);
	}
	
	public void removeCourse(String title){
		for (Course c: courses)
			if (c.getTitle().equals(title)) courses.remove(c);
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

}
