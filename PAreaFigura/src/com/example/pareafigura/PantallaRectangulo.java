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
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.TextView;

public class PantallaRectangulo extends Activity {
	
	Button botonCalculo;
	Button botonDibujar;
	EditText texto1;
	EditText texto2;
	TextView textoResult;
	RadioGroup radioGroup;
	RadioButton radioButtonRojo,radioButtonVerde,radioButtonAzul;

	int color;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantallarectangulo);
		
		/* BOTON PARA DIBUJAR */
		botonDibujar = (Button)findViewById(R.id.botonDibujarRectangulo);

        /* VARIABLES PARA LOS CAMPOS DE TEXTO QUE CONTIENEN LOS VALORES */
		texto1 = (EditText)findViewById(R.id.textoLado1);
		texto2 = (EditText)findViewById(R.id.textoLado2);

        /* LAS VARIABLES DEL RADIOGROUP CON SUS TRES RADIOBUTTONS */
		radioGroup = (RadioGroup)findViewById(R.id.radioGroupRect);
		radioButtonRojo = (RadioButton)findViewById(R.id.rojoRect);
		radioButtonVerde = (RadioButton)findViewById(R.id.verdeRect);
		radioButtonAzul = (RadioButton)findViewById(R.id.azulRect);
		
		/* LA SELECCION DEL COLOR PARA EL CUADRADO MEDIANTE RADIO BUTTONS, COLOR.? DEVUELVE UN INT */
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				
				if (radioButtonRojo.isChecked()){
					color = Color.RED;
				}
				
				if (radioButtonAzul.isChecked()){
					color = Color.BLUE;
				}
				
				if (radioButtonVerde.isChecked()){
					
					color = Color.GREEN;
				}				
			}
		});
		
		
		textoResult = (TextView)findViewById(R.id.textoAreaRectangulo);

        /* LISTENER PARA RECOGER LOS VALORES DE LOS LADOS Y DIBUJAR EL CUADRADO EN LA PANTALLA CANVAS */
		botonDibujar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String valor1 = texto1.getText().toString();
				String valor2 = texto2.getText().toString();
							
				int lado1 = Integer.parseInt(valor1);
				int lado2 = Integer.parseInt(valor2);
				
				
				Bundle bundle = new Bundle();
				bundle.putInt("LADO1", lado1);
				bundle.putInt("LADO2", lado2);
				bundle.putInt("COLOR", color);
				
				Intent intent = new Intent(PantallaRectangulo.this,CanvasRectangulo.class);
				intent.putExtras(bundle);
				startActivity(intent);
								
			}
		});
	}
}
