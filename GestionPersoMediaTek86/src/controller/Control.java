package controller;

import java.util.ArrayList;

import model.Absence;
import model.Personnel;
import view.LoginFrame;

public class Control {
	
	public static void sauverEnBase() {
		// construction du personnel
		Personnel unPersonnel = new Personnel();
		unPersonnel.setNom("");
		unPersonnel.setPrenom("");
		unPersonnel.setTel("");
		unPersonnel.setMail("");
		unPersonnel.setService("");
		// demande d'ajout du personnel
	}

	
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
		//sauverEnBase();
		//lireEnBase();
		
		new LoginFrame().setVisible(true);
		}
	
}
