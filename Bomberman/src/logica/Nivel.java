package logica;

import java.util.Random;

import personaje.Bomberman;
import celda.*;

public class Nivel {

	private final int ancho = 31;
	private final int largo = 13;
	private final float porcentajeDestructibles = 0.5f;
	protected Logica miLogica;
	protected Celda[][] matrizCeldas;
	protected Bomberman miBomberman;
	protected PositionList<Enemigo> enemigos;
	protected Random rnd;

	public Nivel(Logica l) {
		rnd = new Random();
		miLogica = l;
		matrizCeldas = new Celda[ancho][largo];

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
		
		//Inicializo con celdas sin paredes aquellas correspondientes a la ubicación inicial de Bomberman y Sirius.
		matrizCeldas[1][1]=crearPiso(1,1);
		matrizCeldas[1][2]=crearPiso(1,2);
		matrizCeldas[2][1]=crearPiso(2,1);
		
		matrizCeldas[ancho-2][largo-2]=crearPiso(ancho-2,largo-2);
		matrizCeldas[ancho-3][largo-2]=crearPiso(ancho-3,largo-2);
		matrizCeldas[ancho-2][largo-3]=crearPiso(ancho-2,largo-3);
		
		celdasVacias-=6;
		

		// Inicializo las paredes indestructibles dentro del nivel.
		for (int i = 2; i < ancho - 3; i = i + 2)
			for (int j = 2; j < largo - 3; j = j + 2) {
				matrizCeldas[i][j] = crearPI(i, j);
				celdasVacias--;
			}

		// Estimo cuantas paredes destructibles debo colocar
		int destruiblesRestantes = (int) (celdasVacias * porcentajeDestructibles);

		// Coloco las paredes destructibles en lugares aleatorios.
		while (destruiblesRestantes > 0) {
			int rx = rnd.nextInt();
			int ry = rnd.nextInt();
			if (matrizCeldas[rx][ry] == null) {
				matrizCeldas[rx][ry] = crearPD(rx, ry);
				destruiblesRestantes--;
				celdasVacias--;
			}
		}

		//Coloco celdas sin estructuras en las ubicaciones restantes.
		for (int i = 1; i < ancho - 2; i++)
			for (int j = 1; j < largo - 2; j++)
				if (matrizCeldas[i][j] == null){
					matrizCeldas[i][j] = crearPiso(i, j);
					celdasVacias--;
				}
		//Finaliza creación mapa.
		assert(celdasVacias==0);
		
		miBomberman=new Bomberman(matrizCeldas[1][1],this);
		matrizCeldas[1][1].colocar(miBomberman);
		
		Sirius sr=new Sirius(matrizCeldas[ancho-2][largo-2],this);
		matrizCeldas[ancho-2][largo-2].colocar(sr);
		enemigos.addLast(sr);
		
		
		//Falta colocar al resto de los enemigos.
		

	}

	private Celda crearPiso(int x, int y) {
		return new Celda(x, y, this);
	}

	private Celda crearPI(int x, int y) {
		Celda c = new Celda(x, y, this);
		c.setEstructura(new ParedIndestructible(c));
		return c;

	}

	private Celda crearPD(int x, int y) {
		Celda c = new Celda(x, y, this);
		c.setEstructura(new ParedDestructible(c));
		return c;

	}

}
