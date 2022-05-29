package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import controller.DataAccess;
import model.Personnel;

public class PersonnelFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel("Liste du Personnel");
	public static JTable table;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtTel;
	private JTextField txtMail;
	
	public PersonnelFrame() {
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(734, 485);
		this.setTitle("Gestion du personnel");
		panel.setBounds(359, 30, 711, 481);
		panel.setBackground(Color.GRAY);
		label.setForeground(Color.white);
		panel.add(label);

		/**
		 * Initialisation du JTable Récupération via la DB 
		 * Iinitialisation des données du personnel
		 */
		table = new JTable();
		Object[][] body = new Object[(DataAccess.recupPersonnels()).size()][5];
		String[] header = { "Nom", "Prenom", "Tel", "Mail", "Service" };
		int i = 0;
		for (Personnel et : (DataAccess.recupPersonnels())) {
			body[i][0] = et.getNom();
			body[i][1] = et.getPrenom();
			body[i][2] = et.getTel();
			body[i][3] = et.getMail();
			body[i][4] = et.getService();
			i++;
		}
		table.setModel(new DefaultTableModel(body, header));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().setLayout(null);
		scrollPane.setBounds(299, 26, 396, 384);
		getContentPane().add(scrollPane);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(34, 54, 76, 14);
		getContentPane().add(lblNom);

		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(34, 82, 76, 14);
		getContentPane().add(lblPrenom);

		JLabel lblTel = new JLabel("Tel");
		lblTel.setBounds(34, 107, 76, 14);
		getContentPane().add(lblTel);

		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(34, 132, 76, 14);
		getContentPane().add(lblMail);

		JLabel lblService = new JLabel("Service");
		lblService.setBounds(34, 157, 76, 14);
		getContentPane().add(lblService);
		
		txtNom = new JTextField();
		txtNom.setBounds(120, 51, 148, 20);
		txtNom.setColumns(10);
		getContentPane().add(txtNom);

		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(120, 79, 148, 20);
		getContentPane().add(txtPrenom);

		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(120, 104, 148, 20);
		getContentPane().add(txtTel);

		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(120, 129, 148, 20);
		getContentPane().add(txtMail);

		String[] service = {"administratif", "médiation culturelle", "prêt"};
		JComboBox<String> cmbService = new JComboBox<>(service);
		cmbService.setBounds(120, 153, 148, 22);
		getContentPane().add(cmbService);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Vector<String> v = new Vector<>();
					v.add(txtNom.getText());
					v.add(txtPrenom.getText());
					v.add(txtTel.getText());
					v.add(txtMail.getText());
					v.add(cmbService.getSelectedItem().toString());
					model.addRow(v);
				
			        // establish connection
			        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mediatek86", "responsable", "MediaTek86!");  
			        Statement statement = con.createStatement();  
			        statement.executeUpdate("INSERT INTO personnel(nom, prenom, tel, mail, service) VALUES('" + txtNom.getText() + "','" + txtPrenom.getText() + "','" + txtTel.getText() + "','" + txtMail.getText() + "','" + cmbService.getSelectedItem().toString() +"')");  
			        JOptionPane.showMessageDialog(null, "Record inserted...");  
			        statement.close();  
			        con.close();  
			        Referesh(); //Calling Referesh() method  
			    } catch (Exception e1) {  
			        JOptionPane.showMessageDialog(null, e1);  
			    }  
			}

			private void Referesh() {
				    txtNom.setText("");  
				    txtPrenom.setText("");  
				    txtTel.setText(""); 
				    txtMail.setText(""); 
			}
		});
		btnAjouter.setBounds(186, 199, 82, 29);
		getContentPane().add(btnAjouter);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        // establish connection  
			        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mediatek86", "responsable", "MediaTek86!");  
			        Statement statement = con.createStatement();  
			        statement.executeUpdate("DELETE FROM personnel VALUES('" + txtNom.getText() + "','" + txtPrenom.getText() + "','" + txtTel.getText() + "','" + txtMail.getText() + "','" + cmbService.getSelectedItem().toString() +"')");  
			        JOptionPane.showMessageDialog(null, "Record deleted...");  
			        statement.close();  
			        con.close();  
			        Referesh(); //Calling Referesh() method  
			    } catch (Exception el) {  
			        JOptionPane.showMessageDialog(null, el);  
			    }  
			}
			private void Referesh() {
					    txtNom.setText("");  
					    txtPrenom.setText("");  
					    txtTel.setText(""); 
					    txtMail.setText("");  
			}		
		});
		btnSupprimer.setBounds(186, 279, 82, 29);
		getContentPane().add(btnSupprimer);

		JButton btnMaj = new JButton("Mise à jour");
		btnMaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnMaj.setBounds(34, 381, 99, 29);
		getContentPane().add(btnMaj);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(186, 239, 82, 29);
		getContentPane().add(btnModifier);

		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(186, 381, 82, 29);
		getContentPane().add(btnQuitter);

		JButton btnAbsence = new JButton("Absence");
		btnAbsence.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnAbsence) {
					new AbsenceFrame().setVisible(true);
					new PersonnelFrame().setVisible(false);
				}
			}
		});
		btnAbsence.setBounds(34, 279, 82, 29);
		getContentPane().add(btnAbsence);

	}
}
