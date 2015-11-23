package entidades;

import javax.swing.ImageIcon;

/**
 * Clase Bombality Grafica
 * @author Esteban Federico Canela y German Herrou
 *
 */

public class BombalityGrafica extends PowerUpGrafica {
	
	/**
	 * Constructor de Bombality Grafica
	 * @param x posicion en X
	 * @param y posicion en Y
	 */
	public BombalityGrafica (int x, int y) {
		super (x,y);
		this.img = new ImageIcon(this.getClass().getResource("/imagenes/Bombality.png"));
	}

}

