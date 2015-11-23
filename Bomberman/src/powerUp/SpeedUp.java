package powerUp;

import java.applet.AudioClip;

import celda.Celda;
import entidades.SpeedUpGrafica;
import logica.Nivel;
import personaje.Bomberman;

/**
 * Clase SpeedUp
 * @author Esteban Federico Canela y German Herrou
 *
 */

public class SpeedUp extends PowerUp {
	
	/**
	 * Constructor de SpeedUp
	 * @param n Nivel al que pertenece el PowerUp
	 */
	
	public SpeedUp(Nivel n){
		super(n);
	}
	
	public void activar(Bomberman b){
		b.duplicarVelocidad();
		getNivel().aumentarPuntuacion(30);
		getNivel().procesarGrafico().removerPowerUp(this);
		b.getNivel().procesarGrafico().aumentarSpeedUp();
		AudioClip poweru;
		poweru = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/Bonus.mid"));
		poweru.play();
		System.out.println("SpeedUp obtenido.");
	}
	
	public void ubicarEnCelda(Celda c){
		miCelda=c;
		miGrafico= new SpeedUpGrafica(c.getPosX(),c.getPosY());
	}

}
