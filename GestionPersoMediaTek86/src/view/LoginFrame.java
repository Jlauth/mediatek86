package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginFrame extends JFrame {

	/**
	 * Déclaration des éléments visuels 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel userNameLable, passwordLabel;
    JTextField userNameTextField;
    JPasswordField passwordField;
    JButton loginButton;
    Container container;
	
    
    /*---------2---------*/
    //create objects for components
    public LoginFrame() {
    	  userNameLable = new JLabel("User Name");
          userNameTextField = new JTextField();
          passwordLabel = new JLabel("Password");
          passwordField = new JPasswordField();
          loginButton = new JButton("Login");
          setTitle("Login Form");
          setBounds(250, 250, 370, 300);
          container = getContentPane();
          container.setLayout(null);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setResizable(false);
          
          setBounds();
          addComponents();
          addActionListener();
    }
 
    /*---------3---------*/
    //Place components at specified position
    public void setBounds() {
    	 userNameLable.setBounds(10, 10, 100, 30);
         userNameTextField.setBounds(100, 10, 200, 30);
         passwordLabel.setBounds(10, 50, 100, 30);
         passwordField.setBounds(100, 50, 200, 30);
         loginButton.setBounds(100, 100, 200, 30);
    }
 
    /*---------3---------*/
    //Add components to Container
    public void addComponents() {
    	container.add(userNameLable);
        container.add(userNameTextField);
        container.add(passwordLabel);
        container.add(passwordField);
        container.add(loginButton);
 
    }
 
    /*---------4---------*/
    //Add actionListener to components
    public void addActionListener() {
 
    }
 
    /*---------5---------*/
    //Perform actions based on events
    public void actionPerformed(ActionEvent e) {
 
    }
 
    public static void main(String[] args) {
        /*Create object of class and set basic properties*/
        LoginFrame frame = new LoginFrame();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(250, 250, 370, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
 
    }
 
}
