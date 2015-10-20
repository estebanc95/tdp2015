package entidades;

import javax.swing.ImageIcon;

public class SpeedUpGrafica extends PowerUpGrafica {
	
	public SpeedUpGrafica (int x, int y) {
		super (x,y);
		this.img = new ImageIcon(this.getClass().getResource("/imagenes/SpeedUp.png"));
	}

}
