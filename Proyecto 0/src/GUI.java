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
import javax.swing.JScrollBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.JMenuItem;


public class GUI extends JFrame {
	public GUI() {
		super("Proyecto Tecnologia de Programacion 2015");
		setResizable(false);
		setSize(550, 361);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel Monty = new JLabel("");
		Monty.setVerticalAlignment(SwingConstants.BOTTOM);
		Monty.setIcon(new ImageIcon("C:\\Users\\Esteban Federico\\Documents\\Proyecto 0\\mont2.png"));
		panel.add(Monty);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setForeground(new Color(255, 215, 0));
		btnIniciar.setFont(new Font("Akbar", Font.PLAIN, 30));
		panel_1.add(btnIniciar);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Los Simpsons - TDP");
		lblNewLabel.setFont(new Font("Akbar", Font.PLAIN, 30));
		panel_2.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmReiniciar = new JMenuItem("Reiniciar");
		mnNewMenu.add(mntmReiniciar);
	}

}
