package com.example.pareafigura;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
	
		AdaptadorFiguras adaptador = new AdaptadorFiguras(this);
		final ListView listView = (ListView)findViewById(R.id.lista);
		
		listView.setAdapter(adaptador);
		
		//ADAPTAMOS ONITEMCLICKLISTENER PARA PODER CLICKAR EN LA LISTA
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> a, View view, int position,long id) {
				String numeracion = ((Figura)a.getAdapter().getItem(position)).getNumero();
				String nombre = ((Figura)a.getAdapter().getItem(position)).getNombre();
				int imagen = ((Figura)a.getAdapter().getItem(position)).getImagen();
							
				if (position == 0){
				
					Intent intent = new Intent(MainActivity.this,PantallaCuadrado.class);
					startActivity(intent);
				}
								
				if (position == 1){
					
					Intent intentRect = new Intent(MainActivity.this,PantallaRectangulo.class);
					startActivity(intentRect);
				}

                if (position == 2){

                    Intent intentCirc = new Intent(MainActivity.this,PantallaCirculo.class);
                    startActivity(intentCirc);

                }
			}
		});		
	}	
}
	class AdaptadorFiguras extends ArrayAdapter<Figura>{
	
		Activity context;
		
		public AdaptadorFiguras (Activity context){
			super(context,R.layout.listitemfigura,datos);
			this.context = context;
			
		}
			 		
		public View getView (int position,View convertView,ViewGroup Parent){
			
			View item = convertView;
			ViewHolder holder;
			
			if (item == null){
				
				LayoutInflater inflater = context.getLayoutInflater();
				item = inflater.inflate(R.layout.listitemfigura,null);
				
				holder = new ViewHolder();
				holder.numeracion = (TextView)item.findViewById(R.id.numero);
				holder.nombre = (TextView)item.findViewById(R.id.nombre);
				holder.imagen = (ImageView)item.findViewById(R.id.imagen);
				
				item.setTag(holder);
								
			} else {
				
				holder = (ViewHolder)item.getTag();
		
			}
			
			holder.numeracion.setText(datos[position].getNumero());
			holder.nombre.setText(datos[position].getNombre());
			holder.imagen.setImageResource(datos[position].getImagen());
			
			return (item);
			
		}
				
		final private static Figura[] datos = new Figura[]{
			new Figura("1.-", "Cuadrado",R.drawable.cuadrado),
			new Figura("2.-", "Rectángulo",R.drawable.rectangulo),
			new Figura("3.-", "Círculo",R.drawable.circulo)
		
		};
		
		class ViewHolder {
			
			TextView numeracion;
			TextView nombre;
			ImageView imagen;
						
		}	
	}