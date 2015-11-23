package entidades;

import javax.swing.ImageIcon;
/**
 * Clase FatalityGrafica
 * @author Esteban Federico Canela y German Herrou
 *
 */
public class FatalityGrafica extends PowerUpGrafica {
	
	/**
	 * Constructor FatalityGrafica
	 * @param x posicion X
	 * @param y posicion Y
	 */
	public FatalityGrafica (int x, int y) {
		super (x,y);
		this.img = new ImageIcon(this.getClass().getResource("/imagenes/Fatality.png"));
	}

}
