package br.edu.etec.folks.caronte.controllerView;

import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import br.edu.etec.folks.caronte.controller.GeraGuia;
import br.edu.etec.folks.caronte.view.Guias;
import br.edu.etec.folks.caronte.view.Separador;

public class EfeitosDual {

	int delay = 0;
	
	int interval = 1;
	
	public int chegada;
	
	Timer timer = new Timer();
	
	Responsivo resp = new Responsivo();
	GeraDual geraD = new GeraDual();
	GeraGuia gera = new GeraGuia();
	
	public void aumentaCabecalho(){
		
		timer.scheduleAtFixedRate(new TimerTask(){
			
			public void run(){
				
				if(resp.j.cabecalho.getHeight()+10 <= 88){
					
					resp.j.cabecalho.setSize(resp.j.cabecalho.getWidth(), resp.j.cabecalho.getHeight()+10);
					resp.j.pItens.setLocation(0, resp.j.pItens.getY()+5);
					resp.j.sombra.setBounds(0, resp.j.cabecalho.getHeight()-1, resp.j.cabecalho.getWidth(), 1);
					
				}else{
					
					resp.j.cabecalho.setSize(resp.j.cabecalho.getWidth(), 88);
					resp.j.pItens.setBounds(0,35, resp.j.cabecalho.getWidth()-10, 51);
					resp.j.sombra.setBounds(0, resp.j.cabecalho.getHeight()-1, resp.j.cabecalho.getWidth(), 1);
					resp.j.pAbas.setVisible(false);
					
					geraD.novaDual();
					
					cancel();
					
				}
				
			}
				
		},10,10);
		
	}
	
	public void naoFecha(){
			
		timer.scheduleAtFixedRate(new TimerTask(){
				
			public void run(){
				
				if(chegada == 350){
				
					if(resp.j.separador.knob.getX()+1 < chegada){
						
						resp.j.separador.knob.setLocation(resp.j.separador.knob.getX()+1, resp.j.separador.knob.getY());
						resp.j.separador.div.setLocation(resp.j.separador.knob.getX(),resp.j.separador.div.getY());
						resp.j.separador.mod1.setBounds(resp.j.separador.div.getX()+10,0,resp.j.getWidth()-resp.j.separador.div.getX()-10,resp.j.separador.div.getHeight());
						resp.j.separador.mod2.setBounds(0,0,resp.j.separador.div.getX(),resp.j.separador.div.getHeight());
						
						resp.j.separador.div.repaint();
						resp.j.separador.knob.repaint();
						
					}else{
						
						resp.j.separador.knob.setLocation(350, resp.j.separador.knob.getY());
						resp.j.separador.div.setLocation(resp.j.separador.knob.getX(),resp.j.separador.div.getY());
						resp.j.separador.mod1.setBounds(resp.j.separador.div.getX()+10,0,resp.j.getWidth()-resp.j.separador.div.getX()-10,resp.j.separador.div.getHeight());
						resp.j.separador.mod2.setBounds(0,0,resp.j.separador.div.getX(),resp.j.separador.div.getHeight());
						
						
						geraD.respDual();

						resp.j.separador.mod1.setVisible(false);
						resp.j.separador.mod2.setVisible(false);
						
						resp.j.cabecalho.setVisible(true);
						resp.j.pPrincipal.setVisible(true);
						
						resp.j.separador.div.repaint();
						resp.j.separador.knob.repaint();

						cancel();
						
					}
					
				}else{
					
					if(resp.j.separador.knob.getX()-1 > resp.j.getWidth()-350){
						
						resp.j.separador.knob.setLocation(resp.j.separador.knob.getX()-1, resp.j.separador.knob.getY());
						resp.j.separador.div.setLocation(resp.j.separador.knob.getX(),resp.j.separador.div.getY());
						resp.j.separador.mod1.setBounds(resp.j.separador.div.getX()+10,0,resp.j.getWidth()-resp.j.separador.div.getX()-10,resp.j.separador.div.getHeight());
						resp.j.separador.mod2.setBounds(0,0,resp.j.separador.div.getX(),resp.j.separador.div.getHeight());
						

						
						resp.j.separador.div.repaint();
						resp.j.separador.knob.repaint();
						
					}else{
						
						resp.j.separador.knob.setLocation(resp.j.getWidth()-350, resp.j.separador.knob.getY());
						resp.j.separador.div.setLocation(resp.j.separador.knob.getX(),resp.j.separador.div.getY());
						resp.j.separador.mod1.setBounds(resp.j.separador.div.getX()+10,0,resp.j.getWidth()-resp.j.separador.div.getX()-10,resp.j.separador.div.getHeight());
						resp.j.separador.mod2.setBounds(0,0,resp.j.separador.div.getX(),resp.j.separador.div.getHeight());

						geraD.respDual();
						
						resp.j.separador.mod1.setVisible(false);
						resp.j.separador.mod2.setVisible(false);
						
						resp.j.cabecalho.setVisible(true);
						resp.j.pPrincipal.setVisible(true);
						
						resp.j.separador.div.repaint();
						resp.j.separador.knob.repaint();

						
						cancel();
						
					}
					
				}
				
			}
				
		},delay,interval);
	
	}
	
