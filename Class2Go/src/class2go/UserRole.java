package class2go;

import java.awt.CardLayout;
import java.util.ArrayList;

import class2go.gui.Class2Go;

public class UserRole {
	
	private String roleTitle;
	
	public UserRole(){
		setRoleTitle("");
	}
	
	public String getRoleTitle(){
		return roleTitle;
	}

	public void setRoleTitle(String roleTitle) {
		this.roleTitle = roleTitle;
	}
	
	public void addCourse(Course course, User user){
	}
	
	public void removeCourse(Course course, User user){
	}
	
	public void removeCourse(String title, User user){
	}

	public void setCourses(ArrayList<Course> courses, User user) {
	}
	
	public void getInterface(Class2Go app, CardLayout layout, User user){
		if (roleTitle.equals("Student")){
			app.setStudent(user);
			layout.next(app.getContentPane());
		} else {
			System.out.println("Instructor");
			app.setInstructor(user);
			layout.next(app.getContentPane());
			layout.next(app.getContentPane());
		}
	}

}
