package model;
/**
 * Classe Personnel, gestion de l'identité des salariés
 * @author Jean
 *
 */
public class Personnel {
	
	/**
	 * Construction des objets de la classe Personnel
	 */
	
	private String nom;
	private String prenom;
	private String tel;
	private String mail;
	private String service;
	
	/**
	 * Getter sur le nom du personnel
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * Setter sur le nom du personnel
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * Getter sur le prenom du personnel
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * Setter sur le prenom du personnel
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * Getter sur le numéro de téléphone du personnel
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}
	/**Setter sur le téléphone du personnel
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**Getter sur le mail du personnel
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**Setter sur le mail du personnel
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**Getter sur le service du personnel
	 * @return the service
	 */
	public String getService() {
		return service;
	}
	/**Setter sur le service du personnel
	 * @param service the service to set
	 */
	public void setService(String service) {
		this.service = service;
	}
	
}
