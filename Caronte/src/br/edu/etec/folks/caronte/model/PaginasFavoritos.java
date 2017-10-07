package br.edu.etec.folks.caronte.model;

public class PaginasFavoritos {

	private String nomeFav;
	private String urlFav; 
	private int pasta;

	public String getUrlFav() {
		return urlFav;
	}

	public void setUrlFav(String urlFav) {
		this.urlFav = urlFav;
	}

	public String getNomeFav() {
		return nomeFav;
	}

	public void setNomeFav(String nomeFav) {
		this.nomeFav = nomeFav;
	}
	
	public int getPasta() {
		return pasta;
	}

	public void setPasta(int pasta) {
		this.pasta = pasta;
	}
	
}
