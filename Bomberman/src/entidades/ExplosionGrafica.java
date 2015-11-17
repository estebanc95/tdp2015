package entidades;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ExplosionGrafica {
	
	protected static final int VERTICAL = 0;
	protected static final int HORIZONTAL = 1;
	protected static final int CENTRO = 9;
	
	protected JLabel graf;
	protected Icon img;
	protected final int weight = 32;
	protected final int height = 32;
	protected Point pos;
	
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
	
	public Point obtenerpos() {
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
