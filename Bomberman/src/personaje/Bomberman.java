package personaje;
import bombas.Bomba;
import logica.Nivel;
import celda.Celda;

public class Bomberman extends Personaje {
	
	protected int alcance;
	protected int maxBombas;
	protected int bColocadas;
	protected int velocidad;
	
	public Bomberman(Celda c,Nivel n){
		super(c,n,false);
		alcance=1;
		maxBombas=1;
		bColocadas=0;
		velocidad=1;
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
	
	public boolean colocarBomba(){
		if (maxBombas-bColocadas<=0)
			return false;
		else{
			new Bomba(getNivel(),alcance,getCelda(),this);
			bColocadas++;
			return true;
		}
	}
	
	public void duplicarAlcance(){
		alcance*=2;
	}
	
	public int getAlcance(){
		return alcance;
	}
	
	public int getCantColocadas(){
		return bColocadas;
	}
	
	public int getMaxBombas(){
		return maxBombas;
	}
	
	public void setMaxBombas(int c){
		maxBombas=c;
	}
	
	public void duplicarVelocidad(){
		velocidad*=2;
	}
	
	public void aumentarMaxBombas(){
		maxBombas++;
	}
	
}
