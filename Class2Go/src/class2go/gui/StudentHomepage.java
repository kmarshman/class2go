package class2go.gui;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import class2go.Course;
import class2go.Student;

public class StudentHomepage extends JPanel {

	private static final long serialVersionUID = 5383757619897977563L;
	private Student student;
	private JTabbedPane courseTabs;
	private ArrayList<JScrollPane> courses;

	/**
	 * Create the panel.
	 */
	public StudentHomepage() {
		
		courseTabs = new JTabbedPane(JTabbedPane.TOP);
		add(courseTabs);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		courses = new ArrayList<JScrollPane>();
		int index = 0;
		for (Course c: student.getCourses()){
			courses.add(new CoursePanel(c));
			courseTabs.add(c.getTitle(), courses.get(index));
			index++;
		}
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
		paintComponent(this.getGraphics());
	}

}
