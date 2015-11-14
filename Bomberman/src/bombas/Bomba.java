package bombas;

import personaje.Bomberman;
import celda.Celda;
import entidades.BombaGrafica;
import logica.Direccion;
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
		miNivel.procesarGrafico().agregarBomba(this);
	}
	

	/**
	 * Explota la bomba pasado un tiempo. La explosion se propaga a las celdas adyacentes de acuerdo al alcance.
	 * 0 arriba, 1 derecha, 2 centro, 3 abajo, 4 izquierda
	 */
	public void explotar(){
		miCelda.recibirExplosion(alcance,9);
		
		
		miNivel.getAdyacente(miCelda,Direccion.ARRIBA).recibirExplosion(alcance,Direccion.ARRIBA);
		
		miNivel.getAdyacente(miCelda,Direccion.ABAJO).recibirExplosion(alcance,Direccion.ABAJO);
		
		miNivel.getAdyacente(miCelda,Direccion.DERECHA).recibirExplosion(alcance,Direccion.DERECHA);
		
		miNivel.getAdyacente(miCelda,Direccion.IZQUIERDA).recibirExplosion(alcance,Direccion.IZQUIERDA);
		
		miNivel.procesarGrafico().removerBomba(this);
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
