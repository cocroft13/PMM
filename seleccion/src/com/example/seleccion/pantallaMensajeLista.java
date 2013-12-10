package com.example.seleccion;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class pantallaMensajeLista extends Activity {
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantallamensajelista);
		
			
		//Localizar controles		
		TextView txtArtista = (TextView)findViewById(R.id.Artista);
		TextView txtAlbum = (TextView)findViewById(R.id.Album);
		TextView txtYear = (TextView)findViewById(R.id.Year);
		ImageView portada = (ImageView)findViewById(R.id.portada);
		
		//Accedemos al intent que ha originado la actividad principal		
		Bundle bundle = getIntent().getExtras();
		
		//Construimos el mensaje a mostrar	
		txtArtista.setText("Artista: " + bundle.getString("ARTISTA"));
		txtAlbum.setText("Album: " + bundle.getString("ALBUM"));
		txtYear.setText("Año :" + bundle.getString("AñO"));
		portada.setImageResource(bundle.getInt("PORTADA"));
					
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}
