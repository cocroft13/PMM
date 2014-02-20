package com.androidcentroescolar;

public class Centros {
		
	public Centros(int cod_centro,String tipo_centro,String nombre,String direccion,String telefono,int num_plazas){
		
		this.cod_centro = cod_centro;
		this.tipo_centro = tipo_centro;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.num_plazas = num_plazas;		
	}

	String tipo_centro,nombre,direccion,telefono;
	int cod_centro,num_plazas;
	
	
	public String getTipo_centro() {
		return tipo_centro;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public int getCod_centro() {
		return cod_centro;
	}
	public int getNum_plazas() {
		return num_plazas;
	}

}