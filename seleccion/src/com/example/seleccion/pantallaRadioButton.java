package com.example.seleccion;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class pantallaRadioButton extends Activity{

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantallaradiobutton);
		
		final TextView lblMensaje = (TextView)findViewById(R.id.lblSeleccion);
		final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
		
		radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {	
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				lblMensaje.setText("Id opci—n seleccionada:" + checkedId);				
			}
		});		
	}	
}
