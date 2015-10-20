package bombas;

import personaje.Bomberman;
import celda.Celda;
import logica.Nivel;

public class Bomba {

	protected int alcance;
	protected Nivel miNivel;
	protected Celda miCelda;
	protected Bomberman miBomberman;
	protected int tiempo;
	
	public Bomba(Nivel n,int a,Celda c,Bomberman b){
		miNivel=n;
		alcance=a;
		miCelda=c;
		miBomberman=b;
		tiempo=4000;
		
		
	}
	
	public void explotar(){
		for(int i=1;i<4;i++)
		
	}
}
