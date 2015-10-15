package celda;

public abstract class Estructura {

	protected Celda miCelda;
	
	protected Estructura(Celda c){
		miCelda=c;
	}
	
	public abstract void atravesar(Bomberman b);
	public abstract void atravesar(Enemigo e);
	public abstract void recibirExplosion();
}
