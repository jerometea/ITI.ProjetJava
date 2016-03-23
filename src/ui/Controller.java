package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Controller {
	JFrame _wido;
	public Controller(JFrame pWido) {
		_wido = pWido;
		_wido.add(new ListePersonnes(this));
		_wido.repaint();
	}
	
	public void ChangePanel(JPanel pWanted, JPanel pActual) {
		_wido.remove(pActual);
		_wido.add(pWanted);
		_wido.repaint();
	}
}
