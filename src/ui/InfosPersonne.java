package ui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfosPersonne extends JPanel {
	public InfosPersonne() {
		setSize(500, 500);
		setLayout(null);
		
		JButton butBack = new JButton("Retour");
		JButton butDel = new JButton("Supprimer");
		JButton butUpdate = new JButton("Modifier");
		
		JLabel lastname = new JLabel();
		JLabel firstname = new JLabel();
		JLabel birthDate = new JLabel();
		JLabel address = new JLabel();
		JLabel zipCpde = new JLabel();
		JLabel telnumber = new JLabel();
		
		lastname.setText("Nom : ");
		firstname.setText("Prenom : ");
		birthDate.setText("Date de naissance : ");
		address.setText("Adresse : ");
		zipCpde.setText("Code postale : ");
		telnumber.setText("Numéro de tel. : ");
		
		this.add(butBack);
		this.add(butDel);
		this.add(butUpdate);
		
		this.add(lastname);
		this.add(firstname);
		this.add(birthDate);
		this.add(address);
		this.add(zipCpde);
		this.add(telnumber);
		
		butBack.setBounds(100, 400, 100, 25);
		butDel.setBounds(200, 400, 100, 25);
		butUpdate.setBounds(300, 400, 100, 25);
		
		lastname.setBounds(125, 10, 150, 25);
		firstname.setBounds(125, 60, 150, 25);
		birthDate.setBounds(125, 110, 150, 25);
		address.setBounds(125, 160, 150, 25);
		zipCpde.setBounds(125, 210, 150, 25);
		telnumber.setBounds(125, 260, 150, 25);
	}
}
