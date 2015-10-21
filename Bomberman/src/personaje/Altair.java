package personaje;

import threads.ThreadEnemigo;
import logica.Nivel;
import celda.Celda;
import entidades.AltairGrafica;

public class Altair extends Enemigo {

	public Altair(ThreadEnemigo t,Celda c,Nivel n){
		super(t,c,n,true);
		miGrafico=new AltairGrafica(velocidad,getCelda().getPosX(),getCelda().getPosY());
	}
	
	public void pensar(){
		//hay que pensarlo
	}
}
