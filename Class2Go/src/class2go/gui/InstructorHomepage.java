package class2go.gui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import class2go.User;

public class InstructorHomepage extends JPanel {

	private static final long serialVersionUID = 1L;
	private User instructor;
	
	/**
	 * Create the panel.
	 */
	public InstructorHomepage() {
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);

	}

	public User getInstructor() {
		return instructor;
	}

	public void setInstructor(User instructor) {
		this.instructor = instructor;
	}

}
