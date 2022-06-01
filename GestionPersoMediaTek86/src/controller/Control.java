package controller;
/**
 * Controlleur de l'app comportant la Main Class
 */
import java.util.ArrayList;

import model.Absence;
import model.Personnel;
import view.LoginFrame;

/**
 * Classe publique Control qui gère l'initialisation de l'app
 * @author Jean
 *
 */
public class Control {
	
	
	public static void lireEnBase() {
		ArrayList<Personnel> lesPersonnels = (ArrayList<Personnel>) DataAccess.recupPersonnels();
		for(Personnel unPersonnel : lesPersonnels) {
			System.out.println(unPersonnel.getNom()+" "+
			unPersonnel.getPrenom()+" "+
			unPersonnel.getTel()+" "+
			unPersonnel.getMail()+" "+
			unPersonnel.getService());
		
		
		ArrayList<Absence> lesAbsences = (ArrayList<Absence>) DataAccess.recupAbsences();
		for(Absence uneAbsence : lesAbsences) {
			System.out.println(uneAbsence.getDatedebut()+" "+
				uneAbsence.getNom()+" "+
				uneAbsence.getPrenom()+" "+
				uneAbsence.getDatedebut()+" "+
				uneAbsence.getDatefin()+" "+
				uneAbsence.getMotif());
			}
		}
	}

		
	public static void main(String[] args) {
		lireEnBase();	
		new LoginFrame().setVisible(true);
		
		}
	
}