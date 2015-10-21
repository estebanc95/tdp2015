package Gui;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import logica.Nivel;

public class gui extends JFrame {
	
	protected Nivel n;
	
	public gui () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setLayout(null);
		n = new Nivel (this);
		
	}
	
	
}