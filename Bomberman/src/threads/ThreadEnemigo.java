package threads;

import java.util.Random;

import personaje.Enemigo;

/**
 * Clase Thread Enemigo
 * @author Esteban Federico Canela y German Herrou
 *
 */

public class ThreadEnemigo extends Thread {

	//Atributos
	protected Enemigo miEnemigo;
	protected boolean activar;
	protected Random rnd;
	
	/**
	 * Constructor ThreadEnemigo
	 * @param e Enemigo que inicia el hilo
	 */

	public ThreadEnemigo(Enemigo e) {
		miEnemigo = e;
		activar = true;
		rnd = new Random();
	}
	
	/**
	 * Comienza a correr el hilo
	 */

	public void run() {
		while (activar) {
			try {
				sleep(3000);
				int direccion = rnd.nextInt(3);
				switch (direccion) {
				case 0: {
					miEnemigo.moverArriba();
					break;
				}
				case 1: {
					miEnemigo.moverDerecha();
					break;
				}
				case 2: {
					miEnemigo.moverAbajo();
					break;
				}
				case 3: {
					miEnemigo.moverIzquierda();
					break;
				}

				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	/**
	 * Detener el hilo
	 */
	public void detener() {
		this.interrupt();
		activar=false;
	}
	
	/**
	 * Matar al enemigo
	 */
	public void destruir() {
		this.detener();
		miEnemigo.morir();
	}

}
