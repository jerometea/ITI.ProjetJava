package logical;

import java.time.LocalDate;

public class Personne {


	int id;
	String nom;
	String prenom;
	String adresse;
	LocalDate naissance;
	int codePostable;
	String tel;
	
	public Personne(){}
	
	public Personne(int pId, String pNom, String pPrenom, String pAdresse, LocalDate pDate, int pCodePostable, String pTel) {
		id = pId;
		nom = pNom;
		prenom = pPrenom;
		adresse = pAdresse;
		naissance = pDate;
		codePostable = pCodePostable;
		tel = pTel;
	}

	public int getId() {
		return id;
	}

	public void setId(int pId) {
		id = pId;
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

	public LocalDate getNaissance() {
		return naissance;
	}

	public void setNaissance(LocalDate pDate) {
		naissance = pDate;
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
