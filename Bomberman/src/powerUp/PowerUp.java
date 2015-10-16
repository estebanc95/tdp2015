package powerUp;

import personaje.Bomberman;

public abstract class PowerUp {
	
	protected Nivel miNivel;
	
	protected PowerUp(Nivel n){
		miNivel=n;
	}
	
	public abstract void activar(Bomberman b);

}
