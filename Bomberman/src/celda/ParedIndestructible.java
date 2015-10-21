package celda;
import entidades.CeldaIndestructibleGrafica;
import personaje.Bomberman;
import personaje.Enemigo;

public class ParedIndestructible extends Estructura {

	public ParedIndestructible(Celda c) {
		super(c);
		this.graf = new CeldaIndestructibleGrafica(c.getPosX(),c.getPosY());
	}

	public void atravesar(Bomberman b) {
	}

	public void atravesar(Enemigo e) {
	}

	public void recibirExplosion() {
	}
}
