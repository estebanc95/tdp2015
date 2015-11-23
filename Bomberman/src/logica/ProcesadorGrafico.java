package logica;

import java.applet.AudioClip;

import personaje.Personaje;
import powerUp.PowerUp;
import threads.ThreadBomba;
import threads.ThreadExplosionGrafica;
import bombas.Bomba;
import bombas.Explosion;
import celda.Celda;
import Gui.gui;

public class ProcesadorGrafico {
	
	protected gui miGui;
	protected ThreadBomba tb;
	
	public ProcesadorGrafico(gui g){
		miGui=g;
		// Crea un thread que explota las bombas colocadas
		tb = new ThreadBomba();
		tb.start();
	}
	
	public void agregarCelda(Celda c){
		miGui.miMapa().add(c.getCeldaGrafica().obtenerGrafico(),new Integer(1));
	}
	
	public void agregarPersonaje(Personaje p){
		miGui.miMapa().add(p.obtenerGrafico().obtenergraf(), new Integer(50));
	}
	
	public void aumentarPuntos(int p){
		miGui.aumentarPuntos(p);
	}
	
	public void gameOver(){
		miGui.gameOver();
	}
	
	/**
	 * Agrega una bomba al nivel.
	 * @param b Bomba a agregar.
	 */
	public void agregarBomba(Bomba b) {
		tb.colocarBomba(b);
		miGui.miMapa().add(b.obtenerGrafico().obtenerGrafico(), new Integer(8));
		miGui.miMapa().repaint();

	}
	/**
	 * Quita una bomba del nivel (Debido a que explotó).
	 * @param b Bomba a remover.
	 */
	public void removerBomba(Bomba b) {
		miGui.miMapa().remove(b.obtenerGrafico().obtenerGrafico());
		miGui.miMapa().repaint();
	}
	
	public void mostrarExplosion(Celda c,int tipo){
		ThreadExplosionGrafica th=new ThreadExplosionGrafica(tipo,c);
		th.start();
	}
	
	public void agregarExplosion(Explosion e){
		miGui.miMapa().add(e.obtenerGrafico().obtenerGrafico(),new Integer(7));
		miGui.miMapa().repaint();
	}
	
	public void quitarExplosion(Explosion e){
		miGui.miMapa().remove(e.obtenerGrafico().obtenerGrafico());
		miGui.miMapa().repaint();
	}
	
	
	/**
	 * Quita un powerUp del nivel (Dado que se activó).
	 * @param p PowerUp a remover.
	 */
	public void removerPowerUp(PowerUp p) {
		miGui.miMapa().remove(p.obtenerGrafico().obtenerGrafico());
		miGui.miMapa().repaint();
	}
	/**
	 * Quita una pared destruible de una celda. (Dado que explotó).
	 * @param c celda cuya pared fue destruida.
	 */

	public void quitarPared(Celda c) {
		miGui.miMapa().remove(c.getCeldaGrafica().obtenerGrafico());
		c.setEstructura(null);
		miGui.miMapa().add(c.getCeldaGrafica().obtenerGrafico(), new Integer(1));
		if (c.getPowerUp() != null) {
			miGui.miMapa().add(c.getPowerUp().obtenerGrafico().obtenerGrafico(),
					new Integer(5));
		}
		miGui.miMapa().repaint();
	}
	/**
	 * Quita un personaje del Nivel. (Dado que murió).
	 * @param p personaje a remover.
	 */
	
	
	public void quitarPersonaje(Personaje p) {
		miGui.miMapa().remove(p.obtenerGrafico().obtenergraf());
		miGui.miMapa().repaint();
	}
	
	
	public void mostrarVictoria() {
		miGui.mostrarVictoria();
		
	}
	
	public void aumentarSpeedUp() {
		miGui.aumentarSpeedUp();
	}
	
	public void aumentarFatality() {
		miGui.aumentarFatality();
	}
	
	public void aumentarBombality() {
		miGui.aumentarBombality();
	}
	
	public void aumentarMasacrality() {
		miGui.aumentarMasacrality();
	}

}
