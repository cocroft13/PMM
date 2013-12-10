package com.example.ejemploanimaciondraw;

import org.ejemplo.aguilar.ImageView;
import org.ejemplo.aguilar.MotionEvent;
import org.ejemplo.aguilar.R;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Obtenemos el recurso creado en animacion.xml
        animacion = (AnimationDrawable) getResources().getDrawable(R.anim.animacion);
        //Creamos una vista que contendr� una imagen
        ImageView imagen = new ImageView(this);
        //Le ponemos color de fondo
        imagen.setBackgroundColor(Color.WHITE);
        //Cargamos en lugar de una imagen, una animaci�n.
        imagen.setImageDrawable(animacion);
        setContentView(imagen);
    }
    
    public boolean onTouchEvent(MotionEvent evento) {
    	//Al realizar una pulsaci�n en pantalla
    	if (evento.getAction() == MotionEvent.ACTION_DOWN) {
    		//Ponemos en marcha la animaci�n
    		animacion.start();
    		return true;
    	}
    	return super.onTouchEvent(evento);
    }
	}

	


