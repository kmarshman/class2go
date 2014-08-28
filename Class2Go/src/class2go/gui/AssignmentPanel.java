package class2go.gui;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import class2go.curriculum.Assignment;

public class AssignmentPanel extends JPanel implements Observer{

	private static final long serialVersionUID = 1L;
	private Assignment assignment;
	private JLabel dueDate;
	private JButton complete;
	
	public AssignmentPanel(Assignment assignment){
		this.setAssignment(assignment);
		this.assignment.addObserver(this);
		this.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.setLayout(new FlowLayout(FlowLayout.LEADING));
		this.setMaximumSize(new Dimension(1000, 40));
		this.setPreferredSize(new Dimension(1000, 40));
		this.setMinimumSize(new Dimension(1000, 40));
		
		fill();
	}
	
	private void fill(){
		
		SimpleDateFormat date_format = new SimpleDateFormat("EEE, MMM d");
		dueDate = new JLabel(date_format.format((assignment.getDueDate().getTime())));
		dueDate.setFont(new Font("Arial", Font.BOLD, 15));
		dueDate.setMaximumSize(new Dimension(100, 40));
		dueDate.setPreferredSize(new Dimension(100, 40));
		dueDate.setMinimumSize(new Dimension(100, 40));
		add(dueDate);
		
		Double grade = assignment.getGrade();
		if (grade == null) grade = 0.0;
		JLabel score = new JLabel(grade + " / " + assignment.calculateTotalPoints());
		score.setFont(new Font("Arial", Font.PLAIN, 15));
		score.setMaximumSize(new Dimension(100, 40));
		score.setPreferredSize(new Dimension(100, 40));
		score.setMinimumSize(new Dimension(100, 40));
		add(score);
		
		
		JLabel title = new JLabel(assignment.getTitle());
		title.setFont(new Font("Arial", Font.BOLD, 16));
		title.setMaximumSize(new Dimension(500, 40));
		title.setPreferredSize(new Dimension(500, 40));
		title.setMinimumSize(new Dimension(500, 40));
		add(title);
		
		complete = new JButton("Complete");
		complete.setFont(new Font("Arial", Font.PLAIN, 13));
		complete.setMaximumSize(new Dimension(100, 30));
		complete.setPreferredSize(new Dimension(100, 30));
		complete.setMinimumSize(new Dimension(100, 30));
		complete.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				takeAssignment();
			}
		});
		if (assignment.getGrade() != null) complete.setEnabled(false);
		add(complete);
	}
	
	private void takeAssignment(){
		CoursePanel coursePanel = (CoursePanel) this.getParent().getParent();
		coursePanel.setAssignmentGUI(assignment);
		CardLayout cards = (CardLayout) coursePanel.getLayout();
		cards.next(coursePanel);
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Update Assignment");
		this.assignment = (Assignment) o;
		removeAll();
		fill();		
	}

}
