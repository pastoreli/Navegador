package br.edu.etec.folks.caronte.controllerView;

import java.awt.Color;

import br.edu.etec.folks.caronte.view.Abas;
import br.edu.etec.folks.caronte.controller.GeraGuia;

public class Cor {
	
	public static Color tema, tema2, tema3;
	
	public static void escolhaTema(int tipo){
		
		switch(tipo){
		
			case 0:
				tema = new Color(230, 230, 230);
				tema2 = new Color(210, 210, 210);
				tema3 = new Color(220, 220, 220);
				break;
				
			case 1:
				
				tema = new Color(241, 220, 154);
				tema2 = new Color(241, 212, 123);
				tema3 = new Color(241, 219, 152);
				
				break;
				
			case 2:
				
				tema = new Color(74, 88, 136);
				tema2 = new Color(62, 70, 98);
				tema3 = new Color(75, 84, 116);
				
				break;
				
			case 3:
				tema = new Color(138, 138, 138);
				tema2 = new Color(167, 167, 167);
				tema3 = new Color(150, 150, 150);
				break;
				
		}
		
		Responsivo resp = new Responsivo();
		
		resp.j.cabecalho.setBackground(tema);
		resp.j.fechar.setBackground(tema);
		resp.j.minimizar.setBackground(tema);
		resp.j.maximizar.setBackground(tema);
		resp.j.pItens.setBackground(tema);
		resp.j.pAbas.setBackground(tema2);
		resp.j.novaGuia.setBackground(tema2);
		resp.j.pPrincipal.setBackground(tema);
		
		GeraGuia gera = new GeraGuia();
		for(Abas a : gera.lAbas){
			if(a.aberta)a.setBackground(tema);
			else a.setBackground(tema2);
		}
		
	}
	
}
