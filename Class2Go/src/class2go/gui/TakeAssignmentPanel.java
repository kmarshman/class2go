package class2go.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import assignment.Assignment;

public class TakeAssignmentPanel extends JPanel {

	private static final long serialVersionUID = 7457539860616049194L;
	
	private Assignment assignment;
	private JLabel title;
	private JPanel questions;
	private ArrayList<QuestionPanel> questionPanels;
	
	public TakeAssignmentPanel(){		
		setLayout(new BorderLayout());
		title = new JLabel();
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setHorizontalTextPosition(SwingConstants.CENTER);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setFont(new Font("Arial", Font.BOLD, 20));
		add(title, BorderLayout.NORTH);
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
		this.removeAll();
		add(title, BorderLayout.NORTH);
		title.setText(assignment.getTitle());
		
		questions = new JPanel(new CardLayout());
		questionPanels = new ArrayList<QuestionPanel>();
		for (int i = 0; i < assignment.getQuestions().size(); i++){
			boolean last = (i == assignment.getQuestions().size() - 1);
			questions.add(new QuestionPanel(assignment.getQuestions().get(i), last));
		}	
		int number = 1;
		for(QuestionPanel panel: questionPanels){
			questions.add(panel, ("Question " + number));
			number++;
		}
		
		add(questions, BorderLayout.CENTER);
	}

}
