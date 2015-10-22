package entidades;

import javax.swing.ImageIcon;

public class MasacralityGrafica extends PowerUpGrafica {
	
	public MasacralityGrafica (int x, int y) {
		super (x,y);
		this.img = new ImageIcon(this.getClass().getResource("/imagenes/Massacrality.png"));
	}

}
