package entidades;
import javax.swing.ImageIcon;
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
		
		this.mov[0] = new ImageIcon(this.getClass().getResource("/imagenes/SiriusDer.gif"));
		this.mov[1] = new ImageIcon(this.getClass().getResource("/imagenes/SiriusIzq.gif"));
		this.mov[2] = new ImageIcon(this.getClass().getResource("/imagenes/SiriusAdel.gif"));
		this.mov[3] = new ImageIcon(this.getClass().getResource("/imagenes/SiriusAtras.gif"));
		this.dmovn = new ImageIcon(this.getClass().getResource("/imagenes/Sirius-Centro.png"));
	}
	


}