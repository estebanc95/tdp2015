package personaje;
import logica.Nivel;
import celda.Celda;
import entidades.EntidadGrafica;
/**
 * Clase genérica personaje.
 * @author Esteban Federico Canela, Germán Herrou
 *
 */
public abstract class Personaje {
	//Atributos
	protected Celda miCelda;
	protected boolean esFantasma;
	protected Nivel miNivel;
	protected EntidadGrafica miGrafico;
	/**
	 * Constructor de personaje
	 * @param c Celda en la que se ubica inicialmente.
	 * @param n Nivel al que pertenece el personaje.
	 * @param es Verdadero si el personaje puede atravesar paredes, falso en caso contrario.
	 */
	protected Personaje(Celda c,Nivel n,boolean es){
		miCelda=c;
		esFantasma=es;
		miNivel=n; 
	}
	/**
	 * Mueve al personaje arriba.
	 */
	public abstract void moverArriba();
	/**
	 * Mueve al personaje abajo.
	 */
	public abstract void moverAbajo();
	/**
	 * Mueve al personaje a la derecha.
	 */
	public abstract void moverDerecha();
	/**
	 * Mueve al personaje a la izquierda.
	 */
	public abstract void moverIzquierda();
	
	
	/**
	 * Retorna la celda en la que esta ubicada el personaje.
	 * @return Celda donde está el personaje.
	 */
	public Celda getCelda(){
		return miCelda;
	}
	/**
	 * Retorna el nivel al que pertenece el personalje
	 * @return
	 */
	public Nivel getNivel(){
		return miNivel;
	}
	
	public void setCelda(Celda c){
		miCelda=c;
	}
	
	public boolean esFantasma(){
		return esFantasma;
	}
	
	public void setFantasma (boolean b){
		esFantasma=b;
	}
	
	public EntidadGrafica obtenerGrafico() {
		return miGrafico;
	}
	
	

}
