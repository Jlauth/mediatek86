package view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.DataAccess;
import model.Absence;
import model.Personnel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PersonnelFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
    JLabel label = new JLabel("Liste du Personnel");
	JTable table = null;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtTel;
	private JTextField txtMail;
	
	public PersonnelFrame() {
	
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	    this.setSize(700,400);
	    this.setTitle("Liste actualisée du personnel");
	    panel.setBounds(359, 30, 414, 24);
	    panel.setBackground(Color.GRAY);
	    label.setForeground(Color.white);
	    panel.add(label);	         
	    
	    /**
	     * Initialisation du JTable
	     * Récupération via la DB et initialisation des données du personnel
	     */
		table = new JTable();
		Object[][] body = new Object[(DataAccess.recupPersonnels()).size()][5];
		String [] header = {"Nom", "Prénom", "Tel", "Mail", "Service"} ;
		int i = 0;
		for(Personnel et: (DataAccess.recupPersonnels())) {
		    	body[i][0] = et.getNom();
		        body[i][1] = et.getPrenom();
		        body[i][2] = et.getTel();
		        body[i][3] = et.getMail();
		        body[i][4] = et.getService();
		        i++;
		}
		table.setModel(new DefaultTableModel(body,header));
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().setLayout(null);
		scrollPane.setBounds(343, 0, 341, 361);
		getContentPane().add(scrollPane);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(34, 69, 76, 14);
		getContentPane().add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prénom");
		lblPrenom.setBounds(34, 97, 76, 14);
		getContentPane().add(lblPrenom);
		
		JLabel lblTel = new JLabel("Téléphone");
		lblTel.setBounds(34, 122, 76, 14);
		getContentPane().add(lblTel);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(34, 147, 76, 14);
		getContentPane().add(lblMail);
		
		JLabel lblService = new JLabel("Service");
		lblService.setBounds(34, 172, 76, 14);
		getContentPane().add(lblService);
		
		txtNom = new JTextField();
		txtNom.setBounds(120, 66, 148, 20);
		getContentPane().add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(120, 94, 148, 20);
		getContentPane().add(txtPrenom);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(120, 119, 148, 20);
		getContentPane().add(txtTel);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(120, 144, 148, 20);
		getContentPane().add(txtMail);
		
		JComboBox cmbService = new JComboBox();
		cmbService.setBounds(120, 168, 148, 22);
		getContentPane().add(cmbService);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			@Override
				public void actionPerformed(ActionEvent e) {
			}
		});
		
				
		btnAjouter.setBounds(28, 223, 82, 29);
		getContentPane().add(btnAjouter);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(212, 223, 82, 29);
		getContentPane().add(btnSupprimer);
		
		JButton btnReset = new JButton("Réinitialiser");
		btnReset.setBounds(120, 263, 82, 29);
		getContentPane().add(btnReset);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(120, 223, 82, 29);
		getContentPane().add(btnModifier);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(212, 263, 82, 29);
		getContentPane().add(btnQuitter);
		
		JButton btnAbsence = new JButton("Accès absence");
		btnAbsence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnAbsence) {
					new AbsenceFrame().setVisible(true);
					new PersonnelFrame().setVisible(false);
				}
			}
		});
		btnAbsence.setBounds(120, 307, 174, 29);
		getContentPane().add(btnAbsence);
        
	}
}

