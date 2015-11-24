package Gui;

import java.applet.AudioClip;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import threads.ThreadMovimiento;
import threads.ThreadTiempo;
import bombas.Bomba;
import logica.Nivel;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;

/**
 * Clase gui
 * @author Esteban Canela y German Herrou
 *
 */

public class gui extends JFrame {

	private static final long serialVersionUID = 1L;
	protected Nivel n;
	protected boolean lock;
	protected int dir;
	protected JLayeredPane mapa;
	protected PanelInferior panelI;
	protected PanelSuperior panelS;
	protected MenuGUI miPrincipal;
	protected ThreadTiempo tiempoC;
	protected AudioClip music;
	private int cantClicks;
	
	/**
	 * Constructor de gui
	 */
	
	public gui (MenuGUI p) {
		
		super ("Proyecto X - TECNOLOGIA DE PROGRAMACION - 2015");
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				mover(arg0);
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/IconoJuego.png"));
	    setIconImage(icon);
		setSize(998,530);
		miPrincipal=p;
		panelI = new PanelInferior();
		panelS = new PanelSuperior(miPrincipal,this);
		mapa = new JLayeredPane();
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(mapa, BorderLayout.CENTER);
		getContentPane().add(panelS, BorderLayout.NORTH);
		getContentPane().add(panelI, BorderLayout.SOUTH);
		panelS.setFocusable(false);
		panelI.setLayout(new BoxLayout(panelI, BoxLayout.X_AXIS));
		this.setFocusable(true);
		
		setLocationRelativeTo(null);
		mapa.setLayout(null);
		lock = false;
		dir = -1;
		//this.setUndecorated(true); //SE USA PARA PONER PANTALLA COMPLETA
		//this.setExtendedState(MAXIMIZED_BOTH); //SE USA PARA PONER PANTALLA COMPLETA
		n = new Nivel (this);
		tiempoC = new ThreadTiempo (panelI);
		tiempoC.start();
		ThreadMovimiento tmv = new ThreadMovimiento (n.obtenerBomberman(),this,n);
		tmv.start();
		music = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/SongGame.mid"));
		music.loop();
		cantClicks=0;
	}
	
	/**
	 * Devuelve el mapa principal el cual contiene el juego en si
	 * @return el mapa de juego
	 */
	
	public JLayeredPane miMapa () {
		return mapa;
	}
	/**
	 * Finaliza el juego
	 */
	
	 public void gameOver() {
		 FondoFin ff = new FondoFin (miPrincipal,this,"/imagenes/GameOver.png");
		 ff.setVisible(true);
		 setVisible(false);
		 music.stop();
		}
	
	/**
	 * Establece los movimientos que el usuario desea
	 * @param key movimiento del usuario
	 */
	
	protected void mover(KeyEvent key) {
		if(!lock){
		switch (key.getKeyCode()) {
			case KeyEvent.VK_RIGHT : { // Derecha
				dir=0;
				lock=true;
				break;
			}
			case KeyEvent.VK_LEFT : { // Izquierda
				dir=1;
				lock=true;
				break;
			}
			case KeyEvent.VK_UP : { // Arriba
				dir=2;
				lock = true;
				break;
			}
			case KeyEvent.VK_DOWN : { // Abajo
				dir=3;
				lock = true;
				break;
		}
			case KeyEvent.VK_SPACE : { // Poner bomba
				n.obtenerBomberman().colocarBomba();
				break;
			}
			case KeyEvent.VK_ESCAPE : { //Salir juego
				System.exit(0);
				break;
			}
			default : // Cualquier otra tecla
				break;
		}
		this.repaint();
	}
	}
	
	/**
	 * Se fija si el teclado se encuentra bloqueado
	 * @return verdadero si el teclado esta bloqueado, en caso contrario falso
	 */
	
	public boolean estaBloqueado () {
		return lock;
	}
	
	/**
	 * Desbloquea el teclado
	 */
	
	public void desbloquear () {
		lock = !lock;
	}
	
	/**
	 * Devuelve la direccion en que se movio
	 * @return direccion del ulimo movimiento
	 */
	
	public int getDir () {
		return dir;
	}

	/**
	 * Muestra que el jugador gano el Juego
	 */
	public void mostrarVictoria() {
		 FondoFin ff = new FondoFin (miPrincipal,this,"/imagenes/Win.png");
		 ff.setVisible(true);
		 setVisible(false);
		 music.stop();
		
	}
	
	/**
	 * Aumenta el powerUp
	 */
	
	public void aumentarSpeedUp() {
		panelI.aumentarSpeedUP();
	}
	
	/**
	 * Aumenta el powerUp
	 */
	public void aumentarFatality() {
		panelI.aumentarFatality();
	}

	/**
	 * Aumenta el powerUp
	 */
	
	public void aumentarBombality() {
		panelI.aumentarBombality();
	}

	/**
	 * Aumenta el powerUp
	 */
	
	public void aumentarMasacrality() {
		panelI.aumentarMasacrality();
	}

	/**
	 * Aumenta el powerUp
	 */
	
	public void aumentarPuntos (int n) {
		panelI.aumentarPuntaje(n);
	}
	
	/**
	 * Silencia la musica de fondo
	 */
	
	public void silenciar () {
	
		if (cantClicks%2==0)
			music.stop();
		else 
			music.play();
		cantClicks++;
	}
	
	/**
	 * Silenciar definitivamente la musica de fondo
	 */
	public void silenciarDefin() {
		music.stop();
	}
	
}
	