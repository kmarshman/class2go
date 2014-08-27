package class2go.gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.codehaus.jackson.map.ObjectMapper;

import server_communication.HttpConnectionHandler;
import server_communication.RequestBuilder;
import class2go.Course;
import class2go.User;

public class StudentRosterPanel extends JPanel {

	private static final long serialVersionUID = -5516086492100774132L;
	private Course course;
	private JTextField firstName, lastName;
	
	public StudentRosterPanel(Course course){
		this.course = course;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		buttonPanel.setMaximumSize(new Dimension(1000, 40));
		buttonPanel.setPreferredSize(new Dimension(1000, 40));
		buttonPanel.setMinimumSize(new Dimension(1000, 40));
		
		JLabel title = new JLabel("Student Roster");
		title.setFont(new Font("Arial", Font.BOLD, 20));
		title.setMaximumSize(new Dimension(250, 40));
		title.setPreferredSize(new Dimension(250, 40));
		title.setMinimumSize(new Dimension(250, 40));
		buttonPanel.add(title);
		
		buttonPanel.add(Box.createHorizontalStrut(200));
		
		JButton finish = new JButton("return");
		finish.setFont(new Font("Arial", Font.PLAIN, 15));
		finish.setMaximumSize(new Dimension(100, 30));
		finish.setPreferredSize(new Dimension(100, 30));
		finish.setMinimumSize(new Dimension(100, 30));
		finish.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				back();
			}
		});
		buttonPanel.add(finish);
		
		add(buttonPanel);
		
		add(Box.createVerticalStrut(10));
		
		ArrayList<StudentPanel> students = new ArrayList<StudentPanel>();
		if(course.getRoster() != null){
			for(User s: course.getRoster().getStudents()){
				students.add(new StudentPanel(s));
			}
		}
		
		JPanel studentPanels = new JPanel();
		studentPanels.setLayout(new BoxLayout(studentPanels, BoxLayout.Y_AXIS));
		for(StudentPanel p: students)
			studentPanels.add(p);
		
		JScrollPane scrollPane = new JScrollPane(studentPanels);
		add(scrollPane);
		
		add(Box.createVerticalStrut(10));
		
		JPanel newStudent = new JPanel();
		newStudent.setMaximumSize(new Dimension(500, 40));
		newStudent.setPreferredSize(new Dimension(500, 40));
		newStudent.setMinimumSize(new Dimension(500, 40));
		
		
		firstName = new JTextField("First Name");
		firstName.setFont(new Font("Arial", Font.PLAIN, 15));
		firstName.setMaximumSize(new Dimension(200, 30));
		firstName.setPreferredSize(new Dimension(200, 30));
		firstName.setMinimumSize(new Dimension(200, 30));
		newStudent.add(firstName);
		
		lastName = new JTextField("Last Name");
		lastName.setFont(new Font("Arial", Font.PLAIN, 15));
		lastName.setMaximumSize(new Dimension(200, 30));
		lastName.setPreferredSize(new Dimension(200, 30));
		lastName.setMinimumSize(new Dimension(200, 30));
		newStudent.add(lastName);
		
		JButton addStudent = new JButton("add");
		addStudent.setFont(new Font("Arial", Font.PLAIN, 15));
		addStudent.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addStudent();
			}
		});
		newStudent.add(addStudent);
	
		add(newStudent);
	}
	
	private void back(){
		CardLayout cards = (CardLayout) this.getParent().getLayout();
		cards.next(this.getParent());
	}
	
	private void addStudent(){
		String first = firstName.getText();
		String last = lastName.getText();
		
		ObjectMapper mapper = new ObjectMapper();

		try {
			String courseJson =  mapper.writeValueAsString(course);
			String[] variables = {"requestType", "firstName", "lastName", "course"};
			String[] values = {"addStudent", first, last, courseJson};
			String post = RequestBuilder.buildPost(variables, values);
			
			HttpConnectionHandler postSender = new HttpConnectionHandler();
			User result = (User) postSender.sendPost(post, "addStudent");
			
			course.addStudent(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
}
