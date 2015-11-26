package threads;

import personaje.Bomberman;
/**
 * Clase Thread Fatality
 * @author Esteban Federico Canela y German Herrou
 *
 */
public class ThreadMasacrality extends Thread {
	
	//Atributos
	protected final int duracion=15000;
	protected Bomberman miBomberman;
	
	/**
	 * Constructor de Thread Fatality
	 * @param b Bomberman que recibe el PowerUp
	 */
	public ThreadMasacrality(Bomberman b){
		miBomberman=b;
	}
	
	/**
	 * Comienza a correr el hilo
	 */
	
	public void run(){
		try {
			miBomberman.setFantasma(true);
			sleep(duracion);
			miBomberman.setFantasma(false);
			this.interrupt();
			miBomberman.getNivel().procesarGrafico().desactivarMassa();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
