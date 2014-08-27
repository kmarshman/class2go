package class2go.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import class2go.curriculum.Assignment;

public class InstructorAssignmentPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Assignment assignment;
	private JLabel dueDate;
	private JButton complete;
	
	public InstructorAssignmentPanel(Assignment assignment){
		this.setAssignment(assignment);
		this.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.setLayout(new FlowLayout(FlowLayout.LEADING));
		this.setMaximumSize(new Dimension(900, 40));
		this.setPreferredSize(new Dimension(900, 40));
		this.setMinimumSize(new Dimension(900, 40));
		
		SimpleDateFormat date_format = new SimpleDateFormat("EEE, MMM d");
		dueDate = new JLabel(date_format.format((assignment.getDueDate().getTime())));
		dueDate.setFont(new Font("Arial", Font.BOLD, 15));
		dueDate.setMaximumSize(new Dimension(100, 40));
		dueDate.setPreferredSize(new Dimension(100, 40));
		dueDate.setMinimumSize(new Dimension(100, 40));
		add(dueDate);
		
		
		JLabel score = new JLabel(String.valueOf(assignment.calculateTotalPoints()));
		score.setFont(new Font("Arial", Font.PLAIN, 15));
		score.setMaximumSize(new Dimension(60, 40));
		score.setPreferredSize(new Dimension(60, 40));
		score.setMinimumSize(new Dimension(60, 40));
		add(score);
		
		
		JLabel title = new JLabel(assignment.getTitle());
		title.setFont(new Font("Arial", Font.BOLD, 16));
		title.setMaximumSize(new Dimension(500, 40));
		title.setPreferredSize(new Dimension(500, 40));
		title.setMinimumSize(new Dimension(500, 40));
		add(title);
		
		complete = new JButton("remove");
		complete.setFont(new Font("Arial", Font.PLAIN, 13));
		complete.setMaximumSize(new Dimension(80, 30));
		complete.setPreferredSize(new Dimension(80, 30));
		complete.setMinimumSize(new Dimension(80, 30));
		complete.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				removeAssignment();
			}
		});
		add(complete);
	}
	
	private void removeAssignment(){

	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

}
