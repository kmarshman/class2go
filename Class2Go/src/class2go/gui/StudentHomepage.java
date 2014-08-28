package class2go.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import class2go.Course;
import class2go.User;

public class StudentHomepage extends JPanel implements Observer{

	private static final long serialVersionUID = 5383757619897977563L;
	private User student;
	private JTabbedPane courseTabs;
	private ArrayList<JPanel> courses;

	/**
	 * Create the panel.
	 */
	public StudentHomepage() {
		courseTabs = new JTabbedPane();
		courseTabs.setFont(new Font("Arial", Font.BOLD, 14));
		courseTabs.setPreferredSize(new Dimension(975, 640));
		courseTabs.setMinimumSize(new Dimension(900, 600));
		add(courseTabs);
	}
	
	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
		this.student.addObserver(this);
		
		courseTabs.removeAll();
		
		courses = new ArrayList<JPanel>();
		int index = 0;
		for (Course c: student.getCourses()){
			courses.add(new CoursePanel(c));
			courseTabs.add(c.getTitle(), courses.get(index));
			index++;
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Student Update");
		setStudent((User) o);
	}

}
