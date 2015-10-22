package powerUp;
import celda.Celda;
import entidades.FatalityGrafica;
import logica.Nivel;
import personaje.Bomberman;

public class Fatality extends PowerUp {
	
	public Fatality (Nivel n) {
		super(n);
	}
	
	public void activar (Bomberman b) {
		b.duplicarAlcance();
		getNivel().aumentarPuntuacion(35);
		getNivel().removerPowerUp(this);
	}
	
	public void ubicarEnCelda(Celda c){
		miCelda=c;
		miGrafico= new FatalityGrafica(c.getPosX(),c.getPosY());
	}

}
