package personaje;
import celda.Celda;

public abstract class Enemigo {
	
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
	
	public void pensar(){
		//Hay que pensarlo
	}

}
