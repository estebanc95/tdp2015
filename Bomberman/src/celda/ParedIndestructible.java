package celda;
import entidades.CeldaIndestructibleGrafica;
import personaje.Bomberman;
import personaje.Enemigo;

/**
 * Clase Pared Indestructible 
 * @author Esteban Federico Canela y German Herrou
 *
 */

public class ParedIndestructible extends Estructura {

	/**
	 * Constructor de Pared Indestructible
	 * @param c Celda a la que pertenece esta estructura
	 */
	public ParedIndestructible(Celda c) {
		super(c);
		this.graf = new CeldaIndestructibleGrafica(c.getPosX(),c.getPosY());
	}

	public void atravesar(Bomberman b) {
	}

	public void atravesar(Enemigo e) {
	}

	public void recibirExplosion() {
	}
}
