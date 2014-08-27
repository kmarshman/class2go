package class2go.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import class2go.User;

public class StudentPanel extends JPanel {

	private static final long serialVersionUID = -6366578660196009632L;
	private User student;
	
	public StudentPanel(User student){
		this.setStudent(student);
		
		this.setLayout(new FlowLayout(FlowLayout.LEADING));
		this.setAlignmentX(LEFT_ALIGNMENT);
		
		setMaximumSize(new Dimension(500, 40));
		setPreferredSize(new Dimension(500, 40));
		setMinimumSize(new Dimension(500, 40));
		
		JLabel id = new JLabel(String.valueOf(student.getId()));
		id.setFont(new Font("Arial", Font.PLAIN, 15));
		id.setMaximumSize(new Dimension(100, 20));
		id.setPreferredSize(new Dimension(100, 20));
		id.setMinimumSize(new Dimension(100, 20));
		add(id);
		
		JLabel firstName = new JLabel(student.getFirstName());
		firstName.setFont(new Font("Arial", Font.PLAIN, 15));
		firstName.setMaximumSize(new Dimension(100, 40));
		firstName.setPreferredSize(new Dimension(100, 40));
		firstName.setMinimumSize(new Dimension(100, 40));
		add(firstName);
		
		JLabel lastName = new JLabel(student.getLastName());
		lastName.setFont(new Font("Arial", Font.PLAIN, 15));
		lastName.setMaximumSize(new Dimension(100, 40));
		lastName.setPreferredSize(new Dimension(100, 40));
		lastName.setMinimumSize(new Dimension(100, 40));
		add(lastName);
		
		JButton removeStudent = new JButton("drop");
		removeStudent.setFont(new Font("Arial", Font.PLAIN, 15));
		removeStudent.setMaximumSize(new Dimension(100, 30));
		removeStudent.setPreferredSize(new Dimension(100, 30));
		removeStudent.setMinimumSize(new Dimension(100, 30));
		removeStudent.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dropStudent();
			}
		});
		add(removeStudent);
		
	}
	
	private void dropStudent(){
		StudentRosterPanel rosterPanel = (StudentRosterPanel) this.getParent().getParent().getParent().getParent();
		rosterPanel.getCourse().removeStudent(student);
		rosterPanel.remove(this);
		rosterPanel.revalidate();
		rosterPanel.repaint();
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

}
