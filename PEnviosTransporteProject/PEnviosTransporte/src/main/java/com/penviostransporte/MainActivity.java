package com.penviostransporte;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    Spinner spinner;
    RadioGroup radioGroup;
    RadioButton radioButtonNormal, radioButtonUrgente;
    EditText textoPeso;
    Button botonConsultar;
    CheckBox checkBoxRegalo;
    CheckBox checkBoxTarjeta;

    String peso;
    int precioZona;
    int pesoFinal;
    double precioEnvio;

    String decoracion;
    String tarifa;
    String zona;

    int costeFinal;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoPeso = (EditText)findViewById(R.id.textoPeso);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroupTarifa);
        radioButtonNormal = (RadioButton)findViewById(R.id.radioButtonNormal);
        radioButtonUrgente = (RadioButton)findViewById(R.id.radioButtonUrgente);
        checkBoxRegalo = (CheckBox)findViewById(R.id.checkBoxRegalo);
        checkBoxTarjeta = (CheckBox)findViewById(R.id.checkBoxTarjeta);
        botonConsultar = (Button)findViewById(R.id.botonConsulta);


        AdaptadorTransporte adaptador = new AdaptadorTransporte(this);
        spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(adaptador);


        //LISTENER PARA EL SPINNER
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> a, View view, int position, long id) {

                if (a.getSelectedItemPosition() == 0){

                    precioZona = 30;
                    zona = "Asia y Oceania";
                }

                if (a.getSelectedItemPosition() == 1){

                    precioZona = 20;
                    zona = "America y Africa";
                }

                if (a.getSelectedItemPosition() == 2){

                    precioZona = 10;
                    zona = "Europa";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //LISTENER PARA EL RADIOGROUP
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (radioButtonNormal.isChecked()){
                    precioEnvio = 1;
                    tarifa = "";
                    tarifa = "Normal";
                }

                if (radioButtonUrgente.isChecked()){
                    precioEnvio = 0.3;
                    tarifa = "";
                    tarifa = "Urgente";
                }
            }
        });


        //LISTENER PARA EL BOTON
        botonConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                peso = String.valueOf(textoPeso.getText());
                pesoFinal = Integer.parseInt(peso);


                //CONTROL DEL PESO DEL PAQUETE
                if (pesoFinal <= 5){
                    pesoFinal *= 1;
                }

                if (pesoFinal >5 && pesoFinal <= 10){
                    pesoFinal *= 1.5;
                }

                if (pesoFinal > 10){
                    pesoFinal *= 2;
                }

                //CONTROL DE LA DECORACION

                if (!checkBoxRegalo.isChecked() && !checkBoxTarjeta.isChecked()) {
                    decoracion = "";
                    decoracion = "Sin decoracion";
                }

                if (checkBoxRegalo.isChecked()){
                    decoracion = "";
                    decoracion = "Caja regalo";
                }

                if (checkBoxTarjeta.isChecked()){
                    decoracion = "";
                    decoracion = "Tarjeta dedicada";
                }

                if (checkBoxRegalo.isChecked() && checkBoxTarjeta.isChecked()){
                    decoracion = "";
                    decoracion = "Caja regalo y tarjeta dedicada";
                }


               int coste = precioZona + pesoFinal;
               costeFinal = (int) (coste + coste * precioEnvio);

               Bundle bundle = new Bundle();
               bundle.putString("ZONA",zona);
               bundle.putString("TARIFA",tarifa);
               bundle.putString("PESO", peso);
               bundle.putString("DECORACION",decoracion);
               bundle.putInt("COSTEFINAL", costeFinal);

               Intent intent = new Intent(MainActivity.this,ResultadoEnvio.class);
               intent.putExtras(bundle);
               startActivity(intent);

            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                Toast.makeText(this,"Acerca De..",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.MnuOpc2:

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

}

    class AdaptadorTransporte extends ArrayAdapter <Zona>{

        Activity context;

        public AdaptadorTransporte(Activity context) {
            super(context, R.layout.desglosespinner,datos);
            this.context = context;
        }

        @Override
        public View getDropDownView(int position,View convertView,ViewGroup Parent){
            return getView(position, convertView, Parent);
        }

        public View getView(int position,View convertView,ViewGroup parent){

            View item = convertView;
            ViewHolder holder;

            if(item == null){

                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.desglosespinner, null);

                holder = new ViewHolder();
                holder.zona = (TextView)item.findViewById(R.id.zonaSpinner);
                holder.continente = (TextView)item.findViewById(R.id.continenteSpinner);
                holder.precio = (TextView)item.findViewById(R.id.precioSpinner);

                item.setTag(holder);

            } else {

                holder = (ViewHolder)item.getTag();
            }

            holder.zona.setText(datos[position].getZona());
            holder.continente.setText(datos[position].getContinente());
            holder.precio.setText(datos[position].precioToString());

            return item;

        }

    }

    final private static Zona[] datos = new Zona[]{
            new Zona("A","Asia y Oceania",30),
            new Zona("B","America y Africa",20),
            new Zona("C","Europa",10)
    };

    static class ViewHolder{

        TextView zona;
        TextView continente;
        TextView precio;
    }
}

