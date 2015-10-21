package Gui;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import logica.Nivel;

public class gui extends JFrame {

	private static final long serialVersionUID = 1L;
	protected Nivel n;
	
	public gui () {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(998,445);
		JLayeredPane contentPane = new JLayeredPane();
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		n = new Nivel (this);
		
	}
	
	
}