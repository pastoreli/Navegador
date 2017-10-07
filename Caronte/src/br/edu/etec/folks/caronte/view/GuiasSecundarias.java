package br.edu.etec.folks.caronte.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
import br.edu.etec.folks.caronte.controllerView.EfeitosDual;
import br.edu.etec.folks.caronte.controllerView.GeraDual;
import br.edu.etec.folks.caronte.controllerView.Responsivo;

public class GuiasSecundarias extends JPanel{

	Responsivo resp = new Responsivo();
	GeraGuia gera = new GeraGuia();
	GeraDual geraD = new GeraDual();
	
	public JPanel pGuias;

	public JLabel fundoRgb;
	
	public JScrollPane scroll;
	
	public JButton btnGuias[];
	
	public int indexPagina[];
	
	int indexB = 0;
	
	public GuiasSecundarias(){
		
		this.setLayout(null);
		this.setBounds(0, 0, (int)resp.tela.getWidth(),(int)resp.tela.getHeight());
		this.setBackground(new Color(255,255,255));
		this.setOpaque(false);
		this.setVisible(false);
		this.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {}
			 @Override
			 public void mouseExited(MouseEvent e) {}
		});
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			
			
		});
		
		pGuias = new JPanel();
//		this.add(pGuias);

		LookAndFeel lfAnterior = UIManager.getLookAndFeel();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception ex) {
			ex.printStackTrace();
			}
		
		scroll = new JScrollPane(pGuias);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    scroll.setBounds(-(this.getWidth()/2), 0, (this.getWidth()/2), this.getHeight()); 
	    scroll.getViewport().setOpaque(false);
	    scroll.setOpaque(false); 
	    scroll.setBorder(null); 
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
		this.add(scroll);
		
		try {
			UIManager.setLookAndFeel(lfAnterior);
			} catch (Exception ex) {
			ex.printStackTrace();
			}
		
		pGuias.setLayout(null);
		pGuias.setBounds(0, 0,scroll.getWidth(), scroll.getHeight());
		pGuias.setBackground(new Color(230,230,230,0));
		
		fundoRgb = new JLabel();
		fundoRgb.setBounds(0, 0, scroll.getWidth(), scroll.getHeight());
		fundoRgb.setOpaque(true);
		fundoRgb.setBackground(new Color(0,0,0,240));
		scroll.add(fundoRgb);
		
	}
	
	public void miniGuias(){
		
		int tamanho = 0;
		
		btnGuias = new JButton[gera.lGuias.size()-1];
		indexPagina = new int[gera.lGuias.size()-1];
		
		int cont = 0;
		int cont2=0;
		
		for(Guias g : gera.lGuias){
			
			if(!g.aberta){
				
				indexPagina[cont] = cont2;
				
				btnGuias[cont] = new JButton(gera.lAbas.get(cont2).nomePagina.getText().substring(0, 1).toUpperCase());
				
				if(cont<1){
				
					btnGuias[cont].setBounds((scroll.getWidth()/100)*26, 50, (scroll.getWidth()/100)*60, (scroll.getWidth()/100)*40);
				
				}else{
					
					btnGuias[cont].setBounds((scroll.getWidth()/100)*26, btnGuias[cont-1].getY()+btnGuias[cont-1].getHeight()+50, (scroll.getWidth()/100)*60, (scroll.getWidth()/100)*40);
					
				}
				ImageIcon fundo = new ImageIcon("imgDual/cubos.png");
				btnGuias[cont].setIcon(new ImageIcon(fundo.getImage().getScaledInstance(btnGuias[cont].getWidth(),btnGuias[cont].getHeight(), Image.SCALE_DEFAULT)));
				btnGuias[cont].setContentAreaFilled(false);
				btnGuias[cont].setForeground(new Color(255,255,255));
				btnGuias[cont].setFont(new Font("Arial",  Font. PLAIN,  110));
				btnGuias[cont].setHorizontalAlignment(SwingConstants.CENTER);
				btnGuias[cont].setVerticalAlignment(SwingConstants.CENTER);
				btnGuias[cont].setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
				btnGuias[cont].setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
				btnGuias[cont].setBorder(null);
				btnGuias[cont].setFocusPainted(false);
				btnGuias[cont].addMouseListener(new MouseAdapter() {
					 @Override
					 public void mouseEntered(MouseEvent e) {
						 
						 for(int i=0; i < btnGuias.length; i++){
							 
							 if((JButton)e.getSource() == btnGuias[i]){
								 
								 btnGuias[i].setBackground(new Color(16,39,72));
								 scroll.repaint();
								 indexB = i;
								 
								 break;
								 
							 }
							 
						 }
						 
					 }
					 @Override
					 public void mouseExited(MouseEvent e) {
						 
						 btnGuias[indexB].setBackground(new Color(47,72,109));
						 scroll.repaint();
						 
					}
				});
				btnGuias[cont].addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						
						gera.lPaginas.get(indexPagina[indexB]).indexDual = 2;
						gera.lPaginas.get(indexPagina[indexB]).aberta = true;
						
						gera.lGuias.get(indexPagina[indexB]).indexDual = 2;
						gera.lGuias.get(indexPagina[indexB]).aberta = true;
						
						geraD.index2 = indexPagina[indexB];
						
						
						geraD.secAberta = !geraD.secAberta;
						resp.j.cabecalho.setBounds(0, resp.j.cabecalho.getY(), resp.j.getWidth(), resp.j.cabecalho.getHeight());
						resp.j.pPrincipal.setBounds(0, resp.j.pPrincipal.getY(), resp.j.getWidth(), resp.j.pPrincipal.getHeight());
						resp.j.fechar.setBounds(resp.j.cabecalho.getWidth()-48,0,44,30);
						resp.j.maximizar.setBounds(resp.j.fechar.getX()-44,0,44,30);
						resp.j.minimizar.setBounds(resp.j.maximizar.getX()-44,0,44,30);
						geraD.respDual();
						resp.j.separador.mod1.setBounds(resp.j.separador.div.getX()+10,0,resp.j.getWidth()-resp.j.separador.div.getX()-10,resp.j.separador.div.getHeight());
						resp.j.separador.mod2.setBounds(0,0,resp.j.separador.div.getX(),resp.j.separador.div.getHeight());
						resp.j.separador.mod1.setVisible(false);
						resp.j.separador.mod2.setVisible(false);
						resp.j.separador.knob.setVisible(true);
						resp.j.separador.div.repaint();
						resp.j.separador.knob.repaint();
						gera.lGuias.get(geraD.index2).setVisible(true);
						gera.lPaginas.get(geraD.index2).setVisible(true);
						resp.j.setaDual.setVisible(true);
						resp.j.secundaria.setVisible(false);
						resp.j.secundaria.pGuias.removeAll();
						
					}
					
				});
				
				pGuias.add(btnGuias[cont]);
				
				tamanho+= btnGuias[cont].getHeight()+60;
				
				if(tamanho > pGuias.getHeight()){
					
					pGuias.setSize(this.getWidth(), tamanho);
					
				}
				
				cont++;
			
			}
				
			cont2++;
				
		}
		
		pGuias.setPreferredSize(new Dimension(pGuias.getWidth(), tamanho)); 
		
		if(tamanho>this.getHeight()){
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		}else{
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); 
		}
	    
		scroll.repaint();
		
		pGuias.repaint();
		
		this.repaint();
		
	}
	
}
