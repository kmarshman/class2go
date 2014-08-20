package class2go.gui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import class2go.Course;

public class CoursePanel extends JScrollPane {

	private static final long serialVersionUID = 1L;
	private Course course;
	
	/**
	 * Create the panel.
	 */
	public CoursePanel(Course course) {
		this.setCourse(course);
		this.setBackground(Color.BLUE);
		JLabel title = new JLabel("Test Panel");
		this.add(title);
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
