package com.example.androidsqlite;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class agenda extends Activity {

	EditText editNombre,editTelefono;
	private Button botonGuardar;
	private Button botonLlamar;
	private Button botonEliminarBD;
	private Button botonCerrar;
	
	
	private SQLiteDatabase baseDatos;
	private static final String TAG = "bdagenda";
	private static final String nombreBD = "agenda";
	private static final String tablaContacto = "contacto";
	
	//GUARDAMOS EN UN STRING TODA LA CREACION DE LA TABLA
	
	
	private static final String crearTablaContacto = "CREATE TABLE IF NOT EXISTS " 
							+ " contacto(codigo integer primary key autoincrement,"
							+ " nombre text not null,telefono text not null unique);";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	
		//ASIGNAMOS A CADA OBJETO VISUAL SU ELEMENTO EN EL XML
		editNombre = (EditText)findViewById(R.id.txtNombre);
		editTelefono = (EditText)findViewById(R.id.txtTelefono);
		
		botonGuardar = (Button)findViewById(R.id.insertarContacto);
		botonLlamar = (Button)findViewById(R.id.llamarContacto);
		botonEliminarBD = (Button)findViewById(R.id.eliminarBD);
		botonCerrar = (Button)findViewById(R.id.cerrar);
	
	
		//FUNCIONALIDAD BOTON INSERTAR CONTACTO
		botonGuardar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//ABRIR BASE DE DATOS, SE CREARç SI NO EXISTE
				abrirBD();
				
				//INSERTAR UNA FILA O REGISTRO EN LA TABLA "contacto"
				//SI LA INSERCIîN ES CORRECTO DEVOLVERç TRUE
				
				boolean resultado = insertaFila(editNombre.getText().toString(), editTelefono.getText().toString());
				
				if (resultado){
					Toast.makeText(getApplicationContext(), "Contacto a–adido correctamente", Toast.LENGTH_LONG).show();			
				} else {
					Toast.makeText(getApplicationContext(), "No se ha podido guardar el contacto", Toast.LENGTH_LONG).show();				
				}		
			}
		});
	
		botonLlamar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//MOSTRAR UN MENSAJE DE CONFIRMACION ANTES DE HACER LA LLAMADA
				AlertDialog.Builder alertDialog = new AlertDialog.Builder(agenda.this);
				alertDialog.setMessage("ÀDesea realizar la llamada al contacto?");
				alertDialog.setTitle("Llamar a contacto...");
				alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
				alertDialog.setCancelable(false);
				alertDialog.setPositiveButton("S’", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
						try{
							EditText num = (EditText)findViewById(R.id.txtTelefono);
							String number = "tel:" + num.getText().toString().trim();
							Toast.makeText(getApplicationContext(), "Llamando al " + num.getText().toString().trim(), Toast.LENGTH_LONG).show();
							
							Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(number));
							startActivity(callIntent);
							
						} catch (Exception e){
							
							Toast.makeText(getApplicationContext(), "No se ha podido realizar la llamada", Toast.LENGTH_LONG).show();
						}	
					}
				});
				alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
					
						Toast.makeText(getApplicationContext(), "Llamada cancelada", Toast.LENGTH_LONG).show();		
					}
				}); 	
				
				alertDialog.show();				
			}
		});
		
		botonEliminarBD.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog.Builder alertDialog = new AlertDialog.Builder(agenda.this);
				alertDialog.setMessage("ÀDesea eliminar la base de datos por completo?");
				alertDialog.setTitle("Eliminar agenda...");
				alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
				alertDialog.setCancelable(false);
				alertDialog.setPositiveButton("Si", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
						try{
						
							Toast.makeText(getApplicationContext(), "Eliminando base de datos: " + nombreBD, Toast.LENGTH_LONG).show();
							boolean resultado = deleteDatabase(nombreBD);
						
							if (resultado){
								Toast.makeText(getApplicationContext(), "Base de datos eliminada correctamente", Toast.LENGTH_LONG).show();					
							}else{
								Toast.makeText(getApplicationContext(), "No se pudo eliminar la base de datos", Toast.LENGTH_LONG).show();
							}
						}catch(Exception e) {
						
						Toast.makeText(getApplicationContext(), "No se ha podido eliminar la base de datos", Toast.LENGTH_LONG).show();
						}	
					}
				});
				
				alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
					
						Toast.makeText(getApplicationContext(), "Eliminaci—n de la base de datos cancelada", Toast.LENGTH_LONG).show();			
					}
				});	
				alertDialog.show();				
			}
		});
		
		//FUNCIONALIDAD BOTON CERRAR
		botonCerrar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
	
	}
	
		//METODO PARA ABRIR LA BASE DE DATOS
		@SuppressWarnings("deprecation")
		private void abrirBD(){
			try{
				baseDatos = openOrCreateDatabase(nombreBD, MODE_WORLD_WRITEABLE, null);
				baseDatos.execSQL(crearTablaContacto);
				
			} catch(Exception e){
				Log.i(TAG, "Error al abrir o crear la base de datos" + e);
			}		
		}
	
		//METODO PARA INSERTAR UN REGISTRO EN LA TABLA DE LA BD
		private boolean insertaFila(String nombre, String telefono){
			ContentValues values = new ContentValues();
			values.put("nombre", nombre);
			values.put("telefono", telefono);
			Toast.makeText(getApplicationContext(), "Nombre: " + nombre + ", " 
													+"Telefono: " + telefono, Toast.LENGTH_LONG).show();
			return (baseDatos.insert(tablaContacto, null, values) > 0);
			
		}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
