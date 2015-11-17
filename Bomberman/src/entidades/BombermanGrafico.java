package entidades;
import javax.swing.ImageIcon;

import logica.Direccion;

public class BombermanGrafico extends EntidadGrafica {
	
	public BombermanGrafico(int vel, int x, int y) {
		super(vel, x, y);
		
		this.mov[Direccion.DERECHA] = new ImageIcon(this.getClass().getResource("/imagenes/BombermanDer.png"));
		this.mov[Direccion.IZQUIERDA] = new ImageIcon(this.getClass().getResource("/imagenes/BombermanIzq.png"));
		this.mov[Direccion.ABAJO] = new ImageIcon(this.getClass().getResource("/imagenes/BombermanAb.png"));
		this.mov[Direccion.ARRIBA] = new ImageIcon(this.getClass().getResource("/imagenes/BombermanAr.gif"));	
		this.dmovn = new ImageIcon(this.getClass().getResource("/imagenes/BombermanAb.png"));
	}
	
	

}