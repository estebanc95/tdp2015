import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelBackground extends JPanel{

		private ImageIcon background;
		private String nombre;
		
		public JPanelBackground (String name) {
			nombre=name;
		}
		
		public void paint (Graphics g) {
			Dimension  tamanio=getSize();
			background = new ImageIcon(getClass().getResource(nombre));
			g.drawImage(background.getImage(), 0, 0, tamanio.width, tamanio.height,null);
			setOpaque(false);
			super.paint(g);
		}
	}
