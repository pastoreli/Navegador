package br.edu.etec.folks.caronte.controllerView;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.edu.etec.folks.caronte.controller.GeraGuia;
import br.edu.etec.folks.caronte.view.Abas;
import br.edu.etec.folks.caronte.view.Guias;
import br.edu.etec.folks.caronte.view.Historico;
import br.edu.etec.folks.caronte.view.ItensLateral;
import br.edu.etec.folks.caronte.view.Janela;
import br.edu.etec.folks.caronte.view.Paginas;
import br.edu.etec.folks.caronte.view.Separador;

public class Responsivo {

	
	GeraGuia gera = new GeraGuia();
	public Rectangle tela = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();  
	
	int cursorArea = 2;  
	
	//tamanhos antigos
    public Dimension antigoTamanho = new Dimension(1000,550);
    public Point antigaLoc = new Point((int)(tela.getWidth()/2)-500,(int)(tela.getHeight()/2)-275);
    
    public Point start_drag;        
    public  Point start_loc; 
    
    Toolkit toolkit =  Toolkit.getDefaultToolkit (); 
	
	public static Janela j;
	
	public static ItensLateral itens;
	
	public void createFrame(){
		
		j = new Janela();
		
		itens = new ItensLateral ();
		
		gera.criarPaginas(false);
		
		Cor.escolhaTema(0);
		
	}
	
	public void typeScreen(){
		
		if(j.getWidth() < tela.getWidth() || j.getHeight() < tela.getHeight()) 
			
			restore();
	    	
		else 
			
			full();

	}
	
