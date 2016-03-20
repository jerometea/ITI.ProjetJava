package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import logical.*;

public class Loging extends JFrame {
	private static final long serialVersionUID = 1L;
	
	JTextField TPseudo = null, TPassword = null;
	JLabel LMessage;
	
	public Loging() 
    { 
         setTitle("Gestion d'esclave"); 
         setBounds(0,0,300,100); 
         setResizable(false);
         setSize(500, 500);
         
         JLabel LPseudo, LPassword;
         JButton BPrevious, BConnect;
         
         
         LMessage = new JLabel("Pseudo ou mot de passe incorecte");
         LPseudo = new JLabel("Pseudo");
         LPassword = new JLabel("Password");
         TPseudo = new JTextField(20);
         TPassword = new JTextField(20);
         BPrevious = new JButton("Retour"); 
         BConnect = new JButton("Connect"); 
                
         JPanel pano = new JPanel();
         pano.setLayout(null);
         
         LMessage.setVisible(false);
         
         LMessage.setBounds(150, 100, 250, 20);
         LPseudo.setBounds(225, 140, 60, 20);
         TPseudo.setBounds(175, 160, 150, 20);
         LPassword.setBounds(220, 220, 80, 20);
         TPassword.setBounds(175, 240, 150, 20);
         BPrevious.setBounds(130, 300, 100, 20);
         BConnect.setBounds(270, 300, 100, 20);
         
        Connect connect = new Connect(this);
		BConnect.addActionListener(connect);
         
         pano.add(LMessage);
         pano.add(LPseudo); 
         pano.add(TPseudo);
         pano.add(LPassword);
         pano.add(TPassword);
         pano.add(BPrevious);
         pano.add(BConnect);
               
         getContentPane().add(pano);
    }

	public String getPseudo() {
		return TPseudo.getText();
	}

	public String getPassword() {
		return TPassword.getText();
	}
	
	public void setMessage(String text) {
		LMessage.setText(text);
		LMessage.setVisible(true);
	}

}

class Connect implements ActionListener 
{ 
	Loging parent;
	BaseDeDonnees bdd = new BaseDeDonnees();
	
	public Connect(Loging newParent)
	{
		parent = newParent;
		
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
	public void actionPerformed(ActionEvent e) 
	{ 
		String pseudo = parent.getPseudo();
		String password = parent.getPassword();
		

		try {
			if (bdd.logging(pseudo, password)) parent.setMessage("Vous êtes connecté ! GG");
			else parent.setMessage("Mauvais pseudo ou mot de passe");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	} 
}
