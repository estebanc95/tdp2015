package celda;
import entidades.CeldaGrafica;
import personaje.Bomberman;
import personaje.Enemigo;

public abstract class Estructura {

	protected Celda miCelda;
	protected CeldaGrafica graf;
	
	protected Estructura(Celda c){
		miCelda=c;
	}
	
	public abstract void atravesar(Bomberman b);
	public abstract void atravesar(Enemigo e);
	public abstract void recibirExplosion();
	public CeldaGrafica getCeldaGrafica () {
		return graf;
		}
	}
