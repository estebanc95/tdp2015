package entidades;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
public abstract class EntidadGrafica extends JComponent {	
	
	protected JLabel graf;
	protected Icon mov[];
	protected final int height = 32;
	protected int velocidad;
	protected Icon dmovn;
	protected final int weight = 32;
	protected Point pos;
	
	protected EntidadGrafica(int velocidad, int x, int y) {
		this.pos = new Point(weight * x, height * y);
		this.mov = new Icon[4];
		this.velocidad = velocidad;
	}
	
	public int obtenerVelocidad() {
		return this.velocidad;
	}
	
	public Point obtenerPos() {
		return this.pos;
	}
	
	public void mover(int dir) {
		if (this.graf != null) {
			this.graf.setIcon(this.mov[dir]);
			this.graf.setBounds(this.pos.x, this.pos.y, weight, height);
		}
	}
	
	public void morir() {
		if (this.graf != null) {
			this.graf.setIcon(this.dmovn);
			this.graf.setBounds(this.pos.x, this.pos.y, weight, height);
		}
	}
	
	public JLabel obtenergraf() {
		if (this.graf == null) {
			this.graf = new JLabel(mov[0]);
			this.graf.setBounds(this.pos.x, this.pos.y, weight, height);
		}
		return this.graf;
	}
	
}

