package class2go;

import java.awt.CardLayout;

import class2go.gui.Class2Go;

public class Student extends UserRole{
	
	public Student(){
		setRoleTitle("Student");
	}
	
	public void addCourse(Course course, User user){
	}
	
	public void removeCourse(Course course, User user){
	}
	
	public void removeCourse(String title, User user){
	}
	
	public void getInterface(Class2Go app, CardLayout layout, User user){
		app.setStudent(user);
		layout.next(app.getContentPane());
	}
}
