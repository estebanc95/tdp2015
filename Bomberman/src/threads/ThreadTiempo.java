package threads;

import Gui.PanelInferior;
/**
 * Clase ThreadTiempo
 * @author Esteban Federico Canela, Germán Herrou
 *
 */
public class ThreadTiempo extends Thread {
	protected int segundos;
	protected int minutos;
	protected int horas;
	
	protected PanelInferior panel;
	/**
	 * Costructor ThreadTiempo.
	 * @param pi Panel en el que se visualiza el tiempo.
	 */
    public ThreadTiempo (PanelInferior pi) {
    	this.segundos = 00;
    	this.minutos = 00;
    	this.horas=00;
    	this.panel = pi;
    }
    
    /**
     * Comienza a correr el hilo.
     */
    public void run() {
    	while(true) {
    		try { // Mientras el hilo este activo, cuenta los segundos
    			Thread.sleep(1000);
    			segundos++;
    			if (segundos == 60) { // Cada 60 segundos la variable se resetea para agregar un minuto
    				segundos = 00;
    				minutos++;
    			}
    			if (minutos == 60) {
    				minutos=00;
    				horas++;
    			}
    			this.panel.actualizarTiempo(this.horas,this.minutos, this.segundos);
    		}
    		catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}    	
    }
    

}


