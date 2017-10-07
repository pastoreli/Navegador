package br.edu.etec.folks.caronte.dao;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import br.edu.etec.folks.caronte.controller.BuscaPagina;
import br.edu.etec.folks.caronte.controller.GeraGuia;
import br.edu.etec.folks.caronte.controllerView.Responsivo;
import br.edu.etec.folks.caronte.model.PaginasHistorico;
import br.edu.etec.folks.caronte.view.Guias;

public class CrudHistorico {
	
	Responsivo resp = new Responsivo();
	
	public static List<PaginasHistorico> lHistorico = new ArrayList<PaginasHistorico>();
	
	public int index;
	public void Remover(){
		
		lHistorico.remove(index);
		
		resp.itens.historico.pLista.removeAll();
		resp.itens.historico.addItens();
		resp.itens.historico.pLista.repaint();
		
	}
	
	public void removerTudo(){
		
		lHistorico.removeAll(lHistorico);
		resp.itens.historico.pLista.removeAll();
		resp.itens.historico.addItens();
		resp.itens.historico.pLista.repaint();
		
	}
	
	public static void BuscarHistorico(String url){
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
