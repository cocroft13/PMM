package com.example.seleccion;

public class Titular {

	private String titulo;
	private String subtitulo;
	private int year;
	private int foto;
	
	public Titular(String tit, String subt,int year, int foto) {
		titulo = tit;
		subtitulo = subt;
		this.year = year;
		this.foto = foto;				
	}
	
	public String getTitulo(){
		return titulo;
	}
	
	public String getSubtitulo(){
		return subtitulo;
		
	}
	
	public int getYear(){
		return year;
	}
		
	public String yearToString(){
		String yearc;
		yearc = Integer.toString(year);
		return yearc;
	}
	
	public int getFoto(){
		return foto;
	}
			
}
	
	

