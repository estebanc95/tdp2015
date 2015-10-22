package threads;

import bombas.Bomba;

public class ThreadBomba extends Thread {
	
	protected Bomba miBomba;
	protected int tiempo;
	
	public ThreadBomba(Bomba b,int t){
		miBomba=b;
		tiempo=t;
	}
	
	public void run(){
		try {
			System.out.println("Inicio thread bomba.");
			sleep(tiempo);
			System.out.println("paso el tiempo.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		miBomba.explotar();
		this.interrupt(); 
	}

}
