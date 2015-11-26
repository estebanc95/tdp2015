package threads;

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
				sleep(2000);
			} catch (InterruptedException e) {
			}

			int direccion = dir.remove(0);

			switch (direccion) {
			case Direccion.ARRIBA: {
				miEnemigo.moverArriba();
				System.out.println("Se movio arriba.");
				break;
			}
			case Direccion.DERECHA: {
				miEnemigo.moverDerecha();
				System.out.println("Se movio derecha.");
				break;
			}
			case Direccion.ABAJO: {
				miEnemigo.moverAbajo();
				System.out.println("Se movio abajo.");
				break;
			}
			case Direccion.IZQUIERDA: {
				miEnemigo.moverIzquierda();
				System.out.println("Se movio izquierda.");
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

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		List<Integer> res = new LinkedList<Integer>();

		Celda celdaSirius = miEnemigo.getCelda();
		
		int up = distancia(
				miNivel.getAdyacente(celdaSirius, Direccion.IZQUIERDA),
				miBomberman.getCelda());
		
		int left = distancia(miNivel.getAdyacente(celdaSirius, Direccion.ARRIBA),
				miBomberman.getCelda());
		
		if(up==left)
			left++;
		
		int right = distancia(
				miNivel.getAdyacente(celdaSirius, Direccion.DERECHA),
				miBomberman.getCelda());
		
		while(right==up||right==left)
			right++;
		
		int down = distancia(
				miNivel.getAdyacente(celdaSirius, Direccion.ABAJO),
				miBomberman.getCelda());
		
		while(down==up||down==left||down==right)
			down++;
		
		

		pq.add(up);
		pq.add(down);
		pq.add(left);
		pq.add(right);

		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		h.put(down, Direccion.ABAJO);
		h.put(left, Direccion.IZQUIERDA);
		h.put(up, Direccion.ARRIBA);
		h.put(right, Direccion.DERECHA);

		for (int i = 0; i < 4; i++) {
			res.add(h.get(pq.poll()));
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

	private int opuesto(int x) {
		switch (x) {
		case Direccion.ARRIBA:
			return Direccion.ABAJO;
		case Direccion.ABAJO:
			return Direccion.ARRIBA;
		case Direccion.DERECHA:
			return Direccion.IZQUIERDA;
		case Direccion.IZQUIERDA:
			return Direccion.DERECHA;
		default:
			return -1;
		}
	}
}
