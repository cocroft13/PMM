package com.example.androidsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuariosSQLiteHelper extends SQLiteOpenHelper{

	//STRING QUE ALMACENA UNA SENTENCIA SQL PARA CREAR TABLA
	String sqlCreate = "CREATE TABLE Usuarios(codigo INTEGER, nombre TEXT)";
	
	
	public UsuariosSQLiteHelper(Context contexto, String nombre,
			CursorFactory factory, int version) {
		super(contexto, nombre, factory, version);		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//SE EJECUTA LA SENTENCIA SQL DE CREACION DE LA TABLA
		db.execSQL(sqlCreate);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		//SE ELIMINA LA VERSION ANTERIOR DE LA TABLA
		db.execSQL("DROP TABLE IF EXISTS Usuarios");
		
		//SE CREA LA NUEVA VERSION
		db.execSQL(sqlCreate);
		
		
		
		
		
		
	}

}
