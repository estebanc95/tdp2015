package personaje;
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
	
	public boolean ColocarBomba(){
		if (maxBombas-bColocadas<=0)
			return false;
		else{
			new Bomba(getCelda(),alcance);
			bColocadas++;
			return true;
		}
	}
	
	public void duplicarAlcance(int a){
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
