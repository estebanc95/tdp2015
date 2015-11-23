package entidades;

import javax.swing.ImageIcon;

/**
 * Clase  CeldaDestructibleGrafica
 * @author Esteban Federico Canela y German Herrou
 *
 */
public class CeldaDestructibleGrafica extends CeldaGrafica {
	
	/**
	 * Constructor de  CeldaDestructibleGrafica
	 * @param x posicion x
	 * @param y posicion y
	 */
	public CeldaDestructibleGrafica (int x, int y) {
		super(x,y);
		this.img = new ImageIcon(this.getClass().getResource("/imagenes/ParedD.png"));
	}

}
