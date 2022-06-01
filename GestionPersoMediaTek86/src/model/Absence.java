package model;

/**
 * Création de la classe publique Absence
 * @author Jean
 *
 */
public class Absence {
	
	/**
	 * Construction des objets privés de la classe Absence
	 * @author Jean
	 */
	private String datedebut; // datedebut au format String en attendant le passage en Date
	private String datefin;   // pareil que pour datedebu
	private String nom; 	  // initialisation du nom en String
	private String prenom;    // initialisation du prenom enString
	private String motif;     // initialisation du motif en String
	
	/**
	 * Getter sur la date de début d'absence
	 * @return the datedebut
	 */
	public String getDatedebut() {
		return datedebut;
	}	
	/**
	 * Getter sur la date de fin d'absence
	 * @return the datefin
	 */
	public String getDatefin() {
		return datefin;
	}
	/**
	 * Setter sur la date de début d'absence
	 * @param datedebut the datedebut to set
	 */
	public void setDatedebut(String datedebut) {
		this.datedebut = datedebut;
	}
	/**
	 * Setter sur la date de fin d'absence
	 * @param datefin the datefin to set
	 */
	public void setDatefin(String datefin) {
		this.datefin = datefin;
	}
	
	/**
	 * Getter sur le nom du personne absent
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Setter sur le nom du personnel absent
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Getter sur le prenom du personnel absent
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * Setter sur le prenom du personnel absent
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * Getter sur le motif de l'absence
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}
	
	/**
	 * Setter sur le motif de l'absence
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

}