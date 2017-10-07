package br.edu.etec.folks.caronte.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LookAndFeel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import br.edu.etec.folks.caronte.controller.GeraGuia;
import br.edu.etec.folks.caronte.controllerView.EfeitoItens;
import br.edu.etec.folks.caronte.controllerView.Responsivo;
import br.edu.etec.folks.caronte.dao.CrudFavoritos;
import br.edu.etec.folks.caronte.model.PaginasFavoritos;

public class Favoritos {

	Responsivo resp = new Responsivo();
	CrudFavoritos crud = new CrudFavoritos();
	PaginasFavoritos paginas = new PaginasFavoritos();
	GeraGuia gera = new GeraGuia();
	int indice = 0;
	
	public JPanel pFavoritos, rolante;
	
	public JScrollPane scroll;
	
	public JLabel lblTitulo, borda;
	
	public JPanel pastas[];
	JLabel icone, seta;
	public JPanel pastasItens[];
	List<JPanel>lItens = new ArrayList<JPanel>();
	List<JButton>lFechar = new ArrayList<JButton>();
	List<JButton>lEditar = new ArrayList<JButton>();
	List<String>lUrl = new ArrayList<String>();
	public int tamanhoP[];
	
	public Favoritos(){
		
		pFavoritos = new JPanel();
		pFavoritos.setLayout(null);
		pFavoritos.setBounds(0, 50, 340, resp.itens.camada.getHeight()-50);
		pFavoritos.setBackground(new Color(230, 230, 230));
		pFavoritos.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			
		});
		resp.itens.maeItens.add(pFavoritos);
		
		lblTitulo = new JLabel("Favoritos");
		lblTitulo.setBounds(40, 25, 100, 30);
		lblTitulo.setFont(new Font("Arial",  Font.PLAIN,  22));
		lblTitulo.setVerticalAlignment(SwingConstants.CENTER);
		pFavoritos.add(lblTitulo);
		
		borda = new JLabel();
		borda.setBounds(0, 60, pFavoritos.getWidth()-40, 1);
		borda.setOpaque(true);
		borda.setBackground(new Color(180,180,180));
		pFavoritos.add(borda);
		
		rolante = new JPanel();
		
		LookAndFeel lfAnterior = UIManager.getLookAndFeel();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception ex) {
			ex.printStackTrace();
			}
		
		scroll = new JScrollPane(rolante);
		scroll.setBounds(0, 70, 340, pFavoritos.getHeight()-70);
		scroll.setBorder(null);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBackground(new Color(230, 230, 230));
		scroll.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
	        @Override
	        public void adjustmentValueChanged(final AdjustmentEvent e) {
	        	scroll.repaint();
	        }
	    });
		scroll.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {
	        @Override
	        public void adjustmentValueChanged(final AdjustmentEvent e) {
	        	scroll.repaint();
	        }
	    });
		pFavoritos.add(scroll);
		
		try {
			UIManager.setLookAndFeel(lfAnterior);
			} catch (Exception ex) {
			ex.printStackTrace();
			}
		
		rolante.setLayout(null);
		rolante.setBounds(0, 0, 340, scroll.getHeight());
		rolante.setBackground(new Color(230, 230, 230));
		
		addElementos();
		
	}
	
	public void addElementos(){
		
		pastas = new JPanel[4];
		
		for(int i=0; i<pastas.length; i++){
			
			pastas[i] = new JPanel();
			pastas[i].setLayout(null);
			
			if(i<1)pastas[i].setBounds(5, 70, pFavoritos.getWidth()-10, 35);
			else pastas[i].setBounds(5, pastas[i-1].getY()+35, pFavoritos.getWidth()-10, 35);
			
			pastas[i].setBackground(new Color(230,230,230));
			pastas[i].addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent arg0) {}
				@Override
				public void mouseEntered(MouseEvent e) {
					((JPanel)e.getSource()).setBackground(new Color(200, 200, 200));
				}
				public void mouseExited(MouseEvent e) {
					((JPanel)e.getSource()).setBackground(new Color(230, 230, 230));
				}
				public void mousePressed(MouseEvent arg0) {}
				public void mouseReleased(MouseEvent arg0) {}
				
				
			});
			
			rolante.add(pastas[i]);
			
			if(i==0){
				icone = new JLabel("Pessoais");
				icone.setIcon(new ImageIcon("imgLateral/casaP.png"));
			}else if(i==1){
				icone = new JLabel("Trabalho");
				icone.setIcon(new ImageIcon("imgLateral/trabalhoP.png"));
			}else if(i==2){
				icone = new JLabel("Escola");
				icone.setIcon(new ImageIcon("imgLateral/escolaP.png"));
			}else{
				icone = new JLabel("Outros");
				icone.setIcon(new ImageIcon("imgLateral/outrosP.png"));
			}
			
			icone.setBounds(5, 0, 100, 35);
			icone.setFont(new Font("Arial",  Font.PLAIN,  14));
			icone.setVerticalAlignment(SwingConstants.CENTER);
			icone.setHorizontalAlignment(SwingConstants.LEFT);
			icone.setVerticalTextPosition(SwingConstants.CENTER);
			icone.setHorizontalTextPosition(SwingConstants.RIGHT);
			pastas[i].add(icone);
			
			seta = new JLabel();
			seta.setIcon(new ImageIcon("imgLateral/fechar.png"));
			seta.setBounds(pastas[i].getWidth()-65, 0, 35, 35);
			seta.setFont(new Font("Arial",  Font.PLAIN,  14));
			seta.setVerticalAlignment(SwingConstants.CENTER);
			seta.setHorizontalAlignment(SwingConstants.CENTER);
			pastas[i].add(seta);
			
		}
		
		int cont=0;
		
		pastasItens = new JPanel[4];
		tamanhoP = new int[4];
		
		for(int i=0; i<pastasItens.length; i++){
			
			pastasItens[i] = new JPanel();
			pastasItens[i].setLayout(null);
			pastasItens[i].setBounds(pastas[i].getX(), pastas[i].getY()+pastas[i].getHeight(), pastas[i].getWidth(), 10);
			pastasItens[i].setBackground(new Color(230, 230, 230));	
			
			for(PaginasFavoritos p: crud.lFavoritos){
					
				if(p.getPasta()==i+1){
						
					JPanel itens = new JPanel();
					itens.setLayout(null);
					itens.setBounds(0, tamanhoP[i], pastas[i].getWidth(), 35);
					itens.setBackground(new Color(230, 230, 230));
					itens.addMouseListener(new MouseListener(){

						@Override
						public void mouseClicked(MouseEvent arg0) {
							CrudFavoritos.BuscarFavorito(lUrl.get(indice));
							EfeitoItens efeitoI = new EfeitoItens();
							efeitoI.escondeIten(false);
						}
						@Override
						public void mouseEntered(MouseEvent e) {
							
							((JPanel)e.getSource()).setBackground(new Color(200, 200, 200));
							
							indice = 0;
							for(JPanel p : lItens){
								if(((JPanel)e.getSource())==p){
									break;
								}
								indice++;
							}
							
							lFechar.get(indice).setVisible(true);
							lEditar.get(indice).setVisible(true);
							
						}
						public void mouseExited(MouseEvent e) {
							((JPanel)e.getSource()).setBackground(new Color(230, 230, 230));
							lFechar.get(indice).setVisible(false);
							lEditar.get(indice).setVisible(false);
						}
						public void mousePressed(MouseEvent arg0) {}
						public void mouseReleased(MouseEvent arg0) {}
						
						
					});
					lItens.add(itens);
					
					JLabel nome = new JLabel(p.getNomeFav());
					nome.setBounds(10, 0, lItens.get(lItens.size()-1).getWidth()-93, 35);
					nome.setFont(new Font("Arial",  Font.PLAIN,  14));
					nome.setVerticalAlignment(SwingConstants.CENTER);
					nome.setVerticalAlignment(SwingConstants.CENTER);
					lItens.get(lItens.size()-1).add(nome);
					
					JButton fechar = new JButton();
					fechar.setBounds(lItens.get(lItens.size()-1).getWidth()-63, 2, 30, 30);
					fechar.setIcon(new ImageIcon("imgJanela/closeRed.png"));
					fechar.setVerticalAlignment(SwingConstants.CENTER);
					fechar.setHorizontalAlignment(SwingConstants.CENTER);
					fechar.setContentAreaFilled(false);
					fechar.setBorder(null);
					fechar.setVisible(false);
					fechar.addMouseListener(new MouseAdapter() {
						 @Override
						 public void mouseEntered(MouseEvent e) {
							
							 ((JButton)e.getSource()).setVisible(true);
							 lItens.get(indice).setBackground(new Color(200,200,200));
							lEditar.get(indice).setVisible(true);
									 
						 }
						 @Override
						 public void mouseExited(MouseEvent e) {
							 ((JButton)e.getSource()).setVisible(true);
							lEditar.get(indice).setVisible(true);
						 }
					});
					fechar.addActionListener(new ActionListener(){
		
						public void actionPerformed(ActionEvent e) {
							
							CrudFavoritos.remover(lUrl.get(indice));
							rolante.removeAll();
							addElementos();
							
						}
						
								
					});
					lFechar.add(fechar);
					lItens.get(lItens.size()-1).add(lFechar.get(lFechar.size()-1));
					
					JButton editar = new JButton();
					editar.setBounds(lItens.get(lItens.size()-1).getWidth()-93, 2, 30, 30);
					editar.setIcon(new ImageIcon("imgLateral/iconEditar.png"));
					editar.setVerticalAlignment(SwingConstants.CENTER);
					editar.setHorizontalAlignment(SwingConstants.CENTER);
					editar.setContentAreaFilled(false);
					editar.setBorder(null);
					editar.setVisible(false);
					editar.addMouseListener(new MouseAdapter() {
						 @Override
						 public void mouseEntered(MouseEvent e) {
							
							 ((JButton)e.getSource()).setVisible(true);
							 lItens.get(indice).setBackground(new Color(200,200,200));
							 lFechar.get(indice).setVisible(true);
						 }
						 @Override
						 public void mouseExited(MouseEvent e) {
							 ((JButton)e.getSource()).setVisible(true);
							 lFechar.get(indice).setVisible(true);
						 }
					});
					editar.addActionListener(new ActionListener(){
		
						public void actionPerformed(ActionEvent e) {
							
							for(Guias g : gera.lGuias){
								
								if(g.menuC || g.favoritoC){
									g.menuC = false;
									g.favoritoC = false;
									g.favorito.setIcon(new ImageIcon("imgGuias/imgFavorito.png"));
									g.menu.setIcon(new ImageIcon("imgGuias/menu.png"));
									break;
								}
								
							}
							
							EfeitoItens efeitoI = new EfeitoItens();
							efeitoI.url = lUrl.get(indice); 
							for(PaginasFavoritos f : crud.lFavoritos){
								if(f.getUrlFav().equals(lUrl.get(indice))){
									efeitoI.nome = f.getNomeFav();
								}
							}
							efeitoI.escondeIten(true);
							
						}
						
								
					});
					lEditar.add(editar);
					lItens.get(lItens.size()-1).add(lEditar.get(lEditar.size()-1));
					
					lUrl.add(p.getUrlFav());
					
					pastasItens[i].add(lItens.get(lItens.size()-1));
					tamanhoP[i]+=35;
					pastasItens[i].setSize(pastas[i].getWidth(), tamanhoP[i]);
						
				}
				
			}
			
			rolante.add(pastasItens[i]);
			
		}
		
		int altura = 0;
		
		for(int i=0; i<tamanhoP.length; i++){
			
			if(tamanhoP[i]>0){
				
				pastas[i].setLocation(pastas[i].getX(), altura);
				altura+= pastas[i].getHeight();
				pastasItens[i].setLocation(pastasItens[i].getX(), altura);
				borda = new JLabel();
				borda.setBounds(0, pastasItens[i].getHeight(), pastasItens[i].getWidth()-40, 1);
				borda.setOpaque(true);
				borda.setBackground(new Color(180,180,180));
				pastasItens[i].add(borda);
				pastasItens[i].setSize(pastasItens[i].getWidth(), pastasItens[i].getHeight()+1);
				altura+= pastasItens[i].getHeight();
				
			}else{
				pastas[i].setVisible(false);
				pastasItens[i].setVisible(false);
			}
			
		}
		
		rolante.setPreferredSize(new Dimension(rolante.getWidth(), altura)); 
		
		if(altura>scroll.getHeight()){
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		}else{
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); 
		}
		
	}
	
}
