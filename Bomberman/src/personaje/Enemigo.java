package personaje;
import logica.Direccion;
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
	
	//Ubicaciones adyacentes: 0 arriba, 1 derecha, 2 centro, 3 abajo, 4 izquierda
		public void moverArriba(){
			miNivel.getAdyacente(miCelda,Direccion.ARRIBA).atravesar(this,Direccion.ARRIBA);
		}
		
		public void moverAbajo(){
			miNivel.getAdyacente(miCelda,Direccion.ABAJO).atravesar(this,Direccion.ABAJO);
		}
		
		
		public void moverDerecha(){
				miNivel.getAdyacente(miCelda,Direccion.DERECHA).atravesar(this,Direccion.DERECHA);
		}
		
		
		public void moverIzquierda(){
			miNivel.getAdyacente(miCelda,Direccion.IZQUIERDA).atravesar(this,Direccion.IZQUIERDA);
		}
		
	
	/**
	 * Elimina al enemigo del Nivel
	 */
	public abstract void morir();
	

}
