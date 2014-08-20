package class2go.gui;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;

import class2go.Course;

public class CoursePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Course course;
	
	/**
	 * Create the panel.
	 */
	public CoursePanel(Course course) {
		this.setCourse(course);
		
		this.setLayout(new BorderLayout());
		
		JLabel title = new JLabel(course.getTitle());
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(title, BorderLayout.NORTH);
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
