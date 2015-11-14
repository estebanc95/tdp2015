package bombas;

import celda.Celda;
import entidades.ExplosionGrafica;

public class Explosion {
	
	protected ExplosionGrafica graf;
	
	public Explosion(int tipo, Celda c){
		graf=new ExplosionGrafica(c.getPosX(),c.getPosY(),tipo);
	}

	public ExplosionGrafica obtenerGrafico() {
		return graf;
	}
	

}
