package project1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ParserHTML {
	
	// This program will scan HTML code entered by the user and check it against success criteria set by the Web Content Accessibility Guidelines (WCAG)
	// (Based on a separated, not related project; included for reference)

	public static void main(String[] args) {
		
				JFrame f = new JFrame();
				f.setSize(1000, 1000);
				
				JTextField HTMLTextField = new JTextField();
				
				// Ask user to input HTML code for scanning
				JLabel HTMLLabel = new JLabel("Enter your HTML code :");
				
				JButton ScanButton = new JButton();
				ScanButton.setText("Scan");
				
				
				f.setLayout(new GridLayout(4,2));
				
				f.add(HTMLLabel);
				f.add(HTMLTextField);
				
				f.add(ScanButton);
				
				// Scan the HTML code entered in the text field
				// Split code by lines and output each line
				ScanButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String CodeToScan = HTMLTextField.getText();
						String[] myArray = CodeToScan.split("/n");
						for (int i=0; i<=myArray.length; i++) {
							System.out.println(myArray[i]);
						}
						
						
					}
				});
				
				// Quits the application when user closes the window
				f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				
				f.setVisible(true);
	}
}
