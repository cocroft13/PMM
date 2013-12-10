package com.example.seleccion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class pantallaSpinner extends Activity{
	
	
	boolean flag = false;
	
	public void onCreate(Bundle savedInstanceState){	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantallaspinner);
		
		AdaptadorTitularesSpinner adaptador = new AdaptadorTitularesSpinner(this);
		final Spinner spinner = (Spinner)findViewById(R.id.cmbOpciones);
		
		spinner.setAdapter(adaptador);	
		
		//ADAPTAR INTERFAZ ONCLICK LISTENER
			
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> a, View v,int position, long id) {				
			
			//CREACION DEL INTENT
			Intent intentSpinner = new Intent(pantallaSpinner.this,ResultadoSpinner.class);
			
			if (flag == false){
				flag = true;
			} else {
				
				String artista =((Titular)a.getAdapter().getItem(position)).getTitulo();
				String album = ((Titular)a.getAdapter().getItem(position)).getSubtitulo();
				String year = ((Titular)a.getAdapter().getItem(position)).yearToString();
				int portada = ((Titular)a.getAdapter().getItem(position)).getFoto();
													
			//BUNDLE
			Bundle b = new Bundle();
			b.putString("ARTISTA", artista);
			b.putString("ALBUM", album);
			b.putString("AÑO",year);
			b.putInt("PORTADA", portada);
			
			
			//PASAR LA INFORMACION AL INTENT
			intentSpinner.putExtras(b);
			startActivity(intentSpinner);
			
			}	
			}

			@Override
			public void onNothingSelected(AdapterView<?> a) {
				// TODO Auto-generated method stub
						
			}		
		});					
	}
}

class AdaptadorTitularesSpinner extends ArrayAdapter<Titular>{
	
	Activity context;
	
	public AdaptadorTitularesSpinner(Activity context){
		super(context, R.layout.desglosespinner,datos);
		this.context = context;	
		
	}
	@Override
	public View getDropDownView(int position,View convertView,ViewGroup Parent){
		return getView(position, convertView, Parent);		
	}
	
public View getView(int position,View convertView,ViewGroup parent){
		
		View item = convertView;
		ViewHolder holder;
		
		if (item == null){
	
			LayoutInflater inflater = context.getLayoutInflater();
			item = inflater.inflate(R.layout.desglosespinner, null);
			
			holder = new ViewHolder();
			holder.titulo = (TextView)item.findViewById(R.id.lblTituloSpinner);
			holder.subtitulo = (TextView)item.findViewById(R.id.lblSubtituloSpinner);
			holder.year = (TextView)item.findViewById(R.id.lblYearSpinner);
			holder.portada = (ImageView)item.findViewById(R.id.SpinnerImagen);
			
			item.setTag(holder);
						
		} else {
			
			holder = (ViewHolder)item.getTag();
		}
		
		holder.titulo.setText(datos[position].getTitulo());
		holder.subtitulo.setText(datos[position].getTitulo());
		holder.year.setText(datos[position].yearToString());
		holder.portada.setImageResource(datos[position].getFoto());
			
		return(item);
		
	}	
		
	final private static Titular[] datos = new Titular[]{
		new Titular("Grayskul", "Bloody Radio",2007,R.drawable.bloodyradio),
		new Titular("Redman", "Muddy Waters",1996,R.drawable.muddy),
		new Titular("Jakki Da Motamouth", "Psycho Circus",2011,R.drawable.jakki),
		new Titular("Karvoh y Dekoh", "El pacto de las cenizas",2003,R.drawable.cenizas)};
				

	static class ViewHolder{
		
		TextView titulo;
		TextView subtitulo;
		TextView year;
		ImageView portada;
			
	}	
}


