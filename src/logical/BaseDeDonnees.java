package logical;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;


public class BaseDeDonnees {
	
	private Connection con;
	
	
	public void getConnection(String pForname, String pDriverName,
			String pUserDataBase, String pPasswordDataBase) throws 
	ClassNotFoundException, SQLException{
		Class.forName(pForname);
		con = (Connection)
		DriverManager.getConnection(pDriverName,pUserDataBase,pPasswordDataBase);
	}

	
		public boolean logging (String pseudo, String password) throws SQLException, ParseException
	{
		PreparedStatement ps = con.prepareStatement("select * from admin where pseudo = ? AND mdp = ?");
		ps.setString(1, pseudo);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		
		rs.last();
		
		if (rs.getRow() > 0) return true;
		return false;}
	
		
	// Recupérer toutes les personnes
	public ArrayList<Personne> GetEverybody() throws SQLException{
		java.sql.PreparedStatement ps = con.prepareStatement("SELECT * FROM personne");
		ResultSet rs = ps.executeQuery();
		ArrayList<Personne> listPersonne = new ArrayList<Personne>();
		while (rs.next()){
			Personne personne = new Personne();
			personne.setId(rs.getInt("id"));
			personne.setNom(rs.getString("nom"));
			personne.setPrenom(rs.getString("prenom"));
			personne.setNaissance(rs.getDate("date_naissance").toLocalDate());
			personne.setAdresse(rs.getString("adresse"));
			personne.setCodePostable(rs.getInt("code_postale"));
			personne.setTel(rs.getString("numero_tel"));
			listPersonne.add(personne);
		}
		return listPersonne;		
	}
	
	// Insérer une personne
	public int insertPersonne(Personne pPersonne) throws SQLException{
		java.sql.PreparedStatement ps = con.prepareStatement("INSERT INTO personne (id,nom,prenom, date_naissance,adresse, code_postale, numero_tel) VALUES (?,?,?,?,?,?,?)");
		ps.setInt(1, pPersonne.getId());
		ps.setString(2, pPersonne.getNom());
		ps.setString(3, pPersonne.getPrenom());
		ps.setDate(4,  java.sql.Date.valueOf(pPersonne.getNaissance()));
		ps.setString(5, pPersonne.getAdresse());
		ps.setInt(6, pPersonne.getCodePostable());
		ps.setString(7, pPersonne.getTel());
		return ps.executeUpdate();
	}
	
	// Recupérer une personne
	public Personne getPersone(Personne pPersonne) throws SQLException{
		java.sql.PreparedStatement ps = con.prepareStatement("SELECT * FROM personne where id = ?");
		ps.setInt(1, pPersonne.getId());
		ResultSet rs = ps.executeQuery();
		Personne personne = null;
		while(rs.next()){
			personne = new Personne();
			personne.setId(rs.getInt("id"));
			personne.setNom(rs.getString("nom"));
			personne.setPrenom(rs.getString("prenom"));
			personne.setNaissance(rs.getDate("date_naissance").toLocalDate());
			personne.setAdresse(rs.getString("adresse"));
			personne.setCodePostable(rs.getInt("code_postale"));
			personne.setTel(rs.getString("numero_tel"));
		}
		return personne;
	}

	// Mettre à jour une personne
	public void UpdatePersonne(Personne pPersonne) throws SQLException{
		java.sql.PreparedStatement ps = con.prepareStatement("UPDATE personne SET nom = ?, prenom = ?, date_naissance = ?, adresse = ?, code_postale = ?, numero_tel = ? where id = ?");
		ps.setString(1, pPersonne.getNom());
		ps.setString(2, pPersonne.getPrenom());
		ps.setDate(3,  java.sql.Date.valueOf(pPersonne.getNaissance()));
		ps.setString(4, pPersonne.getAdresse());
		ps.setInt(5, pPersonne.getCodePostable());
		ps.setString(6, pPersonne.getTel());
		ps.setInt(7, pPersonne.getId());
		ps.executeUpdate();
	}
	
	// Supprimer une personne
	public void deletePersonne(Personne pPersonne) throws SQLException{
		java.sql.PreparedStatement ps = con.prepareStatement("DELETE FROM personne where id = ?");
		ps.setInt(1, pPersonne.getId());
		ps.execute();
	}
	
	// Fermer la connection
	public void CloseConnection() throws SQLException{
		con.close();
	}
}
