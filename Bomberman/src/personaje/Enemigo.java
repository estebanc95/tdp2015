package personaje;
import logica.Nivel;
import celda.Celda;

/**
 * Clase Enemigo
 * @author Esteban Federico Canela y German Herrou
 *
 */

public abstract class Enemigo extends Personaje {
	
	//Atributos
	protected int velocidad;
	
	/**
	 * Constructor de Enemigo
	 * @param c Celda en la que esta el enemigo
	 * @param n Nivel al que pertenece el enemigo
	 * @param es Si es un enemigo fantasma
	 */
	
	protected Enemigo(Celda c,Nivel n,boolean es){
		super(c,n,es);
		velocidad=16;
	}
	
	/**
	 * Velocidad actual del enemigo
	 * @return la velocidad del enemigo
	 */
	
	public int getVelocidad(){
		return velocidad;
	}
	
	public void moverArriba(){
		miNivel.getAdyacente(miCelda,'a').atravesar(this,2);
	}
	
	public void moverAbajo(){
		miNivel.getAdyacente(miCelda,'b').atravesar(this,3);
	}
	
	public void moverDerecha(){
		miNivel.getAdyacente(miCelda,'d').atravesar(this,0);
	}
	
	public void moverIzquierda(){
		miNivel.getAdyacente(miCelda,'i').atravesar(this,1);
	}
	
	/**
	 * Elimina al enemigo del Nivel
	 */
	public void morir(){
		getNivel().destruirEnemigo(this);
	}
	

}
