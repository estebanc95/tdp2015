package threads;

import herramientas.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import logica.Direccion;
import logica.Nivel;
import celda.Celda;
import personaje.Bomberman;
import personaje.Sirius;
/**
 * Clase ThreadSirius
 * @author Germán Herrou, Esteban Federico Canela
 *
 */
public class ThreadSirius extends ThreadEnemigo {

	protected Nivel miNivel;
	protected Bomberman miBomberman;
	protected Celda celdaAnterior;
	/**
	 * Constructor ThreadSirius
	 * @param s Sirius que se mueve.
	 * @param n Nivel en el que se mueve.
	 * @param b Bomberman al que persigue.
	 */
	public ThreadSirius(Sirius s, Nivel n, Bomberman b) {
		super(s);
		miNivel = n;
		miBomberman = b;
		celdaAnterior = s.getCelda();
	}
	/**
	 * Comienza a correr el hilo.
	 */
	public void run() {
		try {
			sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Integer> dir = dirPrioridad();
		while (activar) {
			try {
				sleep(800);
			} catch (InterruptedException e) {
			}

			int direccion = dir.remove(0);

			switch (direccion) {
			case Direccion.ARRIBA: {
				miEnemigo.moverArriba();
				break;
			}
			case Direccion.DERECHA: {
				miEnemigo.moverDerecha();
				break;
			}
			case Direccion.ABAJO: {
				miEnemigo.moverAbajo();
				break;
			}
			case Direccion.IZQUIERDA: {
				miEnemigo.moverIzquierda();
				break;
			}
			}

			if (pudoMoverse() || dir.isEmpty()) {
				dir = dirPrioridad();
			}
			celdaAnterior = miEnemigo.getCelda();
		}
	}

	private List<Integer> dirPrioridad() {

		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		List<Integer> res = new LinkedList<Integer>();

		Celda celdaSirius = miEnemigo.getCelda();
		
		int up = distancia(
				miNivel.getAdyacente(celdaSirius, Direccion.ARRIBA),
				miBomberman.getCelda());
		
		int left = distancia(miNivel.getAdyacente(celdaSirius, Direccion.IZQUIERDA),
				miBomberman.getCelda());
		
		int right = distancia(
				miNivel.getAdyacente(celdaSirius, Direccion.DERECHA),
				miBomberman.getCelda());
		
		int down = distancia(
				miNivel.getAdyacente(celdaSirius, Direccion.ABAJO),
				miBomberman.getCelda());
		
		pq.add(new Pair(up,Direccion.ARRIBA));
		pq.add(new Pair(left,Direccion.IZQUIERDA));
		pq.add(new Pair(right,Direccion.DERECHA));
		pq.add(new Pair(down,Direccion.ABAJO));

		for (int i = 0; i < 4; i++) {
			res.add(pq.poll().gete2());
		}

		return res;

	}

	private int distancia(Celda c, Celda d) {
		int dx = Math.abs(c.getPosX() - d.getPosX());
		int dy = Math.abs(c.getPosY() - d.getPosY());
		return dx + dy;
	}

	private boolean pudoMoverse() {
		return celdaAnterior != miEnemigo.getCelda();
	}

}
