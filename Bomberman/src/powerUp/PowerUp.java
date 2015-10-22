package powerUp;

import celda.Celda;
import entidades.PowerUpGrafica;
import logica.Nivel;
import personaje.Bomberman;
/**
 * Clase PowerUp 
 * @author Esteban Federico Canela y German Herrou
 *
 */
public abstract class PowerUp {
	
	//Atributos
	protected Nivel miNivel;
	protected PowerUpGrafica miGrafico;
	protected Celda miCelda;
	
	/**
	 * Constructor de PowerUp
	 * @param n Nivel al que pertenece
	 */
	protected PowerUp(Nivel n){
		miNivel=n;
	}
	
	/**
	 * Activa el PowerUp a un Bomberman
	 * @param b Bomberman al que se le quiere aplicar el PowerUp
	 */
	
	public abstract void activar(Bomberman b);
	
	/**
	 * Ubica en una celda especifica el PowerUp
	 * @param c Celda en el cual se lo quiere ubicar
	 */
	
	public abstract void ubicarEnCelda(Celda c);
	
	/**
	 * Nivel al que pertenece el PowerUp
	 * @return Nivel en el cual esta el PowerUp
	 */
	
	public Nivel getNivel(){
		return miNivel;
	}
	
	/**
	 * Grafica del PowerUp
	 * @return la grafica que posee el PowerUp
	 */
	
	public PowerUpGrafica obtenerGrafico(){
		return miGrafico;
	}

}
