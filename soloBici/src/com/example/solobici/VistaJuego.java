package com.example.solobici;

import java.util.Vector;

import android.R.drawable;
import android.content.Context;
import android.content.SyncResult;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

public class VistaJuego extends View {
	
	// THREAD Y TIEMPO //
	//Hilo encargado de procesar el tiempo
	private HiloJuego hilojuego;
	//Tiempo que debe transcurrir para procesar cambios(ms)
	private static int PERIODO_PROCESO = 50;
	private long ultimoProceso = 0;
	

	//BICI //
	private Grafico bici;
	private int giroBici;				 //Incremento en la direccion de la bici.
	private float aceleracionBici;		 //Aumento de la velocidad en la bici.
	private static final int PASO_GIRO_BICI = 5;
	private static final float PASO_ACELERACION_BICI = 0.5f;
	
	
	//COCHES //
	private Vector <Grafico> Coches;		//VECTOR DE LOS COCHES
	private int numCoches = 5;				//NUMERO INICIAL DE COCHES
	private int numMotos = 3;				//FRAGMENTOS/MOTOS EN QUE SE DIVIDIRA UN COCHE
	
	public VistaJuego(Context contexto,AttributeSet atributos) {
		super(contexto,atributos);
		Drawable graficoBici,graficoCoche,graficoRueda;
		//Obtenemos la imagen/recurso del coche.
		graficoCoche = contexto.getResources().getDrawable(R.drawable.coche);
		graficoBici = contexto.getResources().getDrawable(R.drawable.bici);
		
		//Creamos un vector para contener todos los coches que ir‡n por la pantalla y lo rellenamos con gr‡ficos de coches
		//con valores aleatorios para su velocidad,direccion y rotacion.
		
		Coches = new Vector<Grafico>();
		
		for (int i=0; i< numCoches; i++){
			Grafico coche = new Grafico(this, graficoCoche);
			coche.setIncX(Math.random() *4 -2);
			coche.setIncY(Math.random() *4 -2);
			coche.setAngulo((int)(Math.random() * 360));
			coche.setRotacion((int)(Math.random() + 8 -4));
			Coches.add(coche);		
		}
		
	
		bici = new Grafico(this,graficoBici);
		//bici.setPosX(350);
		//bici.setPosY(350);
		
	
	}
		//Al comenzar y dibujar por primera vez la pantalla del juego
		@Override
		protected void onSizeChanged(int w, int h, int oldw, int oldh) {
			super.onSizeChanged(w, h, oldw, oldh);
			
			//Dibujamos los coches en posiciones aleatorias
			for (Grafico coche:Coches){
				do {
				coche.setPosX(Math.random()*(w-coche.getAncho()));
				coche.setPosY(Math.random()*(h-coche.getAlto()));
				} while (coche.distancia(bici) < (w+h)/5);
			}
			
			
			bici.setPosX(w-bici.getAncho());
			bici.setPosY(h-bici.getAlto());
			
			
			//HILO QUE CONTROLA EL JUEGO
			hilojuego = new HiloJuego();
			hilojuego.start();
		
		}
		
		protected synchronized void actualizaMovimiento(){
			long ahora = System.currentTimeMillis();
			//No hacemos nada si el periodo de proceso no se ha cumplido.
			
			if (ultimoProceso + PERIODO_PROCESO > ahora){
				return;
			}
			
			//Para una ejecucion en tiempo real calculamos retardo
			double retardo = (ahora - ultimoProceso) / PERIODO_PROCESO;
			//Actualizamos la posicion de la bici
			bici.setAngulo((int)(bici.getAngulo() + giroBici * retardo));
			double nIncX = bici.getIncX() + aceleracionBici * Math.cos(Math.toRadians(bici.getAngulo())) * retardo;
			double nIncY = bici.getIncY() + aceleracionBici * Math.sin(Math.toRadians(bici.getAngulo())) * retardo;
			
			if (Grafico.distanciaE(0, 0, nIncX, nIncY) <= Grafico.getMaxVelocidad()){
				bici.setIncX(nIncX);
				bici.setIncY(nIncY);		
			}
			//bici.incrementaPos();
			
			//Movemos los coches
			for (Grafico coche:Coches){
				coche.incrementaPos();				
			}
			ultimoProceso = ahora;		
		}
			
		
		@Override
		protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			//Dibujamos cada uno de los coches
			
			for (Grafico coche:Coches){
				coche.dibujaGrafico(canvas);
			}
			
			bici.dibujaGrafico(canvas);
		}


		private class HiloJuego extends Thread{
			@Override
			public void run(){
				while(true){
					actualizaMovimiento();
				}
			}			
		}
}

