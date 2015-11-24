package entidades;

import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Clase CeldaIndestructibleGrafica
 * @author Esteban Federico Canela y German Herrou
 *
 */
public class CeldaIndestructibleGrafica extends CeldaGrafica {
	
	private static final int tipo=new Random().nextInt(3);
	
	/**
	 * Constructor de CeldaIndestructibleGrafica
	 * @param x posicion X
	 * @param y posicion Y
	 */
	public CeldaIndestructibleGrafica (int x, int y) {
		super(x,y);
		switch (tipo) {
		case (0) : {
			this.img = new ImageIcon(this.getClass().getResource("/imagenes/ParedI.png"));
			break;
			}
		case (1) : {
			this.img = new ImageIcon(this.getClass().getResource("/imagenes/ParedI1.png"));
			break;
		}
		case (2) : {
			this.img = new ImageIcon(this.getClass().getResource("/imagenes/ParedI2.png"));
			break;
		}
		}
	}
	
	
}
