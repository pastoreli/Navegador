package br.edu.etec.folks.caronte.controller;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import br.edu.etec.folks.caronte.controllerView.Responsivo;
import br.edu.etec.folks.caronte.dao.CrudFavoritos;
import br.edu.etec.folks.caronte.dao.CrudHistorico;
import br.edu.etec.folks.caronte.model.PaginasFavoritos;
import br.edu.etec.folks.caronte.model.PaginasHistorico;
import br.edu.etec.folks.caronte.view.Abas;
import br.edu.etec.folks.caronte.view.Guias;
import br.edu.etec.folks.caronte.view.Paginas;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class BuscaPagina {

	GeraGuia gera = new GeraGuia();
	
	Responsivo resp = new Responsivo();
	
	public List<String> lVoltar = new ArrayList<String>(); 
	
	public List<String> lAvancar = new ArrayList<String>(); 
	
	public  URL url;
	
	String title = "";
	
	int index;
	
	public boolean verificaConexao(){
		
        try {
        	
            HttpURLConnection urlConnect = (HttpURLConnection)url.openConnection();
            urlConnect.setConnectTimeout(30000);
            urlConnect.setReadTimeout(30000);

            Object objData = urlConnect.getContent();

        } catch (UnknownHostException e) {
            return false;
        }
        catch (IOException e) {
//            return false;
        }
        
        return true;
    }
	
	public  void buscarPagina(boolean usoCaixa, boolean addVolta){
		
		index = 0;
		
		boolean ultimo = false;
		int paran1;
        int paran2;
		
		for(Guias g : gera.lGuias){
		
			if(g.foco){
			
				g.foco = !g.foco;
				break;
				
			}
			
			index++;
			
		}
		
		if (verificaConexao()){		 	
			
       	 if(addVolta && !gera.lGuias.get(index).txtPesquisa.getText().equals(""+url))guardaPagina(gera.lGuias.get(index).txtPesquisa.getText());
       	 
       	 gera.lGuias.get(index).txtPesquisa.setText(""+url);
       	 
			BufferedReader in;
			 
			try {
					
				in = new BufferedReader(new InputStreamReader(url.openStream()));
					
				String str;  
					   
				while ((str = in.readLine()) != null) {  
					
					try {
						str = new String(str.getBytes("ISO-8859-1"), "UTF-8");
					}
					catch (java.io.UnsupportedEncodingException e) {
						
					}
					
					if (str.contains("<title>") && str.contains("</title>") || str.contains("<title") && str.contains("</title>")){

						if(str.contains("<title>") ){
							paran1 = str.indexOf("<title>");
						}else{
							paran1 = str.indexOf("<title");
						}
				        
						paran2 = str.lastIndexOf("</title>");
					
				        title = str.substring(paran1 +7, paran2);
				        
				        if(title.contains(">")){
				        	
				        	paran1 = title.indexOf(">");
				        	
					        title = title.substring(paran1+1);

				        }
				        
				        break;
				        
					}else{
						
						if (str.contains("<title>") || str.contains("<title") && !ultimo){
							
							title += str;
							ultimo = true;
							
						}else if(str.contains("</title>") && ultimo){
							
							ultimo = false;
							
							title += str;
							
							if(title.contains("<title>") ){
								paran1 = title.indexOf("<title>");
							}else{
								paran1 = title.indexOf("<title");
							}
					        
							paran2 = title.lastIndexOf("</title>");
						
					        title = title.substring(paran1 +7, paran2);
					        
					        if(title.contains(">")){
					        	
					        	paran1 = title.indexOf(">");
							
						        title = title.substring(paran1);
					        	
					        }
							
					        break;
					        
						}else if(ultimo){
							
							title += str;
							
						}
						
						
					}
					   
				}  
					    
				in.close();  
				
				if(title.length()<=0){
					title = ""+url;
				}
				
			} catch (IOException e) {}  
			
				gera.lPaginas.get(index).paginasP.setVisible(true);
				gera.lPaginas.get(index).erro.setVisible(false);
				gera.lAbas.get(index).nomePagina.setText(title);
				
				if(usoCaixa){
				
					Platform.runLater(new Runnable() {
					    public void run() {
					    	WebView webView2 = new WebView();
			       		    webView2.getEngine().load(""+url);
					    	gera.lPaginas.get(index).webView = webView2;
					    	
					    	gera.lPaginas.get(index).paginasP.setScene(new Scene(gera.lPaginas.get(index).webView));
					    	
					    	final WebEngine webEngine = gera.lPaginas.get(index).webView.getEngine();
					    	 webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
					           @Override
					           public void changed(ObservableValue ov, State oldState, State newState) {
	
					             if (newState == Worker.State.SUCCEEDED) {
					            	 					            	 
					            	 gera.lGuias.get(index).foco = true;
					            	 try {
										url = new URL(""+webEngine.getLocation());
									} catch (MalformedURLException e) {
										
									}
					            	 
					            	buscarPagina(false, true);
					            	 
					             }
	
					           }
					         });
					    	
					    }
					});		
					
				}
				
				gera.lGuias.get(index).nomeSite = title;
				gera.lGuias.get(index).url = ""+url;
				
				CrudFavoritos crudF = new CrudFavoritos();
				for(PaginasFavoritos f : crudF.lFavoritos){
					if(f.getUrlFav().equals(""+url)){
						gera.lGuias.get(index).favorito.setVisible(false);
						break;
					}else{
						gera.lGuias.get(index).favorito.setVisible(true);
					}
				}
				
				if(crudF.lFavoritos.size()<1)gera.lGuias.get(index).favorito.setVisible(true);
				
				if(!gera.lGuias.get(index).anonima){
					
					CrudHistorico crud = new CrudHistorico();
					PaginasHistorico historico = new PaginasHistorico();
					
					historico.setNomePagina(title);
					historico.setEnderecoPagina(""+url);
					
					Date data = new Date(System.currentTimeMillis());  
					SimpleDateFormat formatarHour = new SimpleDateFormat("HH:mm"); 
					String hora = formatarHour.format(data);
					formatarHour = new SimpleDateFormat("dd/MM/yy");
					String dia =  formatarHour.format(data);
					historico.setHora(hora);
					historico.setData(dia);
					
					crud.lHistorico.add(historico);
				
				}
				
			
		}else{
			gera.lPaginas.get(index).erro.erro.setText("<html>Não é possível acessar "+url+".</html>");
        	gera.lPaginas.get(index).paginasP.setVisible(false);
        	gera.lPaginas.get(index).erro.setVisible(true);
        	reconectar();
		}
		
	}
	
	public void guardaPagina(String link){
		
		lVoltar.add(link);
		
	}
	
	public void voltar(){
		
		 
 	   try {
 		   
 		    lAvancar.add(""+url);
 		    url = new URL(lVoltar.get(lVoltar.size()-1));
	   		lVoltar.remove(lVoltar.size()-1);
	   		
	   		buscarPagina(true, false);
	   			
 	  } catch (MalformedURLException e1) {}
		
	}
	
	public void avancar(){
		
		 try {
			
			guardaPagina(""+url);
		   	url = new URL(lAvancar.get(lAvancar.size()-1));
		   	lAvancar.remove(lAvancar.size()-1);
		   		
		   	buscarPagina(true, true);
		   			
	 	  } catch (MalformedURLException e1) {}
		
	}
	
	Timer timer = new Timer();
	boolean reconecta = false;
	
	public void reconectar(){
		
		timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask(){
				
			public void run(){
				 
					gera.lGuias.get(index).foco = true;
					buscarPagina(true, false);
					cancel();
				
				
			}
				
		},10000,10000);
		
	}
	
}
