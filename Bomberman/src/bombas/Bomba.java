package bombas;

import personaje.Bomberman;
import celda.Celda;
import entidades.BombaGrafica;
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
		tiempo=4000;
		graf = new BombaGrafica (miCelda.getPosX(),miCelda.getPosY());	
	}
	
	
	
	public void explotar(){
		explotarAux(alcance,'a',miCelda);
		explotarAux(alcance,'b',miCelda);
		explotarAux(alcance,'d',miCelda);
		explotarAux(alcance,'i',miCelda);
			
		}
		
	
	private void explotarAux(int a,char x,Celda c){
		if(a>0){
			Celda sig=miNivel.getAdyacente(c, x);
			sig.recibirExplosion();
			explotarAux(a-1,x,sig);
		}
	}
}
