package powerUp;

import logica.Nivel;
import personaje.Bomberman;

public class Bombality extends PowerUp {
	
	public Bombality(Nivel n){
		super(n);
	}
	
	public void activar(Bomberman b){
		b.aumentarMaxBombas();
		getNivel().aumentarPuntuacion(35);
	}

}
