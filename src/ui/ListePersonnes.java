package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import logical.Personne;


public class ListePersonnes extends JPanel implements ActionListener {
	Controller _context;
	JComboBox<String> list = new JComboBox<String>();
	
	public ListePersonnes(Controller context) {
		_context = context;
		setSize(500, 500);
		setLayout(null);
		
		JButton butCo;
		JButton butCreate = new JButton("Créer");
		JButton butInfo = new JButton("Info");
		
		for(Personne p : context.GetEveryBody()) {
			list.addItem(p.getId()+" "+p.getPrenom()+" "+p.getNom());
		}

		if(_context.get_isConnected()) {
			butCo = new JButton("Deconnexion");			
		} else {
			butCo = new JButton("Connexion");
			butInfo.setVisible(false);
		}
		
		butCreate.addActionListener(this);
		butCo.addActionListener(this);
		butInfo.addActionListener(this);
		
		this.add(butCreate);
		this.add(butInfo);
		this.add(butCo);
		this.add(list);
		
		butInfo.setBounds(375, 10, 75, 25);
		butCo.setBounds(10, 10, 110, 25);
		butCreate.setBounds(200, 400, 75, 25);
		list.setLayout(null);
		list.setBounds(175, 10, 200, 25);
		list.setOpaque(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand() == "Créer") {
			_context.ChangePanel(new CreatePerson(_context), this);
		} else if(arg0.getActionCommand() == "Connexion") {
			_context.ChangePanel(new Loging(_context), this);
		} else if(arg0.getActionCommand() == "Deconnexion") {
			_context.Logout();
			_context.ChangePanel(new ListePersonnes(_context), this);
		} else if(arg0.getActionCommand() == "Info") {
			Personne p = new Personne();
			try {
				p = _context.getPersonne(Integer.parseInt((((String)list.getSelectedItem()).split(" ")[0])));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			_context.ChangePanel(new InfosPersonne(_context, p), this);
		}
	}
}
