package com.example.akshaysmsschedulerapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void scheduleSMS(View v) {
		Intent i = new Intent(getBaseContext(), SMSScheduleService.class);
		startService(i);
	}

	public void cancelSchedule(View v) {
		Intent i = new Intent(getBaseContext(), SMSScheduleService.class);
		stopService(i);
	}

}
