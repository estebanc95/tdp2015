package threads;

import javax.swing.ImageIcon;

import bombas.Explosion;
import celda.Celda;

public class ThreadExplosionGrafica extends Thread {

	protected final int duracion = 100;

	protected int tipo;
	protected Celda c;

	public ThreadExplosionGrafica(int tipo, Celda c) {
		if (tipo == 9)
			this.tipo = tipo;
		else
			this.tipo = tipo % 2;
		this.c = c;
	}

	public void run() {
		try {
			Explosion e=new Explosion(tipo,c);
			c.getNivel().procesarGrafico()
					.agregarExplosion(e);
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
