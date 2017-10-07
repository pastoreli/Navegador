package br.edu.etec.folks.caronte.dao;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import br.edu.etec.folks.caronte.controller.BuscaPagina;
import br.edu.etec.folks.caronte.controller.GeraGuia;
import br.edu.etec.folks.caronte.controllerView.EfeitoItens;
import br.edu.etec.folks.caronte.model.PaginasFavoritos;
import br.edu.etec.folks.caronte.view.Guias;

public class CrudFavoritos {
	
	public static List <PaginasFavoritos> lFavoritos = new ArrayList <PaginasFavoritos>(); 
	
	public static void salvar(PaginasFavoritos nome){
		GeraGuia gera = new GeraGuia();
		
		lFavoritos.add(nome);
		
		for(Guias g : gera.lGuias){
			
			if(g.menuC || g.favoritoC){
				g.menuC = false;
				g.favoritoC = false;
				g.favorito.setIcon(new ImageIcon("imgGuias/imgFavorito.png"));
				g.menu.setIcon(new ImageIcon("imgGuias/menu.png"));
				g.favorito.setVisible(false);
				g.foco = false;
				break;
			}
			
		}
		
		for(Guias g : gera.lGuias){
			if(g.url.equals(nome.getUrlFav()))g.favorito.setVisible(false);
		}
		
	}
	
	public static void remover(String url){
		GeraGuia gera = new GeraGuia();
		for(int i=0; i<lFavoritos.size(); i++){
			if(lFavoritos.get(i).getUrlFav().equals(url)){
				lFavoritos.remove(i);
			}
		}
		
		for(Guias g : gera.lGuias){
				if(g.url.equals(url))g.favorito.setVisible(true);
		}
		
	}
	
	public static void editar(String nome, String url, int indice){
		
		GeraGuia gera = new GeraGuia();
		for(int i=0; i<lFavoritos.size(); i++){
			if(lFavoritos.get(i).getUrlFav().equals(url)){
				lFavoritos.get(i).setNomeFav(nome);
				lFavoritos.get(i).setUrlFav(url);
				lFavoritos.get(i).setPasta(indice);
			}
		}
		
		for(Guias g : gera.lGuias){
			
			if(g.menuC || g.favoritoC){
				g.menuC = false;
				g.favoritoC = false;
				g.favorito.setIcon(new ImageIcon("imgGuias/imgFavorito.png"));
				g.menu.setIcon(new ImageIcon("imgGuias/menu.png"));
				g.favorito.setVisible(false);
				g.foco = false;
				break;
			}
			
		}
	}
	
	public static void BuscarFavorito(String url){
		GeraGuia gera = new GeraGuia();
		BuscaPagina busca = new BuscaPagina();
		try {
			busca.url = new URL(url);
		} catch (MalformedURLException e) {
			
		}
		busca.buscarPagina(true, true);
		
		for(Guias g : gera.lGuias){
			if(g.menuC || g.favoritoC){
				g.menuC = false;
				g.favoritoC = false;
				g.favorito.setIcon(new ImageIcon("imgGuias/imgFavorito.png"));
				g.menu.setIcon(new ImageIcon("imgGuias/menu.png"));
				g.favorito.setVisible(false);
				g.foco = false;
				break;
			}
			
		}
		
	}
	
}
