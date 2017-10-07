package br.edu.etec.folks.caronte.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import br.edu.etec.folks.caronte.controller.BuscaPagina;
import br.edu.etec.folks.caronte.controller.GeraGuia;
import br.edu.etec.folks.caronte.controllerView.EfeitoItens;
import br.edu.etec.folks.caronte.controllerView.EfeitosDual;
import br.edu.etec.folks.caronte.controllerView.Responsivo;

public class Guias extends JPanel{

	Responsivo resp =  new Responsivo();
	
	BuscaPagina busca = new BuscaPagina();
	
	GeraGuia gera = new GeraGuia();
	
	public JPanel elementosBar;
	public JLabel caixaPesquisa;
	public JTextField txtPesquisa;
	public JButton voltar, avancar, reiniciar, dual, menu, favorito, opcoes;
	//clicado ou não
	public boolean menuC = false, favoritoC = false, opcoesC = false;
	
	boolean clicado = false;
	
	public boolean aberta = true, anonima= false;
	public  int indexDual = 0;
	public boolean foco = true;
	//nome site
	public String nomeSite, url;
	
	public Guias(){
		
		this.setLayout(null);
		this.setBounds(10, 0,resp.j.pItens.getWidth(), 49);
//		this.setBackground(new Color(230,230,230));
		this.setOpaque(false);
		
		elementosBar = new JPanel();
		elementosBar.setLayout(null);
		elementosBar.setBounds(this.getBounds());
//		elementosBar.setBackground(new Color(230,230,230));
		elementosBar.setOpaque(false);
		elementosBar.setFocusable(true);
		
		this.add(elementosBar);
		
		voltar = (new JButton());
		voltar.setIcon(new ImageIcon("imgGuias/anterior.png"));
		voltar.setBounds(0,7,34,34);
		voltar.setOpaque(false);
		voltar.setContentAreaFilled(false);
		voltar.setBorder(null);
		voltar.setFont(new Font("Century Gothic",  Font. PLAIN,  40));
		voltar.setFocusPainted(false);
		voltar.setHorizontalAlignment(SwingConstants.CENTER);
		voltar.setVerticalAlignment(SwingConstants.CENTER);
		voltar.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				if(busca.lVoltar.size() > 0)voltar.setIcon(new ImageIcon("imgGuias/anteriorC.png"));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 voltar.setIcon(new ImageIcon("imgGuias/anterior.png"));
				 
			}
		});
		
		voltar.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				
				if(busca.lVoltar.size() > 0){
					foco = !foco;
					busca.voltar();
				}
				
			}
					
		});
		elementosBar.add(voltar);
		
		avancar = (new JButton());
		avancar.setIcon(new ImageIcon("imgGuias/avancar.png"));
		avancar.setBounds(voltar.getLocation().x+voltar.getWidth()+2,7,34,34);
		avancar.setOpaque(false);
		avancar.setContentAreaFilled(false);
		avancar.setBorder(null);
		avancar.setFont(new Font("Century Gothic",  Font. PLAIN,  40));
		avancar.setFocusPainted(false);
		avancar.setHorizontalAlignment(SwingConstants.CENTER);
		avancar.setVerticalAlignment(SwingConstants.CENTER);
		avancar.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 if(busca.lAvancar.size() > 0)avancar.setIcon(new ImageIcon("imgGuias/avancarC.png"));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 avancar.setIcon(new ImageIcon("imgGuias/avancar.png"));
				 
			}
		});
		
		avancar.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				if(busca.lAvancar.size() > 0){
					foco = !foco;
					busca.avancar();
				}
				
			}
			
					
		});
		elementosBar.add(avancar);
		
		ImageIcon imgCaixa = null;
		
		if(anonima)imgCaixa = new ImageIcon("imgGuias/caixaCabecalhoBlack.png");
		else imgCaixa = new ImageIcon("imgGuias/caixaCabecalho.png");
		
		caixaPesquisa = new JLabel();
		caixaPesquisa.setBounds((resp.j.getWidth()/2)-((resp.j.getWidth()/100)*15),10,(resp.j.getWidth()/100)*30,30);
		caixaPesquisa.setIcon(new ImageIcon(imgCaixa.getImage().getScaledInstance(caixaPesquisa.getWidth(),caixaPesquisa.getHeight(), Image.SCALE_DEFAULT)));
		caixaPesquisa.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent e) {
	           
	        	 int key = e.getKeyCode();
	           
	           if (key == KeyEvent.VK_ENTER) {
	              
	        	   Toolkit.getDefaultToolkit().beep();   
	        	   txtPesquisa.setForeground(new Color(200,200,200));
	              
	           }
	           
	         }
	         
	        }
		
	     );
		
		caixaPesquisa.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				
				 if(!clicado){
				 
					 txtPesquisa.setForeground(new Color(0,0,0));
				 
				 }
					 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				
				 if(!clicado){
				 
					 txtPesquisa.setForeground(new Color(200,200,200));
				 
				 }
					 
			}
		});
		caixaPesquisa.addFocusListener(new FocusListener() {  

			@Override
			public void focusGained(FocusEvent e) {
							
				txtPesquisa.selectAll();
				txtPesquisa.setForeground(new Color(0,0,0));
				clicado=true;
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				
				txtPesquisa.setForeground(new Color(200,200,200));
				clicado=false;
				
			}  
 
		});
		
		elementosBar.add(caixaPesquisa);
		
		txtPesquisa = new JTextField();
		txtPesquisa.setForeground(new Color(200,200,200));
		txtPesquisa.setBounds(10,0,caixaPesquisa.getWidth()-20,30);
		txtPesquisa.setOpaque(false);
		txtPesquisa.setBorder(null);
		txtPesquisa.setFont(new Font("Arial",  Font. PLAIN,  14));
		txtPesquisa.setHorizontalAlignment(SwingConstants.CENTER);
		txtPesquisa.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent e) {
	           
	           if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	              
	        	   Toolkit.getDefaultToolkit().beep();   
	        	   
	        	   try {
	        		   
	        		    foco = !foco;
	        		   
	        		    busca.guardaPagina(txtPesquisa.getText());
	        		    
						busca.url = new URL(txtPesquisa.getText());
	        		    busca.buscarPagina(true, true);
	        	   } catch (MalformedURLException e1) {
	        		    
			   			try {
			   				
			   				busca.guardaPagina(txtPesquisa.getText());
							busca.url = new URL("https://www.google.com.br/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q="+txtPesquisa.getText().replace(" ", "+"));
							  busca.buscarPagina(true, true);
			   			} catch (MalformedURLException e2) {
							busca.buscarPagina(true, true);
			        		   
			        		   foco = true;
				        	   
				        	   int index=0;
				        	   
					        	for(Guias g : gera.lGuias){
					        			
					       			if(g.foco)break;
					       			
					       			index++;
					       			
					       		}
//					           busca.reconectar();
					           gera.lPaginas.get(index).erro.erro.setText("<html>Não é possível acessar "+txtPesquisa.getText()+".</html>");
							   gera.lPaginas.get(index).paginasP.setVisible(false);
					           gera.lPaginas.get(index).erro.setVisible(true);	   
					           foco = !foco;  
				        	   txtPesquisa.setFocusable(false);
				        	   txtPesquisa.setFocusable(true);
						
			   			}
	        		   
	        	   }
	              
	           }
	           
	         }
	         
	        }
		
	     );

		txtPesquisa.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				
				if(!clicado){
					 
					if(anonima)txtPesquisa.setForeground(new Color(255,255,255));
					else txtPesquisa.setForeground(new Color(0,0,0));
				
				 }
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				
				 if(!clicado){
				 
					 txtPesquisa.setForeground(new Color(200,200,200));
					 
				 }
				 
			}
		});
		txtPesquisa.addFocusListener(new FocusListener() {  

			@Override
			public void focusGained(FocusEvent e) {
							
				txtPesquisa.selectAll();
				if(anonima)txtPesquisa.setForeground(new Color(255,255,255));
				else txtPesquisa.setForeground(new Color(0,0,0));
				clicado=true;
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				
				txtPesquisa.setForeground(new Color(200,200,200));
				clicado=false;
				
			}  
  
		});
		caixaPesquisa.add(txtPesquisa);
		
		reiniciar = (new JButton());
		reiniciar.setIcon(new ImageIcon("imgGuias/reiniciar.png"));
		reiniciar.setBounds(caixaPesquisa.getX()-34,10,30,30);
		reiniciar.setOpaque(false);
		reiniciar.setContentAreaFilled(false);
		reiniciar.setBorder(null);
		reiniciar.setFont(new Font("Century Gothic",  Font. PLAIN,  40));
		reiniciar.setFocusPainted(false);
		reiniciar.setHorizontalAlignment(SwingConstants.CENTER);
		reiniciar.setVerticalAlignment(SwingConstants.CENTER);
		reiniciar.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 reiniciar.setIcon(new ImageIcon("imgGuias/reiniciarC.png"));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 reiniciar.setIcon(new ImageIcon("imgGuias/reiniciar.png"));
				 
			}
		});
		
		reiniciar.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
