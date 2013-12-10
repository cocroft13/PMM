package com.example.multipleseleccion;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
		
	final Button buttonCheckBox = (Button)findViewById(R.id.goChkButton);
	final Button buttonRadio = (Button)findViewById(R.id.goRadioButton);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
	buttonRadio.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
		
			Intent intent= new Intent(MainActivity.this,pantallaRadio.class);
			startActivity(intent);					
		}
	});	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
