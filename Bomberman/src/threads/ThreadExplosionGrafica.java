package threads;


import java.applet.AudioClip;

import bombas.Explosion;
import celda.Celda;
/**
 * Clase ThreadExplosionGrafica
 * @author Germán Herrou y Esteban Federico Canela
 *
 */
public class ThreadExplosionGrafica extends Thread {

	protected final int duracion = 100;

	protected int tipo;
	protected Celda c;
	/**
	 * Constructor ThreadExplosionGrafica
	 * @param tipo tipo de explosión (vertical, horizontal o centro).
	 * @param c Celda en la que se ubica la explosión.
	 */
	public ThreadExplosionGrafica(int tipo, Celda c) {
		setName("Explosion Grafica");
		if (tipo == 9)
			this.tipo = tipo;
		else
			this.tipo = tipo % 2;
		this.c = c;
	}
	/**
	 * Comienza a correr el hilo
	 */
	public void run() {
		try {
			Explosion e=new Explosion(tipo,c);
			c.getNivel().procesarGrafico()
					.agregarExplosion(e);
			if(tipo==9){
			AudioClip explot;
			explot = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/Explosion.mid"));
			explot.play();
			}
			sleep(duracion);
			c.getNivel().procesarGrafico()
					.quitarExplosion(e);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.interrupt();

	}

}
