package com.ejemplobasedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class ClienteSqliteHelper extends SQLiteOpenHelper {


    String cadSql = "CREATE TABLE Clientes (codigo INTEGER, nombre TEXT, telefono TEXT";

    public ClienteSqliteHelper() {
        super(null, null, null, 1);
    }

    public ClienteSqliteHelper(Context context, String nombre, SQLiteDatabase.CursorFactory almacen, int version) {
        super(context, nombre, almacen, version);
    }

    public void onCreate(SQLiteDatabase db) {

        db.execSQL(cadSql);
    }


    public void onUpgrade(SQLiteDatabase bd, int versionAnterior, int versionNueva) {

        bd.execSQL("DROP TABLE IF EXISTS Clientes");
        bd.execSQL(cadSql);
    }

}
