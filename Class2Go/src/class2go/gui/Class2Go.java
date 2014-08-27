package class2go.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import class2go.User;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Class2Go extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private StudentHomepage studentHome;
	private InstructorHomepage instructorHome;

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
		setSize(1000, 710);
		setLocationRelativeTo(null);
		setTitle("Class2Go");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		

        JMenuBar menubar = new JMenuBar();
        JMenu profile = new JMenu("My Profile");

        JMenuItem eMenuItem = new JMenuItem("Logout");
        eMenuItem.setToolTipText("Logout");
        eMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                logout();
            }
        });

        profile.add(eMenuItem);
        menubar.add(profile);

        setJMenuBar(menubar);
		
		Login loginCard = new Login(this);
		contentPane.add(loginCard, "Welcome");
		studentHome = new StudentHomepage();
		contentPane.add(studentHome, "Student Homepage");
		instructorHome = new InstructorHomepage();
		contentPane.add(instructorHome, "Instructor Homepage");
	}
	
	private void logout(){
		CardLayout cards = (CardLayout) this.getContentPane().getLayout();
		cards.first(this.getContentPane());
	}
	
	public void setStudent(User student){
		studentHome.setStudent(student);
	}
	
	public void setInstructor(User instructor){
		instructorHome.setInstructor(instructor);
	}

}
