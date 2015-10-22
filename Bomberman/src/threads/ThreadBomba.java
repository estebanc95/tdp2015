package threads;

import java.util.LinkedList;
import java.util.Queue;

import bombas.Bomba;
/**
 * Clase Thread Bomba
 * @author Esteban Federico Canela y German Herrou
 *
 */
public class ThreadBomba extends Thread {

	//Atributos
	protected final int tiempo=1500;
	protected Queue<Bomba> miCola;

	/**
	 * Constructor de ThreadBomba
	 */
	public ThreadBomba() {
		miCola=new LinkedList<Bomba>();
	}
	
	/**
	 * Coloca las bombas que se quieren explotar
	 * @param b Bomba a explotarse 
	 */

	public void colocarBomba(Bomba b) {
		miCola.add(b);
	}

	/**
	 * Comienza a correr el hilo
	 */
	
	public void run() {
		try {
			while (true) {
				if (!miCola.isEmpty()) {
					sleep(tiempo);
					miCola.remove().explotar();
				}
			sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
