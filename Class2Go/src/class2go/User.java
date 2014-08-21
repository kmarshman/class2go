package class2go;

import grading.Report;

import java.util.ArrayList;

public class User {
	
	private String firstName;
	private String lastName;
	private int id;
	private ArrayList<Course> courses = new ArrayList<Course>();
	private UserRole role;
	
	public User(String firstName, String lastName, UserRole role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
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

	public Report getGrades(int courseID){
		return role.getGrades(this, courseID);
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

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
}
