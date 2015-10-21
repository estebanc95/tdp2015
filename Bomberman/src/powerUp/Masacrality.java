package powerUp;

import logica.Nivel;
import personaje.Bomberman;

public class Masacrality extends PowerUp {
	
	public Masacrality(Nivel n){
		super(n);
	}
	
	public void activar(Bomberman b){
		b.duplicarAlcance();
		getNivel().aumentarPuntuacion(50);
	}

}
