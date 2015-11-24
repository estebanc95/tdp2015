package Gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * Clase Fondo Fin
 * @author Esteban Federico Canela y German Herrou
 *
 */
public class FondoFin extends JFrame {
	
	private PanelFin pf;
	private gui juego;
	private MenuGUI miPrincipal;
	private JButtonMod nuevoJuego;
	
	/**
	 * Constructor Fondo Fin
	 * @param mip pantalla principal del juego
	 * @param j pantalla que contiene el mapa
	 * @param ruta locacion de la imagen
	 */
	public FondoFin (MenuGUI mip,gui j,String ruta) {
		super ("Proyecto X - TECNOLOGIA DE PROGRAMACION - 2015");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/IconoJuego.png"));
	    setIconImage(icon);
		setSize(998,530);
		setVisible(true);
		setLocationRelativeTo(null);
		pf = new PanelFin (ruta);
		pf.setLayout(null);
		this.add(pf);
		miPrincipal=mip;
		juego=j;
		nuevoJuego = new JButtonMod("/imagenes/NewGame.png");
		nuevoJuego.setBounds(160, 200, 190, 50);
		OyenteBack ob = new OyenteBack();
		nuevoJuego.addActionListener(ob);
		pf.add(nuevoJuego);
		
	}

	 class OyenteBack implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				juego = new gui(miPrincipal);
				juego.setVisible(true);
				setVisible(false);
			}
		}
}
