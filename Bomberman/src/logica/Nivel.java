package logica;

import Gui.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import personaje.*;
import powerUp.*;
import celda.*;

/**
 * Clase Nivel
 * 
 * @author Esteban Federico Canela, Germán Herrou
 *
 */
public class Nivel {
	// Atributos
	private final int ancho = 31;
	private final int largo = 13;
	private final float porcentajeDestructibles = 0.5f;
	protected Celda[][] matrizCeldas;
	protected Bomberman miBomberman;
	protected List<Enemigo> enemigos;
	protected Random rnd;
	protected int puntuacion;
	protected int bloquesParaGanar;
	protected ProcesadorGrafico pg;

	/**
	 * Constructor de Clase Nivel
	 * 
	 * @param guigraf
	 *            Interfaz gráfica.
	 */
	public Nivel(gui guigraf) {

		pg = new ProcesadorGrafico(guigraf);
		puntuacion = 0;
		rnd = new Random();
		enemigos = new ArrayList<Enemigo>();
		matrizCeldas = new Celda[ancho][largo];

		// Creo una lista con los powerUp
		List<PowerUp> listap = new ArrayList<PowerUp>();

		for (int i = 0; i < 4; i++)
			listap.add(new SpeedUp(this));

		for (int i = 0; i < 3; i++)
			listap.add(new Fatality(this));

		for (int i = 0; i < 3; i++)
			listap.add(new Bombality(this));

		listap.add(new Masacrality(this));

		// Creo una matriz vacía.
		for (int i = 0; i < ancho - 1; i++)
			for (int j = 0; j < largo - 1; j++)
				matrizCeldas[i][j] = null;

		int celdasVacias = ancho * largo;

		// Inicializo los bordes del mapa con paredes indestructibles.
		for (int i = 0; i < ancho; i++) {
			matrizCeldas[i][0] = crearPI(i, 0);
			matrizCeldas[i][largo - 1] = crearPI(i, largo - 1);
			celdasVacias -= 2;
			pg.agregarCelda(matrizCeldas[i][0]);
			pg.agregarCelda(matrizCeldas[i][largo - 1]);
		}
		for (int j = 0; j < largo; j++) {
			matrizCeldas[0][j] = crearPI(0, j);
			matrizCeldas[ancho - 1][j] = crearPI(ancho - 1, j);
			pg.agregarCelda(matrizCeldas[0][j]);
			pg.agregarCelda(matrizCeldas[ancho - 1][j]);
			celdasVacias -= 2;
		}

		// Inicializo con celdas sin paredes aquellas correspondientes a la
		// ubicación inicial de Bomberman y Sirius.
		matrizCeldas[1][1] = crearPiso(1, 1);
		matrizCeldas[1][2] = crearPiso(1, 2);
		matrizCeldas[2][1] = crearPiso(2, 1);

		pg.agregarCelda(matrizCeldas[1][1]);
		pg.agregarCelda(matrizCeldas[1][2]);
		pg.agregarCelda(matrizCeldas[2][1]);

		matrizCeldas[ancho - 2][largo - 2] = crearPiso(ancho - 2, largo - 2);
		matrizCeldas[ancho - 3][largo - 2] = crearPiso(ancho - 3, largo - 2);
		matrizCeldas[ancho - 2][largo - 3] = crearPiso(ancho - 2, largo - 3);

		pg.agregarCelda(matrizCeldas[ancho - 2][largo - 2]);
		pg.agregarCelda(matrizCeldas[ancho - 3][largo - 2]);
		pg.agregarCelda(matrizCeldas[ancho - 2][largo - 3]);

		celdasVacias -= 6;

		// Inicializo las paredes indestructibles dentro del nivel.
		for (int i = 2; i < ancho - 1; i = i + 2)
			for (int j = 2; j < largo - 1; j = j + 2) {
				matrizCeldas[i][j] = crearPI(i, j);
				pg.agregarCelda(matrizCeldas[i][j]);
				celdasVacias--;
			}

		int rx = 0;
		int ry = 0;

		// Estimo cuantas paredes destructibles debo colocar
		int destruiblesRestantes = (int) (celdasVacias * porcentajeDestructibles);

		bloquesParaGanar = destruiblesRestantes; // El jugador gana cuando
													// bloquesParaGanar vale 0;

		// Coloco las paredes destructibles en lugares aleatorios.
		while (destruiblesRestantes > 0) {
			rx = rnd.nextInt(ancho - 1);
			ry = rnd.nextInt(largo - 1);
			if (matrizCeldas[rx][ry] == null) {
				if (listap.isEmpty())
					matrizCeldas[rx][ry] = crearPD(rx, ry, null);
				else {
					PowerUp p = listap.remove(0);
					matrizCeldas[rx][ry] = crearPD(rx, ry, p);
					p.ubicarEnCelda(matrizCeldas[rx][ry]);
				}
				pg.agregarCelda(matrizCeldas[rx][ry]);
				destruiblesRestantes--;
				celdasVacias--;
			}
		}

		// Coloco a los enemigos en lugares aleatorios
		int cantRugulos = 3;
		while (cantRugulos > 0) {
			rx = rnd.nextInt(ancho - 1);
			ry = rnd.nextInt(largo - 1);
			if (matrizCeldas[rx][ry] == null) {
				matrizCeldas[rx][ry] = crearPiso(rx, ry);
				pg.agregarCelda(matrizCeldas[rx][ry]);
				celdasVacias--;
				Rugulos rg1 = new Rugulos(matrizCeldas[rx][ry], this);
				matrizCeldas[rx][ry].setEnemigo(rg1);
				pg.agregarPersonaje(rg1);
				cantRugulos--;
			}
		}

		int cantAltair = 2;
		while (cantAltair > 0) {
			rx = rnd.nextInt(ancho - 1);
			ry = rnd.nextInt(largo - 1);
			if (matrizCeldas[rx][ry] == null) {
				celdasVacias--;
				matrizCeldas[rx][ry] = crearPiso(rx, ry);
				pg.agregarCelda(matrizCeldas[rx][ry]);
				Altair at = new Altair(matrizCeldas[rx][ry], this);
				matrizCeldas[rx][ry].setEnemigo(at);
				pg.agregarPersonaje(at);
				cantAltair--;
			}
		}

		// Coloco celdas sin estructuras en las ubicaciones restantes.
		for (int i = 1; i < ancho - 1; i++)
			for (int j = 1; j < largo - 1; j++)
				if (matrizCeldas[i][j] == null) {
					matrizCeldas[i][j] = crearPiso(i, j);
					pg.agregarCelda(matrizCeldas[i][j]);
					celdasVacias--;
				}
		// Finaliza creación mapa.
		assert (celdasVacias == 0);

		// Creo e inserto el bomberman
		miBomberman = new Bomberman(matrizCeldas[1][1], this);
		matrizCeldas[1][1].colocar(miBomberman);
		pg.agregarPersonaje(miBomberman);

		// Creo e inserto a Sirius.

		Sirius sr = new Sirius(matrizCeldas[ancho - 2][largo - 2], this,
				miBomberman);
		matrizCeldas[ancho - 2][largo - 2].colocar(sr);
		enemigos.add(sr);
		pg.agregarPersonaje(sr);

	}