	public void restore(){
		
		j.pPrincipal.setSize(j.getWidth()-6,j.getHeight()-94);
		j.pPrincipal.setLocation(3,91);
		j.cabecalho.setBounds(3,3,j.pPrincipal.getWidth(),57);
		j.fechar.setBounds(j.cabecalho.getWidth()-48,0,44,30);
		j.maximizar.setBounds(j.fechar.getX()-44,0,44,30);
		j.minimizar.setBounds(j.maximizar.getX()-44,0,44,30);
		j.pItens.setBounds(0,5, j.cabecalho.getWidth()-136, 51);
		j.sombra.setBounds(0, j.cabecalho.getHeight()-1, j.cabecalho.getWidth(), 1);
		j.pAbas.setBounds(3,60, j.getWidth()-6, 31);
		j.novaGuia.setBounds(j.pAbas.getWidth()-30,0, 30, 30);
		j.sombraG.setBounds(0, j.pAbas.getHeight()-1, j.pAbas.getWidth(), 1);
		j.bordas.setSize(j.getSize());
		j.bordas.setBackground(new Color(150,150,150));
		
		for(Guias g : gera.lGuias){
			
			g.setBounds(10, 0,j.pItens.getWidth(), 40);
			g.elementosBar.setSize(g.getSize());
			g.voltar.setBounds(0,7,34,34);
			g.avancar.setBounds(g.voltar.getLocation().x+g.voltar.getWidth()+2,7,34,34);
			g.caixaPesquisa.setBounds((g.getWidth()/2)-((g.getWidth()/100)*15)+68,10,(g.getWidth()/100)*30,30);
			ImageIcon imgCaixa;
			if(g.anonima)imgCaixa = new ImageIcon("imgGuias/caixaCabecalhoBlack.png");
			else imgCaixa = new ImageIcon("imgGuias/caixaCabecalho.png");
			g.caixaPesquisa.setIcon(new ImageIcon(imgCaixa.getImage().getScaledInstance(g.caixaPesquisa.getWidth(),g.caixaPesquisa.getHeight(), Image.SCALE_DEFAULT)));
			g.txtPesquisa.setBounds(10,0,g.caixaPesquisa.getWidth()-20,30);
			g.reiniciar.setBounds(g.caixaPesquisa.getX()-34,10,30,30);
			g.favorito.setBounds(g.caixaPesquisa.getX() + g.caixaPesquisa.getWidth()+((g.getWidth()/100)*6),7,34,34);
			g.menu.setBounds(g.favorito.getX() + g.favorito.getWidth()+((g.getWidth()/100)*4),7,34,34);
			g.dual.setBounds(g.menu.getX() + g.menu.getWidth()+((g.getWidth()/100)*1),7,34,34);
			g.dual.setVisible(false);
			g.opcoes.setBounds(g.menu.getX() + g.menu.getWidth()+((g.getWidth()/100)*1),7,34,34);
			g.opcoes.setVisible(true);
			
		}
		
		int cont=0;
		
		for(Abas a : gera.lAbas){
			
			if(cont==0){
				
				if(gera.lAbas.size() == 1){
				
					a.setBounds(0,0,(j.pAbas.getWidth()-30)/gera.lAbas.size(),30);
					if(a.anonima){
						a.nomePagina.setBounds(30,0,a.getWidth()-a.getHeight()-4,a.getHeight());
						a.anonimo.setVisible(true);
					}else a.nomePagina.setBounds(30,0,a.getWidth()-4,a.getHeight());
					
					a.anonimo.setBounds(a.getWidth()-a.getHeight(),0,a.getHeight(),a.getHeight());
					
				}else{
				
					a.setBounds(0,0,(j.pAbas.getWidth()-30)/gera.lAbas.size(),30);
					if(a.anonima){
						a.nomePagina.setBounds(30,0,a.getWidth()-a.getHeight()-52,a.getHeight());
						a.anonimo.setVisible(true);
					}else a.nomePagina.setBounds(30,0,a.getWidth()-52,a.getHeight());
					a.anonimo.setBounds(a.getWidth()-a.getHeight(),0,a.getHeight(),a.getHeight());
					
				}
			
			}else{
				
				a.setBounds(gera.lAbas.get(cont-1).getX()+gera.lAbas.get(cont-1).getWidth(),0,(j.pAbas.getWidth()-30)/gera.lAbas.size(),30);
				if(a.anonima){
					a.nomePagina.setBounds(30,0,a.getWidth()-a.getHeight()-52,a.getHeight());
					a.anonimo.setVisible(true);
				}else a.nomePagina.setBounds(30,0,a.getWidth()-52,a.getHeight());
				a.anonimo.setBounds(a.getWidth()-a.getHeight(),0,a.getHeight(),a.getHeight());
				
			}
			
			a.xAntigo = a.getX();
			
			cont++;
			
		}
		
		for(Paginas p : gera.lPaginas){
		
			p.setBounds(0, 0,j.pPrincipal.getWidth(),j.pPrincipal.getHeight());
			p.paginasP.setBounds(0,0,p.getWidth(),p.getHeight());
			p.paginasP.setBounds(0,0,p.getWidth(),p.getHeight());
			
			p.erro.setBounds(0,0, j.pPrincipal.getWidth(), j.pPrincipal.getHeight());
			p.erro.imgErro.setBounds((p.erro.getWidth()/100)*10,(p.erro.getHeight()/2)-150,200,200);
			p.erro.erro.setBounds(p.erro.imgErro.getX()+200+((p.erro.getWidth()/100)*10),(p.erro.getHeight()/2)-200,((p.erro.getWidth()/100)*50),200);
			p.erro.descE.setBounds(p.erro.imgErro.getX()+200+((p.erro.getWidth()/100)*10),(p.erro.getHeight()/2)-100,((p.erro.getWidth()/100)*50),200);
			
		}
		
		//itens
		
		//historico
				
		itens.camada.setBounds(0, 0, j.pPrincipal.getWidth(), j.pPrincipal.getHeight());
		itens.maeItens.setBounds(itens.camada.getWidth(), 0, 400, itens.camada.getHeight());
		
	}
	
