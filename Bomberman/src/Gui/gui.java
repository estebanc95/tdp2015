package Gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import threads.ThreadMovimiento;
import bombas.Bomba;
import logica.Nivel;

public class gui extends JFrame {

	private static final long serialVersionUID = 1L;
	protected Nivel n;
	protected boolean lock;
	protected int dir;
	
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
		setSize(998,445);
		JLayeredPane contentPane = new JLayeredPane();
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		lock = false;
		dir = -1;
		//this.setUndecorated(true); //SE USA PARA PONER PANTALLA COMPLETA
		//this.setExtendedState(MAXIMIZED_BOTH); SE USA PARA PONER PANTALLA COMPLETA
		n = new Nivel (this);
		ThreadMovimiento tmv = new ThreadMovimiento (n.obtenerBomberman(),this,n);
		tmv.start();
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
}
	