package com.example.solobici;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button botonAcercaDe;
	private Button juego;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		botonAcercaDe = (Button)findViewById(R.id.Boton03);		
		botonAcercaDe.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				lanzarAcercaDe();				
			}
		});	
		
		
		//FUNCIONALIDAD DEL BOTON JUEGO
		juego = (Button)findViewById(R.id.Boton01);		
		juego.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				lanzarJuego();
				
			}
		});	
		
	}
	
	public void lanzarAcercaDe(){
		Intent i = new Intent(this,AcercaDe.class);
		startActivity(i);
	}
	
	public void lanzarJuego(){
		Intent i = new Intent(this,Juego.class);
		startActivity(i);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
