package class2go.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import class2go.curriculum.MultipleChoiceQuestion;
import class2go.curriculum.Question;
import class2go.curriculum.ShortAnswerQuestion;
import class2go.curriculum.TrueFalseQuestion;

public class QuestionPanel extends JPanel {

	private static final long serialVersionUID = -7258390655415574243L;
	
	private Question question;
	private JTextField shortAnswer;
	private ButtonGroup selectionGroup;
	private boolean lastCard;
	private JButton submit;
	
	public QuestionPanel(Question question, boolean lastCard){
		this.setLayout(new BorderLayout());
		setPreferredSize(new Dimension(975, 600));
		setMinimumSize(new Dimension(900, 580));
		
		this.lastCard = lastCard;
		setQuestion(question);
		
		JLabel instructions = new JLabel(question.getInstructions());
		instructions.setAlignmentX(Component.CENTER_ALIGNMENT);
		instructions.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel prompt = new JLabel(question.getPrompt());
		prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
		prompt.setFont(new Font("Arial", Font.BOLD, 15));
		
		JPanel instructionsPanel = new JPanel();
		instructionsPanel.setLayout(new BoxLayout(instructionsPanel, BoxLayout.Y_AXIS));
		instructionsPanel.setMaximumSize(new Dimension(100, 50));
		instructionsPanel.setPreferredSize(new Dimension(100, 50));
		instructionsPanel.setMinimumSize(new Dimension(100, 50));
		instructionsPanel.add(instructions);
		instructionsPanel.add(prompt);
		
		add(instructionsPanel, BorderLayout.NORTH);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		if(question instanceof ShortAnswerQuestion){
			shortAnswer = new JTextField();
			shortAnswer.setFont(new Font("Arial", Font.PLAIN, 15));
			shortAnswer.setMaximumSize(new Dimension(300, 100));
			shortAnswer.setPreferredSize(new Dimension(300, 100));
			shortAnswer.setMinimumSize(new Dimension(300, 100));
			inputPanel.add(shortAnswer);
		} else if (question instanceof TrueFalseQuestion){
			JPanel optionsPanel = new JPanel();
			optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
			optionsPanel.setMaximumSize(new Dimension(150, 100));
			optionsPanel.setPreferredSize(new Dimension(150, 100));
			optionsPanel.setMinimumSize(new Dimension(150, 100));
			JRadioButton trueButton = new JRadioButton("True");
			trueButton.setFont(new Font("Arial", Font.PLAIN, 15));
			trueButton.setHorizontalAlignment(SwingConstants.LEFT);
			JRadioButton falseButton = new JRadioButton("False");
			falseButton.setFont(new Font("Arial", Font.PLAIN, 15));
			falseButton.setHorizontalAlignment(SwingConstants.LEFT);
			optionsPanel.add(trueButton);
			optionsPanel.add(falseButton);
			selectionGroup = new ButtonGroup();
			selectionGroup.add(trueButton);
			selectionGroup.add(falseButton);
			inputPanel.add(optionsPanel);
		} else if (question instanceof MultipleChoiceQuestion){
			JPanel optionsPanel = new JPanel();
			optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
			optionsPanel.setMaximumSize(new Dimension(200, 150));
			optionsPanel.setPreferredSize(new Dimension(200, 150));
			optionsPanel.setMinimumSize(new Dimension(200, 150));
			ArrayList<JRadioButton> optionButtons = new ArrayList<JRadioButton>();
			for (String choice: question.getOptions()){
				JRadioButton b = new JRadioButton(choice);
				b.setFont(new Font("Arial", Font.PLAIN, 15));
				b.setAlignmentX(Component.LEFT_ALIGNMENT);
				b.setHorizontalAlignment(SwingConstants.LEFT);
				optionButtons.add(b);
			}
			selectionGroup = new ButtonGroup();
			for (JRadioButton button: optionButtons){
				selectionGroup.add(button);
				optionsPanel.add(button);
			}
			inputPanel.add(optionsPanel);
		} else {
			JLabel errorMessage = new JLabel("Invalid question type");
			errorMessage.setFont(new Font("Arial", Font.PLAIN, 15));
			inputPanel.add(errorMessage);
		}
		if(!lastCard) submit = new JButton("next");
		else submit = new JButton("submit");
		submit.setFont(new Font("Arial", Font.PLAIN, 15));
		submit.setMaximumSize(new Dimension(100, 30));
		submit.setPreferredSize(new Dimension(100, 30));
		submit.setMinimumSize(new Dimension(100, 30));
		submit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gradeQuestion();
			}
		});
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		buttonPanel.setMaximumSize(new Dimension(300, 100));
		buttonPanel.setPreferredSize(new Dimension(300, 100));
		buttonPanel.setMinimumSize(new Dimension(300, 100));
		buttonPanel.add(submit);
		inputPanel.add(buttonPanel);
		add(inputPanel, BorderLayout.CENTER);
	}
	
	private void gradeQuestion(){
		if(!lastCard){
			CardLayout cards = (CardLayout) this.getParent().getLayout();
			cards.next(this.getParent());
		} else {
			CoursePanel coursePanel = (CoursePanel) this.getParent().getParent().getParent();
			CardLayout cards = (CardLayout) coursePanel.getLayout();
			cards.next(coursePanel);
		}
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}
