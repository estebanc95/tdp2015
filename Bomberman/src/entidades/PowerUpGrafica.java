package entidades;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;
/**
 * Clase PowerUpGrafica
 * @author Esteban Federico Canela y German Herrou
 *
 */
public abstract class PowerUpGrafica {
		protected JLabel graf;
		protected Icon img;
		protected final int weight = 32;
		protected final int height = 32;
		protected Point pos;
		/**
		 * Construcor de PowerUpGrafica
		 * @param x posicion X
		 * @param y posicion Y
		 */
		protected PowerUpGrafica (int x, int y) {
			this.pos = new Point(height * x, weight * y);
		}
		/**
		 * Devuelve el punto donde se encuentra la explosion grafica
		 * @return la posicion de la explosion
		 */
		
		public Point obtenerPosicion() {
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
