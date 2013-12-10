package org.ejemplo.aguilar;

import java.util.List;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class EjemploSensor extends Activity implements SensorEventListener {
    private TextView salida;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Campo de texto para mostrar la salida
        salida = (TextView)findViewById(R.id.salida);
        
        //Objeto SensorManager que nos permitir� ver la lista de sensores del dispositivo
        SensorManager miSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        List<Sensor> listaSensores = miSensorManager.getSensorList(Sensor.TYPE_ALL);
        
        //Vamos mostrando los sensores uno a uno
        for(Sensor sensor:listaSensores) {
        	mostrar(sensor.getName());
        }
        
        //Registramos los sensores para tener acceso a ellos.
        //Debemos registrar cada tipo de sensor por separado para poder obtener informaci�n de �l.
        //En primer lugar registramos el sensor de orientaci�n.
        listaSensores = miSensorManager.getSensorList(Sensor.TYPE_ORIENTATION);
        Sensor sensorOrientacion = listaSensores.get(0);
        miSensorManager.registerListener(this, sensorOrientacion, SensorManager.SENSOR_DELAY_UI);
        
        //Despu�s registramos el aceler�metro.
        listaSensores = miSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        Sensor sensorAcelerometro = listaSensores.get(0);
        miSensorManager.registerListener(this, sensorAcelerometro, SensorManager.SENSOR_DELAY_UI);
        
        //Despu�s registramos la br�jula
        listaSensores = miSensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
        Sensor sensorBrujula = listaSensores.get(0);
        miSensorManager.registerListener(this, sensorBrujula, SensorManager.SENSOR_DELAY_UI);
        
        //Por �ltimo registramos el sensor de temperatura
        listaSensores = miSensorManager.getSensorList(Sensor.TYPE_TEMPERATURE);
        Sensor sensorTemperatura = listaSensores.get(0);
        miSensorManager.registerListener(this, sensorTemperatura, SensorManager.SENSOR_DELAY_UI);
        
        
    }
    
    private void mostrar(String cadena) {
    	salida.append(cadena + "\n");
    }

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent evento) {
		//Cada sensor puede provocar que un hilo pase por aqui
		//as� que sincronizamos el acceso.
		synchronized (this) {
			switch (evento.sensor.getType()) {
			case Sensor.TYPE_ORIENTATION:
				for (int i=0 ; i<3 ; i++) {
					mostrar("Orientacion " + i + ": " + evento.values[i]);
				}
				break;
			case Sensor.TYPE_ACCELEROMETER:
				for (int i=0 ; i<3 ; i++) {
					mostrar("Acelerometro " + i + ": " + evento.values[i]);
				}
				break;
			case Sensor.TYPE_MAGNETIC_FIELD:
				for (int i=0 ; i<3 ; i++) {
					mostrar("Brujula " + i + ": " + evento.values[i]);
				}
				break;
			default:
				for (int i=0 ; i<evento.values.length ; i++) {
					mostrar("Temperatura " + i + ": " + evento.values[i]);
				}
				break;
			}
		}		
	}
}

