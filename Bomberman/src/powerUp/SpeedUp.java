package powerUp;

import celda.Celda;
import entidades.SpeedUpGrafica;
import logica.Nivel;
import personaje.Bomberman;

public class SpeedUp extends PowerUp {
	
	public SpeedUp(Nivel n){
		super(n);
	}
	
	public void activar(Bomberman b){
		b.duplicarVelocidad();
		getNivel().aumentarPuntuacion(30);
		getNivel().removerPowerUp(this);
	}
	
	public void ubicarEnCelda(Celda c){
		miCelda=c;
		miGrafico= new SpeedUpGrafica(c.getPosX(),c.getPosY());
	}

}
