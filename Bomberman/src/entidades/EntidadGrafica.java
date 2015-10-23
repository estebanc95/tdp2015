package entidades;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
public abstract class EntidadGrafica extends JComponent {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		this.velocidad =velocidad;
	}
	
	public void setVelocidad(int velocidad){
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
			
			try {
				switch (dir){
				case 2 : // Arriba
					for(int i = 0; i < this.height; i += this.velocidad){
						this.graf.setBounds(this.pos.x, this.pos.y -= this.velocidad, weight, height);
						Thread.sleep(100-(2*velocidad));
					}
					break;
				case 3 : // Abajo
					for(int i = 0; i < this.height; i += this.velocidad){
						this.graf.setBounds(this.pos.x, this.pos.y += this.velocidad, weight, height);
						Thread.sleep(100-(2*velocidad));
					}
					break;
				case 0 : // Derecha
					for(int i = 0; i < this.weight; i += this.velocidad){
						this.graf.setBounds(this.pos.x += this.velocidad, this.pos.y, weight, height);
						Thread.sleep(100-(2*velocidad));
					}
					break;
				case 1 : // Derecha
					for(int i = 0; i < this.weight; i += this.velocidad){
						this.graf.setBounds(this.pos.x -= this.velocidad, this.pos.y, weight, height);
						Thread.sleep(100-(2*velocidad));
					}
					break;
				}
			}
					catch (InterruptedException e) {
				//	TODO Auto-generated catch block
				e.printStackTrace();
					}
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

