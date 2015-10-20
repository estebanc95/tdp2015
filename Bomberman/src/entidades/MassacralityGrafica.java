package entidades;

import javax.swing.ImageIcon;

public class MassacralityGrafica extends PowerUpGrafica {
	
	public MassacralityGrafica (int x, int y) {
		super (x,y);
		this.img = new ImageIcon(this.getClass().getResource("/imagenes/Massacrality.png"));
	}

}
