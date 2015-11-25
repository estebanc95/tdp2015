package personaje;

import threads.ThreadEnemigo;
import threads.ThreadSirius;
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
	 * @param b Bomberman al que debe perseguir
	 */
	public Sirius(Celda c,Nivel n,Bomberman b){
		super(c,n,false,50);
		miGrafico=new SiriusGrafica(velocidad,getCelda().getPosX(),getCelda().getPosY());
		th=new ThreadSirius(this,n,b);
		th.start();
	}
	
	public void morir(){
		super.morir();
		th.detener();
	}
	
	}