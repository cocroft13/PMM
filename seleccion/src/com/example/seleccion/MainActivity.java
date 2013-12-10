package com.example.seleccion;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
				
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
	    getMenuInflater().inflate(R.menu.main, menu);
	    return true;
	}
	
	
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()) {
		case R.id.MnuOpc1:
			Intent intent = new Intent(MainActivity.this,pantallaCheckBox.class);
			startActivity(intent);
			return true;

		case R.id.MnuOpc2:
			Intent intent2 = new Intent(MainActivity.this,pantallaSpinner.class);
			startActivity(intent2);
			return true;
			
		case R.id.MnuOpc3:
			Intent intent3 = new Intent(MainActivity.this,pantallaListView.class);
			startActivity(intent3);
			return true;
		
		case R.id.MnuOpc4:
			Intent intent4 = new Intent(this,AcercaDe.class);
			startActivity(intent4);			
			return true;
			
		default:
			return super.onOptionsItemSelected(item);
		}		
	}
}