	public void full(){
		
		j.pPrincipal.setSize(j.getWidth(), j.getHeight()-88);
		j.pPrincipal.setLocation(0,88);
		j.cabecalho.setBounds(0,0,j.pPrincipal.getWidth(),57);
		j.fechar.setBounds(j.cabecalho.getWidth()-48,0,44,30);
		j.maximizar.setBounds(j.fechar.getX()-44,0,44,30);
		j.minimizar.setBounds(j.maximizar.getX()-44,0,44,30);
		j.pItens.setBounds(0,5, j.cabecalho.getWidth()-136, 51);
		j.sombra.setBounds(0, j.cabecalho.getHeight()-1, j.cabecalho.getWidth(), 1);
		j.pAbas.setBounds(0,57, j.getWidth(), 31);
		j.novaGuia.setBounds(j.getWidth()-30,0, 30, 30);
		j.sombraG.setBounds(0, j.pAbas.getHeight()-1, j.pAbas.getWidth(), 1);
		j.bordas.setSize(j.getSize());
		j.bordas.setBackground(new Color(150,150,150,0));
		
		for(Guias g : gera.lGuias){
		
			g.setBounds(10, 0,j.pItens.getWidth(), 49);
			g.elementosBar.setSize(g.getSize());
			g.voltar.setBounds(0,7,34,34);
			g.avancar.setBounds(g.voltar.getLocation().x+g.voltar.getWidth()+2,7,34,34);
			g.caixaPesquisa.setBounds((g.getWidth()/2)-((g.getWidth()/100)*15)+68,10,(g.getWidth()/100)*30,30);
			ImageIcon imgCaixa;
			if(g.anonima)imgCaixa = new ImageIcon("imgGuias/caixaCabecalhoBlack.png");
			else imgCaixa = new ImageIcon("imgGuias/caixaCabecalho.png");
			g.caixaPesquisa.setIcon(new ImageIcon(imgCaixa.getImage().getScaledInstance(g.caixaPesquisa.getWidth(),g.caixaPesquisa.getHeight(), Image.SCALE_DEFAULT)));
			g.txtPesquisa.setBounds(10,0,g.caixaPesquisa.getWidth()-20,30);
			g.reiniciar.setBounds(g.caixaPesquisa.getX()-34,10,30,30);
			g.favorito.setBounds(g.caixaPesquisa.getX() + g.caixaPesquisa.getWidth()+((g.getWidth()/100)*2),7,34,34);
			g.menu.setBounds(g.favorito.getX() + g.favorito.getWidth()+((g.getWidth()/100)*9),7,34,34);
			g.dual.setBounds(g.menu.getX() + g.menu.getWidth()+((g.getWidth()/100)*2),7,34,34);
			g.dual.setVisible(true);
			g.opcoes.setBounds(g.dual.getX() + g.dual.getWidth()+((g.getWidth()/100)*2),7,34,34);
			g.opcoes.setVisible(true);
			
		}

		int cont=0;
		
		for(Abas a : gera.lAbas){
			
if(cont==0){
				
				if(gera.lAbas.size() == 1){
				
					a.setBounds(0,0,(j.pAbas.getWidth()-30)/gera.lAbas.size(),30);
					if(a.anonima){
						a.nomePagina.setBounds(30,0,a.getWidth()-a.getHeight()-4,a.getHeight());
						a.anonimo.setVisible(true);
					}else a.nomePagina.setBounds(30,0,a.getWidth()-4,a.getHeight());
					
					a.anonimo.setBounds(a.getWidth()-a.getHeight(),0,a.getHeight(),a.getHeight());
					
				}else{
				
					a.setBounds(0,0,(j.pAbas.getWidth()-30)/gera.lAbas.size(),30);
					if(a.anonima){
						a.nomePagina.setBounds(30,0,a.getWidth()-a.getHeight()-52,a.getHeight());
						a.anonimo.setVisible(true);
					}else a.nomePagina.setBounds(30,0,a.getWidth()-52,a.getHeight());
					a.anonimo.setBounds(a.getWidth()-a.getHeight(),0,a.getHeight(),a.getHeight());
					
				}
			
			}else{
				
				a.setBounds(gera.lAbas.get(cont-1).getX()+gera.lAbas.get(cont-1).getWidth(),0,(j.pAbas.getWidth()-30)/gera.lAbas.size(),30);
				if(a.anonima){
					a.nomePagina.setBounds(30,0,a.getWidth()-a.getHeight()-52,a.getHeight());
					a.anonimo.setVisible(true);
				}else a.nomePagina.setBounds(30,0,a.getWidth()-52,a.getHeight());
				a.anonimo.setBounds(a.getWidth()-a.getHeight(),0,a.getHeight(),a.getHeight());
				
			}
			
			a.xAntigo = a.getX();
			
			cont++;
			
		}
		
		for(Paginas p : gera.lPaginas){
		
			p.setBounds(0, 0,j.getWidth(),j.pPrincipal.getHeight());
			p.paginasP.setBounds(0,0,p.getWidth(),p.getHeight());
			p.paginasP.setBounds(0,0,p.getWidth(),p.getHeight());
			
			p.erro.setBounds(0,0, j.pPrincipal.getWidth(), j.pPrincipal.getHeight());
			p.erro.imgErro.setBounds((p.erro.getWidth()/100)*10,(p.erro.getHeight()/2)-150,200,200);
			p.erro.erro.setBounds(p.erro.imgErro.getX()+200+((p.erro.getWidth()/100)*10),(p.erro.getHeight()/2)-200,((p.erro.getWidth()/100)*50),200);
			p.erro.descE.setBounds(p.erro.imgErro.getX()+200+((p.erro.getWidth()/100)*10),(p.erro.getHeight()/2)-100,((p.erro.getWidth()/100)*50),200);
		
		}
		
		//itens
		
		//historico
		
		itens.camada.setBounds(0, 0, j.pPrincipal.getWidth(), j.pPrincipal.getHeight());
		itens.maeItens.setBounds(itens.camada.getWidth(), 0, 400, itens.camada.getHeight());
		
	}
	
