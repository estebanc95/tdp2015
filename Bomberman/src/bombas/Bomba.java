package bombas;

import personaje.Bomberman;
import threads.ThreadBomba;
import celda.Celda;
import entidades.BombaGrafica;
import entidades.EntidadGrafica;
import logica.Nivel;

public class Bomba {

	protected int alcance;
	protected Nivel miNivel;
	protected Celda miCelda;
	protected Bomberman miBomberman;
	protected int tiempo;
	protected BombaGrafica graf;
	
	public Bomba(Nivel n,int a,Celda c,Bomberman b){
		miNivel=n;
		alcance=a;
		miCelda=c;
		miBomberman=b;
		tiempo=6000;
		graf = new BombaGrafica (miCelda.getPosX(),miCelda.getPosY());	
		miNivel.agregarBomba(this);
	}
	
	
	
	public void explotar(){
		explotarAux(alcance,'a',miCelda);
		explotarAux(alcance,'b',miCelda);
		explotarAux(alcance,'d',miCelda);
		explotarAux(alcance,'i',miCelda);
		miNivel.removerBomba(this);
			
		}
	
	public BombaGrafica obtenerGrafico() {
		return graf;
	}
		
	
	private void explotarAux(int a,char x,Celda c){
		if(a>0){
			Celda sig=miNivel.getAdyacente(c, x);
			sig.recibirExplosion();
			explotarAux(a-1,x,sig);
		}
	}
	
}
