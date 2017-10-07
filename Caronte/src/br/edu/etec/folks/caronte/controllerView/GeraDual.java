package br.edu.etec.folks.caronte.controllerView;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import br.edu.etec.folks.caronte.controller.GeraGuia;
import br.edu.etec.folks.caronte.view.GuiasSecundarias;
import br.edu.etec.folks.caronte.view.Paginas;

public class GeraDual {

	Responsivo resp = new Responsivo();
	GeraGuia gera = new GeraGuia();
	
	public static int index1, index2;
	
	public static boolean secAberta = false;
	
	public void novaDual(){
		
		if(gera.lPaginas.size() <= 2)resp.j.separador.knob.setVisible(true);
		
		resp.j.separador.div.setSize(10,resp.j.getHeight());
		resp.j.separador.div.setLocation((resp.j.getWidth()/2)-5, 0);
		resp.j.separador.knob.setBounds((resp.j.getWidth()/2)-5,(resp.j.separador.div.getHeight()/2)-25, 10, 50);
		
		index1 = 0;
		for(Paginas p : gera.lPaginas){
			if(p.aberta &&  p.indexDual == 1)break;
			index1++;
		}
		
		if(gera.lPaginas.size() > 2){
			resp.j.secundaria.setBounds(0, 0, (int)resp.tela.getWidth(),(int)resp.tela.getHeight());
			resp.j.secundaria.scroll.setBounds(-(resp.j.secundaria.getWidth()/2), 0, (resp.j.secundaria.getWidth()/2), resp.j.secundaria.getHeight()); 
			resp.j.secundaria.pGuias.setBounds(0, 0,resp.j.secundaria.scroll.getWidth(), resp.j.secundaria.scroll.getHeight());
			resp.j.secundaria.fundoRgb.setSize(resp.j.secundaria.scroll.getSize());
			resp.j.secundaria.setVisible(true);
			resp.j.secundaria.miniGuias();
			secAberta = true;
			EfeitosDual efeitos = new EfeitosDual();
			efeitos.chamaGuias();
			
			resp.j.separador.div.setVisible(true);
			
		}else{
			
			resp.j.separador.div.setVisible(true);
			
			int valor;
			
			if(index1 > 0) valor = 0;
			else valor = 1;
			
			gera.lPaginas.get(valor).indexDual = 2;
			gera.lPaginas.get(valor).aberta = true;
			gera.lGuias.get(valor).indexDual = 2;
			gera.lGuias.get(valor).aberta = true;
			index2 = valor;
			
			EfeitosDual efeitos = new EfeitosDual();
			efeitos.duasPaginas();
		
		}
			
	}
	
