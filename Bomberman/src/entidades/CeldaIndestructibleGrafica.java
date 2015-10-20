package entidades;

import javax.swing.ImageIcon;

public class CeldaIndestructibleGrafica extends CeldaGrafica {

	public CeldaIndestructibleGrafica (int x, int y) {
		super(x,y);
		this.img = new ImageIcon(this.getClass().getResource("/imagenes/ParedI.png"));
	}
	
}
