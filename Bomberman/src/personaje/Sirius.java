package personaje;

import threads.ThreadSirius;
import bombas.Bomba;
import logica.Nivel;
import celda.Celda;

public class Sirius extends Enemigo {
	
	protected int maxBombas;
	protected int bColocadas;
	protected int alcance;

	public Sirius(Celda c,Nivel n){
		ThreadSirius tc=new ThreadSirius(this);
		super(tc,c,n,false);
		maxBombas=1;
		bColocadas=0;
		alcance=1;
	}
	
	public void pensar(){
		//hay que pensarlo
	}

	public void ColocarBomba(){
		if (maxBombas-bColocadas>0)
			new Bomba(miNivel,getCelda(),alcance);
			bColocadas++;
		}
	}
}
