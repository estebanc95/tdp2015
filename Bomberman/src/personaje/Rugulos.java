package personaje;

import logica.Nivel;
import celda.Celda;
import entidades.RugulosGrafica;

/**
 * Clase Rugulos 
 * @author Esteban Federico Canela y German Herrou
 *
 */

public class Rugulos extends Enemigo {

	/**
	 * Constructor de Rugulos
	 * @param c Celda a la que pertenece
	 * @param n Nivel al que pertenece
	 */
	public Rugulos(Celda c,Nivel n){
		super(c,n,false);
		miGrafico=new RugulosGrafica(velocidad,getCelda().getPosX(),getCelda().getPosY());
	}
	
}