	public void respDual(){
		
		gera.lPaginas.get(index1).setBounds(resp.j.separador.div.getX()+10,0,resp.j.pPrincipal.getWidth()-resp.j.separador.div.getX()-10,resp.j.pPrincipal.getHeight());
		gera.lPaginas.get(index1).paginasP.setBounds(0,0,gera.lPaginas.get(index1).getWidth(),gera.lPaginas.get(index1).getHeight());
		gera.lPaginas.get(index1).paginasP.setBounds(0,0,gera.lPaginas.get(index1).getWidth(),gera.lPaginas.get(index1).getHeight());
		
		gera.lPaginas.get(index1).erro.setBounds(0,0, gera.lPaginas.get(index1).getWidth(), gera.lPaginas.get(index1).getHeight());
		gera.lPaginas.get(index1).erro.imgErro.setBounds((gera.lPaginas.get(index1).erro.getWidth()/100)*10,(gera.lPaginas.get(index1).erro.getHeight()/2)-150,200,200);
		gera.lPaginas.get(index1).erro.erro.setBounds(gera.lPaginas.get(index1).erro.imgErro.getX()+200+((gera.lPaginas.get(index1).erro.getWidth()/100)*10),(gera.lPaginas.get(index1).erro.getHeight()/2)-200,((gera.lPaginas.get(index1).erro.getWidth()/100)*50),200);
		gera.lPaginas.get(index1).erro.descE.setBounds(gera.lPaginas.get(index1).erro.imgErro.getX()+200+((gera.lPaginas.get(index1).erro.getWidth()/100)*10),(gera.lPaginas.get(index1).erro.getHeight()/2)-100,((gera.lPaginas.get(index1).erro.getWidth()/100)*50),200);
		
		
		gera.lGuias.get(index1).setBounds(resp.j.separador.div.getX()+12, 0,resp.j.pPrincipal.getWidth()-resp.j.separador.div.getX()-10, 49);
		gera.lGuias.get(index1).elementosBar.setSize(gera.lGuias.get(index1).getSize());
		gera.lGuias.get(index1).voltar.setBounds(0,7,34,34);
		gera.lGuias.get(index1).avancar.setBounds(gera.lGuias.get(index1).voltar.getLocation().x+gera.lGuias.get(index1).voltar.getWidth()+2,7,34,34);
		gera.lGuias.get(index1).caixaPesquisa.setBounds((gera.lGuias.get(index1).getWidth()/2)-((gera.lGuias.get(index1).getWidth()/100)*15),10,(gera.lGuias.get(index1).getWidth()/100)*30,30);
		
		if(gera.lGuias.get(index1).caixaPesquisa.getWidth() > 0){
		
			ImageIcon imgCaixa;
			if(gera.lGuias.get(index1).anonima)imgCaixa = new ImageIcon("imgGuias/caixaCabecalhoBlack.png");
			else imgCaixa = new ImageIcon("imgGuias/caixaCabecalho.png");
			gera.lGuias.get(index1).caixaPesquisa.setIcon(new ImageIcon(imgCaixa.getImage().getScaledInstance(gera.lGuias.get(index1).caixaPesquisa.getWidth(),gera.lGuias.get(index1).caixaPesquisa.getHeight(), Image.SCALE_DEFAULT)));
		
		}
		
		gera.lGuias.get(index1).txtPesquisa.setBounds(10,0,gera.lGuias.get(index1).caixaPesquisa.getWidth()-20,30);
		gera.lGuias.get(index1).reiniciar.setBounds(gera.lGuias.get(index1).caixaPesquisa.getX()-34,10,30,30);
		gera.lGuias.get(index1).favorito.setBounds(gera.lGuias.get(index1).caixaPesquisa.getX() + gera.lGuias.get(index1).caixaPesquisa.getWidth()+((gera.lGuias.get(index1).getWidth()/100)*6),7,34,34);
		gera.lGuias.get(index1).menu.setBounds(gera.lGuias.get(index1).favorito.getX() + gera.lGuias.get(index1).favorito.getWidth()+((gera.lGuias.get(index1).getWidth()/100)*4),7,34,34);
		gera.lGuias.get(index1).dual.setBounds(gera.lGuias.get(index1).menu.getX() + gera.lGuias.get(index1).menu.getWidth()+((gera.lGuias.get(index1).getWidth()/100)*1),7,34,34);
		gera.lGuias.get(index1).dual.setVisible(false);
		gera.lGuias.get(index1).opcoes.setBounds(gera.lGuias.get(index1).menu.getX() + gera.lGuias.get(index1).menu.getWidth()+((gera.lGuias.get(index1).getWidth()/100)*1),7,34,34);
		gera.lGuias.get(index1).opcoes.setVisible(true);
		
		if(!secAberta){
		
			gera.lPaginas.get(index2).setBounds(0,0,resp.j.separador.div.getX(),resp.j.pPrincipal.getHeight());
			gera.lPaginas.get(index2).paginasP.setBounds(0,0,gera.lPaginas.get(index2).getWidth(),gera.lPaginas.get(index2).getHeight());
			gera.lPaginas.get(index2).paginasP.setBounds(0,0,gera.lPaginas.get(index2).getWidth(),gera.lPaginas.get(index2).getHeight());
			
			gera.lPaginas.get(index2).erro.setBounds(0,0, gera.lPaginas.get(index2).getWidth(), gera.lPaginas.get(index2).getHeight());
			gera.lPaginas.get(index2).erro.imgErro.setBounds((gera.lPaginas.get(index2).erro.getWidth()/100)*10,(gera.lPaginas.get(index2).erro.getHeight()/2)-150,200,200);
			gera.lPaginas.get(index2).erro.erro.setBounds(gera.lPaginas.get(index2).erro.imgErro.getX()+200+((gera.lPaginas.get(index2).erro.getWidth()/100)*10),(gera.lPaginas.get(index2).erro.getHeight()/2)-200,((gera.lPaginas.get(index2).erro.getWidth()/100)*50),200);
			gera.lPaginas.get(index2).erro.descE.setBounds(gera.lPaginas.get(index2).erro.imgErro.getX()+200+((gera.lPaginas.get(index2).erro.getWidth()/100)*10),(gera.lPaginas.get(index2).erro.getHeight()/2)-100,((gera.lPaginas.get(index2).erro.getWidth()/100)*50),200);
			
			
			gera.lGuias.get(index2).setBounds(2, 0,resp.j.separador.div.getX()-7, 49);
			gera.lGuias.get(index2).elementosBar.setSize(gera.lGuias.get(index2).getSize());
			gera.lGuias.get(index2).voltar.setBounds(0,7,34,34);
			gera.lGuias.get(index2).avancar.setBounds(gera.lGuias.get(index2).voltar.getLocation().x+gera.lGuias.get(index2).voltar.getWidth()+2,7,34,34);
			gera.lGuias.get(index2).caixaPesquisa.setBounds((gera.lGuias.get(index2).getWidth()/2)-((gera.lGuias.get(index2).getWidth()/100)*15),10,(gera.lGuias.get(index2).getWidth()/100)*30,30);
			gera.lGuias.get(index2).opcoes.setVisible(false);
			
			resp.j.setaDual.setLocation((resp.j.separador.div.getX()/2)-20,5);
			
			if(gera.lGuias.get(index2).caixaPesquisa.getWidth() > 0){
			
				ImageIcon imgCaixa;
				if(gera.lGuias.get(index2).anonima)imgCaixa = new ImageIcon("imgGuias/caixaCabecalhoBlack.png");
				else imgCaixa = new ImageIcon("imgGuias/caixaCabecalho.png");
				gera.lGuias.get(index2).caixaPesquisa.setIcon(new ImageIcon(imgCaixa.getImage().getScaledInstance(gera.lGuias.get(index2).caixaPesquisa.getWidth(),gera.lGuias.get(index2).caixaPesquisa.getHeight(), Image.SCALE_DEFAULT)));
			
			}
			
			gera.lGuias.get(index2).txtPesquisa.setBounds(10,0,gera.lGuias.get(index2).caixaPesquisa.getWidth()-20,30);
			gera.lGuias.get(index2).reiniciar.setBounds(gera.lGuias.get(index2).caixaPesquisa.getX()-34,10,30,30);
			gera.lGuias.get(index2).favorito.setBounds(gera.lGuias.get(index2).caixaPesquisa.getX() + gera.lGuias.get(index2).caixaPesquisa.getWidth()+((gera.lGuias.get(index2).getWidth()/100)*6),7,34,34);
			gera.lGuias.get(index2).menu.setBounds(gera.lGuias.get(index2).favorito.getX() + gera.lGuias.get(index2).favorito.getWidth()+((gera.lGuias.get(index2).getWidth()/100)*4),7,34,34);
			gera.lGuias.get(index2).dual.setBounds(gera.lGuias.get(index2).menu.getX() + gera.lGuias.get(index2).menu.getWidth()+((gera.lGuias.get(index2).getWidth()/100)*1),7,34,34);
			gera.lGuias.get(index2).dual.setVisible(false);
		
		}
		
	}
	
