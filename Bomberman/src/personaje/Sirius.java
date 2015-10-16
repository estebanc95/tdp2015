package personaje;

import celda.Celda;

public class Sirius extends Enemigo {
	
	protected int maxBombas;
	protected int bColocadas;

	public Sirius(IA i,Celda c,Nivel n){
		super(i,c,n,false);
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
