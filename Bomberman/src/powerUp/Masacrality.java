package powerUp;

import java.applet.AudioClip;

import celda.Celda;
import entidades.MasacralityGrafica;
import logica.Nivel;
import personaje.Bomberman;
import threads.ThreadMasacrality;

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
		ThreadMasacrality th=new ThreadMasacrality(b);
		th.start();
		getNivel().aumentarPuntuacion(50);
		getNivel().procesarGrafico().removerPowerUp(this);
		b.getNivel().procesarGrafico().aumentarMasacrality();
		AudioClip poweru;
		poweru = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/Bonus.mid"));
		poweru.play();
		System.out.println("Masacrality obtenido.");
	}
	
	public void ubicarEnCelda(Celda c){
		miCelda=c;
		miGrafico= new MasacralityGrafica(c.getPosX(),c.getPosY());
	}

}