	// Mudar tamanho do Frame
	
	public static Point getScreenLocation(MouseEvent e, JFrame frame)   {  
        Point cursor = e.getPoint();  
        Point view_location = frame.getLocationOnScreen();  
        return new Point((int) (view_location.getX() + cursor.getX()),  
                (int) (view_location.getY() + cursor.getY()));  
	}  
	
	public static Point cursorLocation;
	
	public void mudarCursor(){
		
		if(j.getWidth() < tela.getWidth() || j.getHeight() < tela.getHeight())  {
			  
	        int xPos = cursorLocation.x;           
	        int yPos = cursorLocation.y;        
	                
	        if(xPos >= cursorArea && xPos <= j.getWidth()-cursorArea && yPos >= j.getHeight()-cursorArea)        
	            j.setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));        
	        else if(xPos >= j.getWidth()-cursorArea && yPos >= cursorArea && yPos <= j.getHeight()-cursorArea)        
	            j.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));        
	        else if(xPos <= cursorArea && yPos >= cursorArea && yPos <= j.getHeight()-cursorArea)        
	            j.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));        
	        else if(xPos >= cursorArea && xPos <= j.getWidth()-cursorArea && yPos <= cursorArea)        
	            j.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));        
	        else if(xPos <= cursorArea && yPos <= cursorArea)        
	            j.setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));        
	        else if(xPos >= j.getWidth() - cursorArea && yPos <= cursorArea)        
	            j.setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));        
	        else if(xPos >= j.getWidth()-cursorArea && yPos >= j.getHeight()-cursorArea)        
	            j.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));        
	        else if(xPos <= cursorArea && yPos >= j.getHeight()-cursorArea)        
	            j.setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));        
	        else       
	            j.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	        
		}
		
	}
	
	//duplo click
	
	public void headerDoubleClickResize(){
		
        if(j.getWidth() < tela.getWidth() || j.getHeight() < tela.getHeight()){  
        	
        	j.maximizar.setIcon(new ImageIcon("imgJanela/restaurar.png"));
        	tela = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();  
        	antigoTamanho = j.getSize();
        	antigaLoc = j.getLocation();
        	j.setSize(tela.getSize()); 
        	j.setLocation(0, 0);
        	typeScreen();
              
        }else{     
        	j.setSize(antigoTamanho); 
        	j.setLocation(antigaLoc);
        	j.maximizar.setIcon(new ImageIcon("imgJanela/maximizar.png"));
        	typeScreen();
        	
        }     
    }
	
	public Object sourceObject;
	public Point current;
	
	public int newWidth;        
    public int newHeight;        
	
	public void sizeFrame(){
		 
        Point offset = new Point((int)current.getX()- (int)start_drag.getX(), (int)current.getY()- (int)start_drag.getY());           
        
        
        if(sourceObject instanceof JPanel && j.getCursor().equals(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR))){     
        	
        	if(j.getWidth() == tela.getWidth() || j.getHeight() == tela.getHeight()){
        		
	        	int posicao = (int) ((int)(current.getX()/(j.getWidth()/antigoTamanho.getWidth())));
	        	int posicaoH = (int) ((int)(current.getY()/(j.getHeight()/antigoTamanho.getHeight())));
        		j.setSize(antigoTamanho);
	        	j.setLocation((int) current.getX()-posicao, (int) current.getY()-posicaoH);
	        	start_loc = j.getLocation();
	        	typeScreen();
	       
        	}else{
	        	j.setLocation((int) (start_loc.getX() + offset.getX()), (int) (start_loc.getY() + offset.getY()));   
	        }
        	          
        }else if(!j.getCursor().equals(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR))){           
            
        	int oldLocationX = (int)j.getLocation().getX();        
            int oldLocationY = (int)j.getLocation().getY();        
            int newLocationX = (int) (this.start_loc.getX() + offset.getX());        
            int newLocationY = (int) (this.start_loc.getY() + offset.getY());          
            boolean N_Resize = j.getCursor().equals(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));        
            boolean NE_Resize = j.getCursor().equals(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));        
            boolean NW_Resize = j.getCursor().equals(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));        
            boolean E_Resize = j.getCursor().equals(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));        
            boolean W_Resize = j.getCursor().equals(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));        
            boolean S_Resize = j.getCursor().equals(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));        
            boolean SW_Resize = j.getCursor().equals(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));        
            boolean setLocation = false;        
                    
            if(NE_Resize){             
                newHeight = j.getHeight() - (newLocationY - oldLocationY);         
                newLocationX = (int)j.getLocation().getX();        
                setLocation = true;        
            }        
           
            else if(E_Resize)        
                newHeight = j.getHeight();         
           
            else if(S_Resize)        
                newWidth = j.getWidth();                      
            
            else if(N_Resize){           
                newLocationX = (int)j.getLocation().getX();        
                newWidth = j.getWidth();        
                newHeight = j.getHeight() - (newLocationY - oldLocationY);        
                setLocation = true;        
            
            }else if(NW_Resize){        
                newWidth = j.getWidth() - (newLocationX - oldLocationX);        
                newHeight = j.getHeight() - (newLocationY - oldLocationY);        
                setLocation =true;        
            
            }else if(NE_Resize){             
                newHeight = j.getHeight() - (newLocationY - oldLocationY);        
                newLocationX = (int)j.getLocation().getX();          
            
            }else if(SW_Resize){           
                newWidth = j.getWidth() - (newLocationX - oldLocationX);        
                newLocationY = (int)j.getLocation().getY();                       
                setLocation =true;        
            }        
            if(W_Resize){           
                newWidth = j.getWidth() - (newLocationX - oldLocationX);        
                newLocationY = (int)j.getLocation().getY();           
                newHeight = j.getHeight();        
                setLocation =true;        
            }         
                                    
            if(newWidth >= (int)toolkit.getScreenSize().getWidth() || newWidth <= j.getMinimumSize().getWidth()){        
                newLocationX = oldLocationX;        
                newWidth = j.getWidth();
                typeScreen();
            }        
                    
            if(newHeight >= (int)toolkit.getScreenSize().getHeight() - 30 || newHeight <= j.getMinimumSize().getHeight()){        
                newLocationY = oldLocationY;        
                newHeight = j.getHeight();
                typeScreen();
            }        
                    
            if(newWidth != j.getWidth() || newHeight != j.getHeight()){        
                j.setSize(newWidth, newHeight);
                typeScreen();
                            
                if(setLocation)        
                    j.setLocation(newLocationX, newLocationY);
                typeScreen();
            }        
        }        
		
	}
	
}
