package br.edu.etec.folks.caronte.controllerView;

import java.util.Timer;
import java.util.TimerTask;

public class EfeitoItens {

	Responsivo resp = new Responsivo();
	
	Timer timer = new Timer();
	
	//histórico
	
	public void apresentaIten(){
		
		timer.scheduleAtFixedRate(new TimerTask(){
			
			public void run(){
					
				if(resp.itens.maeItens.getX()-10 > resp.itens.camada.getWidth()-340){
					
					resp.itens.maeItens.setBounds(resp.itens.maeItens.getX()-10, 0, 340, resp.itens.camada.getHeight());
					
				}else{
				
					resp.itens.maeItens.setBounds(resp.itens.camada.getWidth()-340, 0, 340, resp.itens.camada.getHeight());
					
					resp.j.separador.div.repaint();
					resp.j.separador.knob.repaint();
					
					cancel();
					
				}
					
			}
					
		},1,1);
		
	}
	
	public String nome, url;
	public void escondeIten(final boolean outro){
		
		timer.scheduleAtFixedRate(new TimerTask(){
			
			public void run(){
					
				if(resp.itens.maeItens.getX()+10 < resp.itens.camada.getWidth()){
					
					resp.itens.maeItens.setBounds(resp.itens.maeItens.getX()+10, 0, 340, resp.itens.camada.getHeight());
					
				}else{
				
					resp.itens.maeItens.setBounds(resp.itens.camada.getWidth(), 0, 340, resp.itens.camada.getHeight());
					resp.itens.camada.setVisible(false);
					resp.itens.maeItens.removeAll();
					resp.j.separador.div.repaint();
					resp.j.separador.knob.repaint();
					
					if(outro){
						
						
						resp.j.pPrincipal.setComponentZOrder(resp.itens.camada, 0);
						resp.itens.camada.setVisible(true);
						resp.itens.apresentaAddFavorito();
						resp.itens.itemAberto = 0;
	
						resp.itens.favorito.titulo.setText("Editar este favorito");
						resp.itens.favorito.salvar.setText("Editar");
						resp.itens.favorito.txtNome.setText(nome);
						
						resp.itens.favorito.url = url;
						
						apresentaIten();
						
					}
					
					cancel();
					
				}
					
			}
					
		},1,1);
		
	}
	
	public void goHistorico(){
		
		timer.scheduleAtFixedRate(new TimerTask(){
				
			public void run(){
						
					if(resp.itens.historico.pHistorico.getX()>0){
						
						resp.itens.historico.pHistorico.setLocation(resp.itens.historico.pHistorico.getX()-1, resp.itens.historico.pHistorico.getY());
						resp.itens.favoritos.pFavoritos.setLocation(resp.itens.favoritos.pFavoritos.getX()-1, resp.itens.favoritos.pFavoritos.getY());
						
					}else{
						resp.itens.historico.pHistorico.setLocation(0, resp.itens.historico.pHistorico.getY());
						resp.itens.favoritos.pFavoritos.setLocation(-resp.itens.maeItens.getWidth(), resp.itens.favoritos.pFavoritos.getY());
						cancel();
					}
						
			}
						
		},1,1);
			
	}
	
	public void goFavoritos(){
		
		timer.scheduleAtFixedRate(new TimerTask(){
				
			public void run(){
						
					if(resp.itens.favoritos.pFavoritos.getX()<0){
						
						resp.itens.historico.pHistorico.setLocation(resp.itens.historico.pHistorico.getX()+1, resp.itens.historico.pHistorico.getY());
						resp.itens.favoritos.pFavoritos.setLocation(resp.itens.favoritos.pFavoritos.getX()+1, resp.itens.favoritos.pFavoritos.getY());
						
					}else{
						resp.itens.historico.pHistorico.setLocation(resp.itens.maeItens.getWidth(), resp.itens.historico.pHistorico.getY());
						resp.itens.favoritos.pFavoritos.setLocation(0, resp.itens.favoritos.pFavoritos.getY());
						cancel();
					}
						
			}
						
		},1,1);
			
	}
	
}
