package P.AreaFigura;

import android.app.Activity;

public class Figura extends Activity {

    String numero;
    String nombre;
    int imagen;

    public Figura(String numero, String nombre, int imagen){
        this.numero = numero;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNumero(){
        return numero;

    }

    public String getNombre(){
        return nombre;

    }

    public int getImagen(){
        return imagen;
    }
}

