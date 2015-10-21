package powerUp;

import logica.Nivel;
import personaje.Bomberman;

public class Masacrality extends PowerUp {
	
	public Masacrality(Nivel n){
		super(n);
		miGrafico=new MasacralityGrafica
	}
	
	public void activar(Bomberman b){
		b.duplicarAlcance();
		getNivel().aumentarPuntuacion(50);
	}

}
