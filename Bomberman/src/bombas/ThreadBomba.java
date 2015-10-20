package bombas;

public class ThreadBomba extends Thread {
	
	protected Bomba miBomba;
	protected int tiempo;
	
	public ThreadBomba(Bomba b,int t){
		miBomba=b;
		tiempo=t;
	}
	
	public void run(){
		try {
			sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		miBomba.explotar();
		this.interrupt(); 
	}

}
