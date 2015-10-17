package powerUp;
import logica.Nivel;
import personaje.Bomberman;

public class Fatality extends PowerUp {
	
	public Fatality (Nivel n) {
		super(n);
	}
	
	public void activar (Bomberman b) {
		b.duplicarAlcance();
	}

}
