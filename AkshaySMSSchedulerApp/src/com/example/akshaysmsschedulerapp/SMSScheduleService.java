package com.example.akshaysmsschedulerapp;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

public class SMSScheduleService extends Service {
	Timer timer;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		timer = new Timer();
		Date d = new Date(2014 - 1900, 7 - 1, 28, 3, 20);
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				SmsManager smsmgr = SmsManager.getDefault();
				smsmgr.sendTextMessage("5556", null, "Happy B'day", null, null);
				stopSelf();
			}
		};

		timer.schedule(task, d);

		Toast.makeText(getBaseContext(), "SMS Scheduled Successfully",
				Toast.LENGTH_LONG).show();

		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		timer.cancel();
		Toast.makeText(getBaseContext(), "SMS Schedule Cancelled",
				Toast.LENGTH_LONG).show();

		super.onDestroy();
	}
}
