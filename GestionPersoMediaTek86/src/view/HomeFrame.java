package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import controller.DataAccess;
import model.Personnel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;

public class HomeFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel p = new JPanel();
	JLabel label = new JLabel("Liste du Personnel");     
	JTable table = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	     
	public HomeFrame() {
		this.setLocationRelativeTo(null);
	    this.setSize(820,514);
	    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    this.setTitle("MediaTek86");
	    getContentPane().setLayout(null);
	    label.setForeground(Color.white);
	    p.setBounds(359, 30, 414, 24);
	    p.setBackground(Color.BLACK);
	    p.add(label);
	    getContentPane().add(p);
	         
	    data();
	    }
	     
	    public void data() {
	        new Personnel();
	        Object[][] body = new Object[(DataAccess.afficher()).size()][5];
	        String [] header= {"Nom", "Prénom", "Tel", "Mail", "Service"} ;
	        table = new JTable();
	        int i = 0;
	        for(Personnel et: (DataAccess.afficher())) {
	            body[i][0] = et.getNom();
	            body[i][1] = et.getPrenom();
	            body[i][2] = et.getTel();
	            body[i][3] = et.getMail();
	            body[i][4] = et.getService();
	            i++;
	        }
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(359, 54, 414, 374);
	        getContentPane().add(scrollPane);
	        table.setModel(new DefaultTableModel(
	        	new Object[][] {
	        		{null, null, null, null, null},
	        		{null, null, null, null, null},
	        		{null, null, null, null, null},
	        		{null, null, null, null, null},
	        		{null, null, null, null, null},
	        		{null, null, null, null, null},
	        		{null, null, null, null, null},
	        		{null, null, null, null, null},
	        		{null, null, null, null, null},
	        		{null, null, null, null, null},
	        		{null, null, null, null, null},
	        		{null, null, null, null, null},
	        	},
	        	new String[] {
	        		"Nom", "Pr\u00E9nom", "T\u00E9l\u00E9phone", "Mail", "Service"
	        	}
	        ));
	        
	        JButton btnAjouter = new JButton("Ajouter");
	        btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 11));
	        btnAjouter.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	}
	        });
	        btnAjouter.setBounds(20, 300, 96, 37);
	        getContentPane().add(btnAjouter);
	        
	        JButton btnModifier = new JButton("Modifier");
	        btnModifier.setFont(new Font("Tahoma", Font.BOLD, 11));
	        btnModifier.setBounds(126, 300, 96, 37);
	        getContentPane().add(btnModifier);
	        
	        JButton btnSupprimer = new JButton("Supprimer");
	        btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 11));
	        btnSupprimer.setBounds(230, 300, 96, 37);
	        getContentPane().add(btnSupprimer);
	        
	        JButton btnAbsence = new JButton("Absence");
	        btnAbsence.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	}
	        });
	        btnAbsence.setFont(new Font("Tahoma", Font.BOLD, 11));
	        btnAbsence.setBounds(126, 390, 96, 37);
	        getContentPane().add(btnAbsence);
	        
	        JLabel lblNom = new JLabel("Nom");
	        lblNom.setBounds(53, 83, 63, 14);
	        getContentPane().add(lblNom);
	        
	        JLabel lblPrenom = new JLabel("Prénom");
	        lblPrenom.setBounds(53, 115, 63, 14);
	        getContentPane().add(lblPrenom);
	        
	        JLabel lblTel = new JLabel("Téléphone");
	        lblTel.setBounds(53, 147, 63, 14);
	        getContentPane().add(lblTel);
	        
	        JLabel lblMail = new JLabel("Mail");
	        lblMail.setBounds(53, 183, 63, 14);
	        getContentPane().add(lblMail);
	        
	        JLabel lblService = new JLabel("Service");
	        lblService.setBounds(53, 218, 63, 14);
	        getContentPane().add(lblService);
	        
	        textField = new JTextField();
	        textField.setBounds(151, 83, 130, 20);
	        getContentPane().add(textField);
	        textField.setColumns(10);
	        
	        textField_1 = new JTextField();
	        textField_1.setColumns(10);
	        textField_1.setBounds(151, 115, 130, 20);
	        getContentPane().add(textField_1);
	        
	        textField_2 = new JTextField();
	        textField_2.setColumns(10);
	        textField_2.setBounds(151, 147, 130, 20);
	        getContentPane().add(textField_2);
	        
	        textField_3 = new JTextField();
	        textField_3.setColumns(10);
	        textField_3.setBounds(151, 183, 130, 20);
	        getContentPane().add(textField_3);
	        
	        JComboBox comboBox = new JComboBox();
	        comboBox.setBounds(151, 217, 130, 22);
	        getContentPane().add(comboBox);
	    }
}
