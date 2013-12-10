package com.example.pareafigura;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.renderscript.Sampler.Value;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;

@SuppressLint("DrawAllocation")
public class CanvasCuadrado extends Activity {
		
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new EjemploView(this));
	}

	public class EjemploView extends View {
		public EjemploView(Context contexto){
			super(contexto);
		}
		
		@Override
		protected void onDraw(Canvas canvas){
			
			Bundle bundle = getIntent().getExtras();
			
			int lado = bundle.getInt("LADOCUADRADO");
            int color = bundle.getInt("COLOR");

            int area = lado*lado;
            String textoArea = new String("El área del cuadrado es " + area + " m2");

            DisplayMetrics metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);

            int ancho = metrics.widthPixels;
            int alto = metrics.heightPixels;
            int anchoAlto = ancho*alto;

            if (area > anchoAlto){

                lado = ancho;
            }


			Paint pincel = new Paint();
			pincel.setColor(color);
			pincel.setStrokeWidth(15);
			pincel.setStyle(Style.STROKE);
			canvas.drawRect(30, 30, lado+30, lado+30, pincel);


            Paint pincelArea = new Paint();
            pincelArea.setColor(Color.BLACK);
            pincelArea.setStrokeWidth(25);
            pincelArea.setTextSize(30);
            canvas.drawText(textoArea,200,600,pincelArea);
	
		}		
	}
}
