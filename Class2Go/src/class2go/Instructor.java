package class2go;

import java.awt.CardLayout;

import class2go.gui.Class2Go;

public class Instructor extends UserRole{
	
	public Instructor(){
		setRoleTitle("Instructor");
	}
	
	public void addCourse(Course course, User user){
		user.getCourses().add(course);
	}
	
	public void removeCourse(Course course, User user){
		user.getCourses().remove(course);
	}
	
	public void removeCourse(String title, User user){
		for (Course c: user.getCourses())
			if (c.getTitle().equals(title)) user.getCourses().remove(c);
	}
	
	public void getInterface(Class2Go app, CardLayout layout, User user){
		System.out.println("Getting interface");
		app.setInstructor(user);
		layout.next(app.getContentPane());
		layout.next(app.getContentPane());
	}
}