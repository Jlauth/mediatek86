package controller;

import java.util.ArrayList;

import model.Personnel;
import view.HomeFrame;
import view.LoginFrame;

public class Control {
	
	/*public static void sauverEnBase() {
		// construction du personnel
		Personnel unPersonnel = new Personnel();
		unPersonnel.setNom("azea");
		unPersonnel.setPrenom("a'ea");
		unPersonnel.setTel("aze");
		unPersonnel.setMail("aez");
		unPersonnel.setService("aze");
		// demande d'ajout du personnel
		DataAccess.addPersonnel(unPersonnel);
		}
	*/
	
	public static void lireEnBase() {
		ArrayList<Personnel> lesPersonnels = (ArrayList<Personnel>) DataAccess.recupPersonnels();
		for(Personnel unPersonnel : lesPersonnels) {
		System.out.println(unPersonnel.getNom()+" "+
				unPersonnel.getPrenom()+" "+
				unPersonnel.getTel()+" "+
				unPersonnel.getMail()+" "+
				unPersonnel.getService());
		}
	}
	
	public static void main(String[] args) {
		/*sauverEnBase();*/
		lireEnBase();
		
		LoginFrame frame = new LoginFrame();
		frame.setVisible(true);
		
		new HomeFrame().setVisible(true);
		}
}
