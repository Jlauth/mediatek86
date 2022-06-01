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
import javax.swing.table.DefaultTableModel;
import controller.DataAccess;
import model.Absence;
import java.awt.Font;

/**
 * Création de AbsenceFrame, hérite de JFrame
 * @author Jean
 *
 */
public class AbsenceFrame extends JFrame {

	/**
	 * Initialisation des variables composant l'interface
	 * @author Jean
	 */
	private static final long serialVersionUID = 1L;
	protected static final String String = null;
	JPanel panel = new JPanel();
    JLabel label = new JLabel("Liste des absences");
	JTable tableAbs;
	private JTextField txtNom;
	private JTextField txtPrenom;   
	private JTextField txtDebut;
	private JTextField txtFin;
	
	/**
	 * Création de la classe AbsenceFrame
	 * Comprend toutes les fonctionnalités gérées par le frame
	 */
	public AbsenceFrame() {
	
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	    this.setSize(734,485);
	    this.setTitle("Absences");
	    panel.setBounds(359, 30, 711, 250);
	    panel.setBackground(Color.lightGray);
	    label.setForeground(Color.white);
	    panel.add(label);

	    /**
	     * Initialisation du JTable
	     * Récupération via la DB et initialisation des données du personnel
	     * @param DataAccess.recupAbsences() lien avec la DB
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
		tableAbs.setModel(new DefaultTableModel(body,header)); 
		DefaultTableModel model = (DefaultTableModel) tableAbs.getModel();
		
		// initialisation afin de gérer le défilement de la table
		JScrollPane scrollPane = new JScrollPane(tableAbs);
		getContentPane().setLayout(null);
		scrollPane.setBounds(299, 26, 396, 384);
		getContentPane().add(scrollPane);
		
		// suite des différents label liés aux txtFields
		txtNom = new JTextField();
		txtNom.setBounds(120, 51, 148, 20);
		getContentPane().add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(120, 79, 148, 20);
		getContentPane().add(txtPrenom);	
		
		txtDebut =  new JTextField();
		txtDebut.setBounds(120, 104, 148, 20);
		getContentPane().add(txtDebut);
		txtDebut.setColumns(10);
		
		txtFin = new JTextField();
		txtFin.setColumns(10);
		txtFin.setBounds(120, 129, 148, 20);
		getContentPane().add(txtFin);
     
		// insertion des données dans le cmb Motif
		String[] motif = {"Congé parental", "Maladie", "Motif familial", "Vacances"};
		JComboBox<Object> cmbMotif = new JComboBox<>(motif);
		cmbMotif.setBounds(120, 157, 148, 22);
		getContentPane().add(cmbMotif);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(34, 54, 76, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom");
		lblNewLabel_1.setBounds(34, 82, 76, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Début abs");
		lblNewLabel_2.setBounds(34, 107, 76, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fin abs");
		lblNewLabel_3.setBounds(34, 132, 76, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Motif");
		lblNewLabel_3_1.setBounds(34, 161, 76, 14);
		getContentPane().add(lblNewLabel_3_1);
		
		/**
		 * Ajout des données récupérées dans la DB
		 * ActionListener sur le btnAjouter
		 * @param Vector  afin d'itérer dans la table
		 */
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAjouter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// création du vecteur de remplissage des rows
					Vector<String> vec = new Vector<>();
					vec.add(txtNom.getText());
					vec.add(txtPrenom.getText());
					vec.add(txtDebut.getText());
					vec.add(txtFin.getText());
					vec.add(cmbMotif.getSelectedItem().toString());
					DefaultTableModel model = (DefaultTableModel) tableAbs.getModel();
					model.addRow(vec);
					
					// établissement de la connection à la DB
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mediatek86", "responsableMDTK", "MediaTek86!");  
					Statement statement = con.createStatement();  
					statement.executeUpdate("INSERT INTO absence(nom, prenom, datedebut, datefin, motif) VALUES('" + txtNom.getText() + "','" + txtPrenom.getText() + "',"
							+ "'" + txtDebut.getText() + "','" + txtFin.getText() + "','" + cmbMotif.getSelectedItem().toString() +"')");  
					JOptionPane.showMessageDialog(null, "Record inserted...");  
					statement.close();  
					con.close();    
				} catch (Exception e1) {  
					JOptionPane.showMessageDialog(null, e1);  
				}
			}
		});
		btnAjouter.setBounds(186, 223, 100, 35);
		getContentPane().add(btnAjouter);
		
		/**
		 * Appel de MouseListener afin de récupérer toutes les données des rows
		 * Implémentation dans les txtFields correspondants
		 */
		tableAbs.addMouseListener((MouseListener) new MouseAdapter(){  
	        @Override
	        public void mouseClicked(MouseEvent e){
	            // i = l'index de la row sélectionnée
	            int i = tableAbs.getSelectedRow();
	            txtNom.setText((java.lang.String) model.getValueAt(i, 0));
	            txtPrenom.setText((java.lang.String) model.getValueAt(i, 1));
	            txtDebut.setText((java.lang.String) (model.getValueAt(i, 2)));
	            txtFin.setText((java.lang.String) model.getValueAt(i, 3));
	            cmbMotif.setSelectedItem(model.getValueAt(i, 4));
	        }
	        
	    });
		
		/**
		 * Suppression de la ligne de rows sélectionnés
		 * Suppression dans l'appli et la DB (en théorie toujours)
		 * ActionListener sur btnSupprimer
		 * @param getSelectedIndex()
		 */
		tableAbs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// vérification de la row sélectionnée
					if(tableAbs.getSelectedRow()!= -1) {
						// sauvegarde de la row
						int rowSelected = tableAbs.getSelectedRow();
						String selected = model.getValueAt(rowSelected, 0).toString();
						String delRow = "delete from personnel where nom='" + selected + "'";
						// suppression depuis la table de la row sélectionnée
						model.removeRow(tableAbs.getSelectedRow());
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
		 *@param getSelectedRow() permet de récupérer la sélection
		 */
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModifier.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// i = index de la row sélectionnée
                int i = tableAbs.getSelectedRow();
                if(i >= 0) 
                {
                   model.setValueAt(txtNom.getText(), i, 0);
                   model.setValueAt(txtPrenom.getText(), i, 1);
                   model.setValueAt(txtDebut.getText(), i, 2);
                   model.setValueAt(txtFin.getText(), i, 3);
                }
                else{
                    System.out.println("Update Error");
                }
			}
		});
		btnModifier.setBounds(186, 269, 100, 35);
		getContentPane().add(btnModifier);
		
		/**
		 * Vider les txtfields, réinitialisation combobox
		 * ActionListener sur btnEffacer
		 */
		JButton btnEffacer = new JButton("Vider");
		btnEffacer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    txtNom.setText("");  
				    txtPrenom.setText("");   
				    txtDebut.setText("");
				    txtFin.setText("");
				    cmbMotif.setSelectedItem(null);
				}
		});
		btnEffacer.setBounds(34, 269, 100, 35);
		getContentPane().add(btnEffacer);
		
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
		 * Retour à la page personnel via ActionListener
		 * dispose() ferme la classe et ouvre PersonnelFrame
		 */
		JButton btnRetour = new JButton("Retour Personnel");
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRetour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnRetour) {
					new PersonnelFrame().setVisible(true);
					dispose();
				}
			}
		});
		btnRetour.setBounds(34, 375, 252, 35);
		getContentPane().add(btnRetour);
		
	}

	
}
