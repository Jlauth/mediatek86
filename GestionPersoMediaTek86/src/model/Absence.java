package model;

import java.sql.Date;

public class Absence {
	private Date datedebut;
	private Date datefin;
	private String nom;
	private String prenom;
	private String motif;
	
	/**
	 * @return the datedebut
	 */
	public Date getDatedebut() {
		return datedebut;
	}
	/**
	 * @param datedebut the datedebut to set
	 */
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	/**
	 * @return the datefin
	 */
	public Date getDatefin() {
		return datefin;
	}
	/**
	 * @param datefin the datefin to set
	 */
	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	/**
	 * @return the nom
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
