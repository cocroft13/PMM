package com.androidcentroescolar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class PantallaCentros extends Activity {
	
	int codigoCentroEliminar;
	
	static int codigoCentro;
	static String tipoCentro;
	static String nombreCentro;
	static String direccionCentro;
	static String telefonoCentro;
	static int numPlazasCentro;
	
	int numColumnas;
	int cont = 0;
	Centros[] datos;	
		
	Button btnNuevoCentro,btnEliminarCentro;
	
	
	public void crearAlertDialog(final DbHelper dbHelper,final SQLiteDatabase db){
		
						
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		alertDialogBuilder.setMessage("¿Desea eliminar el centro seleccionado?");
		alertDialogBuilder.setTitle("- Eliminar Centro -");
		alertDialogBuilder.setIcon(android.R.drawable.ic_dialog_alert);
		alertDialogBuilder.setCancelable(false);
				
		alertDialogBuilder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
								
				dbHelper.eliminarCentro(db, codigoCentroEliminar);
				
			}
		});
		
		alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
										
				dialog.cancel();
				
			}
		});
		
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
		
	}
	
		
	public void onCreate(Bundle savedInstanceState) {	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantalla_centros);	
		
		String[] arrayColumnas = new String[]{"cod_centro","tipo_centro","nombre_centro","direccion","telefono","num_plazas"};
		
		btnNuevoCentro = (Button)findViewById(R.id.btnAgregarCentro);
		btnEliminarCentro = (Button)findViewById(R.id.btnEliminarCentro);
				
		final DbHelper dbHelper = new DbHelper(getBaseContext(), "centros", null, 1);
		final SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor c = db.query("centros", arrayColumnas, null, null, null, null, null);	
		
		numColumnas = c.getCount();
		datos = new Centros[numColumnas];
		
		if (c.moveToNext()){
			
			do {
			codigoCentro = c.getInt(0);
			tipoCentro = c.getString(1);
			nombreCentro = c.getString(2);
			direccionCentro = c.getString(3);
			telefonoCentro = c.getString(4);
			numPlazasCentro = c.getInt(5);
			
			datos[cont] = new Centros(codigoCentro, tipoCentro, nombreCentro, direccionCentro, telefonoCentro, numPlazasCentro);
			
			cont++;
						
			} while(c.moveToNext());			
		}
							
		AdaptadorCentros adaptador = new AdaptadorCentros(this);
		final Spinner spinner = (Spinner)findViewById(R.id.spinnerOpciones);
	
		spinner.setAdapter(adaptador);
		
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> a, View v, int position, long id) {
				
				codigoCentroEliminar = ((Centros)a.getAdapter().getItem(position)).getCod_centro();
																			
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				
				
			}				
			
		});
					
		btnNuevoCentro.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(PantallaCentros.this,PantallaNuevoCentro.class);
				startActivity(i);
				finish();
			}
		});	
				
		btnEliminarCentro.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				crearAlertDialog(dbHelper, db);
				
			}
		});
			
	}

	class AdaptadorCentros extends ArrayAdapter<Centros>{
		
			
		Activity context;
	
		public AdaptadorCentros(Activity context) {
			super(context, R.layout.desglosespinner,datos);
			this.context = context;
		
		}
		
		public View getDropDownView(int position,View convertView,ViewGroup Parent){
			return getView(position, convertView, Parent);		
		}
			
		public View getView(int position,View convertView,ViewGroup parent){
					
			View item = convertView;
			ViewHolder holder;
					
			if(item == null){
				
				LayoutInflater inflater = context.getLayoutInflater();
				item = inflater.inflate(R.layout.desglosespinner, null);
				
				holder = new ViewHolder();
				
				holder.codCentro = (TextView)item.findViewById(R.id.lblCodCentro);
				holder.tipoCentro = (TextView)item.findViewById(R.id.lblTipoCentro);
				holder.nombreCentro = (TextView)item.findViewById(R.id.lblNombreCentro);
				holder.direccion = (TextView)item.findViewById(R.id.lblDireccion);
				holder.telefono = (TextView)item.findViewById(R.id.lblTelefono);
				holder.numPlazas = (TextView)item.findViewById(R.id.lblNumPlazas);
				
				item.setTag(holder);
						
			} else {
				
				holder = (ViewHolder)item.getTag();		
			}
			
			holder.codCentro.setText(String.valueOf(datos[position].getCod_centro()));
			holder.tipoCentro.setText(datos[position].getTipo_centro());
			holder.nombreCentro.setText(datos[position].getNombre());
			holder.direccion.setText(datos[position].getDireccion());
			holder.telefono.setText(datos[position].getTelefono());
			holder.numPlazas.setText(String.valueOf(datos[position].getNum_plazas()));
					
			return(item);
		}		
		  
		 class ViewHolder {
			
			TextView codCentro,tipoCentro,nombreCentro,direccion,telefono,numPlazas;
					
		}			
	}
}
