package entidades;

import javax.swing.ImageIcon;

public class BombalityGrafica extends PowerUpGrafica {
	
	public BombalityGrafica (int x, int y) {
		super (x,y);
		this.img = new ImageIcon(this.getClass().getResource("/imagenes/Bombality.png"));
	}

}

