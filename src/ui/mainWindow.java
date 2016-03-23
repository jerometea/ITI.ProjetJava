package ui;

import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JFrame;

import logical.BaseDeDonnees;
import logical.Personne;

public class mainWindow{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		JFrame fenetre = new JFrame();
		fenetre.setSize(500, 500);
		fenetre.setVisible(true);
		
		Controller controller = new Controller(fenetre);
	}
}
