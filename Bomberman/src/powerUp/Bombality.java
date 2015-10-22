package powerUp;

import celda.Celda;
import entidades.BombalityGrafica;
import logica.Nivel;
import personaje.Bomberman;

public class Bombality extends PowerUp {
	
	public Bombality(Nivel n){
		super(n);
	}
	
	public void activar(Bomberman b){
		b.aumentarMaxBombas();
		getNivel().aumentarPuntuacion(35);
		getNivel().removerPowerUp(this);
	}
	
	public void ubicarEnCelda(Celda c){
		miCelda=c;
		miGrafico= new BombalityGrafica(c.getPosX(),c.getPosY());
	}

}
