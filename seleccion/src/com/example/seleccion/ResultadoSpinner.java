package com.example.seleccion;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultadoSpinner extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resultado_spinner);
	
	
		TextView txtArtista = (TextView)findViewById(R.id.lblArtist);
		TextView txtAlbum = (TextView)findViewById(R.id.lblAlbum);
		TextView txtFecha = (TextView)findViewById(R.id.lblFecha);
		ImageView imgCover = (ImageView)findViewById(R.id.lblCover);
		
		Bundle bundle = getIntent().getExtras();
		
		txtArtista.setText(bundle.getString("ARTISTA"));
		txtAlbum.setText(bundle.getString("ALBUM"));
		txtFecha.setText(bundle.getString("A„O"));
		imgCover.setImageResource(bundle.getInt("PORTADA"));
	
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.resultado_spinner, menu);
		return true;
	}

}
