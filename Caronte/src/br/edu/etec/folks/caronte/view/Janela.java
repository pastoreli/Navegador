package br.edu.etec.folks.caronte.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.edu.etec.folks.caronte.controller.GeraGuia;
import br.edu.etec.folks.caronte.controllerView.Cor;
import br.edu.etec.folks.caronte.controllerView.EfeitosDual;
import br.edu.etec.folks.caronte.controllerView.GeraDual;
import br.edu.etec.folks.caronte.controllerView.Responsivo;

public class Janela extends JFrame implements ActionListener, MouseMotionListener, MouseListener{

	Responsivo resp = new Responsivo();
	
	GeraGuia gera = new GeraGuia();
	
	public  Separador separador = new Separador();
	public  GuiasSecundarias secundaria = new GuiasSecundarias();
	public GeraDual geraD = new GeraDual();
	
	Rectangle tela = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();  
	
    //elementos graficos
    
	public static  JPanel pPrincipal, pAbas, cabecalho, pItens;
	public static JButton fechar, minimizar, maximizar;
	public static JLabel bordas, sombra, sombraG;
	
	//seta dual
	public JButton setaDual;
	
	public static JButton novaGuia;
    
	public Janela(){
		
		this.setLayout(null);
		this.setSize(tela.getSize());
		this.addMouseListener(this);  
		this.addMouseMotionListener(this);
		this.setMinimumSize(new Dimension(500, 400));
	    
		this.add(separador.knob);
		this.add(separador.div);
		this.add(separador.mod1);
		this.add(separador.mod2);
		this.add(secundaria);
		
		cabecalho = new JPanel();
		cabecalho.setLayout(null);
		cabecalho.setBounds(0,0,this.getWidth(),57);
		cabecalho.setBackground(Cor.tema);
		cabecalho.addMouseListener(this);  
		cabecalho.addMouseMotionListener(this);
		cabecalho.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		this.add(cabecalho);
		
//		seta dual
		setaDual = new JButton();
		setaDual.setBounds(240,5, 40, 30);
		setaDual.setIcon(new ImageIcon("imgDual/setaDual.png"));
		setaDual.setContentAreaFilled(false);
		setaDual.setBorder(null);
		setaDual.setVisible(false);
		setaDual.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
			
				geraD.trocaGuia();
				
				gera.lPaginas.get(geraD.index2).indexDual = 0;
				gera.lPaginas.get(geraD.index2).aberta = false;
				
				gera.lGuias.get(geraD.index2).indexDual = 0;
				gera.lGuias.get(geraD.index2).aberta = false;
				
				secundaria.scroll.setBounds(-separador.div.getX(), 0, separador.div.getX(), secundaria.getHeight());
				secundaria.pGuias.setBounds(0, 0,secundaria.scroll.getWidth(), secundaria.scroll.getHeight());
				secundaria.fundoRgb.setSize(secundaria.scroll.size());
				secundaria.miniGuias();
				secundaria.setVisible(true);
				
				geraD.secAberta = !geraD.secAberta;
				
				EfeitosDual efeitos = new EfeitosDual();
				efeitos.chamachamaGuias2();
				
			}
			
		});
		cabecalho.add(setaDual);
		
		fechar = (new JButton());
		fechar.setIcon(new ImageIcon("imgJanela/close.png"));
		fechar.addActionListener(this);
		fechar.setBounds(cabecalho.getWidth()-48,0,44,30);
		fechar.setBackground(Cor.tema);
		fechar.setFocusPainted(false);
		fechar.setBorder(null);
		fechar.setBorderPainted(false); 
		fechar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		fechar.setHorizontalAlignment(SwingConstants.CENTER);
		fechar.setVerticalAlignment(SwingConstants.CENTER);
		fechar.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 fechar.setIcon(new ImageIcon("imgJanela/close2.png"));
				 fechar.setBackground(new Color(232,17,35));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 fechar.setIcon(new ImageIcon("imgJanela/close.png"));
				 fechar.setBackground(Cor.tema);
				 
			}
		});
		cabecalho.add(fechar);
		
		maximizar = (new JButton());
		maximizar.setIcon(new ImageIcon("imgJanela/restaurar.png"));
		maximizar.addActionListener(this);
		maximizar.setBounds(fechar.getX()-44,0,44,30);
		maximizar.setBackground(Cor.tema);
		maximizar.setFocusPainted(false);
		maximizar.setBorder(null);
		maximizar.setBorderPainted(false);
		maximizar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		maximizar.setHorizontalAlignment(SwingConstants.CENTER);
		maximizar.setVerticalAlignment(SwingConstants.CENTER);
		maximizar.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 maximizar.setBackground(new Color(190,190,190));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 maximizar.setBackground(Cor.tema);
				 
			}
		});
		cabecalho.add(maximizar);
		
		minimizar = (new JButton());
		minimizar.setIcon(new ImageIcon("imgJanela/minimizar.png"));
		minimizar.addActionListener(this);
		minimizar.setBounds(maximizar.getX()-44,0,44,30);
		minimizar.setBackground(Cor.tema);
		minimizar.setFocusPainted(false);
		minimizar.setBorder(null);
		minimizar.setBorderPainted(false);
		minimizar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		minimizar.setHorizontalAlignment(SwingConstants.CENTER);
		minimizar.setVerticalAlignment(SwingConstants.CENTER);
		minimizar.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 minimizar.setBackground(new Color(190,190,190));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 minimizar.setBackground(Cor.tema);
				 
			}
		});
		cabecalho.add(minimizar);
	
		pItens = new JPanel();
		pItens.setLayout(null);
		pItens.setBounds(0,5, cabecalho.getWidth()-136, 51);
		pItens.setBackground(Cor.tema);
		cabecalho.add(pItens);
		
		sombra = new JLabel();
		sombra.setBounds(0, cabecalho.getHeight()-1, cabecalho.getWidth(), 1);
		sombra.setOpaque(true);
		sombra.setBackground(new Color(200,200,200));
		cabecalho.add(sombra);
		
		pAbas = new JPanel();
		pAbas.setLayout(null);
		pAbas.setBounds(0,57, this.getWidth(), 31);
		pAbas.setBackground(Cor.tema2);
		this.add(pAbas);
		
		novaGuia = new JButton();
		novaGuia.setBounds(pItens.getWidth()-30,0, 30, 30);
		novaGuia.setIcon(new ImageIcon("imgJanela/nGuia.png"));
		novaGuia.setBorder(null);
		novaGuia.setFocusPainted(false);
		novaGuia.setBackground(Cor.tema2);
		novaGuia.setHorizontalAlignment(SwingConstants.CENTER);
		novaGuia.setVerticalAlignment(SwingConstants.CENTER);
		novaGuia.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 novaGuia.setBackground(Cor.tema);
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 novaGuia.setBackground(Cor.tema2);
				 
			}
		});
		novaGuia.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
			
				GeraGuia gera = new GeraGuia();
				
				gera.criarPaginas(false);
				
			}
			
		});
		
		pAbas.add(novaGuia);
		
		sombraG = new JLabel();
		sombraG.setBounds(0, pAbas.getHeight()-1, pAbas.getWidth(), 1);
		sombraG.setOpaque(true);
		sombraG.setBackground(new Color(210,210,210));
		pAbas.add(sombraG);
		
		pPrincipal = new JPanel();
		pPrincipal.setLayout(null);
		pPrincipal.setBounds(0,88,this.getWidth(),this.getHeight()-88);