	public void trocaGuia(){
		
		gera.lPaginas.get(index1).setBounds(0, 0, resp.j.getWidth()-resp.j.separador.div.getX(), gera.lPaginas.get(index1).paginasP.getHeight());
		gera.lPaginas.get(index1).paginasP.setBounds(0,0,gera.lPaginas.get(index1).getWidth(),gera.lPaginas.get(index1).getHeight());
		gera.lPaginas.get(index1).paginasP.setBounds(0,0,gera.lPaginas.get(index1).getWidth(),gera.lPaginas.get(index1).getHeight());
		
		gera.lPaginas.get(index1).erro.setBounds(0,0, gera.lPaginas.get(index1).getWidth(), gera.lPaginas.get(index1).getHeight());
		gera.lPaginas.get(index1).erro.imgErro.setBounds((gera.lPaginas.get(index1).erro.getWidth()/100)*10,(gera.lPaginas.get(index1).erro.getHeight()/2)-150,200,200);
		gera.lPaginas.get(index1).erro.erro.setBounds(gera.lPaginas.get(index1).erro.imgErro.getX()+200+((gera.lPaginas.get(index1).erro.getWidth()/100)*10),(gera.lPaginas.get(index1).erro.getHeight()/2)-200,((gera.lPaginas.get(index1).erro.getWidth()/100)*50),200);
		gera.lPaginas.get(index1).erro.descE.setBounds(gera.lPaginas.get(index1).erro.imgErro.getX()+200+((gera.lPaginas.get(index1).erro.getWidth()/100)*10),(gera.lPaginas.get(index1).erro.getHeight()/2)-100,((gera.lPaginas.get(index1).erro.getWidth()/100)*50),200);
		
		
		gera.lGuias.get(index1).setBounds(2, 0,resp.j.getWidth()-resp.j.separador.div.getX(), gera.lGuias.get(index1).elementosBar.getHeight());
		gera.lGuias.get(index1).elementosBar.setSize(gera.lGuias.get(index1).getSize());
		gera.lGuias.get(index1).voltar.setBounds(0,7,34,34);
		gera.lGuias.get(index1).avancar.setBounds(gera.lGuias.get(index1).voltar.getLocation().x+gera.lGuias.get(index1).voltar.getWidth()+2,7,34,34);
		gera.lGuias.get(index1).caixaPesquisa.setBounds((gera.lGuias.get(index1).getWidth()/2)-((gera.lGuias.get(index1).getWidth()/100)*15),10,(gera.lGuias.get(index1).getWidth()/100)*30,30);
		
		if(gera.lGuias.get(index1).caixaPesquisa.getWidth() > 0){
		
		ImageIcon imgCaixa = new ImageIcon("imgGuias/caixaCabecalho.png");
		gera.lGuias.get(index1).caixaPesquisa.setIcon(new ImageIcon(imgCaixa.getImage().getScaledInstance(gera.lGuias.get(index1).caixaPesquisa.getWidth(),gera.lGuias.get(index1).caixaPesquisa.getHeight(), Image.SCALE_DEFAULT)));
		
		}
		
		gera.lGuias.get(index1).txtPesquisa.setBounds(10,0,gera.lGuias.get(index1).caixaPesquisa.getWidth()-20,30);
		gera.lGuias.get(index1).reiniciar.setBounds(gera.lGuias.get(index1).caixaPesquisa.getX()-34,10,30,30);
		gera.lGuias.get(index1).dual.setBounds(gera.lGuias.get(index1).caixaPesquisa.getX() + gera.lGuias.get(index1).caixaPesquisa.getWidth()+((gera.lGuias.get(index1).getWidth()/100)*6),7,34,34);
		gera.lGuias.get(index1).dual.setVisible(false);
		gera.lGuias.get(index1).menu.setBounds(gera.lGuias.get(index1).caixaPesquisa.getX() + gera.lGuias.get(index1).caixaPesquisa.getWidth()+((gera.lGuias.get(index1).getWidth()/100)*4),7,34,34);
		
	}
	
}
