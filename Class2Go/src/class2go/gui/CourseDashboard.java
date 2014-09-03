package class2go.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import org.codehaus.jackson.map.ObjectMapper;

import server_communication.HttpConnectionHandler;
import server_communication.RequestBuilder;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import class2go.Course;
import class2go.curriculum.Assignment;
import class2go.curriculum.Curriculum;
import class2go.curriculum.MultipleChoiceQuestion;
import class2go.curriculum.Question;
import class2go.curriculum.ShortAnswerQuestion;
import class2go.curriculum.TrueFalseQuestion;
import class2go.curriculum.Unit;

public class CourseDashboard extends JPanel implements Observer{

	private static final long serialVersionUID = 4201401732489263417L;
	private Course course;
	private JTree curriculumTree;
	private DefaultMutableTreeNode selectedNode;
	private JLabel[] labels;
	private JComponent[] fields;
	private Assignment assignment;
	private JButton add, remove;
	
	public CourseDashboard(Course course){
		this.setCourse(course);
		
		for (Unit u: course.getCurriculum().getUnits()){
			u.addObserver(this);
			for (Assignment a: u.getAssignments()){
				a.addObserver(this);
			}
		}
		
		course.getCurriculum().addObserver(this);
		
		this.setLayout(new BorderLayout());
		
		fill();
	}
	
