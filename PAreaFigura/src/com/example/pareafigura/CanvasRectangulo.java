package com.example.pareafigura;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

@SuppressLint("DrawAllocation")
public class CanvasRectangulo extends Activity {
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(new EjemploView(this));
		
	}
	
	public class EjemploView extends View {
		public EjemploView(Context contexto){
			super(contexto);
		}
	
		protected void onDraw(Canvas canvas){
			
			Bundle bundle = getIntent().getExtras();
			
			int lado1 = bundle.getInt("LADO1");
			int lado2 = bundle.getInt("LADO2");
			int color = bundle.getInt("COLOR");

            int area = lado1*lado2;

            String textoArea = new String("El área del rectángulo es " + area + " m2");

            DisplayMetrics metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);

            int ancho = metrics.widthPixels;
            int alto = metrics.heightPixels;
            int areaPantalla = ancho*alto;

            if (areaPantalla < area){

                lado1 = ancho;
                lado2 = alto;

            }


            /* PINCEL PARA DIBUJAR EL RECTÁNGULO */
			Paint pincel = new Paint();
			pincel.setColor(color);
			pincel.setStrokeWidth(15);
			pincel.setStyle(Style.STROKE);
			canvas.drawRect(300, 350, 300+lado1, 350+lado2, pincel);


            /* PINCEL PARA ESCRIBIR EL TEXTO DEL AREA DEL RECTÁNGULO */
            Paint pincelArea = new Paint();
            pincelArea.setColor(Color.BLACK);
            pincelArea.setStrokeWidth(25);
            pincelArea.setTextSize(30);
            canvas.drawText(textoArea,200,600,pincelArea);

		}
	}
}