	public void duasPaginas(){
		
		resp.j.cabecalho.setVisible(false);
		resp.j.pPrincipal.setVisible(false);
		resp.j.separador.div.setLocation(0, resp.j.separador.div.getY());
		resp.j.separador.knob.setLocation(0, resp.j.separador.knob.getY());
		
		resp.j.separador.mod1.setVisible(true);
		resp.j.separador.mod2.setVisible(true);
		
		gera.lGuias.get(geraD.index2).setVisible(true);
		gera.lPaginas.get(geraD.index2).setVisible(true);
		
		timer.scheduleAtFixedRate(new TimerTask(){
					
			public void run(){
					
				if(resp.j.separador.knob.getX()+3 < (resp.j.getWidth()/2)-5){
					
					resp.j.separador.div.setLocation(resp.j.separador.div.getX()+3, resp.j.separador.div.getY());
					resp.j.separador.knob.setLocation(resp.j.separador.div.getX(), resp.j.separador.knob.getY());
					resp.j.separador.mod1.setBounds(resp.j.separador.div.getX()+10,0,resp.j.getWidth()-resp.j.separador.div.getX()-10,resp.j.separador.div.getHeight());
					resp.j.separador.mod2.setBounds(0,0,resp.j.separador.div.getX(),resp.j.separador.div.getHeight());
					
				}else{
					
					resp.j.separador.div.setLocation((resp.j.getWidth()/2)-5, resp.j.separador.div.getY());
					resp.j.separador.knob.setLocation(resp.j.separador.div.getX(), resp.j.separador.knob.getY());
					geraD.respDual();
					resp.j.separador.mod1.setBounds(resp.j.separador.div.getX()+10,0,resp.j.getWidth()-resp.j.separador.div.getX()-10,resp.j.separador.div.getHeight());
					resp.j.separador.mod2.setBounds(0,0,resp.j.separador.div.getX(),resp.j.separador.div.getHeight());
					resp.j.separador.mod1.setVisible(false);
					resp.j.separador.mod2.setVisible(false);
					
					resp.j.cabecalho.setVisible(true);
					resp.j.pPrincipal.setVisible(true);
					
					resp.j.separador.div.repaint();
					resp.j.separador.knob.repaint();
					
					cancel();
					
				}
					
			}
					
		},1,1);
			
	}
	
	//mais de 2
	
	public void chamaGuias(){
		
		resp.j.cabecalho.setVisible(false);
		resp.j.pPrincipal.setVisible(false);
		
		resp.j.separador.div.setLocation(0, resp.j.separador.div.getY());
		resp.j.separador.knob.setLocation(0, resp.j.separador.knob.getY());
		
		resp.j.separador.mod1.setVisible(true);
		
		timer.scheduleAtFixedRate(new TimerTask(){
			
			public void run(){
			
				if(resp.j.separador.knob.getX()+3 < (resp.j.getWidth()/2)){
					
					resp.j.separador.div.setLocation(resp.j.separador.div.getX()+3, resp.j.separador.div.getY());
					resp.j.separador.knob.setLocation(resp.j.separador.div.getX(), resp.j.separador.knob.getY());
					resp.j.separador.mod1.setBounds(resp.j.separador.div.getX()+10,0,resp.j.getWidth()-resp.j.separador.div.getX()-10,resp.j.separador.div.getHeight());
					resp.j.secundaria.scroll.setBounds(resp.j.secundaria.scroll.getX()+3, 0, (resp.j.getWidth()/2),resp.j.getHeight());
					
				}else{
					
					resp.j.separador.div.setLocation((resp.j.getWidth()/2)-5, resp.j.separador.div.getY());
					resp.j.separador.knob.setLocation(resp.j.separador.div.getX(), resp.j.separador.knob.getY());
//					geraD.respDual();
					resp.j.separador.mod1.setBounds(resp.j.separador.div.getX()+10,0,resp.j.getWidth()-resp.j.separador.div.getX()-10,resp.j.separador.div.getHeight());
					resp.j.secundaria.scroll.setBounds(0, 0, (resp.j.getWidth()/2),resp.j.getHeight());
					resp.j.separador.mod1.setVisible(false);
					
					resp.j.cabecalho.setVisible(true);
					resp.j.pPrincipal.setVisible(true);
					
					resp.j.separador.div.repaint();
					resp.j.separador.knob.repaint();
					resp.j.secundaria.repaint();
					
					cancel();
					
				}
				
			}
					
		},1,1);
		
	}
	
	public void chamachamaGuias2(){ 
		
		resp.j.setaDual.setVisible(false);
		resp.j.cabecalho.setBounds(resp.j.separador.div.getX()+10, resp.j.cabecalho.getY(), resp.j.getWidth()-resp.j.separador.div.getX()-10, resp.j.cabecalho.getHeight());
		resp.j.pPrincipal.setBounds(resp.j.separador.div.getX()+10, resp.j.pPrincipal.getY(), resp.j.getWidth()-resp.j.separador.div.getX()-10, resp.j.pPrincipal.getHeight());
		resp.j.fechar.setBounds(resp.j.cabecalho.getWidth()-48,0,44,30);
		resp.j.maximizar.setBounds(resp.j.fechar.getX()-44,0,44,30);
		resp.j.minimizar.setBounds(resp.j.maximizar.getX()-44,0,44,30);
		
		timer.scheduleAtFixedRate(new TimerTask(){
			
			public void run(){
			
				if(resp.j.secundaria.scroll.getX()+resp.j.secundaria.scroll.getWidth()+2 < resp.j.separador.div.getX()){
					
					resp.j.secundaria.scroll.setLocation(resp.j.secundaria.scroll.getX()+2, 0);
					
				}else{
					
					resp.j.secundaria.scroll.setLocation(0,0);
					
					gera.lGuias.get(geraD.index2).setVisible(false);
					gera.lPaginas.get(geraD.index2).setVisible(false);
					resp.j.separador.knob.setVisible(false);
					resp.j.separador.div.repaint();
					resp.j.separador.knob.repaint();
					resp.j.secundaria.repaint();
					
					cancel();
					
				}
				
			}
					
		},1,1);
		
	}
			
}
