package br.edu.etec.folks.caronte.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.edu.etec.folks.caronte.controller.GeraGuia;
import br.edu.etec.folks.caronte.controllerView.Cor;
import br.edu.etec.folks.caronte.controllerView.Responsivo;

public class Ferramentas {

	Responsivo resp = new Responsivo();
	
	public JPanel pFerramentas, cores;
	public JLabel anonimo;
	public JLabel luz, escuro, marinho, ouro;
	
	public Ferramentas(){
		
		pFerramentas = new JPanel();
		pFerramentas.setLayout(null);
		pFerramentas.setBounds(0, 0, 340, resp.itens.camada.getHeight());
		pFerramentas.setBackground(new Color(230, 230, 230));
		pFerramentas.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			
			
		});
		resp.itens.maeItens.add(pFerramentas);
		
		anonimo = new JLabel("<html><p style='padding:30px'>Nova guia anônima</p></html>");
		anonimo.setBounds(0, 20, pFerramentas.getWidth(), 40);
		anonimo.setFont(new Font("Arial",  Font.PLAIN,  16));
		anonimo.setVerticalAlignment(SwingConstants.CENTER);
		anonimo.setHorizontalAlignment(SwingConstants.LEFT);
		anonimo.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				GeraGuia gera = new GeraGuia();
				
				gera.criarPaginas(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				anonimo.setOpaque(true);
				anonimo.setBackground(new Color(210, 210, 210));
			}
			public void mouseExited(MouseEvent arg0) {
				anonimo.setOpaque(false);
				anonimo.setBackground(new Color(230, 230, 230));
			}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			
			
		});
		pFerramentas.add(anonimo);
		
		cores= new JPanel();
		cores.setLayout(null);
		cores.setBounds(0, 60, pFerramentas.getWidth(), 60);
		cores.setOpaque(false);
		pFerramentas.add(cores);
		
		luz = new JLabel();
		luz.setBounds(36, 10, 40, 40);
		luz.setIcon(new ImageIcon("imgLateral/luz.png"));
		luz.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Cor.escolhaTema(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			
			
		});
		cores.add(luz);
		
		ouro = new JLabel();
		ouro.setBounds(112, 10, 40, 40);
		ouro.setIcon(new ImageIcon("imgLateral/ouro.png"));
		ouro.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Cor.escolhaTema(1);
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			
			
		});
		cores.add(ouro);
		
		marinho = new JLabel();
		marinho.setBounds(188, 10, 40, 40);
		marinho.setIcon(new ImageIcon("imgLateral/marinho.png"));
		marinho.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Cor.escolhaTema(2);
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			
			
		});
		cores.add(marinho);
		
		escuro = new JLabel();
		escuro.setBounds(264, 10, 40, 40);
		escuro.setIcon(new ImageIcon("imgLateral/escuro.png"));
		escuro.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Cor.escolhaTema(3);
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			
			
		});
		cores.add(escuro);
		
	}
	
}
