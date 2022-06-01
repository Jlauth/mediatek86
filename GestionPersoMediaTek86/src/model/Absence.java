package model;

public class Absence {
	
	
	private String datedebut;
	private String datefin;
	private String nom;
	private String prenom;
	private String motif;
	
	/**
	 * @return the datedebut
	 */
	public String getDatedebut() {
		return datedebut;
	}
	
	/**
	 * @return the datefin
	 */
	public String getDatefin() {
		return datefin;
	}
	
	/**
	 * @param string the datefin to set
	 */
	
	public void setDatefin(String datefin) {
		this.datefin = datefin;
	}
	
	/**
	 * @param string the datedebut to set
	 */
	public void setDatedebut(String datedebut) {
		this.datedebut = datedebut;
	}
	
	/**
	 * @return
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}
	/**
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

}