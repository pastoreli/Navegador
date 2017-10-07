package br.edu.etec.folks.caronte.controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

import br.edu.etec.folks.caronte.controllerView.Cor;
import br.edu.etec.folks.caronte.controllerView.Responsivo;
import br.edu.etec.folks.caronte.view.Abas;
import br.edu.etec.folks.caronte.view.Guias;
import br.edu.etec.folks.caronte.view.Paginas;

public class GeraGuia {
	
	//Listas para controle de guias, páginas e abas
	public static List<Guias> lGuias = new ArrayList<Guias>();
	public static List<Paginas> lPaginas = new ArrayList<Paginas>();
	public static List<Abas> lAbas = new ArrayList<Abas>();
	
	//Abrir páginas
	public void criarPaginas(boolean anonima){
		
		Responsivo resp = new Responsivo();
		//sobrepondo guias ao abrir uma nova
		for(Guias g1 : lGuias){
			 
			 if(g1.aberta){
				 
				 g1.aberta = false;
				 g1.setVisible(false);
				 
			 }
			 
		 }
		//Guia ta como se fosse aba, área de pesquisa de cada página aberta
		 Guias g = new Guias();
		 if(anonima)g.anonima = true;
		 
		 lGuias.add(g);
		 
		 resp.j.pItens.add(lGuias.get(lGuias.size()-1));
		 
		 for(Abas a1 : lAbas){
			 
			 if(a1.aberta){
				 //Se estiver aberta muda de cor
				 a1.setBackground(Cor.tema2);
				 a1.aberta = false;
				 
			 }

		 }
		 //Abas estão como se fosse Guias, a seleção de página
		 Abas a = new Abas();
		 if(anonima)a.anonima = true;
		 
		 lAbas.add(a);
		
		 resp.j.pAbas.add(lAbas.get(lAbas.size()-1));
		 //Verificando as páginas abertas
		 for(Paginas p1 : lPaginas){
			 
			 if(p1.aberta){
				 //Se estiver aberta troca de cor
				 p1.aberta = false;
				 p1.setVisible(false);
				 
			 }
			 
		 }
		 
		 //Controlar o design de troca e página
		 Paginas p = new Paginas();
		 
		 lPaginas.add(p);
		
		 resp.j.pPrincipal.add(lPaginas.get(lPaginas.size()-1));
		 
		 g.repaint();
		 
		 a.repaint();
		 
		 p.repaint();
		 
		 g.pagina1();
		 
		 //Verifica o tamanho da tela para torná-la responsiva
		 resp.typeScreen();
		 
	}
	
	//Metodo da troca de guias, dã
	public void trocaGuia(){
		
		Responsivo resp = new Responsivo();
		
		//Controle de guias
		for(Guias g : lGuias){
			
			if(g.aberta){
				g.aberta = false;
				g.setVisible(false);
			}
			
		}
		
		for(Paginas p : lPaginas){
			
			if(p.aberta){
				p.aberta = false;
				p.setVisible(false);
			}
			
		}
	
		//contador para controlar o indice de cada item(guias)
		int cont = 0;
		
		//Controle de abas
		for(Abas a : lAbas){
			
			if(a.aberta){
				
				a.setBackground(Cor.tema2);
				a.aberta = false;
				
			}
			
			if(a.getBackground().equals(Cor.tema3)){
				
				a.setBackground(Cor.tema);
				a.aberta = true;
				
				lGuias.get(cont).setVisible(true);
				lGuias.get(cont).aberta = true;
				lPaginas.get(cont).setVisible(true);
				lPaginas.get(cont).aberta = true;
				
			}
			
			cont++;
			
		}
		
//		resp.typeScreen();
		
	}
	
	//Para fechar guias, dã
	public void fechaGuias(){
		
		Responsivo resp = new Responsivo();
		
		int cont = 0;
		//remover abas
		for(Abas a : lAbas){
			
			if(a.aberta){
				
				a.setVisible(false);
				resp.j.pAbas.remove(a);
				lAbas.remove(cont);
				break;
				
			}
			
			cont++;
			
		}
		
		cont = 0;
		//remover guias
		for(Guias g : lGuias){
			
			if(g.aberta){
				
				g.setVisible(false);
				resp.j.cabecalho.remove(g);
				lGuias.remove(cont);
				break;
				
			}
			
			cont++;
			
		}
		
		cont = 0;
		//remover páginas
		for(Paginas p : lPaginas){
			
			if(p.aberta){
				
				p.setVisible(false);
				resp.j.pPrincipal.remove(p);
				lPaginas.remove(cont);
				break;
				
			}
			
			cont++;
			
		}
		//Verfcando se tem só uma guia para mudar o design
		if(cont == 0){
		
			lAbas.get(0).setBackground(Cor.tema);
			lAbas.get(0).setVisible(true);
			lAbas.get(0).aberta = true;
			lGuias.get(0).setVisible(true);
			lGuias.get(0).aberta = true;
			lPaginas.get(0).setVisible(true);
			lPaginas.get(0).aberta = true;
		
		}else{//Verificando se tem mais de uma guias, para mudar o design
			
			lAbas.get(cont-1).setBackground(Cor.tema);
			lAbas.get(cont-1).setVisible(true);
			lAbas.get(cont-1).aberta = true;
			lGuias.get(cont-1).setVisible(true);
			lGuias.get(cont-1).aberta = true;
			lPaginas.get(cont-1).setVisible(true);
			lPaginas.get(cont-1).aberta = true;
			
		}
		//pega o  tamanho datela
		resp.typeScreen();
		
	}
	
	// troca de posições
	
	public static int indice = 0;
	
	 public static boolean moverParaFrente(List<Abas> abas, List<Guias> guias, List<Paginas> paginas) throws Exception {
         if (abas == null && guias == null && paginas == null) {
                 throw new Exception("Elemento não existe");
         } else if (abas != null && guias != null && paginas != null) {
                 Collections.swap(abas, indice, indice+1);
                 Collections.swap(guias, indice, indice+1);
                 Collections.swap(paginas, indice, indice+1);
                 return true;
         }
         return false;
	 }


  public static boolean moverParaTras(List<Abas> abas, List<Guias> guias, List<Paginas> paginas) throws Exception {
         if (abas == null && guias == null && paginas == null) {
                 throw new Exception("Elemento não existe");
         } else if (abas != null && guias != null && paginas != null) {
                 Collections.swap(abas, indice, indice-1);
                 Collections.swap(guias, indice, indice-1);
                 Collections.swap(paginas, indice, indice-1);
                 return true;
         }
         return false;
  }
		
}
