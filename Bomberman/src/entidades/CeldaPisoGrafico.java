package entidades;

import javax.swing.ImageIcon;

/**
 * Constructor de CeldaPisoGrafico
 * @author Esteban Federico Canela y German Herrou
 *
 */
public class CeldaPisoGrafico extends CeldaGrafica {
	
	/**
	 * Constructor de CeldaPisoGrafico
	 * @param x posicion X
	 * @param y posicion Y
	 */
	public CeldaPisoGrafico (int x,int y) {
		super(x,y);
		this.img = new ImageIcon(this.getClass().getResource("/imagenes/Piso.png"));
		
	}

}
