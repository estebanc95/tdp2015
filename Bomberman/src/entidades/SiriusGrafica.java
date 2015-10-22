package entidades;
import javax.swing.ImageIcon;

public class SiriusGrafica extends EntidadGrafica{

	public SiriusGrafica (int vel, int x, int y) {
		super(vel, x, y);
		
		this.mov[0] = new ImageIcon(this.getClass().getResource("/moves/runner_right.png"));
		this.mov[1] = new ImageIcon(this.getClass().getResource("/moves/runner_left.png"));
		this.mov[2] = new ImageIcon(this.getClass().getResource("/moves/runner_up.png"));
		this.mov[3] = new ImageIcon(this.getClass().getResource("/moves/runner_down.png"));
		
		this.dmovn = new ImageIcon(this.getClass().getResource("/moves/runner_d.png"));
	}
	


}