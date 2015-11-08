package Gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import threads.ThreadMovimiento;
import bombas.Bomba;
import logica.Nivel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;

public class gui extends JFrame {

	private static final long serialVersionUID = 1L;
	protected Nivel n;
	protected boolean lock;
	protected int dir;
	protected JLayeredPane mapa;
	protected PanelInferior panelI;
	protected PanelSuperior panelS;
	
	public gui () {
		
		super ("Proyecto X - TECNOLOGIA DE PROGRAMACION - 2015");
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				mover(arg0);
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(998,530);
		panelI = new PanelInferior();
		panelS = new PanelSuperior();
		mapa = new JLayeredPane();
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(mapa, BorderLayout.CENTER);
		getContentPane().add(panelS, BorderLayout.NORTH);
		getContentPane().add(panelI, BorderLayout.SOUTH);
		panelI.setLayout(new BoxLayout(panelI, BoxLayout.X_AXIS));
		
		setLocationRelativeTo(null);
		mapa.setLayout(null);
		lock = false;
		dir = -1;
		//this.setUndecorated(true); //SE USA PARA PONER PANTALLA COMPLETA
		//this.setExtendedState(MAXIMIZED_BOTH); //SE USA PARA PONER PANTALLA COMPLETA
		n = new Nivel (this);
		ThreadMovimiento tmv = new ThreadMovimiento (n.obtenerBomberman(),this,n);
		tmv.start();
	}
	
	public JLayeredPane miMapa () {
		return mapa;
	}
	
	public void gameOver(){
		JOptionPane.showMessageDialog(this, "Game Over.","Bomberman",JOptionPane.WARNING_MESSAGE);
		System.exit(0);
		}
	
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
	
	public boolean estaBloqueado () {
		return lock;
	}
	
	public void desbloquear () {
		lock = !lock;
	}
	
	public int getDir () {
		return dir;
	}

	public void mostrarVictoria() {
		JOptionPane.showMessageDialog(this, "El bomberman ha ganado!.","Bomberman",JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
		
	}
	
	public void aumentarSpeedUp() {
		panelI.aumentarSpeedUP();
	}
	
	public void aumentarFatality() {
		panelI.aumentarFatality();
	}
	
	public void aumentarBombality() {
		panelI.aumentarBombality();
	}
	
	public void aumentarMasacrality() {
		panelI.aumentarMasacrality();
	}
	
	public void aumentarPuntos (int n) {
		panelI.aumentarPuntaje(n);
	}
}
	