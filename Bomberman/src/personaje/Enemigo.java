package personaje;
import threads.ThreadEnemigo;
import logica.Nivel;
import celda.Celda;

public abstract class Enemigo extends Personaje {
	
	protected int velocidad;
	protected ThreadEnemigo ia;
	
	protected Enemigo(ThreadEnemigo t,Celda c,Nivel n,boolean es){
		super(c,n,es);
		velocidad=1;
		ia=t;
		ia.run();
	}
	
	public int getVelocidad(){
		return velocidad;
	}
	
	public void moverArriba(){
		miNivel.getAdyacente(miCelda,'a').atravesar(this);
	}
	
	public void moverAbajo(){
		miNivel.getAdyacente(miCelda,'b').atravesar(this);
	}
	
	public void moverDerecha(){
		miNivel.getAdyacente(miCelda,'d').atravesar(this);
	}
	
	public void moverIzquierda(){
		miNivel.getAdyacente(miCelda,'i').atravesar(this);
	}
	
	public abstract void pensar();
	
	public void morir(){
		getNivel().destruirEnemigo(this);
	}
	

}
