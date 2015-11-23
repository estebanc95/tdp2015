package entidades;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;
/**
 * Clase Celda Grafica
 * @author Esteban Federico Canela y German Herrou
 *
 */
public abstract class CeldaGrafica {
	protected JLabel graf;
	protected Icon img;
	protected final int weight = 32;
	protected final int height = 32;
	protected Point pos;
	
	/**
	 * Constructor de Celda Grafica
	 * @param x posicion X
	 * @param y posicion Y
	 */
	protected CeldaGrafica (int x, int y) {
		this.pos = new Point(height * x, weight * y);
	}
	
	/**
	 * Devuelve la posicion de la celda
	 * @return un punto en el cual almacena la posicion de la Celda
	 */
	public Point obtenerPosicion() {
		return this.pos;
	}
	
	/**
	 * Devuelve el grafico que posee la celda
	 * @return el grafico que posee
	 */
	public JLabel obtenerGrafico() {
		if (this.graf == null) {
			this.graf = new JLabel(img);
			this.graf.setBounds(this.pos.x, this.pos.y, weight, height);
		}
		return this.graf;
	}
	

}
