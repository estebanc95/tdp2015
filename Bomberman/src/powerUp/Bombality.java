package powerUp;

import java.applet.AudioClip;

import celda.Celda;
import entidades.BombalityGrafica;
import logica.Nivel;
import personaje.Bomberman;
/**
 * Clase Bombality
 * @author Esteban Federico Canela y German Herrou
 *
 */

public class Bombality extends PowerUp {
	
	/**
	 * Constructor de Bombality
	 * @param n Nivel al que pertenece el PowerUp
	 */
	
	public Bombality(Nivel n){
		super(n);
	}
	
	public void activar(Bomberman b){
		b.aumentarMaxBombas();
		getNivel().aumentarPuntuacion(35);
		getNivel().procesarGrafico().removerPowerUp(this);
		b.getNivel().procesarGrafico().aumentarBombality();
		AudioClip poweru;
		poweru = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/Bonus.mid"));
		poweru.play();
	}
	
	public void ubicarEnCelda(Celda c){
		miCelda=c;
		miGrafico= new BombalityGrafica(c.getPosX(),c.getPosY());
	}

}