	private void fill(){
		
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
		curriculumTree = CurriculumTreeBuilder.buildTree(course.getCurriculum());
		if (curriculumTree != null){
			curriculumTree.addTreeSelectionListener(new TreeSelectionListener(){
				@Override
				public void valueChanged(TreeSelectionEvent arg0) {
					selectedNode = (DefaultMutableTreeNode) curriculumTree.getLastSelectedPathComponent();
					if ((selectedNode.getUserObject() instanceof Assignment)){
						add.setEnabled(true);
						add.setText("add question");
						remove.setEnabled(true);
						remove.setText("remove assignment");
					} else if ((selectedNode.getUserObject() instanceof Unit)){
						remove.setText("remove unit");
						remove.setEnabled(true);
						add.setText("add assignment");
						add.setEnabled(true);
					} else if ((selectedNode.getUserObject() instanceof Curriculum)){
						remove.setEnabled(false);
						remove.setText("remove");
						add.setText("add unit");
						add.setEnabled(true);
					} else if ((selectedNode.getUserObject() instanceof Question)){
						add.setText("add");
						add.setEnabled(false);
						remove.setText("remove question");
						remove.setEnabled(true);							
					}else {
						add.setText("add");
						add.setEnabled(false);
						remove.setText("remove");
						remove.setEnabled(false);						
					}
				}
			});
			treeWrapper.add(Box.createHorizontalStrut(20));
			JScrollPane scrollPane2 = new JScrollPane(curriculumTree);
			scrollPane2.setMaximumSize(new Dimension(700, 400));
			scrollPane2.setPreferredSize(new Dimension(700, 400));
			scrollPane2.setMinimumSize(new Dimension(700, 400));
			treeWrapper.add(scrollPane2);
			curriculumPanel.add(treeWrapper);
		}
		add(curriculumPanel, BorderLayout.WEST);
		
		JPanel editCurriculum = new JPanel(new FlowLayout(FlowLayout.LEADING));
		editCurriculum.setAlignmentX(LEFT_ALIGNMENT);
		
		add = new JButton("add");
		add.setFont(new Font("Arial", Font.PLAIN, 15));
		add.setEnabled(false);
		add.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				add();
			}
		});
		editCurriculum.add(add);
		
		remove = new JButton("remove");
		remove.setFont(new Font("Arial", Font.PLAIN, 15));
		remove.setEnabled(false);
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
		//editCurriculum.add(edit);
		
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
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
		buttons.add(editCurriculum);
		buttons.add(Box.createVerticalStrut(100));
		buttons.add(rosterButtonPanel);
		add(buttons, BorderLayout.SOUTH);
	}
	
	private void add(){ //returnType = add
		if (selectedNode != null){
			if(selectedNode.getUserObject() instanceof Curriculum){
				JPanel newUnitDialog = new JPanel();
				
				JLabel title = new JLabel("Title");
				title.setFont(new Font("Arial", Font.BOLD, 15));
				newUnitDialog.add(title);
				
				JTextField unitTitle = new JTextField(25);
				unitTitle.setFont(new Font("Arial", Font.BOLD, 15));
				newUnitDialog.add(unitTitle);
				
				int result = JOptionPane.showConfirmDialog(null, newUnitDialog, 
			               "Create New Unit", JOptionPane.OK_CANCEL_OPTION);
				
				if(result == JOptionPane.OK_OPTION){
					String newUnitTitle = unitTitle.getText();
					Unit unit = new Unit(newUnitTitle, course.getCurriculum().getUnits().size()+1);
					
					sendUnit(unit);
				}
				//pass unit and course
			} else if (selectedNode.getUserObject() instanceof Unit){
				assignment = new Assignment();
				
				labels = new JLabel[2];
				fields = new JComponent[2];
				
				labels[0] = new JLabel("Title");
				labels[0].setFont(new Font("Arial", Font.BOLD, 15));
				
				fields[0] = new JTextField(25);
				fields[0].setFont(new Font("Arial", Font.BOLD, 15));
								
				labels[1] = new JLabel("Due Date:");
				labels[1].setFont(new Font("Arial", Font.BOLD, 15));
				
				UtilDateModel model = new UtilDateModel();
				JDatePanelImpl datePanel = new JDatePanelImpl(model);
				fields[1] = new JDatePickerImpl(datePanel,  new DateLabelFormatter());

				JPanel newAssignment = new JPanel();
		        GroupLayout layout = new GroupLayout(newAssignment);
		        newAssignment.setLayout(layout);
		        layout.setAutoCreateGaps(true);
		        
		        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		        GroupLayout.Group yLabelGroup = layout.createParallelGroup(GroupLayout.Alignment.TRAILING);
		        hGroup.addGroup(yLabelGroup);
		        GroupLayout.Group yFieldGroup = layout.createParallelGroup();
		        hGroup.addGroup(yFieldGroup);
		        layout.setHorizontalGroup(hGroup);

		        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		        layout.setVerticalGroup(vGroup);

		        int p = GroupLayout.PREFERRED_SIZE;
		        for (JLabel label : labels) {
		            yLabelGroup.addComponent(label);
		        }
		        for (JComponent field : fields) {
		            yFieldGroup.addComponent(field, p, p, p);
		        }
		        for (int ii = 0; ii < labels.length; ii++) {
		            vGroup.addGroup(layout.createParallelGroup().
		                    addComponent(labels[ii]).
		                    addComponent(fields[ii], p, p, p));
		        }

				int result = JOptionPane.showConfirmDialog(null, newAssignment, 
			               "Create New Assignment", JOptionPane.OK_CANCEL_OPTION);
				
				if (result == JOptionPane.OK_OPTION){
					JTextField input = (JTextField)fields[0];
					String title = input.getText();
					
					JDatePickerImpl dateInput = (JDatePickerImpl) fields[1];
					Date selectedDate = (Date) dateInput.getModel().getValue();
					
					Calendar dueDate = new GregorianCalendar();
					dueDate.setTime(selectedDate);
					
					assignment.setDueDate(dueDate);
					assignment.setTitle(title);
					
					sendAssignment(assignment);
				}
			} else if (selectedNode.getUserObject() instanceof Assignment){	
				labels = new JLabel[5];
				fields = new JComponent[5];
				
				labels[0] = new JLabel("Question Type");
				labels[0].setFont(new Font("Arial", Font.BOLD, 15));
				
				String[] options = {"Short Answer", "True/False", "Multiple Choice"};
				fields[0] = new JComboBox<String>(options);
				fields[0].setFont(new Font("Arial", Font.BOLD, 15));
				
				labels[1] = new JLabel("Instructions");
				labels[1].setFont(new Font("Arial", Font.BOLD, 15));
				
				fields[1] = new JTextField(25);
				fields[1].setFont(new Font("Arial", Font.BOLD, 15));
				
				labels[2] = new JLabel("Prompt");
				labels[2].setFont(new Font("Arial", Font.BOLD, 15));
				
				fields[2] = new JTextField(25);
				fields[2].setFont(new Font("Arial", Font.BOLD, 15));			
				
				labels[3] = new JLabel("Answer");
				labels[3].setFont(new Font("Arial", Font.BOLD, 15));
				
				fields[3] = new JTextField(25);
				fields[3].setFont(new Font("Arial", Font.BOLD, 15));
				
				labels[4] = new JLabel("Weight");
				labels[4].setFont(new Font("Arial", Font.BOLD, 15));
				
				fields[4] = new JTextField(10);
				fields[4].setFont(new Font("Arial", Font.BOLD, 15));
			
				JPanel newQuestion = new JPanel();
		        GroupLayout layout = new GroupLayout(newQuestion);
		        newQuestion.setLayout(layout);
		        layout.setAutoCreateGaps(true);
		        
		        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		        GroupLayout.Group yLabelGroup = layout.createParallelGroup(GroupLayout.Alignment.TRAILING);
		        hGroup.addGroup(yLabelGroup);
		        GroupLayout.Group yFieldGroup = layout.createParallelGroup();
		        hGroup.addGroup(yFieldGroup);
		        layout.setHorizontalGroup(hGroup);

		        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		        layout.setVerticalGroup(vGroup);

		        int p = GroupLayout.PREFERRED_SIZE;
		        for (JLabel label : labels) {
		            yLabelGroup.addComponent(label);
		        }
		        for (JComponent field : fields) {
		            yFieldGroup.addComponent(field, p, p, p);
		        }
		        for (int ii = 0; ii < labels.length; ii++) {
		            vGroup.addGroup(layout.createParallelGroup().
		                    addComponent(labels[ii]).
		                    addComponent(fields[ii], p, p, p));
		        }
		        
				int result = JOptionPane.showConfirmDialog(null, newQuestion, 
			               "Add Question", JOptionPane.OK_CANCEL_OPTION);
				
				if(result == JOptionPane.OK_OPTION){
		        
			        JTextField input = (JTextField)fields[1];
					String instructions = input.getText();
					
					input = (JTextField)fields[2];
					String prompt = input.getText();
					
					input = (JTextField)fields[3];
					String answer = input.getText();
					
					input = (JTextField)fields[4];
					Double weight = Double.valueOf(input.getText());
					
					@SuppressWarnings("unchecked")
					JComboBox<String> input2 = (JComboBox<String>)fields[0];
					int type = input2.getSelectedIndex();
					
					Question question;
					switch(type){
					case 0:
						question = new ShortAnswerQuestion(prompt, instructions, answer, weight);
						break;
					case 1:
						question = new TrueFalseQuestion(prompt, instructions, answer, weight);
						break;
					case 2:
						question = new MultipleChoiceQuestion(prompt, instructions, answer, weight);
						break;
					default:
						question = new Question();
						break;
					}
					
					sendQuestion(question);
				}
			}
		}
	}
	
	private void remove(){ //returnType = remove
		if (selectedNode != null){
			if(selectedNode.getUserObject() instanceof Curriculum){
				// can't do
			} else if (selectedNode.getUserObject() instanceof Unit){
				removeUnit((Unit)selectedNode.getUserObject()); 
			} else if (selectedNode.getUserObject() instanceof Question){
				removeQuestion((Question)selectedNode.getUserObject());
			} else {
				removeAssignment((Assignment)selectedNode.getUserObject());
			}
		}
	}
	
	private void edit(){ //requestType = edit
		if (selectedNode != null){
			if(selectedNode.getUserObject() instanceof Curriculum){
				// pass curriculum
				
			} else if (selectedNode.getUserObject() instanceof Unit){
				// pass unit
			} else {
				// pass assignment
			}
		}
	}

	private void viewStudents(){
		CardLayout cards = (CardLayout) this.getParent().getLayout();
		cards.next(this.getParent());
	}
	
	private void sendAssignment(Assignment assignment){
		String[] variables = {"requestType", "parent", "object", "objType"};
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json =  mapper.writeValueAsString(assignment);
			String parentJson = mapper.writeValueAsString(selectedNode.getUserObject());
			
			System.out.println(json);
			System.out.println(parentJson);
			
			String[] values = {"add", parentJson, json, "Assignment"};
			String post = RequestBuilder.buildPost(variables, values);
			HttpConnectionHandler postSender = new HttpConnectionHandler();
			System.out.println("about to send post");
			Assignment newAssignment = (Assignment) postSender.sendPost(post, "Assignment");
			System.out.println("Hello");
			assignment.setId(newAssignment.getId());
			
			System.out.println("got assignment id: " + newAssignment.getId());
			
			Unit unit = (Unit) selectedNode.getUserObject();
			unit.addAssignment(assignment);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void sendUnit(Unit unit){
		String[] variables = {"requestType", "parent", "object", "objType"};
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json =  mapper.writeValueAsString(unit);
			String parentJson = mapper.writeValueAsString(course);
			String[] values = {"add", parentJson, json, "Unit"};
			String post = RequestBuilder.buildPost(variables, values);
			HttpConnectionHandler postSender = new HttpConnectionHandler();
			Unit newUnit = (Unit) postSender.sendPost(post, "Unit");
			unit.setId(newUnit.getId());
			
			course.getCurriculum().addUnit(unit);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void sendQuestion(Question question){
		String[] variables = {"requestType", "parent", "object", "objType"};
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json =  mapper.writeValueAsString(question);
			String parentJson = mapper.writeValueAsString(selectedNode.getUserObject());
			String[] values = {"add", parentJson, json, "Question"};
			String post = RequestBuilder.buildPost(variables, values);
			HttpConnectionHandler postSender = new HttpConnectionHandler();
			Question newQuestion = (Question) postSender.sendPost(post, "Question");
			question.setId(newQuestion.getId());
			
			Assignment assignment = (Assignment) selectedNode.getUserObject();
			assignment.addQuestion(question);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void removeUnit(Unit unit){
		String[] variables = {"requestType", "parent", "object", "objType"};
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json =  mapper.writeValueAsString(unit);
			String parentJson = mapper.writeValueAsString(course);
			String[] values = {"remove", parentJson, json, "Unit"};
			String post = RequestBuilder.buildPost(variables, values);
			HttpConnectionHandler postSender = new HttpConnectionHandler();
			postSender.sendPost(post, "Remove");
			
			course.getCurriculum().removeUnit(unit);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void removeAssignment(Assignment assignment){
		String[] variables = {"requestType", "parent", "object", "objType"};
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json =  mapper.writeValueAsString(assignment);
			String parentJson = mapper.writeValueAsString(selectedNode.getUserObject());
			String[] values = {"remove", parentJson, json, "Assignment"};
			String post = RequestBuilder.buildPost(variables, values);
			HttpConnectionHandler postSender = new HttpConnectionHandler();
			postSender.sendPost(post, "Remove");
			
			DefaultMutableTreeNode parent = (DefaultMutableTreeNode) selectedNode.getParent();
			Unit unit = (Unit) parent.getUserObject();
			unit.removeAssignment(assignment);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void removeQuestion(Question question){
		String[] variables = {"requestType", "parent", "object", "objType"};
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json =  mapper.writeValueAsString(question);
			DefaultMutableTreeNode parent = (DefaultMutableTreeNode) selectedNode.getParent().getParent();
			String parentJson = mapper.writeValueAsString(parent.getUserObject());
			String[] values = {"remove", parentJson, json, "Question"};
			String post = RequestBuilder.buildPost(variables, values);
			HttpConnectionHandler postSender = new HttpConnectionHandler();
			postSender.sendPost(post, "Remove");
			
			Assignment assignment = (Assignment) parent.getUserObject();
			assignment.removeQuestion(question);
			
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

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("update");
		removeAll();
		fill();
	}

}
