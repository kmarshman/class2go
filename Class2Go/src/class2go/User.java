package class2go;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Observable;

import class2go.gui.Class2Go;

public class User extends Observable{
	
	private String firstName;
	private String lastName;
	private int id;
	private ArrayList<Course> courses = new ArrayList<Course>();
	private UserRole role;
	
	public User(){
		super();
		firstName = "";
		lastName = "";
		role = null;
	}
	
	public User(String firstName, String lastName, UserRole role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	public void addCourse(Course course){
		role.addCourse(course, this);
		setChanged();
		notifyObservers(this);
	}
	
	public void removeCourse(Course course){
		role.removeCourse(course, this);
		setChanged();
		notifyObservers(this);
	}
	
	public void removeCourse(String title){
		role.removeCourse(title, this);
		setChanged();
		notifyObservers(this);
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
		setChanged();
		notifyObservers(this);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		setChanged();
		notifyObservers(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		setChanged();
		notifyObservers(this);
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
		setChanged();
		notifyObservers(this);
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
		setChanged();
		notifyObservers(this);
	}
	
	public void getInterface(Class2Go app, CardLayout layout){
		System.out.println("User get interface");
		role.getInterface(app, layout, this);
	}
}
