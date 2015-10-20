package entidades;

import javax.swing.ImageIcon;

public class CeldaDestructibleGrafica extends CeldaGrafica {
	
	public CeldaDestructibleGrafica (int x, int y) {
		super(x,y);
		this.img = new ImageIcon(this.getClass().getResource("/imagenes/ParedD.png"));
	}

}
