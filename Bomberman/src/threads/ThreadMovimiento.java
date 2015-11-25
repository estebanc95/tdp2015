package threads;

import logica.Nivel;
import Gui.gui;
import personaje.Bomberman;
/**
 * Clase ThreadMovimiento
 * @author Germán Herrou, Esteban Federico Canela
 *
 */
public class ThreadMovimiento extends Thread {
	
	protected Bomberman miBomberman;
	protected gui miGui;
	protected Nivel miNivel;
	/**
	 * Constructor ThreadMovimiento
	 * @param b Bomberman que se desea mover.
	 * @param g Gui en la que se mueve el bomberman.
	 * @param n Nivel en el que se mueve el bomberman.
	 */
	public ThreadMovimiento (Bomberman b, gui g, Nivel n) {
		miBomberman = b;
		miGui= g;
		miNivel = n;
	}
	
	public void run () {
		try {
			//Tiempo para que se inicializen todos los elementos lógicos.
			sleep(250);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(true) {
			try {
				sleep(100);
				if(miGui.estaBloqueado()){
					miNivel.moverPersonaje(miGui.getDir());
					miGui.desbloquear();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}