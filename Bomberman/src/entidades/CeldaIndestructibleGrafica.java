package entidades;

import javax.swing.ImageIcon;

/**
 * Clase CeldaIndestructibleGrafica
 * @author Esteban Federico Canela y German Herrou
 *
 */
public class CeldaIndestructibleGrafica extends CeldaGrafica {

	/**
	 * Constructor de CeldaIndestructibleGrafica
	 * @param x posicion X
	 * @param y posicion Y
	 */
	public CeldaIndestructibleGrafica (int x, int y) {
		super(x,y);
		this.img = new ImageIcon(this.getClass().getResource("/imagenes/ParedI.png"));
	}
	
}
