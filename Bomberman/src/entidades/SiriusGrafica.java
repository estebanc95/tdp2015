package entidades;
import javax.swing.ImageIcon;

import logica.Direccion;
/**
 * Clase SiriusGrafica
 * @author Esteban Federico Canela y German Herrou
 *
 */
public class SiriusGrafica extends EntidadGrafica{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor SiriusGrafica
	 * @param vel velocidad del Sirius
	 * @param x posicion X
	 * @param y posicion Y
	 */
	public SiriusGrafica (int vel, int x, int y) {
		super(vel, x, y);
		
		this.mov[Direccion.DERECHA] = new ImageIcon(this.getClass().getResource("/imagenes/SiriusDer.gif"));
		this.mov[Direccion.IZQUIERDA] = new ImageIcon(this.getClass().getResource("/imagenes/SiriusIzq.gif"));
		this.mov[Direccion.ARRIBA] = new ImageIcon(this.getClass().getResource("/imagenes/SiriusAdel.gif"));
		this.mov[Direccion.ABAJO] = new ImageIcon(this.getClass().getResource("/imagenes/SiriusAtras.gif"));
		this.dmovn = new ImageIcon(this.getClass().getResource("/imagenes/Sirius-Centro.png"));
	}
	


}