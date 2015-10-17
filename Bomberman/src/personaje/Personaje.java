package personaje;
import logica.Nivel;
import celda.Celda;

public abstract class Personaje {
	
	protected Celda miCelda;
	protected boolean esFantasma;
	protected Nivel miNivel;
	
	protected Personaje(Celda c,Nivel n,boolean es){
		miCelda=c;
		esFantasma=es;
		miNivel=n;
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
	//Es necesario implementar morir?
	
	public Celda getCelda(){
		return miCelda;
	}
	
	public void setCelda(Celda c){
		miCelda=c;
	}
	
	public boolean esFantasma(){
		return esFantasma;
	}
	
	public void setFantasma (boolean b){
		esFantasma=b;
	}
	
	

}
