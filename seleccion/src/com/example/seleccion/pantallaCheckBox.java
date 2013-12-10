package com.example.seleccion;

import com.example.seleccion.R;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;
import android.view.View.OnClickListener;;


public class pantallaCheckBox extends Activity {
	
	
	String message="";
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs);	
	
	
		final CheckBox boxDeporte = (CheckBox)findViewById(R.id.checkBox1);
		final CheckBox boxMusica = (CheckBox)findViewById(R.id.checkBox2);
		final CheckBox boxCine = (CheckBox)findViewById(R.id.checkBox3);
		final TextView textoCheckBoxs = (TextView)findViewById(R.id.textoCheckBox);
		final Button botonMostrar = (Button)findViewById(R.id.botonMostrarHobby);
				
		
	botonMostrar.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			message = "";
			if (boxDeporte.isChecked()){
				message +="Deporte";
							
			}
			if (boxCine.isChecked()){
				message +=" Cine";
			
			}
			
			if (boxMusica.isChecked()){			
				message +=" Musica";
				
			}
			
			textoCheckBoxs.setText(message);
			
		}
	});	
	
	
	final TextView lblMensaje = (TextView)findViewById(R.id.lblSeleccion);
	final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
	
	radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {	
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			lblMensaje.setText("Id opci—n seleccionada:" + checkedId);				
		}
	});
	
	
	Resources res = getResources();
	
	TabHost tabs = (TabHost)findViewById(android.R.id.tabhost);
	tabs.setup();
	
	TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
	spec.setContent(R.id.tab1);
	spec.setIndicator("CheckBoxes",res.getDrawable(android.R.drawable.ic_btn_speak_now));
	
	tabs.addTab(spec);
	
	spec = tabs.newTabSpec("mitab2");
	spec.setContent(R.id.tab2);
	spec.setIndicator("RadioButtons",res.getDrawable(android.R.drawable.ic_dialog_map));
	
	tabs.addTab(spec);
	
	tabs.setCurrentTab(0);
	
	}
	
}
