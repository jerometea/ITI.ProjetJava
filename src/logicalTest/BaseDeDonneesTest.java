package logicalTest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.time.LocalDate;

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
		
		Personne p2 = bdd.getPersone(p1);
		
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
