package personaje;

import threads.ThreadEnemigo;
import logica.Nivel;
import celda.Celda;
import entidades.AltairGrafica;

/**
 * Clase Altair
 * @author Esteban Federico Canela y German Herrou
 *
 */

public class Altair extends Enemigo {
	
	protected ThreadEnemigo th;
	
	/**
	 * Constructor de Altair
	 * @param c Celda a la que pertenece
	 * @param n Nivel al que pertenece el personaje
	 */

	public Altair(Celda c,Nivel n){
		super(c,n,true);
		miGrafico=new AltairGrafica(velocidad,getCelda().getPosX(),getCelda().getPosY());
		th=new ThreadEnemigo(this);
		th.start();
	}
	
	public void morir(){
		super.morir();
		th.interrupt();
	}
	
	}