package threads;

import personaje.Bomberman;
/**
 * Clase Thread Fatality
 * @author Esteban Federico Canela y German Herrou
 *
 */
public class ThreadFatality extends Thread {
	
	//Atributos
	protected final int duracion=5000;
	protected Bomberman miBomberman;
	
	/**
	 * Constructor de Thread Fatality
	 * @param b Bomberman que recibe el PowerUp
	 */
	public ThreadFatality(Bomberman b){
		miBomberman=b;
	}
	
	/**
	 * Comienza a correr el hilo
	 */
	
	public void run(){
		try {
			miBomberman.setFantasma(true);
			System.out.println("Inicio modo dios.");
			sleep(duracion);
			miBomberman.setFantasma(false);
			System.out.println("Fin modo dios.");
			this.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
