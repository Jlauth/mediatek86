package model;

import java.util.ArrayList;
import java.util.List;

public class Validation {
	 public List<String> validateLogin(String login, String pwd) {
	        ArrayList<String> err = new ArrayList<>();
	        if (login.isEmpty()) {
	            err.add("Login ne peut être vide");
	        }
	        if (pwd.isEmpty()) {
	            err.add("Password ne peut être vide");
	        }
	        return err;
	    }
	 
	 public List<String> validatePerso(String nom, String prenom, String tel, String mail) {
		 ArrayList<String> err = new ArrayList<>();
		 if(nom.isEmpty() && prenom.isEmpty() && tel.isEmpty() && mail.isEmpty()) {
			 err.add("Merci de remplir tous les champs");
		 }
	     return err;
	   
	}
	 
	 public List<String> validateAbsence(String nom, String prenom, String datedebut, String datefin) {
		 ArrayList<String> err = new ArrayList<>();
		 if(nom.isEmpty() && prenom.isEmpty() && datedebut.isEmpty() && datefin.isEmpty()) {
			 err.add("Merci de remplir tous les champs");
		 }
		 return err;
	 }
}


