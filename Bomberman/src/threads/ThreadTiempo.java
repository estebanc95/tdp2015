package threads;

import Gui.PanelInferior;

public class ThreadTiempo extends Thread {
	protected int segundos;
	protected int minutos;
	
	protected PanelInferior panel;

    public ThreadTiempo (PanelInferior pi) {
    	this.segundos = 0;
    	this.minutos = 0;
    	this.panel = pi;
    }
    
    
    public void run() {
    	while(true) {
    		try { // Mientras el hilo este activo, cuenta los segundos
    			Thread.sleep(1000);
    			segundos++;
    			if (segundos == 60) { // Cada 60 segundos la variable se resetea para agregar un minuto
    				segundos = 0;
    				minutos++;
    			}
    			//this.panel.actualizarTiempo(this.minutos, this.segundos);
    		}
    		catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}    	
    }

}


