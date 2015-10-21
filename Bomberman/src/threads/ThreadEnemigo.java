package threads;

import java.util.Random;

import personaje.Enemigo;

public class ThreadEnemigo extends Thread {

	protected Enemigo miEnemigo;
	protected boolean activar;
	protected Random rnd;

	public ThreadEnemigo(Enemigo e) {
		miEnemigo = e;
		activar = true;
		rnd = new Random();
		run();
	}

	public void run() {
		while (activar) {
			try {
				sleep(3000);
				int direccion = rnd.nextInt(4);
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
	
	public void detener() {
		this.interrupt(); 
		
		activar=false;
		//preguntar
	}
	
	public void destruir() {
		this.detener();
		miEnemigo.morir();
	}

}
