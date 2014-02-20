package com.androidcentroescolar;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	DbHelper db;
	
	Button botonCentros,botonProfesores,botonPersonal,botonSalir;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
			
		botonCentros = (Button)findViewById(R.id.botonCentros);
		botonProfesores = (Button)findViewById(R.id.botonProfesores);
		botonPersonal = (Button)findViewById(R.id.botonPersonal);
		botonSalir = (Button)findViewById(R.id.botonSalir);
		
		DbHelper dbHelper = new DbHelper(getApplicationContext(),"centros", null, 1);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
				
		//dbHelper.insertarCentro(db, 566887, "Publico", "Serpis", "Calle Serpis", "677677677", 800);
		
		botonCentros.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(MainActivity.this,PantallaCentros.class);
				startActivity(i);
								
			}
		});		
	}
}
