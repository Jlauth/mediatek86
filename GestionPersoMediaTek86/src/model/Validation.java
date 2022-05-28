package model;

import java.util.ArrayList;
import java.util.List;

public class Validation {
	 public List<String> validateLogin(String login, String pwd) {
	        ArrayList<String> err = new ArrayList<>();
	        if (login.isEmpty()) {
	            err.add("Login can not be empty");
	        } else if (login.length() < 4) {
	            err.add("Login is too short");
	        } else if (login.length() > 20) {
	            err.add("Login is too long");
	        }
	        if (pwd.isEmpty()) {
	            err.add("Password can not be empty");
	        } else if (pwd.length() < 4) {
	            err.add("Password is too short");
	        } else if (pwd.length() > 20) {
	            err.add("Password is too long");
	        }
	        return err;
	    }
	 
	 public List<String> validatePerso(String nom, String prenom, String tel, String mail, String cmbservice) {
		 ArrayList<String> er = new ArrayList<>();
		 
	     return er;
	   
	}
}


