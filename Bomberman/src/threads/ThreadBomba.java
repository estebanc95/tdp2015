package threads;

import java.util.LinkedList;
import java.util.Queue;

import bombas.Bomba;

public class ThreadBomba extends Thread {

	protected final int tiempo=1500;
	protected Queue<Bomba> miCola;

	public ThreadBomba() {
		miCola=new LinkedList<Bomba>();
	}

	public void colocarBomba(Bomba b) {
		miCola.add(b);
	}

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
