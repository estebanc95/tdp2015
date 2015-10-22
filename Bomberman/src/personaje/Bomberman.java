package personaje;
import bombas.Bomba;
import logica.Nivel;
import celda.Celda;
import entidades.BombermanGrafico;

public class Bomberman extends Personaje {
	
	protected int alcance;
	protected int maxBombas;
	protected int bColocadas;
	protected int velocidad;
	
	public Bomberman(Celda c,Nivel n){
		super(c,n,false);
		alcance=1;
		maxBombas=999; //Debug
		bColocadas=0;
		velocidad=10;
		miGrafico=new BombermanGrafico(velocidad,getCelda().getPosX(),getCelda().getPosY());
	}
	
	public void moverArriba(){
		miNivel.getAdyacente(miCelda,'a').atravesar(this,2);
		
		//miNivel.getAdyacente(miCelda,'a').atravesar(this);
		//obtenerGrafico().mover(2);
	}
	
	public void moverAbajo(){
		miNivel.getAdyacente(miCelda,'b').atravesar(this,3);
		//miNivel.getAdyacente(miCelda,'b').atravesar(this);
		//obtenerGrafico().mover(3);
	}
	
	public void moverDerecha(){
			miNivel.getAdyacente(miCelda,'d').atravesar(this,0);
		//miNivel.getAdyacente(miCelda,'d').atravesar(this);
		//obtenerGrafico().mover(0);
	}
	
	public void moverIzquierda(){
		miNivel.getAdyacente(miCelda,'i').atravesar(this,1);
		//miNivel.getAdyacente(miCelda,'i').atravesar(this);
		//obtenerGrafico().mover(1);
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
