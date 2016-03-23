package logicalTest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.*;

import logical.BaseDeDonnees;
import logical.Personne;

public class BaseDeDonneesTest {

	private static BaseDeDonnees bdd;
	
	@BeforeClass
	public static void SetUp(){
		bdd = new BaseDeDonnees();
		try {
			bdd.getConnection("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/projetjava", "root", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public static void AfterClass() throws SQLException{
		bdd.CloseConnection();
	}
	
	@Test
	public void InsertPerson() throws SQLException{
		Personne p1 = new Personne(2, "Duval", "Thibaud", "Sous le pont des arts", LocalDate.of(1995, 10, 3), 75015, "0695487584");
		bdd.insertPersonne(p1);
		
		Personne p2 = bdd.getPersone(p1.getId());
		
		assertEquals(p1.getId(), p2.getId());
		assertEquals(p1.getNom(), p2.getNom());
		assertEquals(p1.getPrenom(), p2.getPrenom());
		assertEquals(p1.getAdresse(), p2.getAdresse());
		assertEquals(p1.getNaissance(), p2.getNaissance());
		assertEquals(p1.getCodePostable(), p2.getCodePostable());
		assertEquals(p1.getTel(), p2.getTel());
		bdd.deletePersonne(p1);
	}
	
	@Test
	public void GetEverybody() throws SQLException{
		ArrayList<Personne> listTest = new ArrayList<Personne>();
		Personne p1 = new Personne(1, "Duval", "Thibaud", "Sous le pont des arts", LocalDate.of(1995, 10, 3), 75015, "0695487584");
		Personne p2 = new Personne(2,"Stefani","Leo", "Sur les bancs de Chatelet ligne 7", LocalDate.of(1995, 6, 12),75012,"0635154785");
		Personne p3 = new Personne(3,"Tea","Jerome", "Chateau de Versailles", LocalDate.of(1993, 03, 18),77185, "0695498775");
		listTest.add(p1);
		listTest.add(p2);
		listTest.add(p3);
		
		bdd.insertPersonne(p1);
		bdd.insertPersonne(p2);
		bdd.insertPersonne(p3);		
		
		ArrayList<Personne> listBdd = bdd.GetEverybody();
		
		for(Personne personne : listTest){
			if(listBdd.contains(personne.getId())){
				int id = personne.getId();			
				assertEquals(personne.getId(), listBdd.get(id).getId());
				assertEquals(personne.getNom(), listBdd.get(id).getNom());
				assertEquals(personne.getPrenom(), listBdd.get(id).getPrenom());
				assertEquals(personne.getAdresse(), listBdd.get(id).getAdresse());
				assertEquals(personne.getNaissance(), listBdd.get(id).getNaissance());
				assertEquals(personne.getCodePostable(), listBdd.get(id).getCodePostable());
				assertEquals(personne.getTel(), listBdd.get(id).getTel());
			}
		}
		bdd.deletePersonne(p1);
		bdd.deletePersonne(p2);
		bdd.deletePersonne(p3);		
	}
	@Test
	public void DeletePerson() throws SQLException{
		Personne p1 = new Personne(1, "Duval", "Thibaud", "Sous le pont des arts", LocalDate.of(1995, 10, 3), 75015, "0695487584");
		bdd.insertPersonne(p1);
		
		Personne p2 = bdd.getPersone(p1.getId());
		assertEquals(p1.getId(), p2.getId());
		assertEquals(p1.getNom(), p2.getNom());
		assertEquals(p1.getPrenom(), p2.getPrenom());
		assertEquals(p1.getAdresse(), p2.getAdresse());
		assertEquals(p1.getNaissance(), p2.getNaissance());
		assertEquals(p1.getCodePostable(), p2.getCodePostable());
		assertEquals(p1.getTel(), p2.getTel());
		
		bdd.deletePersonne(p1);
		p2 = bdd.getPersone(p1.getId());
		assertNull(p2);
	}
	
	@Test
	public void UpdatePerson() throws SQLException{
		Personne p1 = new Personne(1, "Duval", "Thibaud", "Sous le pont des arts", LocalDate.of(1995, 10, 3), 75015, "0695487584");
		bdd.insertPersonne(p1);
		
		p1.setNom("Stefani");
		p1.setPrenom("Leo");
		p1.setAdresse("Dans la rue");
		p1.setNaissance(LocalDate.of(1986, 12, 10));
		p1.setCodePostable(75001);
		p1.setTel("0123456789");
		
		bdd.UpdatePersonne(p1);
		
		Personne p2 = bdd.getPersone(p1.getId());
		
		assertEquals(p1.getId(), p2.getId());
		assertEquals(p1.getNom(), p2.getNom());
		assertEquals(p1.getPrenom(), p2.getPrenom());
		assertEquals(p1.getAdresse(), p2.getAdresse());
		assertEquals(p1.getNaissance(), p2.getNaissance());
		assertEquals(p1.getCodePostable(), p2.getCodePostable());
		assertEquals(p1.getTel(), p2.getTel());
		
		bdd.deletePersonne(p1);	
		
	}

}
