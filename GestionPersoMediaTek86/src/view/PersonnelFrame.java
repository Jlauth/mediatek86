package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
		lblNom.setBounds(34, 88, 76, 14);
		getContentPane().add(lblNom);

		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(34, 116, 76, 14);
		getContentPane().add(lblPrenom);

		JLabel lblTel = new JLabel("Tel");
		lblTel.setBounds(34, 141, 76, 14);
		getContentPane().add(lblTel);

		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(34, 166, 76, 14);
		getContentPane().add(lblMail);

		JLabel lblService = new JLabel("Service");
		lblService.setBounds(34, 191, 76, 14);
		getContentPane().add(lblService);
		
		txtNom = new JTextField();
		txtNom.setBounds(120, 85, 148, 20);
		txtNom.setColumns(10);
		getContentPane().add(txtNom);

		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(120, 113, 148, 20);
		getContentPane().add(txtPrenom);

		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(120, 138, 148, 20);
		getContentPane().add(txtTel);

		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(120, 163, 148, 20);
		getContentPane().add(txtMail);

		String[] service = {"Administratif", "Médiation culturelle", "Prêt"};
		JComboBox<Object> cmbService = new JComboBox<>(service);
		cmbService.setBounds(120, 187, 148, 22);
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
			        statement.executeUpdate("INSERT INTO personnel(nom, prenom, tel, mail, service) VALUES('" + txtNom.getText() + "',"
			        		+ "'" + txtPrenom.getText() + "','" + txtTel.getText() + "',"
			        		+ "'" + txtMail.getText() + "','" + cmbService.getSelectedItem().toString() +"')");  
			        JOptionPane.showMessageDialog(null, "Record inserted...");  
			        statement.close();  
			        con.close();  
			        // Referesh(); //Calling Referesh() method  
			    } catch (Exception e1) {  
			        JOptionPane.showMessageDialog(null, e1);  
			    }  
			}
		});
		btnAjouter.setBounds(184, 260, 82, 29);
		getContentPane().add(btnAjouter);

		table.addMouseListener((MouseListener) new MouseAdapter(){
	        
	        @Override
	        public void mouseClicked(MouseEvent e){
	            
	            // i = the index of the selected row
	            int i = table.getSelectedRow();
	            
	            txtNom.setText(model.getValueAt(i, 0).toString());
	            txtPrenom.setText(model.getValueAt(i, 1).toString());
	            txtTel.setText(model.getValueAt(i, 2).toString());
	            txtMail.setText(model.getValueAt(i, 3).toString());
	            cmbService.setSelectedItem(model.getValueAt(i, 4).toString());
	        }
	        
	    });
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
			        // establish connection  
			        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mediatek86", "responsable", "MediaTek86!");  
			        Statement statement = con.createStatement();  
			        statement.executeUpdate("DELETE FROM personnel(nom, prenom, tel, mail, service) VALUES('" + txtNom.getText() + "','" + txtPrenom.getText() + "','" + txtTel.getText() + "','" + txtMail.getText() + "','" + cmbService.getSelectedItem().toString() +"')");  
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
		btnSupprimer.setBounds(184, 341, 82, 29);
		getContentPane().add(btnSupprimer);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // i = the index of the selected row
                int i = table.getSelectedRow();
                if(i >= 0) 
                {
                   model.setValueAt(txtNom.getText(), i, 0);
                   model.setValueAt(txtPrenom.getText(), i, 1);
                   model.setValueAt(txtTel.getText(), i, 2);
                   model.setValueAt(txtMail.getText(), i, 3);
                }
                else{
                    System.out.println("Update Error");
                }
            }
        });
		btnModifier.setBounds(184, 300, 82, 29);
		getContentPane().add(btnModifier);
		
		JButton btnViderCases = new JButton("Effacer");
		btnViderCases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    txtNom.setText("");  
				    txtPrenom.setText("");  
				    txtTel.setText(""); 
				    txtMail.setText(""); 
				    cmbService.setSelectedItem(1);
				}
		});
		btnViderCases.setBounds(184, 381, 84, 29);
		getContentPane().add(btnViderCases);
		

		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(34, 381, 82, 29);
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
		btnAbsence.setBounds(34, 341, 82, 29);
		getContentPane().add(btnAbsence);

	}
}
