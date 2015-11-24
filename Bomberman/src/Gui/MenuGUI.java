package Gui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Clase MenuGUI la cual es la principal del GUI
 * @author Esteban Federico Canela y German Herrou
 *
 */
public class MenuGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private FondoMenu panel;
	private JButtonMod nuevoJuego,salir;
	private gui miGui;
	private MenuGUI miPrincipal;
	
	/**
	 * Constructor de MenuGUI
	 */
	
	public MenuGUI () {
		super ("Proyecto X - TECNOLOGIA DE PROGRAMACION - 2015");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/IconoJuego.png"));
	    setIconImage(icon);
		setSize(998,530);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		panel = new FondoMenu ();
		panel.setBounds(0, 0,998,530);
		getContentPane().add(panel);
		miPrincipal = this;
		
		nuevoJuego = new JButtonMod("/imagenes/NewGame.png");
		nuevoJuego.setBounds(160, 200, 190, 50);
		getContentPane().add(nuevoJuego);
		OyenteNJ nj = new OyenteNJ();
		nuevoJuego.addActionListener(nj);
		
		salir = new JButtonMod("/imagenes/Salir.png");
		salir.setBounds(160, 252, 190, 50);
		OyenteSJ sj = new OyenteSJ();
		salir.addActionListener(sj);
		salir.setVisible(true);
		getContentPane().add(salir);
		getContentPane().repaint();
		
		
	}
	
	 class OyenteNJ implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				miGui = new gui(miPrincipal);
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
