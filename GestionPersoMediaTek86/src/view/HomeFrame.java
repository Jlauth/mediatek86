package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.DataAccess;
import model.Personnel;

public class HomeFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
    JLabel label = new JLabel("Liste du Personnel");
	JTable table = null;
	
	public HomeFrame() {
	
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
		Object[][] body = new Object[(DataAccess.afficher()).size()][5];
		String [] header = {"Nom", "Prénom", "Tel", "Mail", "Service"} ;
		int i = 0;
		for(Personnel et: (DataAccess.afficher())) {
		    	body[i][0] = et.getNom();
		        body[i][1] = et.getPrenom();
		        body[i][2] = et.getTel();
		        body[i][3] = et.getMail();
		        body[i][4] = et.getService();
		        i++;
		}
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(343, 0, 341, 361);
		getContentPane().add(scrollPane);
        table.setModel(new DefaultTableModel(body,header));  
        
        
        
        
	}
					
}

