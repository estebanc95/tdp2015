package powerUp;

import personaje.Bomberman;

public class SpeedUp extends PowerUp {
	
	public SpeedUp(Nivel n){
		super(n);
	}
	
	public void activar(Bomberman b){
		b.duplicarVelocidad();
	}

}
