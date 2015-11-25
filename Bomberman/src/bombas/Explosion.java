package bombas;

import celda.Celda;
import entidades.ExplosionGrafica;
/**
 * Clase explosión.
 * @author Germán Herrou, Esteban Federico Canela
 *
 */
public class Explosion {
	
	protected ExplosionGrafica graf;
	/**
	 * Constructor de Explosión
	 * @param tipo Tipo de explosión (Horizontal, vertical o centro).
	 * @param c Celda que recibe la explosión.
	 */
	public Explosion(int tipo, Celda c){
		graf=new ExplosionGrafica(c.getPosX(),c.getPosY(),tipo);
	}
	/**
	 * Retorna el gráfico de la explosión.
	 * @return Gráfico de la explosión.
	 */
	public ExplosionGrafica obtenerGrafico() {
		return graf;
	}
	

}
