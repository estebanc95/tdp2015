package entidades;

import javax.swing.ImageIcon;

public class RugulosGrafica extends EntidadGrafica {
	
	public RugulosGrafica (int vel, int x, int y) {
		super(vel, x, y);
		
		this.mov[0] = new ImageIcon(this.getClass().getResource("/imagenes/RugulusDer.gif"));
		this.mov[1] = new ImageIcon(this.getClass().getResource("/imagenes/RugulusIzq.gif"));
		this.mov[2] = new ImageIcon(this.getClass().getResource("/imagenes/RugulusArr.gif"));
		this.mov[3] = new ImageIcon(this.getClass().getResource("/imagenes/RugulusAb.gif"));
		
		this.dmovn = new ImageIcon(this.getClass().getResource("/imagenes/RugulusArr.gif"));
	}
	

}