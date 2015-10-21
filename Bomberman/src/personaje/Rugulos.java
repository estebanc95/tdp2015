package personaje;

import threads.ThreadEnemigo;
import logica.Nivel;
import celda.Celda;

public class Rugulos extends Enemigo {

	public Rugulos(ThreadEnemigo t,Celda c,Nivel n){
		super(t,c,n,false);
	}
	
	public void pensar(){
		//hay que pensarlo
	}
}
