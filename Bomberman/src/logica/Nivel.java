package logica;
import Gui.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import personaje.*;
import powerUp.*;
import celda.*;

public class Nivel {

	private final int ancho = 31;
	private final int largo = 13;
	private final float porcentajeDestructibles = 0.5f;
	protected Celda[][] matrizCeldas;
	protected Bomberman miBomberman;
	protected List<Enemigo> enemigos;
	protected Random rnd;
	protected int puntuacion;
	protected int bloquesParaGanar;

	public Nivel(gui graf) {
		puntuacion = 0;
		rnd = new Random();
		enemigos = new ArrayList<Enemigo>();
		matrizCeldas = new Celda[ancho][largo];

		// Creo una lista con los powerUp
		List<PowerUp> listap = new ArrayList<PowerUp>();

		for (int i = 0; i < 4; i++)
			listap.add(new SpeedUp(this));

		for (int i = 0; i < 3; i++)
			listap.add(new Masacrality(this));

		for (int i = 0; i < 3; i++)
			listap.add(new Bombality(this));

		listap.add(new Fatality(this));

		// Creo una matriz vacía.
		for (int i = 0; i < ancho - 1; i++)
			for (int j = 0; j < largo - 1; j++)
				matrizCeldas[i][j] = null;

		int celdasVacias = ancho * largo;

		// Inicializo los bordes del mapa con paredes indestructibles.
		matrizCeldas[0][0] = crearPI(0, 0);
		celdasVacias--;
		for (int i = 1; i < ancho - 1; i++) {
			matrizCeldas[i][0] = crearPI(i, 0);
			celdasVacias--;
		}
		for (int j = 1; j < largo - 1; j++) {
			matrizCeldas[0][j] = crearPI(0, j);
			celdasVacias--;
		}

		// Inicializo con celdas sin paredes aquellas correspondientes a la
		// ubicación inicial de Bomberman y Sirius.
		matrizCeldas[1][1] = crearPiso(1, 1);
		matrizCeldas[1][2] = crearPiso(1, 2);
		matrizCeldas[2][1] = crearPiso(2, 1);

		matrizCeldas[ancho - 2][largo - 2] = crearPiso(ancho - 2, largo - 2);
		matrizCeldas[ancho - 3][largo - 2] = crearPiso(ancho - 3, largo - 2);
		matrizCeldas[ancho - 2][largo - 3] = crearPiso(ancho - 2, largo - 3);

		celdasVacias -= 6;

		// Inicializo las paredes indestructibles dentro del nivel.
		for (int i = 2; i < ancho - 3; i = i + 2)
			for (int j = 2; j < largo - 3; j = j + 2) {
				matrizCeldas[i][j] = crearPI(i, j);
				celdasVacias--;
			}

		// Estimo cuantas paredes destructibles debo colocar
		int destruiblesRestantes = (int) (celdasVacias * porcentajeDestructibles);

		bloquesParaGanar = destruiblesRestantes; // El jugador gana cuando
													// bloquesParaGanar vale 0;

		// Coloco las paredes destructibles en lugares aleatorios.
		while (destruiblesRestantes > 0) {
			int rx = rnd.nextInt();
			int ry = rnd.nextInt();
			if (matrizCeldas[rx][ry] == null) {
				if (listap.isEmpty())
					matrizCeldas[rx][ry] = crearPD(rx, ry, null);
				else
					matrizCeldas[rx][ry] = crearPD(rx, ry, listap.remove(0));
				destruiblesRestantes--;
				celdasVacias--;
			}
		}

		// Coloco celdas sin estructuras en las ubicaciones restantes.
		for (int i = 1; i < ancho - 2; i++)
			for (int j = 1; j < largo - 2; j++)
				if (matrizCeldas[i][j] == null) {
					matrizCeldas[i][j] = crearPiso(i, j);
					celdasVacias--;
				}
		// Finaliza creación mapa.
		assert (celdasVacias == 0);

		miBomberman = new Bomberman(matrizCeldas[1][1], this);
		matrizCeldas[1][1].colocar(miBomberman);

		Sirius sr = new Sirius(matrizCeldas[ancho - 2][largo - 2], this);
		matrizCeldas[ancho - 2][largo - 2].colocar(sr);
		enemigos.add(sr);

		// Falta colocar al resto de los enemigos.

	}

	public Bomberman obtenerBomberman() {
		return miBomberman;
	}

	public Celda getCelda(int x, int y) {
		if (x >= 0 && x < ancho && y >= 0 && y > largo)
			return matrizCeldas[x][y];
		else
			return null;
	}
	
	public boolean gano(){
		return (bloquesParaGanar==0);
	}
	
	public void aumentarPuntuacion(int p){
		puntuacion+=p;
	}
	
	public Celda getAdyacente(Celda c,char x) throws{
		switch(x){
			case 'a': return matrizCeldas[c.getPosX()][c.getPosY()+1];
			break;
			case 'i': return 
			
				
	}

	private Celda crearPiso(int x, int y) {
		return new Celda(x, y, this);
	}

	private Celda crearPI(int x, int y) {
		Celda c = new Celda(x, y, this);
		c.setEstructura(new ParedIndestructible(c));
		return c;

	}

	private Celda crearPD(int x, int y, PowerUp p) {
		Celda c = new Celda(x, y, p, this);
		c.setEstructura(new ParedDestructible(c));
		return c;

	}

}
