package powerUp;
import celda.Celda;
import entidades.FatalityGrafica;
import logica.Nivel;
import personaje.Bomberman;

/**
 * Clase Fatality
 * @author Esteban Federico Canela y German Herrou
 *
 */
public class Fatality extends PowerUp {
	
	/**
	 * Constructor de Fatality
	 * @param n Nivel al que pertenece el PowerUp
	 */
	
	public Fatality (Nivel n) {
		super(n);
	}
	
	
	public void activar(Bomberman b){
		b.duplicarAlcance();
		getNivel().aumentarPuntuacion(50);
		getNivel().removerPowerUp(this);
		b.getNivel().aumentarFatality();
		System.out.println("Fatality obtenido.");
	}
	
	public void ubicarEnCelda(Celda c){
		miCelda=c;
		miGrafico= new FatalityGrafica(c.getPosX(),c.getPosY());
	}

}
