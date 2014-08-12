package class2go.gui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import class2go.Instructor;

public class InstructorHomepage extends JPanel {

	private static final long serialVersionUID = 1L;
	private Instructor instructor;
	
	/**
	 * Create the panel.
	 */
	public InstructorHomepage() {
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);

	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

}
