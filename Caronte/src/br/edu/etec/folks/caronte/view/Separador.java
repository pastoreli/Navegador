package br.edu.etec.folks.caronte.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.edu.etec.folks.caronte.controller.GeraGuia;
import br.edu.etec.folks.caronte.controllerView.Cor;
import br.edu.etec.folks.caronte.controllerView.EfeitoItens;
import br.edu.etec.folks.caronte.controllerView.EfeitosDual;
import br.edu.etec.folks.caronte.controllerView.GeraDual;
import br.edu.etec.folks.caronte.controllerView.Responsivo;

public class Separador{

	Responsivo resp = new Responsivo();
	GeraGuia gera = new GeraGuia();
	GeraDual geraD = new GeraDual();
	
	public int indexDivisor;
	
	public static JLabel div;
	public JButton knob;
	
	public static JLabel mod1, mod2;
	
	private int x;
	
	public Separador(){
		
		div = new JLabel();
		div.setSize(10,(int)resp.tela.getHeight());
		div.setLocation(((int)resp.tela.getWidth()/2)-5, 0);
		div.setOpaque(true);
		div.setBackground(new Color(0,0,0));
		div.setVisible(false);
		
		knob = new JButton();
		knob.setBounds(((int)resp.tela.getWidth()/2)-5,(div.getHeight()/2)-25, 10, 50);
		knob.setBackground(new Color(200,200,200));
		knob.setBorder(null);
		knob.setVisible(false);
		knob.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 knob.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));   
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 knob.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));   
				 
			}
		});
		
		knob.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
			
				
				
			}
			
		});
		
		knob.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent e) {
				
				knob.setLocation(knob.getX() + e.getX(), knob.getY());
				div.setLocation(knob.getX(),div.getY());
				
				if(div.getX() <= 10 || div.getX() >= resp.j.getWidth()-10){
					div.setBackground(new Color(239,5,29));
				}else{
					div.setBackground(new Color(0,0,0));
				}
		            	
				mod1.setBounds(div.getX()+10,0,resp.j.getWidth()-div.getX()-10,div.getHeight());
				mod2.setBounds(0,0,div.getX(),div.getHeight());
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
			}

		});
		
		knob.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				mod1.setVisible(true);
				mod2.setVisible(true);
				resp.j.cabecalho.setVisible(false);
				resp.j.pPrincipal.setVisible(false);
				
				
				x = e.getX(); 
				EfeitoItens efeitoI = new EfeitoItens();
				efeitoI.escondeIten(false);
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
				if(div.getBackground().equals(new Color(239,5,29))){
					
					if(div.getX() <= 10){
						
						gera.lPaginas.get(geraD.index2).aberta = false;
						gera.lPaginas.get(geraD.index2).indexDual = 0;
						gera.lPaginas.get(geraD.index2).setVisible(false);
						gera.lGuias.get(geraD.index2).aberta = false;
						gera.lGuias.get(geraD.index2).indexDual = 0;
						gera.lGuias.get(geraD.index2).setVisible(false);
						gera.lGuias.get(geraD.index2).dual.setVisible(true);
						gera.lGuias.get(geraD.index2).menu.setVisible(true);
						
						gera.lPaginas.get(geraD.index1).indexDual = 0;
						gera.lGuias.get(geraD.index1).indexDual = 0;
						gera.lGuias.get(geraD.index1).dual.setVisible(true);
						gera.lGuias.get(geraD.index1).menu.setVisible(true);
						resp.j.pAbas.setVisible(true);
						
						resp.typeScreen();
						
						mod1.setVisible(false);
						mod2.setVisible(false);
						resp.j.cabecalho.setVisible(true);
						resp.j.pPrincipal.setVisible(true);
						resp.j.pAbas.setVisible(true);
						resp.j.setaDual.setVisible(false);
						
					}else{
						
						gera.lPaginas.get(geraD.index1).aberta = false;
						gera.lPaginas.get(geraD.index1).indexDual = 0;
						gera.lPaginas.get(geraD.index1).setVisible(false);
						gera.lGuias.get(geraD.index1).aberta = false;
						gera.lGuias.get(geraD.index1).indexDual = 0;
						gera.lGuias.get(geraD.index1).setVisible(false);
						gera.lGuias.get(geraD.index1).dual.setVisible(true);
						gera.lGuias.get(geraD.index1).menu.setVisible(true);
						gera.lAbas.get(geraD.index1).setBackground(Cor.tema2);
						gera.lAbas.get(geraD.index1).aberta = false;
						
						gera.lPaginas.get(geraD.index2).indexDual = 0;
						gera.lGuias.get(geraD.index2).indexDual = 0;
						gera.lGuias.get(geraD.index2).dual.setVisible(true);
						gera.lGuias.get(geraD.index2).menu.setVisible(true);
						gera.lAbas.get(geraD.index2).setBackground(Cor.tema);
						gera.lAbas.get(geraD.index2).aberta = true;
						
						resp.typeScreen();
						
						mod1.setVisible(false);
						mod2.setVisible(false);
						resp.j.cabecalho.setVisible(true);
						resp.j.pPrincipal.setVisible(true);
						resp.j.pAbas.setVisible(true);
						resp.j.setaDual.setVisible(false);
						
					}
					
					div.setVisible(false);
					div.setBackground(new Color(0,0,0));
					knob.setVisible(false);
					
				}else{
					
					if(div.getX() < 350){
						
						EfeitosDual efeitos = new EfeitosDual();
						efeitos.chegada = 350;
						efeitos.naoFecha();
						
					}else if(div.getX() > resp.j.getWidth()-350){
						
						EfeitosDual efeitos = new EfeitosDual();
						efeitos.chegada = resp.j.getWidth()-350;
						efeitos.naoFecha();
						
					}else{
						
						geraD.respDual();
						mod1.setVisible(false);
						mod2.setVisible(false);
						resp.j.cabecalho.setVisible(true);
						resp.j.pPrincipal.setVisible(true);
						
					}
					
				}
				
			}
				
		});  
		
		//paginas de modificação
		
		mod1 = new JLabel();
		mod1.setBounds(0,0,0,0);
		mod1.setIcon(new ImageIcon("imgDual/iconDual.png"));
		mod1.setOpaque(true);
		mod1.setBackground(new Color(47,72,109));
		mod1.setVisible(false);
		mod1.setForeground(new Color(255,255,255));
		mod1.setFont(new Font("Arial",  Font. PLAIN,  100));
		mod1.setHorizontalAlignment(SwingConstants.CENTER);
		mod1.setVerticalAlignment(SwingConstants.CENTER);
		
		mod2 = new JLabel();
		mod2.setBounds(0,0,0,0);
		
//		URL url = null;
//		
//		try {
//			url = new URL("imgDual/iconDual.png");
//			
//		} catch (MalformedURLException e) {
//			
//		}
		
		mod2.setIcon(new ImageIcon("imgDual/iconDual.png"));
		mod2.setOpaque(true);
		mod2.setBackground(new Color(47,72,109));
		mod2.setVisible(false);
		mod2.setForeground(new Color(255,255,255));
		mod2.setFont(new Font("Arial",  Font. PLAIN,  100));
		mod2.setHorizontalAlignment(SwingConstants.CENTER);
		mod2.setVerticalAlignment(SwingConstants.CENTER);
		
	}
	
}
