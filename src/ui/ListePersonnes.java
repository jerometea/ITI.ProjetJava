package ui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ListePersonnes extends JPanel {
	public ListePersonnes() {
		setSize(500, 500);
		setLayout(null);
		
		JButton butCo;
		JButton butCreate = new JButton("Créer");
		JLabel list = new JLabel();
		
		//if admin ou pas
		if(this.getIgnoreRepaint()) {
			list.setText("text reçu de la bdd - la totale");
		} else {
			list.setText("text reçu de la bdd - juste nom/prénom");
		}
		
		//if admin ou pas
		if(this.getIgnoreRepaint()) {
			butCo = new JButton("Deconnexion");
		} else {
			butCo = new JButton("Connexion");
		}
		
		this.add(butCreate);
		this.add(butCo);
		this.add(list);
		
		butCo.setBounds(10, 10, 110, 25);
		butCreate.setBounds(200, 400, 75, 25);
		list.setLayout(null);
		list.setBounds(150, 10, 300, 350);
		list.setOpaque(true);
		list.setBackground(Color.green);
		list.setVerticalAlignment(SwingConstants.TOP);
		
		setVisible(true);
	}
}
