package com.example.spinner;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends Activity {

	boolean flag = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
		final Spinner spinner = (Spinner)findViewById(R.id.spinnerOpc);	
		spinner.setAdapter(adaptador);
		
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {   //YO NO TENIA ADAPTERVIEW., SOLO EL NEW ONITEMSELECTED

			@Override
			public void onItemSelected(AdapterView<?> a, android.view.View v, int position, long id) {			//NO TENIA ANDROID.VIEW.
			
			Intent intentSpinner = new Intent(MainActivity.this,PruebaActivity.class);
			
			if (flag == false){
				flag = true;
			}else{
				
				String Artista = ((titular)a.getAdapter().getItem(position)).getArtista();
				String album = ((titular)a.getAdapter().getItem(position)).getAlbum();
				String a–o = ((titular)a.getAdapter().getItem(position)).a–oToString();
				int portada = ((titular)a.getAdapter().getItem(position)).getPortada();
				
				
				Bundle bundle = new Bundle();
				bundle.putString("ARTISTA", Artista);
				bundle.putString("ALBUM", album );
				bundle.putString("A„O", a–o);
				bundle.putInt("PORTADA", portada);
								
				intentSpinner.putExtras(bundle);
				startActivity(intentSpinner);			
			}
						
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}					
		});	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}


class AdaptadorTitulares extends ArrayAdapter<titular>{
	
	Activity context;

	public AdaptadorTitulares(Activity context) {
		super(context, R.layout.desglose,datos);
		this.context = context;
	}
	
	@Override
	public View getDropDownView(int position,View convertView,ViewGroup Parent){
		return getView(position, convertView, Parent);		
	}
	
	public View getView(int position,View convertView,ViewGroup Parent){
		
		View item = convertView;
		ViewHolder holder;
		
		if (item == null){
			
			LayoutInflater inflater = context.getLayoutInflater();
			item = inflater.inflate(R.layout.desglose, null);
			
			
			holder = new ViewHolder();
			holder.artista = (TextView)item.findViewById(R.id.lblArtista);
			holder.album = (TextView)item.findViewById(R.id.lblAlbum);
			holder.a–o = (TextView)item.findViewById(R.id.lblYear);
			holder.portada = (ImageView)item.findViewById(R.id.lblPortada);
			
			item.setTag(holder);			
			
		} else {
			
			holder = (ViewHolder)item.getTag();
		}
		
		holder.artista.setText(datos[position].getArtista());
		holder.album.setText(datos[position].getAlbum());
		holder.a–o.setText(datos[position].a–oToString());
		holder.portada.setImageResource(datos[position].getPortada());
		
		return item;
		
	}
	
	private static titular [] datos = new titular[]{
		new titular("Grayskul", "BloodyRadio", 2007,R.drawable.bloodyradio),
		new titular("Redman", "Muddy Waters", 1996,R.drawable.muddy),
		new titular("Jakki Da Motamouth", "Psycho Circus", 2011,R.drawable.jakki)};
	

	static class ViewHolder{
		
		TextView artista;
		TextView album;
		TextView a–o;
		ImageView portada;
				
	}
	
}