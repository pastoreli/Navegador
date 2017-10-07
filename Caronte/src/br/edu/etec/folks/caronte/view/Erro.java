package br.edu.etec.folks.caronte.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.edu.etec.folks.caronte.controllerView.Responsivo;

public class Erro extends JPanel{

	Responsivo resp = new Responsivo();
	
	public JLabel imgErro, erro, descE;
	
	public Erro(){
		
		this.setLayout(null);
		this.setBackground(new Color(255,255,255));
		this.setBounds(0,0, resp.j.pPrincipal.getWidth(), resp.j.pPrincipal.getHeight());
		this.setVisible(false);
		
		imgErro = new JLabel();
		imgErro.setIcon(new ImageIcon("imgJanela/heart.png"));
		imgErro.setBounds((this.getWidth()/100)*10,(this.getHeight()/2)-150,200,200);
		this.add(imgErro);
		
		erro = new JLabel("<html>Não é possível acessar.</html>");
		erro.setBounds(imgErro.getX()+200+((this.getWidth()/100)*10),(this.getHeight()/2)-200,((this.getWidth()/100)*50),200);
		erro.setForeground(new Color(150,150,150));
		erro.setFont(new Font("Arial",  Font. PLAIN,  24));
		erro.setVerticalAlignment(SwingConstants.CENTER);
		this.add(erro);
		
		descE = new JLabel("<html><p>Verifique sua conexão com a internet.</p> <br> <p>Verifique se o endereço da página está correto.</p> <html>");
		descE.setBounds(imgErro.getX()+200+((this.getWidth()/100)*10),(this.getHeight()/2)-100,((this.getWidth()/100)*50),200);
		descE.setForeground(new Color(150,150,150));
		descE.setFont(new Font("Arial",  Font. PLAIN,  18));
		descE.setVerticalAlignment(SwingConstants.CENTER);
		this.add(descE);
		
	}
}
