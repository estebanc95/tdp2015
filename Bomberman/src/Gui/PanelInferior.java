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

/**
 * Panel inferior del Juego
 * @author Esteban Canela y German Herrou
 *
 */
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
	private JLabel temp,hor,min,dosp,seg;
	
	private static final long serialVersionUID = 1L;
	
		/**
		 * Constructor de Panel Inferior
		 */
		public PanelInferior () {
			this.setSize(88,126);
			this.setVisible(true);
			//fondo = this.getClass().getResource("imagenes/PanelInferior.png");
			imagen = new ImageIcon(getClass().getResource("/imagenes/PanelInferior.png"));
			
			//SPEED-UP
			
			speedUp= new JLabel();
			this.speedUp.setIcon(new ImageIcon(getClass().getResource("/imagenes/SpeedUpPI.png")));
			this.add(speedUp);
			totalSpeedUp=0;
			cantSU= new JLabel(" 0 ");
			InputStream spis=this.getClass().getResourceAsStream("/Font/akbar.ttf");
			try {
				cantSU.setFont(Font.createFont(Font.TRUETYPE_FONT, spis).deriveFont(1, 38));
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cantSU.setForeground(Color.YELLOW);
			this.add(cantSU);
			
			//FATALITY
			
			fatality = new JLabel();
			this.fatality.setIcon(new ImageIcon(getClass().getResource("/imagenes/FatalityPI.png")));
			this.add(fatality);
			totalFatality=0;
			cantFa= new JLabel(" 0 ");
			InputStream fais=this.getClass().getResourceAsStream("/Font/akbar.ttf");
			try {
				cantFa.setFont(Font.createFont(Font.TRUETYPE_FONT, fais).deriveFont(1, 38));
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cantFa.setForeground(Color.YELLOW);
			this.add(cantFa);
			
			//BOMBALITY
			
			bombality = new JLabel();
			this.bombality.setIcon(new ImageIcon(getClass().getResource("/imagenes/BombalityPI.png")));
			this.add(bombality);
			totalBombality=0;
			cantBom= new JLabel(" 0 ");
			InputStream bombis=this.getClass().getResourceAsStream("/Font/akbar.ttf");
			try {
				cantBom.setFont(Font.createFont(Font.TRUETYPE_FONT, bombis).deriveFont(1, 38));
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cantBom.setForeground(Color.YELLOW);
			this.add(cantBom);
			
			//MASACRALITY
			
			massacrality = new JLabel();
			this.massacrality.setIcon(new ImageIcon(getClass().getResource("/imagenes/MasacralityPIOff.png")));
			this.add(massacrality);
			totalMassa=0;
			cantMa= new JLabel(" 0 ");
			InputStream cantMatis=this.getClass().getResourceAsStream("/Font/akbar.ttf");
			try {
				cantMa.setFont(Font.createFont(Font.TRUETYPE_FONT, cantMatis).deriveFont(1, 38));
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cantMa.setForeground(Color.YELLOW);
			this.add(cantMa);
			
			
			//PUNTAJE
			
			puntaje= new JLabel();
			this.puntaje.setIcon(new ImageIcon(getClass().getResource("/imagenes/Puntos.png")));
			this.add(puntaje);
			totalPunt=0;
			cantPunt= new JLabel(" 0 ");
			InputStream puntis=this.getClass().getResourceAsStream("/Font/akbar.ttf");
			try {
				cantPunt.setFont(Font.createFont(Font.TRUETYPE_FONT, puntis).deriveFont(1, 38));
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cantPunt.setForeground(Color.YELLOW);
			this.add(cantPunt);
			
			//TIMER
			
			temp = new JLabel();
			temp.setIcon(new ImageIcon(getClass().getResource("/imagenes/timer1.png")));
			this.add(temp);
			
			hor = new JLabel (" 00");
			InputStream horis=this.getClass().getResourceAsStream("/Font/akbar.ttf");
			try {
				hor.setFont(Font.createFont(Font.TRUETYPE_FONT, horis).deriveFont(1, 38));
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			hor.setForeground(Color.YELLOW);
			this.add(hor);
			
			
			
			min = new JLabel(" 00");
			InputStream is=this.getClass().getResourceAsStream("/Font/akbar.ttf");
			try {
				min.setFont(Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(1, 38));
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			min.setForeground(Color.YELLOW);
			this.add(min);
			
			dosp = new JLabel (":");
			InputStream dospis=this.getClass().getResourceAsStream("/Font/akbar.ttf");
			try {
				dosp.setFont(Font.createFont(Font.TRUETYPE_FONT, dospis).deriveFont(0, 38));
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dosp.setForeground(Color.YELLOW);
			this.add(dosp);
			
			seg = new JLabel ("00");
			InputStream seginp=this.getClass().getResourceAsStream("/Font/akbar.ttf");
			try {
				seg.setFont(Font.createFont(Font.TRUETYPE_FONT, seginp).deriveFont(1, 38));
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			seg.setForeground(Color.YELLOW);
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
		  
		  /**
		   * Incrementa el valor del power up 
		   */
		  
		  public void aumentarSpeedUP() {
			  totalSpeedUp++;
			  String tot = Integer.toString(totalSpeedUp);
			  cantSU.setText(" "+tot+" ");
		  }
		  
		  /**
		   * Incrementa el valor del power up 
		   */
		  
		  public void aumentarFatality() {
			  totalFatality++;
			  String tot = Integer.toString(totalFatality);
			  cantFa.setText(" "+tot+" ");
		  }
		  
		  /**
		   * Incrementa el valor del power up 
		   */
		  
		  public void aumentarBombality() {
			  totalBombality++;
			  String tot = Integer.toString(totalBombality);
			  cantBom.setText(" "+tot+" ");
		  }
		  
		  /**
		   * Incrementa el valor del power up 
		   */
		  
		  public void aumentarMasacrality() {
			  this.massacrality.setIcon(new ImageIcon(getClass().getResource("/imagenes/MasacralityPI.png")));
			  totalMassa++;
			  String tot = Integer.toString(totalMassa);
			  cantMa.setText(" "+tot+" ");
		  }
		  
		  /**
		   * Incrementa el valor de los puntajes 
		   * @param n Cantidad a aumentar.
		   */
		  
		  public void aumentarPuntaje(int n) {
			  totalPunt+=n;
			  String total = Integer.toString(totalPunt);
			  cantPunt.setText(" "+total+" ");
		  }
		  
		  /**
		   * Actualiza el tiempo en el panel inferior
		   * @param horas a colocar en el panel
		   * @param minutos minutos a colocar en el panel
		   * @param segundos segundos a colocar en el panel
		   */
		  
		  public void actualizarTiempo(int horas,int minutos, int segundos) {
			  String minut = Integer.toString(minutos);
			  String segu = Integer.toString(segundos);
			  String hora = Integer.toString(horas);
			  if (horas<10) {
				  hor.setText(" 0"+hora);
			  }
			  else 
				  hor.setText(" "+hora);
			  
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
		  
		/**
		 * Desactiva el icono del Massacrality
		 */
		  
		public void desactivarMassa() {
			this.massacrality.setIcon(new ImageIcon(getClass().getResource("/imagenes/MasacralityPIOff.png")));
		}
}

