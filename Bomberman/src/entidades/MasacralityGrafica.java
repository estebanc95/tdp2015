package entidades;

import javax.swing.ImageIcon;
/**
 * Clase MasacralityGrafica
 * @author Esteban Federico Canela y German Herrou
 *
 */
public class MasacralityGrafica extends PowerUpGrafica {
	
	/**
	 * Constructor de MasacralityGrafica
	 * @param x posicion X
	 * @param y posicion Y
	 */
	public MasacralityGrafica (int x, int y) {
		super (x,y);
		this.img = new ImageIcon(this.getClass().getResource("/imagenes/Massacrality.png"));
	}

}
