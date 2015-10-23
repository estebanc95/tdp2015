package entidades;
import javax.swing.ImageIcon;

public class AltairGrafica extends EntidadGrafica {
	

	public AltairGrafica (int vel, int x, int y) {
		super(vel, x, y);
		
		this.mov[0] = new ImageIcon(this.getClass().getResource("/imagenes/Altair.png"));
		this.mov[1] = new ImageIcon(this.getClass().getResource("/imagenes/Altair.png"));
		this.mov[2] = new ImageIcon(this.getClass().getResource("/imagenes/Altair.png"));
		this.mov[3] = new ImageIcon(this.getClass().getResource("/imagenes/Altair.png"));
		this.dmovn = new ImageIcon(this.getClass().getResource("/imagenes/Altair.png"));
	}
	
	
	}

