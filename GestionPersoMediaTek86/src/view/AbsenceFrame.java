package view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.DataAccess;
import model.Absence;

public class AbsenceFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
    JLabel label = new JLabel("Liste des absences");
	JTable table = null;
	
	public AbsenceFrame() {
	
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	    this.setSize(700,400);
	    this.setTitle("Absences");
	    panel.setBounds(359, 30, 414, 24);
	    panel.setBackground(Color.GRAY);
	    label.setForeground(Color.white);
	    panel.add(label);	         
	    
	    /**
	     * Initialisation du JTable
	     * Récupération via la DB et initialisation des données du personnel
	    */
	    table = new JTable();
		Object[][] body = new Object[(DataAccess.recupAbsences()).size()][5];
		String [] header = {"Date début", "Nom", "Prénom", "Date fin", "Motif"} ;
		int i = 0;
		for(Absence et: (DataAccess.recupAbsences())) {
		    	body[i][0] = et.getDatedebut();
		        body[i][1] = et.getNom();
		        body[i][2] = et.getPrenom();
		        body[i][3] = et.getDatefin();
		        body[i][4] = et.getMotif();
		        i++;
		}
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(343, 0, 341, 361);
		getContentPane().add(scrollPane);
        table.setModel(new DefaultTableModel(body,header));  
            
	}

}
