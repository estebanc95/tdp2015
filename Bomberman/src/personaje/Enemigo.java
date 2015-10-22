package personaje;
import threads.ThreadEnemigo;
import logica.Nivel;
import celda.Celda;

public abstract class Enemigo extends Personaje {
	
	protected int velocidad;
	
	protected Enemigo(Celda c,Nivel n,boolean es){
		super(c,n,es);
		velocidad=10;
	}
	
	public int getVelocidad(){
		return velocidad;
	}
	
	public void moverArriba(){
		miNivel.getAdyacente(miCelda,'a').atravesar(this,2);
	}
	
	public void moverAbajo(){
		miNivel.getAdyacente(miCelda,'b').atravesar(this,3);
	}
	
	public void moverDerecha(){
		miNivel.getAdyacente(miCelda,'d').atravesar(this,0);
	}
	
	public void moverIzquierda(){
		miNivel.getAdyacente(miCelda,'i').atravesar(this,1);
	}
	
	public abstract void pensar();
	
	public void morir(){
		getNivel().destruirEnemigo(this);
	}
	

}
