package entidades;

import javax.swing.ImageIcon;
/**
 * Clase RugulosGrafica
 * @author Esteban Federico Canela y German Herrou
 *
 */
public class RugulosGrafica extends EntidadGrafica {
	
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor de RugulosGrafica
	 * @param vel velocidad del Rugulos
	 * @param x posicion X
	 * @param y posicion Y
	 */
	public RugulosGrafica (int vel, int x, int y) {
		super(vel, x, y);
		
		this.mov[0] = new ImageIcon(this.getClass().getResource("/imagenes/Rugulos.png"));
		this.mov[1] = new ImageIcon(this.getClass().getResource("/imagenes/Rugulos.png"));
		this.mov[2] = new ImageIcon(this.getClass().getResource("/imagenes/Rugulos.png"));
		this.mov[3] = new ImageIcon(this.getClass().getResource("/imagenes/Rugulos.png"));
		this.dmovn = new ImageIcon(this.getClass().getResource("/imagenes/Rugulos.png"));
	}
	

}