package personaje;
import logica.Nivel;
import celda.Celda;

public abstract class Enemigo extends Personaje {
	
	protected int velocidad;
	protected IA miIA;
	
	protected Enemigo(IA i,Celda c,Nivel n,boolean es){
		super(c,n,es);
		velocidad=1;
		miIA=i;
	}
	
	public int getVelocidad(){
		return velocidad;
	}
	
	public abstract void pensar();
	

}
