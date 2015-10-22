package personaje;
import bombas.Bomba;
import logica.Nivel;
import celda.Celda;
import entidades.BombermanGrafico;

/**
 * Clase Bomberman
 * @author Esteban Federico Canela y German Herrou
 *
 */

public class Bomberman extends Personaje {
	
	//Atributos
	protected int alcance;
	protected int maxBombas;
	protected int bColocadas;
	protected int velocidad;
	
	/**
	 * Constructor de Bomberman 
	 * @param c Celda a la que pertenece
	 * @param n Nivel al que pertenece
	 */
	
	public Bomberman(Celda c,Nivel n){
		super(c,n,false);
		alcance=1;
		maxBombas=1;
		bColocadas=0;
		velocidad=1;
		miGrafico=new BombermanGrafico(velocidad,getCelda().getPosX(),getCelda().getPosY());
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
	
	/**
	 * Coloca una Bomba en la Celda que se encuentra 
	 * @return la bomba colocada, NULL en caso contrario
	 */
	
	public Bomba colocarBomba(){
		if (!esFantasma()&&maxBombas-bColocadas<=0)
			return null;
		else{
			Bomba bm = new Bomba(getNivel(),alcance,getCelda(),this);
			bColocadas++;
			return bm;
		}
	}
	
	/**
	 * Disminuye la cantidad de bombas colocadas
	 */
	public void bombaExploto(){
		bColocadas--;
	}
	
	/**
	 * Duplica el alcance de las bombas de Bomberman
	 */
	
	public void duplicarAlcance(){
		alcance*=2;
	}
	
	/**
	 * Radio de explosion de las bombas de Bomberman
	 * @return el alcance de una bomba
	 */
	
	public int getAlcance(){
		return alcance;
	}
	
	/**
	 * Cantida de bombas colocadas por Bomberman
	 * @return la cantidad de bombas colocadas en el mapa
	 */
	
	public int getCantColocadas(){
		return bColocadas;
	}
	
	/**
	 * Maximo de bombas que puede colocar Bomberman
	 * @return la cantidad maxima de bombas
	 */
	
	public int getMaxBombas(){
		return maxBombas;
	}
	
	/**
	 * Setea el maximo de bombas de Bomberman
	 * @param c maximo de bombas que queremos que posea
	 */
	
	public void setMaxBombas(int c){
		maxBombas=c;
	}
	
	/**
	 * Velocidad del Bomberman
	 * @return la velocidad que posee Bomberman
	 */
	
	public int getVelocidad() {
		return velocidad;
	}
	
	/**
	 * Duplica la velocidad del Bomberman
	 */
	
	public void duplicarVelocidad(){
		velocidad*=2;
	}
	
	/**
	 * Aumenta el maximo de bombas de Bomberman en uno.
	 */
	
	public void aumentarMaxBombas(){
		maxBombas++;
	}
	
}
