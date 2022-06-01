package model;
/**
 * Classe du responsable ayant accès à l'app
 * @author Jean
 *
 */
public class Responsable {
	
	/**
	 * Objets liés à la classe responsable
	 */
	private String login;
	private String pwd;
	/**
	 * Getter sur le login du responsable
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**Setter sur le login du responsable 
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**Getter sur le mot de passe du responsable
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**Setter sur le mot de passe du responsable
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
