package br.edu.etec.folks.caronte.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import br.edu.etec.folks.caronte.controller.GeraGuia;
import br.edu.etec.folks.caronte.controllerView.EfeitoItens;
import br.edu.etec.folks.caronte.controllerView.Responsivo;

public class ItensLateral {

	Responsivo resp = new Responsivo();
	GeraGuia gera = new GeraGuia();
	
	public int itemAberto = 0;
	
	public Historico historico;
	public Favoritos favoritos;
	public FavoritoForm favorito;
	public Ferramentas ferramentas;
	
	public JPanel camada, maeItens, itens;
	
	JButton btnHistorico, btnFavorito;
	
	public ItensLateral(){
		
		camada = new JPanel();
		camada.setLayout(null);
		camada.setBounds(0, 0, resp.j.pPrincipal.getWidth(), resp.j.pPrincipal.getHeight());
		camada.setBackground(new Color(0,0, 0, 0));
		camada.setVisible(false);
		camada.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {}
			 @Override
			 public void mouseExited(MouseEvent e) {}
		});
		camada.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				for(Guias g : gera.lGuias){
					
					if(g.menuC || g.favoritoC || g.opcoesC){
						g.menuC = false;
						g.favoritoC = false;
						g.opcoesC = false;
						g.favorito.setIcon(new ImageIcon("imgGuias/imgFavorito.png"));
						g.menu.setIcon(new ImageIcon("imgGuias/menu.png"));
						g.opcoes.setIcon(new ImageIcon("imgGuias/opcoes.png"));
						break;
					}
					
				}
				
				EfeitoItens efeitoI = new EfeitoItens();
				efeitoI.escondeIten(false);
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			
			
		});
		resp.j.pPrincipal.add(camada);
		
		maeItens = new JPanel();
		maeItens.setLayout(null);
		maeItens.setBounds(camada.getWidth(), 0, 340, camada.getHeight());
		maeItens.setBackground(new Color(230, 230, 230));
		maeItens.requestFocus();
		maeItens.addFocusListener(new FocusListener() {  
			@Override
			public void focusGained(FocusEvent e) {		
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}  
  
		});
		camada.add(maeItens);
		
		itens = new JPanel();
		itens.setLayout(null);
		itens.setBounds(0,0, maeItens.getWidth(), 50);
		itens.setBackground(new Color(230, 230, 230));
		itens.setVisible(false);
		maeItens.add(itens);
		
		btnHistorico = (new JButton());
		btnHistorico.setBounds(maeItens.getWidth()/2,0,maeItens.getWidth()/2,50);
		btnHistorico.setIcon(new ImageIcon("imgLateral/imgHistorico.png"));
		btnHistorico.setBackground(new Color(200,200,200));
		btnHistorico.setBorder(null);
		btnHistorico.setFont(new Font("Century Gothic",  Font. PLAIN,  16));
		btnHistorico.setFocusPainted(false);
		btnHistorico.setHorizontalAlignment(SwingConstants.CENTER);
		btnHistorico.setVerticalAlignment(SwingConstants.CENTER);
		btnHistorico.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 btnHistorico.setBackground(new Color(230,230,230));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 if(itemAberto == 2)btnHistorico.setBackground(new Color(230,230,230));
					else btnHistorico.setBackground(new Color(200,200,200));
				 
			}
		});
		
		btnHistorico.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				EfeitoItens efeitoI = new EfeitoItens();
				efeitoI.goHistorico();
				
				btnHistorico.setBackground(new Color(230, 230, 230));
				btnFavorito.setBackground(new Color(200, 200, 200));
				itemAberto = 2;
				
			}
				
		});
		
		itens.add(btnHistorico);
		
		btnFavorito = (new JButton());
		btnFavorito.setBounds(0,0,maeItens.getWidth()/2,50);
		btnFavorito.setIcon(new ImageIcon("imgGuias/imgFavorito.png"));
		btnFavorito.setBackground(new Color(230,230,230));
		btnFavorito.setBorder(null);
		btnFavorito.setFont(new Font("Century Gothic",  Font. PLAIN,  16));
		btnFavorito.setFocusPainted(false);
		btnFavorito.setHorizontalAlignment(SwingConstants.CENTER);
		btnFavorito.setVerticalAlignment(SwingConstants.CENTER);
		btnFavorito.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 btnFavorito.setBackground(new Color(230,230,230));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 if(itemAberto == 1)btnFavorito.setBackground(new Color(230,230,230));
					else btnFavorito.setBackground(new Color(200,200,200));
				 
			}
		});
		
		btnFavorito.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				EfeitoItens efeitoI = new EfeitoItens();
				efeitoI.goFavoritos();
				
				btnFavorito.setBackground(new Color(230, 230, 230));
				btnHistorico.setBackground(new Color(200, 200, 200));
				itemAberto = 1;
				
			}
				
		});
		
		itens.add(btnFavorito);
		
	}
	
	public void apresentaHistorico(){
		historico = new Historico();
		historico.addItens();
	}
	
	public void apresentaFavoritos(){
		favoritos = new Favoritos();
	}
	
	public void apresentaAddFavorito(){
		favorito = new FavoritoForm();
	}
	
	public void apresentaFerramentas(){
		ferramentas = new Ferramentas();
	}
	
}
