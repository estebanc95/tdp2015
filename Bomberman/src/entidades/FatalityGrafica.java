package entidades;

import javax.swing.ImageIcon;

public class FatalityGrafica extends PowerUpGrafica {
	
	public FatalityGrafica (int x, int y) {
		super (x,y);
		this.img = new ImageIcon(this.getClass().getResource("/imagenes/Fatality.png"));
	}

}
