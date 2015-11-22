package Gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private FondoMenu panel;
	private JButton nuevoJuego;
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
		nuevoJuego = new JButton("Nuevo Juego");
		nuevoJuego.setBounds(160, 200, 200, 50);
		nuevoJuego.setSelected(false);
		getContentPane().add(nuevoJuego);
		OyenteNJ nj = new OyenteNJ();
		nuevoJuego.addActionListener(nj);
		miPrincipal = this;
		
	}
	
	 class OyenteNJ implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				miGui = new gui();
				miPrincipal.setVisible(false);
				miGui.setVisible(true);
			}
		}

}
