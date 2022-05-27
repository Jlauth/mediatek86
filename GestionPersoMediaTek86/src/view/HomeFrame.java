package view;

import java.awt.BorderLayout;
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
	JPanel p = new JPanel();
	JLabel label = new JLabel("Liste du Personnel");     
	JTable table = null;
	     
	public HomeFrame() {
		this.setLocationRelativeTo(null);
	    this.setSize(700,400);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setTitle("MediaTek86");
	    label.setForeground(Color.white);
	    p.setBackground(Color.BLACK);
	    p.add(label);
	    getContentPane().add(p, BorderLayout.NORTH);
	         
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
	        getContentPane().add(new JScrollPane(table));
	        table.setModel(new DefaultTableModel(body,header));
	    }
	
}
