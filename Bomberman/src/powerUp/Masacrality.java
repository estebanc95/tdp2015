package powerUp;

import celda.Celda;
import entidades.MasacralityGrafica;
import logica.Nivel;
import personaje.Bomberman;

/**
 * Clase Masacrality
 * @author Esteban Federico Canela y German Herrou
 *
 */

public class Masacrality extends PowerUp {
	
	/**
	 * Constructor de Masacrality
	 * @param n Nivel al que pertenece el PowerUp
	 */
	
	public Masacrality(Nivel n){
		super(n);
	}
	
	public void activar(Bomberman b){
		b.duplicarAlcance();
		getNivel().aumentarPuntuacion(50);
		getNivel().removerPowerUp(this);
		b.getNivel().aumentarMasacrality();
		System.out.println("Masacrality obtenido.");
	}
	
	public void ubicarEnCelda(Celda c){
		miCelda=c;
		miGrafico= new MasacralityGrafica(c.getPosX(),c.getPosY());
	}

}
