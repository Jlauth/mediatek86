package controller;

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
	
	public static DBConnection getInstance(String url, String login, String pwd) {
		if (instance == null) {
			instance = new DBConnection(url, login, pwd);
		}
		return instance;
	}
	
		
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
	
	public boolean read() {
		if(rs != null) {
			try {
				return rs.next();
			}catch(SQLException e) {}
		}
		return false;
	}
	
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
