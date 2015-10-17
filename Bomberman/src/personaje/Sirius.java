package personaje;

import logica.Nivel;
import celda.Celda;

public class Sirius extends Enemigo {
	
	protected int maxBombas;
	protected int bColocadas;

	public Sirius(Celda c,Nivel n){
		super(new IASirius(),c,n,false);
		maxBombas=1;
		bColocadas=0;
	}
	
	public void pensar(){
		//hay que pensarlo
	}

	public void ColocarBomba(){
		if (maxBombas-bColocadas>0)
			new Bomba(getCelda(),alcance);
			bColocadas++;
		}
	}
}
