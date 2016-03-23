package ui;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import logical.BaseDeDonnees;
import logical.Personne;

public class Controller {
	JFrame _wido;
	BaseDeDonnees _bdd;
	Boolean _isConnected = false;
	
	public Controller(JFrame pWido) throws ClassNotFoundException, SQLException {
		_bdd = new BaseDeDonnees();
		_bdd.getConnection("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/projetjava", "root", "");
		_wido = pWido;
		_wido.add(new ListePersonnes(this));
		_wido.repaint();
	}
	
	public void ChangePanel(JPanel pWanted, JPanel pActual) {
		_wido.remove(pActual);
		_wido.add(pWanted);
		_wido.repaint();
	}
	
	public ArrayList<Personne> GetEveryBody() {
		try {
			return _bdd.GetEverybody();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void CreatePersonne(String tNom, String tPrenom, String tAdresse, String tCodePostal,
			String tTel, String tYear, String tMonth, String tDay) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Personne p = new Personne();
		p.setNom(tNom);
		p.setPrenom(tPrenom);
		p.setAdresse(tAdresse);
		p.setCodePostable(Integer.parseInt(tCodePostal));
		p.setTel(tTel);
		p.setNaissance(LocalDate.of(Integer.parseInt(tYear), Integer.parseInt(tMonth), Integer.parseInt(tDay)));
		
		try {
			_bdd.insertPersonne(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Login(String pseudo, String password) throws SQLException, ParseException {
		_isConnected = _bdd.logging(pseudo, password);
	}

	public void Logout() {
		_isConnected = false;
	}
	
	public Boolean get_isConnected() {
		return _isConnected;
	}
	
	public void DeletePerson(Personne pPersonne) throws SQLException {
		_bdd.deletePersonne(pPersonne);
	}
	
	public void ModifyPerson(Personne p) throws SQLException {
		_bdd.UpdatePersonne(p);
	}
	
	public Personne getPersonne(int id) throws SQLException {
		return _bdd.getPersone(id);
	}
}
