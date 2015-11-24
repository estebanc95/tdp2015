package Gui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Clase Panel Perdedor
 * @author Esteban Federico Canela y German Herrou
 *
 */

public class PanelFin extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon imagen;

	/**
	 * Constructor de Panel Perdedor
	 */
	public PanelFin (String ruta) {
		this.setVisible(true);
		imagen = new ImageIcon(getClass().getResource(ruta));
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