	/**
	 * Retorna el bomberman que maneja el jugador.
	 * 
	 * @return El personaje bomberman.
	 */
	public Bomberman obtenerBomberman() {
		return miBomberman;
	}

	/**
	 * Retorna una celda dada sus coordenadas.
	 * 
	 * @param x
	 *            Coordenada x de la celda.
	 * @param y
	 *            Coordenada y de la celda
	 * @return Celda con coordenadas (x,y)
	 */
	public Celda getCelda(int x, int y) {
		if (x >= 0 && x < ancho && y >= 0 && y > largo)
			return matrizCeldas[x][y];
		else
			return null;
	}

	/**
	 * Analiza si el jugador ya gano.
	 * 
	 * @return Verdadero si no quedan paredes por destruir, falso en caso
	 *         contrario.
	 */
	public boolean gano() {
		return (bloquesParaGanar == 0);
	}

	/**
	 * Aumenta la puntuacion del juego.
	 * 
	 * @param p
	 *            valor a sumar a la puntuacion.
	 */
	public void aumentarPuntuacion(int p) {
		puntuacion += p;
		pg.aumentarPuntos(p);
	}

	/**
	 * Dada una celda, retorna la adyacente en una direccion determinada.
	 * 
	 * @param c
	 *            La celda cuya adyacente se desea conocer.
	 * @param x
	 *            Direccion de la celda adyacente.
	 * @return La celda correspondiente a la direccion, null si la direccion no
	 *         es valida.
	 */
	public Celda getAdyacente(Celda c, int x) {
		switch (x) {
		case 0:
			return matrizCeldas[c.getPosX()][c.getPosY() - 1];

		case 3:
			return matrizCeldas[c.getPosX() - 1][c.getPosY()];

		case 1:
			return matrizCeldas[c.getPosX() + 1][c.getPosY()];

		case 2:
			return matrizCeldas[c.getPosX()][c.getPosY() + 1];

		}
		return null;

	}

