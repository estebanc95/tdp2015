package entidades;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class PowerUpGrafica {
		protected JLabel graf;
		protected Icon img;
		protected final int weight = 32;
		protected final int height = 32;
		protected Point pos;
		
		protected PowerUpGrafica (int x, int y) {
			this.pos = new Point(height * x, weight * y);
		}
		
		public Point obtenerPosicion() {
			return this.pos;
		}
		
		public JLabel obtenerGrafico() {
			if (this.graf == null) {
				this.graf = new JLabel(img);
				this.graf.setBounds(this.pos.x, this.pos.y, weight, height);
			}
			return this.graf;
		}
		

	}
