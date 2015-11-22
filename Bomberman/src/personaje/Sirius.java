package personaje;

import threads.ThreadEnemigo;
import logica.Nivel;
import celda.Celda;
import entidades.SiriusGrafica;

/**
 * Clase Sirius 
 * @author Esteban Federico Canela y German Herrou
 *
 */

public class Sirius extends Enemigo {
	
	protected ThreadEnemigo th;

	/**
	 * Constructor de Sirius
	 * @param c Celda a la que pertenece
	 * @param n Nivel al que pertenece
	 */
	public Sirius(Celda c,Nivel n){
		super(c,n,false);
		miGrafico=new SiriusGrafica(velocidad,getCelda().getPosX(),getCelda().getPosY());
		th=new ThreadEnemigo(this);
		th.start();
	}
	
	public void morir(){
		super.morir();
		th.interrupt();
	}
	
	}