//		pPrincipal.setVisible(false);
		pPrincipal.setBackground(Cor.tema);
		pPrincipal.addMouseListener(this);  
		pPrincipal.addMouseMotionListener(this);
		this.add(pPrincipal);
		
		bordas = new JLabel();
	    bordas.setSize(this.getSize());
	    bordas.setLocation(0,0);
	    bordas.setBackground(new Color(150,150,150));
	    bordas.setOpaque(true);
	    bordas.addMouseListener(this);  
	    bordas.addMouseMotionListener(this);
	    this.add(bordas);
	    
	    this.setUndecorated(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	    this.setBackground(new Color(255,255,255,0));

		
	}

	//pega seta
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		Object sourceObject=e.getSource();        
        if(sourceObject instanceof JPanel)        
        {        
            if (e.getClickCount() == 2)         
            {       
                if(this.getCursor().equals(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)))        
                    resp.headerDoubleClickResize();        
            }        
        }        
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		resp.start_drag = resp.getScreenLocation(e, this);        
        resp.start_loc = this.getLocation(); 
       
        for(Guias g : gera.lGuias){
        
	        g.txtPesquisa.setFocusable(false);
	        g.txtPesquisa.setFocusable(true);
	        
        }
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == fechar){
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			System.exit(0);
			
		}
		
		if(e.getSource() == minimizar){
			
			this.setState(this.ICONIFIED);
			
		}
		
		if(e.getSource() == maximizar){
			
			resp.headerDoubleClickResize();
			
		}
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		moveOrFullResizeFrame(e);  
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		resp.cursorLocation = e.getPoint();
		resp.mudarCursor();
		
	}
	
	private void moveOrFullResizeFrame(MouseEvent e){        
        
		resp.sourceObject=e.getSource();    
		resp.current = resp.getScreenLocation(e, this);     
		
		resp.newWidth = e.getX();        
        resp.newHeight = e.getY();
        
        resp.sizeFrame();
		
    }        

}
