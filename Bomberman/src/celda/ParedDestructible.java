package celda;
import personaje.Bomberman;
import personaje.Enemigo;

public class ParedDestructible extends Estructura {

	public ParedDestructible(Celda c) {
		super(c);
	}

	public void atravesar(Bomberman b) {
		if (b.esFantasma())
			miCelda.colocar(b);
	}

	public void atravesar(Enemigo e) {
		if (e.esFantasma())
			miCelda.colocar(e);
	}
	
	public void recibirExplosion(){
		miCelda.setEstructura(null);
	}
}