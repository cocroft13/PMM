package com.androidcentroescolar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper{

	public DbHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
			
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL("CREATE TABLE centros (cod_centro INTEGER(5) PRIMARY KEY, tipo_centro VARCHAR(1), "
				+ "nombre_centro VARCHAR(20), direccion VARCHAR(30), telefono VARCHAR(9), num_plazas INTEGER(6));");
		
		db.execSQL("CREATE TABLE personal ("+
				 "cod_centro   SMALLINT NOT NULL,"+
				 "dni          INT UNSIGNED NOT NULL,"+
				 "apellidos    VARCHAR(30),"+
				 "funcion      VARCHAR(15),"+
				 "salario      FLOAT(7,2),"+
				 "PRIMARY KEY (dni),"+
				 "FOREIGN KEY (cod_centro) REFERENCES centros (cod_centro));");	
	
	
		db.execSQL("CREATE TABLE profesores ("+
				 "cod_centro   SMALLINT NOT NULL,"+
				 "dni          INT UNSIGNED NOT NULL,"+
				 "apellidos    VARCHAR(30),"+
				 "especialidad VARCHAR(16),"+
				 "PRIMARY KEY (dni),"+
				 "FOREIGN KEY (dni) REFERENCES personal(dni),FOREIGN KEY (cod_centro) REFERENCES centros (cod_centro));");
		
		
	}
	
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public void insertarCentro(SQLiteDatabase db,int cod_centro,String tipo_centro,String nombre_centro,String direccion,
								String telefono,int num_plazas) {	
		
		db.execSQL("INSERT INTO centros VALUES('"+cod_centro+"','"+tipo_centro+"','"+nombre_centro+"','"+direccion+"',"
				+ "'"+telefono+"','"+num_plazas+"');");
		db.close();
			
	}
	
	public void eliminarCentro(SQLiteDatabase db,int cod_centro){
				
		
		db.execSQL("DELETE FROM centros WHERE cod_centro = " + cod_centro);	
		db.close();
				
	}

}
