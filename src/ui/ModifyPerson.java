package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logical.BaseDeDonnees;
import logical.Personne;

public class ModifyPerson extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	BaseDeDonnees bdd;
	JTextField TNom, TPrenom, TAdresse, TCodePostal, TTel, TYear, TMonth, TDay;
	Personne personne;
	public ModifyPerson(BaseDeDonnees PBdd, Personne p){
		
		bdd = PBdd;
		
		personne= p;
		setTitle("Modifier une personne");
		setVisible(true);
        setBounds(0,0,300,100); 
		setSize(500, 500);
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		// Label
		JLabel LNom, LPrenom, LAdresse, LCodePostal, LTel, LNaissance, LYear,LMonth,LDay;
		LNom = new JLabel("Nom");
		LPrenom = new JLabel("Prenom");
		LAdresse = new JLabel("Adresse");
		LCodePostal = new JLabel("Code postal");
		LTel = new JLabel("Tel");
		LNaissance = new JLabel("Date de naissance");
		LYear = new JLabel("Annee");
		LMonth = new JLabel("Mois");
		LDay = new JLabel("Jour");
		
		int xLabel = 90, yLabel = 50, ySpace = 60;
		LNom.setBounds(xLabel, yLabel,50,10);
		LPrenom.setBounds(xLabel, yLabel+=ySpace,100,10);
		LAdresse.setBounds(xLabel, yLabel+=ySpace,100,10);
		LCodePostal.setBounds(xLabel, yLabel+=ySpace,100,10);
		LTel.setBounds(xLabel, yLabel+=ySpace,100,10);
		LNaissance.setBounds(xLabel, yLabel+=ySpace,150,10);
		LDay.setBounds(260, 325,50,20);
		LMonth.setBounds(260 + 60, 325,50,20);
		LYear.setBounds(260+120, 325,50,20);
		
		panel.add(LNom);
		panel.add(LPrenom);
		panel.add(LAdresse);
		panel.add(LCodePostal);
		panel.add(LTel);
		panel.add(LNaissance);
		panel.add(LYear);
		panel.add(LMonth);
		panel.add(LDay);
		
		//TextFields
		TNom = new JTextField();
		TPrenom = new JTextField();
		TAdresse = new JTextField();
		TCodePostal = new JTextField();
		TTel = new JTextField();
		TYear = new JTextField();
		TMonth = new JTextField();
		TDay = new JTextField();
		
		int xText = 250, yText = 45, ySpaceText = 60;
		TNom.setBounds(xText, yText,150,20);
		TPrenom.setBounds(xText, yText+=ySpaceText,150,20);
		TAdresse.setBounds(xText, yText+=ySpaceText,150,20);
		TCodePostal.setBounds(xText, yText+=ySpaceText,150,20);
		TTel.setBounds(xText, yText+=ySpaceText,150,20);
		TDay.setBounds(xText, 345,50,20);
		TMonth.setBounds(xText += 60, 345,50,20);
		TYear.setBounds(xText+=60, 345,50,20);
		
		TNom.setText(personne.getNom());
		TPrenom.setText(personne.getPrenom());
		TAdresse.setText(personne.getAdresse());
		TCodePostal.setText(Integer.toString(personne.getCodePostable()));
		TTel.setText(personne.getTel());
		TDay.setText(Integer.toString(personne.getNaissance().getDayOfMonth()));
		TMonth.setText(Integer.toString(personne.getNaissance().getMonthValue()));
		TYear.setText(Integer.toString(personne.getNaissance().getYear()));
		

		
		panel.add(TNom);
		panel.add(TPrenom);
		panel.add(TAdresse);
		panel.add(TCodePostal);
		panel.add(TTel);
		panel.add(TYear);		
		panel.add(TMonth);	
		panel.add(TDay);	
		
		// Buttons
		JButton BBack, BCreate;		
		BBack = new JButton("Retour");
		BCreate = new JButton("Valider");
		
		BBack.setBounds(70, 400, 80, 20);
		BCreate.setBounds(350, 400, 80, 20);
		
		panel.add(BBack);
		panel.add(BCreate);
		
		// Ecouteur
		BCreate.addActionListener(this);
		
		
		getContentPane().add(panel);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent pE) {
		// TODO Auto-generated method stub
		personne.setNom(TNom.getText());
		personne.setPrenom(TPrenom.getText());
		personne.setAdresse(TAdresse.getText());
		personne.setCodePostable(Integer.parseInt(TCodePostal.getText()));
		personne.setTel(TTel.getText());
		personne.setNaissance(LocalDate.of(Integer.parseInt(TYear.getText()), Integer.parseInt(TMonth.getText()), Integer.parseInt(TDay.getText())));
		
		try {
			bdd.UpdatePersonne(personne);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
