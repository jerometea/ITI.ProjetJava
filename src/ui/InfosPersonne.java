package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logical.Personne;

public class InfosPersonne extends JPanel implements ActionListener {
	Controller _context;
	JLabel lastname = new JLabel();
	JLabel firstname = new JLabel();
	JLabel birthDate = new JLabel();
	JLabel address = new JLabel();
	JLabel zipCode = new JLabel();
	JLabel telnumber = new JLabel();
	Personne _p;

	
	public InfosPersonne(Controller context, Personne p) {
		_context = context;
		_p = p;
		setSize(500, 500);
		setLayout(null);
		
		JButton butBack = new JButton("Retour");
		JButton butDel = new JButton("Supprimer");
		JButton butUpdate = new JButton("Modifier");
		
		lastname.setText("Nom : "+p.getNom());
		firstname.setText("Prenom : "+p.getPrenom());
		birthDate.setText("Date de naissance : "+p.getNaissance());
		address.setText("Adresse : "+p.getAdresse());
		zipCode.setText("Code postale : "+p.getCodePostable());
		telnumber.setText("Numéro de tel. : "+p.getTel());
		
		this.add(butBack);
		this.add(butDel);
		this.add(butUpdate);
		
		this.add(lastname);
		this.add(firstname);
		this.add(birthDate);
		this.add(address);
		this.add(zipCode);
		this.add(telnumber);
		
		butBack.setBounds(100, 400, 100, 25);
		butDel.setBounds(200, 400, 100, 25);
		butUpdate.setBounds(300, 400, 100, 25);
		
		lastname.setBounds(125, 10, 250, 25);
		firstname.setBounds(125, 60, 250, 25);
		birthDate.setBounds(125, 110, 250, 25);
		address.setBounds(125, 160, 250, 25);
		zipCode.setBounds(125, 210, 250, 25);
		telnumber.setBounds(125, 260, 250, 25);
		
		butBack.addActionListener(this);
		butDel.addActionListener(this);
		butUpdate.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "Retour") {
			_context.ChangePanel(new ListePersonnes(_context), this);
		} else if(e.getActionCommand() == "Supprimer") {
			try {
				_context.DeletePerson(_p);
				_context.ChangePanel(new ListePersonnes(_context), this);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			_context.ChangePanel(new ListePersonnes(_context), this);
		} else if(e.getActionCommand() == "Modifier") {
			_context.ChangePanel(new ModifyPerson(_context, _p), this);
		}
	}
}
