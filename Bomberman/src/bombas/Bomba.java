package bombas;

import personaje.Bomberman;
import celda.Celda;
import entidades.BombaGrafica;
import logica.Nivel;

/**
 * Clase Bomba. 
 * @author Esteban Federico
 *
 */

public class Bomba {
	
	//Atributos 
	protected int alcance;
	protected Nivel miNivel;
	protected Celda miCelda;
	protected Bomberman miBomberman;
	protected int tiempo;
	protected BombaGrafica graf;
	/**
	 *  Constructor de Bomba
	 * @param n Nivel
	 * @param a Alcance de la bomba
	 * @param c Celda donde esta ubicada la bomba
	 * @param b Bomberman que coloco la bomba
	 */
	
	public Bomba(Nivel n,int a,Celda c,Bomberman b){
		miNivel=n;
		alcance=a;
		miCelda=c;
		miBomberman=b;
		tiempo=6000;
		graf = new BombaGrafica (miCelda.getPosX(),miCelda.getPosY());	
		miNivel.agregarBomba(this);
	}
	

	/**
	 * Explota la bomba pasado un tiempo. La explosion se propaga a las celdas adyacentes de acuerdo al alcance.
	 */
	public void explotar(){
		miCelda.recibirExplosion(alcance,'x');
		miNivel.getAdyacente(miCelda,'a').recibirExplosion(alcance,'a');
		miNivel.getAdyacente(miCelda,'b').recibirExplosion(alcance,'b');
		miNivel.getAdyacente(miCelda,'d').recibirExplosion(alcance,'d');
		miNivel.getAdyacente(miCelda,'i').recibirExplosion(alcance,'i');
		miNivel.removerBomba(this);
		miBomberman.bombaExploto();
		}
	
	/**
	 *  Retorna la entidad grafica de la Bomba.
	 * @return Grafico de la bomba.
	 */
	
	public BombaGrafica obtenerGrafico() {
		return graf;
	}
		
	
}
