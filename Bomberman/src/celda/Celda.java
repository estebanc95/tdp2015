package celda;

import entidades.CeldaGrafica;
import entidades.CeldaPisoGrafico;
import bombas.Bomba;
import logica.Nivel;
import personaje.*;
import powerUp.PowerUp;

/**
 * Clase Celda
 * 
 * @author Esteban Federico Canela y German Herrou
 *
 */

public class Celda {

	// Atributos
	protected int posX;
	protected int posY;
	protected Bomberman miBomberman;
	protected Enemigo miEnemigo;
	protected PowerUp miPowerUp;
	protected Estructura miEstructura;
	protected Nivel miNivel;
	protected Bomba miBomba;
	protected CeldaGrafica graf;

	/**
	 * Constructor de Celda
	 * 
	 * @param px
	 *            Posicion en x
	 * @param py
	 *            Posicion en y
	 * @param p
	 *            PowerUp (que contiene)
	 * @param n
	 *            Nivel
	 */

	public Celda(int px, int py, PowerUp p, Nivel n) {
		posX = px;
		posY = py;
		miBomberman = null;
		miEnemigo = null;
		miPowerUp = p;
		miEstructura = null;
		miNivel = n;
		miBomba = null;
		graf = new CeldaPisoGrafico(px, py);
	}

	/**
	 * Constructor de Celda
	 * 
	 * @param px
	 *            Posicion en x
	 * @param py
	 *            Posicion en Y
	 * @param n
	 *            Nivel
	 */

	public Celda(int px, int py, Nivel n) {
		posX = px;
		posY = py;
		miBomberman = null;
		miEnemigo = null;
		miPowerUp = null;
		miEstructura = null;
		miNivel = n;
		miBomba = null;
		graf = new CeldaPisoGrafico(px, py);
	}

	/**
	 * Intenta avanzar el Bomberman a una celda adyacente por medio de la
	 * direccion que recibe.
	 * 
	 * @param b
	 *            Bomberman que desea moverse
	 * @param dir
	 *            Direccion en la que desea moverse
	 */

	public void atravesar(Bomberman b, int dir) {
		if (miEstructura != null)
			miEstructura.atravesar(b);
		else {
			colocar(b);
			miBomberman.obtenerGrafico().mover(dir);
		}
	}

	/**
	 * Intenta avanzar el Enemigo a una celda adyacente por medio de la
	 * direccion que recibe.
	 * 
	 * @param e
	 *            Enemigo que desea moverse
	 * @param dir
	 *            Direccion en la que desea moverse
	 */

	public void atravesar(Enemigo e, int dir) {
		if (miEstructura != null)
			miEstructura.atravesar(e);
		else {
			colocar(e);
			miEnemigo.obtenerGrafico().mover(dir);
		}
	}

	/**
	 * Ubica el Bomberman en esta celda
	 * 
	 * @param b
	 *            Bomberman a ubicar
	 */

	public void colocar(Bomberman b) {
		b.getCelda().quitarBomberman();
		b.setCelda(this);
		miBomberman = b;
		if (miPowerUp != null) {
			miPowerUp.activar(miBomberman);
			miPowerUp = null;
		}
		if (hayEnemigo()) {
			matarPersonaje();
		}
	}

	/**
	 * Ubica el Enemigo en esta celda
	 * 
	 * @param e
	 *            Enemigo a ubicar
	 */

	public void colocar(Enemigo e) {
		if (!hayEnemigo()) {
			e.getCelda().quitarEnemigo();
			e.setCelda(this);
			miEnemigo = e;
			if (hayBomberman()) {
				matarPersonaje();
			}
		}
	}

	/**
	 * Setea la estructura de la Celda
	 * 
	 * @param e
	 *            Estructura que se desea setear
	 */

	public void setEstructura(Estructura e) {
		miEstructura = e;
	}

	/**
	 * Retorna la estructura de la Celda
	 * 
	 * @return la estructura de esta celda si existe, NULL en caso contrario.
	 */

	public Estructura getEstructura() {
		return miEstructura;
	}

	/**
	 * Recibe una explosion proveniente de una bomba
	 * @param alcance El alcance restante de la explosion.
	 * @param direccion Direcion a la que avanza la explosion. a arriba, b abajo, d derecha, i izquierda, x punto de origen
	 */

	public void recibirExplosion(int alcance, char direccion) {
		if (miEstructura != null)
			miEstructura.recibirExplosion();
		matarPersonaje();
		if((miEstructura==null)&&(direccion!='x')&&(alcance>1)){
			miNivel.getAdyacente(this,direccion).recibirExplosion(alcance-1, direccion);
			
		}
	}

	/**
	 * Retorna la coordenada X
	 * 
	 * @return coordenada X
	 */

	public int getPosX() {
		return posX;
	}

	/**
	 * Retorna la coordenada Y
	 * 
	 * @return coordenada Y
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * Quita al Bomberman de esta Celda
	 */

	public void quitarBomberman() {
		miBomberman = null;
	}

	/**
	 * Quita el Enemigo de esta Celda
	 */

	public void quitarEnemigo() {
		miEnemigo = null;
	}

	/**
	 * Mata a cualquier personaje sobre esta celda
	 */

	public void matarPersonaje() {
		if (miBomberman != null) {
			miNivel.quitarPersonaje(miBomberman);
			miNivel.gameOver();
		} else if (hayEnemigo()) {
			miNivel.quitarPersonaje(miEnemigo);
			miNivel.destruirEnemigo(miEnemigo);
		}
	}

	/**
	 * Retorna el personaje sobre esta Celda
	 * 
	 * @return Personaje sobre la celda, NULL si no existe ninguno.
	 */

	public Personaje getPersonaje() {
		if (hayBomberman())
			return miBomberman;
		else
			return miEnemigo;
	}

	/**
	 * Mira si hay un Bomberman
	 * 
	 * @return Verdadero si hay un bomberman, en caso contrario falso
	 */

	public boolean hayBomberman() {
		return (miBomberman != null);
	}

	/**
	 * Mira si hay un Enemigo
	 * 
	 * @return Verdadero si hay un enemigo, en caso contrario falso
	 */

	public boolean hayEnemigo() {
		return (miEnemigo != null);
	}

	/**
	 * Devuelve el grafico de la celda
	 * 
	 * @return la grafica que posee asociada
	 */

	public CeldaGrafica getCeldaGrafica() {
		if (miEstructura == null) {
			return graf;
		} else {
			return miEstructura.getCeldaGrafica();
		}
	}

	/**
	 * Retorna el nivel que posee la celda
	 * 
	 * @return el nivel al que pertenece
	 */

	public Nivel getNivel() {
		return miNivel;
	}

	/**
	 * Devuelve el PowerUp que posee
	 * 
	 * @return powerUp que contiene la celda.
	 */

	public PowerUp getPowerUp() {
		return miPowerUp;
	}

}