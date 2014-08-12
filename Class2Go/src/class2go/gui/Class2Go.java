package class2go.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

public class Class2Go extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class2Go frame = new Class2Go();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Class2Go() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setTitle("Class2Go");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel loginCard = new Login();
		contentPane.add(loginCard, "Welcome");
		JPanel studentHome = new StudentHomepage();
		contentPane.add(studentHome, "Student Homepage");
		JPanel instructorHome = new InstructorHomepage();
		contentPane.add(instructorHome, "Instructor Homepage");
	}

}
