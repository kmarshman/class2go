package class2go.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import class2go.Course;
import class2go.Student;
import class2go.User;
import class2go.curriculum.Curriculum;
import class2go.curriculum.Unit;

public class InstructorHomepage extends JPanel {

	private static final long serialVersionUID = 1L;
	private User instructor;
	private JTabbedPane courseTabs;
	private ArrayList<InstructorCoursePanel> courses;
	
	public InstructorHomepage() {
		
		courseTabs = new JTabbedPane();
		courseTabs.setFont(new Font("Arial", Font.BOLD, 14));
		courseTabs.setPreferredSize(new Dimension(975, 640));
		courseTabs.setMinimumSize(new Dimension(900, 600));
		add(courseTabs);

	}

	public User getInstructor() {
		return instructor;
	}

	public void setInstructor(User instructor) {
		this.instructor = instructor;
		
		///////////////////////////////////////
		instructor.getCourses().get(0).addStudent(new User("Bob", "Marley", new Student()));
		instructor.getCourses().get(0).addStudent(new User("Barbara", "Smith", new Student()));
		instructor.getCourses().get(0).addStudent(new User("Margaret", "Jones", new Student()));
		instructor.getCourses().get(0).addStudent(new User("Hailey", "Anderson", new Student()));
		instructor.getCourses().get(0).addStudent(new User("Bob", "Marley", new Student()));
		instructor.getCourses().get(0).addStudent(new User("Barbara", "Smith", new Student()));
		instructor.getCourses().get(0).addStudent(new User("Margaret", "Jones", new Student()));
		instructor.getCourses().get(0).addStudent(new User("Hailey", "Anderson", new Student()));
		instructor.getCourses().get(0).addStudent(new User("Bob", "Marley", new Student()));
		instructor.getCourses().get(0).addStudent(new User("Barbara", "Smith", new Student()));
		instructor.getCourses().get(0).addStudent(new User("Margaret", "Jones", new Student()));
		instructor.getCourses().get(0).addStudent(new User("Hailey", "Anderson", new Student()));
		instructor.getCourses().get(0).addStudent(new User("Bob", "Marley", new Student()));
		instructor.getCourses().get(0).addStudent(new User("Barbara", "Smith", new Student()));
		instructor.getCourses().get(0).addStudent(new User("Margaret", "Jones", new Student()));
		instructor.getCourses().get(0).addStudent(new User("Hailey", "Anderson", new Student()));
		
		ArrayList<Unit> units = new ArrayList<Unit>();
		units.add(new Unit("Real Numbers", 1));
		units.add(new Unit("Solving Equations", 2));	
		units.add(new Unit("Polynomials", 3));
		units.add(new Unit("Quadratics", 4));
		units.add(new Unit("Complex Fractions", 5));
		Curriculum curriculum = new Curriculum("Algebra", units);
		
		instructor.getCourses().get(0).setCurriculum(curriculum);
		///////////////////////////////////////
		
		courses = new ArrayList<InstructorCoursePanel>();
		int index = 0;
		for (Course c: instructor.getCourses()){
			courses.add(new InstructorCoursePanel(c));
			courseTabs.add(c.getTitle(), courses.get(index));
			index++;
		}
	}

}
