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
import java.awt.Font;

/**
 * Création de LoginFrame, gestion de la connexion des ayants droits
 * Login, mot de passe et bouton de connexion
 * @author Jean
 *
 */
public class LoginFrame extends JFrame implements ActionListener {

	/**
	 * Déclaration des éléments visuels 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JLabel imageUser;
    JTextField loginTextField;
    JPasswordField passwordField;
    JButton loginButton;
    Container container;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    
  
    
    /**
     * Initisalition des la classe LoginFrame
     * Création des objets de la classe LoginFrame
     */
    public LoginFrame() {
    	loginTextField = new JTextField();
    	loginTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
        passwordField = new JPasswordField();
        loginButton = new JButton("Se connecter");
        loginButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel = new JLabel("Login");
        lblNewLabel_1 = new JLabel("Password");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        setTitle("Connexion Gestion du Personnel - MediaTek86");
        setBounds(250, 250, 452, 325);
        container = getContentPane();
        container.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        setBounds();
        addComponents();
        addActionListener();
        
    }
 
    // placement des composants au bon positionnement
    public void setBounds() {
    	loginTextField.setBounds(151, 60, 160, 30);
        passwordField.setBounds(151, 101, 160, 30);
        loginButton.setBounds(151, 163, 160, 45);
        lblNewLabel.setBounds(70, 68, 46, 14);
        lblNewLabel_1.setBounds(70, 112, 69, 14);
    }
 
    // ajout des composants dans le container
    public void addComponents() {
        container.add(loginTextField);
        container.add(passwordField);
        container.add(loginButton);
        container.add(lblNewLabel_1); 
        container.add(lblNewLabel);
  
    }
 
    // ajout ActionListener aux composants
    public void addActionListener() {
    	loginButton.addActionListener(this);
    }
 
    /**
     * Execute les actions via ActionEvent
     * Récupération de la  classe Validation vérification champs remplis et corrects
     */
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
              if (login.equalsIgnoreCase("responsableMDTK") && pwd.equalsIgnoreCase("MediaTek86!")) {
                  JOptionPane.showMessageDialog(null, "Vous êtes connecté");
                  dispose();
                  new PersonnelFrame().setVisible(true);
                  
              } else {
            	  JOptionPane.showMessageDialog(null, "Impossible de se connecter");
              }
         }
    }
}
