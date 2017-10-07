package br.edu.etec.folks.caronte.controllerView;

import java.util.Timer;
import java.util.TimerTask;

import br.edu.etec.folks.caronte.controller.GeraGuia;

public class EfeitosAbas {

	GeraGuia gera = new GeraGuia();
	
	int delay = 1, delay2 =1;
	
	int interval = 1, interval2 = 1;
	
	Timer timer = new Timer();
	
	//move as abas quando tocadas
	
	public int posicaoAntiga = 0;
	public int posicaoNova = 0;
	public int indice = 0;
	
	public static boolean  terminaTroca = true;
	
	public void moverParaFrente(){
		
		if(terminaTroca){
		
			terminaTroca = false;
			
			timer.scheduleAtFixedRate(new TimerTask(){
				
				public void run(){
					
					if(gera.lAbas.get(indice).getX()>posicaoNova){
						
						gera.lAbas.get(indice).setLocation(gera.lAbas.get(indice).getX()-2, 0);
						
					}else{
						
						this.cancel();
						terminaTroca = true;
						
					}
				
				}
				
			},delay,interval);
			
		}
			
	}
	
	public void moverParaTras(){
			
		if(terminaTroca){
			
		terminaTroca = false;
		
			timer.scheduleAtFixedRate(new TimerTask(){
					
				public void run(){
						
					if(gera.lAbas.get(indice).getX()<posicaoNova){
							
						gera.lAbas.get(indice).setLocation(gera.lAbas.get(indice).getX()+2, 0);
							
					}else{
							
						gera.lAbas.get(indice).setLocation(posicaoNova, 0);
						this.cancel();
						terminaTroca = true;
							
					}
					
				}
					
			},delay,interval);
				
		}
			
	}
	
}
