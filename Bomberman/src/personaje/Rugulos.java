package personaje;

import logica.Nivel;
import celda.Celda;
import entidades.RugulosGrafica;
import threads.ThreadEnemigo;

/**
 * Clase Rugulos 
 * @author Esteban Federico Canela y German Herrou
 *
 */

public class Rugulos extends Enemigo {
	
	protected ThreadEnemigo th;
	

	/**
	 * Constructor de Rugulos
	 * @param c Celda a la que pertenece
	 * @param n Nivel al que pertenece
	 */
	public Rugulos(Celda c,Nivel n){
		super(c,n,false);
		miGrafico=new RugulosGrafica(velocidad,getCelda().getPosX(),getCelda().getPosY());
		th=new ThreadEnemigo(this);
		th.start();
	}
	
	public void morir(){
		super.morir();
		th.interrupt();
	}
	
}
