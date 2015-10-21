package personaje;

import threads.ThreadEnemigo;
import logica.Nivel;
import celda.Celda;
import entidades.RugulosGrafica;

public class Rugulos extends Enemigo {

	public Rugulos(ThreadEnemigo t,Celda c,Nivel n){
		super(t,c,n,false);
		miGrafico=new RugulosGrafica(velocidad,getCelda().getPosX(),getCelda().getPosY());
	}
	
	public void pensar(){
		//hay que pensarlo
	}
}
