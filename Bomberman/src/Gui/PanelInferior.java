package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInferior extends JPanel {
	
	private ImageIcon imagen;
	private URL fondo,su;
	private JLabel speedUp,cantSU;
	private int totalSpeedUp;
	private JLabel fatality,cantFa;
	private int totalFatality;
	private JLabel bombality,cantBom;
	private int totalBombality;
	private JLabel massacrality,cantMa;
	private int totalMassa;
	private JLabel puntaje,cantPunt;
	private int totalPunt;
	private JLabel temp,min,dosp,seg;
	
	private static final long serialVersionUID = 1L;
	
		
		public PanelInferior () {
			this.setSize(88,126);
			this.setVisible(true);
			//fondo = this.getClass().getResource("imagenes/PanelInferior.png");
			imagen = new ImageIcon(getClass().getResource("/imagenes/PanelInferior.png"));
			speedUp= new JLabel();
			this.speedUp.setIcon(new ImageIcon(getClass().getResource("/imagenes/SpeedUpPI.png")));
			this.add(speedUp);
			totalSpeedUp=0;
			cantSU= new JLabel();
			cantSU.setIcon(new ImageIcon(getClass().getResource("/imagenes/0.png")));
			this.add(cantSU);
			
			fatality = new JLabel();
			this.fatality.setIcon(new ImageIcon(getClass().getResource("/imagenes/FatalityPI.png")));
			this.add(fatality);
			totalFatality=0;
			cantFa= new JLabel();
			cantFa.setIcon(new ImageIcon(getClass().getResource("/imagenes/0.png")));
			this.add(cantFa);
			
			bombality = new JLabel();
			this.bombality.setIcon(new ImageIcon(getClass().getResource("/imagenes/BombalityPI.png")));
			this.add(bombality);
			totalBombality=0;
			cantBom= new JLabel();
			cantBom.setIcon(new ImageIcon(getClass().getResource("/imagenes/0.png")));
			this.add(cantBom);
			
			massacrality = new JLabel();
			this.massacrality.setIcon(new ImageIcon(getClass().getResource("/imagenes/MasacralityPI.png")));
			this.add(massacrality);
			totalMassa=0;
			cantMa= new JLabel();
			cantMa.setIcon(new ImageIcon(getClass().getResource("/imagenes/0.png")));
			this.add(cantMa);
			
			puntaje= new JLabel();
			this.puntaje.setIcon(new ImageIcon(getClass().getResource("/imagenes/Puntos.png")));
			this.add(puntaje);
			totalPunt=0;
			cantPunt= new JLabel();
			cantPunt.setIcon(new ImageIcon(getClass().getResource("/imagenes/0.png")));
			this.add(cantPunt);
			
			temp = new JLabel();
			temp.setIcon(new ImageIcon(getClass().getResource("/imagenes/timer1.png")));
			this.add(temp);
			min = new JLabel(" 00");
			this.add(min);
			dosp = new JLabel (":");
			this.add(dosp);
			seg = new JLabel ("00");
			this.add(seg);
			
			
		}
		
		  public void paint(Graphics g) {
		        if (imagen != null) {
		            g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(),
		                              this);
		 
		            setOpaque(false);
		        } else {
		            setOpaque(true);
		        }
		 
		        super.paint(g);
		    }
		  
		  public void aumentarSpeedUP() {
			  totalSpeedUp++;
			  if (totalSpeedUp==1) {
				  cantSU.setIcon(new ImageIcon(getClass().getResource("/imagenes/1.png")));
			  }
			  else 
				  if(totalSpeedUp==2){
					  cantSU.setIcon(new ImageIcon(getClass().getResource("/imagenes/2.png")));
				  }
				  else
					  if(totalSpeedUp==3) {
						  cantSU.setIcon(new ImageIcon(getClass().getResource("/imagenes/3.png")));
					  }
					  else {
						  cantSU.setIcon(new ImageIcon(getClass().getResource("/imagenes/4.png")));
					  }
		  }
		  
		  public void aumentarFatality() {
			  totalFatality++;
			  if (totalFatality==1) {
				  cantFa.setIcon(new ImageIcon(getClass().getResource("/imagenes/1.png")));
			  }
			  else 
				  if(totalFatality==2){
					  cantFa.setIcon(new ImageIcon(getClass().getResource("/imagenes/2.png")));
				  }
				  else
				  	{
						  cantFa.setIcon(new ImageIcon(getClass().getResource("/imagenes/3.png")));
					  }
		  }
		  
		  public void aumentarBombality() {
			  totalBombality++;
			  if (totalBombality==1) {
				  cantBom.setIcon(new ImageIcon(getClass().getResource("/imagenes/1.png")));
			  }
			  else 
				  if(totalBombality==2){
					  cantBom.setIcon(new ImageIcon(getClass().getResource("/imagenes/2.png")));
				  }
				  else
					  {
						  cantBom.setIcon(new ImageIcon(getClass().getResource("/imagenes/3.png")));
					  }
		  }
		  
		  public void aumentarMasacrality() {
			  totalMassa++;
			  if (totalMassa==1) {
				  cantMa.setIcon(new ImageIcon(getClass().getResource("/imagenes/1.png")));
			  }
		  }
		  
		  public void aumentarPuntaje(int n) {
			  totalPunt+=n;
			  String total = Integer.toString(totalPunt);
			  cantPunt.setIcon(null);
			  cantPunt.setText(total);
		  }
		  
		  public void actualizarTiempo(int minutos, int segundos) {
			  String minut = Integer.toString(minutos);
			  String segu = Integer.toString(segundos);
			  if (minutos<10) {
			  min.setText(" 0"+minut);
			  }
			  else 
				  min.setText(" "+minut);
			  
			  if (segundos<10) {
				  seg.setText("0"+segu);
			  } else
				  seg.setText(segu);
			  
		  }
}

