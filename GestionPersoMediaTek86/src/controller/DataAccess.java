package controller;

import java.util.ArrayList;

import model.Personnel;

public class DataAccess {
	private static String url = "jdbc:mysql://localhost/mabase";
	private static String login = "root";
	private static String pwd = "";
	
	public static void addProduit(Personnel unPersonnel) {
		String sql = "insert into personnel (nom, prenom, tel, mail, service) values (?, ?, ?, ?, ?)";
		ArrayList<Object> lesPersos = new ArrayList<>();
		lesPersos.add(unPersonnel.getNom());
		lesPersos.add(unPersonnel.getPrenom());
		lesPersos.add(unPersonnel.getTel());
		lesPersos.add(unPersonnel.getMail());
		lesPersos.add(unPersonnel.getService());
		DBConnection cn = DBConnection.getInstance(url, login, pwd);
		cn.reqUpdate(sql, lesPersos);
		}
	
	public static ArrayList<Personnel> recupProduits() {
		String sql = "select * from personnel";
		ArrayList<Personnel> lesPersonnels = new ArrayList<>();
		DBConnection cn = DBConnection.getInstance(url, login, pwd);
		cn.reqSelect(sql, null);
		while (cn.read()) {
			Personnel unPersonnel = new Personnel();
			unPersonnel.setNom((String)cn.field("Nom"));
			unPersonnel.setPrenom((String)cn.field("Prénom"));
			unPersonnel.setTel((String)cn.field("Tel"));
			unPersonnel.setMail((String)cn.field("Mail"));
			unPersonnel.setService((String)cn.field("Service"));
		lesPersonnels.add(unPersonnel);
		}
		cn.close();
		return lesPersonnels;
		}
	
}