	/**
	 * Quita un enemigo del juego.
	 * 
	 * @param e
	 *            Enemigo a quitar.
	 */
	public void destruirEnemigo(Enemigo e) {
		if (e != null) {
			e.morir();
			enemigos.remove(e);
			pg.quitarPersonaje(e);
		}
	}

	/**
	 * Finaliza el juego.
	 */

	public void gameOver() {
		pg.gameOver();
	}

	/**
	 * Mueve el personaje jugador a partir de una direccion definida por el
	 * ususario.
	 * 
	 * @param direccion
	 *            Direccion en la que el personaje se debe mover. 0: Derecha 1:
	 *            Izquierda 2:Arriba 3:Abajo. No esta definido para otra
	 *            direccion
	 */

	public void moverPersonaje(int direccion) {
		switch (direccion) {
		case 0: // Derecha
			miBomberman.moverDerecha();
			break;
		case 1: // Izquierda
			miBomberman.moverIzquierda();
			break;
		case 2: // Arriba
			miBomberman.moverArriba();
			break;
		case 3: // Abajo
			miBomberman.moverAbajo();
			break;
		}
	}

	// Creadores de celdas.
	/**
	 * Crea un piso en la celda
	 * 
	 * @param x
	 *            Posicion X
	 * @param y
	 *            Posicion Y
	 * @return
	 */
	private Celda crearPiso(int x, int y) {
		return new Celda(x, y, this);

	}

	/**
	 * Crea una pared indestructible en la celda
	 * 
	 * @param x Posicion X
	 * @param y Posicion Y
	 * @return Celda con pared destructible.
	 */

	private Celda crearPI(int x, int y) {
		Celda c = new Celda(x, y, this);
		c.setEstructura(new ParedIndestructible(c));
		return c;

	}

	/**
	 * Crea una pared destructible en la celda
	 * 
	 * @param x Posicion X
	 * @param y Posicion Y
	 * @param p PowerUp que contendrar la pared indestructible
	 * @return Celda con pared indestructible.
	 */

	private Celda crearPD(int x, int y, PowerUp p) {
		Celda c = new Celda(x, y, p, this);
		c.setEstructura(new ParedDestructible(c));
		return c;

	}
	/**
	 * Retorna el procesador grafico del nivel.
	 * @return Procesador gráfico del nivel.
	 */
	public ProcesadorGrafico procesarGrafico() {
		return pg;
	}
	/**
	 * Notifica al nivel de la destrucción de una pared.
	 */
	public void paredDestruida() {
		bloquesParaGanar--;
		aumentarPuntuacion(10);
		if (gano())
			pg.mostrarVictoria();
	}

}
