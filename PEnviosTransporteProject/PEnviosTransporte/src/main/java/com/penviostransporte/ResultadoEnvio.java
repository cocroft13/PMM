package com.penviostransporte;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoEnvio extends Activity{

    TextView textoResultadoFinal;
    String zona;
    String tarifa;
    String peso;
    String decoracion;
    double costeFinal;
    String textoFinal;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultadoenvio);

        textoResultadoFinal = (TextView)findViewById(R.id.textoResultadoFinal);

        Bundle bundle = getIntent().getExtras();

        zona = bundle.getString("ZONA");
        tarifa = bundle.getString("TARIFA");
        peso = bundle.getString("PESO");
        decoracion =  bundle.getString("DECORACION");
        costeFinal = bundle.getDouble("COSTEFINAL");


        textoFinal =  "Zona: " + zona + "\n"+
                      "Tarifa: " + tarifa +"\n" +
                      "Peso: " + peso +"Kg" + "\n"+
                      "Decoracion: " + decoracion + "\n" +
                      "COSTE FINAL: " + costeFinal + "€";

        textoResultadoFinal.setText(textoFinal);

    }
}
