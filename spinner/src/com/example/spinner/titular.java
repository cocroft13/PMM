package com.example.spinner;

public class titular {
	
	private String artista;
	private String album;
	private int a–o;
	private int portada;
	
	public titular(String artista,String album,int a–o, int portada){
		this.artista = artista;
		this.album = album;
		this.a–o = a–o;
		this.portada = portada;
		
	}
	
	public String getArtista(){
		return artista;		
	}
	
	public String getAlbum(){	
		return album;
	}
	
	public int getA–o(){
		return a–o;
	}
	
	public int getPortada(){
		return portada;
	}
	
	public String a–oToString(){
		String a–oString;
		a–oString = Integer.toString(a–o);
		return a–oString;
		
	}	
}
