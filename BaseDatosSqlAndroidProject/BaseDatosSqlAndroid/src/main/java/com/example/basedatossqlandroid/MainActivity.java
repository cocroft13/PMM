package com.example.basedatossqlandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

    EditText textoUsuario;
    EditText textoPassword;
    Button botonIniciar;

    private String user = "fernando";
    private String pass = "macbook";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoUsuario = (EditText)findViewById(R.id.campoUsuario);
        textoPassword = (EditText)findViewById(R.id.campoPassword);
        botonIniciar = (Button)findViewById(R.id.botonValidar);

        







    }

}
