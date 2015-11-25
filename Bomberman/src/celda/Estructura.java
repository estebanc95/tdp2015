		package celda;
import entidades.CeldaGrafica;
import personaje.Bomberman;
import personaje.Enemigo;

/**
 * Clase Abstracta Estructura
 * @author Esteban Federico Canela y German Herrou
 *
 */
public abstract class Estructura {
	
	//Atributos
	protected Celda miCelda;
	protected CeldaGrafica graf;
	
	/**
	 * Constructor de Estructura
	 * @param c Celda a la que pertenece
	 */
	protected Estructura(Celda c){
		miCelda=c;
	}
	
	/**
	 * Intenta atravesar el Bomberman a la celda perteneciente a esta estructura
	 * @param b Bomberman que desea atravesar
	 * @param dir dirección de la que proviene el bomberman.
	 */
	public abstract void atravesar(Bomberman b,int dir);
	
	/**
	 * Intenta atravesar el Enemigo a la celda perteneciente a esta estructura
	 * @param e Enemigo que desea atravesar
	 * @param dir dirección de la que proviene el enemigo.
	 */
	public abstract void atravesar(Enemigo e,int dir);
	
	/**
	 * Recibe una explosion como consecuencia de una bomba que detono
	 * @param dir dirección de la que proviene la explosión.
	 */
	public abstract void recibirExplosion(int dir);
	
	/**
	 * Retorna el grafico de la Celda correspondiente a esta estructura
	 * @return grafico que posee la estructura
	 */
	public CeldaGrafica getCeldaGrafica () {
		return graf;
		}
	}
