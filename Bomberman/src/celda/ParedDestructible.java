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
			b.obtenerGrafico().mover(dir);
			miCelda.colocar(b);
		}
	}

	public void atravesar(Enemigo e, int dir) {
		if (e.esFantasma()){
			e.obtenerGrafico().mover(dir);
			miCelda.colocar(e);
		}
	}

	public void recibirExplosion(int dir) {
		miCelda.getNivel().procesarGrafico().quitarPared(miCelda);
		miCelda.getNivel().procesarGrafico().mostrarExplosion(miCelda,dir);
		if (miCelda.getNivel().gano())
			miCelda.getNivel().procesarGrafico().mostrarVictoria();

	}
}