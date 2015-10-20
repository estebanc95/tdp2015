package entidades;

import javax.swing.ImageIcon;

public class RugulosGrafica extends EntidadGrafica {
	
	public RugulosGrafica (int vel, int x, int y) {
		super(vel, x, y);
		
		this.mov[0] = new ImageIcon(this.getClass().getResource("/moves/runner_right.png"));
		this.mov[1] = new ImageIcon(this.getClass().getResource("/moves/runner_left.png"));
		this.mov[2] = new ImageIcon(this.getClass().getResource("/moves/runner_up.png"));
		this.mov[3] = new ImageIcon(this.getClass().getResource("/moves/runner_down.png"));
		
		this.dmovn = new ImageIcon(this.getClass().getResource("/moves/runner_d.png"));
	}
	
	public void mover(int dir) {
		switch (dir) {
			case 1 : // Derecha
				this.pos.setLocation(pos.x + weight, pos.y);
				super.mover(dir);
				break;
			case 2 : // Izquierda
				this.pos.setLocation(pos.x - weight, pos.y);
				super.mover(dir);
				break;
			case 3 : // Arriba
				this.pos.setLocation(pos.x, pos.y - height);
				super.mover(dir);
				break;
			case 4 : // Abajo
				this.pos.setLocation(pos.x, pos.y + height);
				super.mover(dir);
				break;
		}
	}

}