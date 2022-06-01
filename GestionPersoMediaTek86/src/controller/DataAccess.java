package controller;

import java.util.ArrayList;
import java.util.List;

import model.Absence;
import model.Personnel;
import model.Responsable;

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
	
	
	public static void addAbsence(Absence uneAbsence) {
		String sql = "insert into absence (nom, prenom, datedebut, datefin, motif) values (?, ?, ?, ?, ?)";
		ArrayList<Object> lesAbsences = new ArrayList<>();
		lesAbsences.add(uneAbsence.getNom());
		lesAbsences.add(uneAbsence.getPrenom());
		lesAbsences.add(uneAbsence.getDatedebut());
		lesAbsences.add(uneAbsence.getDatefin());
		lesAbsences.add(uneAbsence.getMotif());
		DBConnection cn = DBConnection.getInstance(url, login, pwd);
		cn.reqUpdate(sql, lesAbsences);
		}
	
	public static List<Personnel> recupPersonnels() {
		String sql = "select * from personnel";
		ArrayList<Personnel> lesPersonnels = new ArrayList<>();
		DBConnection cn = DBConnection.getInstance(url, login, pwd);
		cn.reqSelect(sql);
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
	
	public static List<Absence> recupAbsences() {
		String sql = "select * from absence";
		ArrayList<Absence> lesAbsences = new ArrayList<>();
		DBConnection cn = DBConnection.getInstance(url, login, pwd);
		cn.reqSelect(sql);	
		while (cn.read()) {
			Absence uneAbsence = new Absence();
			uneAbsence.setNom((String)cn.field("Nom"));
			uneAbsence.setPrenom((String)cn.field("Prenom"));
			uneAbsence.setDatedebut((String)cn.field("Date début"));
			uneAbsence.setDatefin((String)cn.field("Date fin"));
			uneAbsence.setMotif((String)cn.field("Motif"));
			lesAbsences.add(uneAbsence);
		}
		cn.close();
		return lesAbsences;
	}
	
	public static List<Responsable> recupResponsable() {
		String sql = "select * from responsable";
		ArrayList<Responsable> leResponsable = new ArrayList<>();
		DBConnection cn = DBConnection.getInstance(url, login, pwd);
		cn.reqSelect(sql);
		while (cn.read()) {
			Responsable unResponsable = new Responsable();
			unResponsable.setLogin((String)cn.field("Login"));
			unResponsable.setPwd((String)cn.field("Password"));
			leResponsable.add(unResponsable);
		}
		cn.close();
		return leResponsable;
	
	}
	
	

}
