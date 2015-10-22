package celda;

import entidades.CeldaGrafica;
import entidades.CeldaPisoGrafico;
import bombas.Bomba;
import logica.Nivel;
import personaje.*;
import powerUp.PowerUp;

public class Celda {

	protected int posX;
	protected int posY;
	protected Bomberman miBomberman;
	protected Enemigo miEnemigo;
	protected PowerUp miPowerUp;
	protected Estructura miEstructura;
	protected Nivel miNivel;
	protected Bomba miBomba;
	protected CeldaGrafica graf;

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

	public void atravesar(Bomberman b, int dir) {
		if (miEstructura != null)
			miEstructura.atravesar(b);
		else {
			colocar(b);
			miBomberman.obtenerGrafico().mover(dir);
		}
	}

	public void atravesar(Enemigo e, int dir) {
		if (miEstructura != null)
			miEstructura.atravesar(e);
		else {
			colocar(e);
			miEnemigo.obtenerGrafico().mover(dir);
		}
	}

	public void colocar(Bomberman b) {
		b.getCelda().quitarBomberman();
		b.setCelda(this);
		miBomberman = b;
		if (hayEnemigo()) {
			matarPersonaje();
		}
	}

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

	public void setEstructura(Estructura e) {
		miEstructura = e;
	}

	public Estructura getEstructura() {
		return miEstructura;
	}

	public void recibirExplosion() {
		if (miEstructura != null)
			miEstructura.recibirExplosion();
		matarPersonaje();
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	public void quitarBomberman(){
		miBomberman=null;
	}
	
	public void quitarEnemigo(){
		miEnemigo=null;
	}

	public void matarPersonaje() {
		if (miBomberman != null) {
			miNivel.quitarPersonaje(miBomberman);
			miNivel.gameOver();
		} else if (hayEnemigo()) {
			miNivel.quitarPersonaje(miEnemigo);
			miNivel.destruirEnemigo(miEnemigo);
		}
	}

	public Personaje getPersonaje() {
		if (hayBomberman())
			return miBomberman;
		else
			return miEnemigo;
	}

	public boolean hayBomberman() {
		return (miBomberman != null);
	}

	public boolean hayEnemigo() {
		return (miEnemigo != null);
	}

	public CeldaGrafica getCeldaGrafica() {
		if (miEstructura == null) {
			return graf;
		} else {
			return miEstructura.getCeldaGrafica();
		}
	}

	public Nivel getNivel() {
		return miNivel;
	}

	public PowerUp getPowerUp() {
		return miPowerUp;
	}

}