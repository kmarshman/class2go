package class2go.gui;

import java.awt.CardLayout;

import javax.swing.JPanel;

import class2go.Course;

public class InstructorCoursePanel extends JPanel {

	private static final long serialVersionUID = 998219864871163236L;
	private Course course;
	
	public InstructorCoursePanel(Course course){
		this.course = course;
		this.setLayout(new CardLayout());
		
		CourseDashboard dashboard = new CourseDashboard(course);
		add(dashboard, "Dashboard");
		
		StudentRosterPanel roster = new StudentRosterPanel(course);
		add(roster, "Roster");
	}
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}	
}
