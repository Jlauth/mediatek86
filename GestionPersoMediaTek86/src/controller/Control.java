package controller;

import java.util.ArrayList;

import model.Personnel;

public class Control {
	public static void sauverEnBase() {
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
	
	public static void lireEnBase() {
		ArrayList<Personnel> lesPersonnels = DataAccess.recupPersonnels();
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
		}
}
