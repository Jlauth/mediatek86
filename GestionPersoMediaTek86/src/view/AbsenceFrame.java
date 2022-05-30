package view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.DataAccess;
import model.Absence;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class AbsenceFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
    JLabel label = new JLabel("Liste des absences");
	JTable tableAbs = null;
	private JTextField txtNom;
	private JTextField txtPrenom;
	
	public AbsenceFrame() {
	
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	    this.setSize(771,451);
	    this.setTitle("Absences");
	    panel.setBounds(359, 30, 414, 24);
	    panel.setBackground(Color.GRAY);
	    label.setForeground(Color.white);
	    panel.add(label);
	    
	    /**
	     * Initialisation du JTable
	     * Récupération via la DB et initialisation des données du personnel
	    */
	    tableAbs = new JTable();
		Object[][] body = new Object[(DataAccess.recupAbsences()).size()][5];
		String [] header = {"Nom", "Prénom", "Date début", "Date fin", "Motif"} ;
		int i = 0;
		for(Absence et: (DataAccess.recupAbsences())) {
		        body[i][0] = et.getNom();
		        body[i][1] = et.getPrenom();
		        body[i][2] = et.getDatedebut();
		        body[i][3] = et.getDatefin();
		        body[i][4] = et.getMotif();
		        i++;
		}
		getContentPane().setLayout(null);
		tableAbs.setModel(new DefaultTableModel(body,header)); 
		
		JScrollPane scrollPane = new JScrollPane(tableAbs);
		scrollPane.setBounds(376, 11, 341, 361);
		getContentPane().add(scrollPane);
		
		JDateChooser dtcDebut = new JDateChooser();
		dtcDebut.setBounds(155, 115, 115, 20);
		getContentPane().add(dtcDebut);
		
		JDateChooser dtcFin = new JDateChooser();
		dtcFin.setBounds(155, 146, 115, 20);
		getContentPane().add(dtcFin);
		
		txtNom = new JTextField();
		txtNom.setBounds(155, 53, 115, 20);
		getContentPane().add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(155, 84, 115, 20);
		getContentPane().add(txtPrenom);	
		
		String[] motif = {"Congé parental", "Maladie", "Motif familial", "Vacances"};
		JComboBox<Object> cmbMotif = new JComboBox<>(motif);
		cmbMotif.setBounds(155, 177, 115, 22);
		getContentPane().add(cmbMotif);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(42, 56, 79, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom");
		lblNewLabel_1.setBounds(42, 87, 79, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Début absence");
		lblNewLabel_2.setBounds(42, 115, 79, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fin absence");
		lblNewLabel_3.setBounds(42, 141, 79, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Motif");
		lblNewLabel_3_1.setBounds(42, 181, 79, 14);
		getContentPane().add(lblNewLabel_3_1);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					/**java.util.Date dtcDebut = new java.util.Date();
					java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
					Date DateDebut = sdf.format(dtcDebut).toString();
					Date DateFin = sdf.format(dtcFin);*/
				
					Vector<String> v = new Vector<>();
					v.add(txtNom.getText());
					v.add(txtPrenom.getText());
					v.add(dtcDebut.getDate().toString());
					v.add(dtcFin.getDate().toString());
					v.add(cmbMotif.getSelectedItem().toString());
					DefaultTableModel model = (DefaultTableModel) tableAbs.getModel();
					model.addRow(v);
				
					// establish connection
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mediatek86", "responsable", "MediaTek86!");  
					Statement statement = con.createStatement();  
					statement.executeUpdate("INSERT INTO absence(nom, prenom, datedebut, datefin, motif) VALUES('" + txtNom.getText() + "','" + txtPrenom.getText() + "','" + dtcDebut.getDate().toString() + "','" + dtcFin.getDate().toString() + "',"
									+ "'" + cmbMotif.getSelectedItem().toString() +"')");  
					JOptionPane.showMessageDialog(null, "Record inserted...");  
					statement.close();  
					con.close();  
					// Referesh(); //Calling Referesh() method  
				} catch (Exception e1) {  
					JOptionPane.showMessageDialog(null, e1);  
				}
			}
		});
		btnAjouter.setBounds(10, 252, 97, 34);
		getContentPane().add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModifier.setBounds(10, 297, 97, 34);
		getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        // establish connection  
			        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mediatek86", "responsable", "MediaTek86!");  
			        Statement statement = con.createStatement();  
			        statement.executeUpdate("DELETE FROM absence VALUES('" + txtNom.getText() + "',"
			        		+ "'" + txtPrenom.getText() + "','" + dtcDebut.getDate().toString() + "',"
			        		+ "'" + dtcFin.getDate().toString() + "','" + cmbMotif.getSelectedItem().toString() +"')");  
			        JOptionPane.showMessageDialog(null, "Record deleted...");  
			        statement.close();  
			        con.close();  
			        Referesh(); //Calling Referesh() method  
			    } catch (Exception el) {  
			        JOptionPane.showMessageDialog(null, el);  
			    }  
			}
			@SuppressWarnings("unchecked")
			private void Referesh() {
					    txtNom.setText("");  
					    txtPrenom.setText("");  
			}
		});
		
		btnSupprimer.setBounds(10, 342, 97, 34);
		getContentPane().add(btnSupprimer);
		
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.setBounds(200, 252, 97, 34);
		getContentPane().add(btnEffacer);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(200, 297, 97, 34);
		getContentPane().add(btnQuitter);
		
		JButton btnPersonnel = new JButton("Personnel");
		btnPersonnel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnPersonnel) {
					new AbsenceFrame().setVisible(false);
					new PersonnelFrame().setVisible(true);
				}
			}
		});
		btnPersonnel.setBounds(200, 342, 97, 34);
		getContentPane().add(btnPersonnel);
     
	}
}
