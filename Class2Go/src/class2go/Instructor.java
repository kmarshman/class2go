package class2go;

import java.io.Serializable;
import java.util.ArrayList;

public class Instructor implements Serializable{
	
	private static final long serialVersionUID = 12L;
	private String firstName;
	private String lastName;
	private int id;
	private ArrayList<Course> courses = new ArrayList<Course>();
	
	public Instructor(){
		firstName = "";
		lastName = "";
		id = -1;
	}
	
	public Instructor(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		id = -1;
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
