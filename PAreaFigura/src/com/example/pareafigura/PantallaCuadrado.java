package com.example.pareafigura;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PantallaCuadrado extends Activity{
	
	Button boton;
    RadioGroup radioGroup;
    RadioButton radioButtonRojo,radioButtonVerde,radioButtonAzul;
    int color;

	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantallacuadrado);
		
		final EditText texto = (EditText)findViewById(R.id.textoCuadrado);
			
		boton = (Button)findViewById(R.id.botonDibujarCuadrado);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroupCuadrado);
        radioButtonRojo = (RadioButton)findViewById(R.id.rojoCuadrado);
        radioButtonVerde = (RadioButton)findViewById(R.id.verdeCudadrado);
        radioButtonAzul = (RadioButton)findViewById(R.id.azulCuadrado);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int arg1) {

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

		boton.setOnClickListener(new OnClickListener() {	
					
			@Override
			public void onClick(View v) {
				String lado = texto.getText().toString();
                int value = Integer.parseInt(lado);

				//CONSTRUIMOS EL BUNDLE ALMACENANDO EL VALOR DEL LADO DEL CUADRADO
				Bundle bundle;
				bundle = new Bundle();
				bundle.putInt("LADOCUADRADO",value);
                bundle.putInt("COLOR",color);
				
				//CREAMOS EL INTENT CARGANDO EL BUNDLE, QUE A SU VEZ CONTIENE EL VALOR DE LADO DEL CUADRADO
				Intent intent = new Intent(PantallaCuadrado.this,CanvasCuadrado.class);
				intent.putExtras(bundle);
				startActivity(intent);			
				
			}
		});
	}
}