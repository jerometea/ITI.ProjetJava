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

public class CreatePerson extends JPanel implements ActionListener {
	
	JTextField TNom, TPrenom, TAdresse, TCodePostal, TTel, TYear, TMonth, TDay;
	Controller _context;
	
	public CreatePerson(Controller context){
		_context = context;
		setVisible(true);
		setSize(500, 500);

		setLayout(null);
		
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
		
		add(LNom);
		add(LPrenom);
		add(LAdresse);
		add(LCodePostal);
		add(LTel);
		add(LNaissance);
		add(LYear);
		add(LMonth);
		add(LDay);
		
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

		add(TNom);
		add(TPrenom);
		add(TAdresse);
		add(TCodePostal);
		add(TTel);
		add(TYear);		
		add(TMonth);
		add(TDay);	
		
		// Buttons
		JButton BBack, BCreate;		
		BBack = new JButton("Retour");
		BCreate = new JButton("Valider");
		
		BBack.setBounds(70, 400, 80, 20);
		BCreate.setBounds(350, 400, 80, 20);
		
		add(BBack);
		add(BCreate);
		
		// Ecouteur
		BBack.addActionListener(this);
		BCreate.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent pE) {
		if(pE.getActionCommand() == "Retour") {
			_context.ChangePanel(new ListePersonnes(_context), this);
		} else if(pE.getActionCommand() == "Valider") {
			_context.CreatePersonne(TNom.getText(), TPrenom.getText(), TAdresse.getText(), TCodePostal.getText(), TTel.getText(), TYear.getText(), TMonth.getText(), TDay.getText());
			_context.ChangePanel(new ListePersonnes(_context), this);
		}
	}
	
}
