package controller;

import java.util.ArrayList;

import model.Absence;
import model.Personnel;
import view.AbsenceFrame;
import view.LoginFrame;
import view.PersonnelFrame;

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
		ArrayList<Absence> lesAbsences = (ArrayList<Absence>) DataAccess.recupAbsences();
		for(Absence uneAbsence : lesAbsences) {
			System.out.println(uneAbsence.getDatedebut()+" "+
				uneAbsence.getNom()+" "+
				uneAbsence.getPrenom()+" "+
				uneAbsence.getDatefin()+" "+
				uneAbsence.getMotif());
			}
		
		}
		
	public static void main(String[] args) {
		/*sauverEnBase();*/
		lireEnBase();
		
		new LoginFrame().setVisible(true);
		new PersonnelFrame().setVisible(true);
		new AbsenceFrame().setVisible(true);
		}
	
}
