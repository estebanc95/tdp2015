package powerUp;

import entidades.PowerUpGrafica;
import logica.Nivel;
import personaje.Bomberman;

public abstract class PowerUp {
	
	protected Nivel miNivel;
	protected PowerUpGrafica miGrafico;
	
	protected PowerUp(Nivel n){
		miNivel=n;
	}
	
	public abstract void activar(Bomberman b);
	
	public Nivel getNivel(){
		return miNivel;
	}

}
