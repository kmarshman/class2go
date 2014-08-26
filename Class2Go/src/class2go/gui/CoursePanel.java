package class2go.gui;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import assignment.Assignment;
import class2go.Course;

public class CoursePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Course course;
	private ArrayList<AssignmentPanel> assignmentPanels;
	private TakeAssignmentPanel assignmentGUI;

	/**
	 * Create the panel.
	 */
	public CoursePanel(Course course) {
		this.setCourse(course);
		this.setLayout(new CardLayout());
		
		assignmentPanels = new ArrayList<AssignmentPanel>();
		
		for (Assignment a: course.getSchedule().getAssignments()){
			assignmentPanels.add(new AssignmentPanel(a));
		}
		
		JPanel assignments = new JPanel();
		assignments.setLayout(new BoxLayout(assignments, BoxLayout.Y_AXIS));
		assignments.add(Box.createVerticalStrut(5));
		for (AssignmentPanel p: assignmentPanels){
			assignments.add(p);
		}
		assignments.add(Box.createVerticalGlue());
		
		this.add(assignments, "Assignments");
		
		assignmentGUI = new TakeAssignmentPanel();
		this.add(assignmentGUI, "Take Assignment");
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public void setAssignmentGUI(Assignment assignment) {
		assignmentGUI.setAssignment(assignment);
		assignmentGUI.revalidate();
	}
}
