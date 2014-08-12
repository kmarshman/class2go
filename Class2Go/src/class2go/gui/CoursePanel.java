package class2go.gui;

import javax.swing.JScrollPane;

import class2go.Course;

import javax.swing.JTree;

import java.awt.BorderLayout;

public class CoursePanel extends JScrollPane {

	private static final long serialVersionUID = 1L;
	private Course course;
	
	/**
	 * Create the panel.
	 */
	public CoursePanel(Course course) {
		this.setCourse(course);
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
		setLayout(new BorderLayout(0, 0));
		
		JTree scheduleTree = new JTree();
		add(scheduleTree, BorderLayout.CENTER);
	}

}
