package personaje;

import logica.Nivel;
import celda.Celda;
import entidades.RugulosGrafica;

public class Rugulos extends Enemigo {

	public Rugulos(Celda c,Nivel n){
		super(c,n,false);
		miGrafico=new RugulosGrafica(velocidad,getCelda().getPosX(),getCelda().getPosY());
	}
	
	public void pensar(){
		//hay que pensarlo
	}
}
