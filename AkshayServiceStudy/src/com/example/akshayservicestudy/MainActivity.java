package com.example.akshayservicestudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void startKaroService(View v) {
		Intent i = new Intent(getBaseContext(), MyService.class);
		startService(i);
	}

	public void stopKaroService(View v) {
		Intent i = new Intent(getBaseContext(), MyService.class);
		stopService(i);
	}

}
