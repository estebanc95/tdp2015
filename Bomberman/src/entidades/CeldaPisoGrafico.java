package entidades;

import javax.swing.ImageIcon;

public class CeldaPisoGrafico extends CeldaGrafica {
	
	public CeldaPisoGrafico (int x,int y) {
		super(x,y);
		this.img = new ImageIcon(this.getClass().getResource("/imagenes/Piso.png"));
		
	}

}
