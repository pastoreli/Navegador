package br.edu.etec.folks.caronte.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LookAndFeel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import br.edu.etec.folks.caronte.controllerView.EfeitoItens;
import br.edu.etec.folks.caronte.controllerView.Responsivo;
import br.edu.etec.folks.caronte.dao.CrudFavoritos;
import br.edu.etec.folks.caronte.dao.CrudHistorico;

public class Historico{
	
	Responsivo resp = new Responsivo();
	
	public JPanel pHistorico;
	public JLabel lblTitulo;
	public JLabel borda;
	
	public JScrollPane scroll;
	public JPanel pLista;
	public JPanel pColuna[];
	public JLabel nPagina[], endPagina[], horaPagina[];
	public JButton apagaItem[];
	public JLabel iconNada, nada;
	
	public JLabel desApagar;
	
	int indice;
	
	public Historico(){
		
		pHistorico = new JPanel();
		pHistorico.setLayout(null);
		pHistorico.setBounds(resp.itens.maeItens.getWidth(), 50, 340, resp.itens.camada.getHeight()-50);
		pHistorico.setBackground(new Color(230, 230, 230));
		pHistorico.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			
			
		});
		resp.itens.maeItens.add(pHistorico);
		
		lblTitulo = new JLabel("Histórico");
		lblTitulo.setBounds(40, 25, 100, 30);
		lblTitulo.setFont(new Font("Arial",  Font.PLAIN,  22));
		lblTitulo.setVerticalAlignment(SwingConstants.CENTER);
		pHistorico.add(lblTitulo);
		
		borda = new JLabel();
		borda.setBounds(0, 60, pHistorico.getWidth()-40, 1);
		borda.setOpaque(true);
		borda.setBackground(new Color(180,180,180));
		pHistorico.add(borda);
		
		pLista = new JPanel();
		
		LookAndFeel lfAnterior = UIManager.getLookAndFeel();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception ex) {
			ex.printStackTrace();
			}
		
		scroll = new JScrollPane(pLista);
		scroll.setBounds(0, 70, 340, pHistorico.getHeight()-110);
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
		pHistorico.add(scroll);
		
		try {
			UIManager.setLookAndFeel(lfAnterior);
			} catch (Exception ex) {
			ex.printStackTrace();
			}
		
		pLista.setLayout(null);
		pLista.setBounds(0, 0, scroll.getWidth(), scroll.getHeight());
		pLista.setBackground(new Color(230, 230, 230));
		
		desApagar = new JLabel("Apagar histórico");
		desApagar.setBounds(20, pHistorico.getHeight()-40, 200, 40);
		desApagar.setVerticalAlignment(SwingConstants.CENTER);
		desApagar.setForeground(new Color(47,72,109));
		desApagar.setFont(new Font("Arial",  Font.PLAIN,  14));
		desApagar.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				CrudHistorico crud = new CrudHistorico();
				
				crud.removerTudo();
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			
			
		});
		pHistorico.add(desApagar);
		
	}
	
	public void addItens(){
		
		CrudHistorico crud = new CrudHistorico();
		
		int altura = 0;
		
		if(crud.lHistorico.size() > 0){
		
			pColuna = new JPanel[crud.lHistorico.size()];
			nPagina = new JLabel[crud.lHistorico.size()];
			endPagina = new JLabel[crud.lHistorico.size()];
			horaPagina = new JLabel[crud.lHistorico.size()];
			apagaItem = new JButton[crud.lHistorico.size()];
			
			for(int i=pColuna.length-1; i>=0; i--){
				
				altura+= 50;
				
				pColuna[i] = new JPanel();
				pColuna[i].setLayout(null);
				
				if(i == pColuna.length-1)pColuna[i].setBounds(0, 0, pLista.getWidth(), 50);
				else pColuna[i].setBounds(0, pColuna[i+1].getY()+pColuna[i+1].getHeight(), pLista.getWidth(), 50);
				
				pColuna[i].setBackground(new Color(230, 230, 230));
				pColuna[i].addMouseListener(new MouseListener(){

					@Override
					public void mouseClicked(MouseEvent arg0) {
						CrudHistorico.BuscarHistorico(endPagina[indice].getText());
						EfeitoItens efeitoI = new EfeitoItens();
						efeitoI.escondeIten(false);
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						
						for(int i=0; i<pColuna.length; i++){
							 if((JPanel)e.getSource() == pColuna[i])indice=i;
						 }
						 ((JPanel) e.getSource()).setBackground(new Color(210,210,210));
						 apagaItem[indice].setVisible(true);
						 horaPagina[indice].setVisible(false);
						
					}
					public void mouseExited(MouseEvent e) {
						 ((JPanel) e.getSource()).setBackground(new Color(230,230,230));
						 apagaItem[indice].setVisible(false);
						 horaPagina[indice].setVisible(true);
					}
					public void mousePressed(MouseEvent arg0) {}
					public void mouseReleased(MouseEvent arg0) {}
					
					
				});
				pLista.add(pColuna[i]);
				
				nPagina[i] = new JLabel(crud.lHistorico.get(i).getNomePagina());
				nPagina[i].setBounds(40, 5, 200, 20);
				nPagina[i].setFont(new Font("Arial",  Font.PLAIN,  14));
				nPagina[i].setVerticalAlignment(SwingConstants.CENTER);
				pColuna[i].add(nPagina[i]);
				
				endPagina[i] = new JLabel(crud.lHistorico.get(i).getEnderecoPagina());
				endPagina[i].setBounds(40, 25, 200, 16);
				endPagina[i].setForeground(new Color(180,180,180));
				endPagina[i].setFont(new Font("Arial",  Font.PLAIN,  12));
				endPagina[i].setVerticalAlignment(SwingConstants.CENTER);
				pColuna[i].add(endPagina[i]);
				
				horaPagina[i] = new JLabel("<html><p>"+crud.lHistorico.get(i).getHora()+"</p></br><p>"+crud.lHistorico.get(i).getData()+"<p1></html>");
				horaPagina[i].setBounds(pColuna[i].getWidth()-70, 10, 60, 40);
				horaPagina[i].setForeground(new Color(180,180,180));
				horaPagina[i].setFont(new Font("Arial",  Font.PLAIN,  13));
				horaPagina[i].setVerticalAlignment(SwingConstants.CENTER);
				pColuna[i].add(horaPagina[i]);
				
				apagaItem[i] = new JButton();
				apagaItem[i].setBounds(pColuna[i].getWidth()-50, 10, 30, 30);
				apagaItem[i].setIcon(new ImageIcon("imgJanela/closeRed.png"));
				apagaItem[i].setVerticalAlignment(SwingConstants.CENTER);
				apagaItem[i].setHorizontalAlignment(SwingConstants.CENTER);
				apagaItem[i].setContentAreaFilled(false);
				apagaItem[i].setBorder(null);
				apagaItem[i].setVisible(false);
				apagaItem[i].addMouseListener(new MouseAdapter() {
					 @Override
					 public void mouseEntered(MouseEvent e) {
						
						((JButton)e.getSource()).setVisible(true);
						
						 pColuna[indice].setBackground(new Color(210,210,210));
						 apagaItem[indice].setVisible(true);
						 horaPagina[indice].setVisible(false);
								 
					 }
					 @Override
					 public void mouseExited(MouseEvent e) {}
				});
				apagaItem[i].addActionListener(new ActionListener(){
	
					public void actionPerformed(ActionEvent e) {
						
						CrudHistorico crud = new CrudHistorico();
						
						crud.index = indice;
						crud.Remover();
						
					}
					
							
				});
				pColuna[i].add(apagaItem[i]);
				
			}
			
			pLista.setPreferredSize(new Dimension(pLista.getWidth(), altura)); 
			
			if(altura>scroll.getHeight()){
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
			}else{
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); 
			}
			
		}else{
			
			iconNada = new JLabel();
			iconNada.setBounds((pHistorico.getWidth()/2)-75, ((pHistorico.getHeight()/2)-75)-160, 150, 150);
			iconNada.setVerticalAlignment(SwingConstants.CENTER);
			iconNada.setHorizontalAlignment(SwingConstants.CENTER);
			iconNada.setIcon(new ImageIcon("imgJanela/correto.png"));
			pLista.add(iconNada);
			
			nada = new JLabel("Limpo");
			nada.setBounds(0, iconNada.getY()+iconNada.getHeight()+10, pHistorico.getWidth(), 40);
			nada.setVerticalAlignment(SwingConstants.CENTER);
			nada.setHorizontalAlignment(SwingConstants.CENTER);
			nada.setForeground(new Color(190,190,190));
			nada.setFont(new Font("Arial",  Font.PLAIN,  20));
			pLista.add(nada);
			
		}
		
	}

}
