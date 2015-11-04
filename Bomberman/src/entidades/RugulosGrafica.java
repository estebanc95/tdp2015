package entidades;

import javax.swing.ImageIcon;

public class RugulosGrafica extends EntidadGrafica {
	
	public RugulosGrafica (int vel, int x, int y) {
		super(vel, x, y);
		
		this.mov[0] = new ImageIcon(this.getClass().getResource("/imagenes/Rugulos.png"));
		this.mov[1] = new ImageIcon(this.getClass().getResource("/imagenes/Rugulos.png"));
		this.mov[2] = new ImageIcon(this.getClass().getResource("/imagenes/Rugulos.png"));
		this.mov[3] = new ImageIcon(this.getClass().getResource("/imagenes/Rugulos.png"));
		this.dmovn = new ImageIcon(this.getClass().getResource("/imagenes/Rugulos.png"));
	}
	

}