package br.edu.etec.folks.caronte.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import br.edu.etec.folks.caronte.controller.GeraGuia;
import br.edu.etec.folks.caronte.controllerView.EfeitoItens;
import br.edu.etec.folks.caronte.controllerView.Responsivo;
import br.edu.etec.folks.caronte.dao.CrudFavoritos;
import br.edu.etec.folks.caronte.model.PaginasFavoritos;

public class FavoritoForm {

	Responsivo resp = new Responsivo();
	GeraGuia gera = new GeraGuia();
	
	public JPanel pForm;
	
	public JLabel titulo, desc, caixa, descPasta;
	
	public JTextField txtNome;
	
	public String url;
	
	public JButton pessoais, trabalho, escola, outros;
	
	//indice da pasta
	public int indiceP = 4;
	
	public JButton salvar, cancelar;
	
	
	public FavoritoForm(){
		
		pForm = new JPanel();
		pForm.setLayout(null);
		pForm.setBounds(0, 0, 340, resp.itens.camada.getHeight());
		pForm.setBackground(new Color(230, 230, 230));
		pForm.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			
			
		});
		resp.itens.maeItens.add(pForm);
		
		titulo = new JLabel("Novo favorito");
		titulo.setBounds(0, 30, pForm.getWidth(), 30);
		titulo.setVerticalAlignment(SwingConstants.CENTER);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(new Color(0,0,0));
		titulo.setFont(new Font("Arial",  Font.PLAIN,  22));
		pForm.add(titulo);
		
		desc = new JLabel("Nome");
		desc.setBounds(20, 80, pForm.getWidth()-40, 20);
		desc.setVerticalAlignment(SwingConstants.CENTER);
		desc.setHorizontalAlignment(SwingConstants.LEFT);
		desc.setForeground(new Color(0,0,0));
		desc.setFont(new Font("Arial",  Font.PLAIN,  16));
		pForm.add(desc);
		
		txtNome = new JTextField();
		txtNome.setBackground(new Color(195, 195, 195));
		txtNome.setForeground(new Color(50,50,50));
		txtNome.setBounds(20,110,pForm.getWidth()-40,30);
		txtNome.setBorder(new LineBorder(new Color(195,195,195), 2, false));
		txtNome.setFont(new Font("Arial",  Font.PLAIN,  17));
		txtNome.setHorizontalAlignment(SwingConstants.CENTER);
		txtNome.addFocusListener(new FocusListener() {  
			@Override
			public void focusGained(FocusEvent e) {		
				txtNome.selectAll();
				txtNome.setBackground(new Color(255, 255, 255));
				txtNome.setBorder(new LineBorder(new Color(175,175,175), 2, false));
			}

			@Override
			public void focusLost(FocusEvent e) {
				txtNome.setBackground(new Color(195, 195, 195));
				txtNome.setBorder(new LineBorder(new Color(195,195,195), 2, false));
			}  
  
		});
		pForm.add(txtNome);
		
		descPasta = new JLabel("Salvar em");
		descPasta.setBounds(20, 180, pForm.getWidth()-40, 20);
		descPasta.setVerticalAlignment(SwingConstants.CENTER);
		descPasta.setHorizontalAlignment(SwingConstants.LEFT);
		descPasta.setForeground(new Color(0,0,0));
		descPasta.setFont(new Font("Arial",  Font.PLAIN,  16));
		pForm.add(descPasta);
		
		pessoais = new JButton();
		pessoais.setBounds(25, 210, 60, 60);
		pessoais.setContentAreaFilled(false);
		pessoais.setIcon(new ImageIcon("imgLateral/casa.png"));
		pessoais.setBorder(null);
		pessoais.setVerticalAlignment(SwingConstants.CENTER);
		pessoais.setHorizontalAlignment(SwingConstants.CENTER);
		pessoais.setFocusPainted(false);
		pessoais.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 pessoais.setIcon(new ImageIcon("imgLateral/casaC.png"));
				 
				 trabalho.setIcon(new ImageIcon("imgLateral/trabalho.png"));
				 escola.setIcon(new ImageIcon("imgLateral/escola.png"));
				 outros.setIcon(new ImageIcon("imgLateral/outros.png"));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 validaCor();
			}
		});
		pessoais.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				indiceP = 1;
				
			}
				
		});
		pForm.add(pessoais);
		
		trabalho = new JButton();
		trabalho.setBounds(100, 210,60, 60);
		trabalho.setContentAreaFilled(false);
		trabalho.setIcon(new ImageIcon("imgLateral/trabalho.png"));
		trabalho.setBorder(null);
		trabalho.setVerticalAlignment(SwingConstants.CENTER);
		trabalho.setHorizontalAlignment(SwingConstants.CENTER);
		trabalho.setFocusPainted(false);
		trabalho.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 trabalho.setIcon(new ImageIcon("imgLateral/trabalhoC.png"));
				 
				 pessoais.setIcon(new ImageIcon("imgLateral/casa.png"));
				 escola.setIcon(new ImageIcon("imgLateral/escola.png"));
				 outros.setIcon(new ImageIcon("imgLateral/outros.png"));
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 validaCor();
			}
		});
		trabalho.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				indiceP = 2;
				
			}
				
		});
		pForm.add(trabalho);
		
		escola = new JButton();
		escola.setBounds(185, 210,60, 60);
		escola.setContentAreaFilled(false);
		escola.setIcon(new ImageIcon("imgLateral/escola.png"));
		escola.setBorder(null);
		escola.setVerticalAlignment(SwingConstants.CENTER);
		escola.setHorizontalAlignment(SwingConstants.CENTER);
		escola.setFocusPainted(false);
		escola.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 escola.setIcon(new ImageIcon("imgLateral/escolaC.png"));
				 
				 pessoais.setIcon(new ImageIcon("imgLateral/casa.png"));
				 trabalho.setIcon(new ImageIcon("imgLateral/trabalho.png"));
				 outros.setIcon(new ImageIcon("imgLateral/outros.png"));
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 validaCor();
			}
		});
		escola.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				indiceP = 3;
				
			}
				
		});
		pForm.add(escola);
		
		outros = new JButton();
		outros.setBounds(260, 210,60, 60);
		outros.setContentAreaFilled(false);
		outros.setIcon(new ImageIcon("imgLateral/outrosC.png"));
		outros.setBorder(null);
		outros.setVerticalAlignment(SwingConstants.CENTER);
		outros.setHorizontalAlignment(SwingConstants.CENTER);
		outros.setFocusPainted(false);
		outros.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 outros.setIcon(new ImageIcon("imgLateral/outrosC.png"));
				 
				 pessoais.setIcon(new ImageIcon("imgLateral/casa.png"));
				 trabalho.setIcon(new ImageIcon("imgLateral/trabalho.png"));
				 escola.setIcon(new ImageIcon("imgLateral/escola.png"));
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 validaCor();
			}
		});
		outros.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				indiceP = 4;
				
			}
				
		});
		pForm.add(outros);
		
		salvar = new JButton("Salvar");
		salvar.setBounds(180, 310, 140, 30);
		salvar.setBackground(new Color(195, 195, 195));
		salvar.setBorder(null);
		salvar.setForeground(new Color(52, 52, 52));
		salvar.setFont(new Font("Arial",  Font.PLAIN,  17));
		salvar.setVerticalAlignment(SwingConstants.CENTER);
		salvar.setHorizontalAlignment(SwingConstants.CENTER);
		salvar.setHorizontalTextPosition(SwingConstants.CENTER);
		salvar.setVerticalTextPosition(SwingConstants.CENTER);
		salvar.setFocusPainted(false);
		salvar.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 salvar.setBackground(new Color(175, 175, 175));
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 salvar.setBackground(new Color(195, 195, 195));
			}
		});
		salvar.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				if(salvar.getText().equals("Salvar")){
				
					PaginasFavoritos pagfav = new PaginasFavoritos();
					pagfav.setNomeFav(txtNome.getText());
					pagfav.setUrlFav(url);
					pagfav.setPasta(indiceP);
					
					CrudFavoritos.salvar(pagfav);
				
				}else CrudFavoritos.editar(txtNome.getText(), url, indiceP);
				
				EfeitoItens efeitoI = new EfeitoItens();
				efeitoI.escondeIten(false);
				
			}
				
		});
		pForm.add(salvar);
		
		cancelar = new JButton("Cancelar");
		cancelar.setBounds(20, 310, 140, 30);
		cancelar.setBackground(new Color(195, 195, 195));
		cancelar.setBorder(null);
		cancelar.setForeground(new Color(52, 52, 52));
		cancelar.setFont(new Font("Arial",  Font.PLAIN,  17));
		cancelar.setVerticalAlignment(SwingConstants.CENTER);
		cancelar.setHorizontalAlignment(SwingConstants.CENTER);
		cancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		cancelar.setVerticalTextPosition(SwingConstants.CENTER);
		cancelar.setFocusPainted(false);
		cancelar.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 cancelar.setBackground(new Color(175, 175, 175));
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 cancelar.setBackground(new Color(195, 195, 195));
			}
		});
		cancelar.addActionListener(new ActionListener(){

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
				efeitoI.escondeIten(false);
				
			}
				
		});
		pForm.add(cancelar);
		
	}
	
	public void validaCor(){
		
		if(indiceP==1)pessoais.setIcon(new ImageIcon("imgLateral/casaC.png"));
		else pessoais.setIcon(new ImageIcon("imgLateral/casa.png"));
			
		if(indiceP==2)trabalho.setIcon(new ImageIcon("imgLateral/trabalhoC.png"));
		else trabalho.setIcon(new ImageIcon("imgLateral/trabalho.png"));
					
		if(indiceP==3)escola.setIcon(new ImageIcon("imgLateral/escolaC.png"));
		else escola.setIcon(new ImageIcon("imgLateral/escola.png"));
							
		if(indiceP==4)outros.setIcon(new ImageIcon("imgLateral/outrosC.png"));
		else outros.setIcon(new ImageIcon("imgLateral/outros.png"));
		
	}
	
}
