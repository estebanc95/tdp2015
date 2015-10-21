package personaje;
import logica.Nivel;
import celda.Celda;
import entidades.EntidadGrafica;

public abstract class Personaje {
	
	protected Celda miCelda;
	protected boolean esFantasma;
	protected Nivel miNivel;
	protected EntidadGrafica miGrafico;
	
	protected Personaje(Celda c,Nivel n,boolean es){
		miCelda=c;
		esFantasma=es;
		miNivel=n; 
	}
	
	public abstract void moverArriba();
	
	public abstract void moverAbajo();
	
	public abstract void moverDerecha();
	
	public abstract void moverIzquierda();
	
	//Es necesario implementar morir?
	
	public Celda getCelda(){
		return miCelda;
	}
	
	public Nivel getNivel(){
		return miNivel;
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
