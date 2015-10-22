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
	 */
	public abstract void atravesar(Bomberman b);
	
	/**
	 * Intenta atravesar el Enemigo a la celda perteneciente a esta estructura
	 * @param e Enemigo que desea atravesar
	 */
	public abstract void atravesar(Enemigo e);
	
	/**
	 * Recibe una explosion como consecuencia de una bomba que detono
	 */
	public abstract void recibirExplosion();
	
	/**
	 * Retorna el grafico de la Celda correspondiente a esta estructura
	 * @return grafico que posee la estructura
	 */
	public CeldaGrafica getCeldaGrafica () {
		return graf;
		}
	}
