package Gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase Panel Superior
 * @author Esteban Federico
 *
 */

public class PanelSuperior extends JPanel {
		
	private ImageIcon imagen;
	private URL fondo,su;
	private JButton volver,config;
	private JFrame principal,juego;
	
	/**
	 * Constructor de Panel Superior
	 */
	
	public PanelSuperior (JFrame p, JFrame j) {
		this.setSize(88,126);
		this.setVisible(true);
		//fondo = this.getClass().getResource("imagenes/PanelInferior.png");
		imagen = new ImageIcon(getClass().getResource("/imagenes/PanelSuperior.png"));
		setLayout(new BorderLayout(0, 0));
		principal=p;
		juego=j;
		
		volver = new JButton();
		volver.setBorderPainted(false);
		volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotonBack.png")));
		volver.setContentAreaFilled(false);
		OyenteBack ob = new OyenteBack();
		volver.addActionListener(ob);
		volver.setSelected(false);
		volver.setEnabled(false);
		this.add(volver,BorderLayout.WEST);
		
		config = new JButton();
		config.setBorderPainted(false);
		config.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotonConfig.png")));
		config.setContentAreaFilled(false);
		config.setSelected(false);
		config.setEnabled(false);
		this.add(config,BorderLayout.EAST);
		
		
	}
	
	class OyenteBack implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			juego.setVisible(false);
			principal.setVisible(true);
		}
	}
	
	  public void paint(Graphics g) {
	        if (imagen != null) {
	            g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(),
	                              this);
	 
	            setOpaque(false);
	        } else {
	            setOpaque(true);
	        }
	 
	        super.paint(g);
	    }
}
