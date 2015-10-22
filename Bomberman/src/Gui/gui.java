package Gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import bombas.Bomba;
import logica.Nivel;

public class gui extends JFrame {

	private static final long serialVersionUID = 1L;
	protected Nivel n;
	
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
		//this.setUndecorated(true); //SE USA PARA PONER PANTALLA COMPLETA
		//this.setExtendedState(MAXIMIZED_BOTH); SE USA PARA PONER PANTALLA COMPLETA
		n = new Nivel (this);
		
	}
	
	public void gameOver(){
		JOptionPane.showMessageDialog(this, "Game Over.","Bomberman",JOptionPane.WARNING_MESSAGE);
		System.exit(0);
		}
	
	protected void mover(KeyEvent key) {
		switch (key.getKeyCode()) {
			case KeyEvent.VK_RIGHT : // Derecha
				n.moverPersonaje(0);
				break;
			case KeyEvent.VK_LEFT : // Izquierda
				n.moverPersonaje(1);
				break;
			case KeyEvent.VK_UP : // Arriba
				n.moverPersonaje(2);
				break;
			case KeyEvent.VK_DOWN : // Abajo
				n.moverPersonaje(3);
				break;
			case KeyEvent.VK_SPACE : { // Poner bomba
				Bomba colocada = n.obtenerBomberman().colocarBomba();
				if(colocada!=null)
					System.out.println("Bomba colocada.\n");
				break;
			}
			default : // Cualquier otra tecla
				break;
		}
		this.repaint();
	}
	
	
}