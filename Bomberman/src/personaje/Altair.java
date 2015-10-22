package personaje;

import logica.Nivel;
import celda.Celda;
import entidades.AltairGrafica;

public class Altair extends Enemigo {

	public Altair(Celda c,Nivel n){
		super(c,n,true);
		miGrafico=new AltairGrafica(velocidad,getCelda().getPosX(),getCelda().getPosY());
	}
	
	public void pensar(){
		//hay que pensarlo
	}
}
