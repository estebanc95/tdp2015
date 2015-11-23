package Gui;

import java.awt.EventQueue;

import threads.ThreadBomba;

/**
 * Encargado de ejecutar la aplicacion
 * @author Esteban Federico Canela y  German Herrou
 *
 */

public class Tester {
/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gui asd = new gui();
		asd.setVisible(true);

	}
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGUI frame = new MenuGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
