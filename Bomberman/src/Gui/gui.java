package Gui;
import logica.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class gui extends JFrame {
	
	//Atributos 
	protected JPanel panel;
	protected JMenuItem salir, newGame;
	protected JMenuBar menuBar;
	protected JMenu preferencias;
	private static final long serialVersionUID = 1L;
	protected Nivel n;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui frame = new gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public gui () {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				mover(arg0);
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		setContentPane(this.panel);
		getContentPane().setLayout(null);
		getContentPane().add(panel);
		setBounds(100, 100, 450, 300);
		n = new Nivel (this);
	}
	
	protected void mover(KeyEvent key) {
		switch (key.getKeyCode()) {
			case KeyEvent.VK_RIGHT : // Derecha
				n.obtenerBomberman().moverDerecha();
				break;
			case KeyEvent.VK_LEFT : // Izquierda
				n.obtenerBomberman().moverIzquierda();
				break;
			case KeyEvent.VK_UP : // Arriba
				n.obtenerBomberman().moverArriba();
				break;
			case KeyEvent.VK_DOWN : // Abajo
				n.obtenerBomberman().moverAbajo();
				break;
			case KeyEvent.VK_SPACE : // Poner bomba
				n.obtenerBomberman().colocarBomba();
				break;
			default : // Cualquier otra tecla
				break;
		}
		this.repaint();
	}
		
}
