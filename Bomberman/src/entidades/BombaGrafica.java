package entidades;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase Bomba Grafica
 * @author Esteban Federico Canela y German Herrou
 *
 */
public class BombaGrafica {
	
	protected JLabel graf;
	protected Icon img;
	protected final int weight = 32;
	protected final int height = 32;
	protected Point pos;
	
	/**
	 * Constructor de Bomba Grafica
	 * @param x posicion X
	 * @param y posicion Y
	 */
	
	public BombaGrafica(int x, int y) {
		this.pos = new Point(height * x, weight * y);
		this.img = new ImageIcon(this.getClass().getResource("/imagenes/Bomba.png"));
	}
	
	/**
	 * Posicion en el mapa
	 * @return la posicion de la bomba en el mapa
	 */
	public Point obtenerpos() {
		return this.pos;
	}
	
	/**
	 * Grafico que posee la Bomba
	 * @return el grafico que contiene la bomba
	 */
	public JLabel obtenerGrafico() {
		if (this.graf == null) {
			this.graf = new JLabel(img);
			this.graf.setBounds(this.pos.x, this.pos.y, weight, height);
		}
		return this.graf;
	}

}
