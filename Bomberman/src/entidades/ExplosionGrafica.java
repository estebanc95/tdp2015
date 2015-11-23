package entidades;

import java.applet.AudioClip;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * Clase ExplosionGrafica
 * @author Esteban Federico Canela y German Herrou
 *
 */
public class ExplosionGrafica {
	
	protected static final int VERTICAL = 0;
	protected static final int HORIZONTAL = 1;
	protected static final int CENTRO = 9;
	
	protected JLabel graf;
	protected Icon img;
	protected final int weight = 32;
	protected final int height = 32;
	protected Point pos;
	
	/**
	 * Constructor de Explosion Grafica
	 * @param x posicion x
	 * @param y posicion y 
	 * @param dir direccion de la explosion
	 */
	public ExplosionGrafica(int x, int y,int dir) {
		this.pos = new Point(height * x, weight * y);
		switch(dir){
			case(VERTICAL):{
				this.img = new ImageIcon(this.getClass().getResource("/imagenes/FuegoArriba.png"));
				break;
			}
			case(HORIZONTAL):{
				this.img = new ImageIcon(this.getClass().getResource("/imagenes/FuegoLateral.png"));
				break;
			}
			case(CENTRO):{
				this.img = new ImageIcon(this.getClass().getResource("/imagenes/FuegoCentro.png"));
				break;
			}
		}

		
	}
	
	/**
	 * Devuelve el punto donde se encuentra la explosion grafica
	 * @return la posicion de la explosion
	 */
	
	public Point obtenerpos() {
		return this.pos;
	}
	
	/**
	 * Devuelve el grafico que posee la explosion grafica
	 * @return el grafico que contiene la explosion
	 */
	public JLabel obtenerGrafico() {
		if (this.graf == null) {
			this.graf = new JLabel(img);
			this.graf.setBounds(this.pos.x, this.pos.y, weight, height);
		}
		return this.graf;
	}

}
