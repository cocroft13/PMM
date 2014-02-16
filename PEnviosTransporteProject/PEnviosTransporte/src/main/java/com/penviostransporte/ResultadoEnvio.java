package com.penviostransporte;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoEnvio extends Activity{

    Button botonPagarPaquete;
    TextView textoResultadoFinal;
    String zona;
    String tarifa;
    String peso;
    String decoracion;
    int costeFinal;
    String textoFinal;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultadoenvio);

        botonPagarPaquete = (Button)findViewById(R.id.botonPagarPaquete);
        textoResultadoFinal = (TextView)findViewById(R.id.textoResultadoFinal);

        Bundle bundle = getIntent().getExtras();

        zona = bundle.getString("ZONA");
        tarifa = bundle.getString("TARIFA");
        peso = bundle.getString("PESO");
        decoracion =  bundle.getString("DECORACION");
        costeFinal = bundle.getInt("COSTEFINAL");


        textoFinal =  "Zona: " + zona + "\n"+
                      "Tarifa: " + tarifa +"\n" +
                      "Peso: " + peso +"Kg" + "\n"+
                      "Decoracion: " + decoracion + "\n" +
                      "COSTE FINAL: " + costeFinal + "€";

        textoResultadoFinal.setText(textoFinal);



    botonPagarPaquete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Bundle b = new Bundle();
            b.putInt("COSTE",costeFinal);

            Intent intent = new Intent(ResultadoEnvio.this,PagarPaquete.class);
            intent.putExtras(b);
            startActivity(intent);

        }
    });

    }
}
