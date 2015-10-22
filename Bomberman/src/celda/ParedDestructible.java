package celda;
import entidades.CeldaDestructibleGrafica;
import personaje.Bomberman;
import personaje.Enemigo;

/**
 * Clase Pared Destructible
 * @author Esteban Federico Canela y German Herrou
 *
 */

public class ParedDestructible extends Estructura {

	/**
	 * Constructo de Pared Destructible
	 * @param c Celda a la que pertenece la estructura
	 */
	public ParedDestructible(Celda c) {
		super(c);
		this.graf = new CeldaDestructibleGrafica (c.getPosX(),c.getPosY());
	}

	public void atravesar(Bomberman b) {
		if (b.esFantasma())
			miCelda.colocar(b);
	}

	public void atravesar(Enemigo e) {
		if (e.esFantasma())
			miCelda.colocar(e);
	}
	
	public void recibirExplosion(){
		miCelda.getNivel().quitarPared(miCelda);
		
	}
}