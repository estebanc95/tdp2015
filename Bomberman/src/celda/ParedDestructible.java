package celda;

import entidades.CeldaDestructibleGrafica;
import personaje.Bomberman;
import personaje.Enemigo;

/**
 * Clase Pared Destructible
 * 
 * @author Esteban Federico Canela y German Herrou
 *
 */

public class ParedDestructible extends Estructura {

	/**
	 * Constructo de Pared Destructible
	 * 
	 * @param c
	 *            Celda a la que pertenece la estructura
	 */
	public ParedDestructible(Celda c) {
		super(c);
		this.graf = new CeldaDestructibleGrafica(c.getPosX(), c.getPosY());
	}

	public void atravesar(Bomberman b, int dir) {
		if (b.esFantasma()) {
			miCelda.colocar(b);
			b.obtenerGrafico().mover(dir);
		}
	}

	public void atravesar(Enemigo e, int dir) {
		if (e.esFantasma()){
			miCelda.colocar(e);
			e.obtenerGrafico().mover(dir);
		}
	}

	public void recibirExplosion() {
		miCelda.getNivel().quitarPared(miCelda);
		if (miCelda.getNivel().gano())
			miCelda.getNivel().victoria();

	}
}