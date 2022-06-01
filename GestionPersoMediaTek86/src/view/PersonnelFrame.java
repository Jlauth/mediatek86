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
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import controller.DataAccess;
import model.Personnel;
import java.awt.Font;

public class PersonnelFrame extends JFrame {

	/**
	 * Initialisation des objets de PersonnelFrame
	 * @author Jean
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel("Liste du Personnel");
	public static JTable table;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtTel;
	private JTextField txtMail;
	
	/**
	 * Initialisation de la classe PersonnelFrame
	 * Création des objets de la classe PersonnelFrame
	 */
	public PersonnelFrame() {
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(734, 485);
		this.setTitle("Gestion du personnel");
		panel.setBounds(359, 30, 300, 250);
		panel.setBackground(Color.lightGray);
		label.setForeground(Color.white);
		panel.add(label);
		
		
		/**
		 * Initialisation du JTable Récupération via la DB 
		 * Iinitialisation des données du personnel
		 * DataAccess.recupPersonnels() lien avec la DB
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
		
		// initialisation afin de gérer le défilement de la table
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().setLayout(null);
		scrollPane.setBounds(299, 26, 396, 384);
		getContentPane().add(scrollPane);
		
		// suite des différents label liés aux txtFields
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
		lblService.setBounds(34, 161, 76, 14);
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

		// insertion des données dans le cmb Service
		String[] service = {"Administratif", "Médiation culturelle", "Prêt"};
		JComboBox<Object> cmbService = new JComboBox<>(service);
		cmbService.setBounds(120, 157, 148, 22);
		getContentPane().add(cmbService);
		
		/**
		 * Ajoutt des données récupérées en DB dans la table
		 * ActionListener btnAjouter 
		 * Vector afin d'itérer dans la table
		 */
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAjouter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// création du vecteur de remplissage des rows
					Vector<String> v = new Vector<>();
					v.add(txtNom.getText());
					v.add(txtPrenom.getText());
					v.add(txtTel.getText());
					v.add(txtMail.getText());
					v.add(cmbService.getSelectedItem().toString());
					model.addRow(v);
				
			        // établissement de la connection à la DB
			        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mediatek86", "responsableMDTK", "MediaTek86!");  
			        Statement statement = con.createStatement();  
			        statement.executeUpdate("INSERT INTO personnel(nom, prenom, tel, mail, service) VALUES('" + txtNom.getText() + "','" + txtPrenom.getText() + "','" + txtTel.getText() + "','" + txtMail.getText() + "','" + cmbService.getSelectedItem().toString() +"')");  
			        JOptionPane.showMessageDialog(null, "Record inserted...");  
			        statement.close();  
			        con.close();   
			    } catch (Exception e1) {  
			        JOptionPane.showMessageDialog(null, e1);  
			    }  
			}
		});
		btnAjouter.setBounds(186, 222, 100, 35);
		getContentPane().add(btnAjouter);
		
		/**
		 * Appel de MouseListener afin de récupérer toutes les données des rows
		 * Implémentation dans les txtFields correspondants
		 */
		table.addMouseListener((MouseListener) new MouseAdapter(){  
	        @Override
	        public void mouseClicked(MouseEvent e){
	        	// i = l'index de la row sélectionnée
	            int i = table.getSelectedRow();
	            txtNom.setText(model.getValueAt(i, 0).toString());
	            txtPrenom.setText(model.getValueAt(i, 1).toString());
	            txtTel.setText(model.getValueAt(i, 2).toString());
	            txtMail.setText(model.getValueAt(i, 3).toString());
	            cmbService.setSelectedItem(model.getValueAt(i, 4).toString());
	        }
	        
	    });
		
		/**
		 * Suppression de la ligne de rows sélectionnés
		 * Suppression dans l'appli et la DB (en théorie...)
		 * ActionListener sur btnSupprimer
		 */
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// vérification de la row sélectionnée
					if(table.getSelectedRow() != -1) {
						// sauvegarde de la row 
						int rowSelected = table.getSelectedRow();
						String selected = model.getValueAt(rowSelected, 0).toString();
						String delRow = "delete from personnel where nom='" + selected + "'";
						// suppression depuis la table de la row sélectionnée
						model.removeRow(table.getSelectedRow());
						JOptionPane.showMessageDialog(null, "Deleted successfully");
						// établissement de la connexion
						Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mediatek86", "responsableMDTK", "MediaTek86!");  
						Statement statement = con.createStatement();  
						// suppression dans la DB
						statement.executeUpdate(delRow);
						JOptionPane.showMessageDialog(null, "Record deleted...");  
						statement.close();  
						con.close();
						}
			    	} catch (Exception el) {  
			    		JOptionPane.showMessageDialog(null, el);  
			    	} 
				}
		});		
		btnSupprimer.setBounds(186, 315, 100, 35);
		getContentPane().add(btnSupprimer);
		
		/**
		 * Modification des rows sélectionnées
		 * ActionListener sur btnModifier
		 * getSelectedRow() permet de récupérer la sélection
		 */
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModifier.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	// i = index de la row sélectionnée
                int i = table.getSelectedRow();
                if(i >= 0) 
                {
                   model.setValueAt(txtNom.getText(), i, 0);
                   model.setValueAt(txtPrenom.getText(), i, 1);
                   model.setValueAt(txtTel.getText(), i, 2);
                   model.setValueAt(txtMail.getText(), i, 3);
                   model.setValueAt(cmbService.getSelectedItem(), i, 4);
                }
                else{
                    System.out.println("Update Error");
                }
            }
        });
		btnModifier.setBounds(187, 268, 100, 35);
		getContentPane().add(btnModifier);
		
		/**
		 * Vider les txtfields, réinitialisation combobox
		 * ActionListener sur btnViderCases
		 */
		JButton btnViderCases = new JButton("Vider");
		btnViderCases.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnViderCases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    txtNom.setText("");  
				    txtPrenom.setText("");  
				    txtTel.setText(""); 
				    txtMail.setText(""); 
				    cmbService.setSelectedItem(null);
				}
		});
		btnViderCases.setBounds(34, 268, 100, 35);
		getContentPane().add(btnViderCases);
		
		/**
		 * Quitter totalement l'application via dispose()
		 * ActionListener sur btnQuitter
		 */
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuitter.setBounds(34, 315, 100, 35);
		getContentPane().add(btnQuitter);

		/**
		 * Accès à la page des absences via ActionListener
		 * dispose() ferme la classe et ouvre AbsenceFrame
		 */
		JButton btnAbsence = new JButton("Accès Absence");
		btnAbsence.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAbsence.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnAbsence) {
					new AbsenceFrame().setVisible(true);
					dispose();
				}
			}
		});
		btnAbsence.setBounds(34, 375, 252, 35);
		getContentPane().add(btnAbsence);

	}
}
