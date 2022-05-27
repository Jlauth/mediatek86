package controller;

import java.util.ArrayList;
import java.util.List;

import model.Personnel;

public class DataAccess {
	private static String url = "jdbc:mysql://localhost/mediatek86";
	private static String login = "responsable";
	private static String pwd = "MediaTek86!";
	
	public static void addPersonnel(Personnel unPersonnel) {
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
	
	public static List<Personnel> recupPersonnels() {
		String sql = "select * from personnel";
		ArrayList<Personnel> lesPersonnels = new ArrayList<>();
		DBConnection cn = DBConnection.getInstance(url, login, pwd);
		cn.reqSelect(sql, null);
		while (cn.read()) {
			Personnel unPersonnel = new Personnel();
			unPersonnel.setNom((String)cn.field("Nom"));
			unPersonnel.setPrenom((String)cn.field("Prenom"));
			unPersonnel.setTel((String)cn.field("Tel"));
			unPersonnel.setMail((String)cn.field("Mail"));
			unPersonnel.setService((String)cn.field("Service"));
			lesPersonnels.add(unPersonnel);
		}
		cn.close();
		return lesPersonnels;
		}
	
	 public static List<Personnel> afficher(){
		 String sql = "select * from personnel";
	     ArrayList<Personnel> perso = new ArrayList<>();
	     DBConnection cn = DBConnection.getInstance(url, login, pwd);
	     cn.reqSelect(sql, null);
	     while(cn.read()) {
	        Personnel unPersonnel = new Personnel();
	        unPersonnel.setNom((String)cn.field("Nom"));
			unPersonnel.setPrenom((String)cn.field("Prenom"));
			unPersonnel.setTel((String)cn.field("Tel"));
			unPersonnel.setMail((String)cn.field("Mail"));
			unPersonnel.setService((String)cn.field("Service"));
			perso.add(unPersonnel);
	     }
	     return perso;
	 }

}
