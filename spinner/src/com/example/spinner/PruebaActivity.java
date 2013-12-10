package com.example.spinner;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class PruebaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prueba);
	
	
		TextView txtArtista = (TextView)findViewById(R.id.Artista);
		TextView txtAlbum = (TextView)findViewById(R.id.Album);
		TextView txtFecha = (TextView)findViewById(R.id.Fecha);
		ImageView imgPortada = (ImageView)findViewById(R.id.Portada);
		
		
		Bundle bundle = getIntent().getExtras();
		
		txtArtista.setText(bundle.getString("ARTISTA"));
		txtAlbum.setText(bundle.getString("ALBUM"));
		txtFecha.setText(bundle.getString("A„O"));
		imgPortada.setImageResource(bundle.getInt("PORTADA"));
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.prueba, menu);
		return true;
	}

}
