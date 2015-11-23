package Gui;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Clase JButtonMod
 * @author Esteban Federico Canela y German Herrou
 *
 */
public class JButtonMod extends JButton {
	
	private static final long serialVersionUID = 1L;
	private ImageIcon icon;
	
	/**
	 * Constructor de JButtonMod
	 * @param texto ruta donde se encuentra el imagen
	 */
	
	public JButtonMod(String texto) {
		icon = new ImageIcon(getClass().getResource(texto));
		setIcon(icon);
		setMargin(new Insets (0,0,0,0));
		this.setIconTextGap(0);
		setBorderPainted(false);
		setBorder(null);
		setSize(icon.getImage().getWidth(null),icon.getImage().getHeight(null));
	}
}
