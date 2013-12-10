package com.example.spinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;


public class PantallaSpinner extends Activity {
		
	protected void OnCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pantalla_spinner);
		
		final TextView artista = (TextView)findViewById(R.id.Artist);
		final TextView album = (TextView)findViewById(R.id.Album);
		final TextView a–o = (TextView)findViewById(R.id.Year);
		final ImageView portada = (ImageView)findViewById(R.id.Portada);
			
		Bundle b = getIntent().getExtras();
	
		artista.setText(b.getString("ARTISTA"));
		album.setText(b.getString("ALBUM"));
		a–o.setText(b.getString("A„O"));
		portada.setImageResource(b.getInt("PORTADA"));
	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
