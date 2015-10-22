package threads;

import personaje.Bomberman;

public class ThreadFatality extends Thread {
	
	protected final int duracion=5000;
	protected Bomberman miBomberman;
	
	public ThreadFatality(Bomberman b){
		miBomberman=b;
	}
	
	public void run(){
		try {
			miBomberman.setFantasma(true);
			System.out.println("Inicio modo dios.");
			sleep(duracion);
			miBomberman.setFantasma(false);
			System.out.println("Fin modo dios.");
			this.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
