package com.androidcentroescolar;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PantallaNuevoCentro extends Activity{
	
	private EditText campoCodCentro,campoTipoCentro,campoNombreCentro,
	campoDireccionCentro,campoTelefonoCentro,campoNumPlazasCentro;
	
	private Button botonRegistro;
	
	private int codCentro,numPlazas;
	private String tipoCentro,nombreCentro,direccionCentro,telefonoCentro;
	
	private DbHelper dbHelper; 
	private SQLiteDatabase db; 
	
	
	public void onCreate(Bundle savedInstanceState) {	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantalla_nuevo_centro);
		
		dbHelper = new DbHelper(getApplicationContext(), "centros", null, 1);
		db = dbHelper.getWritableDatabase();
		
			
		botonRegistro = (Button)findViewById(R.id.btnRegistrarCentro);
		
		botonRegistro.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
								
				campoCodCentro = (EditText)findViewById(R.id.lblCodCentro);
				campoTipoCentro = (EditText)findViewById(R.id.lblTipoCentro);
				campoNombreCentro = (EditText)findViewById(R.id.lblNombreCentro);
				campoDireccionCentro = (EditText)findViewById(R.id.lblDireccionCentro);
				campoTelefonoCentro = (EditText)findViewById(R.id.lblTelefonoCentro);
				campoNumPlazasCentro = (EditText)findViewById(R.id.lblNumPlazas);
								
				codCentro = Integer.parseInt(campoCodCentro.getText().toString());
				tipoCentro = campoTipoCentro.getText().toString();
				nombreCentro = campoNombreCentro.getText().toString();
				direccionCentro = campoDireccionCentro.getText().toString();
				telefonoCentro = campoTelefonoCentro.getText().toString();
				numPlazas = Integer.parseInt(campoNumPlazasCentro.getText().toString());
					
					
				DbHelper dbHelper = new DbHelper(getApplicationContext(), "centros", null, 1);
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				
				dbHelper.insertarCentro(db, codCentro, tipoCentro, nombreCentro, direccionCentro, telefonoCentro, numPlazas);
				
				Intent i = new Intent(PantallaNuevoCentro.this,PantallaCentros.class);
				startActivity(i);
				finish();
												
			}
		});		
	}
}
