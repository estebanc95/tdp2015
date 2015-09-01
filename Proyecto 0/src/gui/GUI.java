package gui;
import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JTextField;


public class GUI extends JFrame {
	private JTextField Frase;
	private JLabel Monty,title;
	private JPanelBackground panel;
	private JPanel panel_1, panel_2;
	private JButton btnIniciar;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmSalir;
	
	public GUI() {
		super("Proyecto Tecnologia de Programacion 2015");
		setResizable(false);
		setSize(550, 361);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setIconImage(new ImageIcon(getClass()
				.getResource("/Imagenes/icon.png")).getImage());
		
		panel = new JPanelBackground("/Imagenes/Planta Nuclear.png");
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		Monty = new JLabel("");
		Monty.setHorizontalAlignment(SwingConstants.CENTER);
		Monty.setVerticalAlignment(SwingConstants.BOTTOM);
		Monty.setIcon(new ImageIcon(getClass().getResource(
				"/Imagenes/mont2.png")));
		panel.add(Monty, BorderLayout.CENTER);
		
		Frase = new JTextField();
		Frase.setHorizontalAlignment(SwingConstants.CENTER);
		Frase.setFont(new Font("Tahoma", Font.BOLD, 18));
		Frase.setEditable(false);
		panel.add(Frase, BorderLayout.SOUTH);
		Frase.setColumns(10);
		
		panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		btnIniciar = new JButton("");
		btnIniciar.setIcon(new ImageIcon(getClass().getResource(
				"/Imagenes/Start.png")));
		OyenteFrase of = new OyenteFrase();
		btnIniciar.addActionListener(of);
		btnIniciar.setForeground(new Color(255, 215, 0));
		panel_1.add(btnIniciar);
		
		panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.NORTH);
		
		title = new JLabel("");
		title.setIcon(new ImageIcon(getClass().getResource(
				"/Imagenes/Simpsons.png")));
		panel_2.add(title);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		mntmSalir = new JMenuItem("Salir");
		OyenteCerrar oc = new OyenteCerrar();
		mntmSalir.addActionListener(oc);
		mnNewMenu.add(mntmSalir);
	}
	
	class OyenteFrase implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			btnIniciar.setEnabled(false);
			Frase.setText("Excelente...");
		}
	}
	
	class OyenteCerrar implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	}

}
