package com.example.seleccion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class pantallaListView extends Activity {
			
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantallalistview);
			
		AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
		final ListView listaOpciones = (ListView)findViewById(R.id.listaOpciones);
		
		listaOpciones.setAdapter(adaptador);
		
		//ADAPTAMOS LA INTERFACE ONCLICKLISTENER PARA PODER CLICKAR EN LA LISTA
		listaOpciones.setOnItemClickListener(new OnItemClickListener() {
			
			public void onItemClick(AdapterView<?> a, View v, int position, long id){
				String artista =((Titular)a.getAdapter().getItem(position)).getTitulo();
				String album = ((Titular)a.getAdapter().getItem(position)).getSubtitulo();
				String year = ((Titular)a.getAdapter().getItem(position)).yearToString();
				int portada = ((Titular)a.getAdapter().getItem(position)).getFoto();
								
			//Creaci�n del intent
			Intent intent = new Intent(pantallaListView.this,pantallaMensajeLista.class);
			
			//Creamos la informaci�n a pasar entre actividades
			Bundle b = new Bundle();
			b.putString("ARTISTA",artista);
			b.putString("ALBUM",album);
			b.putString("AÑO", year);
			b.putInt("PORTADA", portada);
			
			
			//A�adimos la informaci�n al intent
			
			intent.putExtras(b);
			startActivity(intent);		
			
			}			
		});		
	
	}
}

class AdaptadorTitulares extends ArrayAdapter<Titular> {
	
	Activity context;
			
	public AdaptadorTitulares(Activity context) {
		super(context, R.layout.listitemtitular,datos);
		this.context = context;				
	}
	
	public View getView(int position,View convertView,ViewGroup parent){
		
		View item = convertView;
		ViewHolder holder;
		
		if (item == null){
	
			LayoutInflater inflater = context.getLayoutInflater();
			item = inflater.inflate(R.layout.listitemtitular, null);
			
			holder = new ViewHolder();
			holder.titulo = (TextView)item.findViewById(R.id.lblTitulo);
			holder.subtitulo = (TextView)item.findViewById(R.id.lblSubtitulo);
			holder.year = (TextView)item.findViewById(R.id.lblYear);
			holder.portada = (ImageView)item.findViewById(R.id.imagen);	
			
			item.setTag(holder);
						
		} else {
			
			holder = (ViewHolder)item.getTag();
		}
		
		holder.titulo.setText(datos[position].getTitulo());
		holder.subtitulo.setText(datos[position].getSubtitulo());
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



