package Gui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private FondoMenu panel;
	private JButton nuevoJuego,salir;
	private gui miGui;
	private MenuGUI miPrincipal;
	
	public MenuGUI () {
		super ("Proyecto X - TECNOLOGIA DE PROGRAMACIONS - 2015");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(998,530);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		panel = new FondoMenu ();
		panel.setBounds(0, 0,998,530);
		getContentPane().add(panel);
		miPrincipal = this;
		
		nuevoJuego = new JButton("Nuevo Juego");
		nuevoJuego.setBounds(160, 200, 200, 50);
		getContentPane().add(nuevoJuego);
		OyenteNJ nj = new OyenteNJ();
		nuevoJuego.addActionListener(nj);
		
		salir = new JButton("Exit");
		salir.setBounds(160, 252, 200, 50);
		OyenteSJ sj = new OyenteSJ();
		salir.addActionListener(sj);
		salir.setVisible(true);
		getContentPane().add(salir);
		getContentPane().repaint();
		
		
	}
	
	 class OyenteNJ implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				miGui = new gui();
				miPrincipal.setVisible(false);
				miGui.setVisible(true);
			}
		}
	 
	 class OyenteSJ implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		}

}
