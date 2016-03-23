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

public class Loging extends JPanel {
	
	JTextField TPseudo = null, TPassword = null;
	JLabel LMessage;
	
	public Loging() 
    { 

		setSize(500, 500);
		setLayout(null);
         
         JLabel LPseudo, LPassword;
         JButton BPrevious, BConnect;
         
         
         LMessage = new JLabel("Pseudo ou mot de passe incorecte");
         LPseudo = new JLabel("Pseudo");
         LPassword = new JLabel("Password");
         TPseudo = new JTextField(20);
         TPassword = new JTextField(20);
         BPrevious = new JButton("Retour"); 
         BConnect = new JButton("Connect"); 
         
         LMessage.setVisible(false);
         
         this.add(LMessage);
         this.add(LPseudo); 
         this.add(TPseudo);
         this.add(LPassword);
         this.add(TPassword);
         this.add(BPrevious);
         this.add(BConnect);
         
         LMessage.setBounds(150, 100, 250, 20);
         LPseudo.setBounds(225, 140, 60, 20);
         TPseudo.setBounds(175, 160, 150, 20);
         LPassword.setBounds(220, 220, 80, 20);
         TPassword.setBounds(175, 240, 150, 20);
         BPrevious.setBounds(130, 300, 100, 20);
         BConnect.setBounds(270, 300, 100, 20);
         
        //Connect connect = new Connect(this);
		//BConnect.addActionListener(connect);
               
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


