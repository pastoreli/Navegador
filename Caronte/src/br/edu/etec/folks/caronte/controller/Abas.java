package br.edu.etec.folks.caronte.controller;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import br.edu.etec.folks.caronte.controllerView.EfeitosAbas;
import br.edu.etec.folks.caronte.controllerView.Responsivo;
import br.edu.etec.folks.caronte.view.Janela;

public class Abas extends JPanel{

	GeraGuia gera = new GeraGuia();
	
	Responsivo resp = new Responsivo();
	
	Rectangle tela = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();  
	
	public JLabel nomePagina;
	public JButton fecharGuia;
	
	public boolean aberta = true;
	
	  private static final long serialVersionUID = 1L;   
	  private int x, select=0;  
	  public int xAntigo; 
	
	public Abas(){
		
		this.setLayout(null);
		this.setBounds(0,0,tela.width-30,30);
		this.setBackground(new Color(230,230,230));
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				
				for(JPanel a : gera.lAbas){
					
					if((JPanel) e.getSource() == a){
						
						if(a.getBackground().equals(new Color(220,220,220))){
							
							gera.trocaGuia();
							
						}
						
					}
					
				}
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
				int cont = 0;
				
				for(JPanel a : gera.lAbas){
					
					if((JPanel) e.getSource() == a){
						
						if(a.getBackground().equals(new Color(210,210,210))){
							
							a.getCursor().equals(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
							
							a.setBackground(new Color(220,220,220));
							
						}
						
						gera.lAbas.get(cont).fecharGuia.setVisible(true);
						
						break;
						
					}
					
					cont++;
					
				}
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				int cont = 0;
				
				for(JPanel a : gera.lAbas){
					
					if((JPanel) e.getSource() == a){
						
						if(a.getBackground().equals(new Color(220,220,220))){
							
							a.setBackground(new Color(210,210,210));
							
						}
						
						gera.lAbas.get(cont).fecharGuia.setVisible(false);
						
						break;
						
					}
				
					cont++;
					
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				for(JPanel a : gera.lAbas){
					
					if((JPanel) e.getSource() == a){
						
						if(a.getBackground().equals(new Color(220,220,220))){
							
							xAntigo = a.getX();
							
						}
						
					}
					
				}
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
				for(JPanel a : gera.lAbas){
					
					if((JPanel) e.getSource() == a){
						
						
						a.setLocation(xAntigo, 0);  
						
					}
					
				}
				
			}
					
		});  
		this.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent e) {
				
				if (e.getX() - x == 0 || e.getX() - x == 0) {  
	                
					x = e.getX();  
	                
	            }  
		
				resp.j.pAbas. setComponentZOrder(gera.lAbas.get(select),0);
						
				if(gera.lAbas.get(select).getBackground().equals(new Color(220,220,220))){
							
					gera.trocaGuia();
							
				}
						
				if(gera.lAbas.get(select).getX() + (e.getX() - x) >= 0 && gera.lAbas.get(select).getX() + (e.getX() - x)<= (Janela.pAbas.getWidth()-30)-gera.lAbas.get(select).getWidth()){
				
					gera.lAbas.get(select).setLocation(gera.lAbas.get(select).getX() + (e.getX() - x), 0);  
					
				}else if(gera.lAbas.get(select).getX() + (e.getX() - x) <= 0){
					
					gera.lAbas.get(select).setLocation(0, 0); 
					
				}else{
					
					gera.lAbas.get(select).setLocation((Janela.pAbas.getWidth()-30)-gera.lAbas.get(select).getWidth(), 0); 
					
				}
				
				if(gera.lAbas.get(select).getX() > xAntigo+((gera.lAbas.get(select).getWidth()/100)*80)){
					
					EfeitosAbas efeitos = new EfeitosAbas();
					
					if(efeitos.terminaTroca){
					
						int xProximo = xAntigo;
						
						xAntigo = gera.lAbas.get(select+1).getX();
						
						efeitos.indice = select;
						efeitos.posicaoAntiga = xAntigo;
						efeitos.posicaoNova = xProximo;
						
//						gera.lAbas.get(select+1).setLocation(xProximo, 0);
						
						gera.indice = select;
						try {
							gera.moverParaFrente(gera.lAbas, gera.lGuias, gera.lPaginas);
							
							select++;
							
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						
						efeitos.moverParaFrente();
						
					}
					
				}
				
				if(gera.lAbas.get(select).getX() < xAntigo-((gera.lAbas.get(select).getWidth()/100)*80)){
					
					EfeitosAbas efeitos = new EfeitosAbas();
					
					if(efeitos.terminaTroca){
					
						int xProximo = xAntigo;
						
						xAntigo = gera.lAbas.get(select-1).getX();
						
						efeitos.indice = select;
						efeitos.posicaoAntiga = xAntigo;
						efeitos.posicaoNova = xProximo;
						
//						gera.lAbas.get(select-1).setLocation(xProximo, 0);
						
						gera.indice = select;
						try {
							gera.moverParaTras(gera.lAbas, gera.lGuias, gera.lPaginas);
							
							select--;
							
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						
						efeitos.moverParaTras();
						
					}
					
				}
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				
				select = 0;
				
				for(JPanel a : gera.lAbas){
					
					if((JPanel) e.getSource() == a){
						
						break;
						
					}
					
					select++;
					
				}
				
				x = e.getX(); 
				
			}
			
			
			
		});
		
		nomePagina = new JLabel();
		nomePagina.setBounds(26,0,this.getWidth()-52,this.getHeight());
		nomePagina.setFont(new Font("Arial",  Font. PLAIN,  16));
		nomePagina.setHorizontalAlignment(SwingConstants.CENTER);
		nomePagina.setVerticalAlignment(SwingConstants.CENTER);
		this.add(nomePagina);
		
		fecharGuia = new JButton();
		fecharGuia.setIcon(new ImageIcon("imgGuias/fechaGuia.png"));
		fecharGuia.setContentAreaFilled(false);
		fecharGuia.setBorder(null);
		fecharGuia.setFocusPainted(false);
		fecharGuia.setVisible(false);
		fecharGuia.setBounds(0,2,26,26);
		fecharGuia.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 fecharGuia.setVisible(true);
				 fecharGuia.setIcon(new ImageIcon("imgGuias/fechaGuia2.png"));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 fecharGuia.setIcon(new ImageIcon("imgGuias/fechaGuia.png"));
				 
			}
		});
		fecharGuia.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if(gera.lGuias.size() <= 1){
				
					System.exit(0);
				
				}else{
					
					gera.fechaGuias();
					
				}
				
			}
			
		});
		
		this.add(fecharGuia);
		
	}
	
}
