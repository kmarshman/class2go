package class2go.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;

import java.awt.Font;

import javax.swing.border.LineBorder;

import class2go.User;
import server_communication.RequestBuilder;
import server_communication.HttpConnectionHandler;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;
	private Class2Go app;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public Login(Class2Go app) {
		this.app = app;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Component outsideTopGlue = Box.createGlue();
		add(outsideTopGlue);
		
		JPanel container = new JPanel();
		container.setBackground(Color.WHITE);
		container.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		container.setMaximumSize(new Dimension(300, 300));
		add(container);
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		Component topVerticalStrut = Box.createVerticalStrut(20);
		container.add(topVerticalStrut);
		
		JLabel instructionLabel = new JLabel("Sign in to");
		container.add(instructionLabel);
		instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		instructionLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		
		JLabel productLabel = new JLabel("Class2Go");
		container.add(productLabel);
		productLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		productLabel.setFont(new Font("Arial", Font.BOLD, 16));
		
		Component verticalStrut = Box.createVerticalStrut(10);
		container.add(verticalStrut);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(Color.WHITE);
		container.add(loginPanel);
		loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
		
		JPanel username = new JPanel();
		username.setBackground(Color.WHITE);
		username.setMaximumSize(new Dimension(200, 200));
		loginPanel.add(username);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 12));
		username.add(lblUsername);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Arial", Font.PLAIN, 12));
		username.add(usernameField);
		usernameField.setColumns(10);
		
		JPanel password = new JPanel();
		password.setBackground(Color.WHITE);
		password.setMaximumSize(new Dimension(200, 200));
		loginPanel.add(password);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		password.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 12));
		password.add(passwordField);
		passwordField.setColumns(10);
		
		JPanel submit = new JPanel();
		submit.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) submit.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		loginPanel.add(submit);
		
		JButton login = new JButton("Sign in");
		submit.add(login);
		login.setFont(new Font("Arial", Font.PLAIN, 12));
		login.setAlignmentX(Component.CENTER_ALIGNMENT);
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				login();		
			}
		});
		
		app.getRootPane().setDefaultButton(login);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(50);
		submit.add(horizontalStrut_1);
		
		Component bottomGlue = Box.createGlue();
		loginPanel.add(bottomGlue);
		
		Component bottomVerticalStrut = Box.createVerticalStrut(20);
		loginPanel.add(bottomVerticalStrut);
		
		Component outsideBottomGlue = Box.createGlue();
		add(outsideBottomGlue);
		
	}
	
	private void login(){
		if (!usernameField.getText().equals("") && !passwordField.getPassword().equals("")){
			String[] variables = {"requestType", "username", "password"};
			String[] values = {"login", usernameField.getText(), String.valueOf(passwordField.getPassword())};
			String post = RequestBuilder.buildPost(variables, values);
			try {
				HttpConnectionHandler postSender = new HttpConnectionHandler();
				User result = (User) postSender.sendPost(post, "Login");
				CardLayout layout = (CardLayout) app.getContentPane().getLayout();
				result.getInterface(app, layout);
				/*
				if (result.getRole().getRoleTitle().equals("Student")){
					app.setStudent(result);
					layout.next(app.getContentPane());
				} else if (result.getRole().getRoleTitle().equals("Instructor")){
					System.out.println("Instructor");
					app.setInstructor(result);
					layout.next(app.getContentPane());
					layout.next(app.getContentPane());
				} else {
					JOptionPane.showMessageDialog((JFrame) SwingUtilities.getWindowAncestor(Login.this), "Username and Password combination inccorect", "Login error", JOptionPane.ERROR_MESSAGE);
				}
				*/
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			JOptionPane.showMessageDialog((JFrame) SwingUtilities.getWindowAncestor(Login.this), "Username and Password must be completed", "Login error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
