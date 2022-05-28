package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Validation;

public class LoginFrame extends JFrame implements ActionListener {

	/**
	 * Déclaration des éléments visuels 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JLabel loginLabel;
	JLabel passwordLabel;
    JTextField loginTextField;
    JPasswordField passwordField;
    JButton loginButton;
    Container container;
	
    
    /*---------2---------*/
    //create objects for components
    public LoginFrame() {
    	loginLabel = new JLabel("User Name");
    	loginTextField = new JTextField();
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
    	loginLabel.setBounds(10, 10, 100, 30);
    	loginTextField.setBounds(100, 10, 200, 30);
        passwordLabel.setBounds(10, 50, 100, 30);
        passwordField.setBounds(100, 50, 200, 30);
        loginButton.setBounds(100, 100, 200, 30);
    }
 
    /*---------3---------*/
    //Add components to Container
    public void addComponents() {
    	container.add(loginLabel);
        container.add(loginTextField);
        container.add(passwordLabel);
        container.add(passwordField);
        container.add(loginButton);
 
    }
 
    /*---------4---------*/
    //Add actionListener to components
    public void addActionListener() {
    	loginButton.addActionListener(this);
    }
 
    /*---------5---------*/
    //Perform actions based on events
    @Override
    public void actionPerformed(ActionEvent e) {
    	 System.out.println("Event called");
         if (e.getSource() == loginButton) {
        	 String login = loginTextField.getText();
              /*never print password or other sensitive data in console this is only for testing purpose*/
              String pwd = String.valueOf(passwordField.getPassword());
              System.out.println(login + " " + pwd);
              
              Validation v = new Validation();
              java.util.List<String> errors = v.validateLogin(login, pwd);
              if (!errors.isEmpty()) {
                  JOptionPane.showMessageDialog(null, errors.toArray());
                  return;
              }
              
              // check password provided by user with stored password in database
              if (login.equalsIgnoreCase("Test") && pwd.equalsIgnoreCase("1234")) {
                  System.out.println("Logged in");
                  new PersonnelFrame().setVisible(true);
              } else {
            	  System.out.println("Unable to login");
              }
         }
    }
}
