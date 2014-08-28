package class2go;

import java.util.ArrayList;

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

}
