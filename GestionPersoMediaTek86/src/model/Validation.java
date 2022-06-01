package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Vérification des champs renseignés, ne peuvent être vide
 * Parcours via List et ArrayList afin de déceler des erreurs
 * @author Jean
 *
 */
public class Validation {
	
	/**
	 * Vérification si la requête login est adéquate
	 * @param login vérifie si login est vide ou non
	 * @param pwd  vérifie si le login est vide ou non
	 * @return
	 */
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
	 /**
	  * Vérification si la requête adéquate peut être effectuée
	  * @param nom vérifié si le nom est vide ou non
	  * @param prenom vérifie si le prenom est vide ou non
	  * @param tel vérifie si le tel est vide ou non
	  * @param mail vérifie si le mail est vide ou non
	  * @return
	  */
	 public List<String> validatePerso(String nom, String prenom, String tel, String mail) {
		 ArrayList<String> err = new ArrayList<>();
		 if(nom.isEmpty() && prenom.isEmpty() && tel.isEmpty() && mail.isEmpty()) {
			 err.add("Merci de remplir tous les champs");
		 }
	     return err;
	   
	}
	 /**
	  * Vérification si l'absence est valide ou non
	  * @param nom si nom est rempli
	  * @param prenom si prenom est remplli
	  * @param datedebut si datedebut remplie
	  * @param datefin si datefin remplie
	  * @return
	  */
	 public List<String> validateAbsence(String nom, String prenom, String datedebut, String datefin) {
		 ArrayList<String> err = new ArrayList<>();
		 if(nom.isEmpty() && prenom.isEmpty() && datedebut.isEmpty() && datefin.isEmpty()) {
			 err.add("Merci de remplir tous les champs");
		 }
		 return err;
	 }
}


