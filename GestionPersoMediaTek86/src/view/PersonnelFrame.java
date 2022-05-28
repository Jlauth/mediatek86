package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	JPanel panel = new JPanel();
	JLabel label = new JLabel("Liste du Personnel");
	JTable table = null;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtTel;
	private JTextField txtMail;

	public PersonnelFrame() {

		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(734, 485);
		this.setTitle("Liste actualisée du personnel");
		panel.setBounds(359, 30, 711, 481);
		panel.setBackground(Color.GRAY);
		label.setForeground(Color.white);
		panel.add(label);

		/**
		 * Initialisation du JTable Récupération via la DB et initialisation des données
		 * du personnel
		 */
		table = new JTable();
		Object[][] body = new Object[(DataAccess.recupPersonnels()).size()][5];
		String[] header = { "Nom", "Prénom", "Tel", "Mail", "Service" };
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

		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().setLayout(null);
		scrollPane.setBounds(299, 26, 396, 384);
		getContentPane().add(scrollPane);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(34, 54, 76, 14);
		getContentPane().add(lblNom);

		JLabel lblPrenom = new JLabel("Prénom");
		lblPrenom.setBounds(34, 82, 76, 14);
		getContentPane().add(lblPrenom);

		JLabel lblTel = new JLabel("Téléphone");
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

		String[] service = {"Administratif", "Médiation culturelle", "Prêt"};
		JComboBox<Object> cmbService = new JComboBox<>(service);
		cmbService.setBounds(120, 153, 148, 22);
		getContentPane().add(cmbService);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<String> v = new Vector<String>();
				v.add(txtNom.getText());
				v.add(txtPrenom.getText());
				v.add(txtTel.getText());
				v.add(txtMail.getText());
				v.add(cmbService.getSelectedItem().toString());
				
				DefaultTableModel dt = (DefaultTableModel) table.getModel();
				dt.addRow(v);
			}
		});
		btnAjouter.setBounds(186, 199, 82, 29);
		getContentPane().add(btnAjouter);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(186, 279, 82, 29);
		getContentPane().add(btnSupprimer);

		JButton btnReset = new JButton("Effacer");
		btnReset.setBounds(34, 381, 82, 29);
		getContentPane().add(btnReset);

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
