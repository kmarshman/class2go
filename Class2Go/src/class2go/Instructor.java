package class2go;

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
}