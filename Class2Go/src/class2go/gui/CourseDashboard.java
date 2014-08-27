package class2go.gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import class2go.Course;
import class2go.curriculum.Assignment;
import class2go.curriculum.Unit;

public class CourseDashboard extends JPanel {

	private static final long serialVersionUID = 4201401732489263417L;
	private Course course;
	private ArrayList<InstructorAssignmentPanel> assignmentPanels;
	private JDatePickerImpl datePicker;
	private JTextField title;
	
	public CourseDashboard(Course course){
		this.setCourse(course);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		/*
		
		JPanel addAssignmentWrapper = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		addAssignmentWrapper.setMaximumSize(new Dimension(1530, 40));
		addAssignmentWrapper.setPreferredSize(new Dimension(1530, 40));
		addAssignmentWrapper.setMinimumSize(new Dimension(1530, 40));
		
		JLabel dueDate = new JLabel("Due Date:");
		dueDate.setFont(new Font("Arial", Font.BOLD, 15));
		addAssignmentWrapper.add(dueDate);
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel,  new DateLabelFormatter());
		addAssignmentWrapper.add(datePicker);
		
		addAssignmentWrapper.add(Box.createHorizontalStrut(20));
		
		JLabel titlePrompt = new JLabel("Title:");
		titlePrompt.setFont(new Font("Arial", Font.BOLD, 15));
		addAssignmentWrapper.add(titlePrompt);
		
		title = new JTextField();
		titlePrompt.setFont(new Font("Arial", Font.PLAIN, 15));
		title.setMaximumSize(new Dimension(300, 30));
		title.setPreferredSize(new Dimension(300, 30));
		title.setMinimumSize(new Dimension(300, 30));
		addAssignmentWrapper.add(title);
		
		addAssignmentWrapper.add(Box.createHorizontalStrut(20));
		
		JButton addAssignment = new JButton("add");
		addAssignment.setFont(new Font("Arial", Font.PLAIN, 13));
		addAssignmentWrapper.add(addAssignment);
		addAssignment.setMaximumSize(new Dimension(80, 30));
		addAssignment.setPreferredSize(new Dimension(80, 30));
		addAssignment.setMinimumSize(new Dimension(80, 30));
		schedulePanel.add(addAssignmentWrapper);
		
		add(schedulePanel);
		*/
		add(Box.createVerticalStrut(10));
		
		JPanel curriculumPanel = new JPanel();
		curriculumPanel.setLayout(new BoxLayout(curriculumPanel, BoxLayout.Y_AXIS));
		curriculumPanel.setMaximumSize(new Dimension(1500, 250));
		curriculumPanel.setPreferredSize(new Dimension(1500, 250));
		curriculumPanel.setMinimumSize(new Dimension(1500, 250));
		
		JPanel cTitleWrapper = new JPanel(new FlowLayout(FlowLayout.LEADING));
		cTitleWrapper.setMaximumSize(new Dimension(1500, 40));
		cTitleWrapper.setPreferredSize(new Dimension(1500, 40));
		cTitleWrapper.setMinimumSize(new Dimension(1500, 40));
		JLabel curriculumTitle = new JLabel("Curriculum");
		curriculumTitle.setFont(new Font("Arial", Font.BOLD, 20));
		cTitleWrapper.add(curriculumTitle);
		curriculumPanel.add(cTitleWrapper);
		
		JPanel treeWrapper = new JPanel(new FlowLayout(FlowLayout.LEADING));;
		JTree curriculumTree = CurriculumTreeBuilder.buildTree(course.getCurriculum());
		if (curriculumTree != null){
			treeWrapper.add(Box.createHorizontalStrut(20));
			JScrollPane scrollPane2 = new JScrollPane(curriculumTree);
			scrollPane2.setMaximumSize(new Dimension(500, 200));
			scrollPane2.setPreferredSize(new Dimension(500, 200));
			scrollPane2.setMinimumSize(new Dimension(500, 200));
			treeWrapper.add(scrollPane2);
			curriculumPanel.add(treeWrapper);
		}
		
		JPanel editCurriculum = new JPanel();
		editCurriculum.setLayout(new BoxLayout(editCurriculum, BoxLayout.Y_AXIS));
		
		JButton add = new JButton("add");
		add.setFont(new Font("Arial", Font.PLAIN, 15));
		add.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				add();
			}
		});
		editCurriculum.add(add);
		
		JButton remove = new JButton("remove");
		remove.setFont(new Font("Arial", Font.PLAIN, 15));
		remove.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				remove();
			}
		});
		editCurriculum.add(remove);
		
		JButton edit = new JButton("edit");
		edit.setFont(new Font("Arial", Font.PLAIN, 15));
		edit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				edit();
			}
		});
		editCurriculum.add(edit);

		add(curriculumPanel);
		
		JPanel rosterButtonPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		rosterButtonPanel.setMaximumSize(new Dimension(2000, 40));
		rosterButtonPanel.setPreferredSize(new Dimension(2000, 40));
		rosterButtonPanel.setMinimumSize(new Dimension(2000, 40));
		JButton rosterButton = new JButton("Roster");
		rosterButton.setFont(new Font("Arial", Font.PLAIN, 15));		
		rosterButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				viewStudents();
			}
		});
		rosterButtonPanel.add(rosterButton);
		add(rosterButtonPanel);
	}
	
	private void add(){
		
	}
	
	private void remove(){
		
	}
	
	private void edit(){
		
	}

	private void viewStudents(){
		CardLayout cards = (CardLayout) this.getParent().getLayout();
		cards.next(this.getParent());
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
