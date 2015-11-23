package Gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Establece un fondo al menu principal
 * @author Esteban Canela y German Herrou
 *
 */

public class FondoMenu extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private ImageIcon imagen;

	/**
	 * Constructor de fondo Menu
	 */
	public FondoMenu () {
		this.setVisible(true);
		imagen = new ImageIcon(getClass().getResource("/imagenes/fondoJuego.png"));
	}
	
	 public void paint(Graphics g) {
	        if (imagen != null) {
	            g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(),
	                              this);
	 
	            setOpaque(false);
	        } else {
	            setOpaque(true);
	        }
	 
	        super.paint(g);
	    }
	 
	 
}
