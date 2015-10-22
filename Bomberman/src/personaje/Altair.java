package personaje;

import logica.Nivel;
import celda.Celda;
import entidades.AltairGrafica;

/**
 * Clase Altair
 * @author Esteban Federico Canela y German Herrou
 *
 */

public class Altair extends Enemigo {
	
	/**
	 * Constructor de Altair
	 * @param c Celda a la que pertenece
	 * @param n Nivel al que pertenece el personaje
	 */

	public Altair(Celda c,Nivel n){
		super(c,n,true);
		miGrafico=new AltairGrafica(velocidad,getCelda().getPosX(),getCelda().getPosY());
	}
}