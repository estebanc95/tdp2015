package threads;

import logica.Nivel;
import Gui.gui;
import personaje.Bomberman;

public class ThreadMovimiento extends Thread {
	
	protected Bomberman miBomberman;
	protected gui miGui;
	protected Nivel miNivel;
	
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