package Gui;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import logica.Nivel;

public class gui extends JFrame {
	
	protected Nivel n;
	
	public gui () {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(998,445);
		getContentPane().setLayout(null);
		n = new Nivel (this);
		
	}
	
	
}