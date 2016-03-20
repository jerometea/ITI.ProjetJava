package logical;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) throws SQLException {
		BaseDeDonnees bdd = new BaseDeDonnees();
		
		try {
			bdd.getConnection("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/projetjava", "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		Personne p = new Personne(1, "Morel", "Christophe", "Paris",LocalDate.of(1989, 6, 9), 75, "0182487585");
		bdd.insertPersonne(p);
		
		Personne p1 = bdd.getPersone(p);
		System.out.println(p1.getNom());
		
		ArrayList<Personne> listPersonne = new ArrayList<Personne>();
		listPersonne = bdd.GetEverybody();
		for(Personne personne : listPersonne){
			System.out.println(personne.getNom());
		}
		
		p1.setNom("Mozarel");
		p1.setPrenom("pablo");
		p1.setNaissance(LocalDate.of(1990,10,2));
		bdd.UpdatePersonne(p1);
		p = bdd.getPersone(p1);
		System.out.println(p1.getNom() + " " + p1.getPrenom() + " " + p1.getNaissance() + " ");
		
		
		bdd.CloseConnection();

	}

}
