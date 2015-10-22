package powerUp;

import celda.Celda;
import entidades.PowerUpGrafica;
import logica.Nivel;
import personaje.Bomberman;

public abstract class PowerUp {
	
	protected Nivel miNivel;
	protected PowerUpGrafica miGrafico;
	protected Celda miCelda;
	
	
	protected PowerUp(Nivel n){
		miNivel=n;
	}
	
	public abstract void activar(Bomberman b);
	
	public abstract void ubicarEnCelda(Celda c);
	
	public Nivel getNivel(){
		return miNivel;
	}
	
	public PowerUpGrafica obtenerGrafico(){
		return miGrafico;
	}

}
