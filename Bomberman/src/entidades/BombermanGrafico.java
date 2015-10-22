package entidades;
import javax.swing.ImageIcon;

public class BombermanGrafico extends EntidadGrafica {
	
	public BombermanGrafico(int vel, int x, int y) {
		super(vel, x, y);
		
		this.mov[0] = new ImageIcon(this.getClass().getResource("/imagenes/BombermanDer.png"));
		this.mov[1] = new ImageIcon(this.getClass().getResource("/imagenes/BombermanIzq.png"));
		this.mov[2] = new ImageIcon(this.getClass().getResource("/imagenes/BombermanAb.gif"));
		this.mov[3] = new ImageIcon(this.getClass().getResource("/imagenes/BombermanAr.png"));
		
		this.dmovn = new ImageIcon(this.getClass().getResource("/imagenes/BombermanAr.png"));
	}
	
	public void mover(int dir) {
		switch (dir) {
			case 0 : // Derecha
				this.pos.setLocation(pos.x + weight, pos.y);
				super.mover(dir);
				break;
			case 1 : // Izquierda
				this.pos.setLocation(pos.x - weight, pos.y);
				super.mover(dir);
				break;
			case 2 : // Arriba
				this.pos.setLocation(pos.x, pos.y + height);
				super.mover(dir);
				break;
			case 3 : // Abajo
				this.pos.setLocation(pos.x, pos.y - height);
				super.mover(dir);
				break;
		}
	}

}