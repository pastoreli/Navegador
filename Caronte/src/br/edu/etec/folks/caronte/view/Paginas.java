package br.edu.etec.folks.caronte.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.text.html.HTMLEditorKit;

import org.w3c.dom.stylesheets.StyleSheet;

import br.edu.etec.folks.caronte.controller.BuscaPagina;
import br.edu.etec.folks.caronte.controllerView.Responsivo;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Paginas extends JPanel{
	
	Responsivo resp = new Responsivo();
	public Erro erro = new Erro();
	
	public JFXPanel paginasP;
	
	public WebView webView;
	
	public boolean aberta = true;
	public int posicao;
	public  int indexDual = 0;
	
	public Paginas(){
		
		this.setLayout(null);
		this.setBounds(0, 0,resp.j.getWidth(), resp.j.getHeight()-50);
		this.setBackground(new Color(255,255,255));
		
		this.add(erro);
		
		LookAndFeel lfAnterior = UIManager.getLookAndFeel();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception ex) {
			ex.printStackTrace();
			}
		
		paginasP = new JFXPanel();
		paginasP.setBounds(0,0,this.getWidth(),this.getHeight());
		
		try {
			UIManager.setLookAndFeel(lfAnterior);
			} catch (Exception ex) {
			ex.printStackTrace();
			}
		
		this.add(paginasP);
		
	}
	
}
