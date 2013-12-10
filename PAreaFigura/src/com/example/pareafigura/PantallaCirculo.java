package com.example.pareafigura;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PantallaCirculo extends Activity {

    EditText radioCirculo;
    Button botonCirculo;
    RadioGroup radioGroup;
    RadioButton radioButtonRojo,radioButtonVerde,radioButtonAzul;

    int color;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantallacirculo);


        radioCirculo = (EditText)findViewById(R.id.radioCirculo);
        botonCirculo = (Button)findViewById(R.id.botonDibujarCirculo);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroupCirculo);
        radioButtonRojo = (RadioButton)findViewById(R.id.botonRojoCirculo);
        radioButtonVerde = (RadioButton)findViewById(R.id.botonVerdeCirculo);
        radioButtonAzul = (RadioButton)findViewById(R.id.botonAzulCirculo);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (radioButtonRojo.isChecked()){

                    color = Color.RED;
                }

                if (radioButtonVerde.isChecked()){

                    color = Color.GREEN;
                }

                if (radioButtonAzul.isChecked()){

                    color = Color.BLUE;
                }
            }
        });


        botonCirculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String radio = radioCirculo.getText().toString();
                float value = Float.parseFloat(radio);

                Bundle bundle = new Bundle();
                bundle.putFloat("RADIO", value);
                bundle.putInt("COLOR",color);

                Intent intent = new Intent(PantallaCirculo.this,CanvasCirculo.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

    }
}


