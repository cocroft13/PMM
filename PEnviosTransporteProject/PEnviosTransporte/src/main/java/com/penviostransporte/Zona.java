package com.penviostransporte;


public class Zona {

    private String zona;
    private String continente;
    private int precioBase;



    public Zona(String zona, String continente, int precioBase){

        this.zona = zona;
        this.continente = continente;
        this.precioBase = precioBase;

    }


    public String getZona(){
        return zona;
    }

    public String getContinente(){

        return continente;
    }

    public int getPrecioBase(){

        return precioBase;
    }

    public String precioToString(){

        String pr;
        pr = Integer.toString(precioBase);
        return pr;

    }


}
