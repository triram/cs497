package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class FinalProject {
	
	// PE10: Create an array that fictitiously registers five users with names and passwords
	
	static int currentUser = 0;
	static User[] UserArray = new User[100];

	public static void main(String[] args) {
		
		// Create a new window frame
		JFrame f = new JFrame();
		// Set the width and height of the frame
		f.setSize(200, 300);
		
		// Create the text fields for entering name, username, and password
		JTextField NameTextField = new JTextField();
		JTextField UserNameTextField = new JTextField();
		JTextField PasswordTextField = new JTextField();
		
		// Label the text fields
		JLabel NameLabel = new JLabel("Name :");
		JLabel UserNameLabel = new JLabel("Username :");
		JLabel PasswordLabel = new JLabel("Password :");
		
		// Create the sign up and login buttons
		JButton SignUpButton = new JButton();
		SignUpButton.setText("Sign Up");
		
		JButton LogInButton = new JButton();
		LogInButton.setText("Log In");
		
		// Creates a grid layout which will separate the text fields and buttons
		f.setLayout(new GridLayout(4,2));
		
		// Add text fields and buttons to the window
		f.add(NameLabel);
		f.add(NameTextField);
		
		f.add(UserNameLabel);
		f.add(UserNameTextField);
		
		f.add(PasswordLabel);
		f.add(PasswordTextField);
		
		f.add(LogInButton);
		f.add(SignUpButton);
		
		// If the password entered matches the password associated with a user in UserArray
		// the user will be logged in, text fields and buttons will not be visible, & welcome message will display
		LogInButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < UserArray.length; i++) {
					if (UserArray[i].getPassword().equals(PasswordTextField.getText())) {
						System.out.println("Logged In");
						NameTextField.setVisible(false);
						UserNameTextField.setVisible(false);
						PasswordTextField.setVisible(false);
						
						SignUpButton.setVisible(false);
						LogInButton.setVisible(false);
						
						NameLabel.setText("Welcome, " + UserArray[i].getName());
						UserNameLabel.setVisible(false);
						PasswordLabel.setVisible(false);
						
						break;
					}
				}
			}
		});
		
		// If username already exists in UserArray, do nothing
		// Otherwise, add new user to UserArray with their name, username, and password
		SignUpButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				User UserToAdd = new User(NameTextField.getText(), 
						  UserNameTextField.getText(), 
						  PasswordTextField.getText());
				
				boolean UserExists = false;
				
				for (int i = 0; i < UserArray.length; i++) {
					if (UserArray[i].getUsername().equals(UserToAdd.getName())) {
						UserExists = true;
					}
				}
				
				if (UserExists = false) {
					UserArray[currentUser] = UserToAdd;
					System.out.println("Added new user with name " + UserToAdd.getName());
				}
			}
		});
		
		// Quit the application when user closes the window
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		// Make the window visible
		f.setVisible(true);

	}

}
