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
	 * Retorna el nivel al que pertenece el personaje
	 * @return el nivel en el que se encuentra
	 */
	public Nivel getNivel(){
		return miNivel;
	}
	
	/**
	 * Setea la celda actual del Personaje
	 * @param c Celda en la cual se lo va a colocar
	 */
	
	public void setCelda(Celda c){
		miCelda=c;
	}
	
	/**
	 * Verifica si el Personaje es fantasma
	 * @return Verdadero si el Personaje es fantasma, Falso en caso contrario
	 */
	
	public boolean esFantasma(){
		return esFantasma;
	}
	
	/**
	 * Setea si el Personaje es Fantasma
	 * @param b Verdadero si quiere que el Personaje sea fantasma, Falso en caso contrario
	 */
	
	public void setFantasma (boolean b){
		esFantasma=b;
	}
	/**
	 * Grafico correspondiente con el Personaje
	 * @return grafico que posee dicho personaje
	 */
	
	public EntidadGrafica obtenerGrafico() {
		return miGrafico;
	}
	
	

}
