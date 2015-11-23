package entidades;

import javax.swing.ImageIcon;
/**
 * Clase SpeedUpGrafica
 * @author Esteban Federico Canela y German Herrou
 *
 */
public class SpeedUpGrafica extends PowerUpGrafica {
	
	/**
	 * Constructor de SpeedUpGrafica
	 * @param x posicion X
	 * @param y posicion Y
	 */
	public SpeedUpGrafica (int x, int y) {
		super (x,y);
		this.img = new ImageIcon(this.getClass().getResource("/imagenes/SpeedUp.png"));
	}

}
