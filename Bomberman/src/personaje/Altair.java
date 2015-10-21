package personaje;

import threads.ThreadEnemigo;
import logica.Nivel;
import celda.Celda;

public class Altair extends Enemigo {

	public Altair(ThreadEnemigo t,Celda c,Nivel n){
		super(t,c,n,true);
	}
	
	public void pensar(){
		//hay que pensarlo
	}
}
