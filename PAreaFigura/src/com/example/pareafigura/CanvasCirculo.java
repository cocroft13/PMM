package com.example.pareafigura;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

public class CanvasCirculo extends Activity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
    }

        class EjemploView extends View {
           public EjemploView(Context contexto){
            super(contexto);
            }

            protected void onDraw(Canvas canvas){

                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);

                int x = metrics.widthPixels /2;
                int y = metrics.heightPixels /2;

                Bundle bundle = getIntent().getExtras();

                float radio = bundle.getFloat("RADIO");
                int color = bundle.getInt("COLOR");

                Paint paint = new Paint();
                paint.setColor(color);
                paint.setStrokeWidth(25);
                paint.setTextSize(30);
                canvas.drawCircle(x,y,radio,paint);

           }

        }
}