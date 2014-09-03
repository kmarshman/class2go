package class2go.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import class2go.User;

public class NewCourseTab extends JPanel {

	private static final long serialVersionUID = 4913698467478860574L;
	private JTextField courseTitle;
	
	public NewCourseTab(User instructor){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel newcourseDialog = new JPanel();
		newcourseDialog.setMaximumSize(new Dimension(500, 50));
		newcourseDialog.setMinimumSize(new Dimension(500, 50));
		newcourseDialog.setPreferredSize(new Dimension(500, 50));
		
		JLabel title = new JLabel("Title");
		title.setFont(new Font("Arial", Font.BOLD, 15));
		newcourseDialog.add(title);
		
		courseTitle = new JTextField(25);
		courseTitle.setFont(new Font("Arial", Font.BOLD, 15));
		newcourseDialog.add(courseTitle);
		
		add(newcourseDialog);
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		buttonPanel.setMaximumSize(new Dimension(500, 50));
		buttonPanel.setMinimumSize(new Dimension(500, 50));
		buttonPanel.setPreferredSize(new Dimension(500, 50));
		
		JButton add = new JButton("add");
		add.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//String newCourseTitle = courseTitle.getText();
			
				courseTitle.setText("");
			}
		});
		buttonPanel.add(add);
		
		add(buttonPanel);
		add(Box.createVerticalGlue());
	}

}
