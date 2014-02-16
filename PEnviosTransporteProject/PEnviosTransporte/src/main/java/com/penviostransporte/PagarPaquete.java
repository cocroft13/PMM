package com.penviostransporte;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PagarPaquete extends Activity{

    private Button botonPagar;
    private EditText campoDineroIntroducido;
    private TextView textoCambioDevuelto;
    private double dineroPagado;
    private int costeEnvio;
    private String cambioDevuelto;

    int bill50,bill20,bill10,bill5,mon2,mon1,mon50;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagar_paquete);


        botonPagar = (Button)findViewById(R.id.botonPagar);
        campoDineroIntroducido = (EditText)findViewById(R.id.campoDineroIntroducido);
        textoCambioDevuelto = (TextView)findViewById(R.id.lblDineroDevolver);

        Bundle bundle = getIntent().getExtras();

        costeEnvio = bundle.getInt("COSTE");


        //cambioDevuelto = "Coste: " + costeEnvio;


        botonPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int dineroPagado = Integer.parseInt(campoDineroIntroducido.getText().toString());

                calcularCambio(dineroPagado);
            }
        });

    }

    public void calcularCambio(double dineroPagado){

        if(dineroPagado == costeEnvio ){

            textoCambioDevuelto.setText("No hay cambio a devolver, el importe ha sido exacto");

        } else if(dineroPagado < costeEnvio){

            textoCambioDevuelto.setText("Has introducido una cantidad menor al coste");

        } else {

            int total = (int) (dineroPagado - costeEnvio);
            int aux = total;

            if (total >= 50){
                bill50 = Integer.parseInt(String.valueOf(total/50));
                total = total%50;
            }

            if (total >= 20){
                bill20 = Integer.parseInt(String.valueOf(total/20));
                total = total%20;
            }

            if (total >= 10){
                bill10 = Integer.parseInt(String.valueOf(total/10));
                total = total%10;
            }

            if (total >= 5){
                bill5 = Integer.parseInt(String.valueOf(total/5));
                total = total%5;
            }

            if (total >= 2){
                mon2 = Integer.parseInt(String.valueOf(total/2));
                total = total%2;
            }

            /*if (total >= 1){
                mon1 = Integer.parseInt(String.valueOf(total/1));
                total = total%1;
            }*/

            if (total >= 0.50){
                mon50 = Integer.parseInt(String.valueOf(total/0.50));
                total = (int) (total%0.50);
            }


            textoCambioDevuelto.setText( "Su vuelta: " + aux + "\n" +
                                        "Billetes de 50€: " + bill50 + "\n" +
                                        "Billetes de 20€: " + bill20 + "\n" +
                                        "Billetes de 10€: " + bill10 + "\n" +
                                        "Billetes de 5€: " + bill5 + "\n" +
                                        "Monedas de 2€:" + mon2 + "\n" +
                                        "Monedas de 1€: " + mon1 + "\n" +
                                        "Monedasd de 0,50€: " + mon50 + "\n");
        }
    }
}