package entidades;
import javax.swing.ImageIcon;

/**	
 * Entidad grafica de un Altair
 * @author Esteban Federico y German Herrou
 *
 */

public class AltairGrafica extends EntidadGrafica {
	
	/**
	 * Constructor de AltairGrafica, establece las imagenes del Altair
	 * @param vel velocidad del personaje
	 * @param x ubicacion del personaje en pos x
	 * @param y ubicacion del personaje en pos y
	 */
	public AltairGrafica (int vel, int x, int y) {
		super(vel, x, y);
		
		this.mov[0] = new ImageIcon(this.getClass().getResource("/imagenes/Altair.png"));
		this.mov[1] = new ImageIcon(this.getClass().getResource("/imagenes/Altair.png"));
		this.mov[2] = new ImageIcon(this.getClass().getResource("/imagenes/Altair.png"));
		this.mov[3] = new ImageIcon(this.getClass().getResource("/imagenes/Altair.png"));
		this.dmovn = new ImageIcon(this.getClass().getResource("/imagenes/Altair.png"));
	}
	
	
	}

