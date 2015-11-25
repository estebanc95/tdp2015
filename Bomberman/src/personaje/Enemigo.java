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
	protected int puntos;
	
	/**
	 * Constructor de Enemigo
	 * @param c Celda en la que esta el enemigo
	 * @param n Nivel al que pertenece el enemigo
	 * @param es Si es un enemigo fantasma
	 * @param p puntos que otorga al morir
	 */
	
	protected Enemigo(Celda c,Nivel n,boolean es,int p){
		super(c,n,es);
		velocidad=16;
		puntos=p;
	}
	
	/**
	 * Velocidad actual del enemigo
	 * @return la velocidad del enemigo
	 */
	
	public int getVelocidad(){
		return velocidad;
	}
	
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
	public void morir(){
		miNivel.aumentarPuntuacion(puntos);
	}
	

}
