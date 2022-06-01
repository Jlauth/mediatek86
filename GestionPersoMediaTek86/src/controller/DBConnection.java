package controller;

/**
 * Classe publique permettant la connexion à la DB
 * Requête de sélection et de mise à jour
 * @author Jean
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class DBConnection {
	private static DBConnection instance = null;
	private Connection cn = null;
	private ResultSet rs = null;
	
	/**
	 * Constructeur privé
	 * @param url
	 * @param login
	 * @param pwd
	 */
	private DBConnection(String url, String login, String pwd) {
		if(cn == null) {
			try {
				cn = DriverManager.getConnection(url, login, pwd);
			}catch(SQLException e) {
				System.out.println("Erreur d'accès à la BDD");
				System.exit(0);
			}
		}
	}
	
	/**
	 * On instancie le constructeur
	 * @param url
	 * @param login
	 * @param pwd
	 * @return
	 */
	public static DBConnection getInstance(String url, String login, String pwd) {
		if (instance == null) {
			instance = new DBConnection(url, login, pwd);
		}
		return instance;
	}
	
	/**
	 * A revoir cet été	
	 * @param req
	 * @param lesPersos
	 */
	public void reqUpdate(String req, List<Object> lesPersos) {
		if(cn != null) {
			try {
				PreparedStatement pst = cn.prepareStatement(req);
				if(lesPersos != null) {
					int k=1;
					for (Object perso : lesPersos) {
						pst.setObject(k++, perso);
					}
				}
				pst.executeUpdate();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	/**
	 * A revoir cet été.
	 * @param req
	 */
	public void reqSelect(String req) {
		if(cn != null) {
			try {
				PreparedStatement pst = cn.prepareStatement(req);
				rs = pst.executeQuery();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	// à revoir, mall intégré
	public boolean read() {
		if(rs != null) {
			try {
				return rs.next();
			}catch(SQLException e) {}
		}
		return false;
	}
	// à revoir, mall intégré
	public Object field(String nameField) {
		if(rs == null) {
			return null;
		}
		try {
			return rs.getObject(nameField);
			}catch(SQLException e) {
		return null;
		}
	}
	// à revoir, mall intégré
	public void close() {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				rs = null;
			}
		}
	}
	
}
