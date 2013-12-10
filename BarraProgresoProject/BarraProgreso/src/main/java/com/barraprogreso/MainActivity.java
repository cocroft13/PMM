package com.barraprogreso;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {

    ProgressBar pbarProgreso;
    Button btnSinHilos;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pbarProgreso = (ProgressBar)findViewById(R.id.barraProgreso);
        btnSinHilos = (Button)findViewById(R.id.btnSinHilos);

        btnSinHilos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MiTareaAsincrona miTarea = new MiTareaAsincrona();
                miTarea.execute();


            }
        });
    }


    private class MiTareaAsincrona extends AsyncTask <Void, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {

            for (int i=0; i<=10;i++){
                tareaLarga();

                onProgressUpdate(i * 10);
                if (isCancelled()){
                    break;
                }
            }

            return true;
        }

        protected void onProgressUpdate(Integer... values){
                int progreso = values[0].intValue();
                pbarProgreso.setProgress(progreso);

        }

        protected void onPreExecute(){
            pbarProgreso.setMax(100);
            pbarProgreso.setProgress(0);

        }


        protected void onPostExecute(Boolean result){
            if(result)
                Toast.makeText(MainActivity.this,"Tarea finalizada",Toast.LENGTH_SHORT).show();
        }


        protected void onCancelled (){
            Toast.makeText(MainActivity.this,"Tarea cancelada",Toast.LENGTH_SHORT).show();

        }

    }

    private void tareaLarga()
    {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {}
    }
}
