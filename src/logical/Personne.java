package logical;

import java.sql.Date;

public class Personne {


	String nom;
	String prenom;
	String adresse;
	Date naissance;
	int codePostable;
	String tel;
	
	public Personne(String pNom, String pPrenom, String pAdresse, Date pNaissance, int pCodePostable, String pTel) {
		super();
		nom = pNom;
		prenom = pPrenom;
		adresse = pAdresse;
		naissance = pNaissance;
		codePostable = pCodePostable;
		tel = pTel;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String pNom) {
		nom = pNom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String pPrenom) {
		prenom = pPrenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String pAdresse) {
		adresse = pAdresse;
	}

	public Date getNaissance() {
		return naissance;
	}

	public void setNaissance(Date pNaissance) {
		naissance = pNaissance;
	}

	public int getCodePostable() {
		return codePostable;
	}

	public void setCodePostable(int pCodePostable) {
		codePostable = pCodePostable;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String pTel) {
		tel = pTel;
	}
	
}
