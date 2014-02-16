package com.ejemplobasedatos;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class EjemploBaseDatos extends Activity {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //Abrimos la base de datos en modo escritura
        ClienteSqliteHelper cliDB = new ClienteSqliteHelper(this,"DBClientes",null,1);

        //Obtenemos la referencia a la base de datos
        SQLiteDatabase db = cliDB.getWritableDatabase();

        //En caso de abrir de forma correcta la base de datos

        if (db != null) {
            //Introducimos 3 clientes de ejemplo

            for (int cont = 1; cont <= 3; cont++){

                int codigo = cont;
                String nombre = "Cliente" + cont;
                String telefono = cont + "XXXXXXX";

                //Introducimos los datos en la tabla Clientes
                db.execSQL("INSERT INTO Clientes (codigo,nombre,telefono) " +
                            "VALUES (" + codigo + "', " + nombre + "', '" + telefono + "')");

            }

            //Cerramos la base de datos
            db.close();
        }
    }
}
