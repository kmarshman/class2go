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

public class InstructorHomepage extends JPanel implements Observer{

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
		this.instructor.addObserver(this);
		
		courseTabs.removeAll();
		
		courses = new ArrayList<InstructorCoursePanel>();
		int index = 0;
		for (Course c: instructor.getCourses()){
			courses.add(new InstructorCoursePanel(c));
			courseTabs.add(c.getTitle(), courses.get(index));
			index++;
		}
		courseTabs.add("New Course...", new NewCourseTab(instructor));
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("Instructor Update");
		setInstructor((User)arg0);
	}

}
