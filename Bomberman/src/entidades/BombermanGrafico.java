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
	 * Constructor de Bomberman Grafico
	 * @param vel velocidad del personaje
	 * @param x posicion X
	 * @param y posicion Y
	 */
	public BombermanGrafico(int vel, int x, int y) {
		super(vel, x, y);
		
		this.mov[Direccion.DERECHA] = new ImageIcon(this.getClass().getResource("/imagenes/BombermanDer.png"));
		this.mov[Direccion.IZQUIERDA] = new ImageIcon(this.getClass().getResource("/imagenes/BombermanIzq.png"));
		this.mov[Direccion.ABAJO] = new ImageIcon(this.getClass().getResource("/imagenes/BombermanAb.png"));
		this.mov[Direccion.ARRIBA] = new ImageIcon(this.getClass().getResource("/imagenes/BombermanAr.gif"));	
		this.dmovn = new ImageIcon(this.getClass().getResource("/imagenes/BombermanAb.png"));
	}
	
	

}