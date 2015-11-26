package entidades;
import javax.swing.ImageIcon;

import logica.Direccion;

/**
 * Clase BombermanGrafico
 * @author Esteban Federico Canela y German Herrou
 *
 */

public class BombermanGrafico extends EntidadGrafica {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de Bomberman Grafico
	 * @param vel velocidad del personaje
	 * @param x posicion X
	 * @param y posicion Y
	 */
	public BombermanGrafico(int vel, int x, int y) {
		super(vel, x, y);
		
		this.mov[Direccion.DERECHA] = new ImageIcon(this.getClass().getResource("/imagenes/BombermanDer.gif"));
		this.mov[Direccion.IZQUIERDA] = new ImageIcon(this.getClass().getResource("/imagenes/BombermanIzq.gif"));
		this.mov[Direccion.ABAJO] = new ImageIcon(this.getClass().getResource("/imagenes/BombermanAr.gif"));
		this.mov[Direccion.ARRIBA] = new ImageIcon(this.getClass().getResource("/imagenes/BombermanAb.gif"));	
		this.dmovn = new ImageIcon(this.getClass().getResource("/imagenes/BombermanAr.gif"));
	}
	
	

}