//					pesquisa.reiniciar();
				
			}
			
					
		});
		elementosBar.add(reiniciar);
		
		favorito = new JButton();
		favorito.setIcon(new ImageIcon("imgGuias/imgFavorito.png"));
		favorito.setBounds(caixaPesquisa.getX() + caixaPesquisa.getWidth()+((this.getWidth()/100)*6),7,34,34);
		favorito.setContentAreaFilled(false);
		favorito.setBorder(null);
		favorito.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 if(!favoritoC)favorito.setIcon(new ImageIcon("imgGuias/imgFavoritoC.png"));
				 else favorito.setIcon(new ImageIcon("imgGuias/imgFavoritoRedC.png"));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 if(!favoritoC)favorito.setIcon(new ImageIcon("imgGuias/imgFavorito.png"));
				 else favorito.setIcon(new ImageIcon("imgGuias/imgFavoritoRed.png"));
				 
			}
		});
		
		favorito.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				if(!favoritoC){
				
					foco = true;
					
					EfeitoItens efeitoI = new EfeitoItens();
					
					resp.j.pPrincipal.setComponentZOrder(resp.itens.camada, 0);
					resp.itens.camada.setVisible(true);
					resp.itens.apresentaAddFavorito();
					resp.itens.itemAberto = 0;
					
					resp.itens.favorito.txtNome.setText(nomeSite);
					
					resp.itens.favorito.url = ""+busca.url;
					
					efeitoI.apresentaIten();
					
					favorito.setIcon(new ImageIcon("imgGuias/imgFavoritoRedC.png"));
					
					favoritoC = !favoritoC;
				
				}else{	

					EfeitoItens efeitoI = new EfeitoItens();
					efeitoI.escondeIten(false);
					
					favorito.setIcon(new ImageIcon("imgGuias/imgFavoritoC.png"));
					
					favoritoC = !favoritoC;
					
				}
				
			}
			
					
		});
		elementosBar.add(favorito);
		
		menu = new JButton();
		menu.setIcon(new ImageIcon("imgGuias/menu.png"));
		menu.setBounds(favorito.getX() + favorito.getWidth()+((this.getWidth()/100)*6),7,34,34);
		menu.setContentAreaFilled(false);
		menu.setBorder(null);
		menu.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 if(!menuC) menu.setIcon(new ImageIcon("imgGuias/menuC.png"));
				 else menu.setIcon(new ImageIcon("imgGuias/menuRedC.png"));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 if(!menuC) menu.setIcon(new ImageIcon("imgGuias/menu.png"));
				 else menu.setIcon(new ImageIcon("imgGuias/menuRed.png"));
				 
			}
		});
		
		menu.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				if(!menuC){
				
					foco = true;
					
					EfeitoItens efeitoI = new EfeitoItens();
				
					resp.j.pPrincipal.setComponentZOrder(resp.itens.camada, 0);
					resp.itens.camada.setVisible(true);
					resp.itens.maeItens.add(resp.itens.itens);
					resp.itens.itens.setVisible(true);
					resp.itens.apresentaFavoritos();
					resp.itens.apresentaHistorico();
					resp.itens.itemAberto = 1;
					
					menu.setIcon(new ImageIcon("imgGuias/menuRedC.png"));
					menuC = !menuC;
				
				efeitoI.apresentaIten();
				
				}else{
					
					EfeitoItens efeitoI = new EfeitoItens();
					efeitoI.escondeIten(false);
					
					menu.setIcon(new ImageIcon("imgGuias/menuC.png"));
					menuC = !menuC;
					
				}
				
			}
			
		});
		elementosBar.add(menu);
		
		dual = (new JButton());
		dual.setIcon(new ImageIcon("imgGuias/dual.png"));
		dual.setBounds(menu.getX() + menu.getWidth()+((this.getWidth()/100)*10),7,34,34);
		dual.setOpaque(false);
		dual.setContentAreaFilled(false);
		dual.setBorder(null);
		dual.setFont(new Font("Century Gothic",  Font. PLAIN,  40));
		dual.setFocusPainted(false);
		dual.setHorizontalAlignment(SwingConstants.CENTER);
		dual.setVerticalAlignment(SwingConstants.CENTER);
		dual.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 dual.setIcon(new ImageIcon("imgGuias/dualC.png"));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 dual.setIcon(new ImageIcon("imgGuias/dual.png"));
				 
			}
		});
		
		dual.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				for(Guias g : gera.lGuias){
					
					if(g.aberta)g.indexDual = 1;
					
				}
				
				for(Paginas p : gera.lPaginas){
				
					if(p.aberta)p.indexDual = 1;
					
				}
				
				EfeitosDual efeitos = new EfeitosDual();
				efeitos.aumentaCabecalho();
				
			}
			
					
		});
		elementosBar.add(dual);
		
		opcoes = new JButton();
		opcoes.setIcon(new ImageIcon("imgGuias/opcoes.png"));
		opcoes.setBounds(dual.getX() + dual.getWidth()+((this.getWidth()/100)*2),7,34,34);
		opcoes.setContentAreaFilled(false);
		opcoes.setBorder(null);
		opcoes.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 if(!opcoesC) opcoes.setIcon(new ImageIcon("imgGuias/opcoesC.png"));
				 else opcoes.setIcon(new ImageIcon("imgGuias/opcoesRedC.png"));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 if(!opcoesC) opcoes.setIcon(new ImageIcon("imgGuias/opcoes.png"));
				 else opcoes.setIcon(new ImageIcon("imgGuias/opcoesRed.png"));
				 
			}
		});
		
		opcoes.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				if(!opcoesC){
				
					EfeitoItens efeitoI = new EfeitoItens();
					
					resp.j.pPrincipal.setComponentZOrder(resp.itens.camada, 0);
					resp.itens.camada.setVisible(true);
					resp.itens.apresentaFerramentas();
					resp.itens.itemAberto = 3;
					
					efeitoI.apresentaIten();
					
					opcoes.setIcon(new ImageIcon("imgGuias/opcoesRedC.png"));
					
					opcoesC = !opcoesC;
					
				}else{
					

					EfeitoItens efeitoI = new EfeitoItens();
					efeitoI.escondeIten(false);
					
					opcoes.setIcon(new ImageIcon("imgGuias/opcoesC.png"));
					
					opcoesC = !opcoesC;
					
				}
					
			}
			
		});
		elementosBar.add(opcoes);
		
	}
	
	public void pagina1(){
		
		try {
			busca.url = new URL("https://www.google.com.br/");
			busca.buscarPagina(true, false);
		} catch (MalformedURLException e1) {}
		
	}
	
}
