package ui;

import java.sql.SQLException;
import java.time.LocalDate;

import logical.BaseDeDonnees;
import logical.Personne;

public class mainWindow{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
     Loging fenetre; 
     fenetre=new Loging(); 
     fenetre.setVisible(true);
	}
}
