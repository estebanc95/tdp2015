package herramientas;

public class Pair implements Comparable<Pair> {

	protected int e1;
	protected int e2;
	/**
	 * Crea un par de elementos enteros.
	 * @param k Primer elemento.
	 * @param v Segundo elemento.
	 */
	public Pair(int k, int v) {
		e1 = k;
		e2 = v;
	}
	
	public int compareTo(Pair p) {
		if (e1 > p.gete1())
			return 1;
		else if (e1 == p.gete1())
			return 0;
		else
			return -1;
	}
	/**
	 * Retorna el primer elemento.
	 * @return el primer elemento-
	 */
	public int gete1() {
		return e1;
	}
	/**
	 * Retorna el segundo elemento.
	 * @return el segundo elemento.
	 */
	public int gete2() {
		return e2;
	}

}
