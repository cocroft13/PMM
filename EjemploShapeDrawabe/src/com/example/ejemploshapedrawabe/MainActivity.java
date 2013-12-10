package com.example.ejemploshapedrawabe;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Style;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new EjemploView(this));	
	}
	
	@SuppressLint("DrawAllocation")
	public class EjemploView extends View{
		public EjemploView(Context contexto){
			super(contexto);
		}
		
		@Override
		protected void onDraw(Canvas canvas){
			
			Paint pincelBlue = new Paint();
			pincelBlue.setColor(Color.BLUE);
			pincelBlue.setStrokeWidth(15);
			pincelBlue.setStyle(Style.STROKE);
			canvas.drawCircle(200, 200, 80, pincelBlue);
			
			Rect r = new Rect(30,30,200,200);
			
			Paint pincelRed = new Paint();
			pincelRed.setColor(Color.RED);
			pincelRed.setStrokeWidth(15);
			pincelRed.setStyle(Style.STROKE);
			canvas.drawRect(r, pincelRed);
			
				
		}				
	}	
}
